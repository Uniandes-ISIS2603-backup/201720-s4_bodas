(function (ng) {
    var mod = ng.module("invitadosModule");
    mod.constant("invitadosContext", "invitados");
    mod.constant("bodasContext", "api/bodas");
    mod.controller('invitadosDeleteCtrl', ['$scope', '$http', 'bodasContext', '$state','invitadosContext',
        function ($scope, $http, bodasContext, $state,invitadosContext) {
            var idInv = $state.params.invitadoId;
            $scope.deleteInvitado = function () {
                $http.delete(bodasContext + '/' + $state.params.bodaId, +'/' + invitadosContext + '/'+ idInv).then(function (response) {
                    $state.go('invitadosList',{invitadoId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(angular);


