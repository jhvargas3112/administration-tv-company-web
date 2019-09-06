'use strict';

App.factory('SubscriberAccountService', ['$rootScope', '$http', '$q', function($rootScope, $http, $q) {

	return {
		fetchAllSubscriberAccountsOfCompany: function(idCompany) {
			return $http.get('http://localhost:8081/nntv-control/accounts/' + idCompany)
			.then(
					function(response) {
						return response.data;
					},
					function(errResponse) {
						console.error('Error while fetching subscriber accounts');
						return $q.reject(errResponse);
					}
			);
		},
		
		createSubscriberAccount: function(subscriberAccount) {
			return $http({
				method: 'POST',
				url: 'http://localhost:8081/nntv-control/accounts/',
				data: subscriberAccount
			}).
			then(
					function (data, headersGetter, status) {
						var resp = data;
					}
			).catch(
					function(data, headersGetter, status){
						var err = data;
					}
			)
		},
		
		updateSubscriberAccount: function(email, subscriberAccount) {
			return $http.put('http://localhost:8081/nntv-control/accounts/' + email, subscriberAccount)
			.then(
					function(response){
						return response.data;
					}, 
					function(errResponse) {
						console.error('Error while updating subscriber account');
						return $q.reject(errResponse);
					}
			);
		},
		
		exists: function(email) {
			return $http({
				method: 'GET',
				url: 'http://localhost:8081/nntv-control/accounts/exists/' + email,
			})
			.then(
					function(response) {
						return response.data;
					}, 
					function(errResponse) {
						return errResponse.data;
					}
			);
		}
	};
}]);