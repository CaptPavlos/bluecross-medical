package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.room.driver.SupportSQLiteConnection;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.Set;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class FtsTableInfo {
    public static final Companion Companion = new Companion(null);
    public final Set<String> columns;
    public final String name;
    public final Set<String> options;

    public FtsTableInfo(String str, Set<String> set, Set<String> set2) {
        str.getClass();
        set.getClass();
        set2.getClass();
        this.name = str;
        this.columns = set;
        this.options = set2;
    }

    public static final FtsTableInfo read(SQLiteConnection sQLiteConnection, String str) {
        return Companion.read(sQLiteConnection, str);
    }

    public boolean equals(Object obj) {
        return FtsTableInfoKt.equalsCommon(this, obj);
    }

    public int hashCode() {
        return FtsTableInfoKt.hashCodeCommon(this);
    }

    public String toString() {
        return FtsTableInfoKt.toStringCommon(this);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final FtsTableInfo read(SQLiteConnection sQLiteConnection, String str) {
            sQLiteConnection.getClass();
            str.getClass();
            return new FtsTableInfo(str, SchemaInfoUtilKt.readFtsColumns(sQLiteConnection, str), SchemaInfoUtilKt.readFtsOptions(sQLiteConnection, str));
        }

        private Companion() {
        }

        public final FtsTableInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
            supportSQLiteDatabase.getClass();
            str.getClass();
            return read(new SupportSQLiteConnection(supportSQLiteDatabase), str);
        }
    }

    public static final FtsTableInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        return Companion.read(supportSQLiteDatabase, str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FtsTableInfo(String str, Set<String> set, String str2) {
        this(str, set, SchemaInfoUtilKt.parseFtsOptions(str2));
        str.getClass();
        set.getClass();
        str2.getClass();
    }
}
