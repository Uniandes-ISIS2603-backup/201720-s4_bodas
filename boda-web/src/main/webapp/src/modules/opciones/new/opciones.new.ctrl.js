    
(function (ng) {
    var mod = ng.module("opcionesModule");
    mod.constant("opcionesContext", "opciones");
    mod.constant("proveedoresContext", "api/proveedores");
    
    mod.controller('opcionesNewCtrl', ['$scope', '$http', 'proveedoresContext', '$state', '$rootScope','opcionesContext',
        function ($scope, $http, proveedoresContext, $state,  $rootScope, opcionesContext) {
            $rootScope.edit = false;
            $scope.createOpcionServicio = function () {
                  
                $http.post(proveedoresContext + '/' + $state.params.bodaId + '/' + opcionesContext , {
                    descripcion: $scope.opcionesDescripcion,
                    image: $scope.opcionesImage,
                    diasDisponibles: $scope.opcionesDiasDisponibles,
                    costo: $scope.opcionesCosto
                    
                }).then(function (response) {
                    //Boda created successfully
                    $state.go('opcionesList', {opcionesId: response.data.id}, {reload: true});
                });
                 
            
            };
        }
    ]);
}
)(angular);


           


           


