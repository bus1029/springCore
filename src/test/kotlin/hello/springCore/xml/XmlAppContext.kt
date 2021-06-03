package hello.springCore.xml

import hello.springCore.member.MemberService
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.context.support.GenericXmlApplicationContext

class XmlAppContext {
  @Test
  fun xmlAppContext() {
    val genericXmlApplicationContext = GenericXmlApplicationContext("appConfig.xml")
    val bean = genericXmlApplicationContext.getBean("memberService", MemberService::class.java)
    Assertions.assertThat(bean).isInstanceOf(MemberService::class.java)
  }
}