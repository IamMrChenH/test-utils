package com.kaopuyun.combine.test.model;


import java.util.List;

/**
 * @author chenh
 * @date 2020年01月06日
 */
public interface DetectionDataExportServiceMapper {
    DetectionDataExportDTO toDetectionDataExportDTO(DetectionDataExport detectionDataExport);

    DetectionDataExport fromDetectionDataExportDTO(DetectionDataExportDTO detectionDataExportDTO);

    List<DetectionDataExportDTO> toDetectionDataExportDTO(List<DetectionDataExport> content);

}