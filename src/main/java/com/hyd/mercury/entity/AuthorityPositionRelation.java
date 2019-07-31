package com.hyd.mercury.entity;

public class AuthorityPositionRelation {
	
    private String uuid;

    private String positionUuid;

    private String authorityUuid;

    private Integer isHidden;

    private Integer createTime;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getPositionUuid() {
		return positionUuid;
	}

	public void setPositionUuid(String positionUuid) {
		this.positionUuid = positionUuid;
	}

	public String getAuthorityUuid() {
		return authorityUuid;
	}

	public void setAuthorityUuid(String authorityUuid) {
		this.authorityUuid = authorityUuid;
	}

	public Integer getIsHidden() {
		return isHidden;
	}

	public void setIsHidden(Integer isHidden) {
		this.isHidden = isHidden;
	}

	public Integer getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	} 
}