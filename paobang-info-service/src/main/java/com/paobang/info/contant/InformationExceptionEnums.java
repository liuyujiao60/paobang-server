package com.paobang.info.contant;

import com.server.core.exception.ExceptionEnums;

public enum InformationExceptionEnums implements ExceptionEnums {
    INFORMATION_PARAM_ERROR("11001","帖子信息错误，请检验后重新保存！"),
    INFORMATION_AUTHOR_EMPTY("11002","帖子作者未填写！"),
    INFORMATION_NOT_EXIST("11003","帖子不存在！"),
    INFORMATION_COLUMN_NOT_EXIST("11004","栏目不存在！"),;
	
    public String code;
    public String message;
    private  InformationExceptionEnums(String code,String message)
    {
        this.code=code;
        this.message=message;
    }
    public String getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
