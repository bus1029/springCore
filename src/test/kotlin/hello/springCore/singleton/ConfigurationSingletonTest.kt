package hello.springCore.singleton

import hello.springCore.AppConfig
import hello.springCore.member.MemberRepository
import hello.springCore.member.MemberServiceImpl
import hello.springCore.order.OrderServiceImpl
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class ConfigurationSingletonTest {
  @Test
  fun configurationTest() {
    val ac = AnnotationConfigApplicationContext(AppConfig::class.java)
    val memberService = ac.getBean(MemberServiceImpl::class.java)
    val orderService = ac.getBean(OrderServiceImpl::class.java)
    val memberRepository = ac.getBean("memberRepository", MemberRepository::class.java)

    println("memberService -> memberRepository = ${memberService.getMemberRepository()}")
    println("orderService -> memberRepository = ${orderService.getMemberRepository()}")
    println("memberRepository = $memberRepository")
  }

  @Test
  fun configurationDeep() {
    val ac = AnnotationConfigApplicationContext(AppConfig::class.java)
    val bean = ac.getBean(AppConfig::class.java)
    println("bean = $bean")
  }
}