var varAddItemIndex = 1;
var eidtItemIndex = 1;


$(function(){
var baseTr = "<tr><td><input type='text' name='items[0].name' class='easyui-textbox' data-options='width:150' > </td><td><input type='text' name='items[0].intro' class='easyui-textbox' data-options='width:150'></td></tr><a class='easyui-linkbutton' data-options='iconCls:'icon-remove"+"',plain:true  data-cmd='delItem'></a>";
    //对页面中的元素进行抽取.
    //方法太凌乱,希望统一管理
    //按钮在JS统一进行监听
    var systemDictionaryDatagrid,delItemBtm,systemDictionaryItemDatagrid,systemDictionaryEditBtnAndQuitBtn,systemDictionaryDialog,systemDictionaryForm,systemDictionaryItemForm;
    systemDictionaryDatagrid = $("#systemDictionary_datagrid");
    systemDictionaryItemDatagrid = $("#systemDictionaryItem_datagrid");
    systemDictionaryEditBtnAndQuitBtn = $("#systemDictionary_editBtn,#systemDictionary_quitBtn");
    systemDictionaryDialog = $("#systemDictionary_dialog");
    systemDictionaryForm = $("#systemDictionary_form");
    systemDictionaryItemForm = $("#systemDictionaryItem_form");
    delItemBtm = $("#delItemBtm");
    //数据表格
    systemDictionaryDatagrid.datagrid({
        fit:true,
        rownumbers:true,
        singleSelect:true,
        url:'/systemDictionary/list',
        fitColumns:true,
        toolbar:'#systemDictionary_datagrid_tb',
        columns:[
            [
                {field:'sn',align:'center',width:10,title:'字典编号'},
                {field:'name',align:'center',width:10,title:'字典名称'},
                {field:'intro',align:'center',width:10,title:'字典简介'}

            ]
        ],
        /*给当前的行绑定点击的时候去查询数据字典的事件*/
        onClickRow:function (index,row) {
            /*给item 设置url 并且重新加载*/
            systemDictionaryItemDatagrid.datagrid("options").url = "systemDictionaryItem/queryBySystemDictionaryId?id="+row.id;
            systemDictionaryItemDatagrid.datagrid("reload");
        }

    });
    //item 中的数据表格
    systemDictionaryItemDatagrid.datagrid({
        fit:true,
        rownumbers:true,
        singleSelect:true,
        fitColumns:true,
        columns:[
            [
                {field:'name',align:'center',width:10,title:'字典名称'},
                {field:'intro',align:'center',width:10,title:'字典简介'}

            ]
        ]

    });
    //对话框
    systemDictionaryDialog.dialog({
        width:600,
        height:380,
        buttons:'#systemDictionary_dialog_bt',
        closed:true

    });

    delItemBtm.linkbutton({
        onClick:function () {
           // 找到上一个tr
            $(this).closest("tr").remove();
        }
    });










    //对按钮进行统一事件监听
    $("a[data-cmd]").on("click",function(){
        var cmd = $(this).data("cmd");
        if(cmd){
            cmdObj[cmd]();
        }
    });

    //方法统一管理起来]
    var cmdObj = {
        add:function(){
            /*设置item中的其实的id*/
            varAddItemIndex = 1;
            /*需要去掉表单中多于的行*/
            var findTr = systemDictionaryForm.find("tr");
            /*变量删除*/
            for(var i = 0 ; i < findTr.length ; i++){
                if (i >= 1) {
                    findTr[i].parentNode.removeChild(findTr[i])
                }
            }


            //1.清空表单数据
            systemDictionaryForm.form("clear");
            //2.设置对话框的标题
            systemDictionaryDialog.dialog("setTitle","新增");
            //3.打开对话框
            systemDictionaryDialog.dialog("open");
        },
        edit:function(){
            varAddItemIndex = eidtItemIndex;
            var rowData = systemDictionaryDatagrid.datagrid("getSelected");
            if(rowData){

                /*设置item中的其实的id*/
                varAddItemIndex = 1;
                /*需要去掉表单中多于的行*/
                var findTr = systemDictionaryForm.find("tr");
                /*变量删除*/
                for(var i = 0 ; i < findTr.length ; i++){
                    if (i >= 1) {
                        findTr[i].parentNode.removeChild(findTr[i])
                    }
                }





                //1.清空表单数据
                systemDictionaryForm.form("clear");
                //2.设置对话框的标题
                systemDictionaryDialog.dialog("setTitle","编辑");
                //3.打开对话框
                systemDictionaryDialog.dialog("open");

                //4.回显数据
                systemDictionaryForm.form("load",rowData);//基于同名匹配规则
                //回显item中的信息.
                //[1,3]----->List<Long>
            var btn = $("#delItemBtm").clone(true);
                $.post("/systemDictionaryItem/queryBySystemDictionaryId?id="+rowData.id,function(data){

                    /*增加tr和设置值*/
                    for(var i = 0 ; i < data.rows.length ; i ++){

                        if (i == 0) {
                            /*直接设置值*/
                            $("[name='items[0].name']").prop("value",data.rows[0].name);
                            $("[name='items[0].intro']").prop("value",data.rows[0].intro);
                        }else {
                            // 克隆当前的tr
                            var tr = $(baseTr).clone(true);
                            tr.find("[name='items[0].intro']").after($(btn));
                            // 设置值

                            tr.find("[name='items[0].name']").val(data.rows[i].name);
                            tr.find("[name='items[0].intro']").val(data.rows[i].intro);
                            /*设置tr的name*/
                            // tr.find("[name='items[0].name']").prop("name","items["+varAddItemIndex+"].name");
                            // tr.find("[name='items[0].intro']").prop("name","items["+varAddItemIndex+"].intro");

                            $(tr).appendTo("#systemDictionaryItem_table");

                            /*序号需要在加上1*/
                            eidtItemIndex = varAddItemIndex ++;


                        }

                    }



                }),"json";

            }else{
                $.messager.alert("温馨提示","请选择一条需要修改的数据.","warning");
            }

        },
        del:function(){
            var rowData = systemDictionaryDatagrid.datagrid("getSelected");
            if(rowData){
                $.messager.confirm("温馨提示","您确定需要删除该字典吗?",function(yes){
                    if(yes){
                        $.get("/systemDictionary/delete?id="+rowData.id,function(data){
                            if(data.success){
                                systemDictionaryDatagrid.datagrid("reload");
                                $.messager.alert("温馨提示",data.msg,"info");
                            }else{
                                $.messager.alert("温馨提示",data.msg,"error");
                            }
                        },"json")
                    }
                });
            }else{
                $.messager.alert("温馨提示","请选择需要删除的字典记录.","warning");
            }
        },
        reload:function(){
            //刷新数据表格
            systemDictionaryDatagrid.datagrid("reload");
        },
        save:function(){
            var url;
            var idVal = $("[name='id']").val();
            if(idVal){
                url = "/systemDictionary/update";
            }else{
                url = "/systemDictionary/save";
            }
            /*设置当中的table中的input的值*/
            var saveTr = $("#systemDictionaryItem_table").find("tr");

            for(var i = 0 ;  i < saveTr.length; i ++){
                $(saveTr[i]).find("[name='items[0].name']").prop("name","items["+i+"].name");
                $(saveTr[i]).find("[name='items[0].intro']").prop("name","items["+i+"].intro");
            }


            systemDictionaryForm.form("submit",{
                url:url,
                onSubmit:function(param){

                },
                success:function(data){
                    data = $.parseJSON(data);
                    if(data.success){
                        //提示消息,当点确定的时候,关闭对话框,刷新数据表格
                        $.messager.alert("温馨提示",data.msg,"info",function(){
                            systemDictionaryDialog.dialog("close");
                            systemDictionaryDatagrid.datagrid("reload");
                            systemDictionaryItemDatagrid.datagrid("reload");
                        });
                    }else{
                        $.messager.alert("温馨提示",data.msg,"error");
                    }
                }
            });
        },
        cancel:function(){
            systemDictionaryDialog.dialog("close");
        },
        addItem:function () {
            // 克隆当前的tr
            var tr = $(baseTr).clone(true);
            var btn = $("#delItemBtm").clone(true);
            /*设置tr的name*/
            // tr.find("[name='items[0].name']").prop("name","items["+varAddItemIndex+"].name");
            // tr.find("[name='items[0].intro']").prop("name","items["+varAddItemIndex+"].intro");
            //在后面克隆按钮
            $(tr).appendTo("#systemDictionaryItem_table");
            $(btn).insertAfter($(tr).find("[name='items[0].intro']"));

            /*序号需要在加上1*/
            varAddItemIndex ++;
        },
        delItem:function () {
            console.log(this);
        }
    }
});


function delInput() {
    delItemBtm.linkbutton()
}