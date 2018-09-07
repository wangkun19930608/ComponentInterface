package org.narisq.web.Common.Component;

public class RPCComponentInformation {
	private String componentName;
	private String componentCategory;
	private String componentIP;
	private int componentPort;
 	private String componentPath;
	private String componentQname;
	private String componentServiceName;
	
	public String getComponentIP() {
		return componentIP;
	}

	public void setComponentIP(String componentIP) {
		this.componentIP = componentIP;
	}

	public int getComponentPort() {
		return componentPort;
	}

	public void setComponentPort(int componentPort) {
		this.componentPort = componentPort;
	}

	public String getComponentQname() {
		return componentQname;
	}

	public void setComponentQname(String componentQname) {
		this.componentQname = componentQname;
	}


	public String getComponentPath() {
		return componentPath;
	}

	public void setComponentPath(String componentPath) {
		this.componentPath = componentPath;
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public String getComponentCategory() {
		return componentCategory;
	}

	public void setComponentCategory(String componentCategory) {
		this.componentCategory = componentCategory;
	}

	public String getComponentServiceName() {
		return componentServiceName;
	}

	public void setComponentServiceName(String componentServiceName) {
		this.componentServiceName = componentServiceName;
	}

}
