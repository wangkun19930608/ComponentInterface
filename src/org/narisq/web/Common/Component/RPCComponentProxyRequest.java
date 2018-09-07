package org.narisq.web.Common.Component;

import java.util.List;

import org.dom4j.Element;
import org.narisq.web.Common.Data.CommonDataSetList;
import org.narisq.web.Common.Param.CommonParam;
import org.narisq.web.Common.Param.ConcreteCommonParam;
import org.narisq.web.Common.WebService.WebServiceXmlLoader;

public class RPCComponentProxyRequest {

	public RPCComponentProxyRequest() {
		// TODO Auto-generated constructor stub
	}
	
	public static ConcreteCommonParam Process(Element RPCProxyNode)
	{
		String strRPCComponentInfo = RPCProxyNode.element("Destination").element("root").asXML();
		List<RPCComponentInformation> RPCComponentInformationObjList = WebServiceXmlLoader.loadFromString(strRPCComponentInfo);
		if(RPCComponentInformationObjList.size()>1)
		{
			System.out.println("代理请求无法同时支持多个组件！");
			return new ConcreteCommonParam();
		}
		
		if(RPCComponentInformationObjList.size()==0)
		{
			System.out.println("代理请求目标组件为空！");
			return new ConcreteCommonParam();
		}
	    int connectionTimeout = 120000;
	    int soTimeout = 120000;
	    //获取超时信息
	    String StrTimeOut = RPCProxyNode.attributeValue("TimeOut");
	    if(StrTimeOut != null)
	    {
	    	String strTime[] = StrTimeOut.split(",");
	    	connectionTimeout = Integer.parseInt(strTime[0]);
	    	soTimeout = Integer.parseInt(strTime[1]);
	    }
	    
		RPCComponentInformation RPCComponentInformationObj = RPCComponentInformationObjList.get(0);
		String strRPCParam = RPCProxyNode.element("Parameters").element("ParamXmlNode").asXML();
		ConcreteCommonParam ConcreteParamObj= new ConcreteCommonParam();
		ConcreteParamObj.setXmlParameterString(strRPCParam);
		CommonParam CommonParamObj = new CommonParam(ConcreteParamObj);		
		CommonParam retParam = RPCComponentInvoker.Execute(CommonParamObj, RPCComponentInformationObj, connectionTimeout, soTimeout);
		if(retParam == null)
			return new ConcreteCommonParam();
		ConcreteCommonParam ReturnConcreteCommonParamObj = new ConcreteCommonParam(retParam);//解包
		//插入返回的数据集
		return ReturnConcreteCommonParamObj;
	}

}
