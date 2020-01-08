package com.kaopuyun.combine.test.model;

import lombok.*;

import java.util.Date;

/**
 * @author chenh
 * @date 2020年01月06日
 */
@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetectionDataExport extends Model {

    /**
     * 数据开始时间
     */
    private Date dataBeginTime;

    /**
     * 数据结束时间
     */
    private Date dataEndTime;

    /**
     * 文件类型
     */
    private String fileType;

    /**
     * oss url
     */
    private String url;

    /**
     * 描述
     */
    private String description;


}
