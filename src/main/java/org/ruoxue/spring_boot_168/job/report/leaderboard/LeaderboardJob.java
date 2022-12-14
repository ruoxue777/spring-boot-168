package org.ruoxue.spring_boot_168.job.report.leaderboard;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@ConditionalOnProperty(name = "scheduling.enable", havingValue = "true")
public class LeaderboardJob {

	@Scheduled(initialDelay = 3000, fixedRate = 3000)
	public void secondBoard() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		log.info("secondBoard: " + sdf.format(new Date()));
		try {
			Thread.sleep(10_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Scheduled(initialDelay = 3000, fixedRate = 60000)
	public void minuteBoard() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		log.info("minuteBoard: " + sdf.format(new Date()));
	}
}
