(function (ng) {
    var mod = ng.module("proveedoresModule");
    mod.constant("proveedoresContext", "api/proveedores");
    mod.controller('proveedoresCtrl', ['$scope', '$http', 'proveedoresContext', '$state',
        function ($scope, $http,proveedoresContext, $state) {
            $http.get(proveedoresContext).then(function (response) {
                $scope.proveedoresRecords = response.data;
            });

            if ($state.params.proveedorId !== undefined) {
                $http.get(proveedoresContext + '/' + $state.params.proveedorId).then(function (response) {
                    //$scope.regalosRecords = response.data.regalos;
                    $scope.currentProveedor = response.data;
                });   
            }
            
        }]);
})(angular);