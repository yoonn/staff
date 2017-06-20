package com.kedu.staff.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.kedu.common.DBManager;
import com.kedu.staff.dto.LicDto;

public class LicDao {
	
	public LicDao() {
	}
	
	private static LicDao instance = new LicDao();
	
	public static LicDao getInstance(){
		return instance;
	}
	
	public void insertLic(LicDto lDto){
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO EMP_LIC( emp_no					");
		sql.append("				   , lic_seq				");
		sql.append("               	   , lic_nm					");
		sql.append("                   , lic_no					");
		sql.append("                   , institution			");
		sql.append("                   , get_dt					");
		sql.append("                   , expiration_dt			");
		sql.append("                   , certificate_img_path	");
		sql.append("                   )						");
		sql.append("             VALUES( ?						");
		sql.append("                   , LIC_SEQ.NEXTVAL		");
		sql.append("                   , ?						");
		sql.append("                   , ?						");
		sql.append("                   , ?						");
		sql.append("                   , ?						");
		sql.append("                   , ?						");
		sql.append("                   , ?						");
		sql.append("                   )						");

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, lDto.getEmp_no());
			pstmt.setString(2, lDto.getLic_nm());
			pstmt.setString(3, lDto.getLic_no());
			pstmt.setString(4, lDto.getInstitution());
			pstmt.setDate(5, lDto.getGet_dt());
			pstmt.setDate(6, lDto.getExpiration_dt());
			pstmt.setString(7, lDto.getCertificate_img_path());
			
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
	}
}
