package com.sword.cloud.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发送短信验证码
 */
public class SendMsgServer {

	private static final Logger logger = LoggerFactory.getLogger(SendMsgServer.class);


	public static String SendMsg(String messageStr, String phoneNum) {
		//TODO
		logger.debug("发送信息成功");
		return "ok";
	}

}
