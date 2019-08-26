package com.mybatis.schedule;

import com.mybatis.utils.GzipUtils;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.io.IOException;

/**
 * @author: Ant
 * @Date: 2018/11/21 16:44
 * @Description:
 */
@Component
public class ResultReciver {
    private static final Logger logger = LoggerFactory.getLogger(ResultReciver.class);

    //@RabbitListener(queues = "${spring.rabbitmq.resultQueue}")//监听结果消息队列
    @RabbitHandler
    public void process(Message message, Channel channel) {
        String unzip = GzipUtils.unzip(message.getBody());
        System.out.println(unzip);
//        Student spiderResult = JSONObject.parseObject(unzip, Student.class);//将JSON数据转化为对象实体
//        logger.debug("--receive msg: [{}] [{}]",spiderResult.getStatus(),spiderResult.getSpiderTask().getId());
//        logger.info("--receive msg: [{}] [{}]",spiderResult.getStatus(),spiderResult.getSpiderTask().getId());
//        try {
//            reslutProcess.process(spiderResult);
//        } catch (Exception e) {
//            logger.error("数据库操作出错 [{}]",spiderResult.getSpiderTask().getId());
//        }
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            logger.error("数据处理完成后，向MQ发送ACK消息出错！ [{}]");
        }
    }
}
