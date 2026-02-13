package androidx.room;

import a3.q;
import a3.s;
import androidx.sqlite.SQLiteStatement;
import g7.l;
import kotlin.jvm.internal.g;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class RoomRawQuery {
    private final l bindingFunction;
    private final String sql;

    public RoomRawQuery(String str, l lVar) {
        str.getClass();
        lVar.getClass();
        this.sql = str;
        this.bindingFunction = new s(lVar, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w _init_$lambda$0(SQLiteStatement sQLiteStatement) {
        sQLiteStatement.getClass();
        return w.f12711a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w bindingFunction$lambda$1(l lVar, SQLiteStatement sQLiteStatement) {
        sQLiteStatement.getClass();
        lVar.invoke(new BindOnlySQLiteStatement(sQLiteStatement));
        return w.f12711a;
    }

    public final l getBindingFunction() {
        return this.bindingFunction;
    }

    public final String getSql() {
        return this.sql;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RoomRawQuery(String str) {
        this(str, null, 2, 0 == true ? 1 : 0);
        str.getClass();
    }

    public /* synthetic */ RoomRawQuery(String str, l lVar, int i10, g gVar) {
        this(str, (i10 & 2) != 0 ? new q(1) : lVar);
    }
}
