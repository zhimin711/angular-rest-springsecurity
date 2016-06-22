/**
 * Created by 80002023 on 2016/6/22.
 */


function LoginController($scope, $rootScope, $location, $cookieStore, UserService) {

    $scope.rememberMe = false;

    $scope.isError = false;
    $scope.errorMsg = "";

    $scope.login = function () {
        UserService.authenticate($.param({
            username: $scope.username,
            password: $scope.password
        }), function (authenticationResult) {
            console.info(authenticationResult)
            var authToken = authenticationResult.token;
            $rootScope.authToken = authToken;
            if ($scope.rememberMe) {
                $cookieStore.put('authToken', authToken);
            }
            UserService.get(function (user) {
                $rootScope.user = user;
                $location.path("/");
            });
        }, function (result) {
            console.info(result);
            if (result.status == 401) {
                $scope.isError = true;
                $scope.errorMsg = "login failed! username or password error!";
            }
        });
    };
};
