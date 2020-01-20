package com.kaopuyun.combine.test.model;

import lombok.Data;

import java.util.Date;

/**
 * @author chenh
 * @date 2020年01月09日
 */
@Data
public class DetectionDataExportDTO {
    private Long id;
    private String url;
    private Long fileId;
    private Long userId;
    private Long projectId;
    private Long deviceId;
    private String fileType;
    private String description;
    private Date dataBeginTime;
    private Date dataEndTime;
}
