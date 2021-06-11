package hello.springCore.lifecycle

import org.junit.jupiter.api.Test
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class BeanLifecycleTest {
  @Test
  fun lifeCycleTest() {
    val ac: ConfigurableApplicationContext = AnnotationConfigApplicationContext(LifeCycleConfig::class.java)
    val client = ac.getBean(NetworkClient::class.java)
    ac.close()
  }

  @Configuration
  class LifeCycleConfig {
    @Bean(initMethod = "init", destroyMethod = "close")
    fun networkClient(): NetworkClient {
      val networkClient = NetworkClient()
      // 객체 생성 후 설정이 들어올 수 있음
      networkClient.url = "http://hello-spring.dev"
      return networkClient
    }
  }
}