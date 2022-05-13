package org.wx.kafka.common.serialization;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.common.serialization.Deserializer;
import org.wx.kafka.common.model.KafkaMsg;

/**
 * @author WangXin
 * @description 反序列化
 * @date 2022/5/13 17:41
 */
public class KafkaMsgDeserializer implements Deserializer<KafkaMsg> {

    /**
     * 反序列化
     * @param topic topic
     * @param bytes bytes[]
     * @return KafkaMsg
     */
    @Override
    public KafkaMsg deserialize(String topic, byte[] bytes) {
        return JSON.parseObject(bytes, KafkaMsg.class);
    }
}
