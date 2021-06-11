package hello.springCore.scope

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.ObjectProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Scope
import javax.inject.Provider

class SingletonWithPrototype {
  @Test
  fun singletonClientUsePrototype() {
    val ac = AnnotationConfigApplicationContext(PrototypeBean::class.java, ClientBean::class.java)
    val clientBean1 = ac.getBean(ClientBean::class.java)
    val logic1 = clientBean1.logic()
    Assertions.assertThat(logic1).isEqualTo(1)

    val clientBean2 = ac.getBean(ClientBean::class.java)
    val logic2 = clientBean2.logic()
    Assertions.assertThat(logic2).isEqualTo(1)
  }

  @Scope("singleton")
  class ClientBean @Autowired constructor(private val prototypeBeanProvider: ObjectProvider<PrototypeBean>) {
    fun logic(): Int {
      // 필요할 때마다 스프링 컨테이너에 요청
      val prototypeBean = prototypeBeanProvider.getObject()
      return prototypeBean.addCount()
    }
  }

  @Scope("singleton")
  class ClientBean2 @Autowired constructor(private val prototypeBeanProvider: Provider<PrototypeBean>) {
    fun logic(): Int {
      // 필요할 때마다 스프링 컨테이너에 요청
      val prototypeBean = prototypeBeanProvider.get()
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