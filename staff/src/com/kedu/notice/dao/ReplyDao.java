package com.kedu.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kedu.common.DBManager;
import com.kedu.notice.dto.ReplyDto;

public class ReplyDao {

	public ReplyDao() {
	}
	
	private static ReplyDao instance = new ReplyDao();
	
	public static ReplyDao getInstance(){
		return instance;
	}
	
	public List<ReplyDto> selectNoticeReply(String notice_no){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT *				");
		sql.append("  FROM REPLY			");
		sql.append(" WHERE notice_no = ?	");
		sql.append(" ORDER BY reply_dt ASC	");
		
		List<ReplyDto> list = new ArrayList<ReplyDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, notice_no);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				ReplyDto rDto = new ReplyDto();
				
				rDto.setEmp_id(rs.getString("emp_id"));
				rDto.setReply_dt(rs.getTimestamp("reply_dt"));
				rDto.setReply_content(rs.getString("reply_content"));
				rDto.setNotice_no(rs.getString("notice_no"));
				rDto.setReply_no(rs.getString("reply_no"));
				
				list.add(rDto);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
		
	}
	
	public void insertNoticeReply(ReplyDto rDto){
		StringBuilder sql = new StringBuilder();
		sql.append("insert into reply( reply_no				");
		sql.append("			     , notice_no			");
		sql.append("			     , emp_id				");
		sql.append("			     , reply_content		");
		sql.append("			     )						");
		sql.append("		   values( reply_seq.nextval	");
		sql.append("				 , ?					");
		sql.append("				 , ?					");
		sql.append("				 , ?					");
		sql.append("				 )						");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, rDto.getNotice_no());
			pstmt.setString(2, rDto.getEmp_id());
			pstmt.setString(3, rDto.getReply_content());
			
			pstmt.executeQuery();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
		
	}
	
	public void deleteNoticeReply(String reply_no){
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM REPLY	");
		sql.append(" WHERE reply_no = ?	");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn  = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, reply_no);
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
		
	}
}
