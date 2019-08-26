package com.mybatis.schedule;


import com.alibaba.fastjson.JSONObject;
import com.mybatis.model.Student;
import com.mybatis.service.DBService;
import com.mybatis.service.MQService;
import com.mybatis.utils.GzipUtils;
import com.mybatis.utils.MQUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Component
//@EnableScheduling
public class scheduleSend  implements SchedulingConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(scheduleSend.class);
    private int ignoreNum = 0;      // 连续send ignore 3次以后，不再记录ignore日志直到下一次任务发送，
    private int lastMsgCount = 0;
    @Autowired
    private MQUtils mqUtils;
    @Autowired
    private MQService mqService;
    @Autowired
    protected RabbitTemplate rabbitTemplate;
    @Autowired
    private sendTask sendtask;
    @Value("${spring.rabbitmq.taskQueue}")
    private String task_queue_name;
    @Value("${spider.tasksender.sendCount}")
    private int sendCount;//每次发送任务条数
    @Value("${spider.tasksender.mqMaxMessage}")
    private int mqMaxMessage;//MQ队列中消息总数小于多少才会发送
    /**
     * 执行定时任务.
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(
                // 1.添加任务内容(Runnable)
                () -> {
                    // 1.1具体任务
                    if (checkMqQueues()) {
                        // 从数据库取任务
                        List<Student> spiderTasks = getTaskListFromDB();
                        // 发送任务
                        if (spiderTasks.size() == 0){
                            if (ignoreNum < 3){
                                logger.info("Get 0 Task from DataBase, send ignore!");
                                ignoreNum++;
                            }
                        }else {
                            sendtask.sendTaskList(spiderTasks);
                            logger.info("send Task Success, send count: {}", spiderTasks.size());
                            ignoreNum = 0;
                        } }

                },
                // 2.设置执行周期(Trigger)
                triggerContext -> {
                    // 任务触发，可修改任务的执行周期
                    CronTrigger trigger = new CronTrigger("0/" + 5 + " * * * * ?");//每隔interval触发一次
                    Date nextExecutionTime = trigger.nextExecutionTime(triggerContext);
                    return nextExecutionTime;
                });
    }
    private boolean checkMqQueues() {
        int messageCount = 0;
        try {
            messageCount = mqUtils.getMessageCount(task_queue_name);

        } catch (IOException e) {
            logger.error("与MQ通信失败！",e);
            return false;
        }
        if (messageCount >= mqMaxMessage) {
            if (ignoreNum < 3){
                logger.info("send Task ignore! current size of {} is: {}", task_queue_name, messageCount);
                if (messageCount == lastMsgCount) ignoreNum++;else ignoreNum=0;
            }
            lastMsgCount = messageCount;
            return false;
        }
        lastMsgCount = messageCount;
        return true;
    }

    private List<Student> getTaskListFromDB() {
        return mqService.getTaskList(sendCount);
    }

}