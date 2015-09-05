package me.guligo.dropwizard.dao;

import java.util.List;

import me.guligo.dropwizard.entities.UserProfileView;
import me.guligo.dropwizard.utils.MappingUtils;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 * Provides persistence layer functionality for operating with user profile and
 * other related database entities.
 * 
 * @author guligo
 */
@RegisterMapper(MappingUtils.UserProfileViewMapper.class)
public interface UserProfileDAO {

	@SqlUpdate("create table if not exists user_profile_views (id identity, target_user_id integer, viewing_user_id integer, timestamp timestamp)")
	void createUserProfileViewTable();

	@SqlUpdate("insert into user_profile_views (target_user_id, viewing_user_id, timestamp) values (:targetUserId, :viewingUserId, :timestamp)")
	void createUserProfileView(@BindBean UserProfileView userProfileView);

	@SqlQuery("select target_user_id, viewing_user_id, timestamp from user_profile_views where target_user_id = :targetUserId and unix_millis(now()) - unix_millis(timestamp) <= 10 * 24 * 60 * 60 * 1000 order by timestamp desc limit 10")
	List<UserProfileView> getUserProfileViews(@Bind("targetUserId") Integer targetUserId);

	@SqlQuery("select target_user_id from user_profile_views group by target_user_id")
	List<Integer> getTargetUserIds();

	@SqlUpdate("delete from user_profile_views where unix_millis(now()) - unix_millis(timestamp) > 10 * 24 * 60 * 60 * 1000")
	void removeOutdatedUserProfileViews();

	@SqlUpdate("delete from user_profile_views where target_user_id = :targetUserId and id in (select id from user_profile_views order by timestamp desc offset 10)")
	void removeUnreachableUserProfileViews(@Bind("targetUserId") Integer targetUserId);

}
