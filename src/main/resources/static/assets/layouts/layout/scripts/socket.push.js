// if ($.cookie('POSITIONTYPE') == 'sales') {
if ($.cookie('POSITIONUUID') == '1ac01cfd-2755-2db0-0936-dc96f9ea019c') {
    // 连接服务端
    var socket = io('http://192.168.43.143:2120');

    var data = {
        'uuid':$.cookie('USERUUID'),
        'group':$.cookie('POSITIONUUID')
    }; 

    socketLogin(data);
    console.log(9);
    // 后端推送来消息时
    socket.on('new_msg', function (msg) {
        playSound();
        console.log(10);
        var viewname = window.location.pathname.split('/').pop();

        if (viewname == 'salesOrderListView') {
            //工业屏 列表刷新
            getSalesOrderList();
        }
        /*else if(viewname == 'salesOrderList'){
            //销售模块 列表刷新
            getSalesOrderList();
        }
        else if(viewname == 'salesOrderDetail'){
            //销售模块 订单详情刷新
            getSalesOrderDetail();
        }*/

    });   
}

//长连接登录
function socketLogin(data)
{
    // socket连接后以uuid登录以group分组
    // data={'uuid':'','group':''};
    socket.on('connect', function () {
        socket.emit('login', data);
    });
}

//播放提示音
function playSound()
{
    var audioElement = document.createElement('audio');
        audioElement.setAttribute('src', '/uploads/sound/notice.mp3');
        audioElement.setAttribute('autoplay', 'autoplay'); //打开自动播放

        $.get();

        audioElement.addEventListener("load", function() {
            audioElement.play();
        }, true);
}