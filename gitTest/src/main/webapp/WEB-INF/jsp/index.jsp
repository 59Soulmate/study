<%--
  Created by IntelliJ IDEA.
  User: sd-kf
  Date: 2017/6/9
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/static/public/css/bootstrap.css">
    <script type="text/javascript" src="/static/public/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="/static/public/js/bootstrap.min.js"></script>
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
                                str += ">" + v.name + "</a>";
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
    </SCRIPT>
</head>
<body>
<div id="listDiv"></div>
</body>
</html>
