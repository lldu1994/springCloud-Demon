package zscontract.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/nacos")
public class ContractController {

    @ResponseBody
    @RequestMapping("/demon")
    public String getString() {

        return "hello World";
    }
}