package com.eshop.generator.controller;

import com.eshop.generator.utils.ActionResult;
import com.eshop.generator.utils.PageUtils;
import com.eshop.generator.utils.Query;
import com.eshop.generator.service.SysGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 代码生成器
 *
 */
@Controller
@RequestMapping("/sys/generator")
public class SysGeneratorController {

    @Autowired
    private SysGeneratorService sysGeneratorService;

    /**
     * 列表
     */
    @ResponseBody
    @RequestMapping("/list")
    public ActionResult list(@RequestParam Map<String, Object> params) {
        PageUtils pageUtil = sysGeneratorService.queryList(new Query(params));

        return ActionResult.ok().put("page", pageUtil);
    }

    /**
     * 生成代码
     */
    @RequestMapping("/code")
    @ResponseBody
    public Map<String, Object> code(String tables) {
        Map<String, Object> map = new HashMap<>();
        boolean bool = sysGeneratorService.generatorCode(tables.split(","));
        if (bool) {
            map.put("result", true);
            map.put("msg", "生成成功");
        } else {
            map.put("result", false);
            map.put("msg", "生成失败");
        }
        return map;
    }
}
