var app = angular.module('myApp', []);
app.controller('myCtrl', function ($scope, $http) {
    $scope.get_review = function (v1) {
        $scope.reviewAspectList = null;
        $http.get("/rate/item/"+v1)
            .success(function (data) {
                console.log(data);
                $scope.reviewAspectList = data;
                $scope.selectedItemId = v1;
            });
    };

    $scope.postRating = function (selectedItemId,reviewAspectId) {
        $http({
            method: 'POST',
            url: "/rate",
            data: {itemId: selectedItemId, reviewAspectId: reviewAspectId, score: $scope.my_rating}
        }).success(function (data) {
            $scope.get_review(selectedItemId);
        });
    };
});