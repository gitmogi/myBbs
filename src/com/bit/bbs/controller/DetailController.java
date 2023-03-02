package com.bit.bbs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.bbs.model.BbsDao;
import com.bit.bbs.model.BbsDto;

public class DetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin","*");
		resp.setContentType("text/html;charset=UTF-8");
		int num=Integer.parseInt(req.getParameter("num"));
		BbsDao dao=new BbsDao();
		BbsDto bean=dao.getOne(num);
		PrintWriter out = resp.getWriter();
		try {
			out.println("{\"bbs\":[");
			out.println("{\"num\":"+bean.getNum()
					+",\"id\":\""+bean.getId()
					+"\",\"title\":\""+bean.getTitle()
					+"\",\"contents\":\""+bean.getContents()
					+"\",\"date\":\""+bean.getDate()+"\"}");
			out.println("]}");
		}finally {
			if(out!=null)out.close();
		}
	}
}
