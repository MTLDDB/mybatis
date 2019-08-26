package com.mybatis.schedule;

import com.alibaba.fastjson.JSONObject;
import com.mybatis.model.Student;
import com.mybatis.utils.GzipUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
@Component
public class sendTask {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    protected RabbitTemplate rabbitTemplate;
    @Value("${spring.rabbitmq.taskQueue}")
    private String task_queue_name;
    @Value("${spider.tasksender.sendCount}")
    private int sendCount;//每次发送任务条数
    public void sendTaskList(List<Student> spiderTaskList) {
        for (Student spiderTask : spiderTaskList) {
            rabbitTemplate.convertAndSend(task_queue_name, GzipUtils.zip(JSONObject.toJSONString(spiderTask)));
            System.out.println("执行定时任务: " + LocalDateTime.now().toLocalTime());
        }
        for (Student spiderTask : spiderTaskList) {
                jdbcTemplate.update("update student set status=1 where student_id='" + spiderTask.getStudent_id() + "'");
            }
        }
    }
