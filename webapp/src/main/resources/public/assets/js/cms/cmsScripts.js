$(document).ready(function() {
   
   var moo = $('#mooeditable');
   if(moo.size()) {
       new MooEditable('mooeditable',{
                actions: 'bold italic underline strikethrough' +
                '| justifyleft justifyright justifycenter justifyfull' +
                '| insertunorderedlist indent outdent insertHorizontalRule' +
                '| undo redo | createlink unlink | urlimage | toggleview'
            });
   }
   
   var sr = $('.short-resume');
   if(sr.size()) {
       var counter = sr.find('.short-resume-counter');
       var ta = sr.find('.short-resume-text');
       
       counter.text(400 - ta.val().length);
       ta.keyup(function() {
            var len = ta.val().length;
            if (len >= 400) {
                counter.css('color','red');
            }
            else {
                counter.css('color','black');
            }
            counter.text(400 - len);
       });
   }
});

