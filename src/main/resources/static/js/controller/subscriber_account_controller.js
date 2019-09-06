'use strict';

App.controller('SubscriberAccountController', ['$rootScope', '$scope', '$window', '$log', 'SubscriberAccountService', function ($rootScope, $scope, $window, $log, SubscriberAccountService) {
	var self = this;
	
	self.currentCompany = document.getElementById('currentUser').value;
	
	self.subscriberAccount = {idUser: null, type: '', subscriberType: '', email: '', description: '', password: '', city: '',
			       country: '', address: '', postalCode: '', firstName: '', lastName: '', active: true, test: false, idCompany: self.currentCompany};

	self.subscriberAccounts = [];
	
	self.fetchAllSubscriberAccountsOfCompany = function(idCompany) {
		SubscriberAccountService.fetchAllSubscriberAccountsOfCompany(idCompany)
		.then(
				function(subscriberAccounts) {
					self.subscriberAccounts = subscriberAccounts;
				},
				function(errResponse) {
					console.error('Error while fetching subscriber accounts.');
				}
		);
	};
	
	self.createSubscriberAccount = function() {
		self.subscriberAccount.idCompany = self.currentCompany;
		
		SubscriberAccountService.exists(self.subscriberAccount.email)
		.then(
				function(response) {
					if (response) {
						alert("El suscriptor " + self.subscriberAccount.email + " ya está registrado.");
					} else {
						SubscriberAccountService.createSubscriberAccount(self.subscriberAccount)
						.then(
								function(response) {
									return response.data;
								},
								function(errResponse) {
									console.error('Error while creating Subscriber account.');
								}
						);

						alert("Se ha registrado un nuevo suscriptor con email " + self.subscriberAccount.email + ".");
						$window.location.reload();
						$window.location.reload();
					}
				}
		);
	};
	
	self.updateSubscriberAccount = function() {
		SubscriberAccountService.updateSubscriberAccount(self.subscriberAccount.email, self.subscriberAccount)
		.then(
				function(errResponse) {
					console.error('Error while updating susbscriptor account.');
				}
		);
		
		alert("Se ha modificado la información del subscriptor" + self.subscriberAccount.email + ".");
		$window.location.reload();
		$window.location.reload();

	};
	
	self.edit = function(email) {
		for(var i = 0; i < self.subscriberAccounts.length; i++) {
			if (self.subscriberAccounts[i].email == email) {
				self.subscriberAccount = angular.copy(self.subscriberAccounts[i]);
				$scope.subscriberType = self.subscriberAccount.subscriberType;
				break;
			}
		}
	};
	
	self.resetCreateSubscriberAccountModal = function() {
		self.subscriberAccount.idUser = null;
		self.subscriberAccount.email = '';
		self.subscriberAccount.subscriberType = 'MOVIL'
		self.subscriberAccount.description = '';
		self.subscriberAccount.password = '';
		self.subscriberAccount.city = '';
		self.subscriberAccount.country = '';
		self.subscriberAccount.address = '';
		self.subscriberAccount.postalCode = '';
		self.subscriberAccount.firstName = '';
		self.subscriberAccount.lastName = '';
		self.subscriberAccount.active = true;
		self.subscriberAccount.test = false;
		self.subscriberAccount.idCompany = self.currentCompany;
	};
	
	self.resetUpdateSubscriberAccountModal = function() {
		self.subscriberAccount.subscriberType = $scope.subscriberType;
		self.subscriberAccount.description = '';
		self.subscriberAccount.password = '';
		self.subscriberAccount.city = '';
		self.subscriberAccount.country = '';
		self.subscriberAccount.address = '';
		self.subscriberAccount.postalCode = '';
		self.subscriberAccount.firstName = '';
		self.subscriberAccount.lastName = '';
	};
}]);
