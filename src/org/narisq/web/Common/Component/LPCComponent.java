package org.narisq.web.Common.Component;

import org.narisq.web.Common.Param.CommonParam;
import org.narisq.web.Common.Param.ConcreteCommonParam;

public abstract class LPCComponent extends AbstractComponent {

	public LPCComponent() {
    	SetComponentLocaltion("Local");
		// TODO Auto-generated constructor stub
	}
	@Override
	public CommonParam process(CommonParam ParamObj) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void Initialize(Object obj) {
		// TODO Auto-generated method stub
		
	}
	public ConcreteCommonParam process(ConcreteCommonParam obj, int connectionTimeout, int soTimeout)
	{
		ConcreteCommonParam PreConcreteCommonParamObj = PreProcess(obj);
		ConcreteCommonParam ConcreteCommonParamObj = Process(PreConcreteCommonParamObj);
		ConcreteCommonParam PostConcreteCommonParamObj = PostProcess(ConcreteCommonParamObj);
		return PostConcreteCommonParamObj;
	}

}
