package com.hao.db.jdbc.model;
/**
 * 对应XML文档中的元素,用于链接数据库
 * @author hao
 *
 */
public class JDBCInfo {
	private String drivername;
	private String url;
	private String username;
	private String password;
	public String getDrivername() {
		return drivername;
	}
	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}