package com.hyd.mercury.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Success {

	class SuccessResponse {
		private final int code;
		private final String data;
		private final String msg;

		public SuccessResponse(int code) {
	        this.code = code;
	        this.data = "";
	        this.msg = "OK";
	    }

		public int getCode() {
			return code;
		}

		public String getData() {
			return data;
		}

		public String getMsg() {
			return msg;
		}
	}

	@GetMapping(value = { "/api/v2/Success" }, produces = "application/json;charset=UTF-8")
	public SuccessResponse index(@RequestParam(required = false) String data) {
		return new SuccessResponse(200);
	}

	@GetMapping(value = { "/api/v2/Success/{id}" }, produces = "application/json;charset=UTF-8")
	public SuccessResponse read(@PathVariable String id, @RequestParam(required = false) String data) {
		return new SuccessResponse(200);
	}

	@PostMapping(value = { "/api/v2/Success" }, produces = "application/json;charset=UTF-8")
	public SuccessResponse save(@RequestBody(required = false) String data) {
		return new SuccessResponse(200);
	}

	@PutMapping(value = { "/api/v2/Success/{id}" }, produces = "application/json;charset=UTF-8")
	public SuccessResponse update(@PathVariable String id, @RequestBody(required = false) String data) {
		return new SuccessResponse(200);
	}

}
