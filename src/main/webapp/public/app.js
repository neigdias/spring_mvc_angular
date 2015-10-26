var app = angular.module('app', []);

// Controller principal
app.controller('MyCtrl', function($scope, $http){

		$scope.pesq = function(pesquisa){
			$http({url: '/produtos',
				   method: "GET",
			       params: {"name" : pesquisa}
				  }
			).
		    success(function(data) {
				$scope.produtos = data;     
		    }).
		    error(function(data) {
				console.log("Ocorreu um erro ao trazer os produtos");
		    });		
		};
  }
);