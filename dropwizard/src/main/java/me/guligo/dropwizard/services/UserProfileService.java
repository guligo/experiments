package me.guligo.dropwizard.services;

import java.util.Date;
import java.util.List;

import me.guligo.dropwizard.dao.UserProfileDAO;
import me.guligo.dropwizard.entities.UserProfileView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides business logic for user profile and other logically related
 * entities.
 * 
 * @author guligo
 */
public class UserProfileService {

	private final static Logger logger = LoggerFactory.getLogger(UserProfileService.class.getName());

	private UserProfileDAO userProfileDAO;

	public UserProfileService(UserProfileDAO userProfileDAO) {
		this.userProfileDAO = userProfileDAO;
	}

	public void createUserProfileView(Integer targetUserId, Integer viewingUserId) {
		if (targetUserId.equals(viewingUserId)) {
			return;
		}

		logger.debug("Creating user profile view with targetUserId = " + targetUserId + " and viewingUserId = " + viewingUserId);

		UserProfileView userProfileView = new UserProfileView();
		userProfileView.setTargetUserId(targetUserId);
		userProfileView.setViewingUserId(viewingUserId);
		userProfileView.setTimestamp(new Date());

		userProfileDAO.createUserProfileView(userProfileView);
	}

	public List<UserProfileView> getUserProfileViews(Integer targetUserId) {
		logger.debug("Retrieving user profile view list for user with targetUserId = " + targetUserId);

		return userProfileDAO.getUserProfileViews(targetUserId);
	}

	public void removeUserProfileViews() {
		logger.debug("Cleaning up database");

		userProfileDAO.removeOutdatedUserProfileViews();
		for (Integer targetUserId : userProfileDAO.getTargetUserIds()) {
			userProfileDAO.removeUnreachableUserProfileViews(targetUserId);
		}
	}

}
