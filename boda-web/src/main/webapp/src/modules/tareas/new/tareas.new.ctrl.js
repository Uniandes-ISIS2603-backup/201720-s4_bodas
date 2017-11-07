    
(function (ng) {
    var mod = ng.module("tareasModule");
    mod.constant("tareasContext", "tareas");
    mod.constant("bodasContext", "api/bodas");
    
    mod.controller('tareasNewCtrl', ['$scope', '$http', 'bodasContext', '$state','tareasContext', '$rootScope',
        function ($scope, $http, bodasContext, $state, tareasContext,  $rootScope) {
            $rootScope.edit = false;
            $scope.createTarea = function () {
                if ($state.params.bodaId !== undefined) {
                $http.get(bodasContext + '/' + $state.params.bodaId).then(function (response) {
                    //$scope.regalosRecords = response.data.regalos;
                    $scope.currentBoda = response.data;
                });   
                $http.post($state.params.bodaId,tareasContext, {
                    id: $scope.tareaId,
                    dia: $scope.tareaDia,
                    image: $scope.tareaImage,
                    nombre: $scope.tareaNombre
                    
                }).then(function (response) {
                    //Boda created successfully
                    $state.go('tareasList({bodaId: currentBoda.id})', {tareaId: response.data.id}, {reload: true});
                });
                 
            }
            };
        }
    ]);
}
)(angular);


           


           

