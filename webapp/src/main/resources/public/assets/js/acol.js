$(document).ready(function() {
  if($('.chamber-block .chamber-name').text().length < 34) {
    $('.chamber-block .chamber-name').addClass('chamber-name-pulled-down')
  }
});