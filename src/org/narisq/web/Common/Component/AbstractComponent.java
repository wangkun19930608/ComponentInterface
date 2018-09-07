package org.narisq.web.Common.Component;

import java.util.List;

import org.dom4j.Element;
import org.narisq.web.Common.PropertyInfoImpl;
import org.narisq.web.Common.Filter.DataSetFilterToolBox;
import org.narisq.web.Common.Param.CommonParam;
import org.narisq.web.Common.Param.ConcreteCommonParam;
import org.narisq.web.Common.Xml.XmldeSerializer;

public abstract class AbstractComponent implements IComponent {
    public PropertyInfoImpl PropertyInfoImplObj = new PropertyInfoImpl();
    
	public AbstractComponent() {
		SetComponentProperty("valid", "true");	
	}
	public Object GetComponentProperty(String PropertyName) {
	    return PropertyInfoImplObj.GetPropertyByName(PropertyName);
	}
	public void Initialize(Object obj){
		
	}
	public abstract AbstractComponent Clone();	
	public abstract CommonParam process(CommonParam ParamObj);
	public String GetComponentName()
	{
		return (String) GetComponentProperty("name");
	}
	
	public void SetComponentName(String strComponentName)
	{
		SetComponentProperty("name", strComponentName);
	}
	public String GetComponentIP()
	{
		return (String) GetComponentProperty("ip");
	}
	public void SetComponentIP(String strComponentIP)
	{
		SetComponentProperty("ip", strComponentIP);
	}
	
	public void SetComponentProperty(String PropertyName, Object PropertyObj)
	{
	    PropertyInfoImplObj.SetProperty(PropertyName, PropertyObj);
	}
	
	public void SetComponentLocaltion(String strLocation)
	{
		SetComponentProperty("Location", strLocation);
	}
	
	public String GetComponentLocation()
	{
		return (String) GetComponentProperty("Location");
	}
	
	public boolean IsRomoteComponent()
	{
		if(GetComponentLocation().equalsIgnoreCase("Remote"))
			return true;
		else
			return false;
	}
	
	public ConcreteCommonParam process(ConcreteCommonParam obj, int connectionTimeout, int soTimeout)
	{
		//LPCComponent提供了重载
		return null;
	}
	
	//本地组件和远程组件需要提供实现
	public abstract ConcreteCommonParam Process(ConcreteCommonParam obj);
	public ConcreteCommonParam PreProcess(ConcreteCommonParam obj)
	{
		doDataFilter(obj, "Pre");	
		return obj;
	}
	public ConcreteCommonParam PostProcess(ConcreteCommonParam obj)
	{
		doDataFilter(obj, "Post");	
		return obj;
	}
	
	public void doDataFilter(ConcreteCommonParam obj, String strOrder)
	{
		String XmlParamString = obj.getXmlParameterString();//<ECode Name="FDRtElement::DbQueryRtTower"><P E="Condition" UID="203" OP="MA" EN="" A="Value" V="2017-05-29 13-34-00"/><P E="Condition" UID="202" OP="MA" EN="" A="Op" V="in"/><P E="Condition" UID="202" OP="MA" EN="" A="Value" V="57107999,57061999,57061999"/></ECode>
		if(XmlParamString.equalsIgnoreCase(""))
			return;
		Element ParamXmlRootElementObj = XmldeSerializer.stringToElement(XmlParamString);
		if(ParamXmlRootElementObj == null)
			return;
		List<Element> FilterENodeList = ParamXmlRootElementObj.elements("DataFilter");
		DataSetFilterToolBox.Instance().DoFilters(FilterENodeList, obj, strOrder);

	}
	
	
}
