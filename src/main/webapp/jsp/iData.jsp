<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!-- JSTL 函数 包含一系列标准函数，大部分是通用的字符串处理函数-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- JSTL 核心标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- JSTL 格式化标签 用来格式化并输出文本、日期、时间、数字 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- JSTL SQL标签库 提供了与关系型数据库进行交互的标签 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!-- JSTL XML标签库 提供了创建和操作XML文档的标签 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="/static/layui/css/layui.css" media="all">
    <script type="text/javascript" src="/static/layui/layui.js"></script>
    <script  src="/static/jquery-3.5.1/jquery-3.5.1.min.js"></script>
    <style>

    </style>
</head>
<body>
<div>
    <button type="button" class="layui-btn" id="test1">
        <i class="layui-icon">&#xe67c;</i>上传图片
    </button>
    <input id="t1" value="jsp"/>
</div>
</body>

<script>

    $(function(){
        // alert($("#t1").val());
        }
    );
    layui.use('upload', function () {
        var upload = layui.upload;

        //执行实例
        var uploadInst = upload.render({
            elem: '#test1' //绑定元素
            , url: '/data/uploadPic' //上传接口
            , done: function (res) {
                //上传完毕回调
                alert(res.code);
            }
            , error: function () {
                //请求异常回调
                alert("error");
            }
        });
    });
</script>
</html>