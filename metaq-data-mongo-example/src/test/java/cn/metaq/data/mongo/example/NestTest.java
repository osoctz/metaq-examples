package cn.metaq.data.mongo.example;

import cn.metaq.data.mongo.example.dao.ColumnInfoDao;
import cn.metaq.data.mongo.example.entity.ColumnInfo;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class NestTest {

  @Autowired
  private ColumnInfoDao columnInfoDao;

  @Test
  public void testAdd(){

    ColumnInfo c1=new ColumnInfo();
    //c1.setId("1");
    c1.setColumnName("c1");
    c1.setTableId("t1");

    ColumnInfo c11=new ColumnInfo();
    //c11.setId("11");
    c11.setColumnName("c11");
    c11.setTableId("t1");
    columnInfoDao.save(c11);

    ColumnInfo c12=new ColumnInfo();
    //c12.setId("12");
    c12.setColumnName("c12");
    c12.setTableId("t1");
    columnInfoDao.save(c12);

    c1.setColumns(Lists.list(c11,c12));
    columnInfoDao.save(c1);

  }

  @Test
  public void testAdd2(){

    ColumnInfo c11=new ColumnInfo();
    //c11.setId("11");
    c11.setColumnName("c11");
    c11.setTableId("t1");

    ColumnInfo c111=new ColumnInfo();
    //c111.setId("111");
    c111.setColumnName("c111");
    c111.setTableId("t1");
    columnInfoDao.save(c111);

    ColumnInfo c112=new ColumnInfo();
    //c112.setId("112");
    c112.setColumnName("c112");
    c112.setTableId("t1");
    columnInfoDao.save(c112);

    c11.setColumns(Lists.list(c111,c112));

    columnInfoDao.save(c11);
  }

  @Test
  public void testQuery(){

    columnInfoDao.findById("1").ifPresent(s->{

      System.out.println(s);
    });
  }
}
