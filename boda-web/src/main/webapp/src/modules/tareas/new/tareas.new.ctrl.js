    
(function (ng) {
    var mod = ng.module("tareasModule");
    mod.constant("tareasContext", "tareas");
    mod.constant("opcionesServicioContext","opcionServicios");
    mod.constant("proveedoresContext","api/proveedores");
    
    mod.controller('tareasNewCtrl', ['$scope', '$http',  '$state','opcionesServicioContext','proveedoresContext', '$rootScope','tareasContext',
        function ($scope, $http, $state, opcionesServicioContext, proveedoresContext,  $rootScope, tareasContext) {
            $rootScope.edit = false;
            $scope.createTarea = function () {
                  
                $http.post(proveedoresContext + '/' + $state.params.proveedorId + '/' + opcionesServicioContext + '/' + $state.params.opcionId + '/' + tareasContext, {
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


           


           

