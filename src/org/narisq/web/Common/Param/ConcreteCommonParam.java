package org.narisq.web.Common.Param;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dom4j.Element;
import org.narisq.web.Common.Data.CommonDataSet;
import org.narisq.web.Common.Data.DataXmlDescriptor;
import org.narisq.web.Common.Data.DataXmlDescriptorOperator;

import flexjson.JSON;

public class ConcreteCommonParam  implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String XmlParameterString = "";
    private List<CommonDataSet> ParamDataSetObjList = new ArrayList<CommonDataSet>();
    
    //缺省构造函数
	public ConcreteCommonParam() {
	}
	//字节反序列化构造函数
	public ConcreteCommonParam(byte[] Buffer) {
		try {
			DeSerialize(Buffer);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//对象反序列化构造函数
	public ConcreteCommonParam(CommonParam CommonParamObj) {
		try {
			DeSerialize(CommonParamObj.getBuffer());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//数据集链表拷贝构造函数
	public ConcreteCommonParam(List<CommonDataSet> commonDataSetList)
	{
		AddDataSetList(commonDataSetList);
	}
	
	private void writeObject(java.io.ObjectOutputStream out) throws IOException {   
	    out.writeObject(this.XmlParameterString);
	    out.writeInt(ParamDataSetObjList.size());
	    for(int i = 0; i<ParamDataSetObjList.size(); i++)
	    {
	    	CommonDataSet CommonDataSetObj = ParamDataSetObjList.get(i);
	    	out.writeObject(CommonDataSetObj);
	    }
	    
	}   
	  
	private void readObject(java.io.ObjectInputStream in) throws IOException,   
	        ClassNotFoundException { 
		ParamDataSetObjList = new ArrayList<CommonDataSet>();
	    this.XmlParameterString = (String) in.readObject();
	    int count = in.readInt();
	    for(int i = 0; i<count; i++)
	    {
	    	CommonDataSet CommonDataSetObj = (CommonDataSet) in.readObject();
	    	ParamDataSetObjList.add(CommonDataSetObj);
	    }
  
	}
	public byte[] Serialize() throws IOException{   
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();   
	    ObjectOutputStream oos = new ObjectOutputStream(baos);   
	    oos.writeObject(this);
	    return baos.toByteArray();
  
	}
	public void DeSerialize(byte[] Buffer) throws IOException, ClassNotFoundException {  
		if(Buffer == null)
			return;
	    ByteArrayInputStream bais = new ByteArrayInputStream(Buffer);   
	    ObjectInputStream ois = new ObjectInputStream(bais);   
	    ConcreteCommonParam ConcreteCommonParamObj = (ConcreteCommonParam) ois.readObject();  
	    this.setXmlParameterString(ConcreteCommonParamObj.getXmlParameterString());
	    this.ParamDataSetObjList = ConcreteCommonParamObj.ParamDataSetObjList;
	}
	@JSON(include=false)
	public String getXmlParameterString() {
		return XmlParameterString;
	}
	@JSON(include=false)
	public void setXmlParameterString(String xmlParameterString) {
		XmlParameterString = xmlParameterString;
	}
	
	//增加数据集数组
	public void AddDataSetArray(CommonDataSet[] CommonDataSetObjArray)
	{
		int count = CommonDataSetObjArray.length;
		for(int i = 0; i<count; i++)
		{
			CommonDataSet CommonDataSetObj = CommonDataSetObjArray[i];
			AddDataSet(CommonDataSetObj);
		}

	}
	
	//从合并一个ConcreteCommonParam的数据集
	public void AddDataSetListFromConcreteCommonParam(ConcreteCommonParam ParamObj)
	{
		AddDataSetList(ParamObj.ParamDataSetObjList);
	}
	//增加数据集链表
	public void AddDataSetList(List<CommonDataSet> CommonDataSetObjList)
	{
		int count = CommonDataSetObjList.size();
		for(int i = 0; i<count; i++)
		{
			CommonDataSet CommonDataSetObj = CommonDataSetObjList.get(i);
			AddDataSet(CommonDataSetObj);
		}

	}
	//增加单个数据集
	public void AddDataSet(CommonDataSet CommonDataSetObj)
	{
		String strDataSetName = CommonDataSetObj.GetDataSetName();
		if(GetDataSetObjByName(strDataSetName) != null)
		{
			System.out.println("该数据集链表中已经存在了名称为：" + strDataSetName + " 的数据集，不能重复加入！");
			return;
		}
		if(strDataSetName.equalsIgnoreCase(""))
		{
			System.out.println("数据集名称为空，不能加入！");
			return;			
		}
		ParamDataSetObjList.add(CommonDataSetObj);
	}
	
	//用传入的数据集替换链表中已有的同名数据集，返回被替换的数据集
	public CommonDataSet ReplaceDataSetObjWithSameName(CommonDataSet CommonDataSetObj)
	{
		String strDataSetName = CommonDataSetObj.GetDataSetName();
		//删除已有数据集
		CommonDataSet ReplaceDataSetObj = RemoveDataSetObjByName(strDataSetName);
		//加入新数据集
		AddDataSet(CommonDataSetObj);
		return ReplaceDataSetObj;
	}
	//删除名称为strDataSetNamede的数据集, 返回被删除的数据集
	public CommonDataSet RemoveDataSetObjByName(String strDataSetName)
	{
		CommonDataSet CommonDataSetObj = GetDataSetObjByName(strDataSetName);
		if(CommonDataSetObj != null)
			ParamDataSetObjList.remove(CommonDataSetObj);
		return CommonDataSetObj;

	}
	//删除所有数据集，返回删除数据集的链表
	public List<CommonDataSet> RemoveAllDataSetObj()
	{
		List<CommonDataSet> CommonDataObjList = GetDataObjListCopy();
		ParamDataSetObjList.removeAll(CommonDataObjList);
		return CommonDataObjList;
	}
	
	//获取数据集的数目
	public int GetDataObjCount()
	{
		return ParamDataSetObjList.size();
	}

	//获取索引为i的数据集
	public CommonDataSet GetDataSetObjByIndex(int i)
	{
		if(i<0 || i>ParamDataSetObjList.size()-1)
			return null;
		
		return ParamDataSetObjList.get(i);
	
	}	
	//======================以下为通过数据集名称来获取数据集的函数==============
	
	//获取数据集链表的一个拷贝
	public List<CommonDataSet> GetDataObjListCopy()
	{
	    List<CommonDataSet> TempDataObjList = new ArrayList<CommonDataSet>();
	    
	    int count = ParamDataSetObjList.size();
	    for(int i = 0; i<count; i++)
	    {
	    	CommonDataSet DataObj = ParamDataSetObjList.get(i);
	    	TempDataObjList.add(DataObj);
	    }
	    
	    return TempDataObjList;
	}
	//获取数据集以String链表为参数
	public List<CommonDataSet> GetDataObjListByNameList(List<String> NameList)
	{
	    List<CommonDataSet> TempDataObjList = new ArrayList<CommonDataSet>();
	    
	    int count = NameList.size();	    
	    for(int i = 0; i<count; i++)
	    {
	    	CommonDataSet DataObj = GetDataSetObjByName(NameList.get(i));
	    	if(DataObj == null)
	    	{
	    		System.out.println("缺少数据集" + NameList.get(i));
	    	}
	    	else
	    	{
	    		TempDataObjList.add(DataObj);
	    	}
	    }
	    
	    return TempDataObjList;
	}
	//获取数据集以String数组为参数
	public List<CommonDataSet> GetDataObjListByNameStringArray(String[] NameArray)
	{
    
	    ArrayList<CommonDataSet> TempDataObjList = new ArrayList<CommonDataSet>();	    
	    for(int i = 0; i<NameArray.length; i++)
	    {
	    	CommonDataSet DataObj = GetDataSetObjByName(NameArray[i]);
	    	if(DataObj == null)
	    	{
	    		System.out.println("缺少数据集" + NameArray[i]);
	    	}
	    	else
	    	{
	    		TempDataObjList.add(DataObj);
	    	}
	    	TempDataObjList.add((CommonDataSet) DataObj);
	    }	    
	    return TempDataObjList;
	}
	
	//获取数据集以"name1,name2,......"为参数
	public List<CommonDataSet> GetDataObjListByNameStringArray(String strNameArray)
	{
		String[] NameArray = strNameArray.split(",");    
	    return GetDataObjListByNameStringArray(NameArray);
	}
	
	//获取名称为strDataSetName的数据集
	public CommonDataSet GetDataSetObjByName(String strDataSetName)
	{
		for(int i = 0; i<ParamDataSetObjList.size(); i++)
		{
			CommonDataSet CommonDataSetObj = ParamDataSetObjList.get(i);
			DataXmlDescriptorOperator DataXmlDescriptorOperatorObj = new DataXmlDescriptorOperator(CommonDataSetObj.getDataXmlDescriptorObj());
			if(strDataSetName.equalsIgnoreCase(DataXmlDescriptorOperatorObj.GetDataSourceName()))
			{
				return CommonDataSetObj;			
			}			
		}
		//System.out.println("无法找到名称为:" + strDataSetName + "的数据集！");
		return null;		
	}

	//获取数据集以名称包含某字符串
	public List<CommonDataSet> GetDataObjListByNameStringContain(String strNameContain)
	{    
	    ArrayList<CommonDataSet> TempDataObjList = new ArrayList<CommonDataSet>();
		for(int i = 0; i<ParamDataSetObjList.size(); i++)
		{
			CommonDataSet CommonDataSetObj = ParamDataSetObjList.get(i);
			if(CommonDataSetObj.GetDataSetName().contains(strNameContain))
			{
				TempDataObjList.add(CommonDataSetObj);			
			}			
		}    
	    return TempDataObjList;
	}	

}
