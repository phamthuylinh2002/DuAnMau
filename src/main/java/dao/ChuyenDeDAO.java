/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import enity.ChuyenDe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author 84373
 */
public class ChuyenDeDAO {

    public ChuyenDeDAO() {
    }
    
    public  ArrayList<ChuyenDe> getListChuyenDe(){
        ArrayList<ChuyenDe> lst = new ArrayList<>();
        try (Connection conn = utils.UtilsJDBC.getConnection()){
            String sql ="select * from chuyenDe";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                ChuyenDe x = new ChuyenDe();
                x.setMaCD(rs.getString("MaCD"));
                x.setTenCD(rs.getString("TenCD"));
                x.setHocPhi(rs.getFloat("HocPhi"));
                x.setThoiLuong(rs.getInt("ThoiLuong"));
                x.setHinh(rs.getString("Hinh"));
                x.setMoTa(rs.getString("MoTa"));
                lst.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
    
    public boolean insertCD(ChuyenDe x){
        
        try (Connection conn = utils.UtilsJDBC.getConnection()){
            String sql="insert into Chuyende values(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, x.getMaCD());
            ps.setString(2, x.getTenCD());
            ps.setFloat(3, x.getHocPhi());
            ps.setInt(4, x.getThoiLuong());
            ps.setString(5, x.getHinh());
            ps.setString(6, x.getMoTa());
            
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteCD(String maCD){
        
        try (Connection conn = utils.UtilsJDBC.getConnection()){
            PreparedStatement ps = conn.prepareStatement("delete Chuyende where macd=?");
            ps.setString(1, maCD);
            
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
                    
        }
        return false;
    }
    
    public boolean updateCD(ChuyenDe x){
        try (Connection conn = utils.UtilsJDBC.getConnection()){
            String sql="update chuyende set tencd=?,hocphi=?,thoiluong=?,hinh=?,mota=? where macd=?";
            PreparedStatement ps = conn.prepareStatement(sql);            
            ps.setString(1, x.getTenCD());
            ps.setFloat(2, x.getHocPhi());
            ps.setInt(3, x.getThoiLuong());
            ps.setString(4, x.getHinh());
            ps.setString(5, x.getMoTa());
            ps.setString(6, x.getMaCD());
            
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    
}
