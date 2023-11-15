package com.diginamic.BestiolesREST.cron;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CronService {
	
	@Value("${cron.value}")
	private String value;
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Scheduled(cron = "${cron.value}")
	public void cron() {
		LOG.info(">>>>> CRON <<<<<");
		LOG.info(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)));
	}

}
