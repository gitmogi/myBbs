package com.bit.bbs.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.bbs.model.BbsDao;

public class AddController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin","*");
		String param1 = req.getParameter("id");
		String param2 = req.getParameter("date");
		String param3 = req.getParameter("title");
		String param4 = req.getParameter("contents");
		
		String id = param1.trim();
		String date = param2.trim();
		String title = param3.trim();
		String contents = param4.trim();
		
		BbsDao dao = new BbsDao();
		if (dao.insertOne(id, date, title, contents)>0) {
			resp.setStatus(201);
		} else {
			resp.setStatus(400);
		}
	}
}
