'use strict';

App.controller('DeviceController', ['$rootScope', '$scope', '$window', '$log', 'DeviceService', function ($rootScope, $scope, $window, $log, DeviceService) {
	var self = this;

	self.device = {udid: null, company: '', active: '', activeDate: '', creationDate: '', test: '',
			desactivationDate: '', lastAccessDate: '', description: ''};

	self.devices = [];

	self.currentUser = document.getElementById('currentUser').value;

	self.fetchAllDevicesOfCompany = function(idCompany) {

		DeviceService.fetchAllDevicesOfCompany(idCompany)
		.then(
				function(d) {
					self.devices = d;
				},
				function(errResponse) {
					console.error('Error while fetching devices');
				}
		);
	};

	self.createDevice = function() {
		if(self.device.active == '')
			self.device.active = false;
		if(self.device.test == '')
			self.device.test = false;

		self.device.company = self.currentUser;

		DeviceService.exists(self.device.udid)
		.then(
				function(response) {
					if (response) {
						alert("La MAC " + self.device.udid + " ya está registrada.");
					} else {
						DeviceService.createDevice(self.device)
						.then(
								function(response) {
									return response.data;
								}, 
								function(errResponse) {
									console.error('Error while creating Device.');
								}	
						);

						alert("Se ha registrado un nuevo decodificador con MAC " + self.device.udid + ".");
						$window.location.reload();
						$window.location.reload();
					}
				}
		);
	};

	self.updateDevice = function() {
		if(self.device.active == '')
			self.device.active = false;
		if(self.device.test == '')
			self.device.test = false;

		DeviceService.updateDevice(self.device, self.device.udid)
		.then(
				function(errResponse) {
					console.error('Error while updating User.');
				}
		);

		alert("Se ha modificado el decodificador con MAC " + self.device.udid + ".");
		$window.location.reload();
		$window.location.reload();

	};

	self.deleteDevice = function(device) {
		DeviceService.deleteDevice(device)
		.then(
				function(errResponse){
					console.error('Error while deleting Device.');
				}	
		);

		alert("Se ha eliminado el decodificador con MAC " + device + ".");
		$window.location.reload();
		$window.location.reload();

	};

	self.edit = function(udid) {
		for(var i = 0; i < self.devices.length; i++) {
			if (self.devices[i].udid == udid) {
				self.device = angular.copy(self.devices[i]);
				break;
			}
		}
	};

	self.resetCreateDeviceModalForm = function() {
		self.device.udid = null;
		self.device.description = '';
		self.device.active = '';
		self.device.test = '';
	};

	self.resetUpdateDeviceModalForm = function() {
		self.device.description = '';
		self.device.active = '';
		self.device.test = '';
	};

}]);
