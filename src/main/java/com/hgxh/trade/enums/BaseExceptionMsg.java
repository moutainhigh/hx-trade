
package com.hgxh.trade.enums;


public enum BaseExceptionMsg {
    /**
     * 错误码命名规则：六位数字。
     * 每个子模块从001000开始扩充
     * 000000-000999 为公共异常
     * 要求全部大写，用下划线连接字母
     */
    SUCCESS("000000", "trade is succeed"),
    NUKNOW_ERROR("999999", "unknow error"),
    PARAM_IS_NULL("000001", "param is null"),
    CALL_REMOTE_SERVICE_FAILED("000002", "call remote service is failed"),


    /*	trade-service 01
     *  公共编号 010000-010099
	 */

    //核心交易
    USER_NOT_EXIST("010401", "用户不存在"),
    BID_NOT_EXIST("010402", "标的不存在"),
    USER_STATUS_EXCEPTION("010403", "用户状态不正确"),
    BUY_SHARE_EXCEPTION("010404", "购买份额必须是标的最小购买份额的整数倍"),
    BID_NOT_PUBLISHED("1010405", "标的状态不是已发布"),
    BID_STATUS_NOT_SUCCEED("010406", "标的状态不是募集完成"),
    INVEST_EXCEPTION("0104107", "原始购买异常"),
    SEND_NOTICE_EXCEPTION("010408", "发送消息异常"),
    BID_SHARE_ZERO("010409", "标的所剩份额为零"),
    BUY_SHARE_BEYOND_MAX("010410", "超过标的最大购买份额"),

    USER_NOT_FOUND("010001", "查找不到用户"),
    USER_NOT_AUTHED("010002", "用户不是实名认证"),
    USER_NOT_BINDED("010003", "用户未绑定银行卡"),
    CUSTOMER_CREATE_ERROR("010004", "用户创建商户账户失败"),

    ORDER_NOT_FOUND("010101", "订单未找到"),
    ORDER_STATUS_WRONG("010103", "订单状态异常"),
    ORDER_DATA_WRONG("010104", "订单数据异常"),

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

