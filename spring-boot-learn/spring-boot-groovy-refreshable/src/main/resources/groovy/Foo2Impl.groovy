package groovy

import com.github.huotaihe.springboot.learn.groovy.Foo
import com.github.huotaihe.springboot.learn.groovy.TestService
import org.springframework.beans.factory.annotation.Autowired

class Foo2Impl implements Foo{

    @Autowired
    TestService testService;

    @Override
    String execute() {
        return testService.test();
    }
}
