package com.example.demo.dtos;

import com.example.demo.entities.StaffPK;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class StaffDTO {


    private Integer id;
    private Integer wardid;
    private String education;


    private String foren_languages;

    private Date joined;

    public StaffDTO(){

    }

    public StaffDTO(Integer person, Integer ward) {
    }

    public StaffDTO(Integer id, Integer wardid, String education, String foren_languages, Date joined) {
        this.id = id;
        this.wardid=wardid;
        this.education=education;
        this.foren_languages=foren_languages;
        this.joined=joined;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWardid() {
        return wardid;
    }

    public void setWardid(Integer wardid) {
        this.wardid = wardid;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getForen_languages() {
        return foren_languages;
    }

    public void setForen_languages(String foren_languages) {
        this.foren_languages = foren_languages;
    }

    public Date getJoined() {
        return joined;
    }

    public void setJoined(Date joined) {
        this.joined = joined;
    }
}
