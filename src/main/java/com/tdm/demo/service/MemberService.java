package com.tdm.demo.service;

import com.tdm.demo.domain.Member;

public interface MemberService {

    Member get(Integer id);
    
    Member save(Member member);
}
