import {React, useEffect, useState} from 'react';
import { MatchDetailCard } from '../components/MatchDetailCard';
import { MatchSmallCard } from '../components/MatchSmallCard';

export const TeamPage = () =>  {

    //Empty inital so that it is not undefined on the pageLoad useState({})
    const [team, setTeam] = useState({}); 
    
    useEffect(
        () => {
            const fetchMatches = async () => { 
                const response = await fetch('http://localhost:8080/team/Rajasthan Royals');
                const data = await response.json();
                setTeam(data);
            };
            fetchMatches();
        },[] //call only once 
    );

  return (
    <div className="TeamPage">
      <h1>{team.teamName}</h1>
      <MatchDetailCard match={team.matches[0]}/>
      {team.matches.slice(1).map(match => <MatchSmallCard match={match}/> )}  
    </div>
  );
}

