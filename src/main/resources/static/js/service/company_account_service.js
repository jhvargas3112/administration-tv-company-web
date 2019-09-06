'use strict';

App.factory('CompanyAccountService', ['$rootScope', '$http', '$q', function($rootScope, $http, $q) {

	return {
		fetchAllCompanyAccounts: function() {
			return $http.get('http://localhost:8081/nntv-control/companies/')
			.then(
					function(response) {
						return response.data;
					},
					function(errResponse) {
						console.error('Error while fetching company accounts');
						return $q.reject(errResponse);
					}
			);
		}
	};
}]);