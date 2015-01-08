/* Bootstrap tags input for professions */
$("[data-role='professions-tagsinput']").tagsinput({
    itemValue: 'id',
    itemText: 'profession',
    typeahead: {
        source: function(query) {
            return $.getJSON('/professions');
        }
    }
});