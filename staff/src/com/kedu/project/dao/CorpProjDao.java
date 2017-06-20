package com.kedu.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kedu.common.DBManager;
import com.kedu.project.dto.CorpProjDto;

public class CorpProjDao {
	
	public CorpProjDao() {
	}
	
	private static CorpProjDao instance = new CorpProjDao();
	
	public static CorpProjDao getInstance(){
		return instance;
	}
	
	public void insertCorpProj(CorpProjDto cpDto){
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO CORP_PROJ( proj_no				");
		sql.append("			  		 , proj_nm				");
		sql.append("			  		 , client				");
		/*sql.append("			  		 , price				");*/
		sql.append("			  		 , proj_content			");
		sql.append("			  		 , res_dt				");
		sql.append("			  		 , res_emp				");
		sql.append("			  		 , start_dt				");
		sql.append("			  		 , end_dt				");
		sql.append("			  		 )						");
		sql.append("			   VALUES( corpProj_seq.nextval	");
		sql.append("			  		 , ?					");
		sql.append("	         		 , ?					");
		/*sql.append("	         		 , ?					");*/
		sql.append("	         		 , ?					");
		sql.append("	         		 , SYSDATE				");
		sql.append("	         		 , ?					");
		sql.append("	         		 , ?					");
		sql.append("	         		 , ?					");
		sql.append("	         		 )						");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, cpDto.getProj_nm());
			pstmt.setString(2, cpDto.getClient());
			/*pstmt.setInt(3, cpDto.getPrice());*/
			pstmt.setString(3, cpDto.getProj_content());
			pstmt.setString(4, cpDto.getRes_emp());
			pstmt.setDate(5, cpDto.getStart_dt());
			pstmt.setDate(6, cpDto.getEnd_dt());
			
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}

	}
	
	public List<CorpProjDto> selectAllCorpProj(String cPage){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT proj_no							");
		sql.append("	 , proj_nm							");
		sql.append("	 , res_dt							");
		sql.append("	 , res_emp							");
		sql.append("  FROM (								");
		sql.append("  		SELECT ROWNUM r					");
		sql.append("             , a.*						");
		sql.append("          FROM (						");
		sql.append("          		SELECT proj_no			");
		sql.append("					 , proj_nm			");
		sql.append("					 , res_dt			");
		sql.append("					 , res_emp			");
		sql.append("          		  FROM corp_proj		");
		sql.append("                 ORDER BY proj_no DESC	");
		sql.append("               ) a						");
		sql.append("  	   )								");
		sql.append(" WHERE r BETWEEN ? AND ?				");

		int curPage = (cPage == null) ? 1 : Integer.parseInt(cPage);
		
		int start = (curPage -1) * 10 + 1;
		int end	  = start + 10 - 1;
		
		List<CorpProjDto> list = new ArrayList<CorpProjDto>();
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
				CorpProjDto cpDto = new CorpProjDto();
				
				cpDto.setProj_no(rs.getString("proj_no"));
				cpDto.setProj_nm(rs.getString("proj_nm"));
				cpDto.setRes_dt(rs.getDate("res_dt"));
				cpDto.setRes_emp(rs.getString("res_emp"));
				
				list.add(cpDto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public int totalCorpProj(){
		int totalCorpProj = 0;
		
		StringBuilder sql = new StringBuilder();
		sql.append("select count(*)	as cnt	");
		sql.append("  from corp_proj		");
		
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		
		try{
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql.toString());
			if(rs.next()){
				totalCorpProj = rs.getInt("cnt");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, stmt, rs);
		}
		
		return totalCorpProj;
	}
	
	public List<CorpProjDto> selectSearchCorpProj(String cPage, String search_type, String keyword){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT proj_no										");
		sql.append("	 , proj_nm										");
		sql.append("	 , res_dt										");
		sql.append("	 , res_emp										");
		sql.append("  FROM (											");
		sql.append("  		SELECT ROWNUM r								");
		sql.append("             , a.*									");
		sql.append("          FROM (									");
		sql.append("          		SELECT proj_no						");
		sql.append("					 , proj_nm						");
		sql.append("					 , res_dt						");
		sql.append("					 , res_emp						");
		sql.append("          		  FROM corp_proj					");
		if(search_type.equals("proj_nm")){
			sql.append("          	 where proj_nm like '%'|| ?	||'%'	");
		}else if(search_type.equals("res_emp")){
			sql.append("          	 where res_emp like '%'|| ? ||'%'	");
		}else if(search_type.equals("proj_no")){
			sql.append("          	 where proj_no like '%'|| ? ||'%'	");
		}
		sql.append("                 ORDER BY proj_no DESC				");
		sql.append("               ) a									");
		sql.append("  	   )											");
		sql.append(" WHERE r BETWEEN ? AND ?							");

		int curPage = (cPage == null) ? 1 : Integer.parseInt(cPage);
		
		int start = (curPage -1) * 10 + 1;
		int end	  = start + 10 - 1;
		
		List<CorpProjDto> list = new ArrayList<CorpProjDto>();
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
				CorpProjDto cpDto = new CorpProjDto();
				
				cpDto.setProj_no(rs.getString("proj_no"));
				cpDto.setProj_nm(rs.getString("proj_nm"));
				cpDto.setRes_dt(rs.getDate("res_dt"));
				cpDto.setRes_emp(rs.getString("res_emp"));
				
				list.add(cpDto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public int cntSearchCorpProj(String search_type, String keyword){
		int totalCorpProj = 0;
		
		StringBuilder sql = new StringBuilder();
		sql.append("	select count(*)	as cnt				");
		sql.append(" 	  from corp_proj					");
		if(search_type.equals("proj_nm")){
			sql.append(" where proj_nm like '%'|| ?	||'%'	");
		}else if(search_type.equals("res_emp")){
			sql.append(" where res_emp like '%'|| ? ||'%'	");
		}else if(search_type.equals("proj_no")){
			sql.append(" where proj_no like '%'|| ? ||'%'	");
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
				totalCorpProj = rs.getInt("cnt");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		
		return totalCorpProj;
	}
	
	public CorpProjDto selectOneCorpProjByNum(String proj_no){
		StringBuilder sql = new StringBuilder();
		sql.append("select *			");
		sql.append("  from corp_proj	");
		sql.append(" where proj_no = ?	");
		
		CorpProjDto cpDto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, proj_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				cpDto  = new CorpProjDto();
				
				cpDto.setProj_no(proj_no);
				cpDto.setProj_nm(rs.getString("proj_nm"));
				cpDto.setClient(rs.getString("client"));
				cpDto.setPrice(rs.getInt("price"));
				cpDto.setProj_content(rs.getString("proj_content"));
				cpDto.setRes_dt(rs.getDate("res_dt"));
				cpDto.setRes_emp(rs.getString("res_emp"));
				cpDto.setStart_dt(rs.getDate("start_dt"));
				cpDto.setEnd_dt(rs.getDate("end_dt"));
				cpDto.setUpdate_emp(rs.getString("update_emp"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		
		return cpDto;
	}
	
	public void deleteCorpProj(String proj_no){
		StringBuilder sql = new StringBuilder();
		sql.append("delete corp_proj	");
		sql.append(" where proj_no = ?	");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, proj_no);
			
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
	}
	
	public void updateCorpProj(CorpProjDto cpDto){
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE CORP_PROJ		");
		sql.append("   SET proj_nm 		= ?	");
		sql.append("     , client 		= ?	");
		sql.append("     , proj_content = ?	");
		sql.append("     , start_dt		= ?	");
		sql.append("     , end_dt 		= ?	");
		sql.append("     , update_emp 	= ?	");
		sql.append("     , update_dt 	= ?	");
		sql.append(" WHERE proj_no 		= ?	");
				
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, cpDto.getProj_nm());
			pstmt.setString(2, cpDto.getClient());
			pstmt.setString(3, cpDto.getProj_content());
			pstmt.setDate(4, cpDto.getStart_dt());
			pstmt.setDate(5, cpDto.getEnd_dt());
			pstmt.setString(6, cpDto.getUpdate_emp());
			pstmt.setDate(7, cpDto.getUpdate_dt());
			pstmt.setString(8, cpDto.getProj_no());
			
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}

	}
	
}
