package me.guligo.dropwizard.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import me.guligo.dropwizard.services.UserProfileService;
import me.guligo.dropwizard.utils.MappingUtils;

/**
 * Provides REST interface for operating with user profile and other logically
 * related entities.
 * 
 * @author guligo
 */
@Path("/userProfiles")
@Produces(MediaType.APPLICATION_JSON)
public class UserProfileResource {

	private UserProfileService userProfileService;

	public UserProfileResource(UserProfileService userProfileService) {
		this.userProfileService = userProfileService;
	}

	@Path("/{targetUserId}/views/{viewingUserId}")
	@PUT
	public void createUserProfileView(@PathParam("targetUserId") Integer targetUserId, @PathParam("viewingUserId") Integer viewingUserId) {
		userProfileService.createUserProfileView(targetUserId, viewingUserId);
	}

	@Path("/{targetUserId}/views")
	@GET
	public List<UserProfileViewModel> getUserProfileViews(@PathParam("targetUserId") Integer targetUserId) {
		return MappingUtils.toUserProfileViewModelList(userProfileService.getUserProfileViews(targetUserId));
	}

}
