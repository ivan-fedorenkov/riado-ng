$(document).ready(function() {
  $('#changePasswordForm').submit(function() {
      if($('#newPassword1').val() != $('#newPassword2').val()) {
          alert('Введенные новые пароли не совпадают!');
          return false;
      }
      else {
          return true;
      }
  });
  

  var btnUpdatePhoto = $('#profile-photo-upload-btn');
  var btnDeletePhoto = $('#profile-photo-delete-btn');
  var notifications = $('#profile-photo-upload-notifications');
  var errors = $('#profile-photo-upload-errors');
  if(btnUpdatePhoto.size()) { 
    new AjaxUpload(
    btnUpdatePhoto, {  
      action: $('#photoAction').val(),  
      //Name of the file input box  
      name: 'photoFile',  
      onSubmit: function(file, ext){  
        if (!(ext && /^(jpg|png|jpeg|bmp)$/.test(ext))) {  
          // check for valid file extension  
          errors.html('<div class="alert alert-error">Разрешены только изображения (jpg,jpeg,png,bmp)</div>');  
          return false;  
        }  
        notifications.html('<div class="alert alert-info">Загрузка...</div>');
      },  
      onComplete: function(file, response) {  
        //On completion clear the status  
        errors.html('');
        notifications.html('');
        eval('obj='+response);
        //Add uploaded file to list  
        if(obj.success==="1"){  
          var newPhotoUrl = $('#photoUrlPrefix').val() + obj.name;
          $('#photo img').attr('src',newPhotoUrl);  
          notifications.html('<div class="alert alert-success">Фотография успешно обновлена.</div>');
        } 
        else {  
          errors.html('<div class="alert alert-error">'+file+' не удалось загрузить ('+obj.error+')'+'</div>');
        }
      }  
    });
  }
  if(btnDeletePhoto.size()) {
    btnDeletePhoto.click(function() {
      if(true == confirm("Вы уверены что хотите удалить фотографию?")) {
        $.ajax({
          type: "DELETE",
          data: "_method=DELETE",
          url: $('#photoAction').val(),
          success: function() {
            $('#photo img').attr('src', $('#photoUrlPrefix').val() + 'default.jpg');
            notifications.html('<div class="alert alert-success">Фотография успешно удалена.</div>');
          }
        });
      }
    })
  }
});
