'use strict';

App.controller('CompanyAccountController', ['$rootScope', '$scope', '$window', '$log', 'CompanyAccountService', function ($rootScope, $scope, $window, $log, CompanyAccountService) {
	var self = this;

	self.companyAccount = {idUser: null, type: '', email: '', description: '', password: '', city: '',
			country: '', address: '', postalCode: '', firstName: '', lastName: '', active: '', idCompany: ''}; // Creo que sobra

	self.companyAccounts = [];

	self.fetchAllCompanyAccounts = function() {
		CompanyAccountService.fetchAllCompanies()
		.then(
				function(companyAccounts) {
					self.companyAccounts = companyAccounts;
				},
				function(errResponse) {
					console.error('Error while fetching company accounts.');
				}
		);
	};

}]);
