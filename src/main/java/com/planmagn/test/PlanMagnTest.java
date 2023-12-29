package com.planmagn.test;

import com.planmagn.config.RootConfig;
import com.planmagn.dto.PlanDto;
import com.planmagn.service.PlanService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PlanMagnTest {
    public static void main(String[] args)
    {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(RootConfig.class);
        PlanDto planDto= PlanDto.of()
                .planName("Risk Management Plan")
                .planType("Risk Coverage")
                .description("Plan-1")
                .eligibilityCriteria("N/A")
                .build();

        PlanService planService=applicationContext.getBean("planService",PlanService.class);
        int planNo= planService.newPlan(planDto);

        PlanDto planDto1=planService.findPlan(planNo);
        System.out.println(planDto1);
    }
}
