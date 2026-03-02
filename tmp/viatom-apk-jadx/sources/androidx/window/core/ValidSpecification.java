package androidx.window.core;

import androidx.window.core.SpecificationComputer;
import g7.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final class ValidSpecification<T> extends SpecificationComputer<T> {
    private final Logger logger;
    private final String tag;
    private final T value;
    private final SpecificationComputer.VerificationMode verificationMode;

    public ValidSpecification(T t, String str, SpecificationComputer.VerificationMode verificationMode, Logger logger) {
        t.getClass();
        str.getClass();
        verificationMode.getClass();
        logger.getClass();
        this.value = t;
        this.tag = str;
        this.verificationMode = verificationMode;
        this.logger = logger;
    }

    @Override // androidx.window.core.SpecificationComputer
    public T compute() {
        return this.value;
    }

    public final Logger getLogger() {
        return this.logger;
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
        return ((Boolean) lVar.invoke(this.value)).booleanValue() ? this : new FailedSpecification(this.value, this.tag, str, this.logger, this.verificationMode);
    }
}
