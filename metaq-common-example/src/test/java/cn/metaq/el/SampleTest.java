package cn.metaq.el;

import cn.metaq.el.func.ColumnFunction;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SampleTest {

  @Test
  public void test1(){
    ExpressionParser parser = new SpelExpressionParser();
    Expression exp = parser.parseExpression("'Hello World'");
    String message = (String) exp.getValue();

    System.out.println(message);
  }

  @Test
  public void test2(){

    EvaluationContext context = new StandardEvaluationContext();
    context.setVariable("columnFunc",new ColumnFunction());
    String name="abcd";
    context.setVariable("name",name);
    ExpressionParser parser = new SpelExpressionParser();
    Expression exp = parser.parseExpression("#columnFunc.checkNull(#name) or #columnFunc.isNumber('name')");
    Boolean message = exp.getValue(context,Boolean.class);

    System.out.println(message);
    System.out.println(name);
    System.out.println(context.lookupVariable("name"));
  }

  @Test
  public void test3(){

    EvaluationContext context = new StandardEvaluationContext();
    context.setVariable("column_func",new ColumnFunction());
    ExpressionParser parser = new SpelExpressionParser();
    Expression exp = parser.parseExpression("#column_func.checkNull('name')?((#column_func.isNumber('name') && #column_func.checkMaxLength('name'))?'a':'d'):#column_func.isEmail()?'b':'e'");
    String message = exp.getValue(context,String.class);

    System.out.println(message);
  }


  @Test
  public void test4(){

    EvaluationContext context = new StandardEvaluationContext(new ColumnFunction());
    //context.setVariable("column_func",new ColumnFunction());

    Map<String,Object> raw=new HashMap<>();
    raw.put("age",12);

    Map<String,Object> target=new HashMap<>();
    target.put("age",13);

    context.setVariable("raw",raw);
    context.setVariable("target",target);
    ExpressionParser parser = new SpelExpressionParser();
    Expression exp = parser.parseExpression("(compare(#raw.get('age'),#target.get('age')))");
    Boolean message = exp.getValue(context,Boolean.class);

    System.out.println(message);
  }
}
