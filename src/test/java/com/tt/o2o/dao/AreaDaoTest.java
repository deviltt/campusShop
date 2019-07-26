package com.tt.o2o.dao;

import com.tt.o2o.BasePath;
import com.tt.o2o.entity.Area;
import com.tt.o2o.service.AreaService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AreaDaoTest extends BasePath {
    @Autowired
    private AreaService areaService;

    @Test
    public void testArea() {
        List<Area> areaList = areaService.listArea();
        System.out.println(areaList);
    }
}
