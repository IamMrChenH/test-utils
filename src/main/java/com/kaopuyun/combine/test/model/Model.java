package com.kaopuyun.combine.test.model;

import lombok.Data;

/**
 * @author CHENH
 * @version 1.0
 * @date 2020/01/08
 */
@Data
public class Model {
    private Long id;
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 项目id
     */
    private Long projectId;

    /**
     * 设备id
     */
    private Long deviceId;
}
