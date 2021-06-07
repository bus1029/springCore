package hello.springCore.scan

import hello.AutoAppConfig
import hello.springCore.member.MemberService
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class AutoAppConfigTest {
  @Test
  fun basicScan() {
    val ac = AnnotationConfigApplicationContext(AutoAppConfig::class.java)
    val bean = ac.getBean(MemberService::class.java)
    Assertions.assertThat(bean).isInstanceOf(MemberService::class.java)
  }
}