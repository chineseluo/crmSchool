<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>售前管理</title>
    <%@ include file="common.jsp" %>
    <script type="text/javascript" src="/static/js/views/potentialCustom.js"></script>

    <style>
        form td {
            font-size: 14px;
        }
    </style>
</head>
<body>
<table id="potentialCustom_data"></table>
<div id="potentialCustom_tb">
    <div>
        <a class="easyui-linkbutton" iconCls="icon-newAdd" plain="true" data-cmd="add">新增</a>
        <a class="easyui-linkbutton" iconCls="icon-blueEdit" plain="true" data-cmd="edit">編輯</a>
        <a class="easyui-linkbutton" iconCls="icon-see" plain="true" data-cmd="lookup">查看</a>
        <a class="easyui-linkbutton" iconCls="icon-refreshNet" plain="true" data-cmd="reload">刷新</a>
        <a class="easyui-linkbutton" iconCls="icon-select" plain="true" data-cmd="search">高级查询</a>
        <a class="easyui-linkbutton" iconCls="icon-xls" plain="true" data-cmd="downloadJxl">下载表格</a>
        <a class="easyui-linkbutton" iconCls="icon-blueSave" plain="true" data-cmd="becomeFormalStudent">转正</a>
        <a class="easyui-linkbutton" iconCls="icon-see" plain="true" data-cmd="reackStudent">跟踪</a>
        <a class="easyui-linkbutton" iconCls="icon-train" plain="true" data-cmd="examRegister">考试登记</a>
        <a class="easyui-linkbutton" iconCls="icon-transfer" plain="true" data-cmd="sentToCustomPool">放入客户池</a>
        <a class="easyui-linkbutton" iconCls="icon-refreshNet" plain="true" data-cmd="reload">其他</a>
    </div>
