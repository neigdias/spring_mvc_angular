var app = angular.module('app', []);

// Controller principal
app.controller('MyCtrl', function($scope, $http){

	$scope.teste = function(pesquisa){
			$http({url: '/greeting',
				   method: "GET",
				   params: {"name" : pesquisa}}).
	        success(function(data) {
				// JSON retornado do banco
				$scope.dicas = data;     
	        }).
	        error(function(data) {
				console.log("Ocorreu um erro no banco de dados ao trazer auto-ajuda da home");
	        });		
	};
  };
});