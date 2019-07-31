
var FormValidation = function () {

    // basic validation
    	    var handleValidation1 = function(input_form,rules_data) {
        // for more info visit the official plugin documentation: 
            // http://docs.jquery.com/Plugins/Validation

            var form = input_form;
            var error = $('.alert-danger', form);
            var success = $('.alert-success', form);

            form.validate({
                errorElement: 'span', //default input error message container
                errorClass: 'help-block help-block-error', // default input error message class
                focusInvalid: false, // do not focus the last invalid input
                ignore: "",  // validate all fields including form hidden input
                messages: {
                    select_multi: {
                        maxlength: jQuery.validator.format("Max {0} items allowed for selection"),
                        minlength: jQuery.validator.format("At least {0} items must be selected")
                    }
                },
                rules: rules_data,

                invalidHandler: function (event, validator) { //display error alert on form submit              
                    success.hide();
                    error.show();
                    App.scrollTo(error, -200);
                },

                errorPlacement: function (error, element) { // render error placement for each input type
                    var cont = $(element).parent('.input-group');
                    if (cont.size() > 0) {
                        cont.attr('placeholder','该字段不能为空');
                        cont.addClass("invalid");
                    } else {
                        element.attr('placeholder','该字段不能为空');
                        element.addClass("invalid");
                    }
                },

                highlight: function (element) { // hightlight error inputs

                    $(element)
                        .closest('.form-group').addClass('has-error'); // set error class to the control group
                },

                unhighlight: function (element) { // revert the change done by hightlight
                    $(element)
                        .closest('.form-group').removeClass('has-error'); // set error class to the control group
                },

                success: function (label) {
                    label
                        .closest('.form-group').removeClass('has-error'); // set success class to the control group
                },

                submitHandler: function (form) {
                    success.show();
                    error.hide();
                    form.submit();
                }
            });


    }

    return {
        //main function to initiate the module
        init: function (input_form) {

            /*
            * 含有 .required span的元素 都需要进行空值验证
            */

            var rules_data= '';
            $(".required").each(function(){
                var form_control=$(this).closest(".form-group").find(".form-control")
                if(form_control.prop('disabled')==false){
                    rules_data=rules_data+"\"" + $(this).closest(".form-group").find(".form-control").prop("name") + "\"" +':{"required":true},'                   
                }
            });
            rules_data = '{' + rules_data.substring(0,rules_data.length-1) + '}';


            handleValidation1(input_form,$.parseJSON(rules_data));
            // console.log(rules_data);
        }

    };

}();

