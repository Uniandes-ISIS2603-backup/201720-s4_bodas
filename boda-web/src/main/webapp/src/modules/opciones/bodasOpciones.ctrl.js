(function (ng) {
    var mod = ng.module("opcionesModule");
    mod.constant("bodasContext", "api/bodas");  
    mod.controller('bodaOpcionesCtrl', ['$scope', '$http', 'bodasContext', '$state', '$rootScope',

        function ($scope, $http, bodasContext, $state,  $rootScope) {
            $scope.parametrobodaId=$state.params.bodaId;
            $http.get(bodasContext +'/'+$state.params.bodaId+ '/opcionesServicio' ).then(function (response) {
                $scope.opcionesRecords = response.data;
                
                
            });
           
            $scope.orderOpciones = function (condicionNombre, tipoCondicion) {
                $scope.tipoOrdenOpcion = condicionNombre;
                $scope.currentOrdenOp = tipoCondicion;
            };
        }
    ]);

})(window.angular);