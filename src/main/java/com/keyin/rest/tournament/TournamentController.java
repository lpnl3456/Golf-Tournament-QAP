package com.keyin.rest.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TournamentController {
    @Autowired
    private TournamentRepository tournamentRepository;
}
