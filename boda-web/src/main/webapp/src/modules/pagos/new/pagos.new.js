(function (ng) {
    var mod = ng.module("PagosModule");
    mod.constant("pagosContext", "pagos");
    mod.constant("tarjetasCreditoContext", "tarjetasCredito");
    mod.constant("parejasContext", "api/parejas");
    
    mod.controller('tarjetasNewCtrl', ['$scope', '$http', 'parejasContext', 'tarjetasCreditoContext', 'pagosContext' , '$state',  '$rootScope',
        function ($scope, $http, parejasContext, tarjetasCreditoContext, pagosContext, $state,  $rootScope) {
            $rootScope.edit = false;
            
            $scope.updatePago = function () {
                $http.post(parejasContext + '/' + $state.params.parejaId + '/' + tarjetasCreditoContext + '/' + $state.params.tarjetaId + '/' + pagosContext + '/' + $state.params.pagoId, {
                    montoTotal: $scope.pagoMontoTotal,
                    fecha: $scope.pagoFecha,
                    nombrePago: $scope.pagoNombrePago,
                    tarjetaNumero: $scope.pagoTarjetaNumero
                }).then(function (response) {
                    $state.go('pagosList', {pagoId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(angular);
