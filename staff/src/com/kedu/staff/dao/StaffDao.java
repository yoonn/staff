package com.kedu.staff.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kedu.common.DBManager;
import com.kedu.staff.dto.StaffDto;

public class StaffDao {
	
	public StaffDao() {
	}
	
	private static StaffDao instance = new StaffDao();
	
	public static StaffDao getInstance(){
		return instance;
	}
	
	public int userCheck(String emp_id, String emp_pwd, int notice_mgr){
		int result = -1;
		
		StringBuilder sql = new StringBuilder();
		sql.append("select emp_pwd 		");
		sql.append("     , notice_mgr	");
		sql.append("  from emp			");
		sql.append(" where emp_id = ?	");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, emp_id);
			rs = pstmt.executeQuery();
			
			System.out.println("emp_id:"+emp_id
								+", emp_pwd:"+emp_pwd
								+", notice_mgr:"+notice_mgr);
						
			if(rs.next()){
				if(rs.getString("emp_pwd")!=null && rs.getString("emp_pwd").equals(emp_pwd)){
					if(rs.getInt("notice_mgr")==0 && rs.getInt("notice_mgr")==notice_mgr){
						result = 3;
					}else if(rs.getInt("notice_mgr")==1 && rs.getInt("notice_mgr")==notice_mgr){
						result = 2;
					}else{
						result = 1;
					}
				} else {
					result = 0;
				}
			}else{
				result = -1;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	public StaffDto getStaff(String emp_id){
		StaffDto sDto = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("select *			");
		sql.append("  from emp			");
		sql.append(" where emp_id = ?	");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, emp_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				sDto = new StaffDto();
				
				sDto.setEmp_no(rs.getString("emp_no"));
				sDto.setDept_no(rs.getString("dept_no"));
				sDto.setRank_no(rs.getString("rank_no"));
				sDto.setEmp_sal(rs.getDouble("emp_sal"));
				sDto.setEmp_nm(rs.getString("emp_nm"));
				sDto.setEmp_id(rs.getString("emp_id"));
				sDto.setEmp_pwd(rs.getString("emp_pwd"));
				sDto.setRes_no(rs.getDouble("res_no"));
				sDto.setZipcode(rs.getString("zipcode"));
				sDto.setEmp_addr(rs.getString("emp_addr"));
				sDto.setEmp_detail_addr(rs.getString("emp_detail_addr"));
				sDto.setEmp_mobile(rs.getDouble("emp_mobile"));
				sDto.setEmp_office(rs.getDouble("emp_office"));
				sDto.setEnter_dt(rs.getDate("enter_dt"));
				sDto.setRetire_dt(rs.getDate("retire_dt"));
				sDto.setRes_dt(rs.getDate("res_dt"));
				sDto.setRes_emp(rs.getString("res_emp"));
				sDto.setUpdate_dt(rs.getDate("update_dt"));
				sDto.setUpdate_emp(rs.getString("update_emp"));
				sDto.setNotice_mgr(rs.getInt("notice_mgr"));
				sDto.setFile_save_url(rs.getString("file_save_url"));
				sDto.setFile_request_url(rs.getString("file_request_url"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return sDto;
	}
	
	public int insertStaff(StaffDto sDto){
		StringBuilder sql = new StringBuilder();
		sql.append("		INSERT INTO EMP ( emp_no	");
		sql.append("				, dept_no			");
		sql.append("                , rank_no			");
		sql.append("                , emp_sal			");
		sql.append("                , emp_nm			");
		sql.append("                , emp_id			");
		sql.append("                , emp_pwd			");
		sql.append("                , res_no			");
		sql.append("                , ZIPCODE			");
		sql.append("                , emp_addr			");
		sql.append("                , emp_detail_addr	");
		sql.append("                , emp_mobile		");
		sql.append("                , emp_office		");
		sql.append("                , enter_dt			");
		sql.append("                , res_dt			");
		sql.append("                , res_emp			");
		sql.append("                , notice_mgr		");
		sql.append("                , file_save_url		");
		sql.append("                , file_request_url	");
		sql.append("                )					");
		sql.append("		 VALUES ( emp_no_create_fn	");
		sql.append("         		, ?					");
		sql.append("         		, ?					");
		sql.append("         		, ?					");
		sql.append("                , ?					");
		sql.append("                , ?					");
		sql.append("                , ?					");
		sql.append("                , ?					");
		sql.append("                , ?					");
		sql.append("                , ?					");
		sql.append("                , ?					");
		sql.append("                , ?					");
		sql.append("                , ?					");
		sql.append("                , ?					");
		sql.append("                , ?					");
		sql.append("                , ?					");
		sql.append("                , ?					");
		sql.append("                , ?					");
		sql.append("                , ?					");
		sql.append("                )					");

		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, sDto.getDept_no());
			pstmt.setString(2, sDto.getRank_no());
			pstmt.setDouble(3, sDto.getEmp_sal());
			pstmt.setString(4, sDto.getEmp_nm());
			pstmt.setString(5, sDto.getEmp_id());
			pstmt.setString(6, sDto.getEmp_pwd());
			pstmt.setDouble(7, sDto.getRes_no());
			pstmt.setString(8, sDto.getZipcode());
			pstmt.setString(9, sDto.getEmp_addr());
			pstmt.setString(10, sDto.getEmp_detail_addr());
			pstmt.setDouble(11, sDto.getEmp_mobile());
			pstmt.setDouble(12, sDto.getEmp_office());
			pstmt.setDate(13, sDto.getEnter_dt());
			pstmt.setDate(14, sDto.getRes_dt());
			pstmt.setString(15, sDto.getRes_emp());
			pstmt.setInt(16, sDto.getNotice_mgr());
			pstmt.setString(17, sDto.getFile_save_url());
			pstmt.setString(18, sDto.getFile_request_url());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
		
		return result;
		
	}
	
	public void updatePicture(String emp_no, String path, String file_name){
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE EMP					");
		/*sql.append("   SET FILE_SAVE_URL    = ?	"); // FILE_SAVE_URL
*/		sql.append("   SET FILE_REQUEST_URL = ?	"); // FILE_REQUEST_URL
		sql.append(" WHERE EMP_NO 			= ?	");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
//			pstmt.setString(1, path);
			pstmt.setString(1, file_name);
			pstmt.setString(2, emp_no);
			
			System.out.println("path : " + path + ", file_name : " + file_name + ", emp_no : " + emp_no);
			
			result = pstmt.executeUpdate();
			
			System.out.println("result : " + result);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
	}
	
	
	public String getEmpNo(String emp_id){
		
		String result = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT emp_no		");
		sql.append("  FROM EMP			");
		sql.append(" WHERE emp_id = ?	");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, emp_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				result = rs.getString("emp_no");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		
		return result;
		
	}
	
	public int selectIdCheck(String emp_id){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT emp_no		");
		sql.append("  FROM EMP			");
		sql.append(" WHERE emp_id = ?	");

//		동일한 id가 없으면 0
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn  = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, emp_id);
			rs = pstmt.executeQuery();
			
//			동일한 id가 있으면 1
			if(rs.next()){
				result = 1;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	/////////////////////////////////////////////////////
	
	public List<StaffDto> selectAllStaff(String cPage){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT emp_no										");
		sql.append("	 , emp_nm										");
		sql.append("	 , dept_no										");
		sql.append("	 , rank_no										");
		sql.append("	 , enter_dt										");
		sql.append("  FROM (											");
		sql.append("  		SELECT ROWNUM r								");
		sql.append("             , a.*									");
		sql.append("          FROM (									");
		sql.append("          		SELECT emp_no						");
		sql.append("					 , emp_nm						");
		sql.append("					 , dept_no						");
		sql.append("					 , rank_no						");
		sql.append("					 , enter_dt						");
		sql.append("          		  FROM emp							");
		sql.append("                 ORDER BY emp_no DESC				");
		sql.append("               ) a									");
		sql.append("  	   )											");
		sql.append(" WHERE r BETWEEN ? AND ?							");

		int curPage = (cPage == null) ? 1 : Integer.parseInt(cPage);
		
		int start = (curPage -1) * 10 + 1;
		int end	  = start + 10 - 1;
		
		List<StaffDto> list = new ArrayList<StaffDto>();
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
				StaffDto sDto = new StaffDto();
				
				sDto.setEmp_no(rs.getString("emp_no"));
				sDto.setEmp_nm(rs.getString("emp_nm"));
				sDto.setDept_no(rs.getString("dept_no"));
				sDto.setRank_no(rs.getString("rank_no"));
				sDto.setEnter_dt(rs.getDate("enter_dt"));
				
				list.add(sDto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public int totalStaff(){
		int totalNotice = 0;
		
		StringBuilder sql = new StringBuilder();
		sql.append("select count(*)	as cnt	");
		sql.append("  from emp		");
		
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
	
	public List<StaffDto> selectSearchStaff(String cPage, String search_type, String keyword){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT emp_no										");
		sql.append("	 , emp_nm										");
		sql.append("	 , dept_no										");
		sql.append("	 , rank_no										");
		sql.append("	 , enter_dt										");
		sql.append("  FROM (											");
		sql.append("  		SELECT ROWNUM r								");
		sql.append("             , a.*									");
		sql.append("          FROM (									");
		sql.append("          		SELECT emp_no						");
		sql.append("					 , emp_nm						");
		sql.append("					 , dept_no						");
		sql.append("					 , rank_no						");
		sql.append("					 , enter_dt						");
		sql.append("          		  FROM emp							");
		if(search_type.equals("emp_no")){
			sql.append("          	 where emp_no  like '%'|| ?	||'%'	");
		}else if(search_type.equals("emp_nm")){
			sql.append("          	 where emp_nm  like '%'|| ? ||'%'	");
		}else if(search_type.equals("dept_no")){
			sql.append("          	 where dept_no like '%'|| ? ||'%'	");
		}else if(search_type.equals("rank_no")){
			sql.append("          	 where rank_no like '%'|| ? ||'%'	");
		}
		sql.append("                 ORDER BY emp_no DESC				");
		sql.append("               ) a									");
		sql.append("  	   )											");
		sql.append(" WHERE r BETWEEN ? AND ?							");

		int curPage = (cPage == null) ? 1 : Integer.parseInt(cPage);
		
		int start = (curPage -1) * 10 + 1;
		int end	  = start + 10 - 1;
		
		List<StaffDto> list = new ArrayList<StaffDto>();
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
				StaffDto sDto = new StaffDto();
				
				sDto.setEmp_no(rs.getString("emp_no"));
				sDto.setEmp_nm(rs.getString("emp_nm"));
				sDto.setDept_no(rs.getString("dept_no"));
				sDto.setRank_no(rs.getString("rank_no"));
				sDto.setEnter_dt(rs.getDate("enter_dt"));
				
				list.add(sDto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public int cntSearchStaff(String search_type, String keyword){
		int totalStaff = 0;
		
		StringBuilder sql = new StringBuilder();
		sql.append("	select count(*)	as cnt				");
		sql.append(" 	  from emp							");
		if(search_type.equals("emp_no")){
			sql.append(" where emp_no  like '%'|| ?	||'%'	");
		}else if(search_type.equals("emp_nm")){
			sql.append(" where emp_nm  like '%'|| ? ||'%'	");
		}else if(search_type.equals("dept_no")){
			sql.append(" where dept_no like '%'|| ? ||'%'	");
		}else if(search_type.equals("rank_no")){
			sql.append(" where rank_no like '%'|| ? ||'%'	");
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
				totalStaff = rs.getInt("cnt");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		
		return totalStaff;
	}
	
	
}






























