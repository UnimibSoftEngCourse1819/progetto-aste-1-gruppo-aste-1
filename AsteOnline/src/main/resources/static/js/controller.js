app.controller('registerController',function($scope,$http,$location,$route)
		{
	$scope.submitUser = function()
	$http({
		method : 'POST'
		url : 'http://localhost/register/'
		data : $scope.user
	}).then(function(response)
			{
				$location.path("Tutti-gli-utenti");
				$route.reload();
			},function(errResponse){
				$scope.errorMessage = errResponse.data.errorMessage;
			});
	
		}
	$scope.resetForm = function()
	{
			$scope.user= null;
	};
});

app.controller('listUserController',function($scope,$http,$location,$route){
			$http({
				method : 'GET',
				url : 'http://localhost:8080/register/'
			}).then(function(response){
				$scope.users = response.data;
			});
			
			$scope.editUser = function(userId){
				$location.path("/update-user/" +userId);
			}
			
			$scope.deleteUser = function(userId){
				$http({
				 method : 'DELETE',  
				 url : 'http://localhost:8080/register/' + userId
				})
				
						.then(
								function(response)
								{
										$location.path("/Tutti-gli-utenti");
										$route.reload();
								});
			}		
});

app.controller('usersDetailsController',function($scope,$http, $location, $routeParams, $route){
	$scope.userId =  $routeParams.id;
	
	$http({
			method : 'GET',
			url : 'http://localhost:8080/register/' +$scope.userId
	}).then(function(response){
			$scope.use = response.data;
	});
	
	$scope.submitUserForm = function(){
			$http({
					method : 'POST'
				      url  : 'http://localhost:8080/register/',
				      data : $scope.user,
			})
			
		.then(
					function(response)
					{
						$location.path("/tutti-gli-utenti");
						$route.reload();
					},
					function(errResponse){
						$scope.errorMessage = "Errore nel aggiornamento dell'utente - Error Message: "+errResponse.data.errorMessage;
					});
	}
	
});