package com.sky.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderReportVO implements Serializable {
    private String dateList;
    private String orderCountList;
    private String validOrderCountList;
    private Integer totalOrderCount;
    private Integer validOrderCount;
    private Double orderCompletionRate;
}
