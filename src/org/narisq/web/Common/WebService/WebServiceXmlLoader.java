package org.narisq.web.Common.WebService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.narisq.web.Common.Component.RPCComponentInformation;


/**
 * 读取组件配置文件
 * @author Cao Jing
 *
 */
public class WebServiceXmlLoader {
	
	/**
	 * 从配置文件读到对象
	 * @param xmlFile
	 * @return
	 */
	public static List<RPCComponentInformation> loadFromFile(String xmlFile) {		
		SAXReader reader = new SAXReader();
		Document componentXmlDoc = null;
		try {
			File file = new File(xmlFile);
			componentXmlDoc = reader.read(file);
		} catch (DocumentException dex) {
			dex.printStackTrace();
			return null;
		}
		return docToRCO(componentXmlDoc);
	}
	
	
	/**
	 * 从字符串读到对象
	 * @param xmlDocStr
	 * @return
	 */
	public static List<RPCComponentInformation> loadFromString(String xmlDocStr){
		
		Document componentXmlDoc = null;
		try {
			componentXmlDoc = DocumentHelper.parseText(xmlDocStr);
		} catch (DocumentException dex) {
			dex.printStackTrace();
		}
		
		return docToRCO(componentXmlDoc);		
	}
	
	
	/**
	 * 从配置文件读到字符串
	 * @param xmlFile
	 * @return
	 */
	public static String loadStringFromFile(String xmlFile) {
		SAXReader reader = new SAXReader();
		Document componentXmlDoc = null;
		try {
			File file = new File(xmlFile);
			componentXmlDoc = reader.read(file);
		} catch (DocumentException dex) {
			dex.printStackTrace();
			return null;
		}
		return docToString(componentXmlDoc);
	}
	
	/**
	 * 私有方法，xml文档转内部类对象
	 * @param doc
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static List<RPCComponentInformation> docToRCO(Document doc) {

		Element root = doc.getRootElement();//org.dom4j.tree.DefaultDocument@125ff34 [Document: name file:///c:/ComponentRegistration/workflowmanager.xml]
		List<Element> ElementList = root.elements("component");
		List<RPCComponentInformation> RPCComponentInformationList = new ArrayList<RPCComponentInformation>();
	    for(int i = 0; i<ElementList.size(); i++)
	    {
	    	Element componentElement = ElementList.get(i);
			RPCComponentInformation rco = new RPCComponentInformation();
			rco.setComponentName(componentElement.elementTextTrim("name"));//org.narisq.web.Common.Component.RPCComponentInformation@b18df5
			rco.setComponentCategory(componentElement.elementTextTrim("category"));//workflowmanager
			rco.setComponentIP(componentElement.elementTextTrim("ip"));	//127.0.0.1
			rco.setComponentPort(Integer.parseInt(componentElement.elementTextTrim("port")));//8080
			rco.setComponentPath(componentElement.elementTextTrim("path"));//WorkFlowManager
			rco.setComponentQname(componentElement.elementTextTrim("qname"));//http://WorkFlow.web.narisq.org/
			rco.setComponentServiceName(componentElement.elementTextTrim("servicename")); 	//RegisterComponentPort
			RPCComponentInformationList.add(rco);
	    	
	    }		
		return RPCComponentInformationList;
	}
	
	/**
	 * 私有方法，xml文档转成字符串
	 * @param doc
	 * @return
	 */
	private static String docToString(Document doc) {
		String retStr = doc.asXML();
		return retStr;
	}
	
}
