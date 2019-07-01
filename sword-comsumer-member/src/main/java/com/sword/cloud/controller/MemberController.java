package com.sword.cloud.controller;


import com.sword.cloud.common.Result;
import com.sword.cloud.common.ResultGenerator;
import com.sword.cloud.pojo.entity.MemberInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class MemberController
{

	private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-memberInfo";

	/**
	 * 使用 使用restTemplate访问restful接口非常的简单粗暴无脑。 (url, requestMap,
	 * ResponseBean.class)这三个参数分别代表 REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
	 */
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/consumer/memberInfo/add")
	public Result add(MemberInfo memberInfo)
	{
		Boolean aBoolean = restTemplate.postForObject(REST_URL_PREFIX + "/memberInfo/add", memberInfo, Boolean.class);
		if (aBoolean) {
			return ResultGenerator.genSuccessResult();
		}
		return ResultGenerator.genFailResult("error");
	}

	@RequestMapping(value = "/consumer/memberInfo/get/{id}")
	public MemberInfo get(@PathVariable("id") Long id)
	{
		return restTemplate.getForObject(REST_URL_PREFIX + "/memberInfo/get/" + id, MemberInfo.class);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/consumer/memberInfo/list")
	public List<MemberInfo> list()
	{
		return restTemplate.getForObject(REST_URL_PREFIX + "/memberInfo/list", List.class);
	}

	// 测试@EnableDiscoveryClient,消费端可以调用服务发现
	@RequestMapping(value = "/consumer/memberInfo/discovery")
	public Object discovery()
	{
		return restTemplate.getForObject(REST_URL_PREFIX + "/memberInfo/discovery", Object.class);
	}

}
