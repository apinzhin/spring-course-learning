package media_player;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class HasInternetCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        boolean hasInternet = Boolean.valueOf(System.getProperty("hasInternet"));

        System.out.println("Internet connection: " + hasInternet);

        return hasInternet;
    }
}
