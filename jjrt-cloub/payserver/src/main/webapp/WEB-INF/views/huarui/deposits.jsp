<%@ page contentType="text/html;charset=UTF-8" errorPage="/error.jsp" pageEncoding="UTF-8" language="java" %>
<%@include file="/resource/jsp/components.jsp" %>
<html>
<head>
    <title>正在转向华瑞银行...</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <script type="text/javascript" src="${prc}/resource/js/jquery/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="${prc}/resource/js/md5.js"></script>
    
<%--     <script type="text/javascript" src="${prc}/resource/js//paychannel/index.js"></script> --%>
    <script type="text/javascript" src="https://hop.hulubank.com.cn:1443/sdk/html/B/HRSDK/hr_js_sdk/v2/hr.js"></script>
    
</head>
<body>
<form  method="post" id="allinPayForm">
    <input type="hidden" id="appID" name="appID" value="6274d276-cd82-4db0-8ba8-9670db4c54ab"/>
    <input type="hidden" id="MD5sign" name="MD5sign" value="42CE5DF2EC8380E175FA73059942C96E"/>
    <input type="hidden" id="randomNumber" name="randomNumber" value="123456" />
    <input type="hidden" id="appUserId" name="appUserId" value="0000000123"/>
</form>
<script type="text/javascript">

	var deposits = function () {
	    SHRB.Api({
	        serviceId: "HRDeposits",
	        data: {
	            tranDetail: {
	                tranAmt: "100",
	                outTradeNo: "20000000001"
	            },
	            autoFillData: {
	                "cardNo": "",
	                "mobile": "",
	                "revmobile": ""
	            }
	        }
	    }, function (data) {
	        console.log(data);
	        //show(data);
	        //payID = JSON.parse(data).payID;
	    })
	};


	//一、首先初始化SDK
	function initSdk() {
	    var appInfo = "appID=" + "96c3b1a6-f8af-4a29-82ef-53cedd80a1f1" + "&random=" + "123456" + "&key=" + "93acb6df-0671-427d-aa18-1df009b2cc7d";
        console.log($( "#appID" ).val()+";"+$( "#MD5sign" ).val()+";"+$( "#randomNumber" ).val()+";"+$( "#appUserId" ).val()+";");
        var hash = md5(appInfo);
        
	    SHRB.initWithAppID({
	        //appID: $( "#appID" ).val(),
	        //MD5sign: $( "#MD5sign" ).val(),
	        //random: $( "#randomNumber" ).val(),
	        //appUserId: $( "#appUserId" ).val() //用户唯一标识
	        appID: "96c3b1a6-f8af-4a29-82ef-53cedd80a1f1",
	        MD5sign: hash.toUpperCase(),
	        random: "123456",
	        appUserId: "0000000123", //用户唯一标识  
	        mchID: "SHRB01100000000485"
	    }, function (data) {
	        console.log(data);
	        //show(data);
	        deposits();
	    });
	};

    $(document).ready(function (){
    	
        initSdk();
        //HRBindCard();
    });
</script>
</body>
</html>
