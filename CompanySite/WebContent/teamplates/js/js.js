
$(document).ready(function() {
	$('input[name=firstName]').keyup(function() {
		var $this = $(this);

		if ($this.val().length <= 3) {
			$this.css('outline', '1px solid #EF4000');
			$('#firstName_error').html('Invalid first name');
			$('#createEmp').fadeOut();
		} else{
			$this.css('outline', '1px solid #34EF00');
			$('#firstName_error').html('');
			$('#createEmp').fadeIn();
		}
			
	});
	$('input[name=lastName]').keyup(function() {
		var $this = $(this);

		if ($this.val().length <= 3) {
			$this.css('outline', '1px solid #EF4000');
			$('#lastName_error').html('Invalid last name');
			$('#createEmp').fadeOut();
		} else{
			$this.css('outline', '1px solid #34EF00');
			$('#lastName_error').html('');
			$('#createEmp').fadeIn();
		}

	});
	$('input[name=email]').keyup(function() {
		var $this = $(this);

		if ($this.val().length <= 3) {
			$this.css('outline', '1px solid #EF4000');
			$('#email_error').html('Invalid email');
			$('#createEmp').fadeOut();
		} else{
			$this.css('outline', '1px solid #34EF00');
			$('#email_error').html('');
			$('#createEmp').fadeIn();
		}

	});
	$('input[name=phone]').keyup(function() {
		var $this = $(this);

		if ($this.val().length <= 10) {
			$this.css('outline', '1px solid #EF4000');
			$('#tel_error').html('Invalid first name');
			$('#createEmp').fadeOut();
		} else{
			$this.css('outline', '1px solid #34EF00');
			$('#phone_error').html('');
			$('#createEmp').fadeIn();
		}
		
	});

	$('input[name=salary]').keyup(function() {
		var $this = $(this);

		if ($this.val().length <= 2) {
			$this.css('outline', '1px solid #EF4000');
			$('#salary_error').html('Invalid salary');
			$('#createEmp').fadeOut();
		} else{
			$this.css('outline', '1px solid #34EF00');
			$('#salary_error').html('');
			$('#createEmp').fadeIn();
		}
	});
	
});