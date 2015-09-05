package me.guligo.dropwizard.tasks;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import me.guligo.dropwizard.services.UserProfileService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Scheduled task responsible for cleaning up database on a periodic basis.
 * 
 * @author guligo
 */
public class DBCleanupTask {

	private final static Logger logger = LoggerFactory.getLogger(DBCleanupTask.class.getName());

	private class DBCleanupRunnable implements Runnable {

		public void run() {
			userProfileService.removeUserProfileViews();
		}

	}

	private UserProfileService userProfileService;

	public DBCleanupTask(UserProfileService userProfileService) {
		this.userProfileService = userProfileService;
	}

	public void start() {
		logger.info("Database cleanup task scheduled");

		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(new DBCleanupRunnable(), 0, 1, TimeUnit.HOURS);
	}

}
