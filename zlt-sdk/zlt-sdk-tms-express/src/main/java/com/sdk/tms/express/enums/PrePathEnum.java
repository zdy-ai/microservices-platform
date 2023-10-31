package com.sf.csim.express.service;

/**
 * 
 * @Description: json文件前缀路径
 * @Date: 2021/10/19 15:01
 * @Version: 1.0
 */
public enum PrePathEnum {
    EXPRESS_PATH("json\\ExpressJson\\","速运API请求参数路径"),
    EPS_PATH("json\\EPSJson\\","快递管家API请求参数路径"),
    POST_PATH("json\\POSTJson\\","驿站API请求参数路径"),
    YJT_PATH("json\\YJTJson\\","医寄通API请求参数路径"),
    FOP_PATH("json\\FOPJson\\","快运API请求参数路径"),
    HZT_PATH("json\\HZTJson\\","函证通API请求参数路径"),
    ;



    private String path;

    private String description;

    PrePathEnum(String path, String description) {
        this.path = path;
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public String getDescription() {
        return description;
    }
}
