package cn.metaq.el.func;

public class ColumnFunction {

  public static boolean checkNull(String columnName) {
    System.out.println("columnName = " + columnName);
    columnName=null;
    return false;
  }

  public static boolean checkMaxLength(String columnName) {
    return true;
  }

  public static boolean isNumber(String columnName) {
    return true;
  }

  public static boolean isEmail(){
    return true;
  }
}
