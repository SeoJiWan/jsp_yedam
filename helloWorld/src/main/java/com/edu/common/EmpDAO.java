package com.edu.common;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

public class EmpDAO extends DAO{
	
	// 특정 이름 조회
	public List<Employee> getEmpInfo(String name) {	
		List<Employee> list = new ArrayList<Employee>();
	
		try {
			connect();
			String sql = "select * from employees where first_name = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setEmail(rs.getString(4));
				emp.setSalary(rs.getInt("salary"));
				list.add(emp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	// 전체 조회
	public List<Employee> selectAllEmp() {	
		List<Employee> list = new ArrayList<Employee>();
	
		try {
			connect();
			String sql = "select * from employees order by employee_id";
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setEmail(rs.getString(4));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setSalary(rs.getInt("salary"));
				emp.setJobId(rs.getString("job_id"));
				
				list.add(emp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	// member table 삽입 : user_name, user_pwd, role ==> 입력
	// 입력화면, 서블릿, 쿼리
	public int insertMember(String name, String pwd, String role) {
		int result = 0;
		
		try {
			connect();
			String sql = "INSERT INTO members VALUES (?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
			ps.setString(3, role);
			
			result = ps.executeUpdate(); // insert, update, delete
			if (result > 0 ) {
				System.out.println(result + "행 삽입 성공");
			}
			else {
				System.out.println("행 삽입 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
	
	// 변경.
	public int updateMemeber(String name, String pass, String role) {
		int result = 0;
		try {
			connect();
			
			String sql = "update members set "
					+ "member_pwd = ?, "
					+ "member_role = ? "
					+ "where member_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, pass);
			ps.setString(2, role);
			ps.setString(3, name);
			
			result = ps.executeUpdate();
			if (result > 0) {
				System.out.println(result + "행 수정 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
	
}
