/**************************************************************************************/
/**************************************** CONSTANT ************************************/
/**************************************************************************************/
var _STATUS_NAVBAR_LEFT_SWIPE = 0;
const _container_navbar_left_swipe = document.querySelectorAll('.nav-left-swipe'); 

var _STATUS_NAVBAR_PROFILE=0;
const _container_navbar_profile= document.querySelectorAll('.nav-profile'); 

/**************************************************************************************/
/***************************************** FUNCTIONS **********************************/
/**************************************************************************************/
/**
 * 
 */
function navbarLeftSwipe() {
	if (_STATUS_NAVBAR_LEFT_SWIPE == 0) {
		_container_navbar_left_swipe.forEach(nav_el => { nav_el.classList.add('visible-swipe') });
		_STATUS_NAVBAR_LEFT_SWIPE = 1;
	} else {
		_container_navbar_left_swipe.forEach(nav_el => { nav_el.classList.remove('visible-swipe') });
		_STATUS_NAVBAR_LEFT_SWIPE = 0;
	}
}

/**
 * 
 */
function navbarProfile(){
	if (_STATUS_NAVBAR_PROFILE == 0) {
		_container_navbar_profile.forEach(nav_el => { nav_el.classList.add('visible-profile') });
		_STATUS_NAVBAR_PROFILE = 1;
	} else {
		_container_navbar_profile.forEach(nav_el => { nav_el.classList.remove('visible-profile') });
		_STATUS_NAVBAR_PROFILE = 0;
	}
}

/**************************************************************************************/
/******************************************** EVENTS **********************************/
/**************************************************************************************/

$(".form-effect").find("input, textarea").on("keyup blur focus", function (e) {
	var $this = $(this),
		label = $this.prev("label");
	if (e.type === "keyup") {
		if ($this.val() === "") {
			label.removeClass("active realce");
		} else {
			label.addClass("active realce");
		}
	} else if (e.type === "blur") {
		if ($this.val() === "") {
			label.removeClass("active realce");
		} else {
			label.removeClass("realce");
		}
	} else if (e.type === "focus") {
		if ($this.val() === "") {
			label.removeClass("realce");
		}
		else if ($this.val() !== "") {
			label.addClass("realce");
		}
	}
});

/*******************************
 ********** INTERVAL *********** 
 *******************************/




