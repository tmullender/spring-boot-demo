package co.escapeideas.springboot.example;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Notice: This software is proprietary to CME, its affiliates, partners and/or licensors.  Unauthorized copying, distribution or use is strictly prohibited.  All rights reserved.
 * Created with IntelliJ IDEA.
 * User: e20856
 * Date: 21/04/2016
 * Time: 20:25
 */
@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class RESTfulController {

  private static final Logger LOG = LoggerFactory.getLogger(RESTfulController.class);

  @RequestMapping(method = RequestMethod.GET)
  public Map<String, String> get(){
    LOG.debug("get");
    return System.getenv();
  }

  @RequestMapping(method = RequestMethod.POST)
  public Map<String, String> post(@RequestParam Map<String,String> all){
    LOG.debug("post {}", all);
    return all;
  }
}
