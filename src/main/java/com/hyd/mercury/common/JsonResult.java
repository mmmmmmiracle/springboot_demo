package com.hyd.mercury.common;

public enum JsonResult {
		
	JSON401("不具备请求数据的权限", 401),
	JSON899("用户名或密码错误", 899),
	JSON898("账号已停用", 898),
	JSON897("用户不存在", 897),
	JSON896("凭证过期请重新登录", 896);
	
	// 成员变量  
	private String name;  
	private int index;  
	// 构造方法  
	private JsonResult(String name, int index) {
		this.name = name;  
		this.index = index;  
	}  
	// 普通方法  
	public static String getName(int index) {  
		for (JsonResult jr : JsonResult.values()) {  
			if (jr.getIndex() == index) {  
				return jr.name;  
			}  
		}  
		return null;  
	}  
	// get set 方法  
	public String getName() {  
		return name;  
	}  
	public void setName(String name) {  
		this.name = name;  
	}  
	public int getIndex() {  
		return index;  
	}  
	public void setIndex(int index) {  
		this.index = index;  
	}  
}
