package com.planmagn.service;

import com.planmagn.dto.PlanDto;
import com.planmagn.entities.Plan;
import com.planmagn.repositories.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class PlanService {
    @Autowired
    private PlanRepository planRepository;
    @Transactional(readOnly = false)
    public int newPlan(PlanDto planDto)
    {
        Plan plan=new Plan();
        plan.setPlanName(planDto.getPlanName());
        plan.setPlanType(planDto.getPlanType());
        plan.setDescription(planDto.getDescription());
        plan.setEligibilityCriteria(planDto.getEligibilityCriteria());

        planRepository.save(plan);
        return plan.getPlanNo();
    }
    @Transactional(readOnly = true)
    public PlanDto findPlan(int planNo)
    {
        Plan plan=planRepository.findById(planNo).get();
        return PlanDto.of()
                .planNo(plan.getPlanNo())
                .planName(plan.getPlanName())
                .planType(plan.getPlanType())
                .description(plan.getDescription())
                .eligibilityCriteria(plan.getEligibilityCriteria())
                .build();
    }
}
