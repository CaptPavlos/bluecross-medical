package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public interface StartStopTokens {
    public static final Companion Companion = Companion.$$INSTANCE;

    boolean contains(WorkGenerationalId workGenerationalId);

    StartStopToken remove(WorkGenerationalId workGenerationalId);

    StartStopToken remove(WorkSpec workSpec);

    List<StartStopToken> remove(String str);

    StartStopToken tokenFor(WorkGenerationalId workGenerationalId);

    StartStopToken tokenFor(WorkSpec workSpec);

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public static /* synthetic */ StartStopTokens create$default(Companion companion, boolean z9, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z9 = true;
            }
            return companion.create(z9);
        }

        public final StartStopTokens create(boolean z9) {
            StartStopTokensImpl startStopTokensImpl = new StartStopTokensImpl();
            return z9 ? new SynchronizedStartStopTokensImpl(startStopTokensImpl) : startStopTokensImpl;
        }

        public final StartStopTokens create() {
            return create$default(this, false, 1, null);
        }
    }
}
