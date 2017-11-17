(function (ng) {
    var app = angular.module('mainApp', [
        // External dependencies
        'ui.router',
        
        // Internal modules dependencies   
     

        'parejasModule',
     
        'bodasModule',
      
        'tarjetasCreditoModule',
        
        'pagosModule',
        
        'serviciosModule',
        
        'proveedoresModule',

        'ubicacionesModule',
        
        'opcionesModule',

        'tareasModule',
        
        'regalosModule',
        
        'invitadosModule',
        
        'calificaionesModule'

    ]);
    // Resuelve problemas de las promesas
    app.config(['$qProvider', function ($qProvider) {
            $qProvider.errorOnUnhandledRejections(false);
        }]);
})(window.angular);