package com.company.services.interfaces;

import com.company.entities.Member;
import com.company.entities.Task;

public interface EditTask {
    boolean create(Task task, Member executor);
}
