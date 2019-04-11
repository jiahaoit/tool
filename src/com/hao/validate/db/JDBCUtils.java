package com.hao.validate.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.hao.db.jdbc.model.JDBCInfo;

/**
 * 数据库连接和关闭,统一放到这个类中,供其他类调用
 */
public class JDBCUtils {
	
	public static Connection getConnection()
	{
		//从XML读取数据库的实体类JDBCInfo
		JDBCInfo info = new XmlConfigReader().getJdbcInfo();		
		Connection con = null ;		
		try {		
			Class.forName(info.getDrivername());//加载驱动
			String url = info.getUrl();//活动XML中路径
			String username =  info.getUsername();//账户
			String password = info.getPassword();//密码
			con = DriverManager.getConnection(url,username, password);//正式链接
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			System.out.println("数据库连接失败,请查看具体原因:");
			e.printStackTrace();
		}		
		return con ;		
	}

	
	/**
	 * 关闭连接
	 */
	public static void free(ResultSet rs, Statement sta , Connection con)
	{
		try {
			if(null != rs)
			{
				rs.close();
				rs = null ;
			}
			
			if(null != sta)
			{
				sta.close();
				sta = null ;
			}
			
			if(null != con)
			{
				con.close();
				con = null ;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}




