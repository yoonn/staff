package com.kedu.staff.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.kedu.common.DBManager;
import com.kedu.staff.dto.SkillDto;

public class SkillDao {

	public SkillDao() {
	}
	
	private static SkillDao instance = new SkillDao();
	
	public static SkillDao getInstance(){
		return instance;
	}
	
	public void insertSkill(SkillDto skDto){
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO EMP_SKILL( emp_no		");
		sql.append("					 , skill_no		");
		sql.append("              		 , skill_level	");
		sql.append("   		             )				");
		sql.append("			  VALUES ( ?			");
		sql.append("              		 , ?			");
		sql.append("                	 , ?			");
		sql.append("                	 )				");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn  = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, skDto.getEmp_no());
			pstmt.setString(2, skDto.getSkill_no());
			pstmt.setString(3, skDto.getSkill_level());
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
		
	}
}
