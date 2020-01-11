package groovy

import com.github.huotaihe.springboot.learn.groovy.Foo
import com.github.huotaihe.springboot.learn.groovy.TestService
import org.springframework.beans.factory.annotation.Autowired

class FooImpl implements Foo {

    String execute() {
        println("------------------------------hello!");
        return "hello";
    }
}
