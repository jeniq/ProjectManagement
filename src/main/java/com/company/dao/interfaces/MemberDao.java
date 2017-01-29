package com.company.dao.interfaces;

import com.company.entities.Member;
import com.company.entities.Position;

import java.util.List;

/**
 * This interface sets rules for actions with 'member' table in database.
 */
public interface MemberDao extends DmlMethod<Member>{
    Member getMemberById(int id);
    Member getMemberByEmailPassword(String email, String password);
    List<Member> getAllMembers();
    List<Member> getMemberByPosition(Position position);
    List<Member> getEmployeeListByTask(long id);
}
