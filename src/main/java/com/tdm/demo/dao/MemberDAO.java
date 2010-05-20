package com.tdm.demo.dao;

import org.springframework.stereotype.Repository;

import com.tdm.demo.domain.Member;

@Repository("memberDAO")
public class MemberDAO extends AbstractDAO<Member> {

}
