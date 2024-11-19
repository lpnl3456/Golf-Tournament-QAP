package com.keyin.rest.member;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  MemberRepository extends CrudRepository<Member, Long> {

    public Optional<Member> findByName(String name);
}