</div>
<div id="potentialCustom_look_dialog"  >
    <form  id="potentialCustomLookForm" method="post" >
        <input type="hidden" name="id">
        <table align="center" style="margin-top: 15px">
          <tr>
                <td align="right" style="width: 100px">建档时间:</td>
                <td align="left" style="width: 100px">
                    <input name="inputTime" class= "easyui-datebox"  >
                </td>

                <td align="right" style="width: 100px">销售人员:</td>
                <td align="left" style="width: 100px">
                    <input  name="marketingMan.name" class= "easyui-textbox"    >
                </td>

                <td align="right" style="width: 100px">意向校区:</td>
                <td align="left" style="width: 100px">
                    <input  name="intentionSchoolRegion.name"  class= "easyui-textbox" >
                </td>

            </tr>

            <tr>
                <td align="right" style="width: 100px">下次跟进时间:</td>
                <td align="left" style="width: 100px">
                    <input name="nextFollowUpTime" class= "easyui-datebox" >
                </td>

                <td align="right" style="width: 100px">约访时间:</td>
                <td align="left" style="width: 100px">
                    <input name="vistitTime" class= "easyui-datebox"  >
                </td>

                <td align="right" style="width: 100px">来源:</td>
                <td align="left" style="width: 100px">
                    <input id="" name="source.name" class= "easyui-textbox"   >
                </td>

            </tr>

            <tr>
                <td align="right" style="width: 100px">姓名:</td>
                <td align="left" style="width: 100px">
                    <input name="name" class= "easyui-textbox" >
                </td>
                <td align="right" style="width: 100px">微信号:</td>
                <td align="left" style="width: 100px">
                    <input name="weChat" class= "easyui-textbox"  >
                </td>

                <td align="right" style="width: 100px">QQ:</td>
                <td align="left" style="width: 100px">
                    <input name="qq" class= "easyui-textbox"  >
                </td>

            </tr>

            <tr>
                <td align="right" style="width: 100px">电话:</td>
                <td align="left" style="width: 100px">
                    <input name="telephone"  class= "easyui-textbox" >
                </td>
                <td align="right" style="width: 100px">年龄:</td>
                <td align="left" style="width: 100px">
                    <input name="age"  class= "easyui-textbox" >
                </td>


                <td align="right" style="width: 100px">性别:</td>
                <td align="left" style="width: 100px">
                    <input name="gender" class= "easyui-textbox" >
                </td>
            </tr>

            <tr>
                <td align="right" style="width: 100px">Email:</td>
                <td align="left" style="width: 100px">
                    <input name="email"  class= "easyui-textbox" >
                </td>

                <td align="right" style="width: 100px">联系地址:</td>
                <td align="left" style="width: 100px">
                    <input name="address" class= "easyui-textbox" >
                </td>
                <td align="right" style="width: 100px">培训机构:</td>
                <td align="left" style="width: 100px">
                    <input name="schoolOrTrainOrganization" class= "easyui-textbox" >
                </td>
            </tr>

            <tr>
                <%--等着大客户去维护--%>
                <td align="right" style="width: 100px">学校客户:</td>
                <td align="left" style="width: 100px">
                    <input name="schoolClient.id"  class= "easyui-textbox"  >
                </td>

                <td align="right" style="width: 100px">学历:</td>
                <td align="left" style="width: 100px">
                    <input  name="education.name"  class= "easyui-textbox" >
                </td>

                <td align="right" style="width: 100px">专业:</td>
                <td align="left" style="width: 100px">
                    <input name="profession" class= "easyui-textbox" >
                </td>
            </tr>
            <tr>

                <td align="right" style="width: 100px">地域:</td>
                <td align="left" style="width: 100px">
                    <input  name="region.name"  class= "easyui-textbox" >
                </td>

                <td align="right" style="width: 100px">工作年限:</td>
                <td align="left" style="width: 100px">
                    <input  name="workYear.name" class= "easyui-textbox"  >
                </td>

                <td align="right" style="width: 100px">介绍学员:</td>
                <td align="left" style="width: 100px">
                    <input name="introducer"  class= "easyui-textbox" >
                </td>
            </tr>
            <tr>

                <td align="right" style="width: 100px">意向学科:</td>
                <td align="left" style="width: 100px">
                    <input id="" name="intentionSubject.name"  class= "easyui-textbox" >
                </td>



                <td align="right" style="width: 100px">意向班级:</td>
                <td align="left" style="width: 100px">
                    <input  id="" name="intentionClass.name" class= "easyui-textbox" >
                </td>


                <td align="right" style="width: 100px">意向程度:</td>
                <td align="left" style="width: 100px">
                    <input id="" name="intentionLevel.name" class= "easyui-textbox"  >
                </td>

            </tr>

            <tr>
                <%--/?????????--%>
                <td align="right" style="width: 100px">当前状态:</td>
                <td align="left" style="width: 100px">
                    <input id="" name="currentState.name" class= "easyui-textbox" >
                </td>


                <td align="right" style="width: 100px">客户类型:</td>
                <td align="left" style="width: 100px">
                    <input id="" name="clientType.name"  class= "easyui-textbox" >
                </td>


                <td align="right" style="width: 100px">其他销售人员:</td>
                <td align="left" style="width: 100px">
                    <input name="" class= "easyui-textbox" >
                </td>
            </tr>

            <tr>
                <td align="right" style="width: 100px">携带笔记本:</td>
                <td align="left" style="width: 100px">
                    <select name="bringComputer" class="easyui-combobox" style="width: 100px">
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                </td>

                <td align="right" style="width: 100px">大学入学时间:</td>
                <td align="left" style="width: 100px">
                    <input name="enrolTime" class= "easyui-datebox"  >
                </td>

                <td align="right" style="width: 100px">零付款:</td>
                <td style="text-align:left">

                        <input id="" type="radio" name="zeroPay" value="0">否
                        <input id=""  type="radio" name="zeroPay" value="1">是
                </td>

            </tr>

            <tr>
                <td >
                    <span>关注问题</span>
                </td>
                <td colspan="5">
                    <input name="careQuestion" class="easyui-textbox" data-options="multiline:true"  style="width:600px;height:50px">
                </td>
            </tr>
            <tr>
                <td >
                    <span>备注</span>
                </td>
                <td colspan="5">

                    <input name="remark" class="easyui-textbox" data-options="multiline:true"  style="width:600px;height:50px">

                </td>


            </tr>


        </table>
    </form>
