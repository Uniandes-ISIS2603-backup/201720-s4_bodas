(function (ng) {
    var mod = ng.module("tarjetasCreditoModule", []);
    mod.constant("tarjetasCreditoContext", "api/tarjetasCredito");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/tarjetasCredito/';
            $urlRouterProvider.otherwise("/tarjetasList");
            $stateProvider.state('tarjetasList', {
                url: '/tarjetasCredito',
                views: {
                    'mainView': {
                        controller: 'tarjetasCreditoCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'tarjetasCredito.list.html'
                    }
                }
                }).state('tarjetasDetail', {
                url: '/{tarjetaCreditoId:int}/detail',
                parent: 'tarjetasCredito',
                param: {
                    tarjetaCreditoId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + 'tarjetasCredito.list.html'
                    },
                    'detailView': {
                        templateUrl: basePath + 'tarjetasCredito.detail.html',
                        controller: 'tarjetasCreditoCtrl',
                        controllerAs: 'ctrl'
                    }

                }
            })
            
        }]);
})(window.angular);


