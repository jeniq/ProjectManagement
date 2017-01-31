package com.company.services.impls;

import com.company.dao.interfaces.MemberDao;
import com.company.entities.Member;
import com.company.services.interfaces.Load;
import com.company.services.interfaces.SearchExecutor;
import com.company.services.interfaces.SearchMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class MemberService implements SearchMember, Load, SearchExecutor {

    @Autowired
    private MemberDao memberDao;

    @Override
    public Member getMember(long id) {
        return memberDao.getMemberById(id);
    }

    @Override
    public List<Member> getMemberList() {
        return memberDao.getAllMembers();
    }

    @Override
    public List<Member> getProjectManagerList() {
        return memberDao.getProjectManagerList();
    }

    @Override
    public List<Member> getAvailableEmployeeList() {
        List<Member> employees = memberDao.getAvailableEmployeeList();

        for (int i = 0; i < employees.size(); i++){
            if (employees.get(i).getPosition().getPosName().equals("Project Manager")){
                employees.remove(i);
            }
        }

        return employees;
    }

    @Override
    public List<Member> getCustomerList() {
        return memberDao.getCustomerList();
    }

    @Override
    public Integer getEmployeeLoadPerWeek(Member member, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int week = calendar.get(Calendar.WEEK_OF_YEAR);

        //return taskDao.getEmployeeLoadHoursById(week);
        return null;
    }

    @Override
    public List<Member> getEmployeeListForTask(long id) {
        return memberDao.getEmployeeListByTask(id);
    }
}
