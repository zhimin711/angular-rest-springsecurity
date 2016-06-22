/**
 * Created by 80002023 on 2016/6/22.
 */
angular.module('app.services', ['ngResource']).factory('UserService', function ($resource) {

    return $resource('rest/user/:action', {},
        {
            authenticate: {
                method: 'POST',
                params: {'action': 'authenticate'},
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            },
        }
    );
});