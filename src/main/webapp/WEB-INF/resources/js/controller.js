var cartApp = angular.module("cartApp",[]);

cartApp.controller("cartController", function($scope,$http){
	
	$scope.refreshCart = function(){
		$http.get("/rest/cart/"+$scope.cartId).success(function(data){
			$scope.productAdded = false;
			$scope.cart = data;
		});
	};
	
	$scope.clearCart = function(){
		$http.delete("/rest/cart/"+$scope.cartId).success($scope.refreshCart());
	};

	$scope.initCartId = function(cartId){
		$scope.cartId = cartId;
		$scope.refreshCart(cartId);
	};
	
	$scope.addProduct = function(productId){
		$http.post("/rest/cart/add/"+productId).success(function(){
			alert("Product successfully added to the cart!");
		});
	};
	
	$scope.removeFromCart = function(productId){
		$http.put("/rest/cart/remove/"+productId).success(function(){
			$scope.refreshCart();
		});
	};
	
	$scope.calGrandTotal = function(){
		var grandTotal = 0;
		
		for(var i=0;i<$scope.cart.cartItems.length;i++){
			grandTotal += $scope.cart.cartItems[i].totalPrice;
		}
		return grandTotal;
	};
});

var customerApp = angular.module("customerApp",[]);

customerApp.controller("customerAppController",function($scope,$http){
	
	$scope.refreshCustomerList = function(){
		$http.get("/rest/customer").success(function(data){
			$scope.customers = data;
		});
	};
	
	$scope.customerInit = function(){
		$scope.refreshCustomerList();
	};
	
	$scope.enableDisableCustomer = function(customerId){
		$http.put("/rest/customer/"+customerId).success(function(){
			$scope.refreshCustomerList();
		});
	};
});