$(document).ready(function() {
    var attachments_table = $('#feedback-attachments-table');

    if  (attachments_table.size()) {

        var attachments_table=$('#feedback-attachments-table');
        var upload_button = $('#feedback-attachments-upload-btn');
        var upload_status = $('#feedback-attachments-status');

        var attachments_table_tbody = $('#feedback-attachments-table tbody');
        var action = attachments_table.data('upload-action');
        var editor_key = attachments_table.data('editor-key');

        function setStatusError(error) {
            upload_status.html('<div class="alert alert-error">' + error + '</div>');
        }

        function setStatusSuccess(notification) {
            upload_status.html('<div class="alert alert-success">' + notification + '</div>');
        }

        function refreshAttachmentsTableVisibility() {
            if (attachments_table_tbody.children('tr').size()) {
              document.getElementById('feedback-attachments-table').style.display="";
            } else {
              document.getElementById('feedback-attachments-table').style.display="none";
            }
        }

        new AjaxUpload(upload_button, {
            action: action + '?editorKey=' + editor_key,
            //Name of the file input box  
            name: 'attachment',
            onSubmit: function(file, ext){
                if (! (ext && /^(jpg|png|jpeg|bmp)$/.test(ext))){  
                    // check for valid file extension  
                    setStatusError('Разрешены только изображения (jpg,jpeg,png,bmp)');
                    return false;  
                }  
                upload_status.text('загрузка...');
            },  
            onComplete: function(file, response){  
                //On completion clear the status  
                upload_status.html('');
                //Add uploaded file to list
                eval ('attachment=' + response);
                if(attachment.success=="1"){
                    setStatusSuccess("Файл успешно загружен.")
                    $('<tr></tr>').appendTo(attachments_table_tbody).html(
                        '<td>' + attachment.name + '</td>' +
                        '<td>' + attachment.size + '</td>' +
                        '<td>' + attachment.creation_date + '</td>' +
                        '<td>' + '<a href="javascript:void(0);" class="btn btn-small btn-danger feedback-attachments-remove-btn" data-attachment-id="' + attachment.id +  '">Удалить</a>' + '</td>');

                    refreshAttachmentsTableVisibility();
                } else{
                  setStatusError(file + ' не удалось загрузить (' + attachment.error + ')');
                }
            }  
        });

        attachments_table_tbody.on('click', '.feedback-attachments-remove-btn', function(){
            var buttonClicked = $(this);
            if(confirm($(this).data("question") || 'Вы уверены?')) {
                $.ajax({
                   url: action + '/' + $(this).data('attachment-id') + '?editorKey=' + editor_key,
                   type: "delete",
                   data: {_method: "delete"}
                }).done(function() {
                  buttonClicked.parents('tr').remove();
                  setStatusSuccess("Файл успешно удалён.");
                  refreshAttachmentsTableVisibility();
                });
            }
            return false;
        });
    }
});