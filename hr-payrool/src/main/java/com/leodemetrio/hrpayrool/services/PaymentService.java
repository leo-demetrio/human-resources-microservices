package com.leodemetrio.hrpayrool.services;

import com.leodemetrio.hrpayrool.entities.Worker;
import com.leodemetrio.hrpayrool.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.leodemetrio.hrpayrool.entities.Payment;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {


    private final WorkerFeignClient workerFeignClient;
    public PaymentService(WorkerFeignClient workerFeignClient){
        this.workerFeignClient = workerFeignClient;
    }
    public Payment getPayment(long workerId, int days){

        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
