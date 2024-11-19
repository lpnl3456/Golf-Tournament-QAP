package com.keyin.rest.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return tournamentService.addMemberToTournament( id,  memberID);
    }
}
