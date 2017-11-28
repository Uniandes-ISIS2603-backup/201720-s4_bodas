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
                parent: 'tarjetasDetail',
                views: {
                    'childrenView': {
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
                }).state('pagosDetail', {
                url: '/:pagoId',
                parent: 'pagos',
                param: {
                    pagoId: null
                },
                 views: {
                    'detailView': {
                        templateUrl: basePath + 'pagos.detail.html',
                        controller: 'pagosCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('pagosUpdate', {
                url: '/update/:pagoId',
                parent: 'pagos',
                param: {
                    pagoId: null
                },
                 views: {
                    'detailView': {
                        templateUrl: basePath + 'update/pagos.update.html',
                        controller: 'pagosUpdateCtrl'
                    }
                }
            }).state('pagosCreate', {
                url: '/create/:pagoId',
                parent: 'pagos',
                param: {
                    pagoId: null
                },
                 views: {
                    'detailView': {
                        templateUrl: basePath + 'update/pagos.update.html',
                        controller: 'pagosNewCtrl'
                    }
                }
            });
        }]);
})(window.angular);