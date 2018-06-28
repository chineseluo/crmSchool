<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>大客户</title>
    <%@ include file="common.jsp" %>
    <script type="text/javascript" src="/static/js/views/bigClient.js"></script>
</head>
<body>
<table id="bigClient_data"></table>
<div id="bigClient_tb">
    <div>
        <a class="easyui-linkbutton" iconCls="icon-newAdd" plain="true" data-cmd="add">新增</a>
        <a class="easyui-linkbutton" iconCls="icon-blueEdit" plain="true" data-cmd="edit">編輯</a>
        <a class="easyui-linkbutton" iconCls="icon-delete" plain="true" data-cmd="del">刪除</a>
        <a class="easyui-linkbutton" iconCls="icon-see" plain="true" data-cmd="allSelect">查看</a>
        <a class="easyui-linkbutton" iconCls="icon-select" plain="true" data-cmd="advSelect">高级查询</a>
        <a class="easyui-linkbutton" iconCls="icon-refreshNet" plain="true" data-cmd="reload">刷新</a>
        <a class="easyui-linkbutton" iconCls="icon-train" plain="true" data-cmd="train">实训相关</a>
        <a href="javascript:void(0)" id="mb" class="easyui-menubutton"
           data-options="menu:'#mm',iconCls:'icon-transfer'">移交</a>
        <div id="mm" style="width:150px;">
        </div>
    </div>
</div>
<div id="bigClient_advDialog">
    <form id="advForm">
        <table align="center" style="text-align: right">
            <tr>
                <td>学校名称:</td>
                <td><input id="bigClient_advSchool" type="text" class="easyui-combobox"></td>
                <td>营销人员:</td>
                <td><input id="bigClient_advMarketing" type="text" class="easyui-combobox"></td>
            </tr>
            <tr>
                <td>学校类型:</td>
                <td><input id="bigClient_advSchoolType" type="text" class="easyui-combobox"></td>
                <td>星级:</td>
                <td><input id="advStarLevel" type="text" class="easyui-combobox" data-options="
                                                            valueField: 'label',
                                                            textField: 'value',
                                                            data: [{
                                                                label: '★',
                                                                value: '★'
                                                            },{
                                                                label: '★★',
                                                                value: '★★'
                                                            },{
                                                                label: '★★★',
                                                                value: '★★★'
                                                            },{
                                                                label: '★★★★',
                                                                value: '★★★★'
                                                            },{
                                                                label: '★★★★★',
                                                                value: '★★★★★'
                                                            }]"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<div id="bigClient_dialog">
    <form id="bigClientForm" method="post">
        <input type="hidden" name="id">
        <table align="center" style="text-align: right">
            <tr>
                <td>学校名称:</td>
                <td><input name="school" id="bigClient_school" type="text" class="easyui-combobox"></td>
                <td>简称1:</td>
                <td><input name="abbreviationOne" type="text" class="easyui-textbox"></td>
                <td>简称2:</td>
                <td><input name="abbreviationTwo" type="text" class="easyui-textbox"></td>
            </tr>
            <tr>
                <td>归属部门:</td>
                <td><input name="department" type="text" class="easyui-textbox"></td>
                <td>营销人员:</td>
                <td><input name="marketing.id" id="bigClient_marketing" type="text" class="easyui-combobox"></td>
                <td>跟进人员:</td>
                <td><input name="follow.id" id="bigClient_follow" type="text" class="easyui-combobox"></td>
            </tr>
            <tr>
                <td>学校类型:</td>
                <td><input name="schoolType" id="bigClient_schoolType" type="text" class="easyui-combobox"></td>
                <td>学历:</td>
                <td><input name="education" id="bigClient_education" type="text" class="easyui-combobox"></td>
                <td>地域:</td>
                <td><input name="region" id="bigClient_region" type="text" class="easyui-combobox"></td>
            </tr>
            <tr>
                <td>办学性质:</td>
                <td><input name="schoolProperties" id="bigClient_schoolProperties" type="text" class="easyui-combobox">
                </td>
                <td>创立时间:</td>
                <td><input name="createDate" type="text" class="easyui-datebox"></td>
                <td>星级:</td>
                <td><input name="starLevel" type="text" class="easyui-combobox" data-options="
                                                            valueField: 'label',
                                                            textField: 'value',
                                                            data: [{
                                                                label: '★',
                                                                value: '★'
                                                            },{
                                                                label: '★★',
                                                                value: '★★'
                                                            },{
                                                                label: '★★★',
                                                                value: '★★★'
                                                            },{
                                                                label: '★★★★',
                                                                value: '★★★★'
                                                            },{
                                                                label: '★★★★★',
                                                                value: '★★★★★'
                                                            }]"/>
                </td>
            </tr>
            <tr>
                <td>管理部门:</td>
                <td><input name="deptManage" type="text" class="easyui-textbox"></td>
                <td>学制:</td>
                <td><input name="eductionalsystme" id="bigClient_eductionalsystme" type="text" class="easyui-combobox">
                </td>
                <td>地址:</td>
                <td><input name="address" type="text" class="easyui-textbox"></td>
            </tr>
            <tr>
                <td>邮政编码:</td>
                <td><input name="postalCode" type="text" class="easyui-textbox"></td>
                <td>电话:</td>
                <td><input name="phone" type="text" class="easyui-textbox"></td>
                <td>传真:</td>
                <td><input name="fax" type="text" class="easyui-textbox"></td>
            </tr>
            <tr>
                <td>邮箱:</td>
                <td><input name="email" type="text" class="easyui-textbox"></td>
                <td>主页:</td>
                <td><input name="homepage" type="text" class="easyui-textbox"></td>
                <td>校长:</td>
                <td><input name="principal" type="text" class="easyui-textbox"></td>
            </tr>
            <tr>
                <td>员工数:</td>
                <td><input name="employeeNumber" type="text" class="easyui-textbox"></td>
                <td>老师数:</td>
                <td><input name="teacherNumber" type="text" class="easyui-textbox"></td>
                <td>在校人数:</td>
                <td><input name="inSchoolNumber" type="text" class="easyui-textbox"></td>
            </tr>
            <tr>
                <td>IT专业学生:</td>
                <td><input name="itNumber" type="text" class="easyui-textbox"></td>
                <td>合作高校:</td>
                <td align="left"><input id="radioT" type="radio" name="cooperationSchool" value="1">是<input id="radioF"
                                                                                                            type="radio"
                                                                                                            name="cooperationSchool"
                                                                                                            value="0">否
                </td>
                <td>签约数:</td>
                <td><input name="signNumber" type="text" class="easyui-textbox"></td>
            </tr>
            <tr>
                <td>热点等级:</td>
                <td><input name="hotspotLevel" id="bigClient_hotspotLevel" type="text" class="easyui-combobox"></td>
            </tr>
            <tr>
                <td>热点描述:</td>
                <td colspan="5"><input name="hotspotDescribe" class="easyui-textbox"
                                       data-options="multiline:true" style="width: 600px">
                </td>
            </tr>
            <tr>
                <td>学校简介:</td>
                <td colspan="5"><input name="schoolInfo" class="easyui-textbox"
                                       data-options="multiline:true" style="width: 600px">
                </td>
            </tr>
        </table>
    </form>
