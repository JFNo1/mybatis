package com.panjunfeng.domain;

/**
 * @author panjunfeng
 */
public class MyStudent {
    private Integer stuId;
    private String sName;
    private String sEmail;
    private String sAge;

    public MyStudent(Integer stuId, String sName, String sEmail, String sAge) {
        this.stuId = stuId;
        this.sName = sName;
        this.sEmail = sEmail;
        this.sAge = sAge;
    }

    public MyStudent() {
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsAge() {
        return sAge;
    }

    public void setsAge(String sAge) {
        this.sAge = sAge;
    }

    @Override
    public String toString() {
        return "MyStudent{" +
                "stuId=" + stuId +
                ", sName='" + sName + '\'' +
                ", sEmail='" + sEmail + '\'' +
                ", sAge='" + sAge + '\'' +
                '}';
    }
}
