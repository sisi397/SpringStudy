package kr.or.connect.jdbcexam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.connect.jdbcexam.dto.Role;

public class RoleDao {
	private static String dburl = "jdbc:mysql://localhost:3306/spring";
	private static String dbUser = "root";
	private static String dbpasswd = "mm1125";
	
	public List<Role> getRoles(){
		List<Role> list = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		String sql = "SELECT role_id, description FROM role order by role_id desc";
		try(Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					int id = rs.getInt("role_id");
					String description = rs.getString(2);
					Role role = new Role(id, description);
					list.add(role);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	
	public int addRole(Role role) {
		int insertCount = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			String sql = "INSERT INTO role VALUES(?, ?)";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, role.getRoleId());
			ps.setString(2, role.getDescription());
			
			insertCount = ps.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch(SQLException e) {}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {}
			}
			return insertCount;
		}
	}
	
	public int deleteRole(Integer id) {
		int deleteCount = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			String sql = "DELETE FROM role WHERE role_id = ?";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			deleteCount = ps.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch(SQLException e) {}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {}
			}
			return deleteCount;
		}
	}
	
	public int updateRole(String description, Integer id) {
		int updateCount = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			String sql = "UPDATE role SET description = ? WHERE role_id = ?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, description);
			ps.setInt(2, id);
			
			updateCount = ps.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch(SQLException e) {}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {}
			}
			return updateCount;
		}
	}
	
	public Role getRole(Integer roleId) {
		Role role = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			String sql = "SELECT role_id, description FROM role WHERE role_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, roleId);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt(1);
				String description = rs.getString(2);
				role = new Role(id, description);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return role;
	}
}