</div>
<div id="bigClient_bnt">
    <div>
        <a class="easyui-linkbutton" iconCls="icon-blueSave" plain="true" data-cmd="save">保存</a>
        <a class="easyui-linkbutton" iconCls="icon-cnaclebnt" plain="true" data-cmd="cancel">取消</a>
    </div>
</div>
<div id="bigClient_advBnt">
    <div>
        <a class="easyui-linkbutton" iconCls="icon-select" plain="true" data-cmd="advSave">查询</a>
        <a class="easyui-linkbutton" iconCls="icon-reset" plain="true" data-cmd="advReload">重置</a>
        <a class="easyui-linkbutton" iconCls="icon-cnaclebnt" plain="true" data-cmd="advCancel">取消</a>
    </div>
</div>
<div id="train_dialog">
    <table id="train_data"></table>
    <div id="train_tb">
        <div>
            <a class="easyui-linkbutton" iconCls="icon-newAdd" plain="true" data-cmd="trainAdd">新增</a>
            <a class="easyui-linkbutton" iconCls="icon-blueEdit" plain="true" data-cmd="trainEdit">編輯</a>
            <a class="easyui-linkbutton" iconCls="icon-delete" plain="true" data-cmd="trainDel">刪除</a>
            <a class="easyui-linkbutton" iconCls="icon-reset" plain="true" data-cmd="trainReload">刷新</a>
        </div>
    </div>
    <div id="train_editDialog">
        <form id="trainForm" method="post">
            <input type="hidden" name="id" id="trainId">
            <table align="center">
                <tr>
                    <td>实训时间:</td>
                    <td><input name="trainDate" type="text" class="easyui-datebox"></td>
                    <td>实训地点:</td>
                    <td><input name="trainAddress" type="text" class="easyui-textbox"></td>
                </tr>
                <tr>
                    <td>实训效果:</td>
                    <td><input name="trainResult" type="text" class="easyui-textbox"></td>
                </tr>
                <tr>
                    <td>实训内容:</td>
                    <td colspan="3"><input name="trainInfo" type="text" class="easyui-textbox"
                                           data-options="multiline:true" style="width: 370px"></td>
                </tr>
                <tr>
                    <td>备注:</td>
                    <td colspan="3"><input name="remark" type="text" class="easyui-textbox"
                                           data-options="multiline:true" style="width: 370px"></td>
                </tr>
            </table>
        </form>
    </div>
    <div id="train_bnt">
        <div>
            <a class="easyui-linkbutton" iconCls="icon-blueSave" plain="true" data-cmd="trainSave">保存</a>
            <a class="easyui-linkbutton" iconCls="icon-cnaclebnt" plain="true" data-cmd="trainCancel">取消</a>
        </div>
    </div>
