package zqit.springsession.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	/**
	 * 部署8080端口调用
	 * @param req
	 * @param resp
	 * @return
	 */
	@GetMapping("/a")
	public String a(HttpServletRequest req, HttpServletResponse resp) {
		String sessionId = req.getSession().getId();
		return "8080-req-id: " + sessionId;
	}
	
	/**
	 * 部署8081端口调用
	 * @param req
	 * @param resp
	 * @return
	 */
	@GetMapping("/b")
	public String b(HttpServletRequest req, HttpServletResponse resp) {
		String sessionId = req.getSession().getId();
		return "8081-req-id: " + sessionId;
	}
	
}
