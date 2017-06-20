package com.kedu.staff.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.kedu.common.DBManager;
import com.kedu.staff.dto.CarProjDto;

public class CarProjDao {
	
	public CarProjDao() {
	}

	private static CarProjDao instance = new CarProjDao();
	
	public static CarProjDao getInstance(){
		return instance;
	}
	
	public void insertCarPorj (CarProjDto cpDto){
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO EMP_CAREER_PROJ( emp_no						");
		sql.append("				  		   , emp_career_seq				");
		sql.append("                		   , emp_car_proj_seq			");
		sql.append("             			   , role_nm					");
		sql.append("            			   , proj_nm					");
		sql.append("             			   , proj_content				");
		sql.append("             			   , start_dt					");
		sql.append("             			   , end_dt						");
		sql.append("              			   )							");
		sql.append("			 		VALUES( ?							");
		sql.append("          	 			  , ?							");
		sql.append("             			  , EMP_CAR_PROJ_SEQ.NEXTVAL	");
		sql.append("             			  , ?							");
		sql.append("              			  , ?							");
		sql.append("               			  , ?							");
		sql.append("              			  , ?							");
		sql.append("              			  , ?							");
		sql.append("              			  )								");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, cpDto.getEmp_no());
			pstmt.setInt(2, cpDto.getEmp_career_seq());
			pstmt.setString(3, cpDto.getRole_nm());
			pstmt.setString(4, cpDto.getProj_nm());
			pstmt.setString(5, cpDto.getProj_content());
			pstmt.setDate(6, cpDto.getStart_dt());
			pstmt.setDate(7, cpDto.getEnd_dt());
			
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}

	}
}
