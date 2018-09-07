package org.narisq.web.Common.Param;

import org.dom4j.Element;
import org.narisq.web.Common.Xml.XmldeSerializer;

public class ParamXmlStringOperator {
	public String XmlParameterString = "";
	public ParamXmlStringOperator() {
		// TODO Auto-generated constructor stub
	}
	
	public void InsertNode(String strParentNodeName, Element ChildNode)
	{
		Element RootElementObj = XmldeSerializer.stringToElement(this.XmlParameterString);
		//RootElementObj.element(arg0)
	}
	
	public Element FindNode(Element ElementObj, String strFindNodeName)
	{
		
		return null;
	}
	
}
