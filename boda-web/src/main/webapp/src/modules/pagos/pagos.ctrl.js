(function (ng) {
    var mod = ng.module("pagosModule");
    mod.constant("pagosContext", "api/pagos");
    mod.controller('pagoCtrl', ['$scope', '$http', 'pagosContext', '$state', '$stateParams',
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
        }
    ]);
}
)(angular);