package com.team6.leangoo.util;

/**
 * 封装返回数据
 * @author czh
 * @2015年5月20日
 */
public class AjaxResult {


	private int errcode = 1;
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
