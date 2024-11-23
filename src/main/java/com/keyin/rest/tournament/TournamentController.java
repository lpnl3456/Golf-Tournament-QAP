package com.keyin.rest.tournament;

import com.keyin.rest.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class TournamentController {
    @Autowired
    private TournamentService tournamentService;

    @PostMapping("/tournament")
    public Tournament createTournament(@RequestBody Tournament newTournament){
        return tournamentService.createTournament(newTournament);
    }
    @GetMapping("/tournament")
    public List<Tournament> getAllTournaments(){
        return tournamentService.getAllTournaments();
    }

    @PutMapping("/tournament/{id}/{memberID}")
    public Tournament addMember(@PathVariable long id, @PathVariable long memberID){
        return tournamentService.addMemberToTournament( id, memberID);
    }

    @GetMapping("/tournament/{tournamentDate}")
    public List<Optional<Tournament>> findTournamentByStartDate(@PathVariable String tournamentDate){
        return tournamentService.findTournamentByStartDate(tournamentDate);
    }

    @GetMapping("/tournament/location/{location}")
    public List<Optional<Tournament>> findTournamentByLocation(@PathVariable String location){
        return tournamentService.findTournamentByLocation(location);
    }

    @GetMapping("/tournament/member/{id}")
    public List<Member> findTournamentMembers(@PathVariable long id){
        return tournamentService.findTournamentMembers(id);
    }
}
