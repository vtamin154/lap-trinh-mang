/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author vtamin154
 */
public class IOFile {

    /**
     * @param args the command line arguments
     *
     */
    @SuppressWarnings("unchecked")

    static void writeToFile(ArrayList<Student> list) throws IOException {
        try {
            FileWriter fw = new FileWriter("data.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Student st : list) {
                bw.write(st.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    static void readFromFile(ArrayList<Student> list2) {
        try {
            FileReader fr = new FileReader("data.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
            
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so hoc sinh: ");
        int n = sc.nextInt();
        ArrayList<Student> list = new ArrayList<>();

        //Ghi du lieu vao file
        for (int i = 1; i <= n; i++) {
            Student st = new Student();
            System.out.println("Ma sinh vien: ");
            String maSv = sc.next();
            sc.nextLine();
            System.out.println("Ho ten: ");
            String hoTen = sc.nextLine();
            System.out.println("Nhom: ");
            int nhom = sc.nextInt();
            sc.nextLine();
            st = new Student(maSv, hoTen, nhom);
            list.add(st);
        }
        //ghi du lieu vao file
        writeToFile(list);
        
        //doc du lieu tu file
        ArrayList<Student> list2 = new ArrayList<>();
        readFromFile(list2);
    }

}
