<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="common.jsp" %>
    <script type="text/javascript" src="/static/js/views/potentialCustomPool.js"></script>
    <title>潜在客户池</title>
</head>
<body>
	<table id="potentialCustomPool_datagrid"></table>
	<div id="potentialCustomPool_datagrid_tb">
		<a class="easyui-linkbutton" iconCls="icon-large-shapes" plain="true" data-cmd="view">查看(V)</a>
		<a class="easyui-linkbutton" iconCls="icon-delete" plain="true" data-cmd="del">删除</a>
		<a class="easyui-linkbutton" iconCls="icon-refreshNet" plain="true" data-cmd="reload">刷新</a>
		<%--<a class="easyui-linkbutton" iconCls="icon-transfer" plain="true" data-cmd="remove">移交</a>--%>
		<%--<a class="easyui-linkbutton" iconCls="icon-xls" plain="true" data-cmd="exportStudent">导出</a>--%>
		<a class="easyui-linkbutton" iconCls="icon-reset" plain="true" data-cmd="restore">还原</a>
		<%--<input class="easyui-searchbox"  data-options="prompt:'姓名/QQ/电话',searcher:keyword_query" id="keyword"></input>--%>
	</div>

	<!-- ===========================================view=========================================== -->
	<div id="potentialCustomPool_dialog_view">
		<form id="potentialCustomPool_dialog_form_view" method="post">
			<input type="hidden" name="id"/>
			<table align="center" style="margin-top: 20px">
				<tr>
					<td>建档日期:</td>
					<td><input type="text" class="easyui-datebox" name="buildFileTime"  readonly="readonly"/></td>
					<td>营销人员:</td>
					<td>
						<input type="text" name="marketingMan.username" class="easyui-textbox" />
					</td>
					<td>录入人:</td>
					<td><input type="text" name="inputMan.username" class="easyui-textbox"  readonly="readonly"/></td>
				</tr>
				<tr>
					<td>录入时间:</td>
					<td><input type="text"  class="easyui-textbox"  name="inputTime" readonly="readonly"/></td>
					<td>意向校区:</td>
					<td><input type="text" name="intentionSchoolRegion.name" class="easyui-textbox"  readonly="readonly"
					 /></td>
					<td>下次跟进时间:</td>
					<td><input type="text" class="easyui-datebox" name="nextFollowUpTime" readonly="readonly"/></td>
				</tr>
				<tr>
					<td>约访时间:</td>
					<td><input type="text" class="easyui-datebox" name="vistitTime" readonly="readonly"/></td>
					<td>来源:</td>
					<td><input type="text" name="source.name"  class="easyui-textbox"  readonly="readonly"
					 /></td>
                    <td>姓名:</td>
					<td><input type="text" name="name"  class="easyui-textbox"  readonly="readonly"/></td>
				</tr>
				<tr>
					<td>微信号:</td>
					<td><input type="text"  name="weChat" readonly="readonly"/></td>
					<td>QQ:</td>
					<td><input type="text" name="qq" readonly="readonly"/></td>
					<td>电话:</td>
					<td><input type="text" name="telephone" readonly="readonly"/></td>
				</tr>
				<tr>
					<td>年龄:</td>
					<td><input type="text"  name="age" readonly="readonly"/></td>
					<td>性别:</td>
					<td><input type="text"  class="easyui-textbox"  name="gender" readonly="readonly"
					/></td>
					<td>Email:</td>
					<td><input type="text" name="email" readonly="readonly"/></td>
				</tr>
				<tr>
					<td>联系地址:</td>
					<td><input type="text"  name="address" readonly="readonly"/></td>
					<td>学校或培训机构:</td>
					<td><input type="text" name="schoolOrTrainOrganization" readonly="readonly"/></td>
					<td>学校客户:</td>
					<td>
						<input type="text" name="schoolClient.name"  class="easyui-textbox" readonly="readonly"
						/>
				</tr>
				<tr>
					<td>学历:</td>
					<td><input type="text" name="education.name"   class="easyui-textbox"  readonly="readonly"
					/></td>
					<td>专业:</td>
					<td><input type="text" name="profession" readonly="readonly"/></td>
					<td>地域:</td>
					<td><input type="text" name="region.name"  class="easyui-textbox"  readonly="readonly"
					/></td>
				</tr>
				<tr>
					<td>工作年限:</td>
					<td><input type="text" name="workYear.name"   class="easyui-textbox"  readonly="readonly"
					/></td>
					<td>当前状态:</td>
					<td><input type="text" name="currentState.name"  class="easyui-textbox"   readonly="readonly"
					/></td>
					<td>介绍人:</td>
					<td><input type="text" name="introducer" readonly="readonly"/></td>
				</tr>
				<tr>
					<td>意向学科:</td>
					<td><input type="text" name="intentionSubject.name" class="easyui-textbox"  readonly="readonly"
					/></td>
					<td>意向班级:</td>
					<td>
						<input type="text" name="intentionClass.name"  class="easyui-textbox"  readonly="readonly"
						/>
					</td>
					<td>意向程度:</td>
					<td><input type="text" name="intentionLevel.name" class="easyui-combobox" readonly="readonly"
					data-options="panelHeight:'auto',valueField:'id',textField:'name',url:''" /></td>
				</tr>
				<tr>
					<td>客户类型:</td>
					<td><input type="text" name="clientType.name"   class="easyui-textbox"  readonly="readonly"
					/></td>
					<td>其他营销人员:</td>
					<td><input type="text" name="otherMarketingMan.name"  class="easyui-textbox"  readonly="readonly"
					/></td>
					<td>携带笔记本:</td>
					<td><input type="text" name="bringComputer" class="easyui-combobox" readonly="readonly"
					data-options="panelHeight:'auto',valueField:'id',textField:'name',data:[{id:'1',name:'是'},{id:'0',name:'否'}]"/></td>
				</tr>
				<tr>
					<td>大学入学时间:</td>
					<td><input type="text" name="enrolTime"  class="easyui-datebox" readonly="readonly"/></td>
					<td>零付款:</td>
					<td>
						<input type="text" name="zeroPay" class="easyui-combobox" readonly="readonly"
						data-options="panelHeight:'auto',valueField:'id',textField:'name',data:[{id:'1',name:'是'},{id:'0',name:'否'}]"/>
					</td>
				</tr>
				<tr>
					<td valign="top">关注问题:</td>
					<td colspan="5"><input type="text" style="width: 650px;height:50px;margin:2px 2px 2px 5px;" readonly="readonly" name="careQuestion"/></td>
				</tr>
				<tr>
					<td valign="top">备注:</td>
					<td colspan="5"><input type="text" style="width: 650px;height:50px;margin:2px 2px 2px 5px;" readonly="readonly" name="remark"/></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="potentialCustomPool_dialog_bt_view">
		<a class="easyui-linkbutton" iconCls="icon-ok" plain="true" data-cmd="ok">确定(K)</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="ok">退出(X)</a>
	</div>
	<!-- ==========================================学员移交========================================== -->
	<div id="potentialCustomPool_dialog_remove">
		<form id="potentialCustomPool_dialog_form_remove" method="post">
			<input type="hidden" name="marketingMan.id" id="before_id"/>
            <input type="hidden" name="name" id="client_name">
            <input type="hidden" name="id" id="client_id">
			<table align="center" style="margin-top: 20px">
			<tr>
				<td>营销人员:</td>
					<td>
						<input type="text" name="after.id" class="easyui-combobox"
						data-options="panelHeight:'auto',valueField:'id',textField:'realname',url:'/employee/queryEmpByRoleSn?sn=SALEMAN'"/>
					</td>
			</tr>
			<tr>
				<td>移交原因:</td>
				<td colspan="5"><input type="text" name="reason" style="width: 250px;height:150px;" /></td>
			</tr>
			</table>
		</form>
	</div>
	<div id="potentialCustomPool_dialog_bt_remove">
		<a class="easyui-linkbutton" iconCls="icon-ok" plain="true" data-cmd="removePotentialClientPool">确定移交(K)</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancel">取消(X)</a>
	</div>
</body>
</html>