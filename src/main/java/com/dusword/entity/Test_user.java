package com.dusword.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Test_user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer USER_ID ;
    private String USER_NAME;
    private String USER_PASSWORD;

    public Integer getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(Integer USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public String getUSER_PASSWORD() {
        return USER_PASSWORD;
    }

    public void setUSER_PASSWORD(String USER_PASSWORD) {
        this.USER_PASSWORD = USER_PASSWORD;
    }
}
