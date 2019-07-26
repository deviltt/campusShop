package com.tt.o2o.web.superadmin;

import com.tt.o2o.entity.Area;
import com.tt.o2o.service.impl.AreaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("superadmin")
public class AreaController {
    @Autowired
    private AreaServiceImpl areaService;

    @RequestMapping(value = "listarea", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> listArea(){
        Map<String, Object> modelMap=new HashMap<>();
        List<Area> areas;
        try {
            areas=areaService.listArea();
            modelMap.put("rows", areas);
            modelMap.put("total", areas.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelMap;
    }
}
