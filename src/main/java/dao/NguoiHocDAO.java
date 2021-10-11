/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import enity.NguoiHoc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 84373
 */
public class NguoiHocDAO {

    public NguoiHocDAO() {
    }
    
    public ArrayList<NguoiHoc> getListNH(){
        ArrayList<NguoiHoc> lst = new ArrayList<>();
        try (Connection conn = utils.UtilsJDBC.getConnection()){
            PreparedStatement ps = conn.prepareStatement("select * from nguoihoc");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NguoiHoc x = new NguoiHoc();
                x.setMaNH(rs.getString("maNH"));
                x.setMatKhau(rs.getString("matkhau"));
                x.setHoTen(rs.getString("hoten"));
                x.setGioiTinh(rs.getBoolean("gioiTinh"));
                x.setNgaySinh(rs.getDate("ngaySinh"));
                x.setEmail(rs.getString("email"));
                x.setDienThoai(rs.getString("dienthoai"));
                x.setGhiChu(rs.getString("ghiChu"));
                x.setMaNV(rs.getString("maNV"));
                x.setNgayDK(rs.getDate("ngayDK"));
                
                lst.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
    
    public boolean insertNH(NguoiHoc x){
        try (Connection conn = utils.UtilsJDBC.getConnection()){
            String sql ="insert into NGUOIHOC(MANH,matkhau,HOTEN,NGAYSINH,EMAIL,DIENTHOAI,MANV)\n" +
"            VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, x.getMaNH());
            ps.setString(2, x.getMatKhau());
            ps.setString(3, x.getHoTen());
            ps.setString(4,x.getNgaySinh());
            ps.setString(5, x.getEmail());
            ps.setString(6, x.getDienThoai());
            ps.setString(7, x.getMaNV());
            
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Mã không được trùng");
        }
        
        return false;
    }
    
    public boolean updateNH(NguoiHoc x){
        try (Connection conn = utils.UtilsJDBC.getConnection()){
            String sql="update nguoihoc set matkhau=?, hoTen=?, gioitinh=?,ngaySinh=?,"
                    + "email=?,dienThoai=?,ghichu=?,maNv=?,ngayDK=? where maNh=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,x.getMatKhau());
            ps.setString(2,x.getHoTen());
            int gt =0; // nữ
            if(x.isGioiTinh()){
                gt=1; // nam
            }
            ps.setInt(3,gt);
            ps.setString(4, x.getNgaySinh());
            ps.setString(5,x.getEmail());
            ps.setString(6,x.getDienThoai());
            ps.setString(7,x.getGhiChu());
            ps.setString(8,x.getMaNV());
            ps.setString(9,x.getNgayDK());
            ps.setString(10,x.getMaNH());
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
                
    }
    
    public boolean deleteNH(String maNH){
        try (Connection conn = utils.UtilsJDBC.getConnection()){
            String sql="delete nguoihoc where manh=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maNH);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
