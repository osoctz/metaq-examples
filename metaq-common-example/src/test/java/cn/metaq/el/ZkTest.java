package cn.metaq.el;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.KeeperException.NodeExistsException;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZkTest {

  private static final Logger logger = LoggerFactory.getLogger(ZkTest.class);

  private CuratorFramework client;

  @Before
  public void before() {
    //192.168.3.61:2181
    //bailian-aliyun-cdh1.bl-ai.com:2181,bailian-aliyun-cdh2.bl-ai.com:2181,bailian-aliyun-cdh3.bl-ai.com:2181
    client = CuratorFrameworkFactory.newClient("bailian-aliyun-cdh1.bl-ai.com:2181,bailian-aliyun-cdh2.bl-ai.com:2181,bailian-aliyun-cdh3.bl-ai.com:2181", 5000, 3000, new RetryNTimes(10, 1000));
    client.start();
  }

  @Test
  public void test1() {

    String path = "/dfrun/tasks/402203f71566c4217d430d1694af6f02/cmd/ffdf84f1-bf7b-4b26-bea9-365907160d8f/finish";
    byte[] data = "aaa".getBytes();
    try {
      Stat stat = client.checkExists().forPath(path);
      if (stat != null) {
        System.out.println("已存在");
        client.delete().deletingChildrenIfNeeded().forPath(path);
        client.create().creatingParentsIfNeeded().forPath(path, data);
      } else {
        System.out.println("不存在创建");
        client.create().creatingParentsIfNeeded().forPath(path, data);
      }
    } catch (Exception e) {

      throw new RuntimeException("create zk data node error :" + path, e);
    }
  }

  @Test
  public void test2() {

    String path = "/tangzan/1/2";
    byte[] data = "aaa".getBytes();
    try {
      try {
        client.create().creatingParentsIfNeeded().forPath(path, data);
      } catch (NodeExistsException e) {
        //log.warn(e);
        client.setData().forPath(path, data);
      }
    } catch (Exception e) {

      throw new RuntimeException("create zk data node error :" + path, e);
    }
  }

  @Test
  public void test3() {
    try {
      client.delete().deletingChildrenIfNeeded().forPath("/tangzan");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  @Test
  public void test4() {
    this.run("/tangzan/1/2","aa".getBytes());
    this.run("/tangzan/1/3","aa".getBytes());
//    ExecutorService executor = Executors.newFixedThreadPool(4);
//    executor.execute(()->{
//      this.run("/tangzan/1/2","aa".getBytes());
//    });
//    executor.execute(()->{
//      this.run("/tangzan/1/3","bb".getBytes());
//    });
  }

  private void run(String path,byte[] data){
    try {
      logger.info("{} 启动",path);
      client.create().creatingParentsIfNeeded().forPath(path, data);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
