package org.wx.kafka.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author WangXin
 * @description kafka配置类
 * @date 2022/5/13 16:51
 */
@Configuration
public class KafkaConfiguration {

    /**
     * 创建一个名为testTopic的Topic并设置分区数partitions为8，分区副本数replication-factor为2
     *
     * @return NewTopic
     */
    @Bean
    public NewTopic initialTopic() {
        System.out.println("........................init topic........................");
        return new NewTopic("test_topic_01",8, (short) 1 );
        // 集群启动时使用下方代码
        // return new NewTopic("test_topic_01", 8, (short) 2);
    }

    /**
     * 修改分区数并不会导致数据的丢失，但是分区数只能增大不能减小
     *
     * @return NewTopic
     */
    @Bean
    public NewTopic updateTopic() {
        System.out.println(".......................update topic........................");
        return new NewTopic("test_topic_01", 10, (short) 1);
        // 集群启动时使用下方代码
        // return new NewTopic("test_topic_01",10, (short) 2 );
    }

}
