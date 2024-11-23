package com.keyin.rest.member;

import com.keyin.rest.tournament.Tournament;
import com.keyin.rest.tournament.TournamentRepository;
import com.keyin.rest.tournament.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private TournamentService tournamentService;

    public Member createMember(Member newMember) {
        return memberRepository.save(newMember);
    }

    public List<Member> getAllMembers() {
        return (List<Member>) memberRepository.findAll();
    }

    public Member update(long id, Member updatedMember) {
        Optional<Member> memberToUpdateOptional = memberRepository.findById(id);

        if (memberToUpdateOptional.isPresent()) {
            Member memberToUpdate = memberToUpdateOptional.get();

            memberToUpdate.setName(updatedMember.getName());
            memberToUpdate.setAddress(updatedMember.getAddress());
            memberToUpdate.setEmail(updatedMember.getEmail());
            memberToUpdate.setPhoneNum(updatedMember.getPhoneNum());
            memberToUpdate.setStartDate(updatedMember.getStartDate());
            memberToUpdate.setDuration(updatedMember.getDuration());

            return memberRepository.save(memberToUpdate);
        }
        return null;
    }
    public void deleteMembertById(long id) {
        memberRepository.deleteById(id);
    }

    public Optional<Member> findMemberByName(String name) {
        Optional<Member> membersOptional = memberRepository.findByName(name);
        return membersOptional;
    }
    public Optional<Member> findMemberByPhoneNumber(String phoneNum) {
        Optional<Member> membersOptional = memberRepository.findByPhoneNum(phoneNum);
        return membersOptional;
    }

    public List<Member>findMemberByTournament(String startDate) {
        List<Optional<Tournament>> tournamentOptional = tournamentService.findTournamentByStartDate(startDate);

        if(tournamentOptional.isEmpty()){
            return null;
        }
        List<Member>memberList = new ArrayList<>();

        for(Optional<Tournament> tournamentOp: tournamentOptional ){
            Tournament tournament = tournamentOp.get();
            for(Member member: tournament.getParticipatingMem()){
                if(!memberList.contains(member)){
                    memberList.add(member);
                }
            }

        }

        return memberList;
    }

    public List<Member> findByDuration(String duration) {
        return (List<Member>) memberRepository.findAllByDuration(duration);
    }
}
