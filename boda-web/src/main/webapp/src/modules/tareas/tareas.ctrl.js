
(function (ng) {
    var mod = ng.module("tareasModule");
    mod.constant("tareasContext", "tareas");
    mod.constant("bodasContext", "api/bodas");
    mod.controller('tareasCtrl', ['$scope', '$http', 'bodasContext', '$state', 'tareasContext',
        function ($scope, $http, bodasContext, $state, tareasContext) {
            $http.get(bodasContext + '/' + $state.params.bodaId + '/' + tareasContext).then(function (response) {
                $scope.tareasRecords = response.data;
            });
     
            }]);
         mod.controller('tareasDetCtrl', ['$scope', '$http', 'bodasContext', '$state', 'tareasContext',
        function ($scope, $http, bodasContext, $state, tareasContext) {
            $http.get(bodasContext + '/' + $state.params.bodaId + '/' + tareasContext + '/' + $state.params.tareaId + tareasContext).then(function (response) {
                $scope.currentTarea = response.data;
            });
       if ($state.params.tareaId !== undefined) {
                $http.get(bodasContext + '/' + $state.params.bodaId + '/' +tareasContext + '/' + $state.params.tareaId).then(function (response) {
                   
                    $scope.currentTarea = response.data;
                });   
            }
    
            }]);


            
    })(window.angular);