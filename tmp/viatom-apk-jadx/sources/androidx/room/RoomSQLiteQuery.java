package androidx.room;

import a3.s;
import android.annotation.SuppressLint;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.jvm.internal.g;
import s6.w;
import t6.j;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@SuppressLint({"WrongConstant"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {
    private static final int BLOB = 5;
    public static final int DESIRED_POOL_SIZE = 10;
    private static final int DOUBLE = 3;
    private static final int LONG = 2;
    private static final int NULL = 1;
    public static final int POOL_LIMIT = 15;
    private static final int STRING = 4;
    private int argCount;
    private final int[] bindingTypes;
    public final byte[][] blobBindings;

    @VisibleForTesting
    private final int capacity;
    public final double[] doubleBindings;
    public final long[] longBindings;
    private volatile String query;
    public final String[] stringBindings;
    public static final Companion Companion = new Companion(null);
    public static final TreeMap<Integer, RoomSQLiteQuery> queryPool = new TreeMap<>();

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Binding {
    }

    private RoomSQLiteQuery(int i10) {
        this.capacity = i10;
        int i11 = i10 + 1;
        this.bindingTypes = new int[i11];
        this.longBindings = new long[i11];
        this.doubleBindings = new double[i11];
        this.stringBindings = new String[i11];
        this.blobBindings = new byte[i11][];
    }

    public static final RoomSQLiteQuery acquire(String str, int i10) {
        return Companion.acquire(str, i10);
    }

    public static final RoomSQLiteQuery copyFrom(SupportSQLiteQuery supportSQLiteQuery) {
        return Companion.copyFrom(supportSQLiteQuery);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w toRoomRawQuery$lambda$1(RoomSQLiteQuery roomSQLiteQuery, SQLiteStatement sQLiteStatement) {
        sQLiteStatement.getClass();
        roomSQLiteQuery.bindTo(sQLiteStatement);
        return w.f12711a;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i10, byte[] bArr) {
        bArr.getClass();
        this.bindingTypes[i10] = 5;
        this.blobBindings[i10] = bArr;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i10, double d8) {
        this.bindingTypes[i10] = 3;
        this.doubleBindings[i10] = d8;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i10, long j10) {
        this.bindingTypes[i10] = 2;
        this.longBindings[i10] = j10;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i10) {
        this.bindingTypes[i10] = 1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i10, String str) {
        str.getClass();
        this.bindingTypes[i10] = 4;
        this.stringBindings[i10] = str;
    }

    public final void bindText(int i10, String str) {
        str.getClass();
        bindString(i10, str);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        supportSQLiteProgram.getClass();
        int argCount = getArgCount();
        if (1 > argCount) {
            return;
        }
        int i10 = 1;
        while (true) {
            int i11 = this.bindingTypes[i10];
            if (i11 == 1) {
                supportSQLiteProgram.bindNull(i10);
            } else if (i11 == 2) {
                supportSQLiteProgram.bindLong(i10, this.longBindings[i10]);
            } else if (i11 == 3) {
                supportSQLiteProgram.bindDouble(i10, this.doubleBindings[i10]);
            } else if (i11 == 4) {
                String str = this.stringBindings[i10];
                if (str == null) {
                    com.google.gson.internal.a.n("Required value was null.");
                    return;
                }
                supportSQLiteProgram.bindString(i10, str);
            } else if (i11 == 5) {
                byte[] bArr = this.blobBindings[i10];
                if (bArr == null) {
                    com.google.gson.internal.a.n("Required value was null.");
                    return;
                }
                supportSQLiteProgram.bindBlob(i10, bArr);
            }
            if (i10 == argCount) {
                return;
            } else {
                i10++;
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        int[] iArr = this.bindingTypes;
        Arrays.fill(iArr, 0, iArr.length, 1);
        String[] strArr = this.stringBindings;
        j.q0(null, strArr, 0, strArr.length);
        byte[][] bArr = this.blobBindings;
        j.q0(null, bArr, 0, bArr.length);
        this.query = null;
    }

    public final void copyArgumentsFrom(RoomSQLiteQuery roomSQLiteQuery) {
        roomSQLiteQuery.getClass();
        int argCount = roomSQLiteQuery.getArgCount() + 1;
        System.arraycopy(roomSQLiteQuery.bindingTypes, 0, this.bindingTypes, 0, argCount);
        System.arraycopy(roomSQLiteQuery.longBindings, 0, this.longBindings, 0, argCount);
        System.arraycopy(roomSQLiteQuery.stringBindings, 0, this.stringBindings, 0, argCount);
        System.arraycopy(roomSQLiteQuery.blobBindings, 0, this.blobBindings, 0, argCount);
        System.arraycopy(roomSQLiteQuery.doubleBindings, 0, this.doubleBindings, 0, argCount);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int getArgCount() {
        return this.argCount;
    }

    public final int getCapacity() {
        return this.capacity;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String getSql() {
        String str = this.query;
        if (str != null) {
            return str;
        }
        androidx.window.layout.c.g("Required value was null.");
        return null;
    }

    public final void init(String str, int i10) {
        str.getClass();
        this.query = str;
        this.argCount = i10;
    }

    public final void release() {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = queryPool;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.capacity), this);
            Companion.prunePoolLocked$room_runtime_release();
        }
    }

    public final RoomRawQuery toRoomRawQuery() {
        return new RoomRawQuery(getSql(), new s(this, 5));
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final RoomSQLiteQuery acquire(String str, int i10) {
            str.getClass();
            TreeMap<Integer, RoomSQLiteQuery> treeMap = RoomSQLiteQuery.queryPool;
            synchronized (treeMap) {
                Map.Entry<Integer, RoomSQLiteQuery> entryCeilingEntry = treeMap.ceilingEntry(Integer.valueOf(i10));
                if (entryCeilingEntry == null) {
                    RoomSQLiteQuery roomSQLiteQuery = new RoomSQLiteQuery(i10, null);
                    roomSQLiteQuery.init(str, i10);
                    return roomSQLiteQuery;
                }
                treeMap.remove(entryCeilingEntry.getKey());
                RoomSQLiteQuery value = entryCeilingEntry.getValue();
                value.init(str, i10);
                return value;
            }
        }

        public final RoomSQLiteQuery copyFrom(SupportSQLiteQuery supportSQLiteQuery) {
            supportSQLiteQuery.getClass();
            final RoomSQLiteQuery roomSQLiteQueryAcquire = acquire(supportSQLiteQuery.getSql(), supportSQLiteQuery.getArgCount());
            supportSQLiteQuery.bindTo(new SupportSQLiteProgram() { // from class: androidx.room.RoomSQLiteQuery$Companion$copyFrom$1
                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindBlob(int i10, byte[] bArr) {
                    bArr.getClass();
                    roomSQLiteQueryAcquire.bindBlob(i10, bArr);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindDouble(int i10, double d8) {
                    roomSQLiteQueryAcquire.bindDouble(i10, d8);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindLong(int i10, long j10) {
                    roomSQLiteQueryAcquire.bindLong(i10, j10);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindNull(int i10) {
                    roomSQLiteQueryAcquire.bindNull(i10);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindString(int i10, String str) {
                    str.getClass();
                    roomSQLiteQueryAcquire.bindString(i10, str);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void clearBindings() {
                    roomSQLiteQueryAcquire.clearBindings();
                }

                @Override // java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    roomSQLiteQueryAcquire.close();
                }
            });
            return roomSQLiteQueryAcquire;
        }

        public final void prunePoolLocked$room_runtime_release() {
            TreeMap<Integer, RoomSQLiteQuery> treeMap = RoomSQLiteQuery.queryPool;
            if (treeMap.size() <= 15) {
                return;
            }
            int size = treeMap.size() - 10;
            Iterator<Integer> it = treeMap.descendingKeySet().iterator();
            it.getClass();
            while (true) {
                int i10 = size - 1;
                if (size <= 0) {
                    return;
                }
                it.next();
                it.remove();
                size = i10;
            }
        }

        private Companion() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getDESIRED_POOL_SIZE$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getPOOL_LIMIT$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getQueryPool$annotations() {
        }
    }

    private static /* synthetic */ void getBindingTypes$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getBlobBindings$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getDoubleBindings$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getLongBindings$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getStringBindings$annotations() {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public /* synthetic */ RoomSQLiteQuery(int i10, g gVar) {
        this(i10);
    }

    public final void bindTo(SQLiteStatement sQLiteStatement) {
        sQLiteStatement.getClass();
        int argCount = getArgCount();
        if (1 > argCount) {
            return;
        }
        int i10 = 1;
        while (true) {
            int i11 = this.bindingTypes[i10];
            if (i11 == 1) {
                sQLiteStatement.mo91bindNull(i10);
            } else if (i11 == 2) {
                sQLiteStatement.mo90bindLong(i10, this.longBindings[i10]);
            } else if (i11 == 3) {
                sQLiteStatement.mo89bindDouble(i10, this.doubleBindings[i10]);
            } else if (i11 == 4) {
                String str = this.stringBindings[i10];
                if (str == null) {
                    com.google.gson.internal.a.n("Required value was null.");
                    return;
                }
                sQLiteStatement.mo92bindText(i10, str);
            } else if (i11 == 5) {
                byte[] bArr = this.blobBindings[i10];
                if (bArr == null) {
                    com.google.gson.internal.a.n("Required value was null.");
                    return;
                }
                sQLiteStatement.mo88bindBlob(i10, bArr);
            }
            if (i10 == argCount) {
                return;
            } else {
                i10++;
            }
        }
    }
}
