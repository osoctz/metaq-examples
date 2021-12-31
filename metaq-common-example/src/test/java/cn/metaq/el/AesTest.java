package cn.metaq.el;

import cn.metaq.el.sample1.AESUtils;
import org.junit.Test;

public class AesTest {

  @Test
  public void testAes(){

    String key="6162382d323fb399fc202a5aca55336a";
    //根据密钥，生成 aes.key
    //String aesKey=AesUtils.getKeyByPass(key);
    String str = AesUtils.encrypt("123456", key);
    //解密
    String pwd=AesUtils.decrypt(str,key);

    System.out.println("密钥:"+key);
    //System.out.println("aesKey:"+aesKey);
    System.out.println("加密后:"+str);
    System.out.println("解密:"+pwd);
  }

  private String aesKey = "6162382d323fb399fc202a5aca55336a";

  @Test // 生成 AES Key
  public void test(){
    System.out.println(AesUtils.getKeyByPass("Jueee"));
  }

  @Test // AES 解密
  public void testDecrypt(){
    final String str = "FJscqvyWFReJftsv9WxkIFpHq8Y/GLBAi4tbv/qyAqLMeCAr8fpaJBQ83F4Owe1S";
    System.out.println(AesUtils.decrypt(str, aesKey));
  }

  @Test
  public void test2() throws Exception {
    String key = AESUtils.initKey();
    System.out.println("生成密钥：" + key);
    String iv = AESUtils.initIV();
    System.out.println("生成初始向量：" + iv);
    String content = "zb@@1234";  // 待加密内容
    String encrypt = AESUtils.encrypt(content, key, iv);
    System.out.println("明文内容："+ content);
    System.out.println("加密结果："+ encrypt);
    System.out.println("解密结果："+ AESUtils.decrypt(encrypt, key, iv));
  }
}
