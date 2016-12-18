<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
%>

<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="<%=path%>/jquery-easyui/themes/default/easyui.css" />
	<link rel="stylesheet" href="<%=path%>/jquery-easyui/themes/icon.css" />
	<link rel="stylesheet" href="<%=path%>/css/main.css" />
	<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path%>/jquery-easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path%>/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path%>/js/json2.js"></script>
	<script type="text/javascript" src="<%=path%>/js/main.js"></script>

	<script>

        var jsonStr = '{"merchant.id":"_id","merchant.user":"_user",' +
			'"merchant.name":"_name","merchant.password":"_password","merchant.gender":"_gender",' +
			'"merchant.create_time":"_create_time", "merchant.status":"_status", ' +
			'"merchant.grade":"_grade","merchant.superior_id":"_superior_id","merchant.identity_card":"_identity_card",' +
			'"merchant.bank_card":"_bank_card", "merchant.bank_type":"_bank_type", ' +
			'"merchant.we_char":"_we_char", "merchant.family_address":"_family_address", "merchant.phone":"_phone"}';

        $(function() {
            setPagination("list");
        });

        function showAddProductWin() {
            $("#addForm").form("clear"); // 清除表单里的所有数据
            $("#addWin").window("open"); // 打开指定的window， open表示打开，close表示关闭
        }

        function addProduct() {
            if ($("#addForm").form("validate")) {
                $.post("<%=path %>/merchant/add",
                    $("#addForm").serialize(),
                    function (data) {
                        if (data.result.result == "success") {
                            $("#addWin").window("close"); // 关闭指定的窗口
                            $("#list").datagrid("reload"); // 重新加载指定数据网格数据
                            $.messager.alert("提示", data.result.message, "info");
                        } else if (data.result.result == "fail") {
                            $.messager.alert("提示", data.result.message, "info");
                        }
                    }, "json"
                );
            } else {
                $.messager.alert("提示", "请输入正确的数据", "info");
            }
        }

        function showEditProductWin() {
            // var row = $("#list").datagrid("getSelected"); // 获取数据表格中被选中的行数据
            var rows = $("#list").datagrid("getSelections");
            if (rows.length > 1) {
                $.messager.alert("提示", "请先选择一个需要修改的店长", "info");
            } else if (rows.length == 1) {
                var row = rows[0];
                if (row) { // 有选中的行
                    var jsonStr1 = jsonStr.replace("_id", row.id).replace("_user", row.user).
					replace("_name", row.name).replace("_password", row.password).
					replace("_role", row.role).replace("_status", row.status).
					replace("_gender", row.gender).replace("_grade", row.grade).
					replace("_superior_id", row.superior_id).replace("_identity_card", row.identity_card).
					replace("_bank_card", row.bank_card).replace("_bank_type", row.bank_type).replace("_we_char", row.we_char).
					replace("_family_address", row.family_address).replace("_phone", row.phone);
                    $("#editForm").form("load", JSON.parse(jsonStr1));
                    $("#editWin").window("open");
                }
            } else if (rows.length == 0) {
                $.messager.alert("提示", "请先选择一个需要修改的商品", "info");
            }
        }

        function editProduct() {
            if ($("#editForm").form("validate")) {
                $.post("<%=path %>/merchant/update",
                    $("#editForm").serialize(),
                    function (data) {
                        if (data.result.result == "success") {
                            $("#editWin").window("close"); // 关闭指定的窗口
                            $("#list").datagrid("reload"); // 重新加载指定数据网格数据
                            $.messager.alert("提示", data.result.message, "info");
                        } else if (data.result.result == "fail") {
                            $.messager.alert("提示", data.result.message, "info");
                        }
                    }, "json"
                );
            } else {
                $.messager.alert("提示", "请输入正确的表单数据", "info");
            }
        }

        function removeProduct() {
            var row = $("#list").datagrid("getSelected");
            if (row) {
                $.messager.confirm("提示", "确定删除吗？", function (r) {
                    if (r) { // 点击了确定按键
                        $.get("<%=path %>/product/del?id=" + row.id, function (data) {
                            $("#list").datagrid("reload");
                        }, "json");
                    }
                })
            } else {
                $.messager.alert("提示", "请先选择需要删除的商品", "info");
            }
        }

        function showDlg() {
            $("#dlg").dialog("open"); // 打开对话框   close关闭对话框
        }

        function formatterOpt(value, row, index) {
            if (row.status == 'Y') {
                return "<b>已启用</b>"
			} else if(row.status == 'N') {
                return "<b>已禁用</b>"
			}
        }

        function formatterOpt1(value, row, index) {
       		if (row.role == 'super') {
                return "<b>超级管理员</b>"
            } else if (row.role == 'normal') {
                return "<b>管理员</b>"
            }

        }

        function formatterOpt2(value, row, index) {
            if (row.bank_type == 'one') {
                return "<b>中国银行</b>"
            } else if (row.bank_type == 'two') {
                return "<b>中国建设银行</b>"
            }else if (row.bank_type == 'three') {
                return "<b>邮政银行</b>"
            }else if (row.bank_type == 'four') {
                return "<b>农业银行</b>"
            }else if (row.bank_type == 'five') {
                return "<b>农商银行</b>"
            }

        }

        function formatterOpt3(value, row, index) {
            if (row.grade == 'one') {
                return "<b>一万</b>"
            } else if (row.grade == 'two') {
                return "<b>二万</b>"
            }else if (row.grade == 'three') {
                return "<b>三万</b>"
            }else if (row.grade == 'four') {
                return "<b>四万</b>"
            }else if (row.grade == 'five') {
                return "<b>五万</b>"
            }

        }

        function formatterOpt4(value, row, index) {
            if (row.gender == 'woman') {
                return "<b>女</b>"
            } else if (row.gender == 'boy') {
                return "<b>男</b>"
            }
        }


	</script>

