(function (ng) {
    var mod = ng.module("invitadosModule");
    mod.constant("invitadosContext", "invitados");
    mod.constant("bodasContext", "api/bodas");
    mod.controller('invitadosCtrl', ['$scope', '$http', 'bodasContext', '$state', 'invitadosContext',
        function ($scope, $http, bodasContext, $state, invitadosContext) {
            $http.get(bodasContext + '/' + $state.params.bodaId + '/' + invitadosContext).then(function (response) {
                $scope.invitadosRecords = response.data;
            });
            if ($state.params.invitadoId !== undefined) {
                $http.get(bodasContext + '/' + $state.params.bodaId + '/' + invitadosContext + '/'+ $state.params.invitadoId).then(function (response) {
                    $scope.currentInvitado = response.data;
                });   
            }
            
            $scope.orderInv= function(condicion, tipoCondicion){
                 $scope.tipoOrden = condicion;
                 $scope.criterioOrdenar= tipoCondicion;
            };
        }
    ]);
}
)(angular);