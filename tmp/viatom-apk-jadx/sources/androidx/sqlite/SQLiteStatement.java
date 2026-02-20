package androidx.sqlite;

import androidx.annotation.IntRange;
import com.google.android.material.transformation.FabTransformationScrimBehavior;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public interface SQLiteStatement extends AutoCloseable {
    /* renamed from: bindBlob */
    void mo88bindBlob(@IntRange(from = 1) int i10, byte[] bArr);

    void bindBoolean(@IntRange(from = 1) int i10, boolean z9);

    /* renamed from: bindDouble */
    void mo89bindDouble(@IntRange(from = 1) int i10, double d8);

    void bindFloat(@IntRange(from = 1) int i10, float f);

    void bindInt(@IntRange(from = 1) int i10, int i11);

    /* renamed from: bindLong */
    void mo90bindLong(@IntRange(from = 1) int i10, long j10);

    /* renamed from: bindNull */
    void mo91bindNull(@IntRange(from = 1) int i10);

    /* renamed from: bindText */
    void mo92bindText(@IntRange(from = 1) int i10, String str);

    /* renamed from: clearBindings */
    void mo93clearBindings();

    @Override // java.lang.AutoCloseable
    void close();

    byte[] getBlob(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10);

    boolean getBoolean(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10);

    int getColumnCount();

    String getColumnName(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10);

    List<String> getColumnNames();

    int getColumnType(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10);

    double getDouble(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10);

    float getFloat(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10);

    int getInt(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10);

    long getLong(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10);

    String getText(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10);

    boolean isNull(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10);

    void reset();

    boolean step();
}
