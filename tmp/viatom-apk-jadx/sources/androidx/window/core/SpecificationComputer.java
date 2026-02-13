package androidx.window.core;

import g7.l;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class SpecificationComputer<T> {
    public static final Companion Companion = new Companion(null);

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public enum VerificationMode {
        STRICT,
        LOG,
        QUIET
    }

    public abstract T compute();

    public final String createMessage(Object obj, String str) {
        obj.getClass();
        str.getClass();
        return str + " value: " + obj;
    }

    public abstract SpecificationComputer<T> require(String str, l lVar);

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public static /* synthetic */ SpecificationComputer startSpecification$default(Companion companion, Object obj, String str, VerificationMode verificationMode, Logger logger, int i10, Object obj2) {
            if ((i10 & 2) != 0) {
                verificationMode = BuildConfig.INSTANCE.getVerificationMode();
            }
            if ((i10 & 4) != 0) {
                logger = AndroidLogger.INSTANCE;
            }
            return companion.startSpecification(obj, str, verificationMode, logger);
        }

        public final <T> SpecificationComputer<T> startSpecification(T t, String str, VerificationMode verificationMode, Logger logger) {
            t.getClass();
            str.getClass();
            verificationMode.getClass();
            logger.getClass();
            return new ValidSpecification(t, str, verificationMode, logger);
        }

        private Companion() {
        }
    }
}
