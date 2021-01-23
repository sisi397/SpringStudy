package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

public class JDBCExam2 {
	public static void main(String[] args) {		
		int roleId = 500;
		String description = "CTO";
		
		//삭제
		RoleDao delete_dao = new RoleDao();
		int deleteCount = delete_dao.deleteRole(roleId);
		System.out.println(deleteCount);
		
		//삽입
		Role role = new Role(roleId, description);
		RoleDao dao = new RoleDao();
		int insertCount = dao.addRole(role);
		System.out.println(insertCount);
		
		//업데이트
		RoleDao update_dao = new RoleDao();
		int updateCount = update_dao.updateRole("UPDATE", roleId);
		System.out.println(updateCount);
	}
}
