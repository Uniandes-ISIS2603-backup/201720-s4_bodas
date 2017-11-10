(function (ng) {
    var mod = ng.module("tarjetasCreditoModule", ['parejasModule', 'ui.router']);
    mod.constant("tarjetasCreditoContext", "tarjetasCredito");
    mod.constant("parejasContext", "api/parejas");
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/tarjetasCredito/';
            $urlRouterProvider.otherwise("/tarjetasList");
            
            $stateProvider.state('tarjetas',{
                url: '/tarjetasCredito',
                abstract: true,
                parent: 'parejasOneDetail',
                views: {
                    'childrenView': {
                        templateUrl: basePath + 'tarjetasCredito.html'
                    }
                }
            }).state('tarjetasList', {
                url: '/list',
                parent: 'tarjetas',
                views: {
                    'listView': {
                        templateUrl: basePath + 'tarjetasCredito.list.html',
                        controller: 'tarjetasCreditoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
                }).state('tarjetasChild', {
                url: '/:tarjetaId',
                parent: 'tarjetas',
                param: {
                    tarjetaId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'tarjetas.child.html',
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
                url: '/create',
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


