(function (ng) {
var mod = ng.module("bodasModule", []);
    mod.constant("bodasContext", "api/bodas");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/bodas/';
            $urlRouterProvider.otherwise("/bodasList");
            
            $stateProvider.state('bodasList', {
                url: '/bodas',
                views: {
                    'mainView': {
                        controller: 'bodasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'bodas.list.html'
                    }
                }
               }).state('bodaDetail', {
                url: '/{bodaId:int}/detail',
                parent: 'bodas',
                param: {
                    bodaId: null
                },
                views: {               
                    'detailView': {
                        templateUrl: basePath + 'bodas.detail.html',
                        controller: 'bodaCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('bodaCreate', {
                url: '/bodas/create',
                views: {
                    'mainView': {
                        controller: 'bodasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'bodas.create.html'
                    }
                }

            }).state('bodasEdit', {
                url: '/bodas/:bodaId',
                param: {
                    bodaId: null
                },
                views: {
                    'mainView': {
                        controller: 'bodasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'bodas.create.html'
                    }
                }
            });
        }]);

})(window.angular);



