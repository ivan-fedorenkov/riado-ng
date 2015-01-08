$(document).ready(function() {

  /* Navigation Tabs */
  var prefix = "tab_";

  function activateTab() {
    if (Riado.Commons.isBlank(window.location.hash)) {
      $('a[data-toggle="tab"]:first').tab('show');
    } else {
      $('a[href=' + window.location.hash.replace(prefix,"") + ']').tab('show');
    }
  }

  /* Active the tab on page load */
  activateTab();

  /* Active the tab on hash change */
  $(window).on('hashchange', function() {
      activateTab();
  });

  /* Store current tab in a hash if user clicks the tab link */
  $('.navlist a[data-toggle="tab"], .navlist-side a[data-toggle="tab"]').on('click', function () {
      window.location.hash = $(this).attr('href').replace("#", "#" + prefix);
  });

  /* Set a default tabs on a page */
  $('ul.navlist, ul.navlist-side').each(function() {
    if(! $(this).children('li.active').text()) {$(this).find('a[data-toggle="tab"]:first').tab('show');}
  });

  /* Show tooltip when user clicks on inactive navigation tab link */
  $('.navlist a.inactive, .navlist-side a.inactive').click(function() {
      var tooltip = $(this).tooltip({trigger: 'manual', placement: 'right', title: "Информация отсутствует."});
      tooltip.tooltip('show');

      setTimeout(function() {
        tooltip.tooltip('destroy');
      }, 1500);
  });

  /* Hide the Alerts after a few seconds */
  if($('.alert-success').size()) {
    setTimeout(function() {
      $('.alert-success').fadeOut();
    }, 2500);
  }

  $('a[data-toggle="popover"]').popover({trigger: 'focus', delay: {hide: 400}});

  /* Wysihtml5 textareas */
  $('textarea#wysihtml5').wysihtml5({locale: "ru-RU"});
});