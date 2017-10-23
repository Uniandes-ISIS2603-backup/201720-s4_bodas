(function (ng) {
var mod = ng.module("bodasModule", []);
    mod.constant("bodasContext", "api/bodas");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/bodas/';
            $urlRouterProvider.otherwise("/");

        }]);

})(window.angular);

