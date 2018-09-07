package org.narisq.web.Common.Component;

import org.narisq.web.Common.Param.CommonParam;
import org.narisq.web.Common.Param.ConcreteCommonParam;

public interface IComponent {
	public Object GetComponentProperty(String PropertyName);
	public IComponent Clone();	
	public CommonParam process(CommonParam ParamObj);
	public void Initialize(Object obj);
	public ConcreteCommonParam process(ConcreteCommonParam obj, int connectionTimeout, int soTimeout);
	public String GetComponentName();
	public void SetComponentName(String strComponentName);
	public String GetComponentIP();
	public void SetComponentIP(String strComponentIP);
	public void SetComponentProperty(String PropertyName, Object PropertyObj);
	public void SetComponentLocaltion(String strLocation);
	public String GetComponentLocation();
	public boolean IsRomoteComponent();
	
}
