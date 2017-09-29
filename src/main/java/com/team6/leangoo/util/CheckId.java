package com.team6.leangoo.util;
/*
多表插入时工具类
传入要插入检查的ID和对应的mapper
数据库没有记录返回true,否则返回false
传入参数mapper需要在spring中有注入
@autowired mapper;
 */

public class CheckId {
    public static boolean canInsert(MyMapper myMapper, Integer checkId) {
        if (myMapper.selectByPrimaryKey(checkId) == null)
            return false;
        else return true;
    }
    public static boolean canInsert(MyMapper myMapper, Integer checkId, MyMapper myMapper1, Integer checkId1) {
        if (myMapper.selectByPrimaryKey(checkId) == null) {
            System.out.println(myMapper.getClass().getName() + "---->该ID" + checkId + "不存在");
            return false;
        } else if (myMapper1.selectByPrimaryKey(checkId1) == null) {
            System.out.println(myMapper1.getClass().getName() + "---->该ID" + checkId1 + "不存在");
            return false;
        }
       else return true;
    }
}
