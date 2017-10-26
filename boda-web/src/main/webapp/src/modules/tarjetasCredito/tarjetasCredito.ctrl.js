(function (ng) {
    var mod = ng.module("tarjetasCreditoModule");
    
    mod.constant("parejasContext", "api/parejas");
    
    mod.controller('tarjetasCreditoCtrl', ['$scope', '$http', 'parejasContext', 'tarjetasCreditoContext','$stateParams',
        function($scope, $http, tarjetasCreditoContext, parejasContext,$stateParams) {
                 $http.get(parejasContext + '/' + $stateParams.parejaId + '/'+ tarjetasCreditoContext).then(function (response) {
                 $scope.records = response.data;
                 });
        }
    ]);
}
)(angular);

