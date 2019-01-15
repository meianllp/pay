


function jssdk_GetQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return (r[2]); return null;
}
if (ID("sdk_src")){
    ID("sdk_src").setAttribute("src", ID("sdk_src").getAttribute("data-src"));
    if (jssdk_GetQueryString("src") == "190") {
        ID("sdk_src").setAttribute("src", "http://10.129.34.190/sdk/html/B/HRSDK/hr_js_sdk/v2/hr.js")
    }
    if (jssdk_GetQueryString("src") == "72") {
        ID("sdk_src").setAttribute("src", "http://10.128.165.72/sdk/html/HRSDK/hr_js_sdk/v2/hr.js")
    }
}

function ID(ele) {
    return document.getElementById(ele);
}
function initSdk() {
    SHRB.initWithAppID({
        appID: ID('appID').value,
        MD5sign: ID("MD5sign").value,
        random: ID("randomNumber").value,
        appUserId: ID("appUserId").value,
        mchID: ID("mchID").value
    }, function (data) {
        if (isLocalStorageNameSupported()) saveAppList();
        console.log(data);
        show(data);
    });
};
function getSign() {

    var signData = {
        "appID": ID('appID').value,
        "body": "天天水果",
        "mchID": ID("mchID").value,
        "outTradeNo": ID('outTradeNo').value,
        "random": ID('random').value,
        "totalFee": ID("totalFee").value
    };

    var appkey = ID("app_secret").value;
    var urlappkey = encodeURIComponent(encodeURIComponent(appkey));
    var urljson = encodeURIComponent(encodeURIComponent(JSON.stringify(signData)));
    HrAjax({
        url: 'https://hop.hulubank.com.cn:1443/devportal/ws/createSign/getSign',
        type: "get",
        data: {
            json: urljson,
            appkey: urlappkey, signMethod: "md5"
        },
        dataType: 'json',
        async: true,
        success: function (dataStr) {
            var data = eval('(' + dataStr + ')');
            if (data.code == "00000") {
                ID('outTradeSign').value = data.result.sign;
            } else {
                alert(data.message);
            }
        },
        error: function () {
            // alert('ajax调用异常');
            getSign_local();
        }
    });

}
function appGetSign() {
    var signData = {
        "appID": ID('appID').value,
        "random": ID('randomNumber').value
    };

    var appkey = ID("app_secret").value;
    var urlappkey = encodeURIComponent(encodeURIComponent(appkey));
    var urljson = encodeURIComponent(encodeURIComponent(JSON.stringify(signData)));
    HrAjax({
        url: 'https://hop.hulubank.com.cn:1443/devportal/ws/createSign/getSign',
        type: "get",
        data: {
            json: urljson,
            appkey: urlappkey, signMethod: "md5"
        },
        dataType: 'json',
        async: true,
        success: function (dataStr) {
            var data = eval('(' + dataStr + ')');
            if (data.code == "00000") {
                ID('MD5sign').value = data.result.sign;
            } else {
                alert(data.message);
            }
        },
        error: function () {
            // alert('ajax调用异常');
            appGetSign_local()
        }
    });

}
function getSign_local() {


    var appInfo = "appID=" + ID('appID').value + "&body=天天水果&mchID=" + ID("mchID").value + "&outTradeNo=" + ID('outTradeNo').value + "&totalFee=" + ID("totalFee").value + "&random=" + ID('random').value + "&key=" + ID("app_secret").value;
    var hash = md5(appInfo);
    ID('outTradeSign').value = hash.toUpperCase();


}
function appGetSign_local() {
    var appInfo = "appID=" + ID('appID').value + "&random=" + ID('randomNumber').value + "&key=" + ID("app_secret").value;
    var hash = md5(appInfo);
    ID('MD5sign').value = hash.toUpperCase();

}

