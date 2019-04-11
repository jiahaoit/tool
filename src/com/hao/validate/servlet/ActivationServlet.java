package com.hao.validate.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hao.validate.dao.UserDao;

/**
 * Servlet 用于接收激活信息
 */
@WebServlet("/ActivationServlet")
public class ActivationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ActivationServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置请求和响应编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String code = request.getParameter("code");
		UserDao userDao = new UserDao();
		if (userDao.activation(code) > 0) {
			response.getWriter().append("恭喜您，激活成功！");
		} else {
			response.getWriter().append("激活失败，请检查邮箱！");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
