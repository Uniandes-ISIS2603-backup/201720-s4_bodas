(function (ng) {
    var mod = ng.module("tarjetasCreditoModule");
    mod.constant("tarjetasCreditoContext", "tarjetasCredito");
    mod.constant("parejasContext", "api/parejas");
    mod.controller('tarjetasNewCtrl', ['$scope', '$http', 'parejasContext', 'tarjetasCreditoContext' , '$state',  '$rootScope',
        function ($scope, $http, parejasContext, tarjetasCreditoContext, $state,  $rootScope) {
            $rootScope.edit = false;
            
            $scope.createTarjeta = function () {
                $http.post(parejasContext + '/' + $state.params.parejaId + '/' + tarjetasCreditoContext + '/' + $state.params.tarjetaId, {
                    fecha: $scope.tarjetaFecha,
                    numero: $scope.tarjetaNumero,
                    numDeseg: $scope.tarjetaNumDeSeg,
                    nombreBanco: $scope.tarjetaBanco
                }).then(function (response) {
                    $state.go('tarjetasList', {tarjetaId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(angular);

