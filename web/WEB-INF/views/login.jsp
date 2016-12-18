<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>

    <link rel="stylesheet" href="jquery-easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" href="jquery-easyui/themes/icon.css"/>
    <link rel="stylesheet" href="css/main.css"/>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="jquery-easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="js/main.js"></script>

    <script>


        function login(){
//            alert($("#logname").val());
            $.post("<%=path %>/admin/checking",
                {name:$("#logname").val(),pwd:$("#logpass").val()},
                function (data) {

//                    if (data.result == "success") {
//                        $("#addWin").window("close"); // 关闭指定的窗口
//                        $("#list").datagrid("reload"); // 重新加载指定数据网格数据
//                        $.messager.alert("提示", data.message, "info");
//                    } else if (data.result == "fail") {
//                        $.messager.alert("提示", data.message, "info");
//                    }
                }, "json"
            );
        }

    </script>
</head>

<body class="easyui-layout">


<div style="margin:20px 0;">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w').window('open')">登录</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w').window('close')">关闭</a>
</div>
-->
<div id="w" class="easyui-window" title="请先登录"
     data-options="modal:true,closed:true"style="width:400px;padding:20px 70px 20px 70px;">

    <div style="margin-bottom:10px">
        <input class="easyui-textbox" id="logname" style="width:100%;height:30px;padding:12px"
               data-options="prompt:'请输入用户名',iconCls:'icon-man',iconWidth:38">
    </div>
    <div style="margin-bottom:20px">
        <input class="easyui-textbox" id="logpass" type="password" style="width:100%;height:30px;padding:12px"
               data-options="prompt:'请输入密码',iconCls:'icon-lock',iconWidth:38">
    </div>
    <div style="margin-bottom:20px">
        <input class="easyui-textbox" type="text" id="logyzm" style="width:50%;height:30px;padding:12px"
               data-options="prompt:'请输入验证码'">
        <a href="javascript:;" class="showcode" onclick="changeVeryfy()">
        <img style=" margin:0 0 0 3px ; vertical-align:middle; height:26px;" src="/index.php?s=/Xjadmin/verifyCode">
        </a>
    </div>
    <div>
        <a href="javascript:;" onclick="login()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
           style="padding:5px 0px;width:50%;float: left;">
            <span style="font-size:14px;">登录</span>
        </a>
        <a href="javascript:;" onclick="dologin()" class="easyui-linkbutton" data-options="iconCls:'icon-help'"
           style="padding:5px 0px;width:50%;">
            <span style="font-size:14px;">忘记密码</span>
        </a>
    </div>


</div>

</body>

</html>