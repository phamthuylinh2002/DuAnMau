/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enity;

import java.util.Date;

/**
 *
 * @author 84373
 */
public class Khoahoc {
    int maKH,thoiLuong ;
    String maCD,ghiChu,maNV;
    float hocPhi;
    Date ngayKG, ngayTao;

    public Khoahoc() {
    }

    public Khoahoc(int maKH, int thoiLuong, String maCD, String ghiChu, String maNV, float hocPhi, Date ngayKG, Date ngayTao) {
        this.maKH = maKH;
        this.thoiLuong = thoiLuong;
        this.maCD = maCD;
        this.ghiChu = ghiChu;
        this.maNV = maNV;
        this.hocPhi = hocPhi;
        this.ngayKG = ngayKG;
        this.ngayTao = ngayTao;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public String getMaCD() {
        return maCD;
    }

    public void setMaCD(String maCD) {
        this.maCD = maCD;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public float getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(float hocPhi) {
        this.hocPhi = hocPhi;
    }

    public String getNgayKG() {
        return utils.Hepler.SIMPLE_DATE_FORMAT.format(ngayKG);
    }

    public void setNgayKG(Date ngayKG) {
        this.ngayKG = ngayKG;
    }

    public String getNgayTao() {
        return utils.Hepler.SIMPLE_DATE_FORMAT.format(ngayTao);
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }
    
    
}
