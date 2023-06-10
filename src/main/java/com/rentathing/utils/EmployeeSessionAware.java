package com.rentathing.utils;

import com.rentathing.authentication.EmployeeSessionManager;

public interface EmployeeSessionAware {
    void setEmployeeSessionManager(EmployeeSessionManager sessionManager);
}
