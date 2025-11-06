package com.oswizar.io.sample.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class TimeValue {

    String time;
    BigDecimal dataVal;

}
