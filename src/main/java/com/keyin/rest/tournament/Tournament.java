package com.keyin.rest.tournament;

import com.keyin.rest.member.Member;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Tournament {
    @Id
    @SequenceGenerator(name = "member_sequence", sequenceName = "member_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "member_sequence")
    private long id;
    private Date startDate;
    private Date endDate;
    private String location;
    private double entryFee;
    private double prizeAmount;

    @ManyToMany
    List<Member> participatingMem;

    public Tournament() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(double entryFee) {
        this.entryFee = entryFee;
    }

    public double getPrizeAmount() {
        return prizeAmount;
    }

    public void setPrizeAmount(double prizeAmount) {
        this.prizeAmount = prizeAmount;
    }

    public List<Member> getParticipatingMem() {
        return participatingMem;
    }

    public void setParticipatingMem(List<Member> participatingMem) {
        participatingMem = participatingMem;
    }

    public void addMember(Member member){
        participatingMem.add(member);
    }
}
