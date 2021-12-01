package cn.metaq.neo4j;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.cypherdsl.core.Cypher;
import org.neo4j.cypherdsl.core.Node;
import org.neo4j.cypherdsl.core.Relationship;
import org.neo4j.cypherdsl.core.ResultStatement;
import org.neo4j.cypherdsl.core.renderer.Renderer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Log4j2
public class Neo4jCmdTest {

  @Test
  public void testCreateCmd(){

    var people = Cypher.node("Person").named("people");
    ResultStatement statement = Cypher
        .match(people)
        .returning(people.property("name"))
        .limit(10)
        .build();

    Renderer defaultRenderer=Renderer.getDefaultRenderer();

    log.info("neo4j cypher : {}",defaultRenderer.render(statement)); ;
  }

  @Test
  public void testCreateCmd2(){

    var people = Cypher.anyNode().named("people");
    ResultStatement statement = Cypher
        .match(people)
        .returning(people.property("name"))
        .limit(10)
        .build();

    Renderer defaultRenderer=Renderer.getDefaultRenderer();

    log.info("neo4j cypher : {}",defaultRenderer.render(statement));
  }

  @Test
  public void test3(){

    String name="北京";
    Node source = Cypher.anyNode().named("source");
    Node target = Cypher.anyNode().named("target");
    Relationship relationship = source.relationshipTo(target).named("rela");

    Renderer defaultRenderer = Renderer.getDefaultRenderer();

    ResultStatement statement = Cypher.match(relationship)
        .where(
            source.property("name").eq(Cypher.literalOf(name)).or(target.property("name").eq(Cypher.literalOf(name))))
        .returning(relationship, source, target)
        .limit(25)
        .build();

    log.info("neo4j cypher : {}",defaultRenderer.render(statement));
  }

  @Test
  public void test4(){

    String name="北京";
    Node source = Cypher.anyNode().named("source");
    Node target = Cypher.anyNode().named("target");
    Relationship relationship = source.relationshipTo(target).named("rela");

    Renderer defaultRenderer = Renderer.getDefaultRenderer();

    ResultStatement statement = Cypher.match(relationship)
        .where(
            source.property("name").matches(Cypher.literalOf(".*"+name+".*")).or(target.property("name").eq(Cypher.literalOf(name))))
        .returning(relationship, source, target)
        .limit(25)
        .build();

    log.info("neo4j cypher : {}",defaultRenderer.render(statement));
  }
}
