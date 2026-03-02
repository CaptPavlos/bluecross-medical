package androidx.annotation;

import com.google.android.gms.internal.measurement.a4;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import z6.a;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PACKAGE})
@Documented
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface RestrictTo {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Scope {
        private static final /* synthetic */ a $ENTRIES;
        private static final /* synthetic */ Scope[] $VALUES;
        public static final Scope LIBRARY = new Scope("LIBRARY", 0);
        public static final Scope LIBRARY_GROUP = new Scope("LIBRARY_GROUP", 1);
        public static final Scope LIBRARY_GROUP_PREFIX = new Scope("LIBRARY_GROUP_PREFIX", 2);
        public static final Scope GROUP_ID = new Scope("GROUP_ID", 3);
        public static final Scope TESTS = new Scope("TESTS", 4);
        public static final Scope SUBCLASSES = new Scope("SUBCLASSES", 5);

        private static final /* synthetic */ Scope[] $values() {
            return new Scope[]{LIBRARY, LIBRARY_GROUP, LIBRARY_GROUP_PREFIX, GROUP_ID, TESTS, SUBCLASSES};
        }

        static {
            Scope[] scopeArr$values = $values();
            $VALUES = scopeArr$values;
            $ENTRIES = a4.m(scopeArr$values);
        }

        private Scope(String str, int i10) {
        }

        public static a getEntries() {
            return $ENTRIES;
        }

        public static Scope valueOf(String str) {
            return (Scope) Enum.valueOf(Scope.class, str);
        }

        public static Scope[] values() {
            return (Scope[]) $VALUES.clone();
        }
    }

    Scope[] value();
}
