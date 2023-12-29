package com.planmagn.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(builderMethodName = "of")

public class PlanDto {
    private int planNo;
    private String planName;
    private String planType;
    private String description;
    private String eligibilityCriteria;
}
