package f5;

import android.content.Context;
import com.uptodown.gcm.MyFirebaseMessagingService;
import e5.g1;
import g7.p;
import r7.i0;
import r7.w;
import r7.y;
import w6.c;
import w7.n;
import y6.i;
import y7.d;
import y7.e;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8046a = 1;

    /* renamed from: b, reason: collision with root package name */
    public int f8047b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f8048c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f8049d;
    public final /* synthetic */ MyFirebaseMessagingService e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(long j10, String str, MyFirebaseMessagingService myFirebaseMessagingService, String str2, String str3, c cVar) {
        super(2, cVar);
        this.f8048c = j10;
        this.f8049d = str;
        this.e = myFirebaseMessagingService;
        this.f = str2;
        this.g = str3;
    }

    @Override // y6.a
    public final c create(Object obj, c cVar) {
        switch (this.f8046a) {
            case 0:
                return new a(this.e, this.f8049d, this.f, this.f8048c, this.g, cVar);
            default:
                return new a(this.f8048c, this.f8049d, this.e, this.f, this.g, cVar);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        w wVar = (w) obj;
        c cVar = (c) obj2;
        switch (this.f8046a) {
        }
        return ((a) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i10 = this.f8046a;
        s6.w wVar = s6.w.f12711a;
        x6.a aVar = x6.a.f13718a;
        switch (i10) {
            case 0:
                int i11 = this.f8047b;
                if (i11 == 0) {
                    s6.a.e(obj);
                    this.f8047b = 1;
                    int i12 = MyFirebaseMessagingService.f6688i;
                    e eVar = i0.f12407a;
                    Object objZ = y.z(new a(this.f8048c, this.g, this.e, this.f8049d, this.f, (c) null), d.f14116a, this);
                    if (objZ != aVar) {
                        objZ = wVar;
                    }
                    if (objZ == aVar) {
                        break;
                    }
                } else if (i11 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                    break;
                }
                break;
            default:
                int i13 = this.f8047b;
                if (i13 == 0) {
                    s6.a.e(obj);
                    Context applicationContext = this.e.getApplicationContext();
                    applicationContext.getClass();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    t1.Q(this.f8048c, applicationContext, "fcm_app_id");
                    t1.R(applicationContext, "fcm_packagename", this.f8049d);
                    t1.O(applicationContext, -1, "fcm_download_id");
                    t1.Q(jCurrentTimeMillis, applicationContext, "fcm_received_timestamp");
                    t1.Q(0L, applicationContext, "fcm_shown_timestamp");
                    e eVar2 = i0.f12407a;
                    s7.c cVar = n.f13548a;
                    g1 g1Var = new g1(this.f, this.g, this.f8048c, null);
                    this.f8047b = 1;
                    if (y.z(g1Var, cVar, this) == aVar) {
                        break;
                    }
                } else if (i13 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                    break;
                }
                break;
        }
        return aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(MyFirebaseMessagingService myFirebaseMessagingService, String str, String str2, long j10, String str3, c cVar) {
        super(2, cVar);
        this.e = myFirebaseMessagingService;
        this.f8049d = str;
        this.f = str2;
        this.f8048c = j10;
        this.g = str3;
    }
}
