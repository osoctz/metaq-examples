package cn.metaq.data.kafka;

import cn.metaq.data.kafka.model.Contact;
import cn.metaq.data.kafka.model.Organization;
import cn.metaq.data.kafka.model.Potential;
import cn.metaq.data.kafka.producer.KafkaProducer;
import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.matcher.FilterableList;
import net.bytebuddy.matcher.FilterableList.Empty;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class KafkaTest {

  @Autowired
  private KafkaProducer producer;

  @Test
  public void test(){

    List<Organization> orgs=new ArrayList<>();
    Organization o1=new Organization();
    o1.setName("北京百炼智能科技有限公司");
    o1.setOri_name("百炼智能");

    orgs.add(o1);

    Organization o2=new Organization();
    o2.setName("北京明略科技有限公司");
    o2.setOri_name("明略科技");

    orgs.add(o2);

    List<Contact> contacts=new ArrayList<>();
    Contact contact=new Contact();
    contact.setOrganizations(orgs);
    contact.setName("张先生");
    contact.setOri_url("http://www.baidu.com");
    contact.setSource(12);

    contacts.add(contact);

    Potential p=new Potential();
    p.setSource(11);
    p.setContacts(contacts);
    p.setOri_name("百炼智能");
    p.setOri_url("http://www.jubstforfun.com/12348.html");

    producer.send(p);
  }
}
