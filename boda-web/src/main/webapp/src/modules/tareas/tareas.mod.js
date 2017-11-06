(function (ng) {
    var mod = ng.module("tareasModule", ['bodasModule', 'ui.router']);
    mod.constant("tareasContext", "tareas");
    mod.constant("bodasContext", "api/bodas");

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/tareas/';
            $urlRouterProvider.otherwise("/tareasList");

            $stateProvider.state('tareas', {
                url: '/tareas',
                abstract: true,
                parent: 'bodaDetail',
              views: {
                     'childrenView': {
                        templateUrl: basePath + 'tareas.html'
                    }
                
                }
            }).state('tareasList', {
                url: '/list',
                parent: 'tareas',
                views: {
                    'listView':{
                      
                        templateUrl: basePath + 'tareas.list.html',
                        controller: 'tareasCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('tareaDetail', {
                url: '/detail/{tareaId:int}',
                parent: 'tareas',
                param: {
                    tareaId: null
                },
                views: {
                    'listView':{
                      
                        templateUrl: basePath + 'tareas.list.html',
                        controller: 'tareasCtrl',
                        controllerAs: 'ctrl'
                    },
                    'detailView': {
                        templateUrl: basePath + 'tareas.detail.html',
                        controller: 'tareasCtrl',
                        controllerAs: 'ctrl'
                    }
                    
                }
            });
        }]);
})(window.angular);



                
