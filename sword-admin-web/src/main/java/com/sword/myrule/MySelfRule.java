package com.sword.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@description:自定义负载规则
 *
 *@author Sjh
 *@date 2019/1/12 12:12
 *@version 1.0.1
 */

@Configuration
public class MySelfRule
{
	@Bean
	public IRule myRule()
	{
		//return new RandomRule();// Ribbon默认是轮询，我自定义为随机
		//return new RoundRobinRule();// Ribbon默认是轮询，我自定义为随机
		
		return new com.sword.cloud.myrule.RandomRule_SJH();// 我自定义为每台机器5次
	}
}
