package cn.metaq.example.iceblue;

import com.github.difflib.DiffUtils;
import com.github.difflib.UnifiedDiffUtils;
import com.github.difflib.patch.AbstractDelta;
import com.github.difflib.patch.Patch;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
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

  /**
   * 文本差异对比高亮工具（基于谷歌文本比对工具）
   * <span title="i=0">“数据”是新的生产要素已成为共识，而要挖掘数据价值，就绕不过数据管理。在数据管理层面，近几年业界有一个相关概念受到广泛关注——DataOps。DataOps 的概念自首次被提出至今已有 8 年，并在 2018 年被 Gartner 纳入数据管理技术成熟度曲线。从实施上看，当下 DataOps 仍处在发展初期，鲜少企业或团队能据此真正沉淀一套方法论或技术产品的体系。不过，随着越来越多的企业开启 DataOps 实践，相信令人“雾里看花”的 DataOps 方法体系也会逐渐明朗起来。明源云是其中一个探索者，</span>
   *   <ins style="background:#E6FFE6;" title="i=254">
   *    加入了一段修改的文本，
   *   </ins>
   *   <span title="i=265">过去 25 年，明源云的数字化服务主要聚焦在住宅开发领域。随着房地产行业从过去的红利时代急转进入混沌时代，不少企业开始纷纷布局存量市场，并注重精细化管理，明源云的下一步业务战略正是沿着不动产的产业数字化方向扩展。不动产企业的发展战略趋向多元化，对于经营决策、运营服务等的需求越来越迫切，同时，明源云意识到，在企业经营管理战略上，如果数据不能保证及时和准确，数字化价值则会大打折扣。为此，过去几年在业务发展路径和客户数字化诉求的驱动下，明源云持续结合 DataOps 实践、探索数据治理体系的落地。近期我们与明源云天际&middot;PaaS 平台数据云事业部产品负责人梅容进行了一次交流，以进一步了解明源云 DataOps 的实践过程、从中收获的经验和认知。</span>
   *   <ins style="background:#E6FFE6;" title="i=587">
   *    什么是 DataOps？关于 DataOps，一个常见的基本问题是，DataOps 和 DevOps 有什么关系和区别？2021 年，Gartner 发布的“十大数据和分析技术趋势”中有一项是“XOps”，Gartner 研究总监孙鑫对此解读道：现在的分析和 AI 解决方案没有跟上日益增长的实践的多样性，其原因在于应用当中的 DevOps 的最佳实践的多个 Ops 学科，大家可以看到的有 DataOps、ModelOps 以及 DevOps，造成了市场的混乱，所以 Gartner 把它叫做 XOps。无论是什么 Ops，它的目标都是利用 DevOps 的最佳实践去实现效率和规模经济，并确保可靠性、可重用性和可重复性，同时减少技术和流程的重复，从而实现自动化。
   *   </ins>
   */
  @Test
  public void test3() throws IOException {
    //原始文件
    List<String> original = Files.readAllLines(new File("text1.txt").toPath());
    //对比文件
    List<String> revised = Files.readAllLines(new File("text2.txt").toPath());

    DiffMatchPatch dmp = new DiffMatchPatch();
    System.out.println(dmp.getHtmlDiffString(original.stream().collect(Collectors.joining()), revised.stream().collect(Collectors.joining())));
  }
}
