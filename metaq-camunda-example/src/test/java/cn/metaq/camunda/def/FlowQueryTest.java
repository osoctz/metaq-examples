package cn.metaq.camunda.def;

import cn.metaq.camunda.TestBase;
import java.util.List;
import javax.annotation.Resource;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.junit.Test;

public class FlowQueryTest extends TestBase {

  @Resource
  private RepositoryService repositoryService;

  @Test
  public void testQueryFlowDefinition(){

    List<ProcessDefinition> processDefinitions=repositoryService.createProcessDefinitionQuery().processDefinitionKey("Process_0hlcphd")
        .orderByProcessDefinitionVersion().asc().list();

    System.out.println(processDefinitions);
  }
}
