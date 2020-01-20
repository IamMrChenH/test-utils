package com.kaopuyun.combine.test.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author chenh
 * @date 2020年01月06日
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetectionDataExportQuery {

    private Long userId;
    private Long projectId;
    private Long deviceId;
    private Date dataBeginTime;
    private Date dataEndTime;
    private String fileType;
}
