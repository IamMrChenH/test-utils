package com.kaopuyun.combine.test;

import com.kaopuyun.combine.test.model.DetectionDataExport;
import com.kaopuyun.combine.test.utils.object.ObjectUtils;

public class DemoApplication {

    public static void main(String[] args) {
        DetectionDataExport source = ObjectUtils.newInstance(DetectionDataExport.class);
        System.out.println(source);
    }

}
