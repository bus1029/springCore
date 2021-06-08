package hello.springCore.autowired

import hello.springCore.member.Member
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Configuration
import org.springframework.lang.Nullable
import java.util.*

class AutowiredTest {
  @Test
  fun autowiredOption() {
    val ac = AnnotationConfigApplicationContext(TestBean::class.java)


  }

  class TestBean {
    @Autowired(required = false)
    fun setNoBean1(noBean1: Member) {
      println("noBean1 = ${noBean1}")
    }
    
    @Autowired
    fun setNoBean2(@Nullable noBean2: Member?) {
      println("noBean1 = ${noBean2}")
    }
    
    @Autowired
    fun setNoBean3(noBean3: Optional<Member>) {
      println("noBean3 = ${noBean3}")
    }
  }
}