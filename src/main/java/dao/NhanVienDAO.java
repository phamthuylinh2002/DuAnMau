/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import enity.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author 84373
 */
public class NhanVienDAO {

    public NhanVienDAO() {
    }
    
    public ArrayList<NhanVien> getListNV(){
        ArrayList<NhanVien> lst = new ArrayList<>();
        
        try (Connection conn = utils.UtilsJDBC.getConnection()){
            
            String sql="select * from nhanvien";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhanVien x = new NhanVien();
                x.setHoTen(rs.getString("hoten"));
                x.setMaNV(rs.getString("manv"));
                x.setVaiTro(rs.getBoolean("vaitro"));
                x.setMatKhau(rs.getString("matkhau"));
                
                lst.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
    
    public boolean insertNV(NhanVien x){
        try (Connection conn = utils.UtilsJDBC.getConnection()){
            String sql="INSERT into NHANVIEN(MANV,MATKHAU,HOTEN,vaitro) VALUES(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, x.getMaNV());
            ps.setString(2, x.getMatKhau());
            ps.setString(3, x.getHoTen());
            ps.setBoolean(4, x.isVaiTro());
            
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteNV(String maNV ){
        
        try (Connection conn = utils.UtilsJDBC.getConnection()){
            PreparedStatement ps = conn.prepareStatement("delete nhanvien where manv=?");
            ps.setString(1, maNV);
            
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateNV(NhanVien x){
        
        try (Connection conn = utils.UtilsJDBC.getConnection()){
            
            String sql="update nhanvien set matkhau=?,hoten=?,vaitro=? where manv=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, x.getMatKhau());
            ps.setString(2, x.getHoTen());
            ps.setBoolean(3,x.isVaiTro() );
            ps.setString(4, x.getMaNV());
            
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
