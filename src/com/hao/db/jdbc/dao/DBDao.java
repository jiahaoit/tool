package com.hao.db.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hao.db.jdbc.model.TestDBModel;
import com.hao.db.jdbc.utils.JDBCUtils;

/**
 * 操作数据库：CRUD
 * 
 * @author hao
 *
 */
public class DBDao {
	/**
	 * 查询所有
	 */
	public List<TestDBModel> findAll() {
		Connection conn = null;// 链接数据库
		PreparedStatement ps = null;// 预编译
		ResultSet rs = null;// 结果集--
		List<TestDBModel> allStu = null;// 储存获得的结果到列表中
		try {
			conn = JDBCUtils.getConnection();// 获得数据库链接
			String sql = "select * from test";// SQL语句
			ps = conn.prepareStatement(sql);// 用SQL语句实例化prepareStatement
			rs = ps.executeQuery();// 执行查询并获得结果集
			while (rs.next()) {// 如果结果不为空
				if (allStu == null) {// 只需要第一次实例化,
					allStu = new ArrayList<TestDBModel>();// 用array实例化
				}
				TestDBModel testDBModel = new TestDBModel();
				testDBModel.setId(rs.getInt("test_id"));// 取得id
				testDBModel.setNumber(rs.getString("number"));// 取得id
				allStu.add(testDBModel);// 依次添加到集合中
			}
		} catch (SQLException e) {
			System.err.println("查询Test表所有数据失败,请查看具体原因!");
			e.printStackTrace();
		}
		return allStu;
	}

	/**
	 * 根据id查询
	 */
	public TestDBModel findById(int sid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		TestDBModel test = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from test where test_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sid);// 传入的id
			rs = ps.executeQuery();

			if (rs.next()) {
				test = new TestDBModel();
				test.setId(rs.getInt("test_id"));
				test.setNumber(rs.getString("number"));
			}

		} catch (SQLException e) {
			System.err.println("根据id查询失败,请查看具体原因!");
			e.printStackTrace();
		}
		return test;// 返回一个
	}
	
	/**
	 * 增加一个,传入test_id ,number
	 */
	public int add(TestDBModel testDBModel) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "insert into test(test_id,number) values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, testDBModel.getId());
			ps.setString(2, testDBModel.getNumber());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 增加一个,传入test_id ,number
	 */
	public int update(TestDBModel testDBModel) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "update test set number=? where test_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, testDBModel.getNumber());
			ps.setInt(2, testDBModel.getId());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 增加一个,传入test_id 
	 */
	public int delete(int test_id) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "delete from test where test_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, test_id);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
