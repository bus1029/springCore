package hello.springCore.scope

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Scope
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy

class PrototypeTest {
  @Test
  fun prototypeBeanFind() {
    val ac = AnnotationConfigApplicationContext(PrototypeBean::class.java)
    println("find prototypeBean1")
    val bean1 = ac.getBean(PrototypeBean::class.java)
    println("find prototypeBean2")
    val bean2 = ac.getBean(PrototypeBean::class.java)
    println("bean1 = ${bean1}")
    println("bean2 = ${bean2}")
    Assertions.assertThat(bean1).isNotSameAs(bean2)
    ac.close()
  }

  @Scope("prototype")
  class PrototypeBean {
    @PostConstruct
    fun init() {
      println("PrototypeBean.init")
    }

    @PreDestroy
    fun destroy() {
      println("PrototypeBean.destroy")
    }
  }
}