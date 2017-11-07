(function (ng) {
    var mod = ng.module("opcionesModule", ['bodasModule', 'ui.router']);
    mod.constant("opcionesContext", "opciones");
    mod.constant("proveedoresContext", "api/proveedores");

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/opciones/';
            $urlRouterProvider.otherwise("/opcionesList");

            $stateProvider.state('opciones', {
                url: '/opciones',
                abstract: true,
                parent: 'proveedoresDetail',
              views: {
                     'childrenView': {
                        templateUrl: basePath + 'opciones.html'
                    }
                
                }
            }).state('opcionesList', {
                url: '/list',
                parent: 'opciones',
                views: {
                    'listView':{
                      
                        templateUrl: basePath + 'opciones.list.html',
                        controller: 'opcionesCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('opcionDetail', {
                url: '/detail/{opcionId:int}',
                parent: 'opciones',
                param: {
                    opcionId: null
                },
                views: {
                    'listView':{
                      
                        templateUrl: basePath + 'opciones.list.html',
                        controller: 'opcionesCtrl',
                        controllerAs: 'ctrl'
                    },
                    'detailView': {
                        templateUrl: basePath + 'opciones.detail.html',
                        controller: 'opcionesCtrl',
                        controllerAs: 'ctrl'
                    }
                    
                }
            }).state('opcionesCreate', {
                url: '/create',
                parent: 'opciones',
                views: {
                    'detailView': {
                    templateUrl: basePath + 'new/opciones.new.html',
                    controller: 'opcionesNewCtrl'
                    }
                }
            }).state('opcionesDelete', {
                url: '/delete/{opcionId:int}',
                parent: 'opcionDetail',
                param: {
                    opcionId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/opciones.delete.html',
                        controller: 'opcionesDeleteCtrl'
                    }
                }
            });
        }]);
})(window.angular);



                