</div>
<div id="bigClient_dialogS">
    <form id="bigClientFormS" method="post">
        <table align="center" style="text-align: right">
            <tr>
                <td>学校名称:</td>
                <td><input name="school" type="text"></td>
                <td>简称1:</td>
                <td><input name="abbreviationOne" type="text"></td>
                <td>简称2:</td>
                <td><input name="abbreviationTwo" type="text"></td>
            </tr>
            <tr>
                <td>归属部门:</td>
                <td><input name="department" type="text"></td>
                <td>营销人员:</td>
                <td><input name="marketing.username" type="text"></td>
                <td>跟进人员:</td>
                <td><input name="follow.username" type="text"></td>
            </tr>
            <tr>
                <td>学校类型:</td>
                <td><input name="schoolType" type="text"></td>
                <td>学历:</td>
                <td><input name="education" type="text"></td>
                <td>地域:</td>
                <td><input name="region" type="text"></td>
            </tr>
            <tr>
                <td>办学性质:</td>
                <td><input name="schoolProperties" type="text">
                </td>
                <td>创立时间:</td>
                <td><input name="createDate" type="text"></td>
                <td>星级:</td>
                <td><input name="starLevel" type="text">
                </td>
            </tr>
            <tr>
                <td>管理部门:</td>
                <td><input name="deptManage" type="text"></td>
                <td>学制:</td>
                <td><input name="eductionalsystme" type="text">
                </td>
                <td>地址:</td>
                <td><input name="address" type="text"></td>
            </tr>
            <tr>
                <td>邮政编码:</td>
                <td><input name="postalCode" type="text"></td>
                <td>电话:</td>
                <td><input name="phone" type="text"></td>
                <td>传真:</td>
                <td><input name="fax" type="text"></td>
            </tr>
            <tr>
                <td>邮箱:</td>
                <td><input name="email" type="text"></td>
                <td>主页:</td>
                <td><input name="homepage" type="text"></td>
                <td>校长:</td>
                <td><input name="principal" type="text"></td>
            </tr>
            <tr>
                <td>员工数:</td>
                <td><input name="employeeNumber" type="text"></td>
                <td>老师数:</td>
                <td><input name="teacherNumber" type="text"></td>
                <td>在校人数:</td>
                <td><input name="inSchoolNumber" type="text"></td>
            </tr>
            <tr>
                <td>IT专业学生:</td>
                <td><input name="itNumber" type="text"></td>
                <td>合作高校:</td>
                <td align="left"><input id="radioTS" type="radio" name="cooperationSchool" value="1">是<input
                        id="radioFS"
                        type="radio"
                        name="cooperationSchool"
                        value="0">否
                </td>
                <td>签约数:</td>
                <td><input name="signNumber" type="text"></td>
            </tr>
            <tr>
                <td>热点等级:</td>
                <td><input name="hotspotLevel" type="text"></td>
            </tr>
            <tr>
                <td>热点描述:</td>
                <td colspan="5"><textarea name="hotspotDescribe" style="width: 600px;height: 35px"></textarea>
                </td>
            </tr>
            <tr>
                <td>学校简介:</td>
                <td colspan="5"><textarea name="schoolInfo" style="width: 600px;height: 35px"></textarea>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
