package cn.metaq.jq;

import cn.metaq.jq.dao.DataQualityRecordDao;
import cn.metaq.jq.entity.DataQualityRecord;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Log4j2
public class DataQualityRecordTest {

  @Autowired
  private DataQualityRecordDao dao;

  @Test
  public void test(){

    DataQualityRecord record=new DataQualityRecord();
    record.setCheckTime(System.currentTimeMillis());
    record.setTableName("aaa");

    Map<String,Integer> map=new HashMap<>();
    map.put("checkNull",1);
    record.setTagCountMap(map);

    dao.save(record);
  }
}
