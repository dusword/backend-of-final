package com.dusword.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public Integer getTotalrownum() {
        return totalrownum;
    }

    public void setTotalrownum(Integer totalrownum) {
        this.totalrownum = totalrownum;
    }

    public Integer getRownum() {
        return rownum;
    }

    public void setRownum(Integer rownum) {
        this.rownum = rownum;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }

    public String getResbindcode() {
        return resbindcode;
    }

    public void setResbindcode(String resbindcode) {
        this.resbindcode = resbindcode;
    }

    public Integer getIsbind() {
        return isbind;
    }

    public void setIsbind(Integer isbind) {
        this.isbind = isbind;
    }

    public Integer getIscamincomplexipc() {
        return iscamincomplexipc;
    }

    public void setIscamincomplexipc(Integer iscamincomplexipc) {
        this.iscamincomplexipc = iscamincomplexipc;
    }

    public Integer getResattribute() {
        return resattribute;
    }

    public void setResattribute(Integer resattribute) {
        this.resattribute = resattribute;
    }

    public Integer getIssuperipc() {
        return issuperipc;
    }

    public void setIssuperipc(Integer issuperipc) {
        this.issuperipc = issuperipc;
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    public String getRescode() {
        return rescode;
    }

    public void setRescode(String rescode) {
        this.rescode = rescode;
    }

    public Integer getResextstatus() {
        return resextstatus;
    }

    public void setResextstatus(Integer resextstatus) {
        this.resextstatus = resextstatus;
    }

    public String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
    }

    public Integer getResstatus() {
        return resstatus;
    }

    public void setResstatus(Integer resstatus) {
        this.resstatus = resstatus;
    }

    public Integer getResisbeshare() {
        return resisbeshare;
    }

    public void setResisbeshare(Integer resisbeshare) {
        this.resisbeshare = resisbeshare;
    }

    public Integer getResisforeign() {
        return resisforeign;
    }

    public void setResisforeign(Integer resisforeign) {
        this.resisforeign = resisforeign;
    }

    public Integer getStreamnum() {
        return streamnum;
    }

    public void setStreamnum(Integer streamnum) {
        this.streamnum = streamnum;
    }

    public String getResname() {
        return resname;
    }

    public void setResname(String resname) {
        this.resname = resname;
    }

    public Integer getRessubtype() {
        return ressubtype;
    }

    public void setRessubtype(Integer ressubtype) {
        this.ressubtype = ressubtype;
    }

    public Integer getRestype() {
        return restype;
    }

    public void setRestype(Integer restype) {
        this.restype = restype;
    }

    public Integer getHasbrdsubres() {
        return hasbrdsubres;
    }

    public void setHasbrdsubres(Integer hasbrdsubres) {
        this.hasbrdsubres = hasbrdsubres;
    }

    public Integer getDevencodeset() {
        return devencodeset;
    }

    public void setDevencodeset(Integer devencodeset) {
        this.devencodeset = devencodeset;
    }

    public Integer getVoicestatus() {
        return voicestatus;
    }

    public void setVoicestatus(Integer voicestatus) {
        this.voicestatus = voicestatus;
    }

    public Integer getSubtypeofsubtype() {
        return subtypeofsubtype;
    }

    public void setSubtypeofsubtype(Integer subtypeofsubtype) {
        this.subtypeofsubtype = subtypeofsubtype;
    }

    //    @Column(name = "errmsg")
    private String errmsg;
//    @Column(name = "ErrCode")
    private Integer errcode;
//    @Column(name = "TotalRowNum")
    private Integer totalrownum;
//    @Column(name = "RowNum")
    private Integer rownum;
//    @Column(name = "Reserve")
    private String reserve;
//    @Column(name = "ResBindCode")
    private String resbindcode;
//    @Column(name = "IsBind")
    private Integer isbind;
//    @Column(name = "IsCamInComplexIPC")
    private Integer iscamincomplexipc;
//    @Column(name = "ResAttribute")
    private Integer resattribute;
//    @Column(name = "IsSuperIPC")
    private Integer issuperipc;
//    @Column(name = "OrgName")
    private String orgname;
//    @Column(name = "ResCode")/
    private String rescode;
//    @Column(name = "ResExtStatus")
    private Integer resextstatus;
//    @Column(name = "OrgCode")
    private String orgcode;
//    @Column(name = "ResStatus")
    private Integer resstatus;
//    @Column(name = "ResIsBeShare")
    private Integer resisbeshare;
//    @Column(name = "ResIsForeign")
    private Integer resisforeign;
//    @Column(name = "StreamNum")
    private Integer streamnum;
//    @Column(name = "ResName")
    private String resname;
//    @Column(name = "ResSubType")
    private Integer ressubtype;
//    @Column(name = "ResType")
    private Integer restype;
//    @Column(name = "HasBrdSubRes")
    private Integer hasbrdsubres;
//    @Column(name = "DevEncodeSet")
    private Integer devencodeset;
//    @Column(name = "VoiceStatus")
    private Integer voicestatus;
//    @Column(name = "SubTypeOfSubType")
    private Integer subtypeofsubtype;

}
