(function (ng) {
    var mod = ng.module("pagosModule", []);
    mod.constant("pagosContext", "api/pagos");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/pagos/';
            $urlRouterProvider.otherwise("/pagosList");
            $stateProvider.state('pagosList', {
                url: '/pagos',
                views: {
                    'mainView': {
                        controller: 'pagosCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'pagos.list.html'
                    }
                }
                }).state('pagosDetail', {
                url: '/{pagoId:int}/detail',
                parent: 'pagos',
                param: {
                    pagoId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + 'pagos.list.html'
                    },
                    'detailView': {
                        templateUrl: basePath + 'pagos.detail.html',
                        controller: 'pagosCtrl',
                        controllerAs: 'ctrl'
                    }

                }
            })
            
        }]);
})(window.angular);