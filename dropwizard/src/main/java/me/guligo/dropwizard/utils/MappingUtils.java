package me.guligo.dropwizard.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import me.guligo.dropwizard.entities.UserProfileView;
import me.guligo.dropwizard.rest.UserProfileViewModel;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 * Provides helper functions for mapping between instances of different classes.
 * 
 * @author guligo
 */
public class MappingUtils {

	public static class UserProfileViewMapper implements ResultSetMapper<UserProfileView> {

		public UserProfileView map(int index, ResultSet rs, StatementContext ctx) throws SQLException {
			UserProfileView userProfileView = new UserProfileView();
			userProfileView.setTargetUserId(rs.getInt("target_user_id"));
			userProfileView.setViewingUserId(rs.getInt("viewing_user_id"));
			userProfileView.setTimestamp(rs.getTimestamp("timestamp"));
			return userProfileView;
		}

	}

	public static List<UserProfileViewModel> toUserProfileViewModelList(List<UserProfileView> userProfileViewList) {
		List<UserProfileViewModel> userProfileViewModelList = new ArrayList<UserProfileViewModel>();
		if (userProfileViewList != null) {
			for (UserProfileView userProfileView : userProfileViewList) {
				UserProfileViewModel userProfileViewModel = new UserProfileViewModel();
				userProfileViewModel.setUserId(userProfileView.getViewingUserId());
				userProfileViewModel.setTimestamp(userProfileView.getTimestamp());
				userProfileViewModelList.add(userProfileViewModel);
			}
		}
		return userProfileViewModelList;
	}

}
