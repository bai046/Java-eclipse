package 时间;

import java.text.SimpleDateFormat;
//SimpleDateFormat 是一个以语言环境敏感的方式来格式化和分析日期的类，允许你选择任何用户自定义日期时间格式来运行。
import java.util.Date;

public class time {
   public static void main(String args[]) {
	   
       // 初始化 Date 对象
       Date date = new Date();
       // 使用 toString() 函数显示日期时间
       System.out.println(date.toString());
      
       
       Date Now = new Date( );
       SimpleDateFormat t = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
//确立了转换的格式，其中 yyyy 是完整的公元年，MM 是月份，dd 是日期，HH:mm:ss 是时、分、秒。
//注意:有的格式大写，有的格式小写，例如 MM 是月份，mm 是分；HH 是 24 小时制，而 hh 是 12 小时制。
       System.out.println("当前时间为: " + t.format(Now));
       
       System.out.println(t.format(new Date()));// new Date()为获取当前系统时间
   }
}