package hello.springCore.web

import hello.springCore.common.MyLogger
import org.springframework.beans.factory.ObjectProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LogDemoService @Autowired constructor(private val myLoggerProvider: ObjectProvider<MyLogger>) {
  fun logic(id: String) {
    val myLogger = myLoggerProvider.getObject()
    myLogger.log("service id = $id")
  }
}