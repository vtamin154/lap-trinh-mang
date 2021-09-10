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
import model.Department;
import controller.dao.Dao;

/**
 *
 * @author vtamin154
 */
public class DepartmentDAO extends Dao{
    String INSERT_DEPARTMENT = "insert into CONTACTDB.department value(?,?,?,?);";
    String SELECT_ALL_DEPARTMENTS = "select * from CONTACTDB.department;";
    String EDIT_DEPARTMENT = "update CONTACTDB.department set DEPT_ID = ?,DEPT_NAME= ?, DEPT_NO =? ,LOCATION = ? where DEPT_ID = ?;";
    String DELETE_DEPARTMENT = "delete from CONTACTDB.department where DEPT_ID = ?;";
    public DepartmentDAO() {
    }
    public void insertDepartment(Department department){
        try(PreparedStatement pr = con.prepareStatement(INSERT_DEPARTMENT)) {
            pr.setInt(1, department.getDeptId());
            pr.setString(2, department.getDeptName());
            pr.setString(3, department.getDeptNo());
            pr.setString(4, department.getLocation());
            pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  List<Department> selectAllDepartments(){
        List<Department> list = new ArrayList<>();
        try (PreparedStatement pr = con.prepareStatement(SELECT_ALL_DEPARTMENTS)){
            ResultSet rs = pr.executeQuery();
            while(rs.next()){
                int id = rs.getInt("DEPT_ID");
                String name = rs.getString("DEPT_NAME");
                String no = rs.getString("DEPT_NO");
                String location = rs.getString("LOCATION");
                list.add(new Department(id, name, no, location));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public boolean editDepartment(Department department, int id){
        boolean edit = false;
        try(PreparedStatement pr = con.prepareStatement(EDIT_DEPARTMENT);) {
            pr.setInt(1, department.getDeptId());
            pr.setString(2, department.getDeptName());
            pr.setString(3, department.getDeptNo());
            pr.setString(4, department.getLocation());
            pr.setInt(5, id);
            edit = pr.executeUpdate()>0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return edit;
    }
    public boolean deleteDepartment(int id){
        boolean delete = false;
        try (PreparedStatement pr = con.prepareStatement(DELETE_DEPARTMENT)){
            pr.setInt(1, id);
            delete = pr.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return delete;
    }
}
