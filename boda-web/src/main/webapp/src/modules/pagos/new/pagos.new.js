(function (ng) {
    var mod = ng.module("tarjetasCreditoModule");
    mod.constant("pagosContext", "pagos");
     mod.constant("tarjetasCreditoContext", "tarjetasCredito");
    mod.constant("parejasContext", "api/parejas");
    
    mod.controller('pagosNewCtrl', ['$scope', '$http','parejasContext','tarjetasCreditoContext', 'pagosContext','$state',  '$rootScope',
        function ($scope, $http, parejasContext,tarjetasCreditoContext, pagosContext, $state,  $rootScope) {
            $rootScope.edit = false;
            
            $scope.createPago = function () {
                $http.post(parejasContext + '/' + $scope.pagoPareja + '/' + tarjetasCreditoContext + '/' + $scope.pagoTarjeta + '/' + pagosContext , {
                    correoPareja: $scope.pagoPareja,
                    montoTotal: $scope.pagoMontoTotal,
                    fecha: $scope.pagoFecha,
                    nombrePago: $scope.pagoNombrePago,
                    tarjetaId: $scope.pagoTarjeta
                }).then(function (response) {
                    $state.go('pagosConfirm', {pagoId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(angular);