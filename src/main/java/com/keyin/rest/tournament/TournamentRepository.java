package com.keyin.rest.tournament;

import com.keyin.rest.member.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TournamentRepository extends CrudRepository<Tournament, Long> {

    public List<Optional<Tournament>> findByStartDate(String startDate);

    public List<Optional<Tournament>> findByLocation(String location);

}
