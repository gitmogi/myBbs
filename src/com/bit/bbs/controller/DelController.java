package com.bit.bbs.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.bbs.model.BbsDao;

public class DelController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin","*");
		int num=Integer.parseInt(req.getParameter("num"));
		BbsDao dao=new BbsDao();
		if(dao.deleteOne(num)==0) resp.setStatus(resp.SC_BAD_REQUEST);
	}
}
