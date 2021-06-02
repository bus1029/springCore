package hello.springCore.beanfind

import hello.springCore.member.MemberRepository
import hello.springCore.member.MemoryMemberRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.NoUniqueBeanDefinitionException
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class ApplicationContextSameBeanFindTest {
  private val ac = AnnotationConfigApplicationContext(SameBeanConfig::class.java)

  @Test
  @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면 중복 오류 발생")
  fun findBeanByTypeDuplicate() {
    Assertions.assertThrows(NoUniqueBeanDefinitionException::class.java) {
      val bean = ac.getBean(MemberRepository::class.java)
    }
  }

  @Test
  @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면 빈 이름으로 지정")
  fun findBeanByName() {
    val bean = ac.getBean("memberRepository1", MemberRepository::class.java)
    org.assertj.core.api.Assertions.assertThat(bean).isInstanceOf(MemberRepository::class.java)
  }

  @Test
  @DisplayName("특정 타입을 모두 조회")
  fun findBeanByType() {
    val beansOfType = ac.getBeansOfType(MemberRepository::class.java)
    for (key in beansOfType.keys) {
      println("key = $key value = ${beansOfType[key]}")
    }
    println("beansOfType = $beansOfType")
    org.assertj.core.api.Assertions.assertThat(beansOfType.size).isEqualTo(2)
  }

  @Configuration
  class SameBeanConfig {
    @Bean
    fun memberRepository1() = MemoryMemberRepository()

    @Bean
    fun memberRepository2() = MemoryMemberRepository()
  }
}