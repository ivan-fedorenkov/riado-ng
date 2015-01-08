var Riado = {
  Commons: {
    isBlank: function(str) {
      return (!str || /^\s*$/.test(str));
    }
  },
  Contacts: {
    addPhoneRecord: function(phone) {
      $('#phone-records').append(
        "<div class='controls'>" +
          "<br />" +
          "<input type='text' name='telephoneList' class='additional-phone-record' placeholder='+7 (XXX) XXX-XX-XX' value='" + phone + "' />" +
          "&nbsp;<a class='btn btn-small remove-phone-record-btn' href='javascript:void(0);'><i class='icon-minus-sign'></i></a>" +
        "</div>"
      );
    }
  }
}