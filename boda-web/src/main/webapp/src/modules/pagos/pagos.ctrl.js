(function (ng) {
    var mod = ng.module("pagosModule");
    mod.constant("pagosContext", "api/pagos");
    mod.controller('pagosCtrl', ['$scope', '$http', 'pagosContext', '$state', '$stateParams',
        function ($scope, $http, pagosContext, $state, $stateParams) {
                $scope.pagosRecords = {};
                $http.get(pagosContext).then(function (response) {
                $scope.pagosRecords = response.data;
            });
            
            if ($stateParams.pagosId !== undefined && $stateParams.pagosId !== null) {
                id = $stateParams.pagosId;
                $http.get(pagosContext + '/' + id).then(function (response) {
                    $scope.currentPago = response.data;
                });
            } else {
               
                $scope.currentPago= {
                    id: undefined,
                    name: '',
                };

                $scope.alerts = [];
            }
            this.saveRecord = function (id) {
                currentPago = $scope.currentPago;

                // si el id es null, es un registro nuevo, entonces lo crea
                if (id === null) {

                    // ejecuta POST en el recurso REST
                    return $http.post(pagosContext, currentPago)
                            .then(function () {
                                // $http.post es una promesa
                                // cuando termine bien, cambie de estado
                                $state.go('pagosList');
                            });

                    // si el id no es null, es un registro existente entonces lo actualiza
                }
            };
        }
    ]);
}
)(angular);