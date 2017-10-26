(function (ng) {

    var mod = ng.module("parejasModule");

    mod.controller("parejasCtrl", ['$scope', '$state', '$stateParams', '$http', 'parejasContext', function ($scope, $state, $stateParams, $http, parejasContext) {

            // inicialmente el listado de ciudades está vacio
            $scope.records = {};
            // carga las ciudades
            $http.get(parejasContext).then(function (response) {
                $scope.records = response.data;
            });

            // el controlador recibió un cityId ??
            // revisa los parámetros (ver el :cityId en la definición de la ruta)
            if ($stateParams.parejaId !== null && $stateParams.parejaId !== undefined) {

                // toma el id del parámetro
                id = $stateParams.parejaId;
                // obtiene el dato del recurso REST
                $http.get(parejasContext + "/" + id)
                        .then(function (response) {
                            // $http.get es una promesa
                            // cuando llegue el dato, actualice currentRecord
                            $scope.currentRecord = response.data;
                        });

                // el controlador no recibió un cityId
            } else {
                // el registro actual debe estar vacio
                $scope.currentRecord = {
                    id: undefined /*Tipo Long. El valor se asigna en el backend*/,
                    name: '' /*Tipo String*/,
                };

                $scope.alerts = [];
            }


            this.saveRecord = function (id) {
                currentRecord = $scope.currentRecord;

                // si el id es null, es un registro nuevo, entonces lo crea
                if (id == null) {

                    // ejecuta POST en el recurso REST
                    return $http.post(parejasContext, currentRecord)
                            .then(function () {
                                // $http.post es una promesa
                                // cuando termine bien, cambie de estado
                                $state.go('parejasList');
                            });

                    // si el id no es null, es un registro existente entonces lo actualiza
                } else {

                    // ejecuta PUT en el recurso REST
                    return $http.put(parejasContext + "/" + currentRecord.id, currentRecord)
                            .then(function () {
                                // $http.put es una promesa
                                // cuando termine bien, cambie de estado
                                $state.go('parejasList');
                            });
                }
                ;
            };
            
            this.deleteRecord = function(record) {
                 return $http.delete(parejasContext +"/" + record.correoElec)
                            .then(function () {
                                // $http.delete es una promesa
                                // cuando termine bien, cambie de estado
                                var index = $scope.records.indexOf(record);
                                if (index > -1) {
                                    $scope.records.splice(index, 1);
                                }
                            });
            }

// Código continua con las funciones de despliegue de errores


        }]);
})(window.angular);

