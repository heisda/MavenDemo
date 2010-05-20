package com.tdm.demo.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TeamServiceTest extends TestBase {

    @Autowired
    private TeamService teamServcie;
    
    @Test
    public void test() throws Exception{
        teamServcie.saveTeamAndMembers(2);
    }
    
    @Test
    public void test1() throws Exception{
        teamServcie.saveTeamAndMembers(1);
    }
}
