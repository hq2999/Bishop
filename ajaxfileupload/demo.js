$.ajaxFileUpload({
    url: '<%=basePath%>uploadFile', //用于文件上传的服务器端请求地址
    secureuri: false, //是否需要安全协议，一般设置为false
    fileElementId: 'file', //文件上传域的ID
    dataType: 'json', //返回值类型 一般设置为json
    success: function (data, status)  //服务器成功响应处理函数
    {
       console.info(data,status);
    },
    error: function (data, status, e)//服务器响应失败处理函数
    {
        alert(e);
    }
})