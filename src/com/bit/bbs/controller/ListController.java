package com.bit.bbs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.bbs.model.BbsDao;
import com.bit.bbs.model.BbsDto;

public class ListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin","*");
		resp.setContentType("text/html;charset=UTF-8");
		BbsDao dao=new BbsDao();
		PrintWriter out = resp.getWriter();
		try {
			out.println("{\"bbs\":[");
			List<BbsDto> list=dao.getList();
			for(int i=0; i<list.size(); i++) {
				BbsDto bean=list.get(i);
				if(i!=0)out.print(",");
				out.println("{\"num\":"+bean.getNum()
						+",\"title\":\""+bean.getTitle()
						+"\",\"id\":\""+bean.getId()
						+"\",\"date\":\""+bean.getDate()+"\"}");
			}
			out.println("]}");
		}finally {
			if(out!=null)out.close();
		}
	}
}
