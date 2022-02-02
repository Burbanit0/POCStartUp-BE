package com.telecom.pocstartup.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.pocstartup.domain.User;
import com.telecom.pocstartup.domain.WorkTime;
import com.telecom.pocstartup.repository.WorkTimeRepository;
import com.telecom.pocstartup.service.WorkTimeService;

@Service
public class WorkTimeServiceImpl implements WorkTimeService {

	@Autowired 
	WorkTimeRepository worktimeRepository;

	@Override
	public List<WorkTime> findAllWorktimes() {
		return this.worktimeRepository.findAll();
	}
}
