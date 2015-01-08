$(document).ready(function() {
  $('#phone-records').delegate('.remove-phone-record-btn', 'click', function() {
    $(this).parent('.controls').remove();
  });

  $('#phone-records .add-phone-record-btn').click(function() {
    Riado.Contacts.addPhoneRecord('');
  });
  
  $('#contactsForm').submit(function() {
    $(this).find('#phone-records input[type="text"].additional-phone-record').each(function() {
      if(Riado.Commons.isBlank($(this).val())) {
        $(this).attr('disabled',true);
      }
    });
    $(this).find('#selectActualDsitrict').attr('disabled',false);
    return true;
  });

  if ($('#contacts-map').size() > 0) {
    function init () {
      var addr_container = $('.addr');
      var address = addr_container.find('.postal-code').text() + ' ' + addr_container.find('.region').text() +
        addr_container.find('.locality').text() + ' ' + addr_container.find('.street-address').text();

      ymaps.geocode(address, {
        results: 1
      }).then(function(res) {
          firstGeoObject = res.geoObjects.get(0),
          // Координаты геообъекта.
            coords = firstGeoObject.geometry.getCoordinates(),
          // Область видимости геообъекта.
            bounds = firstGeoObject.properties.get('boundedBy');

          myMap = new ymaps.Map('contacts-map', {
            center: coords,
            zoom: 15,
            bounds: bounds,
            behaviors: ['default', 'scrollZoom']
          });

          myMap.geoObjects.add(firstGeoObject);

          myMap.controls
            .add('zoomControl', { left: 5, top: 5 })
            .add('typeSelector')
            .add('mapTools', { left: 35, top: 5 });

          $('a[data-toggle="tab" ][href="#contacts"]').on('shown', function (e) {
            myMap.container.fitToViewport();
            myMap.setBounds(bounds, {
              checkZoomRange: true
            });
          });
        });
    }
    ymaps.ready(init);
  }
});