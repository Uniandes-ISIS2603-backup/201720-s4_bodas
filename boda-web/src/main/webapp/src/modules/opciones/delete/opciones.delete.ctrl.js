(function (ng) {
    var mod = ng.module("opcionesModule");
   mod.constant("opconesContext", "opciones");
    mod.constant("proveedoresContext", "api/proveedores");
    mod.controller('opcionesDeleteCtrl', ['$scope', '$http', 'proveedoresContext', '$state','opcionesContext',
        function ($scope, $http,proveedoresContext, $state, opcionesContext) {
            var idProveedor = $state.params.proveedorId;
            var idOpcion = $state.params.opconId;
            $scope.deleteTarea = function () {
                $http.delete(proveedoresContext + '/' + idProveedor+ '/' + opcionesContext+ '/'+idOpcion, {}).then(function (response) {
                    $state.go('opcionesList', {proveedorId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(angular);
   
    
        

            
   



