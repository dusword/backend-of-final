package com.dusword.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PredictedFile {
    @Id
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private String recordTime;

    private String divisionResult;

    private String base64Result;

    private String fileName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public String getDivisionResult() {
        return divisionResult;
    }

    public void setDivisionResult(String divisionResult) {
        this.divisionResult = divisionResult;
    }

    public String getBase64Result() {
        return base64Result;
    }

    public void setBase64Result(String base64Result) {
        this.base64Result = base64Result;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


}
