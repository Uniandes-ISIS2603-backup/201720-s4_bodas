(function (ng) {
    var mod = ng.module("ubicacionesModule", ['uiGmapgoogle-maps']);
    mod.constant("ubicacionesContext", "api/ubicaciones");
    mod.controller('ubicacionesCtrl', ['$scope', '$http', 'ubicacionesContext', '$state',
        function ($scope, $http,ubicacionesContext, $state,GoogleMapApiProviders) {
            $http.get(ubicacionesContext).then(function (response) {
                $scope.ubicacionesRecords = response.data;
            });
            
            
            $scope.map = { center: { latitude: 45, longitude: -73 }, zoom: 8 };
            
            if ($state.params.ubicacionId !== undefined) {
                $http.get(ubicacionesContext + '/' + $state.params.ubicacionId).then(function (response) {
                    $scope.currentUbicacion = response.data;
                }); 
                
               
               
            } 
            
            
             }]);
})(angular);