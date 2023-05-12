package cucon.msa.sample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value="/customers")
public class CustomerController {

    @GetMapping("/{customerId}")
    public String getCustomerDetail(@PathVariable String customerId){
//        throw new RuntimeException("I/O Exception");
        log.info("request customerId :" + customerId);
        return "[Customer id =" +customerId +" at" +System.currentTimeMillis()+"]";
    }

}