</div>

<%--数据显示的--%>


<div id="potentialCustom_dialog" >
    <form id="potentialCustomForm" method="post" >
        <input type="hidden" name="id">
        <table align="center" style="margin-top: 15px">
          <tr>
                <td align="right" style="width: 100px">建档时间:</td>
                <td align="left" style="width: 100px">
                    <input name="inputTime" class= "easyui-datebox"  >
                </td>

                <td align="right" style="width: 100px">销售人员:</td>
                <td align="left" style="width: 100px">
                    <input id="marketingMan_id" name="marketingMan.id"   >
                </td>

                <td align="right" style="width: 100px">意向校区:</td>
                <td align="left" style="width: 100px">
                    <input id="intentionSchoolRegion_id" name="intentionSchoolRegion.id" >
                </td>

            </tr>

            <tr>
                <td align="right" style="width: 100px">下次跟进时间:</td>
                <td align="left" style="width: 100px">
                    <input name="nextFollowUpTime" class= "easyui-datebox" >
                </td>

                <td align="right" style="width: 100px">约访时间:</td>
                <td align="left" style="width: 100px">
                    <input name="vistitTime" class= "easyui-datebox"  >
                </td>

                <td align="right" style="width: 100px">来源:</td>
                <td align="left" style="width: 100px">
                    <input id="source_id" name="source.id"  >
                </td>

            </tr>

            <tr>
                <td align="right" style="width: 100px">姓名:</td>
                <td align="left" style="width: 100px">
                    <input name="name" class= "easyui-textbox" >
                </td>
                <td align="right" style="width: 100px">微信号:</td>
                <td align="left" style="width: 100px">
                    <input name="weChat" class= "easyui-textbox"  >
                </td>

                <td align="right" style="width: 100px">QQ:</td>
                <td align="left" style="width: 100px">
                    <input name="qq" class= "easyui-textbox"  >
                </td>

            </tr>

            <tr>
                <td align="right" style="width: 100px">电话:</td>
                <td align="left" style="width: 100px">
                    <input name="telephone"  class= "easyui-textbox" >
                </td>
                <td align="right" style="width: 100px">年龄:</td>
                <td align="left" style="width: 100px">
                    <input name="age"  class= "easyui-textbox" >
                </td>


                <td align="right" style="width: 100px">性别:</td>
                <td align="left" style="width: 100px">
                    <%--<input name="gender" class= "easyui-textbox" >--%>
                    <select class="easyui-combobox" name="gender" style="width:150px;">
                        <option>男</option>
                        <option>女</option>
                    </select>

                </td>
            </tr>

            <tr>
                <td align="right" style="width: 100px">Email:</td>
                <td align="left" style="width: 100px">
                    <input name="email"  class= "easyui-textbox" >
                </td>

                <td align="right" style="width: 100px">联系地址:</td>
                <td align="left" style="width: 100px">
                    <input name="address" class= "easyui-textbox" >
                </td>
                <td align="right" style="width: 100px">学校或培训机构:</td>
                <td align="left" style="width: 100px">
                    <input name="schoolOrTrainOrganization" class= "easyui-textbox" >
                </td>
            </tr>

            <tr>
                <%--等着大客户去维护--%>
                <td align="right" style="width: 100px">学校客户:</td>
                <td align="left" style="width: 100px">
                    <input name="schoolClient.id"  class= "easyui-combobox" data-options="valueField: 'id',
                     textField: 'school',url:'/bigClient/selectAll'" >
                </td>

                <td align="right" style="width: 100px">学历:</td>
                <td align="left" style="width: 100px">
                    <input id="education_id" name="education.id" >
                </td>

                <td align="right" style="width: 100px">专业:</td>
                <td align="left" style="width: 100px">
                    <input name="profession" class= "easyui-textbox" >
                </td>
            </tr>
            <tr>

                <td align="right" style="width: 100px">地域:</td>
                <td align="left" style="width: 100px">
                    <input id="region_id" name="region.id" >
                </td>

                <td align="right" style="width: 100px">工作年限:</td>
                <td align="left" style="width: 100px">
                    <input id="workYear_id" name="workYear.id"  >
                </td>

                <td align="right" style="width: 100px">介绍学员:</td>
                <td align="left" style="width: 100px">
                    <input name="introducer"  class= "easyui-textbox" >
                </td>
            </tr>
            <tr>

                <td align="right" style="width: 100px">意向学科:</td>
                <td align="left" style="width: 100px">
                    <input id="intentionSubject_id" name="intentionSubject.id" >
                </td>



                <td align="right" style="width: 100px">意向班级:</td>
                <td align="left" style="width: 100px">
                    <input  id="intentionClass_id" name="intentionClass.id" >
                </td>


                <td align="right" style="width: 100px">意向程度:</td>
                <td align="left" style="width: 100px">
                    <input id="intentionLevel_id" name="intentionLevel.id"  >
                </td>

            </tr>

            <tr>
                <%--/?????????--%>
                <td align="right" style="width: 100px">当前状态:</td>
                <td align="left" style="width: 100px">
                    <input id="currentState_id" name="currentState.id">
                </td>


                <td align="right" style="width: 100px">客户类型:</td>
                <td align="left" style="width: 100px">
                    <input id="clientType_id" name="clientType.id"  >
                </td>


                <td align="right" style="width: 100px">其他销售人员:</td>
                <td align="left" style="width: 100px">
                    <input name="otherMarketingMan.id" class= "easyui-combobox" data-options="valueField: 'id',
                     textField: 'username',url:'/employee/queryEmpByRoleSn?sn=SALEMAN'">
                </td>
            </tr>

            <tr>
                <td align="right" style="width: 100px">携带笔记本:</td>
                <td align="left" style="width: 100px">
                    <select name="bringComputer" class="easyui-combobox" style="width: 100px">
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                </td>

                <td align="right" style="width: 100px">大学入学时间:</td>
                <td align="left" style="width: 100px">
                    <input name="enrolTime" class= "easyui-datebox"  >
                </td>

                <td align="right" style="width: 100px">零付款:</td>
                <td style="text-align:left">

                        <input id="zeroPayNot" type="radio" name="zeroPay" value="0">否
                        <input id="zeroPayYes"  type="radio" name="zeroPay" value="1">是
                </td>

            </tr>

            <tr>
                <td >
                    <span>关注问题</span>
                </td>
                <td colspan="5">
                    <input name="careQuestion" class="easyui-textbox" data-options="multiline:true"  style="width:600px;height:50px">
                </td>
            </tr>
            <tr>
                <td >
                    <span>备注</span>
                </td>
                <td colspan="5">

                    <input name="remark" class="easyui-textbox" data-options="multiline:true"  style="width:600px;height:50px">

                </td>


            </tr>


        </table>
    </form>
