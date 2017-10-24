(function (ng) {
    var mod = ng.module("tarjetasCreditoModule");
    mod.constant("tarjetasCreditoContext", "api/tarjetasCredito");
    mod.controller('tarjetasCreditoCtrl', ['$scope', '$http', 'tarjetasCreditoContext', '$state', '$stateParams',
        function ($scope, $http, tarjetasCreditoContext, $state, $stateParams) {
                $scope.records = {};
                $http.get("data/tarjetasCredito.json").then(function (response) {
                $scope.records = response.data;
            });
            
            if ($stateParams.tarjetasId !== undefined && $stateParams.tarjetasId !== null) {
                id = $stateParams.tarjetasId;
                $http.get(tarjetasCreditoContext + '/' + id).then(function (response) {
                    $scope.currentTarjeta = response.data;
                });
            } else {
               
                $scope.currentTarjeta= {
                    id: undefined,
                    name: '',
                };

                $scope.alerts = [];
            }
            this.saveRecord = function (id) {
                currentTarjeta = $scope.currentTarjeta;

                // si el id es null, es un registro nuevo, entonces lo crea
                if (id === null) {

                    // ejecuta POST en el recurso REST
                    return $http.post(tarjetasCreditoContext, currentTarjeta)
                            .then(function () {
                                // $http.post es una promesa
                                // cuando termine bien, cambie de estado
                                $state.go('tarjetasList');
                            });

                    // si el id no es null, es un registro existente entonces lo actualiza
                }
            };
        }
    ]);
}
)(angular);

