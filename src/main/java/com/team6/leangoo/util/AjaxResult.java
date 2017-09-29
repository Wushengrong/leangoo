package com.team6.leangoo.util;

/**
 * 封装返回数据
 */
public final class AjaxResult {
	public static final int ERROCODE_SUCCESS=0;//操作成功
	public static final int ERROCODE_EXITS=1;//数据已存在
	public static final int ERRCODE_NOT_EXITS=2;//数据不存在
	public static final int ERRCODE_SYSTEM_ERROR=10;//系统错误
	private int errcode = ERROCODE_SUCCESS;
	private String info = "操作成功";
	private Object data;
	
	public AjaxResult(int errcode, String info, Object data){
		this.errcode = errcode;
		this.info = info;
		this.data = data;
	}
	
	public AjaxResult(int errcode, String info){
		this.errcode = errcode;
		this.info = info;
	}
	
	public AjaxResult(Object data){
		this.info = "查询成功";
		this.data = data;
	}
	
	public AjaxResult(int errcode){
		this.errcode = errcode;
		this.info = "操作失败";
	}
	
	public AjaxResult(String info){
		this.errcode = 0;
		this.info = info;
	}
	
	public AjaxResult(){
		
	}

	public int geterrcode() {
		return errcode;
	}
	public void seterrcode(int errcode) {
		this.errcode = errcode;
	}
	public String getinfo() {
		return info;
	}
	public void setinfo(String info) {
		this.info = info;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "AjaxResult [errcode=" + errcode + ", info=" + info + ", data=" + data + "]";
	}
	
}
