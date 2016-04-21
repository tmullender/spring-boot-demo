package co.escapeideas.springboot.example;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Notice: This software is proprietary to CME, its affiliates, partners and/or licensors.  Unauthorized copying, distribution or use is strictly prohibited.  All rights reserved.
 * Created with IntelliJ IDEA.
 * User: e20856
 * Date: 21/04/2016
 * Time: 20:25
 */
@RestController
public class RESTfulController {

  @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public Map<String, String> get(){
    return System.getenv();
  }
}
