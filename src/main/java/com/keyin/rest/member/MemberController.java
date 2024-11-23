package com.keyin.rest.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/member")
    public Member createMember(@RequestBody Member newMember) {
        return memberService.createMember(newMember);
    }

    @GetMapping("/member")
    public List<Member> getMember() {
        return memberService.getAllMembers();
    }

    @PutMapping("/member/{id}")
    public Member updateMember(@PathVariable long id, @RequestBody Member member) {
        return memberService.update(id, member);
    }

    @DeleteMapping("/member/{id}")
    public void deleteMember(@PathVariable long id) {
         memberService.deleteMembertById(id);
    }

    @GetMapping("/member/name/{name}")
    public Optional<Member> findMemberByName(@PathVariable String name) {
        return memberService.findMemberByName(name);
    }

    @GetMapping("/member/phone/{phoneNum}")
    public Optional<Member> findMemberByPhoneNum(@PathVariable String phoneNum) {
        return memberService.findMemberByPhoneNumber(phoneNum);
    }

    @GetMapping("/member/tournament/{startDate}")
    public List<Member> findMemberByStartDate(@PathVariable String startDate) {
        return memberService.findMemberByTournament(startDate);
    }

    @GetMapping("/member/duration/{duration}")
    public List<Member> findMemberByDuration(@PathVariable String duration) {
        return memberService.findByDuration(duration);
    }
}
