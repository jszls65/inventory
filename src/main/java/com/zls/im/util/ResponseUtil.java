package com.zls.im.util;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class ResponseUtil
{

    // 定义响应的code
    public static enum ResponseCode
    {

        /**
         * 成功返回
         */
        OK(100),
        /**
         * 查询，新增，修改等等出错
         */
        FAIL(111),
        /**
         * 更新出错
         */
        UPDATE_ERR(101),
        /**
         * 没有找到记录
         */
        NOT_FOUND(102),
        /**
         * 记录已存在
         */
        RECORD_EXISTS(103),
        /**
         * 网站维护中
         */
        SITE_MAINTENANCE(104),
        /**
         * 未登陆
         */
        NON_LOGIN(105),
        /**
         * 没有权限
         */
        NO_PERMISSION(106),
        /**
         * 登陆超时
         */
        SESSION_TIME_OUT(107),
        /**
         * 密码错误
         */
        WRONG_PASSWORD(108),
        /**
         * 重复提交
         */
        REPEAT_SUBMIT(109),
        /**
         * 参数错误
         */
        WRONG_PARAMETER(110),
        /**
         * 数据过期需要刷新
         */
        REFRESH_DATAS(112),
        /**
         * 库存异常
         */
        STORE_EXCEPTION(113),

        /**
         * 编码长度超出范围
         */
        CODEOUTOFRANGE_EXCEPTION(114),
        /**
         * 文件格式错误
         */
        WRONG_FILE_EXCEPTION(115),
        /**
         * 文件解析时，第n行的数据解析出错
         */
        FILE_ROW_ERROR_EXCEPTION(116);

        private int code;

        private ResponseCode(int code)
        {
            this.code = code;
        }

        @Override
        public String toString()
        {
            return String.valueOf(code);
        }

        public int getCode()
        {
            return this.code;
        }

        public static ResponseCode fromCode(int code)
        {
            for (ResponseCode rc : ResponseCode.values())
            {
                if (rc.getCode() == code)
                {
                    return rc;
                }
            }
            throw new IllegalArgumentException("Invalid response code: " + code);
        }
    }

    public String responseJson(ResponseCode code)
    {
        return responseJson(code.getCode() == 100 ? "success" : "fail", code.getCode(), "", "");
    }

    /*public String responseJson(ResponseCode code)
    {
        JSONObject resp = new JSONObject();
        resp.put("result", code.getCode() == 100 ? "success" : "fail");
        resp.put("respCode", code.getCode());
        resp.put("logWeb", logWeb);
        return resp.toString();
    }*/

    public String responseJson(String result, int resCode, String msg, Object data)
    {
        JSONObject resp = new JSONObject();
        resp.put("result", result);
        resp.put("respCode", resCode);
        resp.put("message", msg);
        resp.put("data", data);
        return resp.toString();
    }

    public String responseJson(ResponseCode code, String message, Object data)
    {
        return responseJson(code.getCode() == 100 ? "success" : "fail", code.getCode(), message, data);
    }

    /**
     *
     * @param code 状态码
     * @param message 状态信息
     * @return
     * @author 卢丛越
     * @date 2016年1月11日
     */
    public String responseJson(ResponseCode code, String message)
    {
        return responseJson(code.getCode() == 100 ? "success" : "fail", code.getCode(), message, "");
    }

    public String pageList(int count, Object data)
    {
        JSONObject resp = new JSONObject();
        resp.put("result", 10);
        resp.put("respCode", 0);
        return resp.toString();
    }

    public String responseJson(String result, Object data)
    {
        return responseJson(result, 100, "", data);
    }

}
