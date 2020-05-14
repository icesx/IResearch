/**
 * Program  : ResponseInfo.java<br/>
 * Author   : i<br/>
 * Create   : Oct 25, 2019 2:24:54 PM<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.demo.web;

public class ResponseInfo<T> extends ResponseState {

	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public ResponseInfo() {
		super();
	}

	@Override
	public String toString() {
		return "ResponseInfo [data=" + data + ", code=" + code + ", info=" + info + "]";
	}

	public ResponseInfo(int code2, String info2, T t2) {
		super(code2, info2);
		this.data = t2;
	}

	public static <T> Build<T> builder() {
		return new Build<T>();
	}

	public static class Build<T> {
		private int code;

		private String info;

		private T t2;

		public Build<T> withData(T t) {
			t2 = t;
			this.t2 = t;
			return this;
		}

		public Build<T> withCode(int code) {
			this.code = code;
			return this;
		}

		public Build<T> withInfo(String info) {
			this.info = info;
			return this;
		}

		public ResponseInfo<T> build() {
			return new ResponseInfo<T>(code, info, t2);
		}
	}

}
