<%--
  Created by IntelliJ IDEA.
  User: sd-kf
  Date: 2017/6/9
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="/static/public/js/jquery-1.10.2.min.js"></script>

    <link href="/plugs/Bootstrap/css/bootstrap-table.min.css" rel="stylesheet"/>
    <script src="/plugs/Bootstrap/js/bootstrap-table.min.js"></script>

    <script src="/plugs/Bootstrap/js/bootstrap-table-zh-CN.min.js"></script>

    <script src="/plugs/Bootstrap/js/bootstrap.js"></script>
    <link href="/plugs/Bootstrap/css/bootstrap.css" rel="stylesheet"/>
    <link href="/static/bootstrap/bootstrap.css" rel="stylesheet"/>
    <%--导出--%>
    <script src="/plugs/Bootstrap/js/bootstrap-table-export.js"></script>
    <script src="/plugs/Bootstrap/js/tableExport.js"></script>


    <SCRIPT type="text/javascript">
        var i = 0;
        var array = [];
        if (i == 0) {
            $.ajax({
                type: "post",
                url: "/front/loadTree.action",
                data: {id: 0},
                dataType: "json",
                success: function (data) {
                    i++;
                    $(data).each(function (k, v) {
                        var str = "<a href='#' class='list-group-item' ";
                        if (v.isParent) {
                            str += "data-toggle='collapse' data-target='#demo" + v.id + "' onclick='loadTree(\"demo" + v.id + "\"," + v.id + ")'>" + v.name + "</a>";
                        }
                        $('#listDiv').append(str);
                    })
                }
            });
        }
        function loadTree(name, fid, obj) {
            if (array.indexOf(fid) < 0) {
                array.push(fid);
                $.ajax({
                    type: "post",
                    url: "/front/loadTree.action",
                    data: {id: fid},
                    dataType: "json",
                    success: function (data) {
                        i++;
                        var str = "<div id=" + name + " class='collapse in' style='margin-bottom: -1px'>";
                        $(data).each(function (k, v) {
                            str += "<a href='#' class='list-group-item'";
                            if (v.isParent) {
                                str += "data-toggle='collapse' data-target='#demo" + v.id + "' onclick='loadTree(\"demo" + v.id + "\"," + v.id + " ,this)'>" + v.name + "</a>";
                            } else {
                                str += " onclick='menuClick()'>" + v.name + "</a>";
                            }
                        });
                        str += "</div>";
                        if (obj != null) {
                            $(obj).after(str);
                        } else {
                            $("#listDiv").append(str);
                        }
                    }
                });
            }
        }
        function menuClick() {
            console.log("123");
        }

        $(function () {
            $("#table").bootstrapTable({
                url: "/user/findUser.action",
                dataType: "json",
                method: "post",   //请求方式（*）
                toolbar: "#toolbar",  //工具按钮用哪个容器
                toolbarAlign: "left",				//工具栏对齐方式
                search: true,    //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
                showColumns: true,                  //是否显示所有的列
                showRefresh: true,//是否显示刷新按钮
                striped: true,   //是否显示行间隔色
                cache: false,   //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination: true,   //是否显示分页（*）
                sortable: false,   //是否启用排序
                sortOrder: "asc",   //排序方式
                sidePagination: "server",  //分页方式：client客户端分页，server服务端分页（*）
                pageNumber: 1,   //初始化加载第一页，默认第一页
                pageSize: 3,   //每页的记录行数（*）
                pageList: [3, 25, 50, 100], //可供选择的每页的行数（*）
                contentType: "application/x-www-form-urlencoded",
                strictSearch: true,
                showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
                minimumCountColumns: 1,             //最少允许的列数
                clickToSelect: true,  //是否启用点击选中行
                height: 460,   //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                uniqueId: "user_id",   //每一行的唯一标识，一般为主键列
                cardView: false,   //是否显示详细视图
                detailView: true,   //是否显示父子表
                showExport: true,    //导出
                exportDataType: "basic",  //导出格式basic  all  selected
                columns: [{
                    checkbox: true
                }, {
                    field: "user_id",
                    title: "Item ID"
                }, {
                    field: "user_name",
                    title: "用户名"
                }, {
                    field: "user_pass",
                    title: "密码"
                },]
            });
        })
    </SCRIPT>
</head>
<body>
<div id="listDiv"></div>
<div id="toolbar" class="btn-group">
    <button id="btn_add" type="button" class="btn btn-default"
            onclick="Add()">
        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
    </button>
    <button id="btn_edit" type="button" class="btn btn-default"
            onclick="Edit()">
        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
    </button>
    <button id="btn_delete" type="button" class="btn btn-default"
            onclick="onDeleteClick()">
        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
    </button>
</div>
<table id="table" class="table table-bordered table table-striped"></table>
</body>
</html>
