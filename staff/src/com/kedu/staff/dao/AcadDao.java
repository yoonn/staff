package com.kedu.staff.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.kedu.common.DBManager;
import com.kedu.staff.dto.AcadDto;

public class AcadDao {

	private static AcadDao instance = new AcadDao();
	
	public static AcadDao getInstance(){
		return instance;
	}
	
	public AcadDao() {
	}
	
	public void insertAcad (AcadDto aDto){
		StringBuilder sql = new StringBuilder();
		sql.append("		INSERT INTO EMP_ACAD( emp_no	");
		sql.append("				, acad_level_no			");
		sql.append("                , EMP_ACAD_SEQ			");
		sql.append("                , acad_state_no			");
		sql.append("                , acad_nm				");
		sql.append("                , major_nm				");
		sql.append("                , enter_dt				");
		sql.append("                , graduation_dt			");
		sql.append("                , certificate_img_path	");
		sql.append("                , grade					");
		sql.append("                , perfect_grade			");
		sql.append("                )						");
		sql.append("		  VALUES( ?						");
		sql.append("          		, ?						");
		sql.append("                , EMP_ACAD_SEQ.NEXTVAL	");
		sql.append("                , ?						");
		sql.append("                , ?						");
		sql.append("                , ?						");
		sql.append("                , ?						");
		sql.append("                , ?						");
		sql.append("                , ?						");
		sql.append("                , ?						");
		sql.append("                , ?						");
		sql.append("                )						");

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, aDto.getEmp_no());
			pstmt.setString(2, aDto.getAcad_level_no());
			pstmt.setString(3, aDto.getAcad_state_no());
			pstmt.setString(4, aDto.getAcad_nm());
			pstmt.setString(5, aDto.getMajor_nm());
			pstmt.setDate(6, aDto.getEnter_dt());
			pstmt.setDate(7, aDto.getGraduation_dt());
			pstmt.setString(8, aDto.getCertificate_img_path());
			pstmt.setFloat(9, aDto.getGrade());
			pstmt.setFloat(10, aDto.getPerfect_grade());
			
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
	}
}
