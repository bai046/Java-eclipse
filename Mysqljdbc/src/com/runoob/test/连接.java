package com.runoob.test;

import java.sql.*;       //导入java.sql包

public class 连接 {
		static Connection con;     //声明Connection对象
		static Statement sql;      //声明Statement对象
		static ResultSet res;      //声明ResultSet对象
		public Connection getConnection(){    //建立返回值为Connection的方法
			try {                             //加载数据库驱动
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("数据库驱动加载成功");
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			try {                 //通过访问数据库的URL获取数据库连接对象
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql");
				System.out.println("数据库连接成功");
				System.out.print('\n');
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return con;           //按方法要求放回一个Connection对象
		}	

}
