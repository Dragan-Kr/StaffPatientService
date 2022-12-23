package com.example.demo.dtos;

import java.util.Date;

public class StaffModificationDTO {

        private Integer id;
        private Integer wardid;
        private String education;


        private String foren_languages;

        private Date joined;

        public  StaffModificationDTO(){

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


