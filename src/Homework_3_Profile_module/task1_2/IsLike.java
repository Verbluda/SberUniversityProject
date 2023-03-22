package Homework_3_Profile_module.task1_2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface IsLike {
    boolean isLike();
}