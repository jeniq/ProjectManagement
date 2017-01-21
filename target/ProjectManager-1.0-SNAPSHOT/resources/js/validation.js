 // Валидация
$(document).ready(function() {

	$('form').submit(function(event) {
	    event.preventDefault();
	    var valEmail = $(this).find('[name="email"]').val();
	        valPass = $(this).find('[name="pass"]').val();

	    //test
	    var email = "root",
	    	pass  = "root";     

	    // подумать над регулярками
	    var reEmail = /[a-zA-Zа-яА-Я']/,
	        rePass = /[a-zA-Zа-яА-Я']/;

	    var validEmail = reEmail.test(valEmail),
	        validPass = rePass.test(valPass);

	    var isValidForm = true;
	    
	         if (!validEmail) {
	             console.log('ошибка в email!');
	             return false;
	         } else {
	         	if (!validPass) {
	             console.log('ошибка в пароле!');
	             return false;
	         } else {
	         	if( valEmail==email && valPass==pass ){
	         		location.href = '../admin.html';
	         		// window.open('../admin.html');
	         		console.log('SPS! Vse ahujenno!');
	         	}
	         	else
	         	$('#errors').removeClass('hide');
	            }
	        }  
	    });             
});

