# SpringBoot 集成 Kafka 传输自定义消息

## 启动Zookeeper和Kafka

> docker-compose 容器编排工具启动

在项目根目录打开Terminal，执行启动指令

```shell
wangx@axing kafka-project % docker-compose -f docker-compose.yml up -d
# 启动成功输出
Creating network "kafka-project_network-kafka" with driver "bridge"
Creating star_zk ... done
Creating star_kafka ... done

# 查看在运行的容器
wangx@axing kafka-project % docker-compose ps                         
   Name                 Command               State                          Ports                        
----------------------------------------------------------------------------------------------------------
star_kafka   start-kafka.sh                   Up      0.0.0.0:9092->9092/tcp                              
star_zk      /docker-entrypoint.sh zkSe ...   Up      0.0.0.0:2181->2181/tcp, 2888/tcp, 3888/tcp, 8080/tcp
```

## 启动项目

### 启动生产者和消费者

![image-20220513175742841](https://file.wangx.net.cn/images/202205131757873.png)

启动成功后

校验接口：访问 http://localhost:8000/api/producer/test 是否可正常访问，返回”OK“即为正常

发送消息：访问 http://localhost:8000/api/producer/send?param=TestParam， 返回”OK“即为接口调用正常

消费者收到消息则会打印对应内容，如图所示

![image-20220513213201854](https://file.wangx.net.cn/images/202205132132905.png)

## 自定义消息

KafkaMsg

![image-20220513213307589](https://file.wangx.net.cn/images/202205132133625.png)

序列化实现

![image-20220513213333585](https://file.wangx.net.cn/images/202205132133623.png)

反序列化实现

![image-20220513213354503](https://file.wangx.net.cn/images/202205132133538.png)



> 需要进行自定义其它对象时，创建自定义对象，同时需要进行创建该类对应的序列化(实现org.apache.kafka.common.serialization.Serializer)和反序列化(实现org.apache.kafka.common.serialization.Deserializer)的实现类，在消费者主题监听处，可直接修改泛型V为指定类型，后续可实现自己的业务逻辑。

![image-20220513213611124](https://file.wangx.net.cn/images/202205132136158.png)