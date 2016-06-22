/**
 * Created by 80002023 on 2016/6/22.
 */
angular.module('app.services', ['ngResource']).factory('NewsService', function ($resource) {

    return $resource('rest/news/:id', {id: '@id'});
})