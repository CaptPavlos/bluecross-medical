package androidx.room.util;

import androidx.annotation.IntRange;
import androidx.sqlite.SQLiteStatement;
import com.google.android.material.transformation.FabTransformationScrimBehavior;
import com.google.gson.internal.a;
import java.util.List;
import java.util.Map;
import u6.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class MappedColumnsSQLiteStatementWrapper implements SQLiteStatement {
    private final Map<String, Integer> columnNameToIndexMap;
    private final String[] columnNames;
    private final SQLiteStatement delegate;
    private final int[] mapping;

    public MappedColumnsSQLiteStatementWrapper(SQLiteStatement sQLiteStatement, String[] strArr, int[] iArr) {
        sQLiteStatement.getClass();
        strArr.getClass();
        iArr.getClass();
        this.delegate = sQLiteStatement;
        this.columnNames = strArr;
        this.mapping = iArr;
        if (strArr.length != iArr.length) {
            a.n("Expected columnNames.size == mapping.size");
            throw null;
        }
        f fVar = new f();
        int length = strArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            fVar.put(strArr[i10], Integer.valueOf(this.mapping[i11]));
            i10++;
            i11++;
        }
        int columnCount = getColumnCount();
        for (int i12 = 0; i12 < columnCount; i12++) {
            if (!fVar.containsKey(getColumnName(i12))) {
                fVar.put(getColumnName(i12), Integer.valueOf(i12));
            }
        }
        this.columnNameToIndexMap = fVar.c();
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindBlob */
    public void mo88bindBlob(@IntRange(from = 1) int i10, byte[] bArr) {
        bArr.getClass();
        this.delegate.mo88bindBlob(i10, bArr);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void bindBoolean(@IntRange(from = 1) int i10, boolean z9) {
        this.delegate.bindBoolean(i10, z9);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindDouble */
    public void mo89bindDouble(@IntRange(from = 1) int i10, double d8) {
        this.delegate.mo89bindDouble(i10, d8);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void bindFloat(@IntRange(from = 1) int i10, float f) {
        this.delegate.bindFloat(i10, f);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void bindInt(@IntRange(from = 1) int i10, int i11) {
        this.delegate.bindInt(i10, i11);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindLong */
    public void mo90bindLong(@IntRange(from = 1) int i10, long j10) {
        this.delegate.mo90bindLong(i10, j10);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindNull */
    public void mo91bindNull(@IntRange(from = 1) int i10) {
        this.delegate.mo91bindNull(i10);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindText */
    public void mo92bindText(@IntRange(from = 1) int i10, String str) {
        str.getClass();
        this.delegate.mo92bindText(i10, str);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: clearBindings */
    public void mo93clearBindings() {
        this.delegate.mo93clearBindings();
    }

    @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // androidx.sqlite.SQLiteStatement
    public byte[] getBlob(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10) {
        return this.delegate.getBlob(i10);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public boolean getBoolean(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10) {
        return this.delegate.getBoolean(i10);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public int getColumnCount() {
        return this.delegate.getColumnCount();
    }

    public final int getColumnIndex(String str) {
        str.getClass();
        Integer num = this.columnNameToIndexMap.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    @Override // androidx.sqlite.SQLiteStatement
    public String getColumnName(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10) {
        return this.delegate.getColumnName(i10);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public List<String> getColumnNames() {
        return this.delegate.getColumnNames();
    }

    @Override // androidx.sqlite.SQLiteStatement
    public int getColumnType(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10) {
        return this.delegate.getColumnType(i10);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public double getDouble(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10) {
        return this.delegate.getDouble(i10);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public float getFloat(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10) {
        return this.delegate.getFloat(i10);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public int getInt(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10) {
        return this.delegate.getInt(i10);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public long getLong(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10) {
        return this.delegate.getLong(i10);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public String getText(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10) {
        return this.delegate.getText(i10);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public boolean isNull(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10) {
        return this.delegate.isNull(i10);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void reset() {
        this.delegate.reset();
    }

    @Override // androidx.sqlite.SQLiteStatement
    public boolean step() {
        return this.delegate.step();
    }
}
