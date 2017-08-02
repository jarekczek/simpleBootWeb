package jarek;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ctrl1 {
  @RequestMapping(value = "/page", produces = MediaType.TEXT_HTML_VALUE)
  public String pageHtml()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("<html>");
    sb.append("<script>");
    sb.append("var onLoad = function() {");
    sb.append("  var dest = document.getElementById('idList');");
    sb.append("  dest.innerHTML = 'wait';");
    sb.append("  var r = new XMLHttpRequest();");
    sb.append("  r.open('GET', '/page', false);");
    sb.append("  r.setRequestHeader('Accept', 'text/plain');");
    sb.append("  r.send();");
    sb.append("  dest.innerHTML = r.responseText;");
    sb.append("};");
    sb.append("</script>");
    sb.append("<body onload='onLoad()'>");
    sb.append("<ol id='idList'>");
    sb.append("<li>item</li>");
    sb.append("</ol>");
    sb.append("<a href='/stop'>stop</a>");
    sb.append("</body>");
    sb.append("</html>");

    return sb.toString();
  }

  @RequestMapping(value = "/page", produces = MediaType.TEXT_PLAIN_VALUE)
  public String pageText()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("item\n");
    return sb.toString();
  }

  @RequestMapping(
    value = "/page", produces = MediaType.APPLICATION_XML_VALUE)
  public String pageXml()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("<items><item>Jeden</item></items>");
    return sb.toString();
  }
}