</div>


<div id="potentialCustom_search_dialog" >
        <table align="center" style="margin-top: 15px">
          <tr>s

                <td align="right" style="width: 100px">意向校区:</td>
                <td align="left" style="width: 100px">
                    <input name="schoolType" class="easyui-combobox"
                           data-options="url:'/systemDictionaryItem/payList?sn=schoolType',
                                        valueField:'is',
                                        textField:'name',
                    "  >
                </td>

            </tr>

            <tr>

                <td align="right" style="width: 100px">意向程度:</td>
                <td align="left" style="width: 100px">
                    <input name="intentionGrade" class="easyui-combobox"
                           data-options="url:'/systemDictionaryItem/payList?sn=intentionGrade',
                                        valueField:'name',
                                        textField:'name'
                    "  >
                </td>
            </tr>


            <tr>

                <td align="right" style="width: 100px">工作年限:</td>
                <td align="left" style="width: 100px">
                    <input name="workTime" class= "easyui-textbox" >
                </td>


            </tr>


            <tr>
                <td align="right" style="width: 100px">当前状态:</td>
                <td align="left" style="width: 100px">
                    <input name="currentStatu" class="easyui-combobox"
                           data-options="url:'/systemDictionaryItem/payList?sn=currentStatu',
                                        valueField:'name',
                                        textField:'name'
                    "  >
                </td>

            </tr>

            <tr>

                <td align="right" style="width: 100px">入学时间:</td>
                <td align="left" style="width: 100px">
                    <input name="collegeBeginTimeMin" class= "easyui-datebox"  >
                </td>


            </tr>
            <tr>

                <td align="right" style="width: 100px">入学时间:</td>
                <td align="left" style="width: 100px">
                    <input name="collegeBeginTimeMax" class= "easyui-datebox"  >
                </td>


            </tr>

            <td align="right" style="width: 100px">意向学科:</td>
            <td align="left" style="width: 100px">
                <input name="intentionMajor" class= "easyui-combobox"
                       data-options="url:'/systemDictionaryItem/payList?sn=intentionMajor',
                                        valueField:'name',
                                        textField:'name'"
                >
            </td>


            <tr>
                <td align="right" style="width: 100px">学历:</td>
                <td align="left" style="width: 100px">
                    <input name="educationRecord" class="easyui-combobox"
                           data-options="url:'/systemDictionaryItem/payList?sn=educationRecord',
                                        valueField:'name',
                                        textField:'name'
                    "  >
                </td>
            </tr>

        </table>

