$.ajaxFileUpload({
    url: '<%=basePath%>uploadFile', //�����ļ��ϴ��ķ������������ַ
    secureuri: false, //�Ƿ���Ҫ��ȫЭ�飬һ������Ϊfalse
    fileElementId: 'file', //�ļ��ϴ����ID
    dataType: 'json', //����ֵ���� һ������Ϊjson
    success: function (data, status)  //�������ɹ���Ӧ������
    {
       console.info(data,status);
    },
    error: function (data, status, e)//��������Ӧʧ�ܴ�����
    {
        alert(e);
    }
})