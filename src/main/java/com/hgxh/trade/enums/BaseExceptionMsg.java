
package com.hgxh.trade.enums;


public enum BaseExceptionMsg {
    /**
     * 错误码命名规则：六位数字。
     * 每个子模块从001000开始扩充
     * 000000-000999 为公共异常
     * 要求全部大写，用下划线连接字母
     */
    SUCCESS("000000", "交易成功"),
    UNKNOW_ERROR("999999", "未知错误"),
    PARAM_IS_NULL("000001", "参数为空或缺少必传参数"),
    CALL_REMOTE_SERVICE_FAILED("000002", "连接接口服务异常"),


    /*	trade-service 01
     *  公共编号 010000-010099
	 */
    
    //调用外部接口错误
    ACCOUNT_NOT_EXIST("010101", "该账户不存在"),
    INVEST_EXCEPTION("010102", "购买异常"),

    NULL("Null", "reback code is not exist");

    private String code;
    private String msg;

    private BaseExceptionMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static BaseExceptionMsg getRetMsg(String code) {
        for (BaseExceptionMsg b : BaseExceptionMsg.values()) {
            if (code.equals(b.getCode())) {
                return b;
            }
        }
        return BaseExceptionMsg.NULL;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}

