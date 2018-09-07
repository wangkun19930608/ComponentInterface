package org.narisq.web.Common;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class AbstractPropertyInfo {
	private Map<String, Object> PropertiseMap = new HashMap<String, Object>();
	public AbstractPropertyInfo() {
		// TODO Auto-generated constructor stub
	}
	public String AddProperty(String PropertyName, Object PropertyObj)
	{
		if(PropertiseMap.get(PropertyName)!= null)
			return "false";
		PropertiseMap.put(PropertyName, PropertyObj);
		return "true";
	}
	
	public String SetProperty(String PropertyName, Object PropertyObj)
	{
		if(PropertiseMap.get(PropertyName) == null)
		{
		    AddProperty(PropertyName, PropertyObj);
		}
		PropertiseMap.put(PropertyName, PropertyObj);
		return "true";
	}	
	
	
	public Object GetPropertyByName(String strPropertyName)
	{
		Object Obj = PropertiseMap.get(strPropertyName);
		return Obj;
	}
	public boolean GetBooleanPropertyByName(String strPropertyName)
	{
	    Object Obj = GetPropertyByName(strPropertyName);
	    return  Boolean.parseBoolean(Obj.toString());
	}
	
	public int GetPropertiesCount()
	{
		return PropertiseMap.size();
	}
	
	public void Accept(IPropertyVisitor visitor)
	{
		Set<String> keys = PropertiseMap.keySet();
		for (Object element : keys) {
                    String key   =  (String)element;
                    Object PropertyObj = GetPropertyByName(key);
        	    visitor.Visit(key, PropertyObj);
		}

	}
	public Map<String, Object> getPropertiseMap() {
	    return PropertiseMap;
	}
	public void setPropertiseMap(Map<String, Object> propertiseMap) {
	    PropertiseMap = propertiseMap;
	}

}
