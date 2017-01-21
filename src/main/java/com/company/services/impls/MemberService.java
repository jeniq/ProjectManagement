package com.company.services.impls;

import com.company.dao.interfaces.MemberDao;
import com.company.entities.Member;
import com.company.services.interfaces.SearchMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService implements SearchMember{

    @Autowired
    private MemberDao memberDao;

    @Override
    public Member getMember(long id) {
        return null;
    }

    @Override
    public List<Member> getMemberList() {
        return memberDao.getAllMembers();
    }
}
