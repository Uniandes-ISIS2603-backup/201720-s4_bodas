(function (ng) {
    var mod = ng.module("regalosModule");
    mod.constant("regalosContext", "regalos");
    mod.constant("bodasContext", "api/bodas");
    mod.controller('regalosCtrl', ['$scope', '$http', 'bodasContext', '$state', 'regalosContext',
        function ($scope, $http, bodasContext, $state, regalosContext) {
            $http.get(bodasContext + '/' + $state.params.bodaId + '/' + regalosContext).then(function (response) {
                $scope.regalosRecords = response.data;
            });
        }
    ]);
}
)(window.angular);