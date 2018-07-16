
  $(document).ready(function(){
	  $('.boxgrid').hover(function(){
		  $(".boxcaption", this).stop().animate({top:'0px'},{queue:false,duration:160});
	  }, function() {
		  $(".boxcaption", this).stop().animate({top:'170px'},{queue:false,duration:160});
	  });
  });

		