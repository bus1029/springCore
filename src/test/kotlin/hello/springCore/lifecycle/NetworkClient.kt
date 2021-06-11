package hello.springCore.lifecycle

import javax.annotation.PostConstruct
import javax.annotation.PreDestroy

class NetworkClient {
  var url: String = ""

  init {
    println("생성자 호출, url = $url")
  }

  fun connect() {
    println("connect: $url")
  }

  fun call(message: String) {
    println("call = $url message = $message")
  }

  fun disconnect() {
    println("close $url")
  }

  @PostConstruct
  fun init() {
    println("NetworkClient.afterPropertiesSet")
    connect()
    call("초기화 연결 메시지")
  }

  @PreDestroy
  fun close() {
    println("NetworkClient.destroy")
    disconnect()
  }
}