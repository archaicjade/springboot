package com.bigball.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/*@Controller
public class HelloController {


    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say() {
//        return girlProperties.getCupSize();

        return "index";
    }
}*/


@RestController
@RequestMapping("/hello")
public class HelloController {


    @Autowired
    private GirlProperties girlProperties;

    @Value("${content}")
    private String content;

    @RequestMapping(value = "/{id}/say", method = RequestMethod.GET)
    public String say(@PathVariable("id") Integer id) {
//        return girlProperties.getCupSize();
        return "id:" +
                id;
    }

    //    @RequestMapping(value = "/say2", method = RequestMethod.GET)
    @GetMapping(value = "/say2")
    public String sayFromParams(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {

        return "id:" +
                id;
    }

    @GetMapping(value = "/cc")
    public String comboConfig() {
        return content;
    }
}