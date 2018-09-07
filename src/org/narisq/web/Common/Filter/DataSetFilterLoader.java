package org.narisq.web.Common.Filter;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class DataSetFilterLoader {

	public DataSetFilterLoader() {
		// TODO Auto-generated constructor stub
	}
	public static void LoadFilters(String strFiltersFilename)
	{
		SAXReader reader = new SAXReader();
		Document doc = null;
		try {
//			doc = reader.read(strFiltersFilename);//wkdubug20171102
			doc = reader.read(new File(strFiltersFilename));
		} catch (DocumentException e) {
			e.printStackTrace();
		}		

		Element docRootNode = doc.getRootElement();
		List<Element> filterNode = docRootNode.elements("Filter");
		for(Element filterElement : filterNode){
			String className = filterElement.elementText("Class");
			String initParam = filterElement.elementText("InitParam");
			try {
				Class filterClass = Class.forName(className);
				AbstractDataSetFilter dataSetFilterObj = (AbstractDataSetFilter)filterClass.newInstance();
				dataSetFilterObj.Initialize(initParam);
				DataSetFilterToolBox.Instance().AddFilter(dataSetFilterObj);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
