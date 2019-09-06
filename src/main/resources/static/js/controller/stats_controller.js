App.controller('StatsController', ['$scope', '$window', '$timeout', 'StatsService', function ($scope, $window, $timeout, StatsService) {
	var self = this;
	
	if (document.getElementById('currentUser') == null) {
		self.currentIdCompany = null;
	} else {
		self.currentIdCompany = document.getElementById('currentUser').value;
	}
	
	self.calculateCompanyMacConsumption = function(device) {
		document.getElementById("stats-btn-span-" + device).classList.value = "glyphicon glyphicon-cog gly-spin";
		
		StatsService.calculateCompanyMacConsumption(device)
		.then(
				function(response) {
					document.getElementById("stats-btn-span-" + device).classList.value = "glyphicon glyphicon-hdd";
					$scope.consumptions = response;
					$scope.device = device;
					
					window.open('http://localhost:8081/nntv-control/company_mac_consumption');
					
					$window.ScopeToShare = $scope;
				},
				function(errResponse) {
					console.error('Error while calculating device consume.');
				}
		);
	};
	
	self.calculateGlobalCompanyConsumption = function() {
		document.getElementById("globalConsumption").text = "Calculando...";
		StatsService.calculateGlobalCompanyConsumption(self.currentIdCompany)
		.then(
				function(response) {
					document.getElementById("globalConsumption").text = "Consumo global";
					$scope.globalConsumptions = response;
					window.open('http://localhost:8081/nntv-control/global_company_consumption');
					$window.ScopeToShare = $scope;
				},
				function(errResponse) {
					console.error('Error while calculating global company consumption.');
				}
		);
	};
	
	self.calculateGlobalCompanyConsumptionByDateRange = function() {
		document.getElementById("filter-button").classList.value = "glyphicon glyphicon-cog gly-spin";
		
		var startDate = document.getElementById('startDate').value;
		var startTime = document.getElementById('startTime').value;
		var endDate = document.getElementById('endDate').value;
		var endTime = document.getElementById('endTime').value;
		
		var startTimestamp = startDate + ' ' + startTime + ':00';
		var endTimestamp = endDate + ' ' + endTime + ':00';
		
		StatsService.calculateGlobalCompanyConsumptionByDateRange(self.currentIdCompany, startTimestamp, endTimestamp)
		.then(
				function(response) {
					document.getElementById("filter-button").classList.value = "glyphicon glyphicon-filter";
					$scope.globalConsumptions = response;
					
					$scope.startDate = startDate;
					$scope.startTime = startTime;
					$scope.endDate = endDate;
					$scope.endTime = endTime;
										
					window.open('http://localhost:8081/nntv-control/global_company_consumption');
					
					$window.ScopeToShare = $scope;
				},
				function(errResponse) {
					console.error('Error while calculating global company consumption.');
				}
		);
	};
	
	self.calculateGlobalCompanyConsumptionByTimeSlot = function() {
		document.getElementById("filter-button").classList.value = "glyphicon glyphicon-cog gly-spin";
		
		var startTime = document.getElementById('startTime').value;
		var endTime = document.getElementById('endTime').value;
		
		StatsService.calculateGlobalCompanyConsumptionByTimeSlot(self.currentIdCompany, startTime + ':00', endTime + ':00')
		.then(
				function(response) {
					document.getElementById("filter-button").classList.value = "glyphicon glyphicon-filter";
					$scope.globalConsumptions = response;
					
					$scope.startTime = startTime;
					$scope.endTime = endTime;
										
					window.open('http://localhost:8081/nntv-control/global_company_consumption');
					
					$window.ScopeToShare = $scope;
				},
				function(errResponse) {
					console.error('Error while calculating global company consumption.');
				}
		);
	};
	
	self.calculateGlobalConsumption = function() {
		document.getElementById("globalConsumption").text = "Calculando...";
		StatsService.calculateGlobalConsumption()
		.then(
				function(response) {
					document.getElementById("globalConsumption").text = "Consumo global";
					$scope.globalConsumptions = response;
					window.open('http://localhost:8081/nntv-control/global_consumption');
					$window.ScopeToShare = $scope;
				},
				function(errResponse) {
					console.error('Error while calculating global consumption.');
				}
		);
	};
	
	self.calculateGlobalConsumptionByDateRange = function() {
		document.getElementById("filter-button").classList.value = "glyphicon glyphicon-cog gly-spin";
		
		var startDate = document.getElementById('startDate').value;
		var startTime = document.getElementById('startTime').value;
		var endDate = document.getElementById('endDate').value;
		var endTime = document.getElementById('endTime').value;
		
		var startTimestamp = startDate + ' ' + startTime + ':00';
		var endTimestamp = endDate + ' ' + endTime + ':00';
		
		StatsService.calculateGlobalConsumptionByDateRange(startTimestamp, endTimestamp)
		.then(
				function(response) {
					document.getElementById("filter-button").classList.value = "glyphicon glyphicon-filter";
					$scope.globalConsumptions = response;
					$scope.startDate = startDate;
					$scope.startTime = startTime;
					$scope.endDate = endDate;
					$scope.endTime = endTime;
					
					window.open('http://localhost:8081/nntv-control/global_consumption');
						
					$window.ScopeToShare = $scope;
				},
				function(errResponse) {
					console.error('Error while calculating global consumption.');
				}
		);
	};
	
	self.calculateGlobalConsumptionByTimeSlot = function() {
		document.getElementById("filter-button").classList.value = "glyphicon glyphicon-cog gly-spin";
		
		var startTime = document.getElementById('startTime').value;
		var endTime = document.getElementById('endTime').value;
		
		StatsService.calculateGlobalConsumptionByTimeSlot(startTime + ':00', endTime + ':00')
		.then(
				function(response) {
					document.getElementById("filter-button").classList.value = "glyphicon glyphicon-filter";
					$scope.globalConsumptions = response;
					$scope.startTime = startTime;
					$scope.endTime = endTime;
					
					window.open('http://localhost:8081/nntv-control/global_consumption');
						
					$window.ScopeToShare = $scope;
				},
				function(errResponse) {
					console.error('Error while calculating global consumption.');
				}
		);
	};
}]);