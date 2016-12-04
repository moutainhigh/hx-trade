package com.hgxh.trade.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;


public class PropertyUtils {
    private static final Logger log = LoggerFactory.getLogger(PropertyUtils.class);

    /**
     * 属性赋值
     * @param source  源实体
     * @param dest  目标实体
     * @throws Exception
     */
    public static void copy(Object source, Object dest){
        try{
        //获取属性
            BeanInfo sourceBean = Introspector.getBeanInfo(source.getClass(), Object.class);
            PropertyDescriptor[] sourceProperty = sourceBean.getPropertyDescriptors();

            BeanInfo destBean = Introspector.getBeanInfo(dest.getClass(), Object.class);
            PropertyDescriptor[] destProperty = destBean.getPropertyDescriptors();

            for(int i=0;i<sourceProperty.length;i++){
                for(int j=0;j<destProperty.length;j++){
                    if(sourceProperty[i].getName().equals(destProperty[j].getName()) && sourceProperty[i].getPropertyType().getName().equals(destProperty[j].getPropertyType().getName())){
                        //调用source的getter方法和dest的setter方法
                        destProperty[j].getWriteMethod().invoke(dest, sourceProperty[i].getReadMethod().invoke(source));
                        break;
                    }
                }
            }
        }catch(Exception e){
            log.error("属性复制失败:",e);
        }
    }

    /**
     * 检查字段值是否为空
     * @param obj  被检查的实体
     * @param checkName  需要检查的字段名称
     * @return
     */
    public static boolean checkNull(Object obj, String checkName){
        boolean flag=false;
        try {
            if (obj == null) {
                flag = true;
                return flag;
            }
            Field fields[] = obj.getClass().getDeclaredFields();
            String[] arr = checkName.split(",");
            for(int i=0;i<fields.length;i++){
                Field field=fields[i];
                field.setAccessible(true);//修改访问权限
                for(int j=0;j<arr.length;j++){
                    if(arr[j].equals(field.getName())){
                        Object vobj=field.get(obj);
                        if(null==vobj || StringUtils.isEmpty(vobj.toString())){
                            flag=true;
                        }
                    }
                }
            }
        }catch (Exception e){
            log.error("CheckPropertyNull Exception:",e);
        }
        return flag;
    }

    /**
     * 重写实体的ToString方法
     * @param obj 实体
     * @param fieldNames  不需要toString的某些字段名称
     * @return
     */
    public static String objToString(Object obj,String fieldNames){
        String str="";
        ToStringBuilder sb=new ToStringBuilder(obj);
        try{
            Field fields[] = obj.getClass().getDeclaredFields();
            String[] arr = fieldNames.split(",");
            for(int i=0;i<fields.length;i++){
                Field field=fields[i];
                field.setAccessible(true);//修改访问权限
                boolean flag=false;
                for(int j=0;j<arr.length;j++){
                    if(field.getName().equals("cardNo")) {
                        if (arr[j].equals(field.getName())) {
                            flag = true;
                            break;
                        }
                    }
                }
                if(!flag) {
                    Object vobj = field.get(obj);
                    sb.append(field.getName(),vobj);
                }
            }
            str=sb.toString();
        }catch (Exception e){
            log.error("objToString Exception:",e);
        }
        return str;
    }
}
