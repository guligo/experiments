package me.guligo.dropwizard;

import me.guligo.dropwizard.dao.UserProfileDAO;
import me.guligo.dropwizard.rest.UserProfileResource;
import me.guligo.dropwizard.services.UserProfileService;
import me.guligo.dropwizard.tasks.DBCleanupTask;

import org.skife.jdbi.v2.DBI;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;

/**
 * Dropwizard style application.
 * 
 * @author guligo
 */
public class App extends Application<AppConfig> {

	public static void main(String[] args) throws Exception {
		App app = new App();
		app.run(args);
	}

	@Override
	public void run(AppConfig config, Environment environment) throws Exception {
		DBIFactory factory = new DBIFactory();
		DBI jdbi = factory.build(environment, config.getDataSourceFactory(), "hsqldb");

		UserProfileDAO userProfileDAO = jdbi.onDemand(UserProfileDAO.class);
		userProfileDAO.createUserProfileViewTable();
		UserProfileService userProfileService = new UserProfileService(userProfileDAO);

		UserProfileResource userProfileResource = new UserProfileResource(userProfileService);
		environment.jersey().register(userProfileResource);

		DBCleanupTask cleanupTask = new DBCleanupTask(userProfileService);
		cleanupTask.start();
	}

}
