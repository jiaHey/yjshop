var vm = new Vue({
    el:'#rrapp',
    data:{
        username: '',
        password: '',
        captcha: '',
        error: false,
        errorMsg: '',
        src: '/captcha.jpg'
    },
    beforeCreate: function(){
        if(self != top){
            top.location.href = self.location.href;
        }
    },
    methods: {
        refreshCode: function(){
            this.src = "/captcha.jpg?t=" + $.now();
        },
        login: function () {
            var data = "username="+vm.username+"&password="+vm.password+"&captcha="+vm.captcha;
            $.ajax({
                type: "POST",
                url:  "/sys/login",
                data: data,
                dataType: "json",
                success: function(r){
                    if(r.code == 0){//登录成功
                        localStorage.setItem("token", r.token);
                        parent.location.href ='index.html';
                    }else{
                        vm.error = true;
                        vm.errorMsg = r.msg;

                        vm.refreshCode();
                    }
                }
            });
        }
    }
});