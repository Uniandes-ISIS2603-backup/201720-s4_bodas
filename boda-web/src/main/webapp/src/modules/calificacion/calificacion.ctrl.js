/**
 * Controlador del modulo calificación
 */
(function(ng){
    var mod = ng.module("calificacionesModule");
    mod.constant("calificaionesContext", "calificaciones");
    mod.constant("opcionServicioContext","opcionServicios");
    mod.constant("proveedorContext","api/proveedores");
    
    mod.controller('calificacionCtrl',['$scope','$http','$state','calificaionesContext','opcionServicioContext','proveedorContext',
        function($scope,$http,$state,calificaionesContext,opcionServicioContext,proveedorContext){
            
        }
        
    ]);
    
})(angular);
