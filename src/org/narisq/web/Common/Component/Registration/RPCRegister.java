package org.narisq.web.Common.Component.Registration;

import java.util.List;

import org.narisq.web.Common.Component.RPCComponentInformation;
import org.narisq.web.Common.Param.CommonParam;
import org.narisq.web.Common.Param.ConcreteCommonParam;
import org.narisq.web.Common.WebService.WebServiceXmlLoader;
import org.narisq.web.Common.Component.RPCComponentInvoker;

public class RPCRegister {
	private String WORK_FLOW_MANAGER_XML = "";
	private String COMPONENT_XML = "";
	public RPCRegister() {
	}
	public RPCRegister(String strComponentXmlFlieName, String strWorkFlowManagerXmlFileName)
	{
		WORK_FLOW_MANAGER_XML = strWorkFlowManagerXmlFileName;
		COMPONENT_XML = strComponentXmlFlieName;
	}
	
	/**
	 * 注册到WorkFlowManager
	 */
	public void regist(){
		if(WORK_FLOW_MANAGER_XML.equalsIgnoreCase("")||COMPONENT_XML.equalsIgnoreCase(""))
			return;
		//WorkFlowManager链表（可能有多个WorkFlowManager）
		List<RPCComponentInformation> rciList = WebServiceXmlLoader.loadFromFile(WORK_FLOW_MANAGER_XML);
		if(rciList == null)
		{
			System.out.println("组件注册信息文件为空！无法注册");
			return;
		}
		
		ConcreteCommonParam ConcreteParamObj= new ConcreteCommonParam();
		String StrComponents  = WebServiceXmlLoader.loadStringFromFile(COMPONENT_XML);
		if(StrComponents == null)
		{
			System.out.println("组件注册信息文件为空！无法注册");
			return;
		}
		ConcreteParamObj.setXmlParameterString(StrComponents);
		CommonParam param = new CommonParam(ConcreteParamObj);
		
		for(int i = 0; i<rciList.size(); i++)//向多个WorkFlowManager去注册
		{
			CommonParam ReturnCommonParamObj = RPCComponentInvoker.Execute(param, rciList.get(i),5000, 5000);
			if(ReturnCommonParamObj != null)
			{
				ConcreteCommonParam ReturnConcreteParamObj= new ConcreteCommonParam(ReturnCommonParamObj);
				System.out.println(ReturnConcreteParamObj.getXmlParameterString());
			}
			else
			{
				System.out.println("组件注册失败，但组件服务已经开启！");
			}
		}

	}

	public String getWORK_FLOW_MANAGER_XML() {
		return WORK_FLOW_MANAGER_XML;
	}

	public void setWORK_FLOW_MANAGER_XML(String work_flow_manager_xml) {
		WORK_FLOW_MANAGER_XML = work_flow_manager_xml;
	}

	public String getCOMPONENT_XML() {
		return COMPONENT_XML;
	}

	public void setCOMPONENT_XML(String component_xml) {
		COMPONENT_XML = component_xml;
	}
}
