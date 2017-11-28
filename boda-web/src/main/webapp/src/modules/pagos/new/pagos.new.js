(function (ng) {
    var mod = ng.module("tarjetasCreditoModule");
    mod.constant("pagosContext", "pagos");
     mod.constant("tarjetasCreditoContext", "tarjetasCredito");
    mod.constant("parejasContext", "api/parejas");
    
    mod.controller('pagosNewCtrl', ['$scope', '$http','parejasContext','tarjetasCreditoContext', 'pagosContext','$state',  '$rootScope',
        function ($scope, $http, parejasContext,tarjetasCreditoContext, pagosContext, $state,  $rootScope) {
            $rootScope.edit = false;
            
            $scope.createPago = function () {
                console.log($scope.currentOpcion);
                $http.post(parejasContext + '/' + $rootScope.currentUser.username + '/' + tarjetasCreditoContext + '/' + $scope.pagoTarjeta + '/' + pagosContext , {
                    correoPareja: $rootScope.currentUser.username,
                    montoTotal: $rootScope.currentOpcionPago.costo,
                    fecha: new Date(),
                    nombrePago: $rootScope.currentOpcionPago.descripcion,
                    tarjetaId: $scope.pagoTarjeta
                }).then(function (response) {
                    $state.go('pagosConfirm', {pagoId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(angular);