(function (ng) {
    var mod = ng.module("ubicacionesModule", ['ui.router']);
    mod.constant("ubicacionesContext", "api/ubicaciones");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/ubicaciones/';
            //var basePathRegalos = 'src/modules/regalos/';
            $urlRouterProvider.otherwise("/ubicacionesList");
            $stateProvider.state('ubicaciones', {
                url: '/ubicaciones',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'ubicaciones.html',
                        controller: 'ubicacionesCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('ubicacionesList', {
                url: '/list',
                parent: 'ubicaciones',
                views: {
                    'listView': {
                        templateUrl: basePath + 'ubicaciones.list.html'
                    }
                }
            }).state('ubicacionDetail', {
                url: '/ubicaciones/{ubicacionId:int}',
                parent: 'ubicaciones',
                param: {
                    ubicacionId: null
                },
                views: {
                    
                    'detailView': {
                        templateUrl: basePath + 'ubicaciones.detail.html',
                        controller: 'ubicacionesCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('ubicacionCreate', {
                url: '/create',
                parent: 'ubicaciones',
                views: {
                    'detailView': {
                    templateUrl: basePath + '/new/ubicaciones.new.html',
                    controller: 'ubicacionNewCtrl'
                    }
                }
            }).state('ubicacionUpdate', {
                url: '/update/{ubicacionId:int}',
                parent: 'ubicaciones',
                param: {
                    ubicacionId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/ubicaciones.new.html',
                        controller: 'ubicacionUpdateCtrl'
                    }
                }
            }).state('ubicacionDelete', {
                url: '/delete/{ubicacionId:int}',
                parent: 'ubicaciones',
                param: {
                    ubicacionId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/ubicacion.delete.html',
                        controller: 'ubicacionDeleteCtrl'
                    }
                }
            });
        }]);
})(window.angular);