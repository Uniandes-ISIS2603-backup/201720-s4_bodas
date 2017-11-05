(function (ng) {
    var mod = ng.module("ubicacionesModule");
    mod.constant("ubicacionesContext", "api/ubicaciones");
    mod.controller('ubicacionesCtrl', ['$scope', '$http', 'ubicacionesContext', '$state',
        function ($scope, $http,ubicacionesContext, $state) {
            $http.get(ubicacionesContext).then(function (response) {
                $scope.ubicacionesRecords = response.data;
            });

            if ($state.params.ubicacionId !== undefined) {
                $http.get(ubicacionesContext + '/' + $state.params.ubicacionId).then(function (response) {
                    $scope.currentUbicacion = response.data;
                });   
            }           
        }]);
})(angular);