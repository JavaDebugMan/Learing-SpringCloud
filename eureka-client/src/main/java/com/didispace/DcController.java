package com.didispace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DcController {

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc() {
        String services = "Services: " + discoveryClient.getServices();
        ServiceInstance localServiceInstance = discoveryClient.getLocalServiceInstance();
        System.out.println(services + "======" + localServiceInstance.getServiceId()
                + localServiceInstance.getHost() + "-=========" + localServiceInstance.getPort());
        return services + "======" + localServiceInstance.getServiceId()
                + localServiceInstance.getHost() + "-=========" + localServiceInstance.getPort();
    }

}
