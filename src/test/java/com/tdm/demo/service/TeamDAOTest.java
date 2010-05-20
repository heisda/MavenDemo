package com.tdm.demo.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tdm.demo.dao.TeamDAO;
import com.tdm.demo.domain.Team;

public class TeamDAOTest extends TestBase {

    @Autowired
    private TeamDAO teamDAO;
    
    @Test
    public void test1(){
        printTeams(teamDAO.query());
    }

    @Test
    public void test2(){
        printTeams(teamDAO.query1());
    }
    
    @Test
    public void test3(){
        printTeams(teamDAO.query2());
    }
    
    @Test
    public void test4(){
        System.out.println(teamDAO.query3());
    }
    
    @Test
    public void test5(){
        System.out.println(teamDAO.query4().get(0));
    }
    
    @Test
    public void testDeleteMember(){
        teamDAO.deleteMember(1, 6);
    }
    
    private void printTeams(List<Team> teams){
        int size = teams.size();
        System.out.println(size);
        for(Team team : teams){
            System.out.println(team.getName());
        } 
    }
}
