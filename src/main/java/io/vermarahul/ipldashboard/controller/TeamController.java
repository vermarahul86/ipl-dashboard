package io.vermarahul.ipldashboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.vermarahul.ipldashboard.model.Team;
import io.vermarahul.ipldashboard.repository.MatchRepository;
import io.vermarahul.ipldashboard.repository.TeamRepository;

@RestController
public class TeamController {

   // @Autowired
    private TeamRepository teamRepository;
    private MatchRepository matchRepository;

    
    public TeamController(TeamRepository teamRepository, MatchRepository matchRepository){
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    } 

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable("teamName") String teamName){
         Team team = teamRepository.findByTeamName(teamName);
         team.setMatches(matchRepository.findLatestMatchesbyTeam(teamName, 5));
         return team;
    }
    
}
