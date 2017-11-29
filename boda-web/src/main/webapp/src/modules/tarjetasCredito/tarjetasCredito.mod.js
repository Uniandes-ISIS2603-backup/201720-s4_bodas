(function (ng) {
    var mod = ng.module("tarjetasCreditoModule", ['parejasModule', 'ui.router']);
    mod.constant("tarjetasCreditoContext", "tarjetasCredito");
    mod.constant("parejasContext", "api/parejas");

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/tarjetasCredito/';
            $urlRouterProvider.otherwise("/tarjetasList");

            $stateProvider.state('tarjetas', {
                url: '/tarjetasCredito',
                abstract: true,
                parent: 'parejasDetailOne',
                 data: {
                    requireLogin: true,
                    roles: ['admin','pareja']
                },
                views: {
                    'childrenView': {
                        templateUrl: basePath + 'tarjetasCredito.html'
                    }
                }
            }).state('tarjetasList', {
                url: '/list/:parejaId',
                parent: 'tarjetas',
                data: {
                    requireLogin: true,
                    roles: ['admin','pareja']
                },
                param: {
                    parejaId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + 'tarjetasCredito.list.html',
                        controller: 'tarjetasCreditoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('tarjetasDetail', {
                url: '/{tarjetaId:int}',
                parent: 'tarjetasList',
                 data: {
                    requireLogin: true,
                    roles: ['admin','pareja']
                },
                param: {
                    tarjetaId: null
                },
                views: {
                    'childrenView': {
                        templateUrl: basePath + 'tarjetas.detail.html',
                        controller: 'tarjetasCreditoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('tarjetasDelete', {
                url: '/delete/{tarjetaId:int}',
                parent: 'tarjetas',
                param: {
                    tarjetaId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'delete/tarjetas.delete.html',
                        controller: 'tarjetasCreditoDeleteCtrl'
                    }
                }
            }).state('tarjetasUpdate', {
                url: '/update/{tarjetaId:int}',
                parent: 'tarjetas',
                param: {
                    tarjetaId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'update/tarjetas.update.html',
                        controller: 'tarjetasUpdateCtrl'
                    }
                }
            }).state('tarjetasCreate', {
                parent: 'tarjetas',
                views: {
                    'detailView': {
                        templateUrl: basePath + 'update/tarjetas.update.html',
                        controller: 'tarjetasNewCtrl'
                    }
                }
            });
        }]);
})(window.angular);