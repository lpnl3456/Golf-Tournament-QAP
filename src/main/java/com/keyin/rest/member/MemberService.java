package com.keyin.rest.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

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
}
