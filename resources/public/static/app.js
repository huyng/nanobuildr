var App = angular.module("App", [])
App.controller("MainController", function($scope){
    $scope.projects = PROJECTS;
});