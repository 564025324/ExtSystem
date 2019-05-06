$(function () {
    // Waves初始化
    Waves.displayEffect();
    // 输入框获取焦点后出现下划线
    $('.form-control').focus(function () {
        $(this).parent().addClass('fg-toggled');
    }).blur(function () {
        $(this).parent().removeClass('fg-toggled');
    });
});
Checkbix.init();
$(function () {
    // 点击登录按钮
    $('#login-bt').click(function () {
        login();
    });
    // 回车事件
    $('#username, #password').keypress(function (event) {
        if (13 == event.keyCode) {
            login();
        }
    });
});

// 登录
function login() {
    $.ajax({
        url: 'http://localhost:10088/login/clickLogin',
        type: 'POST',
        data: {
            username: $('#username').val(),
            password: $('#password').val(),
            rememberMe: $('#rememberMe').is(':checked'),
            // backurl: BACK_URL
        },
        dataType: 'json',
        // beforeSend: function () {
        //
        // },
        success: function (json) {
            console.log('json:' + json);
            console.log('json.code :' + json.code );
            console.log('json.msg :' + json.msg );
            if (json.code == 1) {
                window.location.replace("http://localhost:10088/login/index");
            } else {
                alert('123');
                var data = eval('(' + json + ')');
                var data1 = JSON.stringify(data);
                console.log('data:' + data);
                console.log('data1:' + data1);
                console.log('data1:' + data1[0]['msg']);

                if (10101 == json.code) {
                    $('#username').focus();
                }
                if (10102 == json.code) {
                    $('#password').focus();
                } else {
                    alert('json[code] = ' + json[code]);
                }
            }
        },
        error: function (error) {
            console.log(error);
        }
    });
}