package co.escapeideas.springboot.example;

import java.io.IOException;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/")
public class TemplateController {

  @RequestMapping(method = RequestMethod.GET)
  public String get(Model model) {
    model.addAttribute("time", new Date());
    return "landing";
  }

  @RequestMapping(method = RequestMethod.POST)
  public String post(@RequestParam("file") final MultipartFile multiPart,
                     Model model) throws IOException {
    model.addAttribute("time", new Date());
    model.addAttribute("content", new String(multiPart.getBytes()));
    return "landing";
  }

}