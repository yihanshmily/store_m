package com.lry.store.utils;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class R<T> {
    private Boolean flag;
    private T data;
    private String msg;

    public static<T> String success(T data) {
        R<T> r = new R<>();
        r.flag = true;
        r.data = data;
        return JSON.toJSONString(r);
    }

    public static<T> String error(String msg) {
        R<T> r = new R<>();
        r.flag = false;
        r.msg = msg;
        return JSON.toJSONString(r);
    }

    //    返回语句
    public static String returnString(Integer integer) {
        if (integer>=1){
            return R.success("成功");
        }else {
            return R.error("失败");
        }
    }
}
