package hello.springCore.singleton

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class StatefulServiceTest {
  @Test
  fun statefulServiceSingleton() {
    val ac = AnnotationConfigApplicationContext(TestConfig::class.java)
    val bean1 = ac.getBean(StatefulService::class.java)
    val bean2 = ac.getBean(StatefulService::class.java)

    // ThreadA
    bean1.order("userA", 10000)
    // ThreadB
    bean2.order("userB", 20000)

    // ThreadA: 사용자A 주문 금액 조회
    val price = bean1.getPrice()
    println("price = $price")
    Assertions.assertThat(bean1.getPrice()).isEqualTo(20000)
  }

  @Configuration
  class TestConfig {
    @Bean
    fun statefulService() = StatefulService()
  }
}