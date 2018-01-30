package com.chengjingwen.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.chengjingwen.service.PaymentTypeService;

@FeignClient("pay-service")
public interface PaymentTypeFeign extends PaymentTypeService {

}
