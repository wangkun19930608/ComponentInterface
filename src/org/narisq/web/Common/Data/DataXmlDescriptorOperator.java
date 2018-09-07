package org.narisq.web.Common.Data;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
/*
 * <Descriptor>
 * 	  <UID name=''/>
 * 	  <Version number='1.0'/>
 * 	  <DescriptionBlock>
 * 		  <DataSourceName name=''>
 * 		  <DataSourceFormat format=''>
 * 		  ......
 * 	   </DescriptionBlock> 
 * </Descriptor>
 */
public class DataXmlDescriptorOperator {
	public Document document = null;
	public DataXmlDescriptorOperator() {
		CreateXmlDescriptor();
	}
	public DataXmlDescriptorOperator(String XmlDescriptString) {
		DescriptorDocumentDeSerialize(XmlDescriptString);
	}
	public DataXmlDescriptorOperator(DataXmlDescriptor DataXmlDescriptorObj) {
		DescriptorDocumentDeSerialize(DataXmlDescriptorObj.getXmlDescriptString());
	}	
	public boolean CreateXmlDescriptor()
	{
       document = DocumentHelper.createDocument();
       Element DescriptorElement = document.addElement("Descriptor");
       DescriptorElement.addComment("It's a Data Descriptor");
       /** 加入第一个UID节点 */
       Element UIDElement = DescriptorElement.addElement("UID");
       /** 加入name属性内容 */
       UIDElement.addAttribute("name","");
       /** 加入Version节点 */
       Element VersionElement = DescriptorElement.addElement("Version");
       /** 设置版本号 */
       VersionElement.addAttribute("number","1.0");
       //描述块节点
       Element DescriptionBlockElement = DescriptorElement.addElement("DescriptionBlock");
       
       DescriptionBlockElement.addElement("DataSourceName").addAttribute("name","");
       DescriptionBlockElement.addElement("DataSourceFormat").addAttribute("format","");
   
       return true;
	}
	public Element GetDescriptorElement()
	{
		if(document == null)
			return null;
		return document.getRootElement();
	}
	public Element GetUIDElement()
	{
		if(document == null)
			return null;
		return GetDescriptorElement().element("UID");
	}	
	public Element GetVersionElement()
	{
		if(document == null)
			return null;
		return GetDescriptorElement().element("Version");
	}
	
	public Element GetDescriptionBlockElement()
	{
		if(document == null)
			return null;
		Element DescriptionBlockElement = GetDescriptorElement().element("DescriptionBlock");
		return DescriptionBlockElement;
	}
	
	public void SetVersion(String strVersionNumber)
	{
		Element VersionElement = GetVersionElement();
		if(VersionElement == null)
			return;
		VersionElement.addAttribute("number", strVersionNumber);
	}
	
	public String GetVersionNumber()
	{
		Element VersionElement = GetVersionElement();
		if(VersionElement == null)
			return null;
		return VersionElement.attribute("number").getValue();		
	}
	public String GetDataSourceName()
	{
		Element DataSourceNameNode = GetDescriptionBlockElement().element("DataSourceName");
		if(DataSourceNameNode == null)
			return null;
		return DataSourceNameNode.attributeValue("name");		
	}
	
	@SuppressWarnings("deprecation")
	public void SetDataSourceName(String strDataSourceName)
	{
		Element DataSourceNameNode = GetDescriptionBlockElement().element("DataSourceName");
		if(DataSourceNameNode == null)
			return;
		DataSourceNameNode.setAttributeValue("name",strDataSourceName);
	}
	
	public String DescriptorDocumentSerialize()
	{
		if(document == null)
			return null;
	    return document.asXML();
	}
	public void DescriptorDocumentDeSerialize(String XmlDescriptString)
	{
		if(XmlDescriptString == null)
			return;
		try {
			document = DocumentHelper.parseText(XmlDescriptString);
		} catch (DocumentException e) {
			e.printStackTrace();
			return;
		}
	}	
}
