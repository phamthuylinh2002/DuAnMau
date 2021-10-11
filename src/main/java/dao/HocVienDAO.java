/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import enity.HocVien;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author 84373
 */
public class HocVienDAO {

    public HocVienDAO() {
    }
    
    public ArrayList<HocVien> getListHV(){
        ArrayList<HocVien> lst = new ArrayList<>();
        try (Connection conn = utils.UtilsJDBC.getConnection()){
            String url ="select * from hocvien";
            PreparedStatement ps = conn.prepareStatement(url);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HocVien x = new HocVien();
                x.setDiem(rs.getFloat("diem"));
                x.setMaHV(rs.getString("maHV"));
                x.setMaKH(rs.getString("maKH"));
                x.setMaNH(rs.getString("maNH"));
                lst.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
    
   
    
}
