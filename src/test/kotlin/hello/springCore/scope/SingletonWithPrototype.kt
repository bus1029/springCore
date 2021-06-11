package hello.springCore.scope

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Scope

class SingletonWithPrototype {
  @Test
  fun singletonClientUsePrototype() {
    val ac = AnnotationConfigApplicationContext(PrototypeBean::class.java, ClientBean::class.java)
    val clientBean1 = ac.getBean(ClientBean::class.java)
    val logic1 = clientBean1.logic()
    Assertions.assertThat(logic1).isEqualTo(1)

    val clientBean2 = ac.getBean(ClientBean::class.java)
    val logic2 = clientBean2.logic()
    Assertions.assertThat(logic2).isEqualTo(2)
  }

  @Scope("singleton")
  class ClientBean @Autowired constructor(private val prototypeBean: PrototypeBean) {
    // prototypeBean 은 생성 시점에 주입되어 버림
    fun logic(): Int {
      return prototypeBean.addCount()
    }
  }

  @Scope("prototype")
  class PrototypeBean {
    private var count = 0

    fun addCount(): Int {
      return ++count
    }
  }
}