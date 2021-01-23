package kr.or.connect.jdbcexam;

import java.util.List;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

public class JDBCExam1 {
	public static void main(String[] args) {
		// 한개 select
		RoleDao dao  = new RoleDao();
		Role role = dao.getRole(100);
		System.out.println(role);
		
		//여러개 select
		RoleDao daos = new RoleDao();
		List<Role> list = daos.getRoles();
		
		for(Role roles : list) {
			System.out.println(roles);
		}
	}
}
