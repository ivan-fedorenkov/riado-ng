$(document).ready(function() {
  var disqus = $("#disqus");
  if (disqus.size()) {
    var disqus_shortname = 'riado';
    var disqus_identifier = disqus.data('identifier');
    var disqus_url = 'http://www.riado.info' + disqus.data('url');
    var disqus_title = disqus.data('title');

    disqus.append(
        '<noscript>Please enable JavaScript to view the <a href="http://disqus.com/?ref_noscript">comments powered by Disqus.</a></noscript>' +
        '<a href="http://disqus.com" class="dsq-brlink">comments powered by <span class="logo-disqus">Disqus</span></a>'
    );

    (function() {
      var dsq = document.createElement('script'); dsq.type = 'text/javascript'; dsq.async = true;
      dsq.src = '//' + disqus_shortname + '.disqus.com/embed.js';
      (document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(dsq);
    })();
  }
});
