package hello.springCore.order

import hello.springCore.discount.FixDiscountPolicy
import hello.springCore.member.MemoryMemberRepository

class OrderServiceImpl : OrderService {
  private val memberRepository = MemoryMemberRepository()
  private val discountPolicy = FixDiscountPolicy()

  override fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order? {
    val findMember = memberRepository.findById(memberId)
    findMember?.let {
      val discount = discountPolicy.discount(it, itemPrice)
      return Order(memberId, itemName, itemPrice, discount)
    }

    return null
  }
}