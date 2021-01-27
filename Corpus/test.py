# coding:utf-8
from pyquery import PyQuery as pq
import json
import re

html = """
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>查卡布科港_港口代码CLCHA_CHACABUCO</title>
<meta name="keywords" content="查卡布科港,港口代码CLCHA,CHACABUCO" />
<meta name="description" content="这是查询助手查卡布科港CHACABUCO详细介绍页面，包括查卡布科港CHACABUCO所属国家、所在城市、港口代码、航线以及查卡布科港CHACABUCO在地图上位置等信息。" />
<link rel="stylesheet" type="text/css" href="css/2018.css" />
<script src='http://maps.google.cn/maps/api/js?key=AIzaSyDFOpvh_08t8svORGbvINwXCPmpTzCnCrw' type="text/javascript"></script>
</head>
<body> 
<div class=ttt><span class=gda><a href="http://www.00cha.net/">查询助手</a> &gt; <a href="http://gangkou.00cha.net/">世界港口查询</a></span>
<span class=gdb><h1>查卡布科港,CHACABUCO</h1></span>
</div>
<div id="bigdiv">
<div class="bei2 lh">
<div style="background:#F5FEFB;text-align:left;padding:8px;border:1px solid #C8E8D7;font-size:14px;margin-bottom:10px;">
这是查询助手查卡布科港CHACABUCO详细介绍页面，包括查卡布科港CHACABUCO所属国家、所在城市、港口代码、航线以及查卡布科港CHACABUCO在地图上位置等信息。
</div>
</div>
<div class="h10"></div>
<div class="f28 center"><b>查卡布科港&nbsp;CHACABUCO</b></div>
<div class="nra">
<form action="http://gangkou.00cha.net" method="post">
<input name="txtname" type="text" style="padding:5px;width:600px;height:27" size="17" onfocus="this.value= '';" value="智利">&nbsp;<input type="submit" value=" 查 询 " style="height:32px;"><br>
</form>
</div>

<div class="clear"></div>
<div class="bei lh">
<table class="tablea">
	<tr>
		<td width="20%" bgcolor="#F2F2F2"><b>港口代码</b></td>
		<td width="30%">CLCHA　</td>
		<td bgcolor="#F2F2F2" width="20%"><b>城市</b></td>
		<td>CHACABUCO&nbsp;查卡布科　</td>
	</tr>
	<tr>
		<td width="20%" bgcolor="#F2F2F2"><b>港口中文</b></td>
		<td width="30%">查卡布科　</td>
		<td bgcolor="#F2F2F2" width="20%"><b>港口英文</b></td>
		<td>CHACABUCO　</td>
	</tr>
	<tr>
		<td width="20%" bgcolor="#F2F2F2"><b>国家</b></td>
		<td width="30%">智利&nbsp;Chile　</td>
		<td bgcolor="#F2F2F2" width="20%"><b>地区</b></td>
		<td>拉丁美洲　</td>
	</tr>
	<tr>
		<td width="20%" bgcolor="#F2F2F2"><b>航线中文</b></td>
		<td width="30%">中南美　</td>
		<td bgcolor="#F2F2F2" width="20%"><b>航线英文</b></td>
		<td>CENTRAL AND SOUTH AMERICA SERVICE　</td>
	</tr>
	<tr>
		<td width="20%" bgcolor="#F2F2F2"><b>锚地：</b></td>
		<td width="30%">　</td>
		<td bgcolor="#F2F2F2" width="20%"><b>类型：</b></td>
		<td>港口城市　</td>
	</tr>	
	</table>
</div>

<div class="bei"><b>查卡布科港地图位置</b>
<script>
var myCenter=new google.maps.LatLng(-45.4663563,-72.82174685);

function initialize()
{
var mapProp = {
  center:myCenter,
  zoom:8,
  mapTypeId:google.maps.MapTypeId.ROADMAP
  };

var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);

var marker=new google.maps.Marker({
  position:myCenter,
  });

marker.setMap(map);
}

google.maps.event.addDomListener(window, 'load', initialize);
</script>
<div id="googleMap" style="width:100%;height:380px;"></div>
</div>

<div class="bei lh">
<b>查卡布科港口介绍</b>

</div>

<div class="bei lh"><strong>港口查询(按航线)</strong>
<p class="more120">
<a href="hx_central_and_south_america_service.html">中南美线</a><a href="hx_middle_east_line.html">中东印巴线</a><a href="hx_the_far_east.html">远东线</a><a href="hx_japan_korea_lines.html">日韩线</a><a href="hx_european_ground.html">欧地黑线</a><a href="hx_america_canada_line.html">美加线</a><a href="hx_red_sea_line.html">红海线</a><a href="hx_africa_lines.html">非洲线</a><a href="hx_south_east_asia_line.html">东南亚线</a><a href="hx_mediterranean_lines.html">地中海线</a><a href="hx_atlantic.html">大西洋线</a><a href="hx_australia_lines.html">澳新线</a><a href="hx_other.html">其他</a>
<div class="clear"></div>
</p>
</div>

<div class="bei lh"><strong>热门港口地区</strong>
<p class="more120">
<a href="dq_central_america.html">中美洲</a><a href="dq_china_mainland.html">中国大陆</a><a href="dq_middle_east.html">中东</a><a href="dq_russian_far_east.html">远东</a><a href="dq_indonesia__philippines.html">印尼/菲律宾</a><a href="dq_india_pakistan.html">印巴</a><a href="dq_singapore__malaysia__vietnam__thailand.html">新马越泰</a><a href="dq_hong_kong.html">香港</a><a href="dq_hawaii.html">夏威夷</a><a href="dq_west_pacific.html">西太平洋</a><a href="dq_west_africa.html">西非</a><a href="dq_taiwan.html">台湾</a><a href="dq_japanese_branch_port.html">日本偏港</a><a href="dq_japanese_main_port.html">日本基本港</a><a href="dq_european_branch_port.html">欧洲偏港</a><a href="dq_european_main_port.html">欧基港</a><a href="dq_south_pacific.html">南太平洋</a><a href="dq_south_america_west.html">南美西</a><a href="dq_south_america_east.html">南美东</a><a href="dq_western_america.html">美西</a><a href="dq_american_inland_port.html">美国内陆点</a><a href="dq_eastern_america.html">美东</a><a href="dq_the_red_sea.html">红海</a><a href="dq_the_black_sea.html">黑海</a><a href="dq_east_africa.html">东非</a><a href="dq_western_mediterranean.html">地西</a><a href="dq_eastern_mediterranean.html">地东</a><a href="dq_north_africa.html">北非</a>
<div class="clear"></div>
</p>
</div>

<div class="fgd">
	</div>
	<div class="bei">
		<div class="more120">
			<a target="_blank" href="http://quhao.00cha.net/">区号查询</a>
			<a target="_blank" href="http://huaiyun.00cha.net/">怀孕日历表</a>
			<a target="_blank" href="http://moersima.00cha.net/">摩尔斯电码</a>
			<a target="_blank" href="http://waihuipaijia.00cha.net/">外汇牌价</a>
			<a target="_blank" href="http://pailuanqi.00cha.net/">排卵期计算器</a>
			<a target="_blank" href="http://gangkou.00cha.net/">全球港口查询</a>
			<a target="_blank" href="http://szdm.00cha.net/">三字代码</a>
			<a target="_blank" href="http://daxie.00cha.net/">大写数字转换</a>
			<a target="_blank" href="http://chengyujielong.00cha.net/">成语接龙查询</a>
			<a target="_blank" href="http://hscode.00cha.net/">hs编码查询</a>
			<a target="_blank" href="http://time.00cha.net/">现在北京时间</a>
			<a target="_blank" href="http://zishu.00cha.net/">在线字数统计</a>
			<a target="_blank" href="http://pinyin.00cha.net/">汉字转换拼音</a>
			<a target="_blank" href="http://qianming.00cha.net/">连笔签名设计</a>
			<a target="_blank" href="http://chepai.00cha.net/">车牌号查询</a>
			<a target="_blank" href="http://jiaotong.00cha.net/">交通安全标志</a>
			<a target="_blank" href="http://fuli.00cha.net/">复利计算器</a>
			<a target="_blank" href="http://tizhong.00cha.net/">身高体重标准</a>
			<a target="_blank" href="http://nianling.00cha.net/">年龄计算器</a>
			<a target="_blank" href="http://rili.00cha.net/">万年历查询</a>
			<a target="_blank" href="http://gougou.00cha.net/">狗的品种</a>
<a target=_blank href="http://jishi.00cha.net/">计时工具</a>
<a target=_blank href="http://luomashuzi.00cha.net/">罗马数字</a>
<a target=_blank href="http://huilv.00cha.net/">货币汇率换算</a>
<a target=_blank href="http://2v.00cha.net/">二维码生成器</a>
<a target=_blank href="http://huayu.00cha.net/">花语大全</a>
<a target=_blank href="http://suijishu.00cha.net/">随机数</a>
<a target=_blank href="http://kousuanti.00cha.net/">口算题</a>
<a target=_blank href="http://fuhao.00cha.net/">特殊符号</a>
<a target=_blank href="http://jsq.00cha.net/">计算器</a>
			<div class="clear">
			</div>
		</div>
	</div>


<div class=bq>&copy; 2018 00cha.net 查询助手 &#9642; 世界港口  <script type="text/javascript" src="https://s4.cnzz.com/z_stat.php?id=1279121674&web_id=1279121674"></script>
</div>

</div>
</body>

</html>
"""
tb = pq(html).find('.tablea')
tr0 = tb.find('tr').eq(0)
tr1 = tb.find('tr').eq(1)
tr2 = tb.find('tr').eq(2)
tr3 = tb.find('tr').eq(3)
tr4 = tb.find('tr').eq(4)

port_code = tr0.find('td').eq(1).text()
city = tr0.find('td').eq(3).text()

city_cn = re.split('\\s+(?=[\\u4e00-\\u9fff])', city)[1]
city_en = re.split('\\s+(?=[\\u4e00-\\u9fff])', city)[0]

port_name_cn = tr1.find('td').eq(1).text()
port_name_en = tr1.find('td').eq(3).text()

nation = tr2.find('td').eq(1).text()
area = tr2.find('td').eq(3).text()

nation_cn = re.split('(?<=[\\u4e00-\\u9fff])\\s+', nation)[0]
nation_en = re.split('(?<=[\\u4e00-\\u9fff])\\s+', nation)[1]

line_code_cn = tr3.find('td').eq(1).text()
line_code_en = tr3.find('td').eq(3).text()

anchorage = tr4.find('td').eq(1).text()
port_type = tr4.find('td').eq(3).text()

print(port_code + "," + city_cn + "," + city_en + "," + port_name_cn + ","
      + port_name_en + "," + nation_cn + "," + nation_en + "," + line_code_cn + ","
      + line_code_en + "," + anchorage + "," + port_type)


