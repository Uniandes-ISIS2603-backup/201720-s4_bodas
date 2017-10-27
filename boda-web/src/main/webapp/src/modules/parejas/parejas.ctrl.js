(function (ng) {

    var mod = ng.module("parejasModule");
    mod.constant("parejasContext", "api/parejas"); 
    mod.controller("parejasCtrl", ['$scope', '$state', '$http', 'parejasContext',
        function ($scope, $state, $http, parejasContext) {
            $http.get(parejasContext).then(function (response) {
                $scope.parejasRecords = response.data;
            });

            // el controlador recibió un cityId ??
            // revisa los parámetros (ver el :cityId en la definición de la ruta)
            if ($state.params.parejaId !== undefined) {
                // obtiene el dato del recurso REST
                $http.get(parejasContext + "/" + $state.params.parejaId)
                        .then(function (response) {
                            // $http.get es una promesa
                            // cuando llegue el dato, actualice currentRecord
                            $scope.currentPareja = response.data;
                        });

                // el controlador no recibió un cityId
            } else {
                // el registro actual debe estar vacio
                $scope.currentPareja = {
                    id: undefined /*Tipo Long. El valor se asigna en el backend*/,
                    name: '' /*Tipo String*/,
                };

                $scope.alerts = [];
            }


            this.saveRecord = function (id) {
                currentPareja = $scope.currentPareja;

                // si el id es null, es un registro nuevo, entonces lo crea
                if (id === null) {

                    // ejecuta POST en el recurso REST
                    return $http.post(parejasContext, currentPareja)
                            .then(function () {
                                // $http.post es una promesa
                                // cuando termine bien, cambie de estado
                                $state.go('parejasList');
                            });

                    // si el id no es null, es un registro existente entonces lo actualiza
                } else {

                    // ejecuta PUT en el recurso REST
                    return $http.put(parejasContext + "/" + currentPareja.id, currentPareja)
                            .then(function () {
                                // $http.put es una promesa
                                // cuando termine bien, cambie de estado
                                $state.go('parejasList');
                            });
                }
                ;
            };
            
            this.deleteRecord = function(parejaRecord) {
                 return $http.delete(parejasContext +"/" + parejaRecord.correoElec)
                            .then(function () {
                                // $http.delete es una promesa
                                // cuando termine bien, cambie de estado
                                var index = $scope.parejasRecords.indexOf(parejaRecord);
                                if (index > -1) {
                                    $scope.parejasRecords.splice(index, 1);
                                }
                            });
            }

// Código continua con las funciones de despliegue de errores


        }]);
})(window.angular);

