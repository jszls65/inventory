myApp.controller('RegisterController', function($scope, $route, $location) {
    debugger;
    $scope.$route = $route;

    $scope.$register = {};
    $register = $scope.$register;

    $register.msg = "注册成功！";

    /**
     * 注册方法
     */
    $register.regiserFunc = function() {
        debugger;
        alert("注册成功！");
    };

});