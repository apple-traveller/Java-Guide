package com.javaguide.forquize.TestThread;

/**
 * @author EDZ
 * @description CountryEnum
 * @date 2021/3/17 19:35
 */
public enum CountryEnum {
    ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕"),FOUR(4,"赵"),FIVE(5,"魏"),SIX(6,"韩");

    private Integer retCode;

    private String retMessage;

    CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public static CountryEnum foreach_countryEnum(int index){
        CountryEnum[] myArray = CountryEnum.values();
        for (CountryEnum enum2 :myArray){
            if(enum2.getRetCode()==index){
                return enum2;
            }
        }
         return null;
    }

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public String getRetMessage() {
        return retMessage;
    }

    public void setRetMessage(String retMessage) {
        this.retMessage = retMessage;
    }
}
