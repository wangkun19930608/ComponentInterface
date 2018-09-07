package org.narisq.web.Common.Data;

import java.io.IOException;

public class DataXmlDescriptor  implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8757874930128640942L;
	private  String XmlDescriptString;
	public DataXmlDescriptor() {
		// TODO Auto-generated constructor stub
	}
	public String getXmlDescriptString() {
		return XmlDescriptString;
	}
	public void setXmlDescriptString(String xmlDescriptString) {
		XmlDescriptString = xmlDescriptString;
	}
	private void writeObject(java.io.ObjectOutputStream out) throws IOException {   

	    out.writeObject(this.XmlDescriptString);
	    
	}   
	  
	private void readObject(java.io.ObjectInputStream in) throws IOException,   
	        ClassNotFoundException {   
	    this.XmlDescriptString = (String) in.readObject();      
	}	

}
