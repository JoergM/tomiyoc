function RouteCtrl($route) {
    var self = this;
    $route.when('/wines', {template:'tpl/welcome.html'});
    $route.when('/wines/:wineId', {template:'tpl/wine-details.html', controller:WineDetailCtrl});
    $route.otherwise({redirectTo:'/wines'});
}


function OptionsListCtrl($scope, $http) {
/*
    $http({ method: 'GET', url: '/foo' }).
        success(function (data, status, headers, config) {
            // ...
        }).
        error(function (data, status, headers, config) {
            // ...
        });
*/

  $scope.options = [
      {"id" : "1", "description": "Projekt 1 ist ein ganz tolles Projekt"},
      {"id" : "2", "description": "Projekt 2"},
      {"id" : "3", "description": "Projekt 3"},
      {"id" : "4", "description": "Projekt 4"},
      {"id" : "5", "description": "Projekt 5"},
      {"id" : "6", "description": "Projekt 6"},
      {"id" : "7", "description": "Projekt 7"},
      {"id" : "8", "description": "Projekt 8"}]
}