(function (ng) {
    var mod = ng.module("opcionesModule", ['proveedoresModule', 'ui.router']);
    mod.constant("opcionesContext", "opcionServicios");
    mod.constant("proveedoresContext", "api/proveedores");

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/opciones/';
            $urlRouterProvider.otherwise("/opcionesList");

            $stateProvider.state('opciones', {
                url: '/opciones',
                abstract: true,
                parent: 'proveedorDetail',
              views: {
                     'childrenView': {
                        templateUrl: basePath + 'opciones.html'
                    }
                
                }
            }).state('opcionesList', {
                url: '/lista',
                parent: 'opciones',
                views: {
                    'listView':{                                      
                        templateUrl: basePath + 'opciones.list.html',
                        controller: 'opcionesCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('opcionDetail', {
                url: '/:opcionId',
                parent: 'opciones',
                param: {
                    opcionId: null
                },
                views: {
                    'detailView':{
                      
                        templateUrl: basePath + 'opciones.detail.html',
                        controller: 'opcionesCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('opcionesCreate', {
                url: '/nuevo/create',
                parent: 'opciones',
                views: {
                    'detailView': {
                    templateUrl: basePath + 'new/opciones.new.html',
                    controller: 'opcionesNewCtrl'
                    }
                }
            }).state('opcionesDelete', {
                url: '/delete/:opcionId',
                parent: 'opciones',
                param: {
                    opcionId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'delete/opciones.delete.html',
                        controller: 'opcionesDeleteCtrl'
                    }
                }
            }).state('opcionesUpdate', {
                url: '/update/:opcionId',
                parent: 'opciones',
                param: {
                    opcionId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'new/opciones.new.html',
                        controller: 'opcionesUpdateCtrl'
                    }
                }
            });
        }]);
})(window.angular);



                


