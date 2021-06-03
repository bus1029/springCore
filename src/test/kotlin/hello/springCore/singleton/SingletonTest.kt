package hello.springCore.singleton

import hello.springCore.AppConfig
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class SingletonTest {
  @Test
  @DisplayName("스프링 없는 순수한 DI 컨테이너")
  fun pureContainer() {
    val appConfig = AppConfig()
    // 1. 조회: 호출할 때마다 객체를 생성
    val memberService1 = appConfig.memberService()

    // 2. 조회: 호출할 때마다 객체를 생성
    val memberService2 = appConfig.memberService()

    // 참조값이 다름
    println("memberService1 = $memberService1")
    println("memberService2 = $memberService2")

    Assertions.assertThat(memberService1).isNotSameAs(memberService2)
  }

  @Test
  @DisplayName("싱글톤 패턴을 적용한 객체 사용")
  fun singletonServiceTest() {
    val singletonService1 = SingletonService.getInstance()
    val singletonService2 = SingletonService.getInstance()

    println("singletonService1 = $singletonService1")
    println("singletonService2 = $singletonService2")

    // same ==
    // equal equals()
    Assertions.assertThat(singletonService1).isSameAs(singletonService2)
  }
}