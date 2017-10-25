(function (ng) {
var mod = ng.module("bodasModule", []);
    mod.constant("bodasContext", "api/bodas");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/bodas/';
            $urlRouterProvider.otherwise("/bodasList");
            
            
            $stateProvider.state('bodas', {
                url: '/bodas',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'bodas.html',
                        controller: 'bodasCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('bodasList', {
                url: '/list',
                parent: 'bodas',
                views: {
                    'listView': {
                        templateUrl: basePath + 'bodas.list.html'
                    }
                }
     
            }).state('bodaDetail', {
                url: '/bodas/{bodaId:int}',
                parent: 'bodas',
                param: {
                    bodaId: null
                },
                views: {               
                    'detailView': {
                        templateUrl: basePath + 'bodas.detail.html',
                        controller: 'bodasCtrl', 
                        controllerAs: 'ctrl'
                    }
                }
            //}).state('bodaCreate', {
              //  url: '/bodas/create',
                //views: {
                  //  'mainView': {
                    //    controller: 'bodasCtrl',
                      //  controllerAs: 'ctrl',
                        //templateUrl: basePath + 'bodas.create.html'
                   // }
                //}

            //}).state('bodasEdit', {
              //  url: '/bodas/:bodaId',
                //param: {
                  //  bodaId: null
             //   },
               // views: {
                 //   'mainView': {
                   //     controller: 'bodasCtrl',
                     //   controllerAs: 'ctrl',
                       // templateUrl: basePath + 'bodas.create.html'
             //       }
               // }
            });
        }]);

})(window.angular);



