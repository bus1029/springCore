package hello.springCore.autowired.allbean

import hello.AutoAppConfig
import hello.springCore.discount.DiscountPolicy
import hello.springCore.member.Grade
import hello.springCore.member.Member
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class AllBeanTest {
  @Test
  fun findAllBean() {
    val ac =
      AnnotationConfigApplicationContext(AutoAppConfig::class.java, DiscountService::class.java)
    val discountService = ac.getBean(DiscountService::class.java)
    val member = Member(1L, "userA", Grade.VIP)
    val discountPrice = discountService.discount(member, 10000, "fixDiscountPolicy")
    Assertions.assertThat(discountService).isInstanceOf(DiscountService::class.java)
    Assertions.assertThat(discountPrice).isEqualTo(1000)

    val rateDiscountPolicy = discountService.discount(member, 20000, "rateDiscountPolicy")
    Assertions.assertThat(rateDiscountPolicy).isEqualTo(2000)
  }

  class DiscountService @Autowired constructor(
    private val policyMap: Map<String, DiscountPolicy>,
    private val policyList: List<DiscountPolicy>
  ) {
    fun discount(member: Member, money: Int, policyString: String): Int {
      val discountPolicy = policyMap[policyString]
      return discountPolicy?.discount(member, money) ?: 0
    }

    init {
      println("policyMap = ${policyMap}")
      println("policies = ${policyList}")
    }
  }
}