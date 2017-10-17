//在线方式，每次keyup都会提交请求到web

var combo = $("#cmhc").acp({
    url:'<%=basePath%>combox/getVesselVoyage.action',
    per_page:1000,                  //每页条数
    per_page_str:'perPage',         //每页条数的参数名称（str）
    page:1,                         //初始页
    height:350,                     //下拉框高度
    page_str:'page',                //参数（文本框内容）
    param_str:'param',              //参数的名称（str）
    param:{},                       //其它参数
    autoLoad:true,                  //为true时，点击后直接显示第一页内容，否则keyup时显示
    display:function(item){         //下拉框显示的内容
        return item['vesseletrim'] + "/" + item['voyage'];
    },
    afterClick:function(item){      //显示下拉框后回填到文本框的内容
        return item['vesseletrim'] + "/" + item['voyage'] + "-" + item['vesselcode'];
    },
    delay:300,                      //击键间隔，单位毫秒，间隔内的keyup将被忽略，避免无意义的提交
    empty_notice:"条数为0时，下拉框显示的内容"
});	
    
//离线方式
var combo = $("#shipNamec").acp({
    data:data,                         //下拉列表的数据 
    height:350,                        //下拉框高度
    offline:true,                      //离线时必须添加
    filter_field:['label'],            //需要参加过滤的field  
    display:function(item){            //下拉框显示的内容 
        return item['label'];
    },
    afterClick:function(item){         //显示下拉框后回填到文本框的内容
        return item['value'];
    }
    empty_notice:"条数为0时，下拉框显示的内容"
});

function test(){
    alert(combo.getFieldValue("lable"));
}
