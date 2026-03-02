package androidx.room.util;

import g7.l;
import g7.p;
import r7.w;
import s6.a;
import w6.c;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@e(c = "androidx.room.util.DBUtil__DBUtil_androidKt$compatCoroutineExecute$2", f = "DBUtil.android.kt", l = {107}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DBUtil__DBUtil_androidKt$compatCoroutineExecute$2 extends i implements p {
    final /* synthetic */ l $block;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DBUtil__DBUtil_androidKt$compatCoroutineExecute$2(l lVar, c cVar) {
        super(2, cVar);
        this.$block = lVar;
    }

    @Override // y6.a
    public final c create(Object obj, c cVar) {
        return new DBUtil__DBUtil_androidKt$compatCoroutineExecute$2(this.$block, cVar);
    }

    @Override // g7.p
    public final Object invoke(w wVar, c cVar) {
        return ((DBUtil__DBUtil_androidKt$compatCoroutineExecute$2) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
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
        l lVar = this.$block;
        this.label = 1;
        Object objInvoke = lVar.invoke(this);
        x6.a aVar = x6.a.f13718a;
        return objInvoke == aVar ? aVar : objInvoke;
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        return this.$block.invoke(this);
    }
}
