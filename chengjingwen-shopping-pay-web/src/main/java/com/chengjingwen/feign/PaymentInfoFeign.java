package com.chengjingwen.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import com.chengjingwen.service.PaymentInfoService;

@FeignClient("pay-service")
public interface PaymentInfoFeign extends PaymentInfoService{

}
