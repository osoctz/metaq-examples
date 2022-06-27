package cn.metaq.example;

import org.camunda.bpm.client.ExternalTaskClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChargeCardWorker {

  private final static Logger LOGGER = LoggerFactory.getLogger(ChargeCardWorker.class.getName());

  public static void main(String[] args) {

    ExternalTaskClient client = ExternalTaskClient.create().baseUrl("http://localhost:8081/engine-rest")
        .asyncResponseTimeout(10000)
        .build();

    client.subscribe("charge-card").lockDuration(1000)
        .handler(((externalTask, externalTaskService) -> {
          //业务逻辑
          //获取流程变量
          String item = externalTask.getVariable("item");
          Long amount = externalTask.getVariable("amount");
          LOGGER.info("Charging credit card with an amount of'" + amount + "'$ for the item '" + item + "'...");
          externalTaskService.complete(externalTask);
        })).open();
  }
}
