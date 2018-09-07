package org.narisq.web.Common.Filter;



import java.util.List;

import org.dom4j.Element;
import org.narisq.web.Common.Data.CommonDataSet;
import org.narisq.web.Common.Param.ConcreteCommonParam;

public abstract class AbstractDataSetFilter {
	private String dataSetFilterName = "";
	public AbstractDataSetFilter() {
	}
	public String getDataSetFilterName() {
		return dataSetFilterName;
	}
	public void setDataSetFilterName(String dataSetFilterName) {
		this.dataSetFilterName = dataSetFilterName;
	}
	
	public String[][] getDataTypeArray(Element node)
	{
		Element eLocation = node.element("DataLocation");
		String[] strDataTypeArray = eLocation.attributeValue("DataType").split(";");
		int dataSetCount = strDataTypeArray.length;
		String[][] strDataType = new String[dataSetCount][];
		for(int i = 0; i< dataSetCount; i++){
			strDataType[i] = strDataTypeArray[i].split(",");
		}
		return strDataType;
	}
	
	public int[][] getDataIndexArray(Element node)
	{
		Element eLocation = node.element("DataLocation");
		String[] strDataIndexArray = eLocation.attributeValue("Index").split(";");
		int dataSetCount = strDataIndexArray.length;
		int[][] indexArray = new int[dataSetCount][];
		for(int i = 0; i<dataSetCount; i++)
		{
			String[] dataIndexStr = strDataIndexArray[i].split(",");
			indexArray[i] = new int[dataIndexStr.length];
			for(int n = 0; n < dataIndexStr.length; n++){
				indexArray[i][n] = Integer.parseInt(dataIndexStr[n]);
			}
		}
		return indexArray;
	}
	
	
	public String getKeyType(Element node){
		Element eLocation = node.element("Parameter");
		String keyTypeStr = eLocation.attributeValue("KeyType");
		return keyTypeStr;
	}
	
	
	public int getKeyIndex(Element node){
		Element eLocation = node.element("Parameter");
		String keyIndexStr = eLocation.attributeValue("KeyIndex");
		int keyIndexInt = 0;
		if(keyIndexStr != null)
			keyIndexInt = Integer.parseInt(keyIndexStr);
		return keyIndexInt;
	}
	
	public String[] getKeyValueArray(Element node)
	{
		Element eLocation = node.element("Parameter");
		String[] strKeyValueArray = eLocation.attributeValue("KeyValue").split(";");
		return strKeyValueArray;
	}
	
	public String[] getSetNameArray(Element node)
	{
		Element eLocation = node.element("DataLocation");
		String[] strDataIndexArray = eLocation.attributeValue("DataSetName").split(";");
		return strDataIndexArray;
	}
	
	public String[] getReturnDataSetNameArray(Element node)
	{
		Element eLocation = node.element("Parameter");
		String[] strRetDataSetNameArray = eLocation.attributeValue("ReturnNameList").split(";");
		return strRetDataSetNameArray;
	}

	public String getParamString(Element node, String strParamName)
	{
		Element eParam = node.element("Parameter");
		return eParam.attributeValue(strParamName);
	}
	
	public abstract void DoFilter(Element node, ConcreteCommonParam ConcreteCommonParamObj);
	public abstract AbstractDataSetFilter Clone();
	public abstract boolean Initialize(Object ParamObj);
	
	

}
