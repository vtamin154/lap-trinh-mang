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
import model.Timekeeper;
import controller.dao.Dao;
import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author vtamin154
 */
public class TimekeeperDAO extends Dao{
    String INSERT_TIMEKEEPER = "insert into CONTACTDB.TIMEKEEPER value(?,?,?,?);";
    String SELECT_ALL_TIMEKEEPERS = "select * from CONTACTDB.TIMEKEEPER;";
    String EDIT_TIMEKEEPER = "update CONTACTDB.TIMEKEEPER set Timekeeper_Id = ?,Date_Time= ?, In_Out =? ,EMP_ID = ? where Timekeeper_Id = ?;";
    String DELETE_TIMEKEEPER = "delete from CONTACTDB.TIMEKEEPER where Timekeeper_Id = ?;";
  
    public void insertTimekeeper(Timekeeper timekeeper){
        try(PreparedStatement pr = con.prepareStatement(INSERT_TIMEKEEPER)) {         
            pr.setString(1, timekeeper.getTimekeeper_Id());
            pr.setDate(2, new java.sql.Date(timekeeper.getDate_Time().getTime()));
            pr.setString(3, timekeeper.getIn_Out());
            pr.setLong(4,timekeeper.getEmpId().longValue());
            pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  List<Timekeeper> selectAllTimekeepers(){
        List<Timekeeper> list = new ArrayList<>();
        try (PreparedStatement pr = con.prepareStatement(SELECT_ALL_TIMEKEEPERS)){
            ResultSet rs = pr.executeQuery();
            while(rs.next()){
                int id = rs.getInt("");
                String timekeeper_Id = rs.getString("Timekeeper_Id");
                Date date_Time = rs.getDate("Date_Time");
                String in_Out = rs.getString("In_Out");
                BigInteger empId = BigInteger.valueOf(rs.getInt("EMP_ID"));
                list.add(new Timekeeper(timekeeper_Id,date_Time, empId,in_Out));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public boolean editTimekeeper(Timekeeper timekeeper, String id){
        boolean edit = false;
        try(PreparedStatement pr = con.prepareStatement(EDIT_TIMEKEEPER);) {
            pr.setString(1, timekeeper.getTimekeeper_Id());
            pr.setDate(2, new java.sql.Date(timekeeper.getDate_Time().getTime()));
            pr.setString(3, timekeeper.getIn_Out());
            pr.setLong(4, timekeeper.getEmpId().longValue());
            pr.setString(5, id);
            edit = pr.executeUpdate()>0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return edit;
    }
    public boolean deleteTimekeeper(String id){
        boolean delete = false;
        try (PreparedStatement pr = con.prepareStatement(DELETE_TIMEKEEPER)){
            pr.setString(1, id);
            delete = pr.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return delete;
    }
}
