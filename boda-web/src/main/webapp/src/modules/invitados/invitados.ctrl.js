(function (ng) {
    var mod = ng.module("invitadosModule");
    mod.constant("invitadosContext", "invitados");
    mod.constant("bodasContext", "api/bodas");
    mod.controller('invitadosCtrl', ['$scope', '$http', 'bodasContext', '$state', 'invitadosContext',
        function ($scope, $http, bodasContext, $state, invitadosContext) {
            $http.get(bodasContext + '/' + $state.params.bodaId + '/' + invitadosContext).then(function (response) {
                $scope.invitadosRecords = response.data;
            });
        }
    ]);
}
)(angular);