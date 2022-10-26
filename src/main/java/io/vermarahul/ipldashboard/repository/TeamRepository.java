package io.vermarahul.ipldashboard.repository;

import org.springframework.data.repository.CrudRepository;

import io.vermarahul.ipldashboard.model.Team;

public interface TeamRepository extends CrudRepository<Team, Long>  {

    /*Spring JPA is going to start after finaBy 
    - How do you want to find - TeamName so it is going to use this for the query. */
    Team findByTeamName(String teamName);
    
}
