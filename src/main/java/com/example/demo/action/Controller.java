package com.example.demo.action;

import java.util.HashMap;
import java.util.Map;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.logs.ControllerLogs;
import com.example.demo.service.TestService;

/**
 * @author HouZhiBo
 * @version 创建时间：2018年10月30日 下午3:44:32
 * @ClassName 类名称
 * @Description 类描述
 */
@RequestMapping("/test")
@RestController
public class Controller {

	@Autowired
	private TestService testService;

	@PostMapping("/createURL")
	@ControllerLogs(description = "创建机器二维码图片URL")
	public Map<String, Object> createURL(@NotEmpty(message = "mno is required") String mno,
			@NotEmpty(message = "deviceid is required") String deviceid) {
		System.out.println("/*******************************************/");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key", "创建机器二维码图片URL");
		Map<String, Object> goodsSync = testService.goodsSync();
		System.out.println(goodsSync);
		return map;
	}

}
