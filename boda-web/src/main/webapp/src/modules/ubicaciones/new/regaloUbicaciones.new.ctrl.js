(function (ng) {
    var mod = ng.module("ubicacionesModule");
    mod.controller('regaloUbicacionNewCtrl', ['$scope', '$http', '$state',  '$rootScope',
        function ($scope, $http, $state,  $rootScope) {
            $rootScope.edit = false;
            var idRegalo = $state.params.regaloId;
            var idBoda = $state.params.bodaId;
            var idUbi = $state.params.ubicacionId;
            $scope.createUbicacion = function () {
                $http.post('api/bodas'+ idBoda + '/regalos/'+ idRegalo, +'ubicaciones/'+ idUbi).then(function () {
                    $state.go('regalosList', {idBoda}, {reload: true});
                });
            };
        }
    ]);
}
)(angular);

