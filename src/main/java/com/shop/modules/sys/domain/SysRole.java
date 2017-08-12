package com.shop.modules.sys.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class SysRole implements Serializable {

	/**
	 * 角色ID
	 */
	@Id
	@GeneratedValue
	private Long id;

	/**
	 * 角色名称
	 */
	@NotBlank(message="角色名称不能为空")
	private String name;

	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 创建者
	 */
	/**
	 * 创建者
	 */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "userId",insertable = false,updatable = false)
	@JsonIgnore
	private SysUser sysUser;

	private Long userId;


	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
			name = "sys_role_menu",
			joinColumns = @JoinColumn(name = "roleId", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "menuId", referencedColumnName = "id")

	)
	@JsonIgnore
	private Set<SysMenu> sysMenus;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
			name = "sys_role_user",
			joinColumns = @JoinColumn(name = "roleId", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "userId", referencedColumnName = "id")

	)
	@JsonIgnore
	private Set<SysUser> sysUsers;

	/**
	 * 创建时间
	 */
	@Column(nullable = true, columnDefinition = "timestamp default current_timestamp")
	private Date created;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public Set<SysMenu> getSysMenus() {
		return sysMenus;
	}

	public void setSysMenus(Set<SysMenu> sysMenus) {
		this.sysMenus = sysMenus;
	}

	public Set<SysUser> getSysUsers() {
		return sysUsers;
	}

	public void setSysUsers(Set<SysUser> sysUsers) {
		this.sysUsers = sysUsers;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
