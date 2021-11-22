package cn.metaq.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RocketMQMessageListener(topic = "${custom.mq.topic.metadata.task}",consumerGroup = "metadata-task-consumer-group-test")
public class MetadataTaskListener implements RocketMQListener<MessageExt> {

  @Override
  public void onMessage(MessageExt message) {

    String json=new String(message.getBody());
    log.info("元数据同步监听，收到消息,{}",json);
  }
}
