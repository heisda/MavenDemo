package com.tdm.demo.service;

import com.tdm.demo.domain.Team;

public interface TeamService {

    void saveTeamAndMembers(int flag) throws Exception;
    
    void save(Team team);
    
    Team get(Integer id);
    
    void deleteMember(int teamId, int memberId);
}
