package task07;

import java.lang.annotation.Documented;

@Documented
public @interface Submarine {
    String creator();
    String model();
}