</head>
<body style="height:100%;">

<table id="list" class="easyui-datagrid"
	   data-options="toolbar:'#tb',
			singleSelect:false,
			collapsible:true,
			url:'<%=path %>/merchant/queryAll',
			method:'get',
			rownumbers:true,
			autoRowHeight:true,
			pagination:true,
			pageSize:20" style="height:100%;">
	<thead>
	<tr>
		<th data-options="field:'id',checkbox:true">编号</th>
		<th data-options="field:'user',width:100">用户名</th>
		<th data-options="field:'name',width:50">姓名</th>
		<th data-options="field:'bb',width:30" formatter="formatterOpt4">性别</th>
		<th data-options="field:'ll',width:40" formatter="formatterOpt3">等级</th>
		<th data-options="field:'identity_card',width:120">身份证号码</th>
		<th data-options="field:'bank_card',width:120">银行卡号码</th>
		<th data-options="field:'oo',width:70" formatter="formatterOpt2">银行卡类型</th>
		<th data-options="field:'we_char',width:90">微信</th>
		<th data-options="field:'family_address',width:120">家庭地址</th>
		<th data-options="field:'phone',width:80">手机号码</th>
		<th data-options="field:'create_time',width:120">创建时间</th>
		<th data-options="field:'last_login_time',width:120">最后一次登录时间</th>
		<th data-options="field:'aaa',width:60" formatter="formatterOpt">状态</th>
	</tr>
	</thead>
</table>

<div id="tb" style="padding:5px;height:auto">
	<div style="margin-bottom:5px">
		<a href="javascript:;" onclick="showAddProductWin();" class="easyui-linkbutton" iconCls="icon-add">添加</a>
		<a href="javascript:;" onclick="showEditProductWin();" class="easyui-linkbutton" iconCls="icon-edit">编辑</a>
	</div>
</div>

<div id="addWin" class="easyui-window" title="添加店长" data-options="closed:true" style="width:500px;height:300px;">
	<form id="addForm">
		<table>
			<tr>
				<td>用户名</td>
				<td><input class="easyui-validatebox easyui-textbox" name="merchant.user" data-options="required:true,validType:'length[2,20]'"/></td>
			</tr>
			<tr>
				<td>名字</td>
				<td><input class="easyui-validatebox easyui-textbox" name="merchant.name" data-options="required:true,validType:'length[2,20]'"/></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input class="easyui-validatebox easyui-textbox" name="merchant.password" data-options="required:true,validType:'length[2,20]'"/></td>
			</tr>
			<tr>
				<td>性别</td>
				<td>
					<select style="width:100px;" class="easyui-combobox" name="merchant.gender"><option value="boy">男</option><option value="woman">女</option></select>
				</td>
			</tr>
			<tr>
				<td>等级</td>
				<td>
					<select style="width:100px;" class="easyui-combobox" name="merchant.grade"><option value="one">一万</option><option value="two">二万</option><option value="three">三万</option><option value="four">四万</option><option value="five">五万</option></select>
				</td>
			</tr>
			<tr>
				<td>身份证号码</td>
				<td><input class="easyui-validatebox easyui-textbox" name="merchant.identity_card" data-options="required:true,validType:'length[2,20]'"/></td>
			</tr>
			<tr>
				<td>银行卡号码</td>
				<td><input class="easyui-validatebox easyui-textbox" name="merchant.bank_card" data-options="required:true,validType:'length[2,20]'"/></td>
			</tr>
			<tr>
				<td>银行卡类型</td>
				<td>
					<select style="width:100px;" class="easyui-combobox" name="merchant.bank_type"><option value="one">中国银行</option><option value="two">中国建设银行</option><option value="three">邮政银行</option><option value="four">农业银行</option><option value="five">农商银行</option></select>
				</td>
			</tr>
			<tr>
				<td>微信号</td>
				<td><input class="easyui-validatebox easyui-textbox" name="merchant.we_char" data-options="required:true,validType:'length[2,20]'"/></td>
			</tr>
			<tr>
				<td>家庭住址</td>
				<td><input class="easyui-validatebox easyui-textbox" name="merchant.family_address" data-options="required:true,validType:'length[2,20]'"/></td>
			</tr>
			<tr>
				<td>手机号</td>
				<td><input class="easyui-validatebox easyui-textbox" name="merchant.phone" data-options="required:true,validType:'length[2,20]'"/></td>
			</tr>
			<tr>
				<td>
					<a href="javascript:;" onclick="addProduct();" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确认</a>
				</td>
			</tr>
		</table>
	</form>
