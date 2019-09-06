'use strict';

App.factory('DeviceService', ['$rootScope', '$http', '$q', function($rootScope, $http, $q) {

	return {
		fetchAllDevicesOfCompany: function(idCompany) {
			return $http.get('http://localhost:8081/nntv-control/devices/' + idCompany)
			.then(
					function(response) {
						return response.data;
					},
					function(errResponse) {
						console.error('Error while fetching devices');
						return $q.reject(errResponse);
					}
			);
		},
	
		createDevice: function(device) {
			return $http({
				method: 'POST',
				url: 'http://localhost:8081/nntv-control/devices/',
				data: device
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

		updateDevice: function(device, udid) {
			return $http.put('http://localhost:8081/nntv-control/devices/' + udid, device)
			.then(
					function(response){
						return response.data;
					}, 
					function(errResponse) {
						console.error('Error while updating device');
						return $q.reject(errResponse);
					}
			);
		},
		
		deleteDevice: function(udid) {
			return $http.delete('http://localhost:8081/nntv-control/devices/' + udid)
			.then(
					function(response) {
						return response.data;
					}, 
					function(errResponse) {
						console.error('Error while deleting device');
						return $q.reject(errResponse);
					}
			);
		},
		
		exists: function(udid) {
			return $http({
				method: 'GET',
				url: 'http://localhost:8081/nntv-control/devices/exists/' + udid,
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