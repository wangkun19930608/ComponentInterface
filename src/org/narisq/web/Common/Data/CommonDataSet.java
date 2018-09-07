package org.narisq.web.Common.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dom4j.Element;

public class CommonDataSet  implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4235134901963561441L;
	//数据描述器
	private DataXmlDescriptor DataXmlDescriptorObj = new DataXmlDescriptor();
	//数据块
	public List<boolean[]> BoolArrayList = new ArrayList<boolean[]>();
	public List<byte[]> ByteArrayList = new ArrayList<byte[]>();
	public List<char[]> CharArrayList = new ArrayList<char[]>();
	public List<short[]> ShortArrayList = new ArrayList<short[]>();
	public List<int[]> IntArrayList = new ArrayList<int[]>();
	public List<long[]> LongArrayList = new ArrayList<long[]>();	
	public List<float[]> FloatArrayList = new ArrayList<float[]>();	
	public List<double[]> DoubleArrayList = new ArrayList<double[]>();	
	public List<String[]> StringArrayList = new ArrayList<String[]>();	
	public List<Date[]> DateArrayList = new ArrayList<Date[]>();
	
	public CommonDataSet() {
		
		// TODO Auto-generated constructor stub
	}
	public DataXmlDescriptor getDataXmlDescriptorObj() {
		return DataXmlDescriptorObj;
	}
	public void setDataXmlDescriptorObj(DataXmlDescriptor dataXmlDescriptorObj) {
		DataXmlDescriptorObj = dataXmlDescriptorObj;		
	}
	//创建带名称的数据集(静态方法)
	public static CommonDataSet CreateDataSet(String strDataSetName)
	{
		CommonDataSet DataSetObj = new CommonDataSet();
	    DataXmlDescriptorOperator DataXmlDescriptorOperatorObj = new DataXmlDescriptorOperator();
	    //设置数据集的名称
        DataXmlDescriptorOperatorObj.SetDataSourceName(strDataSetName); 
        String xmlDescriptString = DataXmlDescriptorOperatorObj.DescriptorDocumentSerialize();        
        DataSetObj.getDataXmlDescriptorObj().setXmlDescriptString(xmlDescriptString);
        return DataSetObj;
	} 
	
	//获取数据集名称
	public String GetDataSetName()
	{
    	DataXmlDescriptorOperator DataXmlDescriptorOperatorObj = new DataXmlDescriptorOperator();
    	String str = DataXmlDescriptorObj.getXmlDescriptString();
    	DataXmlDescriptorOperatorObj.DescriptorDocumentDeSerialize(str);
		String strDataSourceName = DataXmlDescriptorOperatorObj.GetDataSourceName();
		return strDataSourceName;
		
	}

	
	private void writeObject(java.io.ObjectOutputStream out) throws IOException { 

	    out.writeObject(this.DataXmlDescriptorObj);
	    out.writeInt(BoolArrayList.size());
	    for(int i = 0; i<BoolArrayList.size(); i++)
	    {
	    	boolean[] BooleanArrayObj = BoolArrayList.get(i);
	    	out.writeObject(BooleanArrayObj);
	    }
	    out.writeInt(ByteArrayList.size());
	    for(int i = 0; i<ByteArrayList.size(); i++)
	    {
	    	byte[] ByteArrayObj = ByteArrayList.get(i);
	    	out.writeObject(ByteArrayObj);
	    }
	    out.writeInt(CharArrayList.size());
	    for(int i = 0; i<CharArrayList.size(); i++)
	    {
	    	char[] charArrayObj = CharArrayList.get(i);
	    	out.writeObject(charArrayObj);
	    }
	    out.writeInt(ShortArrayList.size());
	    for(int i = 0; i<ShortArrayList.size(); i++)
	    {
	    	short[] ShortArrayObj = ShortArrayList.get(i);
	    	out.writeObject(ShortArrayObj);
	    }
	    out.writeInt(IntArrayList.size());
	    for(int i = 0; i<IntArrayList.size(); i++)
	    {
	    	int[] IntArrayObj = IntArrayList.get(i);
	    	out.writeObject(IntArrayObj);
	    }
	    out.writeInt(LongArrayList.size());
	    for(int i = 0; i<LongArrayList.size(); i++)
	    {
	    	long[] LongArrayObj = LongArrayList.get(i);
	    	out.writeObject(LongArrayObj);
	    }
	    out.writeInt(FloatArrayList.size());
	    for(int i = 0; i<FloatArrayList.size(); i++)
	    {
	    	float[] FloatArrayObj = FloatArrayList.get(i);
	    	out.writeObject(FloatArrayObj);
	    }
	    out.writeInt(DoubleArrayList.size());
	    for(int i = 0; i<DoubleArrayList.size(); i++)
	    {
	    	double[] DoubleArrayObj = DoubleArrayList.get(i);
	    	out.writeObject(DoubleArrayObj);
	    }
	    out.writeInt(StringArrayList.size());
	    for(int i = 0; i<StringArrayList.size(); i++)
	    {
	    	String[] StringArrayObj = StringArrayList.get(i);
	    	out.writeObject(StringArrayObj);
	    }
	    out.writeInt(DateArrayList.size());
	    for(int i = 0; i<DateArrayList.size(); i++)
	    {
	    	Date[] DateArrayObj = DateArrayList.get(i);
	    	out.writeObject(DateArrayObj);
	    }	    
	    
	}   
	  
	private void readObject(java.io.ObjectInputStream in) throws IOException,   
	        ClassNotFoundException { 
		
		//数据描述器		
	    this.DataXmlDescriptorObj = (DataXmlDescriptor) in.readObject(); 
		//数据块
		BoolArrayList = new ArrayList<boolean[]>();
		ByteArrayList = new ArrayList<byte[]>();
		CharArrayList = new ArrayList<char[]>();
		ShortArrayList = new ArrayList<short[]>();
		IntArrayList = new ArrayList<int[]>();
		LongArrayList = new ArrayList<long[]>();	
		FloatArrayList = new ArrayList<float[]>();	
		DoubleArrayList = new ArrayList<double[]>();	
		StringArrayList = new ArrayList<String[]>();	
		DateArrayList = new ArrayList<Date[]>();
		
	    int count = in.readInt();	    
	    for(int i = 0; i<count; i++)
	    {
	    	boolean[] BooleanArrayObj = (boolean[]) in.readObject();
	    	BoolArrayList.add(BooleanArrayObj);
	    }
	    count = in.readInt();	    
	    for(int i = 0; i<count; i++)
	    {
	    	byte[] ByteArrayObj = (byte[]) in.readObject();
	    	ByteArrayList.add(ByteArrayObj);
	    }

	    count = in.readInt();	
	    for(int i = 0; i<count; i++)
	    {
	    	char[] CharArrayObj = (char[]) in.readObject();
	    	CharArrayList.add(CharArrayObj);
	    }

	    count = in.readInt();	
	    for(int i = 0; i<count; i++)
	    {
	    	short[] ShortArrayObj = (short[]) in.readObject();
	    	ShortArrayList.add(ShortArrayObj);
	    }
	    
	    count = in.readInt();		    
	    for(int i = 0; i<count; i++)
	    {
	    	int[] IntArrayObj = (int[]) in.readObject();
	    	IntArrayList.add(IntArrayObj);
	    }
	    
	    count = in.readInt();		    
	    for(int i = 0; i<count; i++)
	    {
	    	long[] LongArrayObj = (long[]) in.readObject();
	    	LongArrayList.add(LongArrayObj);
	    }
	    
	    count = in.readInt();	    
	    for(int i = 0; i<count; i++)
	    {
	    	float[] FloatArrayObj = (float[]) in.readObject();
	    	FloatArrayList.add(FloatArrayObj);
	    }

	    count = in.readInt();	
	    for(int i = 0; i<count; i++)
	    {
	    	double[] DoubleArrayObj = (double[]) in.readObject();
	    	DoubleArrayList.add(DoubleArrayObj);
	    }

	    count = in.readInt();	
	    for(int i = 0; i<count; i++)
	    {
	    	String[] StringArrayObj = (String[]) in.readObject();
	    	StringArrayList.add(StringArrayObj);
	    }

	    count = in.readInt();	
	    for(int i = 0; i<count; i++)
	    {
	    	Date[] DateArrayObj = (Date[]) in.readObject();
	    	DateArrayList.add(DateArrayObj);
	    }	    
	    
	}
	
	/**
	 * 添加表格控制信息属性
	 * @param lineElement
	 * @param columnHeaderStr
	 * @param columnIndex
	 */
	private static void addTableAttribute(Element lineElement, String columnHeaderStr, int columnIndex){
		lineElement.addAttribute("Index", "0");
		lineElement.addAttribute("Field", "");
		lineElement.addAttribute("Header", columnHeaderStr);
		lineElement.addAttribute("ColumnIndex", String.valueOf(columnIndex));
	}
	
	/**
	 * 创建一个DataSet，加入数据列表
	 * @param dataObjList 数据链表
	 * @param typeStr  数据类型
	 * @param columnHeaderStr  表格列标题
	 * @param columnIndex  表格列索引
	 * @param commonDataSetNameStr  数据集名称
	 */
	public static CommonDataSet createCommonDataSetFromDataObjList(List dataObjList, String typeStr, String columnHeaderStr, int columnIndex, String commonDataSetNameStr )
	{
		DataXmlDescriptorOperator dxdo = new DataXmlDescriptorOperator();
		dxdo.CreateXmlDescriptor();
		Element rootElement = dxdo.GetDescriptionBlockElement();
		//rootElement.addElement("DataObjCount").setText(String.valueOf(dataObjCount));
		rootElement.element("DataSourceName").attribute("name").setText(commonDataSetNameStr);
				
		rootElement.addElement("BooleanArrayList");
		rootElement.addElement("ByteArrayList");
		rootElement.addElement("CharArrayList");
		rootElement.addElement("ShortArrayList");
		rootElement.addElement("IntArrayList");
		rootElement.addElement("LongArrayList");
		rootElement.addElement("FloatArrayList");
		rootElement.addElement("DoubleArrayList");
		rootElement.addElement("StringArrayList");
		rootElement.addElement("DateArrayList");
				
		String destTypeStr = typeStr;
		
		CommonDataSet cds = new CommonDataSet();

		int arrayCount = dataObjList.size();
		if(destTypeStr.equalsIgnoreCase("java.util.date") || destTypeStr.equalsIgnoreCase("date")){
			Date[] dateArray = new Date[arrayCount];
			for(int i = 0; i < arrayCount; i++){
				dateArray[i] = (Date) (dataObjList.get(i));
			}
			
			cds.DateArrayList.add(dateArray);
			//dateCount[retDataSetIndex]++;
			Element lineElement = rootElement.element("DateArrayList").addElement("DateArray");
			addTableAttribute(lineElement, columnHeaderStr, columnIndex);
		}
		else if(destTypeStr.equalsIgnoreCase("java.lang.string") || destTypeStr.equalsIgnoreCase("string")){

			String[] stringArray = new String[arrayCount];
			for(int i = 0; i < arrayCount; i++){
				stringArray[i] = (String) (dataObjList.get(i));
			}
			
			cds.StringArrayList.add(stringArray);
			//dateCount[retDataSetIndex]++;
			Element lineElement = rootElement.element("StringArrayList").addElement("StringArray");
			addTableAttribute(lineElement, columnHeaderStr, columnIndex);
		}
		else if(destTypeStr.equalsIgnoreCase("java.lang.boolean") || destTypeStr.equalsIgnoreCase("bool")){
			boolean[] booleanArray = new boolean[arrayCount];
			for(int i = 0; i < arrayCount; i++){
				booleanArray[i] = ((Boolean) (dataObjList.get(i))).booleanValue();
			}
			
			cds.BoolArrayList.add(booleanArray);
			//dateCount[retDataSetIndex]++;
			Element lineElement = rootElement.element("BooleanArrayList").addElement("BooleanArray");
			addTableAttribute(lineElement, columnHeaderStr, columnIndex);
		}
		else if(destTypeStr.equalsIgnoreCase("java.lang.byte") || destTypeStr.equalsIgnoreCase("byte")){
			byte[] byteArray = new byte[arrayCount];
			for(int i = 0; i < arrayCount; i++){
				byteArray[i] = ((Byte) (dataObjList.get(i))).byteValue();
			}
			
			cds.ByteArrayList.add(byteArray);
			//dateCount[retDataSetIndex]++;
			Element lineElement = rootElement.element("ByteArrayList").addElement("ByteArray");
			addTableAttribute(lineElement, columnHeaderStr, columnIndex);
		}
		else if(destTypeStr.equalsIgnoreCase("java.lang.integer") || destTypeStr.equalsIgnoreCase("int")){
			int[] intArray = new int[arrayCount];
			for(int i = 0; i < arrayCount; i++){
				intArray[i] = ((Integer) (dataObjList.get(i))).intValue();
			}
			
			cds.IntArrayList.add(intArray);
			//dateCount[retDataSetIndex]++;
			Element lineElement = rootElement.element("IntArrayList").addElement("IntArray");
			addTableAttribute(lineElement, columnHeaderStr, columnIndex);
		}
		else if(destTypeStr.equalsIgnoreCase("java.lang.short") || destTypeStr.equalsIgnoreCase("short")){
			short[] shortArray = new short[arrayCount];
			for(int i = 0; i < arrayCount; i++){
				shortArray[i] = ((Short) (dataObjList.get(i))).shortValue();
			}
			
			cds.ShortArrayList.add(shortArray);
			//dateCount[retDataSetIndex]++;
			Element lineElement = rootElement.element("ShortArrayList").addElement("ShortArray");
			addTableAttribute(lineElement, columnHeaderStr, columnIndex);
		}
		else if(destTypeStr.equalsIgnoreCase("java.lang.double") || destTypeStr.equalsIgnoreCase("double")){
			double[] doubleArray = new double[arrayCount];
			for(int i = 0; i < arrayCount; i++){
				doubleArray[i] = ((Double) (dataObjList.get(i))).doubleValue();
			}
			
			cds.DoubleArrayList.add(doubleArray);
			//dateCount[retDataSetIndex]++;
			Element lineElement = rootElement.element("DoubleArrayList").addElement("DoubleArray");
			addTableAttribute(lineElement, columnHeaderStr, columnIndex);
		}
		else if(destTypeStr.equalsIgnoreCase("java.lang.character") || destTypeStr.equalsIgnoreCase("char")){
			char[] charArray = new char[arrayCount];
			for(int i = 0; i < arrayCount; i++){
				charArray[i] = ((Character) (dataObjList.get(i))).charValue();
			}
			
			cds.CharArrayList.add(charArray);
			//dateCount[retDataSetIndex]++;
			Element lineElement = rootElement.element("CharArrayList").addElement("CharArray");
			addTableAttribute(lineElement, columnHeaderStr, columnIndex);
		}
		else if(destTypeStr.equalsIgnoreCase("java.lang.long") || destTypeStr.equalsIgnoreCase("long")){
			long[] longArray = new long[arrayCount];
			for(int i = 0; i < arrayCount; i++){
				longArray[i] = ((Long) (dataObjList.get(i))).longValue();
			}
			
			cds.LongArrayList.add(longArray);
			//dateCount[retDataSetIndex]++;
			Element lineElement = rootElement.element("LongArrayList").addElement("LongArray");
			addTableAttribute(lineElement, columnHeaderStr, columnIndex);
		}
		else if(destTypeStr.equalsIgnoreCase("java.lang.float") || destTypeStr.equalsIgnoreCase("float")){
			float[] floatArray = new float[arrayCount];
			for(int i = 0; i < arrayCount; i++){
				floatArray[i] = ((Float) (dataObjList.get(i))).floatValue();
			}
			
			cds.FloatArrayList.add(floatArray);
			//dateCount[retDataSetIndex]++;
			Element lineElement = rootElement.element("FloatArrayList").addElement("FloatArray");
			addTableAttribute(lineElement, columnHeaderStr, columnIndex);
		}
		DataXmlDescriptor dxd = new DataXmlDescriptor();
		dxd.setXmlDescriptString(dxdo.DescriptorDocumentSerialize());
		cds.setDataXmlDescriptorObj(dxd);
		addColumnDescription(cds);
		return cds;
	}
	
	private static void addColumnHeader(Element columnsElement, String headerStr, String columnIndexStr, String arrayListName, String indexStr){
		Element columnElement = columnsElement.addElement("Column");
		columnElement.addAttribute("Header", headerStr);
		columnElement.addAttribute("ColumnIndex", columnIndexStr);
		columnElement.addAttribute("Type", headerStr);
		columnElement.addAttribute("Index", indexStr);	
	}
		
	
	/**
	 * 在数据集结果中加入columns描述
	 * @param cds
	 * @return
	 */
	public static CommonDataSet addColumnDescription(CommonDataSet cds){
		DataXmlDescriptorOperator dxdo = new DataXmlDescriptorOperator(cds.getDataXmlDescriptorObj());
		Element desBlockElement = dxdo.GetDescriptionBlockElement();
		Element columnsElement = desBlockElement.addElement("Columns");
		
		Element booleanElement = desBlockElement.element("BooleanArrayList");
		if((booleanElement.elements("BooleanArray") != null)&&(booleanElement.elements("BooleanArray").size() != 0)){
			for(Element element: (List<Element>)(booleanElement.elements("BooleanArray"))){
				String headerStr = element.attributeValue("Header");
				String indexStr = element.attributeValue("Index");
				String columnIndexStr = element.attributeValue("ColumnIndex");
				String arrayListName = "BoolArrayList";

				if((!headerStr.equals(""))&&!(columnIndexStr.equals("-1"))){
					addColumnHeader(columnsElement, columnIndexStr ,headerStr, arrayListName,indexStr);
				}
			}	
		}
		
		Element charElement = desBlockElement.element("CharArrayList");
		if((charElement.elements("CharArray") != null)&&(charElement.elements("CharArray").size() != 0)){
			for(Element element: (List<Element>)(charElement.elements("CharArray"))){
				String headerStr = element.attributeValue("Header");
				String indexStr = element.attributeValue("Index");
				String columnIndexStr = element.attributeValue("ColumnIndex");
				String arrayListName = "CharArrayList";
				
				
				if((!headerStr.equals(""))&&!(columnIndexStr.equals("-1"))){
					addColumnHeader(columnsElement, columnIndexStr ,headerStr, arrayListName,indexStr);
				}
			}
		}
		
		Element byteElement = desBlockElement.element("ByteArrayList");
		if((byteElement.elements("ByteArray") != null)&&(byteElement.elements("ByteArray").size() != 0)){
			for(Element element: (List<Element>)(byteElement.elements("ByteArray"))){
				String headerStr = element.attributeValue("Header");
				String indexStr = element.attributeValue("Index");
				String columnIndexStr = element.attributeValue("ColumnIndex");
				String arrayListName = "ByteArrayList";
				
				if((!headerStr.equals(""))&&!(columnIndexStr.equals("-1"))){
					addColumnHeader(columnsElement, columnIndexStr ,headerStr, arrayListName,indexStr);
				}
			}
		}
		
		Element shortElement = desBlockElement.element("ShortArrayList");
		if((shortElement.elements("ShortArray") != null)&&(shortElement.elements("ShortArray").size() != 0)){
			for(Element element: (List<Element>)(shortElement.elements("ShortArray"))){
				String headerStr = element.attributeValue("Header");
				String indexStr = element.attributeValue("Index");
				String columnIndexStr = element.attributeValue("ColumnIndex");
				String arrayListName = "ShortArrayList";
				
				if((!headerStr.equals(""))&&!(columnIndexStr.equals("-1"))){
					addColumnHeader(columnsElement, columnIndexStr ,headerStr, arrayListName,indexStr);
				}
			}
		}
		
		Element intElement = desBlockElement.element("IntArrayList");
		if((intElement.elements("IntArray") != null)&&(intElement.elements("IntArray").size() != 0)){
			for(Element element: (List<Element>)(intElement.elements("IntArray"))){
				String headerStr = element.attributeValue("Header");
				String indexStr = element.attributeValue("Index");
				String columnIndexStr = element.attributeValue("ColumnIndex");
				String arrayListName = "IntArrayList";
				
				if((!headerStr.equals(""))&&!(columnIndexStr.equals("-1"))){
					addColumnHeader(columnsElement, columnIndexStr ,headerStr, arrayListName,indexStr);
				}
			}
		}
		
		Element longElement = desBlockElement.element("LongArrayList");
		if((longElement.elements("LongArray") != null)&&(longElement.elements("LongArray").size() != 0)){
			for(Element element: (List<Element>)(longElement.elements("LongArray"))){
				String headerStr = element.attributeValue("Header");
				String indexStr = element.attributeValue("Index");
				String columnIndexStr = element.attributeValue("ColumnIndex");
				String arrayListName = "LongArrayList";
				
				if((!headerStr.equals(""))&&!(columnIndexStr.equals("-1"))){
					addColumnHeader(columnsElement, columnIndexStr ,headerStr, arrayListName,indexStr);	
				}
			}
		}
		
		Element floatElement = desBlockElement.element("FloatArrayList");
		if((floatElement.elements("FloatArray") != null)&&(floatElement.elements("FloatArray").size() != 0)){
			for(Element element: (List<Element>)(floatElement.elements("FloatArray"))){
				String headerStr = element.attributeValue("Header");
				String indexStr = element.attributeValue("Index");
				String columnIndexStr = element.attributeValue("ColumnIndex");
				String arrayListName = "FloatArrayList";
				
				if((!headerStr.equals(""))&&!(columnIndexStr.equals("-1"))){
					addColumnHeader(columnsElement, columnIndexStr ,headerStr, arrayListName,indexStr);
				}
			}
		}
		
		Element doubleElement = desBlockElement.element("DoubleArrayList");
		if((doubleElement.elements("DoubleArray") != null)&&(doubleElement.elements("DoubleArray").size() != 0)){
			for(Element element: (List<Element>)(doubleElement.elements("DoubleArray"))){
				String headerStr = element.attributeValue("Header");
				String indexStr = element.attributeValue("Index");
				String columnIndexStr = element.attributeValue("ColumnIndex");
				String arrayListName = "DoubleArrayList";
				
				if((!headerStr.equals(""))&&!(columnIndexStr.equals("-1"))){
					addColumnHeader(columnsElement, columnIndexStr ,headerStr, arrayListName,indexStr);
				}
			}
		}
		
		Element stringElement = desBlockElement.element("StringArrayList");
		if((stringElement.elements("BooleanArray") != null)&&(stringElement.elements("StringArray").size() != 0)){
			for(Element element: (List<Element>)(stringElement.elements("StringArray"))){
				String headerStr = element.attributeValue("Header");
				String indexStr = element.attributeValue("Index");
				String columnIndexStr = element.attributeValue("ColumnIndex");
				String arrayListName = "StringArrayList";
				
				if((!headerStr.equals(""))&&!(columnIndexStr.equals("-1"))){
					addColumnHeader(columnsElement, columnIndexStr ,headerStr, arrayListName,indexStr);
				}
			}
		}
		
		Element dateElement = desBlockElement.element("DateArrayList");
		if((dateElement.elements("DateArray") != null)&&(dateElement.elements("DateArray").size() != 0)){
			for(Element element: (List<Element>)(dateElement.elements("DateArray"))){
				String headerStr = element.attributeValue("Header");
				String indexStr = element.attributeValue("Index");
				String columnIndexStr = element.attributeValue("ColumnIndex");
				String arrayListName = "DateArrayList";
				
				if((!headerStr.equals(""))&&!(columnIndexStr.equals("-1"))){
					addColumnHeader(columnsElement, columnIndexStr ,headerStr, arrayListName,indexStr);
				}
			}
		}
		
		desBlockElement.remove(booleanElement);
		desBlockElement.remove(byteElement);
		desBlockElement.remove(charElement);
		desBlockElement.remove(shortElement);
		desBlockElement.remove(intElement);
		desBlockElement.remove(floatElement);
		desBlockElement.remove(doubleElement);
		desBlockElement.remove(longElement);
		desBlockElement.remove(stringElement);
		desBlockElement.remove(dateElement);
		
		DataXmlDescriptor dxd = new DataXmlDescriptor();
		dxd.setXmlDescriptString(dxdo.DescriptorDocumentSerialize());
		cds.setDataXmlDescriptorObj(dxd);
		return cds;
	}


}
