package com.telecom.pocstartup.utils;

import java.time.LocalDate;

import lombok.Data;

@Data
public class WorkTimeData {
	private LocalDate date;
	private Long duration;
}
