package androidx.work;

import androidx.annotation.RestrictTo;
import com.google.android.gms.internal.measurement.a4;
import java.util.concurrent.Executor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class DirectExecutor implements Executor {
    private static final /* synthetic */ z6.a $ENTRIES;
    private static final /* synthetic */ DirectExecutor[] $VALUES;
    public static final DirectExecutor INSTANCE = new DirectExecutor("INSTANCE", 0);

    private static final /* synthetic */ DirectExecutor[] $values() {
        return new DirectExecutor[]{INSTANCE};
    }

    static {
        DirectExecutor[] directExecutorArr$values = $values();
        $VALUES = directExecutorArr$values;
        $ENTRIES = a4.m(directExecutorArr$values);
    }

    private DirectExecutor(String str, int i10) {
    }

    public static z6.a getEntries() {
        return $ENTRIES;
    }

    public static DirectExecutor valueOf(String str) {
        return (DirectExecutor) Enum.valueOf(DirectExecutor.class, str);
    }

    public static DirectExecutor[] values() {
        return (DirectExecutor[]) $VALUES.clone();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.getClass();
        runnable.run();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "DirectExecutor";
    }
}
