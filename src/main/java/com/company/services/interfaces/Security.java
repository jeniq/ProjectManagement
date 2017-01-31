package com.company.services.interfaces;

import com.company.entities.Member;

public interface Security {
    Member login(Member member);
    
    void logout(Member member);
}
