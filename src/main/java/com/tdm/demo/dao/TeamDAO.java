package com.tdm.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tdm.demo.domain.Member;
import com.tdm.demo.domain.Team;

@Repository("teamDAO")
public class TeamDAO extends AbstractDAO<Team> {
    
    @Autowired
    private MemberDAO memberDAO;

    @SuppressWarnings("unchecked")
    public List<Team> query() {
        return getSession().createCriteria(Team.class).add(
                Restrictions.eq("name", "abc")).createCriteria("members").add(
                Restrictions.ilike("name", "%dada%")).list();
    }

    @SuppressWarnings("unchecked")
    public List<Team> query1() {
        return getSession().createCriteria(Team.class)
                .createCriteria("members").add(
                        Restrictions.ilike("name", "%da%"))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @SuppressWarnings("unchecked")
    public List<Team> query2() {
        String query = "select distinct t from Team as t join t.members as m where m.name like '%da%'";
        return getSession().createQuery(query).list();
    }

    public Long query3() {
        String query = "select count(distinct t) from Team as t join t.members as m where m.name like '%da%'";
        return (Long) getSession().createQuery(query).uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List query4() {
        return getSession().createCriteria(Team.class, "t")
        .add(Restrictions.ilike("name", "%da%"))
            .setProjection(
                Projections.projectionList()
                    .add(Projections.countDistinct("t.id"))
                    .add(Projections.max("t.id"))
                    .add(Projections.min("t.id"))
                )
        .createCriteria("members")
        .list();
    }
    
    public void deleteMember(int teamId, int memberId){
        Team team = (Team) this.get(teamId);
        System.out.println(team.getMembers().size());
        for(Member m : team.getMembers()){
            if(memberId == m.getId()){
                memberDAO.delete(m.getId());
            }
        }
        team.setMembers(new ArrayList<Member>());
        System.out.println(team.getMembers().size());
    }

}
