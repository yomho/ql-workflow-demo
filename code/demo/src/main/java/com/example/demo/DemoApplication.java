/*
 * Author：yomho
 * Email：1550438388@qq.com
 * 有bug或问题或需要定制开发，请通过邮箱联系
 */
package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import qinglian.workflow.sdk.common.utils.LicenseHelper;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example.demo", "qinglian.workflow.sdk" })
public class DemoApplication {
	static Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	
	public static void main(String[] args) {
		if (LicenseHelper.validLicense()) {
			SpringApplication.run(DemoApplication.class, args);
			logger.info("license验证通过，到期时间2024-12-31 23:59:59，到期会更新license");
		} else {
			logger.info("license验证不通过，请联系作者更新license");
		}
		logger.info("Email：1550438388@qq.com，有bug或问题或需要定制开发，请通过邮箱联系");
	}

}
