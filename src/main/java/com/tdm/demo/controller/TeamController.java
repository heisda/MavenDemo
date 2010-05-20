package com.tdm.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tdm.demo.dao.TeamDAO;
import com.tdm.demo.domain.Member;
import com.tdm.demo.domain.Team;
import com.tdm.demo.service.TeamService;

@Controller
public class TeamController {

    @Autowired
    private TeamDAO teamDAO;
    
    @Autowired
    private TeamService teamService;
    
    @RequestMapping("/team/save.htm")
    public String save(Team team){
        teamDAO.saveOrUpdate(team);
        return "saveMembers";
    }
    
    @RequestMapping("/team/listMembers")
    public String list(Integer id, HttpServletResponse response) throws IOException{
        Team team = (Team) teamDAO.get(id);
        for(Member m : team.getMembers()){
            System.out.println(m.getName());
        }
        response.getWriter().write(team.getMembers().size());
        return null;
    }
    
    @RequestMapping("/deleteMember")
    public String deleteMember(Integer teamId, Integer memberId){
        teamService.deleteMember(teamId, memberId);
        return "saveMembers";
    }
    
}
