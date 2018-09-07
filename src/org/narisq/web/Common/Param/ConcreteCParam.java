package org.narisq.web.Common.Param;

import java.util.ArrayList;
import java.util.List;

import org.narisq.web.Common.Data.CommonDataSet;

import flexjson.JSON;

public class ConcreteCParam { //用于JSON序列化
	public String XmlParameterString = "";
    public List<CommonDataSet> ParamDataSetObjList = new ArrayList<CommonDataSet>();
	public ConcreteCParam() {
		// TODO Auto-generated constructor stub
	}
	public ConcreteCParam(ConcreteCommonParam ConcreteCommonParamObj)
	{
		XmlParameterString = ConcreteCommonParamObj.getXmlParameterString();
		ParamDataSetObjList = ConcreteCommonParamObj.GetDataObjListCopy();
	}
	@JSON(include=false)
	public String getXmlParameterString() {
		return XmlParameterString;
	}
	@JSON(include=false)
	public void setXmlParameterString(String xmlParameterString) {
		XmlParameterString = xmlParameterString;
	}
	@JSON(include=false)
	public List<CommonDataSet> getParamDataSetObjList() {
		return ParamDataSetObjList;
	}
	@JSON(include=false)
	public void setParamDataSetObjList(List<CommonDataSet> paramDataSetObjList) {
		ParamDataSetObjList = paramDataSetObjList;
	}

}
