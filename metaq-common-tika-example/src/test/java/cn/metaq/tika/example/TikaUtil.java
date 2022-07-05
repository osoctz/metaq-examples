package cn.metaq.tika.example;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import java.io.File;
import java.io.FileInputStream;

public class TikaUtil {

    public static String parse(String filePath) throws Exception{
        return parse(filePath,10*1024*1024);
    }

    public static String parse(String filePath,int limit) throws Exception{
        File file=new File(filePath);
        if(!file.exists()){
            System.out.println("目标文件不存在！");
            return null;
        }
        BodyContentHandler handler=null;
        if(limit>10*1024*1024) {
            handler = new BodyContentHandler(limit);
        }else{
            handler = new BodyContentHandler(10 * 1024 * 1024);
        }
        Metadata meta=new Metadata();
        FileInputStream input=new FileInputStream(file);
        ParseContext context=new ParseContext();
        new AutoDetectParser().parse(input,handler,meta,context);
        return handler.toString();
    }

    public static void main(String[] args) throws Exception {
        System.setProperty("log4j.configurationFile","/Users/zantang/IdeaProjects/metaq-examples/metaq-common-tika-example/src/main/resources/log4j2.xml");
        String content=TikaUtil.parse("/Users/zantang/Desktop/a.docx");
        System.out.println(content);
    }
}

