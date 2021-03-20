package com.javaguide.forquize.TestProxy;

/**
 * @author EDZ
 * @description Test4
 * @date 2020/9/22 15:33
 */
public class Test4 {
    public static void main(String[] args) throws Exception {
        String content = "My name is {{ name }} and I am forever {{ age }}.";
        String values = "{ \"name\": \"Bill\", \"age\": 21, \"male\": true}";
//        Myanalysis(content,values);
//        analysis(content);
    }

    public static String Myanalysis(String myContent,String myValues){
        myValues = Myanalysis(myValues,  "[\"age\"]","[\"name\", \"age\"]");
        String value = getValue(myValues,"age");
        myContent = myContent.replace("{{ name }}",getValue(myValues,"name"));
        myContent = myContent.replace("{{ age }}",getValue(myValues,"age"));
        System.out.println(myContent);
        return myContent;
    }



    //根据key获取value
    public static String getValue(String payload ,String myKey){
        payload = payload.replace("{","");
        payload = payload.replace("}","");
        String payloadProxy = "";
        String[] strarr = payload.split(",");
        if(strarr.length>0){
            for(int i = 0;i<strarr.length;i++){
                String key = strarr[i].split(":")[0].replace("\"","").trim();
                String value = strarr[i].split(":")[1].replace("\"","").trim();
                if(myKey.equals(key)){
                    return value;
                }
            }
        }
        return "";
    }

    public static String Myanalysis(String payload, String requireStr, String allowStr){
        requireStr = requireStr.replace("[","").replace("\"","").trim();
        requireStr = requireStr.replace("]","").replace("\"","").trim();
        payload = payload.replace("{","");
        payload = payload.replace("}","");
        String payloadProxy = "";
        String[] strarr = payload.split(",");
        if(strarr.length>0){
            boolean flag = false;
            for(int i = 0;i<strarr.length;i++){
                String key = strarr[i].split(":")[0].replace("\"","").trim();
                String value = strarr[i].split(":")[1].replace("\"","").trim();
                if(allowStr.contains(key)){
                    payloadProxy = payloadProxy+strarr[i]+",";
                }
                //如果没有key1就报异常
                if(requireStr.equals(key)){
                    flag = true;
                }
            }
            if(!flag){
                throw new RuntimeException("缺少参数");
            }
        }
        payloadProxy = "\"{ "+payloadProxy.substring(0,payloadProxy.length()-1)+" }\"";
        return payloadProxy;
    }


}
