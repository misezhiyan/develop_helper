package com.kimmy.online.esb.finance.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 信数年报财务大数
 * @author: liyq
 * @createtime: 2023-05-15 14:15:38
 */
public class XinShuAsset implements Serializable {

    private String rowkey;
    private String ancheyear;
    private String ispublic;
    private String busst;
    private String dom;
    private String email;
    private String postalcode;
    private String tel;
    private String assgro;
    private String liagro;
    private String maibusinc;
    private String netinc;
    private String progro;
    private String ratgro;
    private String totequ;
    private String vendinc;
    private String notAssgro;
    private String notLiagro;
    private String notMaibusinc;
    private String notNetinc;
    private String notProgro;
    private String notRatgro;
    private String notTotequ;
    private String notVendinc;
    private Date createDate;
    private String empnum;

    public String getRowkey() {
        return rowkey;
    }

    public void setRowkey(String rowkey) {
        this.rowkey = rowkey;
    }

    public String getAncheyear() {
        return ancheyear;
    }

    public void setAncheyear(String ancheyear) {
        this.ancheyear = ancheyear;
    }

    public String getIspublic() {
        return ispublic;
    }

    public void setIspublic(String ispublic) {
        this.ispublic = ispublic;
    }

    public String getBusst() {
        return busst;
    }

    public void setBusst(String busst) {
        this.busst = busst;
    }

    public String getDom() {
        return dom;
    }

    public void setDom(String dom) {
        this.dom = dom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAssgro() {
        return assgro;
    }

    public void setAssgro(String assgro) {
        this.assgro = assgro;
    }

    public String getLiagro() {
        return liagro;
    }

    public void setLiagro(String liagro) {
        this.liagro = liagro;
    }

    public String getMaibusinc() {
        return maibusinc;
    }

    public void setMaibusinc(String maibusinc) {
        this.maibusinc = maibusinc;
    }

    public String getNetinc() {
        return netinc;
    }

    public void setNetinc(String netinc) {
        this.netinc = netinc;
    }

    public String getProgro() {
        return progro;
    }

    public void setProgro(String progro) {
        this.progro = progro;
    }

    public String getRatgro() {
        return ratgro;
    }

    public void setRatgro(String ratgro) {
        this.ratgro = ratgro;
    }

    public String getTotequ() {
        return totequ;
    }

    public void setTotequ(String totequ) {
        this.totequ = totequ;
    }

    public String getVendinc() {
        return vendinc;
    }

    public void setVendinc(String vendinc) {
        this.vendinc = vendinc;
    }

    public String getNotAssgro() {
        return notAssgro;
    }

    public void setNotAssgro(String notAssgro) {
        this.notAssgro = notAssgro;
    }

    public String getNotLiagro() {
        return notLiagro;
    }

    public void setNotLiagro(String notLiagro) {
        this.notLiagro = notLiagro;
    }

    public String getNotMaibusinc() {
        return notMaibusinc;
    }

    public void setNotMaibusinc(String notMaibusinc) {
        this.notMaibusinc = notMaibusinc;
    }

    public String getNotNetinc() {
        return notNetinc;
    }

    public void setNotNetinc(String notNetinc) {
        this.notNetinc = notNetinc;
    }

    public String getNotProgro() {
        return notProgro;
    }

    public void setNotProgro(String notProgro) {
        this.notProgro = notProgro;
    }

    public String getNotRatgro() {
        return notRatgro;
    }

    public void setNotRatgro(String notRatgro) {
        this.notRatgro = notRatgro;
    }

    public String getNotTotequ() {
        return notTotequ;
    }

    public void setNotTotequ(String notTotequ) {
        this.notTotequ = notTotequ;
    }

    public String getNotVendinc() {
        return notVendinc;
    }

    public void setNotVendinc(String notVendinc) {
        this.notVendinc = notVendinc;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getEmpnum() {
        return empnum;
    }

    public void setEmpnum(String empnum) {
        this.empnum = empnum;
    }

    public static XinShuAsset build(String rowkey, String ancheyear, String ispublic, String busst, String dom, String email, String postalcode, String tel, String assgro, String liagro, String maibusinc, String netinc, String progro, String ratgro, String totequ, String vendinc, String notAssgro, String notLiagro, String notMaibusinc, String notNetinc, String notProgro, String notRatgro, String notTotequ, String notVendinc, String empnum) {
        XinShuAsset asset = new XinShuAsset();
        asset.setRowkey(rowkey);
        asset.setAncheyear(ancheyear);
        asset.setIspublic(ispublic);
        asset.setBusst(busst);
        asset.setDom(dom);
        asset.setEmail(email);
        asset.setPostalcode(postalcode);
        asset.setTel(tel);
        asset.setAssgro(assgro);
        asset.setLiagro(liagro);
        asset.setMaibusinc(maibusinc);
        asset.setNetinc(netinc);
        asset.setProgro(progro);
        asset.setRatgro(ratgro);
        asset.setTotequ(totequ);
        asset.setVendinc(vendinc);
        asset.setNotAssgro(notAssgro);
        asset.setNotLiagro(notLiagro);
        asset.setNotMaibusinc(notMaibusinc);
        asset.setNotNetinc(notNetinc);
        asset.setNotProgro(notProgro);
        asset.setNotRatgro(notRatgro);
        asset.setNotTotequ(notTotequ);
        asset.setNotVendinc(notVendinc);
        asset.setEmpnum(empnum);
        return asset;
    }
}
