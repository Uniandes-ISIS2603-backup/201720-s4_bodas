(function (ng) {
    var mod = ng.module("tarjetasCreditoModule");
    mod.constant("tarjetasCreditoContext", "tarjetasCredito");
    mod.constant("parejasContext", "api/parejas");
    mod.controller('tarjetasCreditoDeleteCtrl', ['$scope', '$http', 'parejasContext', 'tarjetasCreditoContext', '$state',
        function ($scope, $http, parejasContext, tarjetasCreditoContext, $state) {
            $scope.deleteTarjetaCredito = function () {
                $http.delete(parejasContext + '/' + $state.params.parejaId + '/' + tarjetasCreditoContext + $state.params.tarjetaId, {}).then(function (response) {
                $state.go('tarjetasList', {parejaId: response.data.correoElec},{tarjetaId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(angular);

