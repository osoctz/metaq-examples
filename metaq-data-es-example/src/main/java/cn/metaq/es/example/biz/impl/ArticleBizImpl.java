package cn.metaq.es.example.biz.impl;

import cn.metaq.data.es.BaseBiz;
import cn.metaq.es.example.biz.ArticleBiz;
import cn.metaq.es.example.model.Article;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.stereotype.Service;

@Service
public class ArticleBizImpl extends BaseBiz<Article,Article> implements ArticleBiz {

  @Override
  public QueryBuilder map(Article article) {
    BoolQueryBuilder query = QueryBuilders.boolQuery();
//    if (StringUtils.isNotBlank(articleQo.getWords())) {
//      BoolQueryBuilder should = QueryBuilders.boolQuery();
//      should.should()
//          .add(QueryBuilders.matchQuery("content", articleQo.getWords()).analyzer("ik_max_word").operator(Operator.OR));
////      should.should()
////          .add(
////              QueryBuilders.matchQuery("subjects", articleQo.getWords()).analyzer("ik_max_word").operator(Operator.OR));
//      query.must().add(should);
//    }
//
//    if (articleQo.getStartTime() != null) {
//      query.must().add(QueryBuilders.rangeQuery("createdTs").gte(articleQo.getStartTime()));
//    }
//
//    if (articleQo.getEndTime() != null) {
//      query.must().add(QueryBuilders.rangeQuery("createdTs").lte(articleQo.getEndTime()));
//    }
//    if (articleQo.getAreas() != null && articleQo.getAreas().size() > 0) {
//      BoolQueryBuilder should = QueryBuilders.boolQuery();
//      for (String area : articleQo.getAreas()) {
//        should.should().add(QueryBuilders.matchQuery("areas", area));
//      }
//      query.must().add(should);
//    }
//    if (articleQo.getSubjects() != null && articleQo.getSubjects().size() > 0) {
//
//      BoolQueryBuilder should = QueryBuilders.boolQuery();
//      for (String subject : articleQo.getSubjects()) {
//        should.should().add(QueryBuilders.matchPhraseQuery("subjects", subject));
//      }
//      query.must().add(should);
//    }
    return query;
  }

}
