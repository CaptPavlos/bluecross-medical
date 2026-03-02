package androidx.window.core;

import a3.a;
import androidx.window.core.SpecificationComputer;
import androidx.window.layout.c;
import com.google.android.gms.internal.measurement.a4;
import g7.l;
import java.util.ArrayList;
import java.util.Collection;
import t6.j;
import t6.t;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final class FailedSpecification<T> extends SpecificationComputer<T> {
    private final WindowStrictModeException exception;
    private final Logger logger;
    private final String message;
    private final String tag;
    private final T value;
    private final SpecificationComputer.VerificationMode verificationMode;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SpecificationComputer.VerificationMode.values().length];
            iArr[SpecificationComputer.VerificationMode.STRICT.ordinal()] = 1;
            iArr[SpecificationComputer.VerificationMode.LOG.ordinal()] = 2;
            iArr[SpecificationComputer.VerificationMode.QUIET.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FailedSpecification(T t, String str, String str2, Logger logger, SpecificationComputer.VerificationMode verificationMode) {
        Collection collectionU;
        t.getClass();
        str.getClass();
        str2.getClass();
        logger.getClass();
        verificationMode.getClass();
        this.value = t;
        this.tag = str;
        this.message = str2;
        this.logger = logger;
        this.verificationMode = verificationMode;
        WindowStrictModeException windowStrictModeException = new WindowStrictModeException(createMessage(t, str2));
        StackTraceElement[] stackTrace = windowStrictModeException.getStackTrace();
        stackTrace.getClass();
        int length = stackTrace.length - 2;
        length = length < 0 ? 0 : length;
        if (length < 0) {
            f.b(a.g(length, "Requested element count ", " is less than zero."));
            throw null;
        }
        if (length == 0) {
            collectionU = t.f12808a;
        } else {
            int length2 = stackTrace.length;
            if (length >= length2) {
                collectionU = j.y0(stackTrace);
            } else if (length == 1) {
                collectionU = a4.u(stackTrace[length2 - 1]);
            } else {
                ArrayList arrayList = new ArrayList(length);
                for (int i10 = length2 - length; i10 < length2; i10++) {
                    arrayList.add(stackTrace[i10]);
                }
                collectionU = arrayList;
            }
        }
        Object[] array = collectionU.toArray(new StackTraceElement[0]);
        if (array == null) {
            c.k("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            throw null;
        }
        windowStrictModeException.setStackTrace((StackTraceElement[]) array);
        this.exception = windowStrictModeException;
    }

    @Override // androidx.window.core.SpecificationComputer
    public T compute() throws WindowStrictModeException {
        int i10 = WhenMappings.$EnumSwitchMapping$0[this.verificationMode.ordinal()];
        if (i10 == 1) {
            throw this.exception;
        }
        if (i10 == 2) {
            this.logger.debug(this.tag, createMessage(this.value, this.message));
            return null;
        }
        if (i10 == 3) {
            return null;
        }
        c.b();
        return null;
    }

    public final WindowStrictModeException getException() {
        return this.exception;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getTag() {
        return this.tag;
    }

    public final T getValue() {
        return this.value;
    }

    public final SpecificationComputer.VerificationMode getVerificationMode() {
        return this.verificationMode;
    }

    @Override // androidx.window.core.SpecificationComputer
    public SpecificationComputer<T> require(String str, l lVar) {
        str.getClass();
        lVar.getClass();
        return this;
    }
}
