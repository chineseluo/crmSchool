<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据字典</title>
<%@include file="common.jsp" %> 
<script type="text/javascript" src="/static/js/views/systemDictionary.js"></script>
</head>
<body>

<%--字典的主页面中的布局--%>
<div id="cc" class="easyui-layout" data-options="fit:true">
    <div data-options="region:'west',title:'字典'" style="width:50%">
        <table id="systemDictionary_datagrid"></table>
    </div>
    <div data-options="region:'center',title:'字典明细'" style="width:50%;background:#eee;">
        <table id="systemDictionaryItem_datagrid"></table>
    </div>
</div>

<!-- 定义对话框 -->
    <div id="systemDictionary_dialog">
        <div class="easyui-layout" data-options="fit:true">
              <form method="post" id="systemDictionary_form">
                <div data-options="region:'west',title:'字典'" style="width:39%;" align="center">

                        <input type="hidden" name="id">
                        <div style="margin-top: 15px">
                            <input type="text" name="sn" class="easyui-textbox" data-options="label:'字典编号:',labelPosition:'top', width:150">
                        </div>
                        <div>
                            <input type="text" name="name" class="easyui-textbox" data-options="label:'字典名称:',labelPosition:'top', width:150">
                        </div>
                        <div>
                            <input type="text" name="intro" class="easyui-textbox" data-options="label:'字典简介:',labelPosition:'top', width:150">
                        </div>
                        <div style="margin-top: 15px">
                            <a class="easyui-linkbutton" data-cmd="addItem">添加明细</a>
                        </div>


                </div>
                <div data-options="region:'center',title:'明细'" style="width:61%;">
                    <table align="center" id="systemDictionaryItem_table">

                        <tr>
                            <td>
                                <input type="text" name="items[0].name" class="easyui-textbox" data-options="label:'字典明细名称:',labelPosition:'top', width:150">

                            </td>
                            <td>
                                <input type="text" name="items[0].intro" class="easyui-textbox" data-options="label:'字典明细简介:',labelPosition:'top', width:150">
                            </td>
                        </tr>
                    </table>
                </div>
             </form>
        </div>
    </div>
                                <a id="delItemBtm" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true"  data-cmd="delItem"></a>

<!-- 定义顶部按钮 -->
<div id="systemDictionary_datagrid_tb">
	<div>
        <shiro:hasPermission name="systemDictionary:save">
		    <a class="easyui-linkbutton" iconCls="icon-newAdd" plain="true" data-cmd="add">新增</a>
        </shiro:hasPermission>

		<a id="systemDictionary_editBtn" class="easyui-linkbutton" iconCls="icon-blueEdit" plain="true"  data-cmd="edit">编辑</a>
		<a id="systemDictionary_quitBtn" class="easyui-linkbutton" iconCls="icon-delete" plain="true" data-cmd="del">删除</a>
		<a class="easyui-linkbutton" iconCls="icon-refreshNet" plain="true" data-cmd="reload">刷新</a>
	</div>
</div>
<!-- 对话框底部按钮 -->
<div id="systemDictionary_dialog_bt">
	<a class="easyui-linkbutton" iconCls="icon-blueSave" plain="true" data-cmd="save">保存</a>
	<a class="easyui-linkbutton" iconCls="icon-cnaclebnt" plain="true" data-cmd="cancel">取消</a>
</div>
</body>
</html>