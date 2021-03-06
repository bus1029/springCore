package hello.springCore.web

import hello.springCore.common.MyLogger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpServletRequest

@Controller
class LogDemoController @Autowired constructor(
  private val logDemoService: LogDemoService,
  private val myLogger: MyLogger
) {
  @RequestMapping("log-demo")
  @ResponseBody
  fun logDemo(request: HttpServletRequest): String {
    val requestURL = request.requestURL.toString()
    myLogger.requestURL = requestURL

    myLogger.log("controller test")
    logDemoService.logic("testId")
    return "OK"
  }
}