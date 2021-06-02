package hello.springCore

import hello.springCore.discount.RateDiscountPolicy
import hello.springCore.member.MemberService
import hello.springCore.member.MemberServiceImpl
import hello.springCore.member.MemoryMemberRepository
import hello.springCore.order.OrderService
import hello.springCore.order.OrderServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {
  @Bean
  fun memberService() = MemberServiceImpl(memberRepository())

  @Bean
  fun orderService() = OrderServiceImpl(memberRepository(), discountPolicy())

  @Bean
  fun discountPolicy() = RateDiscountPolicy()

  @Bean
  fun memberRepository() = MemoryMemberRepository()
}