package hello.springCore.lifecycle

import org.springframework.beans.factory.DisposableBean
import org.springframework.beans.factory.InitializingBean

class NetworkClient : InitializingBean, DisposableBean {
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

  // 의존관계 주입이 끝나면 호출
  override fun afterPropertiesSet() {
    println("NetworkClient.afterPropertiesSet")
    connect()
    call("초기화 연결 메시지")
  }

  override fun destroy() {
    println("NetworkClient.destroy")
    disconnect()
  }
}