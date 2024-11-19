package com.keyin.rest.tournament;

import com.keyin.rest.member.Member;
import com.keyin.rest.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
}
