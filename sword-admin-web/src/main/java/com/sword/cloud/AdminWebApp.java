package com.sword.cloud;


import com.sword.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@EnableEurekaClient

@SpringBootApplication
@RibbonClient(name="SWORD-PROVIDER-MEMBER",configuration=MySelfRule.class)
public class AdminWebApp
{
	public static void main(String[] args)
	{
		SpringApplication.run(AdminWebApp.class, args);
	}
}