</div>

<div id="editWin" class="easyui-window" title="修改店长" data-options="closed:true" style="width:500px;height:300px;">
	<form id="editForm">
		<input type="hidden" name="merchant.id" />
		<table>
			<tr>
				<td>用户名</td>
				<td><input class="easyui-validatebox easyui-textbox" name="merchant.user" data-options="required:true,validType:'length[2,20]'"/></td>
			</tr>
			<tr>
				<td>名字</td>
				<td><input class="easyui-validatebox easyui-textbox" name="merchant.name" data-options="required:true,validType:'length[2,20]'"/></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input class="easyui-validatebox easyui-textbox" name="merchant.password" data-options="required:true,validType:'length[2,20]'"/></td>
			</tr>
			<tr>
				<td>性别</td>
				<td>
					<select style="width:100px;" class="easyui-combobox" name="merchant.gender"><option value="boy">男</option><option value="woman">女</option></select>
				</td>
			</tr>
			<tr>
				<td>等级</td>
				<td>
					<select style="width:100px;" class="easyui-combobox" name="merchant.grade"><option value="one">一万</option><option value="two">二万</option><option value="three">三万</option><option value="four">四万</option><option value="five">五万</option></select>
				</td>
			</tr>
			<tr>
				<td>身份证号码</td>
				<td><input class="easyui-validatebox easyui-textbox" name="merchant.identity_card" data-options="required:true"/></td>
			</tr>
			<tr>
				<td>银行卡号码</td>
				<td><input class="easyui-validatebox easyui-textbox" name="merchant.bank_card" data-options="required:true"/></td>
			</tr>
			<tr>
				<td>银行卡类型</td>
				<td>
					<select style="width:100px;" class="easyui-combobox" name="merchant.bank_type"><option value="one">中国银行</option><option value="two">中国建设银行</option><option value="three">邮政银行</option><option value="four">农业银行</option><option value="five">农商银行</option></select>
				</td>
			</tr>
			<tr>
				<td>微信号</td>
				<td><input class="easyui-validatebox easyui-textbox" name="merchant.we_char" data-options="required:true,validType:'length[2,20]'"/></td>
			</tr>
			<tr>
				<td>家庭住址</td>
				<td><input class="easyui-validatebox easyui-textbox" name="merchant.family_address" data-options="required:true,validType:'length[2,20]'"/></td>
			</tr>
			<tr>
				<td>手机号</td>
				<td><input class="easyui-validatebox easyui-textbox" name="merchant.phone" data-options="required:true,validType:'length[2,20]'"/></td>
			</tr>
			<tr>
				<td>状态</td>
				<td>
					<select style="width: 100px;" class="easyui-combobox" name="merchant.status"><option value="Y">启用</option><option value="N">禁用</option></select>
					<%--<input class="easyui-validatebox easyui-textbox" name="sAdmin.status" data-options="required:true"/>--%>
				</td>
			</tr>
			<tr>
				<td>
					<a href="javascript:;" onclick="editProduct();" style="width: 60px;" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确认</a>
				</td>
			</tr>
		</table>
	</form>
</div>

<div id="dlg" class="easyui-dialog" title="超级电商" data-options="closed:true" style="width:400px;height:200px;padding:10px">
	这是一个对话框
</div>

</body>
</html>