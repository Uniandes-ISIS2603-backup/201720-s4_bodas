
(function (ng) {

    var mod = ng.module("bodasModule");

    mod.controller("bodasCtrl", ['$scope', '$state', '$stateParams', '$http', 'bodasContext', function ($scope, $state, $stateParams, $http, context) {

            // inicialmente el listado de bodas está vacio
            $scope.records = {};
            // carga las bodas
            $http.get(context).then(function (response) {
                $scope.records = response.data;
            });

            // el controlador recibió un bodaId ??
            // revisa los parámetros (ver el :bodaId en la definición de la ruta)
            if ($stateParams.bodaId !== null ) {

                // toma el id del parámetro
                id = $stateParams.bodaId;
                $scope.currentBoda = response.data;
                // obtiene el dato del recurso REST
                $http.get(context + "/" + id)
                        .then(function (response) {
                            // $http.get es una promesa
                            // cuando llegue el dato, actualice currentRecord
                            $scope.currentRecord = response.data;
                        });

                // el controlador no recibió un bodaId
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
                    return $http.post(context, currentRecord)
                            .then(function () {
                                // $http.post es una promesa
                                // cuando termine bien, cambie de estado
                                $state.go('bodasList');
                            });

                    // si el id no es null, es un registro existente entonces lo actualiza
                } else {

                    // ejecuta PUT en el recurso REST
                    return $http.put(context + "/" + currentRecord.id, currentRecord)
                            .then(function () {
                                // $http.put es una promesa
                                // cuando termine bien, cambie de estado
                                $state.go('bodasList');
                            });
                }
                ;
            };
            
            this.deleteRecord = function(record) {
                 return $http.delete(context +"/" + record.id)
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

