package com.bit.bbs.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bit.util.BitSql;

public class BbsDao {
	Connection conn;
	   Statement stmt;
	   ResultSet rs;
	   
	   public BbsDto getOne(int num) {
		   String sql="select * from bbs where num="+num;
		   BbsDto bean=new BbsDto();
		   try {
			   conn=BitSql.getConnection();
			   stmt=conn.createStatement();
			   rs=stmt.executeQuery(sql);
			   if(rs.next()) {
				   bean.setNum(rs.getInt("num"));
					bean.setId(rs.getString("id"));
					bean.setTitle(rs.getString("title"));
					bean.setContents(rs.getString("contents"));
					bean.setDate(rs.getDate("date"));
			   }
		   } catch (SQLException e) {
			e.printStackTrace();
		}finally {
			   try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		   }
		   return bean;
	   }
	   
	   public int insertOne(String id,String date,String title,String contents) {
	      String sql = "insert into bbs (num,id,date,title,contents) values (0,'";
	      sql+=id+"',now(),'"+title+"','"+contents+"')";
	      
	      try {
	         conn = BitSql.getConnection();
	         stmt = conn.createStatement();
	         return stmt.executeUpdate(sql);
	      } catch (SQLException e) {
	         e.printStackTrace();
	         return 0;
	      } finally {
	         try {
	            if(stmt!=null) stmt.close();
	            if(conn!=null)conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	   }
	   
	   public int editOne(int num, String title, String contents) {
		   String sql = "update bbs set title='"+title+"',contents='";
		   sql+=contents+"' where num="+num;
		   
		   try {
		         conn = BitSql.getConnection();
		         stmt = conn.createStatement();
		         return stmt.executeUpdate(sql);
		      } catch (SQLException e) {
		         e.printStackTrace();
		         return 0;
		      } finally {
		         try {
		            if(stmt!=null) stmt.close();
		            if(conn!=null)conn.close();
		         } catch (SQLException e) {
		            e.printStackTrace();
		         }
		      }
	   }
	   
	   public int deleteOne(int num) {
		   String sql = "delete from bbs where num="+num;
		   
		   try {
		         conn = BitSql.getConnection();
		         stmt = conn.createStatement();
		         return stmt.executeUpdate(sql);
		      } catch (SQLException e) {
		         e.printStackTrace();
		         return 0;
		      } finally {
		         try {
		            if(stmt!=null) stmt.close();
		            if(conn!=null)conn.close();
		         } catch (SQLException e) {
		            e.printStackTrace();
		         }
		      }
	   }

	   public List<BbsDto> getList(){
	      String sql = "select * from bbs order by num desc";
	      List<BbsDto> list = new ArrayList<BbsDto>();
	      try {
	         conn = BitSql.getConnection();
	         stmt = conn.createStatement();
	         rs = stmt.executeQuery(sql);
	         while(rs.next()) {
	            BbsDto bean = new BbsDto();
	            bean.setNum(rs.getInt("num"));
				bean.setTitle(rs.getString("title"));
				bean.setId(rs.getString("id"));
				bean.setDate(rs.getDate("date"));
	            list.add(bean);
	         }
	      }catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	            try {
	               if(rs!=null)rs.close();
	               if(stmt!=null)stmt.close();
	               if(conn!=null)conn.close();
	            } catch (SQLException e) {
	               e.printStackTrace();
	            }
	      }
	      return list;
	   }
}
