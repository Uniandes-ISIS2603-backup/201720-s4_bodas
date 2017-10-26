(function (ng) {
    var mod = ng.module("parejasModule", ['ui.router']);
    mod.constant("parejasContext", "api/parejas");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/parejas/';
            $urlRouterProvider.otherwise("/parejasList");
            
            $stateProvider.state('parejas', {
                url: '/parejas',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'parejas.html',
                        controller: 'parejasCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('parejasList', {
                url: '/list',
                parent: 'parejas',
                 views: {
                    'listView': {
                        templateUrl: basePath + 'parejas.list.html'
                    }
                }
               }).state('parejasDetail', {
                url: '/parejas/:parejaId',
                parent: 'parejas',
                param: {
                    parejaId: null
                },
                 views: {
                    
                    'detailView': {
                        templateUrl: basePath + 'parejas.detail.html',
                        controller: 'parejasCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('cityCreate', {
                url: '/cities/create',
                views: {
                    'mainView': {
                        controller: 'citiesCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'cities.create.html'
                    }
                }
            }).state('cityEdit', {
                url: '/cities/:cityId',
                param: {
                    cityId: null
                },
                views: {
                    'mainView': {
                        controller: 'citiesCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'cities.create.html'
                    }
                }
            });
        }]);
})(window.angular);