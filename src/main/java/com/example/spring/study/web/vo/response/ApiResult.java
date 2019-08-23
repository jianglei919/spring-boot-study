package com.houbank.paydayloan.api.result;


import com.houbank.paydayloan.api.enums.CodeEnum;

import java.io.Serializable;

public class ApiResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String version = "1.0";

    /** 错误码 */
    private String status;

    /** 错误描述信息 */
    private String message;

    /** 信审要求code 只为信审特殊处理，其它业务无视 **/
    private String code;

    /** vo 对象 */
    public T data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static <T> ApiResult<T> createResult(CodeEnum codeEnum) {

        return createResult(codeEnum.getCode(), codeEnum.getMsg());
    }
	
	public static <T> ApiResult<T> createResult(CodeEnum codeEnum,String message) {

        return createResult(codeEnum.getCode(), message);
    }

    public static <T> ApiResult<T> createResult(String status, String message) {

        ApiResult<T> result = new ApiResult<T>();
        result.setData(null);
        result.setStatus(status);
        result.setMessage(message);

        return result;
    }

    public static <T> ApiResult<T> success(T data) {
        ApiResult<T> result = new ApiResult<T>();
        result.setData(data);
        result.setStatus(CodeEnum.SUCCESS.getCode());
        result.setMessage(CodeEnum.SUCCESS.getMsg());
        return result;
    }

    public static  ApiResult success() {
        ApiResult result = new ApiResult();
        result.setData(null);
        result.setStatus(CodeEnum.SUCCESS.getCode());
        result.setMessage(CodeEnum.SUCCESS.getMsg());
        return result;
    }
}
