package hello.springCore

import hello.springCore.discount.FixDiscountPolicy
import hello.springCore.discount.RateDiscountPolicy
import hello.springCore.member.MemberService
import hello.springCore.member.MemberServiceImpl
import hello.springCore.member.MemoryMemberRepository
import hello.springCore.order.OrderService
import hello.springCore.order.OrderServiceImpl

class AppConfig {
  // Constructor Dependency Injection
  fun memberService(): MemberService {
    return MemberServiceImpl(memberRepository())
  }

  fun orderService(): OrderService {
    return OrderServiceImpl(memberRepository(), discountPolicy())
  }

  private fun discountPolicy() = RateDiscountPolicy()

  private fun memberRepository() = MemoryMemberRepository()
}