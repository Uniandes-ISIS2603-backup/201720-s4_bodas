(function (ng) {
    var mod = ng.module("parejasModule");
    mod.constant("parejasContext", "api/parejas");
    mod.controller('parejasNewCtrl', ['$scope', '$http', 'parejasContext', '$state', '$rootScope',
        function ($scope, $http, parejasContext, $state , $rootScope) {
            $rootScope.edit = false;
            $scope.createPareja = function () {
                $http.post(parejasContext, {
                    correoElec: $scope.correoElec,
                    contrasenia: $scope.contrasenia,
                    nombreInd1: $scope.nombreInd1,
                    nombreInd2: $scope.nombreInd2,
                    nombreAbreviado: $scope.nombreAbreviado,
                    direccion: $scope.direccion,
                    telefono: $scope.telefono,
                    pago: 0
                }).then(function (response) {
                    //Author created successfully
                    swal("Creada!", "Tu Pareja fue creada.", "success");
                    $state.go('parejasList', {parejaId: response.data.correoElec}, {reload: true});
                });
            };
        }
    ]);
}
)(angular);