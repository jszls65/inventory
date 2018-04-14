myApp.controller('LoginController', function($scope, $route, $location) {
    debugger;
    $scope.$route = $route;

    $scope.$login = {
        person: {}
    };
    // 登录者信息

    $scope.$login.loginBtn = function() {
        debugger;
        if (!($scope.$login.person.name && $scope.$login.person.password)) {
            return;
        }
        $.ajax({
            url: '/demo/db/get',
            type: "POST",
            data: {
                'opcode': 'login',
                'name': $scope.$login.person.name,
                "password": $scope.$login.person.password
            },
            dataType: 'json',
            success: function(result) {
                debugger;
                if (result) {
                    $location.path("/main");
                }else{
                    alert("用户名密码错误");
                }

            },
            error: function(e) {
                debugger;
            }
        });

    };
    $scope.$login.register = function() {
        debugger;
        $location.path("/register");
    }




});