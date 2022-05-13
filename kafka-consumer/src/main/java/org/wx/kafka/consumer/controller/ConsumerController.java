package org.wx.kafka.consumer.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.wx.kafka.common.constants.TopicConstants;
import org.wx.kafka.common.model.KafkaMsg;

/**
 * @author WangXin
 * @date 2022/5/13 17:51
 */
@Component
public class ConsumerController {

    /**
     * 消费者监听 TEST_TOPIC 消息
     *
     * @param record record
     */
    @KafkaListener(topics = TopicConstants.TEST_TOPIC)
    public void onMessage(ConsumerRecord<String, KafkaMsg> record) {
        System.out.println("消费主题：" + record.topic());
        System.out.println("数据分区：" + record.partition());
        System.out.println("消息内容：" + record.value());
    }

}
