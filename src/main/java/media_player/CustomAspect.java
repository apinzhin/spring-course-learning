package media_player;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomAspect {
    @After( "execution(* media_player..*.play(..))" )
    public void beforeFooMethods(JoinPoint jp){


        System.out.println("/////////////// " + jp.getTarget().getClass().getSimpleName() + " is playing //////////////");
    }


    @AfterReturning(pointcut = "execution(* media_player..*.foo())", returning = "retVal")
    public void afterFoo(Double retVal) {
        System.out.println("AFTER foo()" + retVal);
    }
    @AfterThrowing(pointcut = "execution(* media_player..*.*(..))",
            throwing = "ex")
    public void dbException(Exception ex){
        System.out.println(ex);
    }


}
