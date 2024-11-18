package com.keyin.rest.tournament;

import com.keyin.rest.member.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends CrudRepository<Tournament, Long> {
}
