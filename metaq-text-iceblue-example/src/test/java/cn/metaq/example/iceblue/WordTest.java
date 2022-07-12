package cn.metaq.example.iceblue;

import com.spire.doc.Document;
import com.spire.doc.DocumentObject;
import com.spire.doc.Section;
import com.spire.doc.Table;
import com.spire.doc.TableRow;
import com.spire.doc.collections.CommentsCollection;
import com.spire.doc.documents.DocumentObjectType;
import com.spire.doc.documents.Paragraph;
import com.spire.doc.fields.Comment;
import com.spire.doc.fields.TextRange;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import org.junit.Test;

public class WordTest {

  @Test
  public void test1(){
    //创建Document实例，加载第一个Word示例文档
    Document doc1 = new Document();
    doc1.loadFromFile("/Users/zantang/Downloads/0613.docx");

    //创建Document实例，加载第二个Word示例文档
    Document doc2 = new Document();
    doc2.loadFromFile("/Users/zantang/Downloads/招标文件0701.docx");

    //比较两个示例文档的内容差异
    doc1.compare(doc2, "tom");

    //保存结果文档
    doc1.saveToFile("Result.docx");
  }

  @Test
  public void test2(){
    Document doc1 = new Document();
    doc1.loadFromFile("Result.docx");
    //获取文档中的文本保存为String
    String text2=doc1.getText();
    System.out.println(text2);
    //读取word中的批注
    String text = "";

    //遍历所有批注
    for(int i = 0;i< doc1.getComments().getCount();i++){
      Comment comment = doc1.getComments().get(i);
      //遍历所有批注中的段落
      for(int j= 0;j < comment.getBody().getParagraphs().getCount();j++) {
        Paragraph paragraph = comment.getBody().getParagraphs().get(j);
        //遍历段落中的对象
        for (Object object : paragraph.getChildObjects()) {
          //读取文本
          if (object instanceof TextRange) {
            TextRange textRange = (TextRange) object;
            text = text + textRange.getText();
          }
        }
      }
    }
    //输入文本内容
    System.out.println(text);
  }

  @Test
  public void test3(){
    String path = "/Users/zantang/IdeaProjects/metaq-examples/metaq-poi-example/files/1.docx";
    System.out.println("----------段落-----------");
    spireParaghDoc(path);
    System.out.println("----------表格-----------");
    spireForTableOfDoc(path);
  }

  //读取段落
  public static void spireParaghDoc(String path) {
    Document doc = new Document(path);
    for (int i = 0; i < doc.getSections().getCount(); i++) {
      System.out.println("第 " + i+"节");
      Section section = doc.getSections().get(i);
      for (int j = 0; j < section.getParagraphs().getCount(); j++) {
        System.out.println("第 " + j+"段");
        Paragraph paragraph = section.getParagraphs().get(j);
        System.out.println(paragraph.getText());
      }
    }
  }

  //读取表格
  public static void spireForTableOfDoc(String path) {
    Document doc = new Document(path);
    for (int i = 0; i < doc.getSections().getCount(); i++) {
      Section section = doc.getSections().get(i);
      for (int j = 0; j < section.getBody().getChildObjects().getCount(); j++) {
        DocumentObject obj = section.getBody().getChildObjects().get(j);
        if (obj.getDocumentObjectType() == DocumentObjectType.Table) {
          //obj.getPreviousSibling();
          System.out.println("第 " + i+"节");
          System.out.println("第 " + j+"段");
          Table table = (Table) obj;
          for (int k = 0; k < table.getRows().getCount(); k++) {
            TableRow rows = table.getRows().get(k);
            for (int p = 0; p < rows.getCells().getCount(); p++) {
              for (int h = 0; h < rows.getCells().get(p).getParagraphs().getCount(); h++) {
                Paragraph f = rows.getCells().get(p).getParagraphs().get(h);
                System.out.println(f.getText());
              }
            }
          }
        }
      }
    }
  }

}
