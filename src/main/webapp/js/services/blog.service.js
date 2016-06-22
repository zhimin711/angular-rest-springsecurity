/**
 * Created by 80002023 on 2016/6/22.
 */
angular.module('app.services', ['ngResource']).factory('BlogArticleService', function ($resource) {

    return $resource('rest/blog/article/:id', {id: '@id'});
});