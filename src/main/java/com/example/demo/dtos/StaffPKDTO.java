package com.example.demo.dtos;

import javax.persistence.Column;
import java.util.Date;

public class StaffPKDTO {
    private Integer id;
    private Integer wardid;

    private Date joined;

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
}
