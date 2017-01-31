package com.company.services.interfaces;

import com.company.entities.Member;

import java.util.List;

public interface SearchExecutor {
    List<Member> getEmployeeListForTask(Long id);
}
