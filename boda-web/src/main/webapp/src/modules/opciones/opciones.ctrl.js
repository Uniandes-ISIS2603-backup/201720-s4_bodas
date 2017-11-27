
(function (ng) {
    var mod = ng.module("opcionesModule");
    mod.constant("opcionesServicioContext", "opcionServicios");
    mod.constant("proveedoresContext", "api/proveedores");
    mod.controller('opcionesCtrl', ['$scope', '$http', 'proveedoresContext', '$state', 'opcionesContext',
        
        function ($scope, $http, proveedoresContext, $state, opcionesContext) {
          
            $http.get(proveedoresContext + '/' + $state.params.proveedorId + '/' + opcionesContext).then(function (response) {
                $scope.opcionesRecords = response.data;
            });
       if ($state.params.opcionId !== undefined) {
                $http.get(proveedoresContext + '/' + $state.params.proveedorId + '/' +opcionesContext + '/' + $state.params.opcionId).then(function (response) {
                   
                    $scope.currentOpcion = response.data;
                });   
            }
    
            }]);
      


            
    })(window.angular);


