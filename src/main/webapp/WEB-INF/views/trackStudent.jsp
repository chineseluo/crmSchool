<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="common.jsp" %>
    <script type="text/javascript" src="/static/js/views/trackStudent.js"></script>
    <title>学员跟踪</title>
</head>
<body>
<table id="trackstudent_datagrid"></table>
<div id="trackstudent_toolbar">
    <%--<a class="easyui-linkbutton" iconCls="icon-add" plain="true" data-cmd="add">添加</a>--%>
    <a class="easyui-linkbutton" iconCls="icon-blueEdit" plain="true" data-cmd="edit" id="edit_btn">编辑</a>
    <%--<a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="view",id="view_btn">查看</a>--%>
    <a class="easyui-linkbutton" iconCls="icon-delete" plain="true" data-cmd="del"  id="del_btn">删除</a>
    <a class="easyui-linkbutton" iconCls="icon-refreshNet" plain="true" data-cmd="reload">刷新</a>
    <%--<input class="easyui-textbox" name='keyword' prompt="姓名/QQ/电话"/>
    <a class="easyui-linkbutton" iconCls="icon-search" plain="true" data-cmd="formalSearch">查询</a>--%>
   <%-- <input name="currentclass.id" class="easyui-combobox" prompt="请选择班级" id="searchClass"
           data-options="valueField:'name',textField:'name',url:'schoolclass_combobox',panelHeight:'auto',editable:false" />
    <a class="easyui-linkbutton" iconCls="icon-search" plain="true" data-cmd="fastSearch"></a>--%>
</div>

<div id="show_photo">
    <img src="" id="show_photo_img">
</div>



<div id="trackstudent_dialog">
    <form method="post" id="trackstudent_form" enctype="multipart/form-data">
        <input type="hidden" name="id" id="trackStudent_id" />
        <input type="hidden" name="student.id" />
        <input type="hidden" name="fileAddress" />
        <table align="center">
            <tr>
                <td>日期:</td>
                <td><input class="easyui-datebox" name="trackTime" /></td>
                <td>交流方式</td>
                <td><input class="easyui-combobox" name="consultType.id"
                           data-options="valueField:'id',textField:'name',url:'/systemDictionaryItem/payList?sn=talkType',panelHeight:'auto'"/></td>
                <td>营销人员</td>
                <td><input class="easyui-textbox" name="marketingMan.name"/></td>
            </tr>
            <tr>
                <td>潜在学员:</td>
                <td><input class="easyui-textbox" name="student.name"/></td>
                <td>所属学校</td>
                <td><input class="easyui-combobox" name="school.id"
                           data-options="valueField:'id',textField:'school',url:'/bigClient/selectAll',panelHeight:'auto'"/></td>
            </tr>
            <tr>
                <td>电话:</td>
                <td><input class="easyui-textbox" name="student.telephone"/></td>
                <td>qq:</td>
                <td><input class="easyui-textbox" name="student.qq"/></td>
                <td>咨询时长(分钟):</td>
                <td><input class="easyui-textbox" name="consultTime"  /></td>
            </tr>
            <tr>
                <td>约访日期:</td>
                <td><input class="easyui-datebox" name="trackTime"/></td>
                <td>当前状态:</td>
                <td><input class="easyui-combobox" name="student.currentState.id"
                           data-options="valueField:'id',textField:'name',url:'/systemDictionaryItem/payList?sn=currentStatu',panelHeight:'auto'"/></td>
                <td>意向程度:</td>
                <td><input class="easyui-combobox" name="student.intentionLevel.id"
                           data-options="valueField:'id',textField:'name',url:'/systemDictionaryItem/payList?sn=intentionGrade',panelHeight:'auto'"/></td>
            </tr>
            <tr>
                <td>下次访问时间:</td>
                <td><input class="easyui-datebox" name="nextVisitTime" />
                <td>跟进目的:</td>
                <td><input class="easyui-textbox" name="trackAim"/></td>
                <td>意向班级:</td>
                <td><input class="easyui-combobox" name="student.intentionClass.id"
                           data-options="valueField:'id',textField:'name',url:'/classroom/payList',panelHeight:'auto'"/></td>
            </tr>
            <tr>
                <td>文件地址</td>
                <td><input type="file" name="multipartFile" /></td>
            </tr>
            <tr>
                <td>摘要</td>
                <td><input class="easyui-textbox" data-options="multiline:true"  name="summary" /></td>
            </tr>
            <tr>
                <td>交流内容</td>
                <td><input class="easyui-textbox" data-options="multiline:true" name="talkContent" /></td>
            </tr>
        </table>
    </form>
</div>
<div id="trackstudent_dialog_buttons">
    <a class="easyui-linkbutton" iconCls="icon-blueSave" plain="true" data-cmd="save">保存</a>
    <a class="easyui-linkbutton" iconCls="icon-cnaclebnt" plain="true" data-cmd="cancel">取消</a>
</div>
</body>
</html>