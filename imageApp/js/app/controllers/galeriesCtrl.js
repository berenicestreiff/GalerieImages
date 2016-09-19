angular.module('imageApp')
	.controller('galeriesCtr', ['IMG_API',
		function(IMGAPI) {
			console.log(IMGAPI);
		}
	])