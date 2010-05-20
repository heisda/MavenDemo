package com.tdm.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tdm.demo.dao.MemberDAO;
import com.tdm.demo.dao.TeamDAO;
import com.tdm.demo.domain.Member;
import com.tdm.demo.domain.Team;
import com.tdm.demo.service.TeamService;

@Transactional(rollbackFor = {Throwable.class})
@Service("teamService")
public class TeamServiceImpl implements TeamService {
    
    @Autowired
    private TeamDAO teamDAO;
    
    @Autowired
    private MemberDAO memberDAO;

    public void saveTeamAndMembers(int flag) throws Exception {
        Team team = new Team();
        team.setName("ManUtd");
        save(team);
        if(flag == 1){
            throw new Exception("occur error");
        }
        Member member = new Member();
        member.setName("J8");
        member.setTeam(team);
        memberDAO.saveOrUpdate(member);
    }

    public void save(Team team) {
       teamDAO.saveOrUpdate(team);
    }

    public Team get(Integer id) {
        return (Team) teamDAO.get(id);
    }

    public void deleteMember(int teamId, int memberId) {
        this.teamDAO.deleteMember(teamId, memberId);
    }

}
