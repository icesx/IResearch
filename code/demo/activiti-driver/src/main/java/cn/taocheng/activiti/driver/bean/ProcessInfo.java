/**
 * Program  : ProcessInfo.java<br/>
 * Author   : i<br/>
 * Create   : Oct 25, 2019 9:53:55 AM<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.driver.bean;

import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;

public class ProcessInfo {
	public ProcessInfo() {
	}

	private String id;

	private String category;

	private String name;

	private String key;

	private String description;

	private int version;

	private String esourceName;

	private String deploymentId;

	private String diagramResourceName;

	private boolean hasStartFormKey;

	private boolean hasGraphicalNotation;

	private boolean isSuspended;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getEsourceName() {
		return esourceName;
	}

	public void setEsourceName(String esourceName) {
		this.esourceName = esourceName;
	}

	public String getDeploymentId() {
		return deploymentId;
	}

	public void setDeploymentId(String deploymentId) {
		this.deploymentId = deploymentId;
	}

	public String getDiagramResourceName() {
		return diagramResourceName;
	}

	public void setDiagramResourceName(String diagramResourceName) {
		this.diagramResourceName = diagramResourceName;
	}

	public boolean isHasStartFormKey() {
		return hasStartFormKey;
	}

	public void setHasStartFormKey(boolean hasStartFormKey) {
		this.hasStartFormKey = hasStartFormKey;
	}

	public boolean isHasGraphicalNotation() {
		return hasGraphicalNotation;
	}

	public void setHasGraphicalNotation(boolean hasGraphicalNotation) {
		this.hasGraphicalNotation = hasGraphicalNotation;
	}

	public boolean isSuspended() {
		return isSuspended;
	}

	public void setSuspended(boolean isSuspended) {
		this.isSuspended = isSuspended;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	ProcessInfo(String id2, String key2, String name2, String deploymentId2, String resourceName, int version) {
		this.id = id2;
		this.key = key2;
		this.name = name2;
		this.deploymentId = deploymentId2;
		this.diagramResourceName = resourceName;
		this.version = version;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private String id;

		private String deploymentId;

		private String key;

		private int version;

		private String resourceName;

		private String name;

		public Builder withProcessDefine(ProcessDefinition definition) {
			this.id = definition.getId();
			this.key = definition.getKey();
			this.deploymentId = definition.getDeploymentId();
			this.name = definition.getName();
			this.resourceName = definition.getResourceName();
			this.version = definition.getVersion();
			return this;
		}

		public ProcessInfo build() {
			return new ProcessInfo(id, key, name, deploymentId, resourceName, version);

		}

		public Builder withProcessDefine(ProcessInstance processInstance) {
			this.id = processInstance.getId();
			this.key = processInstance.getProcessDefinitionKey();
			this.name = processInstance.getName();
			this.deploymentId = processInstance.getDeploymentId();
			this.version = processInstance.getProcessDefinitionVersion();
			return this;
		}
	}

	@Override
	public String toString() {
		return "ProcessInfo [id=" + id + ", category=" + category + ", name=" + name + ", key=" + key + ", description=" + description + ", version=" + version + ", esourceName=" + esourceName + ", deploymentId=" + deploymentId + ", diagramResourceName=" + diagramResourceName + ", hasStartFormKey=" + hasStartFormKey + ", hasGraphicalNotation=" + hasGraphicalNotation + ", isSuspended=" + isSuspended + ", tenantId=" + tenantId + "]";
	}

}
