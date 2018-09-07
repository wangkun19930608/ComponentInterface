package org.narisq.web.Common.Xml;

import java.io.StringWriter;

import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class XmlSerializer {

    public XmlSerializer() {
	// TODO Auto-generated constructor stub
    }
    
    public static String XmlElementToString(Element ElementObj)
    {
		StringWriter SWriter = new StringWriter();        
	
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("gb2312");
		XMLWriter Xmlwriter = new XMLWriter( SWriter, format );
	
		try {
		    Xmlwriter.write(ElementObj);
		} catch (Exception e) {
		     e.printStackTrace();
		     return null;
		}
		 return SWriter.toString();
    }
    

}
