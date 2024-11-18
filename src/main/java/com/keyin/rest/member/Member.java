package com.keyin.rest.member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

import java.util.Date;

@Entity
public class Member {
    @Id
    @SequenceGenerator(name = "member_sequence", sequenceName = "member_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "member_sequence")
    long id;
    String name;
    String address;
    String email;
    String phoneNum;
    Date startDate;
    Date duration;

    public Member (){

    }
    public Member(String name, String email, String address, long id, String phoneNum, Date startDate, Date duration) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.id = id;
        this.phoneNum = phoneNum;
        this.startDate = startDate;
        this.duration = duration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }


}
