package org.narisq.web.Common.Xml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class XmldeSerializer {

	public XmldeSerializer() {
		// TODO Auto-generated constructor stub
	}
	public static Element stringToElement(String XmlElementString){
		Document doc = null; 
	    try 
	    { 
	        doc = DocumentHelper.parseText(XmlElementString); 
	    }catch(Exception ex) 
	    {             
	        //ex.printStackTrace(); 
	        return null;
	    } 
	    return doc.getRootElement(); 
	}

}
