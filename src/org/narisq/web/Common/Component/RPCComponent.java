package org.narisq.web.Common.Component;


import org.narisq.web.Common.Param.ConcreteCommonParam;

public abstract class RPCComponent extends AbstractComponent {

	public RPCComponent() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public AbstractComponent Clone() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ConcreteCommonParam process(ConcreteCommonParam obj) {
		ConcreteCommonParam PreConcreteCommonParamObj = PreProcess(obj);
		ConcreteCommonParam ConcreteCommonParamObj = Process(PreConcreteCommonParamObj);
		/**
		 * 
<ParamXmlNode> 
  <DataOperationNode> 
    <DataType Value="rttower"/>  
    <ReturnDataSource NameList="rtTower"/>  
    <Fields DataSetCount="1"> 
      <Field Name="towerid" ConvertType="string" Header="测风塔号" ColumnIndex="0" DataSetIndex="0"/>  
      <Field Name="to_char(time,'hh24:mi:ss')" ConvertType="string" Header="时间" ColumnIndex="1" DataSetIndex="0"/>  
      <Field Name="v1avgsp" ConvertType="double" Header=" V1avgsp " ColumnIndex="2" DataSetIndex="0"/>  
      <Field Name="v1avgdir" ConvertType="double" Header=" V1avgdir " ColumnIndex="3" DataSetIndex="0"/>  
      <Field Name="v2avgsp" ConvertType="double" Header=" V2avgsp " ColumnIndex="4" DataSetIndex="0"/>  
      <Field Name="v2avgdir" ConvertType="double" Header=" V2avgdir " ColumnIndex="5" DataSetIndex="0"/>  
      <Field Name="v3avgsp" ConvertType="double" Header=" V3avgsp " ColumnIndex="6" DataSetIndex="0"/>  
      <Field Name="v3avgdir" ConvertType="double" Header=" V3avgdir " ColumnIndex="7" DataSetIndex="0"/>  
      <Field Name="v4avgsp" ConvertType="double" Header=" V4avgsp " ColumnIndex="8" DataSetIndex="0"/>  
      <Field Name="v4avgdir" ConvertType="double" Header=" V4avgdir " ColumnIndex="9" DataSetIndex="0"/>  
      <Field Name="v5avgsp" ConvertType="double" Header=" V5avgsp " ColumnIndex="10" DataSetIndex="0"/>  
      <Field Name="v5avgdir" ConvertType="double" Header=" V5avgdir " ColumnIndex="11" DataSetIndex="0"/>  
      <Field Name="v6avgsp" ConvertType="double" Header=" V6avgsp " ColumnIndex="12" DataSetIndex="0"/>  
      <Field Name="v6avgdir" ConvertType="double" Header=" V6avgdir " ColumnIndex="13" DataSetIndex="0"/>  
      <Field Name="v7avgsp" ConvertType="double" Header=" V7avgsp " ColumnIndex="14" DataSetIndex="0"/>  
      <Field Name="v7avgdir" ConvertType="double" Header=" V7avgdir " ColumnIndex="15" DataSetIndex="0"/>  
      <Field Name="V1TEMP" ConvertType="double" Header=" V1TEMP " ColumnIndex="16" DataSetIndex="0"/>  
      <Field Name="V1HUM" ConvertType="double" Header=" V1HUM " ColumnIndex="17" DataSetIndex="0"/>  
      <Field Name="PRESSURE" ConvertType="double" Header=" PRESSURE " ColumnIndex="18" DataSetIndex="0"/> 
    </Fields>  
    <Condition Op="and"> 
      <Condition Op="and"> 
        <Condition UID="201" Field="time" Op="=" Value="(select max(time) from fd_run_rttower) " ValueType="other"/>  
        <Condition UID="202" Field="towerid" Op="in" Value="57107999,57061999,57061999" ValueType="string"/> 
      </Condition>  
      <Condition UID="203" Field="time" Op="morethan" Value="2017-05-28 13-43-00" ValueType="oracletime"/> 
    </Condition> 
  </DataOperationNode> 
</ParamXmlNode>
		 */
		ConcreteCommonParam PostConcreteCommonParamObj = PostProcess(ConcreteCommonParamObj);
		return PostConcreteCommonParamObj;	

	}
	
	
}
