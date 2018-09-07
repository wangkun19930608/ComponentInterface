package org.narisq.web.Common.Param;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.narisq.web.Common.Data.CommonDataSet;

public class CommonParam {
	public byte[] Buffer = null;

	public CommonParam() {
		// TODO Auto-generated constructor stub
	}
	
	public CommonParam(ConcreteCommonParam ConcreteCommonParamObj)
	{
		try {
			Serialize(ConcreteCommonParamObj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ConcreteCommonParam DeSerialize() throws IOException, ClassNotFoundException {
		if(Buffer == null)
			return null;
		ConcreteCommonParam ConcreteCommonParamObj = new ConcreteCommonParam();
		ConcreteCommonParamObj.DeSerialize(Buffer);
		return ConcreteCommonParamObj;
	}

	public void Serialize(ConcreteCommonParam ConcreteCommonParamObj) throws IOException {
		Buffer = ConcreteCommonParamObj.Serialize();
	}

	public byte[] getBuffer() {
		return Buffer;
	}

	public void setBuffer(byte[] buffer) {
		Buffer = buffer;
	}
}
