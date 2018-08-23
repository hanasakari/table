package cn.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.app.dao.tableDao;

@Service
public class tableService {
    @Autowired
    public tableDao tabledao;

    public JSONArray selectAllTable() {
        JSONArray jsonArray = JSONArray.parseArray(JSONObject.toJSONString(tabledao.selectAllTable()));

        return jsonArray;
    }

    public int createTable(String tablename) {
        return tabledao.createTable(tablename);
    }

    public int createtableDesc(String tablename, String tabledesc) {
        return tabledao.createTableDesc(tablename, tabledesc);
    }
}
