package co.otipc.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Petri Kainulainen
 */
@Controller
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public @ResponseBody String test() {
        LOGGER.info("Rendering hello view.");
        return "index";
    }

    @RequestMapping("/simple") public @ResponseBody String simple() {
        return "Hello world!";
    }

    @RequestMapping("/test/{name}")
    public String test(@PathVariable("name") String name, Model model) {
        model.addAttribute("name", name);
        return "test";
    }

    @RequestMapping("/offcanvas") public String offcanvas() {
        return "offcanvas";
    }

    @RequestMapping("/dashboard") public String dashboard() {
        return "dashboard";
    }

    @RequestMapping("/album") public String album() {
        return "dashboard";
    }

    @RequestMapping("/boot3") public String boot3() {
        return "boot3";
    }
}
