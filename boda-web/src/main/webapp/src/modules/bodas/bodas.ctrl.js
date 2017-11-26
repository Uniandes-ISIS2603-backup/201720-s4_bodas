
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
                let meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];
                $scope.months=meses;
            });

            if ($state.params.bodaId !== undefined) {
                $http.get(bodasContext + '/' + $state.params.bodaId).then(function (response) {
                    //$scope.regalosRecords = response.data.regalos;
                    $scope.currentBoda = response.data;
                });   
            }
            
        }]);
})(angular);
