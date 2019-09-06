'use strict';

App.factory('StatsService', ['$http', '$q', function($http, $q) {

	return {
		calculateCompanyMacConsumption: function(device) {
			return $http({
				method: 'GET',
				url: 'http://localhost:8082/api/device/channels_consumption/' + device
			})
			.then(
					function(response) {
						return response.data;
					}, 
					function(errResponse) {
						console.error('Error while calculating device consume.');
						return $q.reject(errResponse);
					}
			);
		},
		
		calculateGlobalCompanyConsumption: function(idCompany) {
			return $http({
				method: 'GET',
				url: 'http://localhost:8082/api/device/global_company_consumption/' + idCompany
			})
			.then(
					function(response) {
						return response.data;
					}, 
					function(errResponse) {
						console.error('Error while calculating global company consumption.');
						return $q.reject(errResponse);
					}
			);
		},
		
		calculateGlobalCompanyConsumptionByDateRange: function(idCompany, startTimestamp, endTimestamp) {
			return $http({
				method: 'GET',
				url: 'http://localhost:8082/api/device/global_company_consumption_by_date_range/' + idCompany + '/' + startTimestamp + '/' + endTimestamp
			})
			.then(
					function(response) {
						return response.data;
					}, 
					function(errResponse) {
						console.error('Error while calculating global company consumption.');
						return $q.reject(errResponse);
					}
			);
		},
		
		calculateGlobalCompanyConsumptionByTimeSlot: function(idCompany, startTime, endTime) {
			return $http({
				method: 'GET',
				url: 'http://localhost:8082/api/device/global_company_consumption_by_time_slot/' + idCompany + '/' + startTime + '/' + endTime
			})
			.then(
					function(response) {
						return response.data;
					}, 
					function(errResponse) {
						console.error('Error while calculating global company consumption by time slot.');
						return $q.reject(errResponse);
					}
			);
		},
		
		calculateGlobalConsumption: function() {
			return $http({
				method: 'GET',
				url: 'http://localhost:8082/api/device/global_consumption'
			})
			.then(
					function(response) {
						return response.data;
					}, 
					function(errResponse) {
						console.error('Error while calculating global consumption.');
						return $q.reject(errResponse);
					}
			);
		},
		
		calculateGlobalConsumptionByDateRange: function(startTimestamp, endTimestamp) {
			return $http({
				method: 'GET',
				url: 'http://localhost:8082/api/device/global_consumption_by_date_range/' + startTimestamp + '/' + endTimestamp
			})
			.then(
					function(response) {
						return response.data;
					}, 
					function(errResponse) {
						console.error('Error while calculating global consumption by date range.');
						return $q.reject(errResponse);
					}
			);
		},
		
		calculateGlobalConsumptionByTimeSlot: function(startTimestamp, endTimestamp) {
			return $http({
				method: 'GET',
				url: 'http://localhost:8082/api/device/global_consumption_by_time_slot/' + startTimestamp + '/' + endTimestamp
			})
			.then(
					function(response) {
						return response.data;
					}, 
					function(errResponse) {
						console.error('Error while calculating global consumption by date range.');
						return $q.reject(errResponse);
					}
			);
		}
	};
}]);