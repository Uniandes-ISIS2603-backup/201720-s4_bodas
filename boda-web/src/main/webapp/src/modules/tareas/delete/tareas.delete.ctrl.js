(function (ng) {
    var mod = ng.module("bodasModule");
   mod.constant("tareasContext", "tareas");
    mod.constant("bodasContext", "api/bodas");
    mod.controller('tareasDeleteCtrl', ['$scope', '$http', 'bodasContext', '$state','tareasContext',
        function ($scope, $http, bodasContext, $state, tareasContext) {
            var idBoda = $state.params.bodaId;
            var idTarea = $state.params.tareaId;
            $scope.deleteTarea = function () {
                $http.delete(bodasContext + '/' + idBoda+ '/' + tareasContext+idTarea, {}).then(function (response) {
                    $state.go('bodasList', {bodaId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(angular);
   
    
        

            
   


