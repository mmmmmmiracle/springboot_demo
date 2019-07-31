package com.hyd.mercury.entity;

public class UserWithBLOBs extends User {
    private String idImg;

    private String bankCardImg;

    private String healthCertificateImg;

    private String headimg;

    public String getIdImg() {
        return idImg;
    }

    public void setIdImg(String idImg) {
        this.idImg = idImg == null ? null : idImg.trim();
    }

    public String getBankCardImg() {
        return bankCardImg;
    }

    public void setBankCardImg(String bankCardImg) {
        this.bankCardImg = bankCardImg == null ? null : bankCardImg.trim();
    }

    public String getHealthCertificateImg() {
        return healthCertificateImg;
    }

    public void setHealthCertificateImg(String healthCertificateImg) {
        this.healthCertificateImg = healthCertificateImg == null ? null : healthCertificateImg.trim();
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg == null ? null : headimg.trim();
    }
}