/**
 * Controlador del modulo calificación
 */
(function(ng){
    var mod = ng.module("calificaionesModule");
    mod.constant("calificaionesContext", "calificaciones");
    mod.constant("opcionServicioContext","opcionServicios");
    mod.constant("proveedorContext","api/proveedores");
    
    mod.controller('calificacionCtrl',['$scope','$http','$state','calificaionesContext','opcionesContext','proveedoresContext',
        function($scope,$http,$state,calificaionesContext,opcionesContext,proveedoresContext){
            $http.get(proveedoresContext + '/' + $state.params.proveedorId + '/'+ opcionesContext +"/"+ $state.params.opcionId + "/" + calificaionesContext).then(function (response) {
              
                     $scope.calificacionesRecords = response.data;
                 });
            
        }
        
    ]);
    
})(window.angular);
