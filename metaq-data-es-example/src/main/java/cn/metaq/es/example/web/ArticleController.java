package cn.metaq.es.example.web;

import cn.metaq.common.util.JsonUtils;
import cn.metaq.common.web.dto.Result;
import cn.metaq.es.example.biz.ArticleBiz;
import cn.metaq.es.example.model.Article;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.AnalyzeRequest;
import org.elasticsearch.client.indices.AnalyzeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

  @Resource
  private ArticleBiz articleBiz;
  @Autowired
  private RestHighLevelClient client;

  @GetMapping("articles")
  public Result add() {

    Article article = new Article();
    article.setId("1234562");
    article.setName("习大大讲话");
    article.setContent(
        "7月12日至16日，中共中央政治局常委、全国人大常委会委员长栗战书在贵州调研。这是7月16日，栗战书在贵安新区华为云数据中心了解企业研发创新、大数据应用等情况。新华社记者 庞兴雷 摄\n" + "\n"
            + "　　栗战书先后在贵阳市、黔南州、黔东南州、铜仁市和六盘水市进行调研。他深入民族村寨和社区、乡镇，同村寨老党员、村民代表亲切交谈，询问群众生产生活状况。在特色产业园区和企业，了解当地发展优势产业，带动群众就业等情况。栗战书说，在庆祝中国共产党成立100周年大会上，习近平总书记庄严宣告，我们实现了第一个百年奋斗目标，全面建成了小康社会，历史性地解决了绝对贫困问题。农业农村发展已经进入全面推进乡村振兴的新阶段，要再接再厉，把脱贫攻坚成果巩固好拓展好，衔接推进乡村振兴，让广大农民的日子越过越幸福、越过越红火。");
    articleBiz.save(article);
    return Result.ok();
  }

  @GetMapping("analyze")
  public Result analyze(String words) throws IOException {

//    List<String> list = new ArrayList<String>();
//    Request request = new Request("GET", "_analyze");
//
//    Map entity = new HashMap();
//    entity.put("analyzer", "ik_max_word");
//    //entity.put("analyzer", "ik_smart");
//    entity.put("text", words);
//    request.setJsonEntity(JsonUtils.toJson(entity));
//
//    GetRequest request1=new GetRequest();
//    Response response = client.get().performRequest(request);

    //AnalyzeWordDTO wordDTO=response.getEntity()
//    JSONObject tokens = new JSONObject(JsonUtils.toJson(response.getEntity()));
//    JSONArray arrays = tokens.getJSONArray("tokens");
//    for (int i = 0; i < arrays.size(); i++)
//    {
//      JSONObject obj = JSON.parseObject(arrays.getString(i));
//      list.add(obj.getString("token"));
//    }

    AnalyzeRequest analyzeRequest = AnalyzeRequest.withGlobalAnalyzer("ik_max_word",words);

    List<AnalyzeResponse.AnalyzeToken> tokens = client.indices()
        .analyze(analyzeRequest, RequestOptions.DEFAULT).getTokens();

    for (AnalyzeResponse.AnalyzeToken token : tokens) {
      System.out.println(token.getTerm());
    }

    return Result.ok();
  }
}
