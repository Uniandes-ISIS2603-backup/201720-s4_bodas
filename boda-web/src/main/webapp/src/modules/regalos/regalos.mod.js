(function (ng) {
    var mod = ng.module("regalosModule", ['bodasModule', 'ui.router']);
    mod.constant("regalosContext", "regalos");
    mod.constant("bodasContext", "api/bodas");
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/regalos/';
            $urlRouterProvider.otherwise("/regalosList");

            $stateProvider.state('regalos', {
                url: '/regalos',
                abstract: true,
                parent: 'bodaDetail',
                views: {
                    childrenView: {
                        templateUrl: basePath + 'regalos.html'
                    }
                }
            }).state('regalosList', {
                url: '/list',
                parent: 'regalos',
                views: {
                    'listView': {
                        templateUrl: basePath + 'regalos.list.html',
                        controller: 'regalosCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }]);
})(window.angular);


