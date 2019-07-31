package com.hyd.mercury.common;

public class ResultResponse {
	
	private Integer code;
	private String msg;
	private Object data;
	
	public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

	public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public static ResultResponse SuccessResponse(Object data) {
		ResultResponse result = new ResultResponse();
		result.setCode(200);
		result.setMsg("ok");
        result.setData(data);
        return result;
    }
	
	public static ResultResponse ErrorResponse(Integer code) {
		ResultResponse result = new ResultResponse();
		result.setCode(code);
		result.setMsg(JsonResult.getName(code));
        return result;
	}

}
