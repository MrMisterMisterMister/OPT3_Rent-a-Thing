package com.rentathing.utils.session;

import com.rentathing.authentication.EmployeeSessionManager;

public interface EmployeeSessionAware {
    void setEmployeeSessionManager(EmployeeSessionManager sessionManager);
}
