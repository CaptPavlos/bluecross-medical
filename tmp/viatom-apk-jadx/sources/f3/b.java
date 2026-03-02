package f3;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes3.dex */
public @interface b {
    String[] alternate() default {};

    String value();
}
