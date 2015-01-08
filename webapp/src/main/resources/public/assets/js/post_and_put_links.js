$(document).ready(function() {
  /* Links with post/put methods */
  $('a[data-method="delete"],a[data-method="put"]').click(function() {
    if(confirm($(this).data("question") || 'Вы уверены?')) {
      var f = document.createElement('form');
      $(this).after($(f).attr({
        method: 'post',
        action: $(this).attr('href')
      }).append('<input type="hidden" name="_method" value="'
              + $(this).data("method").toUpperCase()
              + '" />'));
      $(f).submit();
    }
    return false;
  });
});
