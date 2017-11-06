(function (ng) {
    var mod = ng.module("invitadosModule", ['bodasModule', 'ui.router']);
    mod.constant("invitadosContext", "invitados");
    mod.constant("bodasContext", "api/bodas");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/invitados/';
            $urlRouterProvider.otherwise("/invitadosList");

            $stateProvider.state('invitados', {
                url: '/invitados',
                abstract: true,
                parent: 'bodaDetail',
                views: {
                    childrenView: {
                        templateUrl: basePath + 'invitados.html'
                    }
                }
            }).state('invitadosList', {
                url: '/list/{bodaId: int}',
                parent: 'invitados',
                param:{
                    bodaId:null
                },
                views: {
                    listView: {
                        templateUrl: basePath + 'invitados.list.html',
                        controller: 'invitadosCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }]);
})(window.angular);


