(function (ng) {
    var mod = ng.module("ubicacionesModule");
    mod.constant("ubicacionesContext", "api/ubicaciones");
    mod.controller('ubicacionesCtrl', ['$scope', '$http', 'ubicacionesContext', '$state',
        function ($scope, $http, ubicacionesContext, $state, GoogleMapApiProviders) {
            
            $http.get(ubicacionesContext).then(function (response) {
                $scope.ubicacionesRecords = response.data;
            });
            if ($state.params.ubicacionId !== undefined) {
                $http.get(ubicacionesContext + '/' + $state.params.ubicacionId).then(function (response) {
                    $scope.currentUbicacion = response.data;
                    $scope.map = { center: { latitude: $scope.currentUbicacion.latitud, longitude: $scope.currentUbicacion.longitud }, zoom: 16 ,bounds: {}};
            $scope.options = {scrollwheel: false};
            var createRandomMarker = function(bounds){
               var lat_min = bounds.southwest.latitude,
                lat_range = bounds.northeast.latitude - lat_min,
                lng_min = bounds.southwest.longitude,
                lng_range = bounds.northeast.longitude - lng_min;
            
            var latitude = lat_min + (Math.random() * lat_range);
            var longitude = lng_min + (Math.random() * lng_range);
            
            var ret  = {
                latitude: $scope.currentUbicacion.latitud,
                longitude: $scope.currentUbicacion.longitud,
                title: '</strong>Direccion:</strong> '+ $scope.currentUbicacion.direccion,
                show: false,
                id: 1
            };
            return ret;
           };
           $scope.onClick = function(marker, eventName, model) {
            model.show = !model.show;
        };
            $scope.randomMarkers = [];
            $scope.$watch(function() { return $scope.map.bounds; }, function(nv, ov) {
            // Only need to regenerate once
            if (!ov.southwest && nv.southwest) {
                var markers = [];
                markers.push(createRandomMarker( $scope.map.bounds))
                $scope.randomMarkers = markers;
            }
            }, true);
                });
            }
        }]);
})(angular);

