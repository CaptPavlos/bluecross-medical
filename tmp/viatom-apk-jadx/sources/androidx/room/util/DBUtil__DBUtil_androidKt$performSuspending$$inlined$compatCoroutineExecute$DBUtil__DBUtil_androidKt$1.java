package androidx.room.util;

import androidx.room.RoomDatabase;
import g7.l;
import g7.p;
import r7.w;
import s6.a;
import w6.c;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@e(c = "androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1", f = "DBUtil.android.kt", l = {109}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DBUtil__DBUtil_androidKt$performSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1 extends i implements p {
    final /* synthetic */ l $block$inlined;
    final /* synthetic */ RoomDatabase $db$inlined;
    final /* synthetic */ boolean $inTransaction$inlined;
    final /* synthetic */ boolean $isReadOnly$inlined;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DBUtil__DBUtil_androidKt$performSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1(c cVar, RoomDatabase roomDatabase, boolean z9, boolean z10, l lVar) {
        super(2, cVar);
        this.$db$inlined = roomDatabase;
        this.$isReadOnly$inlined = z9;
        this.$inTransaction$inlined = z10;
        this.$block$inlined = lVar;
    }

    @Override // y6.a
    public final c create(Object obj, c cVar) {
        return new DBUtil__DBUtil_androidKt$performSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1(cVar, this.$db$inlined, this.$isReadOnly$inlined, this.$inTransaction$inlined, this.$block$inlined);
    }

    @Override // g7.p
    public final Object invoke(w wVar, c cVar) {
        return ((DBUtil__DBUtil_androidKt$performSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                a.e(obj);
                return obj;
            }
            androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        a.e(obj);
        RoomDatabase roomDatabase = this.$db$inlined;
        boolean z9 = this.$isReadOnly$inlined;
        DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1 dBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1 = new DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1(this.$inTransaction$inlined, z9, roomDatabase, null, this.$block$inlined);
        this.label = 1;
        Object objUseConnection$room_runtime_release = roomDatabase.useConnection$room_runtime_release(z9, dBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1, this);
        x6.a aVar = x6.a.f13718a;
        return objUseConnection$room_runtime_release == aVar ? aVar : objUseConnection$room_runtime_release;
    }
}
