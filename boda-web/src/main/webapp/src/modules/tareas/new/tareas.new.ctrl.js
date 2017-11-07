    
(function (ng) {
    var mod = ng.module("tareasModule");
    mod.constant("tareasContext", "tareas");
    mod.constant("bodasContext", "api/bodas");
    
    mod.controller('tareasNewCtrl', ['$scope', '$http', 'bodasContext', '$state', '$rootScope','tareasContext',
        function ($scope, $http, bodasContext, $state,  $rootScope, tareasContext) {
            $rootScope.edit = false;
            $scope.createTarea = function () {
                  
                $http.post(bodasContext + '/' + $state.params.bodaId + '/' + tareasContext , {
                    dia: $scope.tareaDia,
                    image: $scope.tareaImage,
                    nombre: $scope.tareaNombre,
                    aprobada: $scope.tareasAprobada
                    
                }).then(function (response) {
                    //Boda created successfully
                    $state.go('tareasList', {tareaId: response.data.id}, {reload: true});
                });
                 
            
            };
        }
    ]);
}
)(angular);


           


           

