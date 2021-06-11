package hello.springCore.lifecycle

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

  fun init() {
    println("NetworkClient.afterPropertiesSet")
    connect()
    call("초기화 연결 메시지")
  }

  fun close() {
    println("NetworkClient.destroy")
    disconnect()
  }
}