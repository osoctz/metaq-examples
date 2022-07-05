package cn.metaq.el;

import cn.hutool.extra.pinyin.PinyinUtil;
import org.junit.Test;

public class PinyinTest {

  @Test
  public void testPinyin(){

    //System.out.println(PinyinUtil.getPinyin("haha你笑起来真好看", ""));
    System.out.println(Pinyin2Util.getPinyin("name", ""));
    //System.out.println(PinyinUtil.getPinyinInitials("你笑起来真好看"));
  }

  @Test
  public void testPinyin2(){

    System.out.println(PinyinUtil.getPinyin("haha你笑起来真好看", ""));
    System.out.println(PinyinUtil.getPinyin("name",""));
    //System.out.println(PinyinUtil.getPinyinInitials("你笑起来真好看"));
  }

}
