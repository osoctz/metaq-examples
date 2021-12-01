package cn.metaq.example.jpa.config;

import cn.metaq.common.core.DaoTemplate;
import cn.metaq.data.jpa.BaseTemplate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class JpaExampleConfiguration {

    @PersistenceContext
    private EntityManager em;

    @Bean
    public DaoTemplate template(){
        return new BaseTemplate(em);
    }

    @Bean
    public JPAQueryFactory queryFactory(){
        return new JPAQueryFactory(em);
    }
}
