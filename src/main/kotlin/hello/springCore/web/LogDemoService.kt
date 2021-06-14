package hello.springCore.web

import hello.springCore.common.MyLogger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LogDemoService @Autowired constructor(private val myLogger: MyLogger) {
  fun logic(id: String) {
    myLogger.log("service id = $id")
  }
}