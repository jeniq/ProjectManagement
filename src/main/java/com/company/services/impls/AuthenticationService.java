package com.company.services.impls;

import com.company.dao.interfaces.MemberDao;
import com.company.entities.Member;
import com.company.services.interfaces.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements Security {

    @Autowired
    private MemberDao memberDao;

    @Override
    public Member login(Member member) {
        member = memberDao.getMemberByEmailPassword(member.getEmail(), member.getPassword());

        if (member == null) {
            return null;
        }

        return member;
    }

    @Override
    public void logout(Member member) {

    }
}
