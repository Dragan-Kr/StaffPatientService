package com.example.demo.dtos;

import javax.persistence.Column;
import javax.persistence.Id;

public class RoomDTO {


    private Integer id;
    private Integer wid;


    private Integer bedNumber;


    private String rGender;

    public  RoomDTO(){

    }

    public RoomDTO(Integer id, Integer wid, Integer bedNumber, String getrGender) {
        this.id=id;
        this.wid=wid;
        this.bedNumber=bedNumber;
        this.rGender = getrGender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public Integer getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(Integer bedNumber) {
        this.bedNumber = bedNumber;
    }

    public String getrGender() {
        return rGender;
    }

    public void setrGender(String rGender) {
        this.rGender = rGender;
    }
}
