package org.wx.kafka.common.serialization;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.common.serialization.Serializer;
import org.wx.kafka.common.model.KafkaMsg;

/**
 * @author WangXin
 * @description 序列化
 * @date 2022/5/13 21:27
 */
public class KafkaMsgSerializer implements Serializer<KafkaMsg> {

    /**
     * 序列化
     *
     * @param topic topic
     * @param data data
     * @return byte[]
     */
    @Override
    public byte[] serialize(String topic, KafkaMsg data) {
        return JSON.toJSONBytes(data);
    }

}
