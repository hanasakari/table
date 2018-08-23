package cn.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.app.service.tableService;

@Controller(value = "tableController")
@Scope("prototype")
public class tableController {
    @Autowired
    public tableService tableservice;

    /**
     * 获取所有的表 可以修改dao来过滤表
     *
     * @return
     */
    public String selectAllTable() {
        JSONObject jsonObject = JSONObject.parseObject("{\"cmd\":\"selectAllTable\"}");
        jsonObject.put("touser", "self");
        jsonObject.put("selectAllTable", tableservice.selectAllTable().toString());
        return jsonObject.toJSONString();
    }

    public String createTable(String tablename, String tabledesc) {
        int a = 0;
        int b = 0;
        try {
            tableservice.createTable(tablename);
            a = 1;
        } catch (Exception e) {
            a = 0;
        }
        try {
            if (a == 1) b = tableservice.createtableDesc(tablename, tabledesc);
        } catch (Exception e) {
            b = 0;
        }

        int flag = 0;
        if (a != 0 && b != 0) flag = 1;
        JSONObject jsonObject = JSONObject.parseObject("{\"createTable\":" + flag + "}");
        jsonObject.put("touser", "self");
        jsonObject.put("cmd", "createTable");
        return jsonObject.toJSONString();
    }
}
