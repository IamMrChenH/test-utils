package com.kaopuyun.combine.test;

import com.kaopuyun.combine.test.model.DetectionDataExportServiceMapper;
import com.kaopuyun.combine.test.utils.AssertClassBuilder;

public class DemoApplication {

    public static void main(String[] args) {
        System.out.println(new AssertClassBuilder(DetectionDataExportServiceMapper.class).build());
    }


}
