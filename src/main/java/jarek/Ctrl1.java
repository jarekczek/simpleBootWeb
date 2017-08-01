package jarek;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ctrl1 {
  @RequestMapping("/page")
  public String pageHtml()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("<html>");
    sb.append("<ol>");
    sb.append("<li>item</li>");
    sb.append("</ol>");
    sb.append("</html>");
    return sb.toString();
  }
}
