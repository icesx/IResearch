/**
 * Program  : ProcessInfo.java<br/>
 * Author   : i<br/>
 * Create   : Oct 25, 2019 9:53:55 AM<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.bean;

import java.util.Date;

import org.activiti.engine.repository.Deployment;

public class DeploymentInfo {
	public DeploymentInfo() {
	}

	private String id;

	private String category;

	private String name;

	private String key;

	private Date deploymentTime;

	private String tenantId;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public Date getDeploymentTime() {
		return deploymentTime;
	}

	public void setDeploymentTime(Date deploymentTime) {
		this.deploymentTime = deploymentTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	DeploymentInfo(String id, String key, String name, Date deploymentTime, String tenantId, String category) {
		this.id = id;
		this.key = key;
		this.name = name;
		this.tenantId = tenantId;
		this.deploymentTime = deploymentTime;
		this.category = category;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private String id;

		private String category;

		private String name;

		private String key;

		private Date deploymentTime;

		private String tenantId;

		public Builder withDeployment(Deployment deployment) {
			this.id = deployment.getId();
			this.key = deployment.getKey();
			this.category = deployment.getCategory();
			this.name = deployment.getName();
			this.deploymentTime = deployment.getDeploymentTime();
			this.category = deployment.getCategory();
			return this;
		}

		public DeploymentInfo build() {
			return new DeploymentInfo(id, key, name, deploymentTime, tenantId, category);

		}

	}

	@Override
	public String toString() {
		return "DeploymentInfo [id=" + id + ", category=" + category + ", name=" + name + ", key=" + key + ", deploymentTime=" + deploymentTime + ", tenantId=" + tenantId + "]";
	}

}
