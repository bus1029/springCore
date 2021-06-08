package hello.springCore.annotation

import org.springframework.beans.factory.annotation.Qualifier
import java.lang.annotation.Inherited

@Target(AnnotationTarget.FIELD, AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.TYPE, AnnotationTarget.ANNOTATION_CLASS,
  AnnotationTarget.CLASS
)
@Retention(AnnotationRetention.RUNTIME)
@Inherited
@MustBeDocumented
@Qualifier("mainDiscountPolicy")
annotation class MainDiscountPolicy()
