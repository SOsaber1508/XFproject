$(document).ready(function () {
    //退出登录
    $("#Logout").click(function () {
        console.log("i m  coming");
        $.ajax({
            url:"../login/logout.htm",
            type:"POST",
            data:{},
            dataType:"json",
            success:function(data) {
                self.location.href="../index.jsp";
            },
            error:function () {
                alert("请求失败");
            },
            complete:function () {
                //alert("请求成功与否，都会执行");
            }
        });
    });
    //注册
    $("#register").click(function () {
        $.ajax({
            url:"../login/logout.htm",
            type:"POST",
            data:{},
            dataType:"json",
            success:function(data) {
                self.location.href="../index.jsp";
            },
            error:function () {
                alert("请求失败");
            },
            complete:function () {
                //alert("请求成功与否，都会执行");
            }
        });
    });
});