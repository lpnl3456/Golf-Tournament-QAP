package com.keyin.rest.tournament;

import com.keyin.rest.member.Member;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Entity
public class Tournament {
    @Id
    @SequenceGenerator(name = "tournament_sequence", sequenceName = "tournament_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "tournament_sequence")
    private long id;
    private String startDate;
    private String endDate;
    private String location;
    private double entryFee;
    private double prizeAmount;

    @ManyToMany
    List<Member> participatingMem;

    public Tournament() {
    }
    public Tournament(long id, String startDate, String endDate, String location, double entryFee, double prizeAmount, List<Member> participatingMem) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.entryFee = entryFee;
        this.prizeAmount = prizeAmount;
        this.participatingMem = participatingMem;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
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
