package cn.metaq.example.iceblue;

import com.github.difflib.DiffUtils;
import com.github.difflib.UnifiedDiffUtils;
import com.github.difflib.patch.AbstractDelta;
import com.github.difflib.patch.Patch;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import org.junit.Test;

public class TextTest {

  @Test
  public void test() throws IOException {
    //原始文件
    List<String> original = Files.readAllLines(new File("text1.txt").toPath());
    //对比文件
    List<String> revised = Files.readAllLines(new File("text2.txt").toPath());

    //两文件的不同点
    Patch<String> patch = DiffUtils.diff(original, revised);
    for (AbstractDelta<String> delta : patch.getDeltas()) {
      System.out.println(delta);
    }
  }

  /**
   * 根据patch生成统一的差异格式unifiedDiff
   * @throws IOException
   */
  @Test
  public void test2() throws IOException {
    //原始文件
    List<String> original = Files.readAllLines(new File("text1.txt").toPath());
    //对比文件
    List<String> revised = Files.readAllLines(new File("text2.txt").toPath());

    //两文件的不同点
    Patch<String> patch = DiffUtils.diff(original, revised);
    //生成统一的差异格式
    List<String> unifiedDiff = UnifiedDiffUtils.generateUnifiedDiff("text1.txt", "text2.txt", original, patch, 0);
    unifiedDiff.forEach(System.out::println);
  }
}
