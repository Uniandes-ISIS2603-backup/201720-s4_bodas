(function (ng) {
    var mod = ng.module("bodasModule");
    mod.constant("bodasContext", "api/bodas");
    mod.controller('bodaNewCtrl', ['$scope', '$http', 'bodasContext', '$state',  '$rootScope',
        function ($scope, $http, bodasContext, $state,  $rootScope) {
            $rootScope.edit = false;
            $scope.createBoda = function () {
                $http.post(bodasContext, {
                    name: $scope.bodaName,
                    fecha: $scope.bodaFecha,
                    religion: $scope.bodaReligion,
                    tema: $scope.bodaTema,
                    tipo: $scope.bodaTipo,
                    image: $scope.bodaImage
                }).then(function (response) {
                    //Boda created successfully
                    $state.go('bodasList', {bodaId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(angular);