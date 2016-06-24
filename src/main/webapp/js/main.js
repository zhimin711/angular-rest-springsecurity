/*
<!--<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.js"></script>-->
    <script type="text/javascript" src="js/jquery-2.2.3.js"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    <!--<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.9/angular.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.9/angular-resource.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.9/angular-route.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.9/angular-cookies.js"></script>-->

    <script type="text/javascript" src="libs/angularjs/angular.js"></script>
    <script type="text/javascript" src="libs/angularjs/angular-resource.js"></script>
    <script type="text/javascript" src="libs/angularjs/angular-route.js"></script>
    <script type="text/javascript" src="libs/angularjs/angular-cookies.js"></script>

    <script type="text/javascript" src="js/config.js"></script>
    <script type="text/javascript" src="js/app.js"></script>*/
/*require.config({
    paths:{
        //一些库文件
        'jquery': '//cdn.bootcss.com/jquery/2.2.3/jquery.min',
        //'bootstrap': "//cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min",
        'angular': '//cdn.bootcss.com/angular.js/1.5.7/angular.min',
        'angular-route': '//cdn.bootcss.com/angular.js/1.5.7/angular-route.min',
        'domReady': '//cdn.staticfile.org/require-domReady/2.0.1/domReady.min',
        //js文件
        'bootstrap': "bootstrap",
        'app': "config",
        'app': "app",
        'router': "router"
        //.....以及其他的js文件，这里省略
},
shim:{
    'angular':{
        exports:'angular'
    },
    'angular-route':{
        deps:['angular'],
            exports: 'angular-route'
    },

},
deps:['bootstrap'],
    urlArgs: "bust=" + (new Date()).getTime()  //防止读取缓存，调试用
});*/

require.config({
    paths:{
        //一些库文件
        'jquery': '//cdn.staticfile.org/jquery/1.10.2/jquery.min',
        'angular': '//cdn.staticfile.org/angular.js/1.2.10/angular.min',
        'angular-route': '//cdn.staticfile.org/angular-ui-router/0.2.8/angular-ui-router.min',
        'domReady': '//cdn.staticfile.org/require-domReady/2.0.1/domReady.min',
        //js文件
        'bootstrap': "bootstrap",
        'config': "config",
        'app': "app",
        'router': "router"
            //.....以及其他的js文件，这里省略
},
shim:{
    'angular':{
        exports:'angular'
    },
    'angular-route':{
        deps:['angular'],
            exports: 'angular-route'
    }
},
deps:['bootstrap'],
    urlArgs: "bust=" + (new Date()).getTime()  //防止读取缓存，调试用
});