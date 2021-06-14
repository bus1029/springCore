package hello.springCore.common

import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.stereotype.Component
import java.util.*
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
class MyLogger {
  var uuid: String = ""
  var requestURL: String = ""

  fun log(message: String) {
    println("[$uuid][$requestURL] $message")
  }

  @PostConstruct
  fun init() {
    // 절대 겹치지 않음
    uuid = UUID.randomUUID().toString()
    println("[$uuid] request scope bean created: $this")
  }

  @PreDestroy
  fun close() {
    println("[$uuid] request scope bean close: $this")
  }
}