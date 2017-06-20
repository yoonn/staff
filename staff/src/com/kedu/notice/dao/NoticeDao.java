package com.kedu.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kedu.common.DBManager;
import com.kedu.notice.dto.NoticeDto;

public class NoticeDao {

	public NoticeDao() {
	}
	
	private static NoticeDao instance = new NoticeDao();
	
	public static NoticeDao getInstance(){
		return instance;
	}
	
	public List<NoticeDto> selectAllNotices(String cPage){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT *									");
		sql.append("  FROM (									");
		sql.append("  		SELECT ROWNUM r						");
		sql.append("             , a.*							");
		sql.append("          FROM (							");
		sql.append("          		SELECT *					");
		sql.append("          		  FROM NOTICE				");
		sql.append("                 ORDER BY notice_no DESC 	");
		sql.append("               ) a							");
		sql.append("  	   )									");
		sql.append(" WHERE r BETWEEN ? AND ?					");

		int curPage = (cPage == null) ? 1 : Integer.parseInt(cPage);
		
		int start = (curPage -1) * 10 + 1;
		int end	  = start + 10 - 1;
		
		List<NoticeDto> list = new ArrayList<NoticeDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet  rs	= null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs   = pstmt.executeQuery();
			
			while(rs.next()){
				NoticeDto nDto = new NoticeDto();
				
				nDto.setNotice_no(rs.getString("notice_no"));
				nDto.setNotice_title(rs.getString("notice_title"));
				nDto.setNotice_content(rs.getString("notice_content"));
				nDto.setEmp_id(rs.getString("emp_id"));
				nDto.setRes_dt(rs.getDate("res_dt"));
				nDto.setUpdate_dt(rs.getDate("update_dt"));
				nDto.setReadcount(rs.getInt("readcount"));
				
				list.add(nDto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public int totalNotice(){
		int totalNotice = 0;
		
		StringBuilder sql = new StringBuilder();
		sql.append("select count(*)	as cnt	");
		sql.append("  from notice			");
		
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		
		try{
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql.toString());
			if(rs.next()){
				totalNotice = rs.getInt("cnt");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, stmt, rs);
		}
		
		return totalNotice;
	}
	
	
	public List<NoticeDto> selectSearchNotices(String cPage, String search_type, String keyword){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT *												");
		sql.append("  FROM (												");
		sql.append("  		SELECT ROWNUM r									");
		sql.append("             , a.*										");
		sql.append("          FROM (										");
		sql.append("          		SELECT *								");
		sql.append("          		  FROM NOTICE							");
		if(search_type.equals("emp_id")){
			sql.append("          	 where emp_id 		like '%'|| ? ||'%'	");
		}else if(search_type.equals("notice_title")){
			sql.append("          	 where notice_title like '%'|| ? ||'%'	");
		}
		sql.append("                 ORDER BY notice_no DESC 				");
		sql.append("               ) a										");
		sql.append("  	   )												");
		sql.append(" WHERE r BETWEEN ? AND ?								");

		int curPage = (cPage == null) ? 1 : Integer.parseInt(cPage);
		
		int start = (curPage -1) * 10 + 1;
		int end	  = start + 10 - 1;
		
		List<NoticeDto> list = new ArrayList<NoticeDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet  rs	= null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, keyword);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs   = pstmt.executeQuery();
			
			while(rs.next()){
				NoticeDto nDto = new NoticeDto();
				
				nDto.setNotice_no(rs.getString("notice_no"));
				nDto.setNotice_title(rs.getString("notice_title"));
				nDto.setNotice_content(rs.getString("notice_content"));
				nDto.setEmp_id(rs.getString("emp_id"));
				nDto.setRes_dt(rs.getDate("res_dt"));
				nDto.setUpdate_dt(rs.getDate("update_dt"));
				nDto.setReadcount(rs.getInt("readcount"));
				
				list.add(nDto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public int cntSearchNotice(String search_type, String keyword){
		int totalNotice = 0;
		
		StringBuilder sql = new StringBuilder();
		sql.append("	select count(*)	as cnt					");
		sql.append("  	  from notice							");
		if(search_type.equals("emp_id")){
			sql.append(" where emp_id		like '%'|| ? ||'%'	");
		}else if(search_type.equals("notice_title")){
			sql.append(" where notice_title like '%'|| ? ||'%'	");
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet  rs   = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, keyword);
			rs = pstmt.executeQuery();
			if(rs.next()){
				totalNotice = rs.getInt("cnt");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		
		return totalNotice;
	}
	
	
	public void insertNotice(NoticeDto nDto){
		StringBuilder sql = new StringBuilder();
		sql.append("insert into notice( notice_no			");
		sql.append("				  , notice_title		");
		sql.append("				  , notice_content		");
		sql.append("				  , emp_id				");
		sql.append("				  , res_dt				");
		sql.append("				  )						");
		sql.append("			values(notice_seq.nextval	");
		sql.append("				 , ?					");
		sql.append("				 , ?					");
		sql.append("				 , ?					");
		sql.append("				 , sysdate				");
		sql.append("				  )						");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, nDto.getNotice_title());
			pstmt.setString(2, nDto.getNotice_content());
			pstmt.setString(3, nDto.getEmp_id());
			
			pstmt.executeQuery();
					
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
	}
	
	public void updateReadCount(String notice_no){
		StringBuilder sql = new StringBuilder();
		sql.append("update notice						");
		sql.append("   set readcount = readcount + 1	");
		sql.append(" where notice_no = ?				");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, notice_no);
			
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
	}
	
	public NoticeDto selectOneNoticeByNum(String notice_no){
		StringBuilder sql = new StringBuilder();
		sql.append("select *				");
		sql.append("  from notice			");
		sql.append(" where notice_no = ?	");
		
		NoticeDto nDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, notice_no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				nDto = new NoticeDto();
				
				nDto.setNotice_no(rs.getString("notice_no"));
				nDto.setNotice_title(rs.getString("notice_title"));
				nDto.setNotice_content(rs.getString("notice_content"));
				nDto.setEmp_id(rs.getString("emp_id"));
				nDto.setRes_dt(rs.getDate("res_dt"));
				nDto.setUpdate_dt(rs.getDate("update_dt"));
				nDto.setReadcount(rs.getInt("readcount"));				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return nDto;
	}
	
	public void updateNotice(NoticeDto nDto){
		StringBuilder sql = new StringBuilder();
		sql.append("update notice						");
		sql.append("   set notice_title		= ?			");
		sql.append("     , notice_content 	= ?			");
		sql.append("     , emp_id 			= ?			");
		sql.append("     , update_dt 		= sysdate	");
		sql.append(" where notice_no		= ?			");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, nDto.getNotice_title());
			pstmt.setString(2, nDto.getNotice_content());
			pstmt.setString(3, nDto.getEmp_id());
			pstmt.setString(4, nDto.getNotice_no());
						
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
	}
	
	/*public NoticeDto checkPassWord(String pass, String num){
		StringBuilder sql = new StringBuilder();
		sql.append("select *		");
		sql.append("  from notice	");
		sql.append(" where pass = ?	");
		sql.append("   and num  = ?	");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoticeDto nDto = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, pass);
			pstmt.setInt(2, Integer.parseInt(num));
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				nDto = new NoticeDto();
				
				nDto.setNum(rs.getInt("num"));
				nDto.setName(rs.getString("name"));
				nDto.setEmail(rs.getString("email"));
				nDto.setPass(rs.getString("pass"));
				nDto.setTitle(rs.getString("title"));
				nDto.setContent(rs.getString("content"));
				nDto.setReadcount(rs.getInt("readcount"));
				nDto.setWritedate(rs.getTimestamp("writedate"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
		return nDto;
	}*/
	
	public void deleteNotice(String notice_no){
		StringBuilder sql = new StringBuilder();
		sql.append("delete notice			");
		sql.append(" where notice_no = ?	");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, notice_no);
			
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
	}
	
	
	
}
