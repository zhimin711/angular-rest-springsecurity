/**
 * Created by 80002023 on 2016/6/22.
 */

function IndexController($scope, NewsService) {

    $scope.newsEntries = NewsService.query();

    $scope.deleteEntry = function (newsEntry) {
        newsEntry.$remove(function () {
            $scope.newsEntries = NewsService.query();
        });
    };
};


function EditController($scope, $routeParams, $location, NewsService) {

    $scope.newsEntry = NewsService.get({id: $routeParams.id});

    $scope.save = function () {
        $scope.newsEntry.$save(function () {
            $location.path('/');
        });
    };
};


function CreateController($scope, $location, NewsService) {

    $scope.newsEntry = new NewsService();

    $scope.save = function () {
        $scope.newsEntry.$save(function () {
            $location.path('/');
        });
    };
};
