package org.narisq.web.Common.Filter;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;
import org.narisq.web.Common.Param.ConcreteCommonParam;

import edu.emory.mathcs.backport.java.util.Collections;
/*************************************************************
<DataFilter FilterName="Numerical" Order="Post">
	<DataLocation DataSetName="" DataType="float,double" Index="0,2">
	<Parameter Scale="0.1" >
</DataFilter>
**************************************************************/
public class DataSetFilterToolBox {

	private static DataSetFilterToolBox Toolbox = null;
	private static List<AbstractDataSetFilter> dataSetFilterList = new ArrayList<AbstractDataSetFilter>();

	private DataSetFilterToolBox() {
	}
	public static DataSetFilterToolBox Instance()
	{
		if(Toolbox == null)
		{
			Toolbox = new DataSetFilterToolBox();
		}
		return Toolbox;
	}
	//向工具箱增加滤波器
	public void AddFilter(AbstractDataSetFilter dataSetFilter)
	{
		
		if(dataSetFilter != null)
		{
			dataSetFilterList.add(dataSetFilter);
			System.out.println("当前滤波器：" + dataSetFilter.getDataSetFilterName() + "添加到工具箱");
		}
	}
	//按滤波参数对选定数据集进行处理
	public void  DoFilter(Element ENode, ConcreteCommonParam ConcreteCommonParamObj)
	{
		AbstractDataSetFilter dataSetFilterObj = DataSetFilterFactory.FindDataSetFilter(ENode, dataSetFilterList);
		if(dataSetFilterObj != null)
		{
			dataSetFilterObj.DoFilter(ENode, ConcreteCommonParamObj);
			
		}
	}
	
	//批量滤波处理
	public void DoFilters(List<Element> FilterENodeList, ConcreteCommonParam ConcreteCommonParamObj, String strOrder)
	{
		List<FilterNode> FilterNodeObjList = new ArrayList<FilterNode>();
		
		int count = FilterENodeList.size();
		
		for(int i = 0; i<count; i++)
		{	
			Element DataFilterNode = FilterENodeList.get(i);
			FilterNodeObjList.add(new FilterNode(DataFilterNode));
		}
		
	    Collections.sort(FilterNodeObjList);
	    
	    for(int i = 0; i<count; i++)
		{	
			Element DataFilterNode = FilterNodeObjList.get(i).getFilterElement();		
			
			String stringOrder = DataFilterNode.attributeValue("Order");
			if(stringOrder.equalsIgnoreCase(strOrder))
				DoFilter(FilterENodeList.get(i),ConcreteCommonParamObj);
		}
	}
}


class FilterNode implements Comparable<FilterNode>{
	private Element filterElement;
	private int orderIndex;
	
	Element getFilterElement(){
		return this.filterElement;
	}
	
	int getOrderIndex(){
		return this.orderIndex;
	}
	
	FilterNode(Element filterElement){
		this.filterElement = filterElement;
		String indexOrderStr = this.filterElement.attributeValue("OrderIndex");
		this.orderIndex = 0;
		if(indexOrderStr!=null && !indexOrderStr.equalsIgnoreCase("")){
			this.orderIndex = Integer.parseInt(indexOrderStr);
		}
	}

	public int compareTo(FilterNode o) {
			return ((Integer)this.getOrderIndex()).compareTo((Integer)(((FilterNode)o).getOrderIndex()));
	}
}
