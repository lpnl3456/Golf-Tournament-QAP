package com.keyin.rest.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
