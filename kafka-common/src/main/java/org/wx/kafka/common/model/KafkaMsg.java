package org.wx.kafka.common.model;

import java.io.Serializable;

/**
 * @author WangXin
 * @date 2022/5/13 17:13
 */
public class KafkaMsg implements Serializable {

    /**
     * 对象id
     */
    private Long objectId;

    /**
     * key 值
     */
    private String key;

    public KafkaMsg() {
    }

    public KafkaMsg(Long objectId, String key) {
        this.objectId = objectId;
        this.key = key;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "KafkaMsg{" +
                "objectId=" + objectId +
                ", key='" + key + '\'' +
                '}';
    }
}
