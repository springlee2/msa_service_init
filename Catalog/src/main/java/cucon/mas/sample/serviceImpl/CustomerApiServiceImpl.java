package cucon.mas.sample.serviceImpl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import cucon.mas.sample.service.CustomerApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerApiServiceImpl implements CustomerApiService {

    private final RestTemplate restTemplate;
    @Override
    @HystrixCommand(fallbackMethod = "getCustomerDetailFallback")
    public String getCustomerDetail(String customerId) {
        return restTemplate.getForObject("http://customer/customers/" + customerId,
                String.class);
    }

    public String getCustomerDetailFallback(String customerId, Throwable ex) {
        log.info("Error Fallback :" + ex.getMessage());
        return "고객정보 조회가 지연되고 있습니다.";
    }
}
