(function (ng) {
    var mod = ng.module("proveedoresModule", ['ui.router']);
    mod.constant("proveedoresContext", "api/proveedores");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/proveedores/';
            //var basePathProveedores = 'src/modules/proveedores/';
            $urlRouterProvider.otherwise("/proveedoresList");
            $stateProvider.state('proveedores', {
                url: '/proveedores',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'proveedores.html',
                        controller: 'proveedoresCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('proveedoresList', {
                url: '/list',
                parent: 'proveedores',
                views: {
                    'listView': {
                        templateUrl: basePath + 'proveedores.list.html'
                    }
                }
            }).state('proveedorDetail', {
                url: '/detail/{proveedorId:int}',
                parent: 'proveedores',
                param: {
                    proveedorId: null
                },
                views: {
                    
                    'detailView': {
                        templateUrl: basePath + 'proveedores.detail.html',
                        controller: 'proveedoresCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('proveedorCreate', {
                url: '/create',
                parent: 'proveedores',
                views: {
                    'detailView': {
                    templateUrl: basePath + '/new/proveedores.new.html',
                    controller: 'proveedorNewCtrl'
                    }
                }
            }).state('proveedorUpdate', {
                url: '/update/{proveedorId:int}',
                parent: 'proveedores',
                param: {
                    proveedorId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/proveedores.new.html',
                        controller: 'proveedorUpdateCtrl'
                    }
                }
            }).state('proveedorDelete', {
                url: '/delete/{proveedorId:int}',
                parent: 'proveedores',
                param: {
                    authorId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/proveedor.delete.html',
                        controller: 'proveedorDeleteCtrl'
                    }
                }
            });
        }]);
})(window.angular);