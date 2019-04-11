package com.hao.validate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hao.validate.db.JDBCUtils;
import com.hao.validate.pojo.User;

public class UserDao {
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	public int insert(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "insert into user(username,password,email,state,code) values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setInt(4, user.getState());
			ps.setString(5, user.getCode());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 注册表改为激活状态
	 * @param code
	 * @return
	 */
	public int activation(String code) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "update user set state=1 where code=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, code);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
