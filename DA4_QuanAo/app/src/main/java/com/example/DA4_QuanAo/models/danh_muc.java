package com.example.DA4_QuanAo.models;

public class danh_muc {
    int iddm;
    String tendm;
    String hinhanh;
    String ghichu;

    public danh_muc(int iddm, String tendm, String hinhanh, String ghichu) {
        this.iddm = iddm;
        this.tendm = tendm;
        this.hinhanh = hinhanh;
        this.ghichu = ghichu;
    }

    public int getIddm() {
        return iddm;
    }

    public String getTendm() {
        return tendm;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public String getGhichu() {
        return ghichu;
    }
}
