(function (ng) {
    var app = angular.module('mainApp', [
        // External dependencies
        'ui.router',
        
        // Internal modules dependencies   
     

        
     
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
        
        'calificaionesModule',
        'parejasModule'

    ]);
    // Resuelve problemas de las promesas
    app.config(['$qProvider', function ($qProvider) {
            $qProvider.errorOnUnhandledRejections(false);
        }]);
})(window.angular);

jQuery(document).on('ready', function ($) {
    "use strict";

    /*----------------------------
        LOADING
    ------------------------------*/
$(window).load(function () {
    $(".loader").fadeOut("slow");
});

}(jQuery));
