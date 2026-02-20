package androidx.work.impl.utils;

import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopToken;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class StopWorkRunnable implements Runnable {
    private final Processor processor;
    private final int reason;
    private final boolean stopInForeground;
    private final StartStopToken token;

    public StopWorkRunnable(Processor processor, StartStopToken startStopToken, boolean z9, int i10) {
        processor.getClass();
        startStopToken.getClass();
        this.processor = processor;
        this.token = startStopToken;
        this.stopInForeground = z9;
        this.reason = i10;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z9 = this.stopInForeground;
        Processor processor = this.processor;
        boolean zStopForegroundWork = z9 ? processor.stopForegroundWork(this.token, this.reason) : processor.stopWork(this.token, this.reason);
        Logger.get().debug(Logger.tagWithPrefix("StopWorkRunnable"), "StopWorkRunnable for " + this.token.getId().getWorkSpecId() + "; Processor.stopWork = " + zStopForegroundWork);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StopWorkRunnable(Processor processor, StartStopToken startStopToken, boolean z9) {
        this(processor, startStopToken, z9, WorkInfo.STOP_REASON_UNKNOWN);
        processor.getClass();
        startStopToken.getClass();
    }
}
