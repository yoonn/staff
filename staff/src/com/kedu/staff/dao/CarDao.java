package com.kedu.staff.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kedu.common.DBManager;
import com.kedu.staff.dto.CarDto;

public class CarDao {

	public CarDao() {
	}
	
	private static CarDao instance = new CarDao();
	
	public static CarDao getInstance(){
		return instance;
	}
	
	public void insertCar(CarDto cDto){
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO EMP_CAREER( emp_no					");
		sql.append("					  , emp_career_seq			");
		sql.append("                	  , corp_nm					");
		sql.append("                	  , dept_nm					");
		sql.append("                	  , rank_nm					");
		sql.append("                	  , emp_role				");
		sql.append("                	  , enter_dt				");
		sql.append("                	  , retire_dt				");
		sql.append("                	  , certificate_img_path	");
		sql.append("                	  , emp_sal					");
		sql.append("                  	  )							");
		sql.append("			   VALUES ( ?						");
		sql.append("         		  	  , EMP_CAREER_SEQ.NEXTVAL	");
		sql.append("               		  , ?						");
		sql.append("               		  , ?						");
		sql.append("               		  , ?						");
		sql.append("               		  , ?						");
		sql.append("               		  , ?						");
		sql.append("               		  , ?						");
		sql.append("               		  , ?						");
		sql.append("               		  , ?						");
		sql.append("               		  )							");

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, cDto.getEmp_no());
			pstmt.setString(2, cDto.getCorp_nm());
			pstmt.setString(3, cDto.getDept_nm());
			pstmt.setString(4, cDto.getRank_nm());
			pstmt.setString(5, cDto.getEmp_role());
			pstmt.setDate(6, cDto.getEnter_dt());
			pstmt.setDate(7, cDto.getRetire_dt());
			pstmt.setString(8, cDto.getCertificate_img_path());
			pstmt.setInt(9, cDto.getEmp_sal());
			
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
		
	}
	
	public String selectSeqbyCorpNm(String corp_nm){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT emp_career_seq	");
		sql.append("  FROM EMP_CAREER		");
		sql.append(" WHERE corp_nm = ?		");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String result = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, corp_nm);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				result = rs.getString(1);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		
		return result;
	}
}
