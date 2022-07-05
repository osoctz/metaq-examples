package cn.metaq.example.poi;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.CharacterRun;
import org.apache.poi.hwpf.usermodel.Range;
import org.junit.jupiter.api.Test;

public class WordTest {

  /**
   * HWPF
   * 处理*.doc文件
   */
  @Test
  public void testParseXls() throws IOException {

    InputStream is = new FileInputStream("files/1.doc");
    HWPFDocument word = new HWPFDocument(is);

    Range allRange = word.getRange();
    int length = allRange.numCharacterRuns();
    StringBuffer sb = new StringBuffer();
    CharacterRun cur;
    String text = "";
    for (int i = 0; i < length; i++) {
      cur = allRange.getCharacterRun(i);
      System.out.println(cur.text());
      sb.append(CharacterRunUtils.toSpanType(cur));
      text = CharacterRunUtils.getSpicalSysbomByRun(cur.text());
      if(cur.getSubSuperScriptIndex() == 1)
        sb.append("<sup>").append(text).append("</sup>");
      else if(cur.getSubSuperScriptIndex() == 2)
        sb.append("<sub>").append(text).append("</sub>");
      else
        sb.append(text);
      sb.append("</span>");
    }

    System.out.println(sb.toString());
  }
}
