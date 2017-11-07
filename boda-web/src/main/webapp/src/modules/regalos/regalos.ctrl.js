(function (ng) {
    var mod = ng.module("regalosModule");
    mod.constant("regalosContext", "regalos");
    mod.constant("bodasContext", "api/bodas");
    mod.controller('regalosCtrl', ['$scope', '$http', 'bodasContext', '$state', 'regalosContext',
        function ($scope, $http, bodasContext, $state, regalosContext) {
            $http.get(bodasContext + '/' + $state.params.bodaId + '/' + regalosContext).then(function (response) {
                $scope.regalosRecords = response.data;
            });
            if ($state.params.regaloId !== undefined) {
                $http.get(bodasContext + '/' + $state.params.bodaId + '/' + regalosContext + '/'+ $state.params.regaloId).then(function (response) {
                    $scope.currentRegalo = response.data;
                });   
            }
        }
    ]);
}
)(window.angular);