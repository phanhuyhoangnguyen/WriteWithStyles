//AngularJs Script
var app = angular.module("myApp", []);
app.controller("pageCtrl", function ($scope) {

    $scope.products = availableProducts;                     // received value from managed bean on jsf page

    availableProducts = null;
    
    $scope.displayedProducts = $scope.products;

    $scope.selectedSort = 'name';

    //--------html filter elements Creation:--------
    $scope.sortByAvailableObj = {
        "Most Popular": "-sold",
        "Newest": "-dateAdded",
        "Product Name": "name",
        "Price: Low To High": "price",
        "Price: High To Low": "-price"
    };

    $scope.availableBrands = [];
    for (var item of $scope.products) {
        if (!$scope.availableBrands.includes(item.brand))
            $scope.availableBrands.push(item.brand);
    }
    $scope.availableBrands.sort(function (a, b) {
        return a.length - b.length;
    });

    $scope.availableColours = [];
    for (var item of $scope.products) {
        if (!$scope.availableColours.includes(item.colour))
            $scope.availableColours.push(item.colour);
    }

    //list is the brandsSelectedArray that defined by jsf pages
    //toggle function is responsible for adding brands to be filted
    $scope.toggle = function (item, list) {
        var idx = list.indexOf(item);
        if (idx > -1) {             //check if item is already in the list
            list.splice(idx, 1);    //if there is item, delete this item at its index - equal to uncheck
        } else {
            list.push(item);        //else if there is none item, add it to array
        }
    };

    $scope.exists = function (item, list) {
        return list.includes(item);
    };

    $scope.clearFilters = function () {
        $scope.brandsSelectedArray = [];
        $scope.sizesSelectedArray = [];
        $scope.coloursSelectedArray = [];
        $scope.gendersSelectedArray = [];
        $scope.minPrice = "";
        $scope.maxPrice = "";
    };

    $scope.clearFilters();                              // setup default values

    //--------Pagnition:--------
    $scope.productsPerPaginationPage = 12;
    $scope.currentPaginationPageIndex = 1;

    // Controller – Page Control Methods
    $scope.prevPageDisabled = function () {
        return $scope.currentPaginationPageIndex === 1 ? "disabled" : ""; //return disabled value when current page is at start
    };

    $scope.prevPage = function () {
        if ($scope.currentPaginationPageIndex > 1) {
            $scope.currentPaginationPageIndex--;
        }
    };

    $scope.pageCount = function () {
        if ($scope.products !== null) {
            return Math.ceil($scope.products.length / $scope.productsPerPaginationPage);
        } else {
            return 0;
        }
    };

    //page range according to current page: calculate each time page load
    $scope.range = function () {
        var pageIndexAvailable = [];
        var rangePageIndexSize;
        
        var paginationPagesCount = $scope.pageCount();

        rangePageIndexSize = (paginationPagesCount >= 3) ? 3 : paginationPagesCount;

        var startIndex = $scope.currentPaginationPageIndex;
        if (startIndex >= paginationPagesCount - rangePageIndexSize) {
            startIndex = paginationPagesCount - rangePageIndexSize + 1;
        }
        
        for (var i = startIndex; i <= rangePageIndexSize; i++) {
            pageIndexAvailable.push(i);
        }
        
        return pageIndexAvailable;
    };

    $scope.setPage = function (n) {
        $scope.currentPaginationPageIndex = n;
    };

    $scope.nextPageDisabled = function () {
        return $scope.currentPaginationPageIndex === $scope.pageCount() ? "disabled" : "";
    };

    $scope.nextPage = function () {
        if ($scope.currentPaginationPageIndex < $scope.pageCount()) {
            $scope.currentPaginationPageIndex++;
        }
    };
});

//return different array from the sampe source array but different start value (current page and product per page)
//when change on pagnition, it triggers change automatically on start value -> products returned is updated
app.filter("offset", function () {
    return function (input, start) {
        if (input !== null) {
            //take string and return integer with numeral system is 10
            start = parseInt(start, 10); 

            //take the rest of “input” array start from “start” index and return as new array
            return input.slice(start);
        } else
            return input;
    };
});

app.filter("checkboxFilter", function () {
    return function (productsArray, valuesSelectedArray, filterType, scope) {
        var matchedProducts = [];
        //if there is a selected brand
        if (valuesSelectedArray.length > 0) {
            productsArray.forEach(function (product) {
                var valuesInItem = product[filterType];             
                if (valuesSelectedArray.includes(valuesInItem)) {
                    matchedProducts.push(product);
                }
            });
        } else {                                //none value to be filtered, return all the products
            matchedProducts = productsArray;
        }
        
        //update to display products for paginition
        scope.displayedProducts = matchedProducts;
        
        //take the rest of “input” array start from “start” index and return as new array
        return matchedProducts;
    };
});

app.filter("rangeFilter", function () {
    return function (productsArray, startValue, endValue, scope) {
        var matchedProducts = [];
        if (startValue === "") {
            scope.minPrice = 0;
        }
        if (endValue === "" || endValue === 0 || endValue === null) {
            productsArray.forEach(function (product) {
                if (product.price >= startValue) {
                    matchedProducts.push(product);
                }
            });
        } else { //end value is empty, doesn't take part in comparision
            productsArray.forEach(function (product) {
                if (product.price >= startValue && product.price <= endValue) {
                    matchedProducts.push(product);
                }
            });
        }

        //update to display products for paginition
        scope.displayedProducts = matchedProducts;
        
        //take the rest of “input” array start from “start” index and return as new array
        return matchedProducts;
    };
});