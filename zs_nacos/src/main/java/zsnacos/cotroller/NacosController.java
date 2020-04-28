package zsnacos.cotroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/nacos1")
public class NacosController {

    @Autowired
    private RestTemplate restTemplate;

    @ResponseBody
    @RequestMapping("/nacosDemon")
    public String getString() {
        String url = "http://zs-contract/nacos/demon";
        return restTemplate.getForObject(url, String.class);
    }

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Value("${spring.application.name}")
    private String appName;


    @GetMapping("/echo/app-name")
    public String echoAppName(){
        //Access through the combination of LoadBalanceClient and RestTemplate
        ServiceInstance serviceInstance = loadBalancerClient.choose("zs-contract");
        String path = String.format("http://%s:%s/echo/%s",serviceInstance.getHost(),serviceInstance.getPort(),appName);
        System.out.println("request path:" +path);
        return restTemplate.getForObject(path,String.class);
    }
}
