package com.bit.bbs.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.bbs.model.BbsDao;

public class EditController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin","*");
		String param1 = req.getParameter("num");
		String param2 = req.getParameter("title");
		String param3 = req.getParameter("contents");
		
		int num = Integer.parseInt(param1.trim());
		String title = param2.trim();
		String contents = param3.trim();
		
		BbsDao dao = new BbsDao();
		if(dao.editOne(num, title, contents)>0) {
			resp.setStatus(201);
		} else {
			resp.setStatus(400);
		}
	}
}
