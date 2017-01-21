package com.company.dao.interfaces;

import com.company.entities.Member;
import com.company.entities.Project;

import java.util.List;

public interface ProjectConsumerDao extends DmlMethod<Integer>{
    List<Member> getMemberByProjectId(int id);
    List<Project> getProjectByMemberId(int id);
}
