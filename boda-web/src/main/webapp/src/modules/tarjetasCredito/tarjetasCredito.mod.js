(function (ng) {
    var mod = ng.module("tarjetasCreditoModule", ['parejasModule', 'ui.router']);
    mod.constant("tarjetasCreditoContext", "tarjetasCredito")
    mod.constant("parejasContext", "api/parejas");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/tarjetasCredito/';
            $urlRouterProvider.otherwise("/tarjetasList");
                    
                $stateProvider.state('tarjetasCredito', {
                url: '/tarjetasCredito',
                abstract: true,
                parent: 'parejasList',
                views: {
                    childrenView: {
                        templateUrl: basePath + 'tarjetasCredito.html'
                    }
                }
                }).state('tarjetasList', {
                url: '/list',
                parent: 'tarjetasCredito',
                views: {
                    'listView': {
                        templateUrl: basePath + 'tarjetasCredito.list.html',
                        controller: 'tarjetasCreditoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
                })
            
        }]);
})(window.angular);


