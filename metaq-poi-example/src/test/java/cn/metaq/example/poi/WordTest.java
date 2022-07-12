package cn.metaq.example.poi;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.CharacterRun;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.ooxml.POIXMLProperties.CoreProperties;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;

public class WordTest {

  /**
   * HWPF 处理*.doc文件
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
      if (cur.getSubSuperScriptIndex() == 1) {
        sb.append("<sup>").append(text).append("</sup>");
      } else if (cur.getSubSuperScriptIndex() == 2) {
        sb.append("<sub>").append(text).append("</sub>");
      } else {
        sb.append(text);
      }
      sb.append("</span>");
    }

    System.out.println(sb.toString());
  }

  /**
   * IBodyElement ------------------- 迭代器（段落和表格）
   * <p>
   * XWPFComment ------------------- 评论（个人理解应该是批注）
   * <p>
   * XWPFSDT
   * <p>
   * XWPFFooter ------------------- 页脚
   * <p>
   * XWPFFootnotes ------------------- 脚注
   * <p>
   * XWPFHeader ------------------- 页眉
   * <p>
   * XWPFHyperlink ------------------- 超链接
   * <p>
   * XWPFNumbering ------------------- 编号（我也不知是啥...）
   * <p>
   * XWPFParagraph ------------------- 段落
   * <p>
   * XWPFPictureData ------------------- 图片
   * <p>
   * XWPFStyles ------------------- 样式（设置多级标题的时候用）
   * <p>
   * XWPFTable ------------------- 表格
   *
   * @throws IOException
   */
  @Test
  public void testParseXlsx() throws IOException {

    InputStream is = new FileInputStream("files/1.docx");
    XWPFDocument word = new XWPFDocument(is);

    //获取所有段落
    List<XWPFParagraph> paragraphs = word.getParagraphs();
    //遍历段落
    for (XWPFParagraph para : paragraphs) {
//      CTPPr pr=para.getCTP().getPPr();
//      System.out.println(pr.getPStyle().getVal());
      //获取一个段落里的所有XWPFRun， 一个XWPFRun代表具有相同属性的一段文本
      List<XWPFRun> runs = para.getRuns();
      for (XWPFRun run : runs) {
        String fontFamily = run.getFontFamily();
        String style = run.getStyle();
        int pos = run.getTextPosition();
        String text = run.getText(pos);

        System.out.println(fontFamily);
        System.out.println(pos);
        System.out.println(text);

        System.out.println("-------------------------");
      }
    }

    //获取所有表格
    List<XWPFTable> tables = word.getTables();
    //遍历表格
    for (XWPFTable table : tables) {

      //获取表格所有行
      List<XWPFTableRow> rows = table.getRows();
      for (XWPFTableRow row : rows) {
        //一行中所有列
        List<XWPFTableCell> cells = row.getTableCells();
        //获取单元格中的内容
        for (XWPFTableCell cell : cells) {
          List<XWPFParagraph> cellParagraphs = cell.getParagraphs();
        }
      }
    }
  }

  /**
   * 通过XWPFWordExtractor访问XWPFDocument的内容
   * @throws Exception
   */
  @Test
  public void testReadByExtractor() throws Exception {
    InputStream is = new FileInputStream("files/1.docx");
    XWPFDocument doc = new XWPFDocument(is);
    XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
    String text = extractor.getText();
    System.out.println(text);
    CoreProperties coreProps = extractor.getCoreProperties();
    this.printCoreProperties(coreProps);
    this.close(is);
  }

  /**
   * 输出CoreProperties信息
   * @param coreProps
   */
  private void printCoreProperties(CoreProperties coreProps) {
    System.out.println(coreProps.getCategory());   //分类
    System.out.println(coreProps.getCreator()); //创建者
    System.out.println(coreProps.getCreated()); //创建时间
    System.out.println(coreProps.getTitle());   //标题
  }

  /**
   * 关闭输入流
   * @param is
   */
  private void close(InputStream is) {
    if (is != null) {
      try {
        is.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
