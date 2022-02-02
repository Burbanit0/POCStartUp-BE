package com.telecom.pocstartup.service;

import java.util.List;

import com.telecom.pocstartup.domain.WorkTime;

public interface WorkTimeService {
	public List<WorkTime> findAllWorktimes();
	public WorkTime createWorkTime(WorkTime worktime);
}
