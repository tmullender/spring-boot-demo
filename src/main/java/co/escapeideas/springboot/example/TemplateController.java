package co.escapeideas.springboot.example;

import java.io.IOException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/")
public class TemplateController {

  private static final Logger LOG = LoggerFactory.getLogger(TemplateController.class);

  @RequestMapping(method = RequestMethod.GET)
  public String get(Model model) {
    addTime(model);
    return "landing";
  }

  @RequestMapping(method = RequestMethod.POST)
  public String post(@RequestParam("file") final MultipartFile multiPart,
                     Model model) throws IOException {
    addTime(model);
    model.addAttribute("content", new String(multiPart.getBytes()));
    return "landing";
  }

  private void addTime(final Model model) {
    final Date time = new Date();
    LOG.debug("Adding time: {}", time);
    model.addAttribute("time", time);
  }

}