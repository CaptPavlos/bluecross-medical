package androidx.room;

import a3.i0;
import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.concurrent.atomic.AtomicBoolean;
import s6.f;
import s6.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public abstract class SharedSQLiteStatement {
    private final RoomDatabase database;
    private final AtomicBoolean lock;
    private final f stmt$delegate;

    public SharedSQLiteStatement(RoomDatabase roomDatabase) {
        roomDatabase.getClass();
        this.database = roomDatabase;
        this.lock = new AtomicBoolean(false);
        this.stmt$delegate = new m(new i0(this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SupportSQLiteStatement createNewStatement() {
        return this.database.compileStatement(createQuery());
    }

    private final SupportSQLiteStatement getStmt(boolean z9) {
        return z9 ? getStmt() : createNewStatement();
    }

    public SupportSQLiteStatement acquire() {
        assertNotMainThread();
        return getStmt(this.lock.compareAndSet(false, true));
    }

    public void assertNotMainThread() {
        this.database.assertNotMainThread();
    }

    public abstract String createQuery();

    public void release(SupportSQLiteStatement supportSQLiteStatement) {
        supportSQLiteStatement.getClass();
        if (supportSQLiteStatement == getStmt()) {
            this.lock.set(false);
        }
    }

    private final SupportSQLiteStatement getStmt() {
        return (SupportSQLiteStatement) this.stmt$delegate.getValue();
    }
}
