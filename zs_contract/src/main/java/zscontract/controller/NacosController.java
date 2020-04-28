package zscontract.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/nacos")
public class NacosController {


    @ResponseBody
    @RequestMapping("/nacosDemon")
    public String getString() {
        String url = "http://zs-contract/contract//port";
        return "hello";
    }
}
