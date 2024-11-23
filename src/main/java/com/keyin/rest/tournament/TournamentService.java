package com.keyin.rest.tournament;

import com.keyin.rest.member.Member;
import com.keyin.rest.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {
    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private MemberRepository memberRepository;

    public Tournament createTournament(Tournament newTournament) {
        return tournamentRepository.save(newTournament);
    }

    public List<Tournament> getAllTournaments() {
        return (List<Tournament>) tournamentRepository.findAll();
    }

    public Tournament addMemberToTournament(long tournamentID, long memberID) {

        Optional<Tournament> tournamentOptional =  tournamentRepository.findById(tournamentID);

        Tournament tournament = tournamentOptional.get();
        Optional<Member> memberOptional = memberRepository.findById(memberID);

        if (memberOptional.isEmpty()) {

            return null;
        }



        Member member = memberOptional.get();

        if(tournament.getParticipatingMem().contains(member)){
            return null;
        }
        tournament.addMember(member);
         return update(tournamentID, tournament);
    }

    public Tournament update(long id, Tournament updatedTournament) {
        Optional<Tournament> tournamenttoUpdateOptional = tournamentRepository.findById(id);

        if (tournamenttoUpdateOptional.isPresent()) {
            Tournament tournamentToUpdate = tournamenttoUpdateOptional.get();

            tournamentToUpdate.setStartDate(updatedTournament.getStartDate());
            tournamentToUpdate.setEndDate(updatedTournament.getEndDate());
            tournamentToUpdate.setLocation(updatedTournament.getLocation());
            tournamentToUpdate.setEntryFee(updatedTournament.getEntryFee());
            tournamentToUpdate.setPrizeAmount(updatedTournament.getPrizeAmount());
            tournamentToUpdate.setParticipatingMem(updatedTournament.getParticipatingMem());

            return tournamentRepository.save(tournamentToUpdate);
        }
        return null;
    }

    public List<Optional<Tournament>> findTournamentByStartDate(String tournamnetDate) {
        List<Optional<Tournament>> tournamentsOptional = tournamentRepository.findByStartDate(tournamnetDate);
        return tournamentsOptional;
    }

    public List<Optional<Tournament>> findTournamentByLocation(String location) {
        List<Optional<Tournament>> tournamentsOptional = tournamentRepository.findByLocation(location);
        return tournamentsOptional;
    }

    public List<Member> findTournamentMembers(long id) {
        Optional<Tournament> tournamentOptional = tournamentRepository.findById(id);

        if(tournamentOptional.isEmpty()){
            return null;
        }

        Tournament tournaments = tournamentOptional.get();
        List<Member> memParticapting = new ArrayList<Member>();

        for(Member member: tournaments.getParticipatingMem()){
            if(!memParticapting.contains(member)){
                memParticapting.add(member);
            }
        }

        return memParticapting;
    }


}
