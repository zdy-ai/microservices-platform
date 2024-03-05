package com.example.workdemo.util;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.workdemo.model.PersonDTO;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author zdy
 * @ClassName JsonTestUtil
 * @description: TODO
 * @date 2024年02月23日
 * @version: 1.0
 */
public class JsonTestUtil implements Serializable {

    public static void main(String[] args) {
        arrayToJson();
    }

    public static void arrayToJson(){
//        JSONArray array = new JSONArray(2);
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.putOpt("1","11");
//        array.add(jsonObject);
//        JSONObject jsonObject2 = new JSONObject();
//        jsonObject2.putOpt("2","22");
//        array.add(jsonObject2);
        List<PersonDTO> personDTOList = new ArrayList<>(2);
        personDTOList.add(PersonDTO.builder().price(BigDecimal.TEN).id("111").build());
        personDTOList.add(PersonDTO.builder().price(BigDecimal.ONE).id("222").build());
        JSONArray jsonArray = JSONUtil.parseArray(personDTOList);
        System.out.println(jsonArray);
        JSONObject jsonObject = new JSONObject();
        jsonObject.putOpt("data", jsonArray);
        System.out.println(jsonObject);
        JSONUtil.toList(jsonObject.getJSONArray("data"),PersonDTO.class);
    }

    public static void boolTest(){
        Boolean a = Boolean.FALSE;
        Boolean b = Boolean.FALSE;
        Boolean c = Boolean.TRUE;
        Boolean d = null;
        System.out.println(a || b);
        System.out.println(a || c);
        System.out.println(b || c);
        System.out.println(Objects.isNull(c) || Objects.isNull(d) || (d || c));
    }


}
