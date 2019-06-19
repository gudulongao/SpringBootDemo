package demo.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestInterceptorController {
    private static Logger log = LoggerFactory.getLogger(TestInterceptorController.class);

    @RequestMapping("/test/interceptor")
    public String testIntercept(@ModelAttribute("msg") String msg, String id) {
        log.debug("msg: " + msg + " ,id: " + id);
        return msg;
    }

    @RequestMapping("/error")
    public void error(@ModelAttribute("msg") String msg) throws Exception {
        log.debug("msg: " + msg);
        throw new Exception("a xi ba");
    }
}
