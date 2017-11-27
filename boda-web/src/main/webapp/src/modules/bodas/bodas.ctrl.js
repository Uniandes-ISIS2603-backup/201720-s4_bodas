
jQuery(document).on('ready', function ($) {
    "use strict";

    /*----------------------------
        LOADING
    ------------------------------*/
$(window).load(function () {
    $(".loader").fadeOut("slow");
});

}(jQuery));

(function (ng) {
    var mod = ng.module("bodasModule");
    mod.constant("bodasContext", "api/bodas");
    mod.controller('bodasCtrl', ['$scope', '$http', 'bodasContext', '$state',
        function ($scope, $http,bodasContext, $state) {
            $http.get(bodasContext).then(function (response) {
                $scope.bodasRecords = response.data;
            });

            if ($state.params.bodaId !== undefined) {
                $http.get(bodasContext + '/' + $state.params.bodaId).then(function (response) {
                    //$scope.regalosRecords = response.data.regalos;
                    $scope.currentBoda = response.data;
                    $scope.currentFecha = $scope.currentBoda.fecha;
                });   
            }
            
        }]);
})(angular);
