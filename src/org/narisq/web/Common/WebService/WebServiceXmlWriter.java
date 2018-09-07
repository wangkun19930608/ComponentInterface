package org.narisq.web.Common.WebService;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.narisq.web.Common.Component.RPCComponentInformation;

/**
 * 生成组件配置文件
 * @author Cao Jing
 *
 */
public class WebServiceXmlWriter {
	public static void write(RPCComponentInformation rco, String filePath){
		Document doc = DocumentHelper.createDocument();
		Element root = doc.addElement("root");
		
		//添加各节点
		Element componentElement = root.addElement("component");
		
		Element componentNameElement = componentElement.addElement("name");
		componentNameElement.setText(rco.getComponentName());
		
		Element componentCatagoryElement = componentElement.addElement("category");
		componentCatagoryElement.setText(rco.getComponentCategory());
		
		Element componentIpElement = componentElement.addElement("ip");
		componentIpElement.setText(rco.getComponentIP());
		
		Element componentPathElement = componentElement.addElement("path");
		componentPathElement.setText(rco.getComponentPath());
		
		Element componentQnameElement = componentElement.addElement("qname");
		componentQnameElement.setText(rco.getComponentQname());
		
		Element componentServiceNameElement = componentElement.addElement("servicename");
		componentServiceNameElement.setText(rco.getComponentServiceName());
					
		File file = new File(filePath);    
		OutputFormat format = OutputFormat.createPrettyPrint();   
			
		// 指定XML编码   
		format.setEncoding("GB2312");   
			
		//写文件
		try {
			XMLWriter output= new XMLWriter(new FileWriter(file), format);   
			output.write(doc);   
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}  					
	}
}
