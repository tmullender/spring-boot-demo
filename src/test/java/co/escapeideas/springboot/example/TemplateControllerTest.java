package co.escapeideas.springboot.example;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Notice: This software is proprietary to CME, its affiliates, partners and/or licensors.  Unauthorized copying, distribution or use is strictly prohibited.  All rights reserved.
 * Created with IntelliJ IDEA.
 * User: e20856
 * Date: 25/04/2016
 * Time: 10:23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest
public class TemplateControllerTest {

  @Test
  public void testGet() throws Exception {
    final HtmlPage page = new WebClient().getPage("http://localhost:8080");
    final String time = page.getElementById("time").asText();
    assertTrue(StringUtils.isNotBlank(time));
  }

  @Test
  public void testPost() throws Exception {
    final HtmlPage page = new WebClient().getPage("http://localhost:8080");
    final HtmlForm form = page.getFormByName("upload");
    final HtmlInput file = form.getInputByName("file");
    final File upload = new File("src/test/resources/dummy.txt");
    file.setValueAttribute(upload.getAbsolutePath());
    final HtmlPage result = form.getInputByName("submit").click();
    final String content = result.getElementById("content").getTextContent();
    assertEquals(FileUtils.readFileToString(upload), StringUtils.strip(content));
  }
}