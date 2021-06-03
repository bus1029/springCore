package hello.springCore.beanfind

import hello.springCore.discount.DiscountPolicy
import hello.springCore.discount.FixDiscountPolicy
import hello.springCore.discount.RateDiscountPolicy
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.NoUniqueBeanDefinitionException
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class ApplicationContextExtendsFindTest {
  private val ac = AnnotationConfigApplicationContext(TestConfig::class.java)

  @Test
  @DisplayName("부모타입으로 조회 시 자식이 둘 이상 있으면 중복 오류가 발생")
  fun findBeanByParentTypeDuplicate() {
    Assertions.assertThrows(NoUniqueBeanDefinitionException::class.java) {
      ac.getBean(DiscountPolicy::class.java)
    }
  }

  @Test
  @DisplayName("부모 타입으로 조회 시 자식이 둘 이상 있으면 빈 이름을 지정하면 됨")
  fun findBeanByParentTypeBeanName() {
    val bean = ac.getBean("rateDiscountPolicy", DiscountPolicy::class.java)
    org.assertj.core.api.Assertions.assertThat(bean).isInstanceOf(RateDiscountPolicy::class.java)
  }

  @Test
  @DisplayName("특정 하위 타입으로 조회")
  fun findBeanBySubType() {
    val bean = ac.getBean(RateDiscountPolicy::class.java)
    org.assertj.core.api.Assertions.assertThat(bean).isInstanceOf(RateDiscountPolicy::class.java)
  }

  @Test
  @DisplayName("부모 타입으로 모두 조회")
  fun findAllBeanByParentType() {
    val beans = ac.getBeansOfType(DiscountPolicy::class.java)
    org.assertj.core.api.Assertions.assertThat(beans.size).isEqualTo(2)
    for (bean in beans) {
      println("bean = $bean")
    }
  }

  @Test
  @DisplayName("Object 타입으로 모두 조회")
  fun findAllBeanByObjectType() {
    val beans = ac.getBeansOfType(Any::class.java)
    for (bean in beans) {
      println("bean = $bean")
    }
  }

  @Configuration
  class TestConfig {
    @Bean
    fun rateDiscountPolicy():DiscountPolicy = RateDiscountPolicy()

    @Bean
    fun fixDiscountPolicy():DiscountPolicy = FixDiscountPolicy()
  }
}