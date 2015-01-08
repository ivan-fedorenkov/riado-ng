$(document).ready(function(){
    /* Top tabs script */
    $('a.meaning').click(function(){
        $(this).prev('input[type=radio]').attr('checked','checked');
        $(this).parent().find('a').removeClass('active');
        $(this).addClass('active');
      
        return false;
    });

    $('ul.tabs').delegate('li:not(.current) a', 'click', function() {
        $(this).parent().addClass('current').siblings().removeClass('current')
        .parents('div.content').find('div.tab').hide().removeClass('active')
        .eq($(this).parent().index()).fadeIn(150).addClass('active');
        
        location.hash = $(this).parent().attr('id');
                                                                                               
    });
    
    if(location.hash) {
        var linkId = location.hash;
        var contentId = linkId + '_content';
        
        $(linkId).addClass('current');
        $(contentId).addClass('active');
    }
    else {
        $('ul.tabs').find('li:first').addClass('current');
        $('div.tab:first').addClass('active');
    }

    $('.menu li ul').css('display','none');
    $('.menu li ul').prev('a').click(function(){
        $(this).parent().find('ul').slideToggle();
        return false;
    });
    
    /* Hide control scripts */
    $('.hide-control').click(function() {
        $(this).closest('.hide').find('.hide-area').each(function () {
            $(this).fadeToggle('slow');    
        });
    });
     
    $('.hide-default').hide();
    
    var telephoneForm = $('#telephoneForm');
     
    if(telephoneForm.size()) {
    $('#addPhoneNumberButton').click(function() {
            var phone = '+' + $('#addPhoneNumberCountryCode').val() + '(' + $('#addPhoneNumberDistrictCode').val() + ')' + $('#addPhoneNumberLocalNumber').val();
            $('#telephoneList').append(
                '<div class=\"phoneRecord\">' + 
                phone +            
                '<input type=\"hidden\" name=\"phoneRecord\" value=\"' + phone + '\"/>' +
                ' <span class=\"deletePhoneNumberButton\"><a href=\"javascript:void(0);\">Удалить</a></span>'+
                '</div>');

                $('#addPhoneNumberDistrictCode').val('');
                $('#addPhoneNumberLocalNumber').val('');
        });

        $('.deletePhoneNumberButton').livequery('click', function() {
            $(this).parent('.phoneRecord').remove();
        });
    }
});