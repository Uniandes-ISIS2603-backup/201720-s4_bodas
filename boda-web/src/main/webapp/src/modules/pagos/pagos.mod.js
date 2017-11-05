(function (ng) {
    var mod = ng.module("pagosModule", ['parejasModule','tarjetasCreditoModule', 'ui.router']);
    mod.constant("pagosContext", "pagos");
    mod.constant("tarjetasCreditoContext", "tarjetasCredito");
    mod.constant("parejasContext", "api/parejas");
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/pagos/';
            $urlRouterProvider.otherwise("/pagosList");
            
            $stateProvider.state('pagos',{
                url: '/pagos',
                abstract: true,
                parent: 'tarjetasChild',
                views: {
                    childrenView: {
                        templateUrl: basePath + 'pagos.html'
                    }
                }
            }).state('pagosList', {
                url: '/list',
                parent: 'pagos',
                views: {
                    'listView': {
                       templateUrl: basePath + 'pagos.list.html',
                        controller: 'pagosCtrl',
                        controllerAs: 'ctrl'
                    }
                }
                });
        }]);
})(window.angular);