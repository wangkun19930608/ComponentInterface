package org.narisq.web.Common.Component;

import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;
import org.narisq.web.Common.Param.CommonParam;

/**
 * 通用接口调用类
 * @author Cao Jing
 *
 */
public class RPCComponentInvoker {
	
	/**
	 * 执行调用方法
	 * @param param
	 * @param rci
	 * @return
	 */	
	public static CommonParam Execute(CommonParam param, RPCComponentInformation rci, int connectionTimeout, int soTimeout){
		CommonParam  retParam = null;
		Object argObj = param;
		try {
			RPCServiceClient rpcClient = new RPCServiceClient();
			Options opt = new Options();
			String eprStr = "http://" + rci.getComponentIP() + ":" + rci.getComponentPort()
				+ "/" + rci.getComponentPath() + "/" + rci.getComponentServiceName();
//			opt.setProperty(HTTPConstants.SO_TIMEOUT,new Integer(120000));
//			opt.setProperty(HTTPConstants.CONNECTION_TIMEOUT,new Integer(120000));
			opt.setProperty(HTTPConstants.SO_TIMEOUT,new Integer(soTimeout));
			opt.setProperty(HTTPConstants.CONNECTION_TIMEOUT,new Integer(connectionTimeout));
			opt.setTo(new EndpointReference(eprStr)); //服务地址
			
			rpcClient.setOptions(opt);
			Object[] response = rpcClient.invokeBlocking(new QName(rci.getComponentQname(), "process"), new Object[]{argObj},new Class[]{CommonParam.class}); 
			retParam = (CommonParam)response[0];
		} catch (AxisFault e) {
			e.printStackTrace();
			return null;
		} 
		return retParam;
	}
}
