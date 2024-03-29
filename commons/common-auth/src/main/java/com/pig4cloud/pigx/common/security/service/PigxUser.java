package com.pig4cloud.pigx.common.security.service;

import lombok.Getter;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @author
 * @date 2018/8/20
 * 扩展用户信息
 */
public class PigxUser extends User {
	/**
	 * 用户ID
	 */
	@Getter
	private Long id;
	@Getter
	private Long prizeTeamId;
	@Getter
	private Long prizeTeamReturnPoint;
	@Getter
	private Long prizeTeamRateDiscount;
	@Getter
	private Long levelId;
//	@Getter
//	private String tenantId;

	/**
	 * Construct the <code>User</code> with the details required by
	 * {@link DaoAuthenticationProvider}.
	 *
	 * @param id                    用户ID
	 * @param username              the username presented to the
	 *                              <code>DaoAuthenticationProvider</code>
	 * @param password              the password that should be presented to the
	 *                              <code>DaoAuthenticationProvider</code>
	 * @param enabled               set to <code>true</code> if the user is enabled
	 * @param accountNonExpired     set to <code>true</code> if the account has not expired
	 * @param credentialsNonExpired set to <code>true</code> if the credentials have not
	 *                              expired
	 * @param accountNonLocked      set to <code>true</code> if the account is not locked
	 * @param authorities           the authorities that should be granted to the caller if they
	 *                              presented the correct username and password and the user is enabled. Not null.
	 * @throws IllegalArgumentException if a <code>null</code> value was passed either as
	 *                                  a parameter or as an element in the <code>GrantedAuthority</code> collection
	 */
	public PigxUser(Long id, String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities,
					long prizeTeamId,
					long prizeTeamReturnPoint,
					long prizeTeamRateDiscount,
					long levelId/*,
					String tenantId*/) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.id = id;
		this.prizeTeamId = prizeTeamId;
		this.prizeTeamReturnPoint = prizeTeamReturnPoint;
		this.prizeTeamRateDiscount=prizeTeamRateDiscount;
		this.levelId = levelId;
//		this.tenantId = tenantId;
	}
}
