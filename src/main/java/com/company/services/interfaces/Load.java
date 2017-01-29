package com.company.services.interfaces;

import com.company.entities.Member;

import java.util.Date;

public interface Load {
    Integer getEmployeeLoadPerWeek(Member member, Date date);
}
