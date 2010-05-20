package com.tdm.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tdm.demo.domain.Member;
import com.tdm.demo.domain.Team;
import com.tdm.demo.service.MemberService;
import com.tdm.demo.service.TeamService;

@Controller
public class MemberController {

    @Autowired
    private TeamService teamService;
    
    @Autowired
    private MemberService memberService;
    
    @RequestMapping("/member/add")
    public String addMember(@RequestParam("teamId")Integer id){
        Team team = teamService.get(id);
        Member member = new Member();
        member.setName("dada");
        member.setTeam(team);
        memberService.save(member);
        return "ok";
    }
}
