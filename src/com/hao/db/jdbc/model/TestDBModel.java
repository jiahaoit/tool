package com.hao.db.jdbc.model;

/**
 * 数据库表Test 实体类
 * @author hao
 *
 */
public class TestDBModel {
	
	@Override
	public String toString() {
		return "TestDBModel [id=" + id + ", number=" + number + "]";
	}
	public TestDBModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	int id;
	String number;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
}

