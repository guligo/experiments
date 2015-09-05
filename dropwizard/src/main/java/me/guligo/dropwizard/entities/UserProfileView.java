package me.guligo.dropwizard.entities;

import java.util.Date;

/**
 * Database entity that represents user profile view.
 * 
 * @author guligo
 */
public class UserProfileView {

	private Integer targetUserId;
	private Integer viewingUserId;
	private Date timestamp;

	public Integer getTargetUserId() {
		return targetUserId;
	}

	public void setTargetUserId(Integer targetUserId) {
		this.targetUserId = targetUserId;
	}

	public Integer getViewingUserId() {
		return viewingUserId;
	}

	public void setViewingUserId(Integer viewingUserId) {
		this.viewingUserId = viewingUserId;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
