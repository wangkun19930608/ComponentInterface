package org.narisq.web.Common.Exception;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.narisq.web.Common.Param.ConcreteCommonParam;

public class ExceptionXmlWriter {
	public static Element getExceptionXml(Exception e, String componentName, Long processTime){
		Document doc = DocumentHelper.createDocument();
		Element stateRoot = doc.addElement("root");
		Element stateNode = stateRoot.addElement("ComponentWorkState");
		
		//添加各节点
		Element componentElement = stateNode.addElement("Component");
		componentElement.setText(componentName);
		
		Element timeElement = stateNode.addElement("Time");
		timeElement.setText(String.valueOf(processTime));
		
		Element stateElement = stateNode.addElement("State");
		
		if(e != null){
			stateElement.setText("Fail");
		
			Element exceptionElement = stateNode.addElement("Exception");
			exceptionElement.addAttribute("Type", e.getClass().getName());
		}
		else{
			stateElement.setText("Success");
		}
		System.out.println(stateNode.asXML());
		return stateRoot;
	}
	
	public static void setExceptionMessage(Element stateRoot, ConcreteCommonParam ccp){
		String sourceXmlString = ccp.getXmlParameterString();
		Document doc = DocumentHelper.createDocument();
		Element docRoot = doc.addElement("root");
		if(!sourceXmlString.equals("")){
			try {
				
				Document sourceDoc = DocumentHelper.parseText(sourceXmlString);
				
				List<Element> sourceStateElements = sourceDoc.getRootElement().elements("ComponentWorkState");
			    List<Element> newStateElements = stateRoot.getDocument().getRootElement().elements("ComponentWorkState");
			    
			    for(Element sourceStateNode : sourceStateElements){
			    	//System.out.println(stateNode.asXML());
			    	sourceStateNode.setParent(null);
			    	docRoot.add(sourceStateNode);
			    }
			    
			    for(Element newStateNode : newStateElements){
			    	//System.out.println(stateNode.asXML());
			    	newStateNode.setParent(null);
			    	docRoot.add(newStateNode);
			    }
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}
		else{
			doc = stateRoot.getDocument();
		}
		
		String newXmlString = doc.asXML();
		ccp.setXmlParameterString(newXmlString);
		
	}
}
