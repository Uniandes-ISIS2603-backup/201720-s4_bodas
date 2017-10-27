(function (ng) {
    var mod = ng.module("tarjetasCreditoModule");
    mod.constant("tarjetasCreditoContext", "tarjetasCredito");
    mod.constant("parejasContext", "api/parejas");
    mod.controller('tarjetasCreditoCtrl', ['$scope', '$http', 'parejasContext','$state','tarjetasCreditoContext',
        function($scope, $http, tarjetasCreditoContext, $state, parejasContext) {
            $http.get(parejasContext + '/' + $state.params.parejaId + '/'+ tarjetasCreditoContext).then(function (response) {
                     $scope.tarjetasCreditoRecords = response.data;
                 });
        }
    ]);
}
)(angular);

