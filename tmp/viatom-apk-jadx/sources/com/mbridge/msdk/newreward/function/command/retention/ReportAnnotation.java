package com.mbridge.msdk.newreward.function.command.retention;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class ReportAnnotation {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ClassInfo {
        String value();
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @Target({ElementType.LOCAL_VARIABLE, ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FieldInfo {
        int[] value();
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MethodInfo {
        String className() default "-1";

        boolean isParameter() default false;

        String key() default "-1";

        String methodName() default "-1";

        String methodParameter() default "-1";

        String reportType() default "-1";
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @Target({ElementType.PACKAGE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PackageInfo {
        String value();
    }
}