</div>
<div id="potentialCustom_bnt">
    <div align="center">
        <a class="easyui-linkbutton" iconCls="icon-blueSave" plain="true" data-cmd="save">保存</a>
        <a class="easyui-linkbutton" iconCls="icon-reset" plain="true" data-cmd="reset">重置</a>
        <a class="easyui-linkbutton" iconCls="icon-cnaclebnt" plain="true" data-cmd="cancel">取消</a>
    </div>
</div>
<div id="potentialCustom_search_bnt">
    <div align="center">
        <a class="easyui-linkbutton" iconCls="icon-search" plain="true" data-cmd="submitSearch">提交查询</a>
        <a class="easyui-linkbutton" iconCls="icon-cnaclebnt" plain="true" data-cmd="cancel">取消</a>
    </div>




    <!-- =================================转正================================= -->
    <div id="bfmStu_dialog">
        <form id="bfmStu_dialog_form" method="post">
            <input type="hidden" name="id" id="bfmStu_dialog_form_id"/>
            <table align="center" style="margin-top: 20px">
                <tr>
                    <td>姓名:</td>
                    <td><input type="text" name="name" class="easyui-validatebox" data-options="required:true"/></td>
                    <td>QQ:</td>
                    <td><input type="text" name="qq"  class="easyui-textbox" /></td>
                    <td>入学时间:</td>
                    <td><input type="text" name="trainStartTime"  class="easyui-datebox"/></td>
                </tr>
                <tr>
                    <td>来源:</td>
                    <td><input type="text" name="source.id" class="easyui-combobox"
                               data-options="required:true,panelHeight:'auto',valueField:'id',textField:'name',url:'/systemDictionaryItem/payList?sn=src'" /></td>
                    <td>年龄:</td>
                    <td><input type="text"  name="age"  class="easyui-textbox"/></td>
                    <td>性别:</td>
                    <td><input type="text"  class="easyui-combobox" name="gender"
                               data-options="panelHeight:'auto',valueField:'id',textField:'name',data:[{id:'0',name:'男'},{id:'1',name:'女'},{id:'2',name:'其他'}]"/></td>
                </tr>
                <tr>
                    <td>电话:</td>
                    <td><input type="text" name="telephone" class="easyui-textbox"></td>
                    <td>现居住地址:</td>
                    <td><input type="text" name="currentHouseAddress" class="easyui-textbox"></td>
                    <td>Email:</td>
                    <td><input type="text" name="email" class="easyui-textbox"></td>
                </tr>
                <tr>
                    <td>学历:</td>
                    <td><input type="text" name="education.id"  class="easyui-combobox"
                               data-options="panelHeight:'auto',valueField:'id',textField:'name',url:'/systemDictionaryItem/payList?sn=educationRecord'"/></td>
                    <td>家庭住址:</td>
                    <td><input type="text" name="familyAddress"  class="easyui-textbox"/></td>
                    <td>学校:</td>
                    <td><input type="text" name="schoolOrTrainOrganization" class="easyui-textbox" /></td>
                </tr>
                <tr>
                    <td>专业:</td>
                    <td><input type="text" name="profession" class="easyui-textbox" /></td>
                    <td>户口所在地:</td>
                    <td><input type="text" name="registeredAddress" class="easyui-textbox" /></td>
                    <td>工作年限:</td>
                    <td><input type="text" name="workYear.id"  class="easyui-combobox"
                               data-options="panelHeight:'auto',valueField:'id',textField:'name',url:'/systemDictionaryItem/payList?sn=workYear'"/></td>
                </tr>
                <tr>
                    <td>外语水平:</td>
                    <td><input type="text" name="collegeEnglishTest.id" class="easyui-combobox"
                               data-options="panelHeight:'auto',valueField:'id',textField:'name',url:'/systemDictionaryItem/payList?sn=collegeEnglishTest'"/></td>
                    <td>其他水平:</td>
                    <td><input type="text" name="otherlevel" class="easyui-textbox" /></td>
                    <td>选择班级:</td>
                    <td>
                        <input type="text" name="currentClass.id" class="easyui-combobox"
                               data-options="panelHeight:'auto',valueField:'id',textField:'name',url:'classroom/payList'"/>
                        <a class="easyui-linkbutton" iconCls="icon-search" plain="true"></a>
                    </td>
                </tr>
                <tr>
                    <td>付款方式:</td>
                    <td><input type="text" name="payWay.id" class="easyui-combobox"
                               data-options="panelHeight:'auto',valueField:'id',textField:'name',url:'/systemDictionaryItem/payList?sn=payWay'"/></td>
                    <td>客户类型:</td>
                    <td><input type="text" name="clientType.id"  class="easyui-combobox"
                               data-options="panelHeight:'auto',valueField:'id',textField:'name',url:'/systemDictionaryItem/payList?sn=clientType'"/></td>
                    <td>携带笔记本:</td>
                    <td><input type="text" name="bringComputer" class="easyui-combobox"
                               data-options="panelHeight:'auto',valueField:'id',textField:'name',data:[{id:'1',name:'是'},{id:'0',name:'否'}]"/></td>
                </tr>

                <tr>
                    <td>计划学费:</td>
                    <td><input type="text" name="planTuition" class="easyui-textbox" /></td>
                    <td>优惠方式:</td>
                    <td><input type="text" name="discountWay.id"  class="easyui-combobox"
                               data-options="panelHeight:'auto',valueField:'id',textField:'name',url:'/systemDictionaryItem/payList?sn=discountWay'"/></td>
                    <td>优惠金额:</td>
                    <td><input type="text" name="discountAmount" class="easyui-textbox" /></td>
                </tr>
                <tr>
                    <td>培训学费:</td>
                    <td><input type="text" name="trainTuition" class="easyui-textbox" /></td>
                    <td>其他费用:</td>
                    <td><input type="text" name="otherTuition" class="easyui-textbox" /></td>
                    <td>其他优惠:</td>
                    <td><input type="text" name="otherDiscount" class="easyui-textbox" /></td>
                </tr>
                <tr>
                    <td>优惠说明:</td>
                    <td><input type="text" name="discountInstruction" class="easyui-textbox" /></td>
                    <td>总费用:</td>
                    <td><input type="text" name="totalTuition" class="easyui-textbox" /></td>
                    <td>销售流水:</td>
                    <td><input type="text" name="marketStream" class="easyui-textbox" /></td>
                </tr>
                <tr>
                    <td>已付学费:</td>
                    <td><input type="text" name="defraiedTuition"  class="easyui-textbox"/></td>
                    <td>还欠学费:</td>
                    <td><input type="text" name="dueTuition" class="easyui-textbox" /></td>
                    <td>最后付款时间:</td>
                    <td><input type="text" class="easyui-datebox" name="finalpPayTime" /></td>
                </tr>
                <tr>
                    <td>上次催款时间:</td>
                    <td><input type="text" class="easyui-datebox" name="previousUrgeTime" /></td>
                    <td>下次催款时间:</td>
                    <td><input type="text" class="easyui-datebox" name="nextUrgeTime" /></td>
                    <td>催款次数:</td>
                    <td><input type="text" name="UrgePayTimes"  class="easyui-textbox" /></td>
                </tr>
                <tr>
                    <td>完成付款:</td>
                    <td><input type="text" name="completePay" class="easyui-combobox"
                               data-options="panelHeight:'auto',valueField:'id',textField:'name',data:[{id:'1',name:'是'},{id:'0',name:'否'}]"/></td>
                </tr>

            </table>
        </form>
    </div>
    <div id="bfmStu_dialog_bt">
        <a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="saveFormalStudent">保存(K)</a>
        <a class="easyui-linkbutton" iconCls="icon-undo" plain="true" data-cmd="reset">重置(R)</a>
        <a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancel">取消(X)</a>
    </div>




    <!-- ===========================================考试登记=========================================== -->
    <div id="examRegister_dialog">
        <form id="examRegister_form" method="post">
            <input type="hidden" name="id" id="examRegister_id" />
            <table align="center" style="margin-top: 20px">
                <tr>
                    <td>潜在学员:</td>
                    <td><input type="text" disabled="disabled" name="name" /></td>
                </tr>
                <tr>
                    <td>意向校区:</td>
                    <td>
                        <input type="text" name="intentionSchoolRegion.id" class="easyui-combobox" disabled="disabled"
                               data-options="panelHeight:'auto',valueField:'id',textField:'name',url:'/systemDictionaryItem/payList?sn=schoolType'"/>
                    </td>
                </tr>
                <tr>
                    <td>意向班级:</td>
                    <td>
                        <input type="text" name="intentionClass.id" class="easyui-combobox" disabled="disabled"
                               data-options="panelHeight:'auto',valueField:'id',textField:'name',url:'/classroom/payList'"/>
                    </td>
                </tr>
                <tr>
                    <td>QQ:</td>
                    <td>
                        <input type="text" disabled="disabled" name="qq" />
                    </td>
                </tr>
                <tr>
                    <td>电话:</td>
                    <td>
                        <input type="text" disabled="disabled" name="telephone" />
                    </td>
                </tr>
                <tr>
                    <td>考试名称:</td>
                    <td><input type="text" name="examName" id="examName_id" /></td>
                </tr>
                <tr>
                    <td>考试编号:</td>
                    <td><input type="text" name="sn" /></td>
                </tr>
                <tr>
                    <td>考试时间:</td>
                    <td><input type="text" name="examtime" class="easyui-datebox"/></td>
                </tr>
                <tr>
                    <td>备注:</td>
                    <td><input type="text" name="examRemark" /></td>
                </tr>
            </table>
        </form>
    </div>
    <div id="examRegister_dialog_bt">
        <a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="saveExamRegister">保存</a>
        <a class="easyui-linkbutton" iconCls="icon-undo" plain="true" data-cmd="reset">重置</a>
        <a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancel">取消</a>
    </div>

<%--***************************************学员情况的跟踪******************************************--%>

    <div id="trackstudent_dialog">
        <form method="post" id="trackstudent_form" enctype="multipart/form-data">
            <input type="hidden" name="id" id="trackStudent_id" />
            <input type="hidden" name="fileAddress">
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
                    <td><input class="easyui-textbox" name="name"
                               data-options="valueField:'id',textField:'name',url:''"/></td>
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
                    <td><input class="easyui-datebox" name="visitTime"/></td>
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
        <a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="track_student_save">保存</a>
        <a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancel">取消</a>
    </div>


</div>
</body>
</html>
