package com.tdm.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tdm.demo.dao.MemberDAO;
import com.tdm.demo.domain.Member;
import com.tdm.demo.service.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDAO memberDAO;
    
    public Member get(Integer id) {
        return (Member) memberDAO.get(id);
    }

    public Member save(Member member) {
        memberDAO.saveOrUpdate(member);
        return member;
    }

}
