package com.hao.validate.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hao.jmail.SendEmail;
import com.hao.random.StringRandom;
import com.hao.validate.dao.UserDao;
import com.hao.validate.pojo.User;

/**
 * Servlet 注册 插入用户信息到数据库中，并发送激活邮件
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置请求和响应编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append("RegisterServlet！");
		User user = new User();
		user.setUsername(request.getParameter("name"));
		user.setPassword(request.getParameter("pass"));
		user.setEmail(request.getParameter("email"));
		user.setCode(StringRandom.getStringRandom(8));// 随机激活码
		user.setState(0);// 初始状态是0 ，0表示未激活

		System.out.println(user);

		// User信息插入到数据库中
		UserDao userDao = new UserDao();
		if (userDao.insert(user) > 0) {
			response.getWriter().append("注册成功，请登录邮箱激活账号！");
			// 发送邮件
			String mailText = "<html><head></head><body><h1>这是一封激活邮件,激活请点击以下链接</h1><h3><a href='http://localhost:8080/tool/ActivationServlet?code="
					+ user.getCode() + "'>http://localhost:8080/tool/ActivationServlet?code=" + user.getCode()
					+ "</href></h3></body></html>";
			SendEmail.Send("发送邮件的邮箱账户", "发送邮件的邮箱密码", user.getEmail(), "备注", "发件人昵称", "主题", mailText);
		} else {
			response.getWriter().append("注册失败，请检查相关信息！");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