function show(data) {
    ID("status").innerHTML = data;
}
// function login(){
//     SHRB.Api({
//         serviceId:"getUserIDs",
//         data:{
//             appUserToken : ID("appUserToken").value
//         }
//     },function (data) {
//         show(data);
//     })
// }
var approveDev = function () {
    SHRB.Api({
        serviceId: "approveDev",
        data: {
            MD5sign: ID("MD5sign").value,
            randomNumber: ID("randomNumber").value,
            appUserId: ID("appUserId").value
        }
    }, function (data) {
        show(data);

        if (isLocalStorageNameSupported()) saveAppList();

    })
};
function isLocalStorageNameSupported() {
    var testKey = 'testaaa', storage = window.localStorage;
    try {
        storage.setItem(testKey, '1');
        storage.removeItem(testKey);
        return true;
    } catch (error) {
        return false;
    }
}
var getUserCardList = function () {
    SHRB.Api({
        serviceId: "getUserCardList",
        data: {}
    }, function (data) {
        console.log(data);
        orderQuery();
    })
};
var payID;
function orderQuery() {
    SHRB.Api({
        serviceId: "orderQuery",
        data: {
            mchID: ID("mchID").value,
            outTradeNo: ID("outTradeNo").value,
            payID: payID
        }
    }, function (data) {
        console.log("接收数据");
        console.log(data);
    })
}
function cardQuery() {

    SHRB.Api({
        serviceId: "customerCardArrayQuery",
        data: {
            cardID: ID("cardID").value,
            cardStatus: "N",
            customerID: ID("customerID").value,
            merchantID: ID("merchantID").value,
            platformID: ID("platformID").value,
            virtualAcctType: "101",
            personUnionID: "ndxtKWM5ljQsMv36ADQdXddPOQbIy08T+U6BgPmsQzY="
        }
    }, function (data) {
        console.log("接收数据");
        console.log(data);
        show(data);
    })
}
var payOrder = function () {
    SHRB.Api({
        serviceId: "HROrderPay",
        data: {
            discountList: [
                {
                    cardID: ID("cardID").value,
                    discountAmt: ID("discountAmt").value,
                    discountName: ID("discountName").value
                }
            ],
            tranDetail: {
                "attach": "最好的",
                "timeValid": "120",
                "outTradeNo": ID("outTradeNo").value,
                "backUrl": "http://abc.com",
                "body": "天天水果",
                "totalFee": ID("totalFee").value,
                "detail": "水蜜桃",
                "goodsTag": "WXG",
                "mchName": "最好吃的水蜜桃",
                "mchID": ID("mchID").value,
                "spbillCreateIp": "10.125.22.33",
                "feeType": "CNY",
                "limitPay": "01",
                "confirmOrder": "N",
                "unpaidAmount": "44",
                "paidAmount": "44",
                "discountFee": ID("discountFee").value,
                "customerID": ID("customerID").value,
                "merchantID": ID("merchantID").value,
                "platformID": ID("platformID").value,
                "sku": ID("sku").value,
                "spu": ID("spu").value
            },
            random: ID("random").value,
            sign: ID("outTradeSign").value,
            autoFillData: {
                checkData: {//比对用户信息字段,传空则不校验，不为空则检验
                    userName:"",
                    mobile:""
                },
                "cardNo": "",
                "mobile": "18817386369",
                "revmobile": ""
            }
        }
    }, function (data) {
        console.log(data);
        show(data);
        payID = JSON.parse(data).payID;
    })
};
var speedPay = function () {
    SHRB.Api({
        serviceId: "HROrderPay",
        data: {
            speedPay: "true",
            discountList: [
                {
                    cardID: ID("cardID").value,
                    discountAmt: ID("discountAmt").value,
                    discountName: ID("discountName").value
                }
            ],
            tranDetail: {
                "attach": "最好的",
                "timeValid": "120",
                "outTradeNo": ID("outTradeNo").value,
                "backUrl": "http://abc.com",
                "body": "天天水果",
                "totalFee": ID("totalFee").value,
                "detail": "水蜜桃",
                "goodsTag": "WXG",
                "mchName": "最好吃的水蜜桃",
                "mchID": ID("mchID").value,
                "spbillCreateIp": "10.125.22.33",
                "feeType": "CNY",
                "limitPay": "01",
                "confirmOrder": "N",
                "unpaidAmount": "44",
                "paidAmount": "44",
                "discountFee": ID("discountFee").value,
                "customerID": ID("customerID").value,
                "merchantID": ID("merchantID").value,
                "platformID": ID("platformID").value
            },
            random: ID("random").value,
            sign: ID("outTradeSign").value,
            autoFillData: {
                checkData: { //比对用户信息字段,传空则不校验，不为空则检验
                    userName: "",
                    mobile: ""
                },
                "cardNo": "",
                "mobile": "18310839846",
                "revmobile": ""
            }
        }
    }, function (data) {
        console.log(data);
        show(data);
        payID = JSON.parse(data).payID;
    })
};
var HRBindCard = function () {
    SHRB.Api({
        serviceId: "HRBindCard",
        data: {
            autoFillData: {
                checkData: { //比对用户信息字段,传空则不校验，不为空则检验
                    userName: "",
                    mobile: ""
                },
                "cardNo": "",
                "mobile": "18310839846",
                "revmobile": ""
            }
        }
    }, function (data) {
        console.log("接收数据");
        console.log(data);
        show(data);
    })
}
var HRBindCard1 = function () {
    SHRB.Api({
        serviceId: "HROpenEMemCard",
        data: {
            platformID: ID("platformID").value,
            autoFillData: {
                "cardNo": "",
                "mobile": "18310839846",
                "revmobile": ""
            }
        }
    }, function (data) {
        console.log("接收数据");
        console.log(data);
        show(data);
    })
}
function removePage() {
    SHRB.delPage(function (data) {
        show(data);
    })
}
function ninePurchase() {
    SHRB.Api({
        serviceId: "HRPurchase",
        data: {
            "tradeData": {
                "productType": ID('purchase_Type').value,
                "productId": ID('purchase_ID').value
            },
            "extraMessage": {
                "tranNo": "11",
                "mobile": "13088881111",
                "realName": "谷震",
                "appAmt": ID('purchase_amt').value,
                "identity": "652324198006208272",
                "revmobile": "13088881111",
                "cardNo": "6214831218445788"
            }
        }
    }, function (data) {
        console.log("接收数据");
        console.log(data);
        show(data);
    })
}
function setPurchase() {
    if (ID('purcahse_con').style.display == "block") {
        ID('purcahse_con').style.display = "none";
    } else {
        ID('purcahse_con').style.display = "block";
    }
}
function setEcard() {
    if (ID('ecard_con').style.display == "block") {
        ID('ecard_con').style.display = "none";
    } else {
        ID('ecard_con').style.display = "block";
    }
}
var deposits = function () {
    SHRB.Api({
        serviceId: "HRDeposits",
        data: {
            tranDetail: {
                tranAmt: ID("totalFee").value,
                outTradeNo: ID("outTradeNo").value
            },
            autoFillData: {
                "cardNo": "",
                "mobile": "",
                "revmobile": ""
            }
        }
    }, function (data) {
        console.log(data);
        show(data);
        payID = JSON.parse(data).payID;
    })
};
var withdraw = function () {
    SHRB.Api({
        serviceId: "HRWithdraw",
        data: {
            tranDetail: {
                tranAmt: ID("totalFee").value,
                outTradeNo: ID("outTradeNo").value
            },
            autoFillData: {
                "cardNo": "",
                "mobile": "",
                "revmobile": ""
            }
        }
    }, function (data) {
        console.log(data);
        show(data);
        payID = JSON.parse(data).payID;
    });
};
function hide_app_history() {
    document.body.addEventListener("click",function() {
        document.body.removeChild(ID("list_con"));
    });
}
function selectApp() {
    var appList = JSON.parse(localStorage.getItem("hr_app_demo_list"));
    var list_con = document.createElement("div");
    list_con.setAttribute("id", "list_con");
    list_con.style.background = "white";
    list_con.style.border = "1px solid black";
    list_con.style.overflowY = "auto";
    if (appList && appList.appID) {
        var l = appList.appID.length, htmlText = "";
        for (var i = 0; i < l; i++) {
            var htmlNode = '<div id=' + appList.appID[i] + ' style="padding: 5px;"><input MD5sign=' + appList.MD5sign[i] + ' mchID=' + appList.mchID[i] + '  randomNumber=' + appList.randomNumber[i] + '  app_secret=' + appList.app_secret[i] + ' value=' + appList.appID[i] + ' type="button" style="margin-top:0px;display:inline-block;width:75%;" onclick="chooseApp(this)"><span style="display: inline-block;width: 20%;text-align: center;background: #b4874a;border-radius:2px;color:white;margin-left:6px;" onclick=deleteApp(\'' + appList.appID[i] + '\')>删除</span></div>';
            htmlText = htmlText + htmlNode;
        }
        list_con.innerHTML = htmlText;
        list_con.style.display = "block";
        document.body.appendChild(list_con);
    }
}
function saveAppList() {
    var appID = ID("appID").value;
    var app_secret = ID("app_secret").value;
    var MD5sign = ID("MD5sign").value;
    var randomNumber = ID("randomNumber").value;
    var mchID = ID("mchID").value;
    var parseData = JSON.parse(localStorage.getItem("hr_app_demo_list"));
    if (parseData && parseData.appID) {
        var local_appList = parseData, same_status = true;
        for (var i = 0, l = local_appList.appID.length; i < l; i++) {
            if (appID == local_appList.appID[i]) {
                same_status = false;;
                local_appList.app_secret[i] = app_secret;
                local_appList.MD5sign[i] = MD5sign;
                local_appList.randomNumber[i] = randomNumber;
                if (!local_appList.mchID) local_appList.mchID = [];
                local_appList.mchID[i] = mchID;
            }

        }
        if (same_status) {
            local_appList.appID.push(appID);
            local_appList.app_secret.push(app_secret);
            local_appList.MD5sign.push(MD5sign);
            local_appList.randomNumber.push(randomNumber);
            local_appList.mchID.push(mchID);
        }
        localStorage.setItem("hr_app_demo_list", JSON.stringify(local_appList));
    } else {
        var data = {
            appID: [appID],
            app_secret: [app_secret],
            MD5sign: [MD5sign],
            randomNumber: [randomNumber],
            mchID: [mchID]
        }
        localStorage.setItem("hr_app_demo_list", JSON.stringify(data));
    }

}
function chooseApp(_this) {
    ID("appID").value = _this.value;
    ID("app_secret").value = _this.getAttribute('app_secret');
    ID("MD5sign").value = _this.getAttribute('MD5sign');
    ID("randomNumber").value = _this.getAttribute('randomNumber');
    if (_this.getAttribute('mchID') == "undefined") _this.setAttribute('mchID', "请补充商户号");
    ID("mchID").value = _this.getAttribute('mchID');
    document.body.removeChild(ID("list_con"));
}
function deleteApp(appID) {
    var appList = JSON.parse(localStorage.getItem("hr_app_demo_list"));
    var l = appList.appID.length;
    for (var i = 0; i < l; i++) {
        if (appID == appList.appID[i]) {
            appList.appID.splice(i, 1);
            appList.app_secret.splice(i, 1);
            appList.MD5sign.splice(i, 1);
            appList.randomNumber.splice(i, 1);
            appList.mchID.splice(i, 1);
        }
    }
    localStorage.setItem("hr_app_demo_list", JSON.stringify(appList))
    ID("list_con").removeChild(ID(appID));
}
function loan() {
    SHRB.Api({
        serviceId: "HRLoanManagement",
        data: {
            autoFillData: {
                "cardNo": "",
                "mobile": "18310839846",
                "revmobile": ""
            }
        }
    }, function (data) {
        console.log("接收数据");
        console.log(data);
        show(data);
    })
}
function JSHloan() {
    SHRB.Api({
        serviceId: "HRLoanManagementJSH",
        data: {
            autoFillData: {
                "cardNo": "",
                "mobile": "18310839846",
                "revmobile": ""
            }
        }
    }, function (data) {
        console.log("接收数据");
        console.log(data);
        show(data);
    })
}





