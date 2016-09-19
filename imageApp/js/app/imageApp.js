"use strict";
angular.module('imageApp', ['ngRoute'])
	.config(function($routeProvider) {
		$routeProvider
		.when('/', {
			templateUrl : "views/galeries.html",
			controller : "galeriesCtrl"
		})
		.when('galerie/:id' {
			templateUrl : "views/galerie",
			controller : "gallerieCtrl"
		})
		.oterwise({
			redirectTo : "/"
		})
	})
