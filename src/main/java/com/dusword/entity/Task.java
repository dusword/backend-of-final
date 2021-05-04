package com.dusword.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Task {
    @Id
    @TableId(type = IdType.AUTO)
    private Integer Id;
    private Integer UserId;
    private String CreatedTime;
    private String FileName;
    private String IsPredicted;
    private Integer PredictedFileId;
    private String FilePath;
    private String Message;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public String getCreatedTime() {
        return CreatedTime;
    }

    public void setCreatedTime(String createdTime) {
        CreatedTime = createdTime;
    }

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }

    public String getIsPredicted() {
        return IsPredicted;
    }

    public void setIsPredicted(String isPredicted) {
        IsPredicted = isPredicted;
    }

    public Integer getPredictedFileId() {
        return PredictedFileId;
    }

    public void setPredictedFileId(Integer predictedFileId) {
        PredictedFileId = predictedFileId;
    }

    public String getFilePath() {
        return FilePath;
    }

    public void setFilePath(String filePath) {
        FilePath = filePath;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
