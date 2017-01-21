package com.company.services.interfaces;

import com.company.entities.Member;

import java.util.List;

public interface SearchMember {
    Member getMember(long id);
    List<Member> getMemberList();
}
