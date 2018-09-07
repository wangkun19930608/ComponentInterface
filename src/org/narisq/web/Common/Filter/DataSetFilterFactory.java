package org.narisq.web.Common.Filter;

import java.util.List;
import org.dom4j.Element;

public class DataSetFilterFactory {
	private DataSetFilterFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static AbstractDataSetFilter FindDataSetFilter(Element ENode, List<AbstractDataSetFilter> dataSetFilterList)
	{
		String strFilterName = ENode.attributeValue("FilterName");
		int count = dataSetFilterList.size();
		for(int i = 0; i<count; i++)
		{
			AbstractDataSetFilter dataSetFilterObj = dataSetFilterList.get(i);
			if(dataSetFilterObj.getDataSetFilterName().equalsIgnoreCase(strFilterName))
				return dataSetFilterObj.Clone();
		}
		return null;
		
	}

}
