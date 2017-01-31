package com.company.services.interfaces;

import com.company.entities.Member;

import java.util.List;

public interface SearchMember {
    Member getMember(long id);
    List<Member> getMemberList();
    List<Member> getProjectManagerList();
    List<Member> getAvailableEmployeeList();
    List<Member> getCustomerList();
}
