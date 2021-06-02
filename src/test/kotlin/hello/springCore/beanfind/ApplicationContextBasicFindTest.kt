package hello.springCore.beanfind

import hello.springCore.AppConfig
import hello.springCore.member.MemberService
import hello.springCore.member.MemberServiceImpl
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.NoSuchBeanDefinitionException
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class ApplicationContextBasicFindTest {
  private val ac = AnnotationConfigApplicationContext(AppConfig::class.java)

  @Test
  @DisplayName("빈 이름으로 조회")
  fun findBeanByName() {
    val memberService = ac.getBean("memberService", MemberService::class.java)
    Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl::class.java)
  }
  
  @Test
  @DisplayName("이름없이 타입으로만 조회")
  fun findBeanByType() {
    val memberService = ac.getBean(MemberService::class.java)
    Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl::class.java)
  }  
  
  @Test
  @DisplayName("구체 타입으로 조회")
  fun findBeanByConcreteType() {
    val memberService = ac.getBean("memberService", MemberServiceImpl::class.java)
    Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl::class.java)
  }  
  
  @Test
  @DisplayName("빈 이름으로 조회 실패")
  fun findBeanByNameFail() {
    assertThrows(NoSuchBeanDefinitionException::class.java) {
      val memberService = ac.getBean("xxxxx", MemberService::class.java)
    }
  }
}