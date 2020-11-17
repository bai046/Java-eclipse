package reserve;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
public class DateTraveller {
public static void main(String[] args) throws ParseException {
 //通过传入的字符串最终转换为对应的日期类
 int days;
 int day;
 System.out.println("请输入日期(格式：2020-9-10):");
 @SuppressWarnings("resource")
Scanner scanner=new Scanner(System.in);
 String str=scanner.nextLine();//输入查询日期
 DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
 Date d=df.parse(str);  //将字符串转换为时间对象
 Calendar c=new GregorianCalendar();
 c.setTime(d);//将时间对象转换位日期对象
 day=c.get(Calendar.DAY_OF_MONTH);//保存你查的特定天数日期
 System.out.println("日\t一\t二\t三\t四\t五\t六\t");
 c.set(Calendar.DAY_OF_MONTH, 1); //设置第一天
 for(int i=0;i<c.get(Calendar.DAY_OF_WEEK)-1;i++) {
  System.out.print("\t");//月份的第一号对应的星期前面的用\t代替
 }
 days=c.getActualMaximum(Calendar.DATE);//获得你查询日期月份总天数
 for(int i=1;i<=days;i++) {//获得这个日期的当月的最大值
 if(c.get(Calendar.DAY_OF_MONTH)==day) {
   System.out.print("["+c.get(Calendar.DAY_OF_MONTH)+"]\t");//特定的天数格式用[]标识出来
  }else {
   System.out.print(c.get(Calendar.DAY_OF_MONTH)+"\t");
  }
  if(c.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY) { //每到周六就换行
   
   System.out.println();//换行
   
  }
  c.add(Calendar.DAY_OF_MONTH, 1);//天数加一
   
 }
}
}
