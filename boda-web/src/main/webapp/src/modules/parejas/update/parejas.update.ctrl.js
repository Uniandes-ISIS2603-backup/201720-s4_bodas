(
        function (ng) {
            var mod = ng.module("parejasModule");          
            mod.constant("parejasContext", "api/parejas"); 
            mod.controller('parejaUpdateCtrl', ['$scope', '$http', 'parejasContext', '$state', '$rootScope', '$filter',
                function ($scope, $http, parejasContext, $state, $rootScope, $filter) {
                    $rootScope.edit = true;

                   
                }
            ]);
        }
)(angular);