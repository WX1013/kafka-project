package org.wx.kafka.producer.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wx.kafka.common.constants.TopicConstants;
import org.wx.kafka.common.model.KafkaMsg;

import javax.annotation.Resource;

/**
 * @author WangXin
 * @date 2022/5/13 16:47
 */
@RequestMapping("/api/producer")
@RestController
public class ProducerController {

    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    /**
     * 测试接口请求
     * @return String
     */
    @GetMapping("/test")
    public String test(){
        System.out.println("Hello world");
        return "OK";
    }

    /**
     * 发送kafka消息
     * @param param param
     * @return String
     */
    @GetMapping("/send")
    public String sendKafka(String param){
        try {
            ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(
                    TopicConstants.TEST_TOPIC,
                    new KafkaMsg(999L, param == null ? "Test Key" : param)
            );
            future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
                @Override
                public void onFailure(Throwable ex) {
                    System.err.println("生产者发送消息失败：" + ex.getMessage());
                }

                @Override
                public void onSuccess(SendResult<String, Object> result) {
                    System.out.println("生产者发送消息成功：" + result.toString());
                }
            });
        }catch (Exception e){
            e.printStackTrace();
            return "FAIL";
        }
        return "OK";
    }

}
