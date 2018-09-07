package org.narisq.web.Common.Data;

import java.util.ArrayList;
import java.util.List;

import org.narisq.web.Common.Param.ConcreteCommonParam;

public class CommonDataSetList {
	//private List<CommonDataSet> DataObjList = new ArrayList<CommonDataSet>();
	public CommonDataSetList() {
		// TODO Auto-generated constructor stub
	}
//	public CommonDataSet GetDataSetObjByName(String strName)
//	{
//		return CommonDataSet.GetDataSetObjByName(strName, DataObjList);
//	}
//	
//	public List<CommonDataSet> GetDataObjListByNameList(List<String> NameList)
//	{
//	    List<CommonDataSet> TempDataObjList = new ArrayList<CommonDataSet>();
//	    
//	    int count = NameList.size();	    
//	    for(int i = 0; i<count; i++)
//	    {
//	    	CommonDataSet DataObj = GetDataSetObjByName(NameList.get(i));
//	    	if(DataObj == null)
//	    	{
//	    		System.out.println("缺少数据集" + NameList.get(i));
//	    	}
//	    	else
//	    	{
//	    		TempDataObjList.add(DataObj);
//	    	}
//	    }
//	    
//	    return TempDataObjList;
//	}
//	
//	public List<CommonDataSet> GetDataObjListByNameStringArray(String[] NameArray)
//	{
//    
//	    ArrayList<CommonDataSet> TempDataObjList = new ArrayList<CommonDataSet>();	    
//	    for(int i = 0; i<NameArray.length; i++)
//	    {
//	    	CommonDataSet DataObj = GetDataSetObjByName(NameArray[i]);
//	    	if(DataObj == null)
//	    	{
//	    		System.out.println("缺少数据集" + NameArray[i]);
//	    	}
//	    	else
//	    	{
//	    		TempDataObjList.add(DataObj);
//	    	}
//	    	TempDataObjList.add((CommonDataSet) DataObj);
//	    }	    
//	    return TempDataObjList;
//	}
//	
//	public List<CommonDataSet> GetDataObjListByNameStringArray(String strNameArray)
//	{
//		String[] NameArray = strNameArray.split(",");    
//	    return GetDataObjListByNameStringArray(NameArray);
//	}
//	
//	public void AppendDataSetToConcreteCommonParam(ConcreteCommonParam ConcreteCommonParamObj, String strNameArray)
//	{
//		List<CommonDataSet> CommonDataSetList = GetDataObjListByNameStringArray(strNameArray);
//		for(int i = 0; i<CommonDataSetList.size(); i++)
//		{
//			ConcreteCommonParamObj.getParamDataSetObjList().add(CommonDataSetList.get(i));
//		}
//	}
//	
//	public void AddDataObjsetList(List<CommonDataSet> DataObjList)
//	{
//	    for(int i = 0; i<DataObjList.size(); i++)
//	    {
//	    	AddDataSetObj(DataObjList.get(i));
//	    }
//	}
	
//	public void AddDataSetObj(CommonDataSet DataObj)
//	{
//	    DataObjList.add(DataObj);	
//	}	
}
