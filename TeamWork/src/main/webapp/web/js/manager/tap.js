$(window).mousedown(function () {
	// alert("(" + event.pageX + ", " + event.pageY + ")")
	if (window.location.pathname != "/TeamWork/web/view/manager-overview.html") {
		var x = event.pageX;
		var y = event.pageY;
		$.ajax({
			type: "POST",
			url: "/TeamWork/Manager.setHotpoint",
			data: { xy_x: x, xy_y: y },
			success: function (response) {
				//			alert(response)
			}
		});
	}
})