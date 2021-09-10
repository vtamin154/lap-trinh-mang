/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Employee;
import controller.dao.Dao;
import java.math.BigInteger;

/**
 *
 * @author vtamin154
 */
public class EmployeeDAO extends Dao{
    String INSERT_Employee = "INSERT INTO EMPLOYEE (EMP_ID,"+
				"EMP_NAME,"+
				"EMP_NO,"+
				"HIRE_DATE,"+
				"IMAGE,"+
				"JOB,"+
				"SALARY,"+
				"DEPT_ID,"+
				"MNG_ID)"+
				"VALUES (?,?,?,?,?,?,?,?,?)";
    String SELECT_ALL_EmployeeS = "select * from Employee;";
    String EDIT_Employee = "UPDATE EMPLOYEE set "+
				"EMP_NAME = ?,"+
				"EMP_NO = ?,"+
				"HIRE_DATE = ?,"+
				"IMAGE= ?,"+
				"JOB= ?,"+
				"SALARY = ?,"+
				"DEPT_ID = ?,"+
				"MNG_ID= ? "+
				"Where EMP_ID = ?";
    String DELETE_Employee = "delete from Employee where D EMP_ID = ?";

    public void insertEmployee(Employee e){
        try(PreparedStatement pr = con.prepareStatement(INSERT_Employee)) {
            pr.setInt(1, e.getEmpId());
            pr.setString(2, e.getEmpName());
            pr.setString(3, e.getEmpNo());
            pr.setDate(4, new java.sql.Date(e.getHireDate().getTime()));
            pr.setBytes(5, e.getImage());
            pr.setString(6, e.getJob());
            pr.setFloat(7, e.getSalary());
            pr.setInt(8, e.getDeptId());
            pr.setLong(9, e.getMngId().longValue());
        }
        catch (Exception er) {
            er.printStackTrace();
        }
    }
    public  List<Employee> selectAllEmployees(){
        List<Employee> list = new ArrayList<>();
        try (PreparedStatement pr = con.prepareStatement(SELECT_ALL_EmployeeS)){
            ResultSet rs = pr.executeQuery();
            while(rs.next()){
                Employee e = new Employee(
						rs.getInt(1), 
						rs.getString(2),
						rs.getString(3),
						rs.getDate(4),
						rs.getBytes(5),
						rs.getString(6),
						rs.getFloat(7),
						rs.getInt(8),
						BigInteger.valueOf(rs.getInt(9)));
                list.add(e);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public boolean editEmployee(Employee e, int id){
        boolean edit = false;
        try(PreparedStatement pr = con.prepareStatement(EDIT_Employee);) {
            pr.setString(1, e.getEmpName());
            pr.setString(2, e.getEmpNo());
            pr.setDate(3, new java.sql.Date(e.getHireDate().getTime()));
            pr.setBytes(4, e.getImage());
            pr.setString(5, e.getJob());
            pr.setFloat(6, e.getSalary());
            pr.setInt(7, e.getDeptId());
            pr.setLong(8, e.getMngId().longValue());
            pr.setInt(9, e.getEmpId());
            edit = pr.executeUpdate()>0;
            
        } catch (Exception er) {
            er.printStackTrace();
        }
        return edit;
    }
    public boolean deleteEmployee(int id){
        boolean delete = false;
        try (PreparedStatement pr = con.prepareStatement(DELETE_Employee)){
            pr.setInt(1, id);
            delete = pr.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return delete;
    }
}
