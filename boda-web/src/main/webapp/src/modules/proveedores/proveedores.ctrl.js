(function (ng) {
    var mod = ng.module("proveedoresModule");
    mod.constant("proveedoresContext", "api/proveedores");
    mod.controller('proveedoresCtrl', ['$scope', '$http', 'proveedoresContext', '$state',
        function ($scope, $http,proveedoresContext, $state) {
            $http.get(proveedoresContext).then(function (response) {
                $scope.proveedoresRecords = response.data;
            });

            //Si el controlador recibio un proveedor Id
            if ($state.params.proveedorId !== undefined) {
                $http.get(proveedoresContext + '/' + $state.params.proveedorId).then(function (response) {
                    //$scope.regalosRecords = response.data.regalos;
                    $scope.currentProveedor = response.data;
                });   
            }
            else {
                // el registro actual debe estar vacio
                $scope.currentProveedor = {
                    id: undefined /*Tipo Long. El valor se asigna en el backend*/,
                    name: '' /*Tipo String*/,
                    especificacion:''
                };

                $scope.alerts = [];
            }
            
        }]);
})(angular);