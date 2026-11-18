package com.learning.codingshuttle.hospitalManagement.dto;

import com.learning.codingshuttle.hospitalManagement.entities.type.BloodGroupType;
import lombok.Data;

@Data
public class BloodGroupStats {

    private final BloodGroupType bloodGroupType;
    private final Long count;
}
