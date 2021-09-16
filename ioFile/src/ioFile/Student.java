/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioFile;

import java.io.Serializable;

/**
 *
 * @author vtamin154
 */
public class Student implements Serializable{
    String maSV;
    String hoTen;
    int nhom;

    public Student() {
    }

    public Student(String maSV, String hoTen, int nhom) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.nhom = nhom;
    }    
    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getNhom() {
        return nhom;
    }

    public void setNhom(int nhom) {
        this.nhom = nhom;
    }
    @Override
    public  String toString(){
        return maSV+"\t"+hoTen+"\t"+ nhom;
    }
}

