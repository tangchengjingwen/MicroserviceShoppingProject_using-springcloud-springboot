package com.chengjingwen.load;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.unionpay.acp.sdk.SDKConfig;

@Component
public class AutoLoadRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		SDKConfig.getConfig().loadPropertiesFromSrc();
		System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作<<<<<<<<<<<<<");
	}

}
