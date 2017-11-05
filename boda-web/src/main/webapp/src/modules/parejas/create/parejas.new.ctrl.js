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
                    description: $scope.authorDescription,
                    image: $scope.authorImage
                }).then(function (response) {
                    //Author created successfully
                    $state.go('parejasList', {authorId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(angular);