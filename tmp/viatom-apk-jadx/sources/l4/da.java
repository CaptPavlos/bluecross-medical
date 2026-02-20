package l4;

import android.content.Intent;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.UserActivity;
import com.uptodown.activities.UserDeviceDetailsActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class da implements u7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10337a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserActivity f10338b;

    public /* synthetic */ da(UserActivity userActivity, int i10) {
        this.f10337a = i10;
        this.f10338b = userActivity;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(v5.m r7, w6.c r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof l4.fa
            if (r0 == 0) goto L13
            r0 = r8
            l4.fa r0 = (l4.fa) r0
            int r1 = r0.f10406d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10406d = r1
            goto L18
        L13:
            l4.fa r0 = new l4.fa
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f10404b
            int r1 = r0.f10406d
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L2e
            if (r1 != r3) goto L28
            v5.l r7 = r0.f10403a
            s6.a.e(r8)
            goto L4f
        L28:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r7)
            return r2
        L2e:
            s6.a.e(r8)
            v5.j r8 = v5.j.f13166a
            boolean r8 = kotlin.jvm.internal.l.a(r7, r8)
            if (r8 != 0) goto Ld6
            boolean r8 = r7 instanceof v5.l
            if (r8 == 0) goto Lc9
            r8 = r7
            v5.l r8 = (v5.l) r8
            r0.f10403a = r8
            r0.f10406d = r3
            r1 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r8 = r7.y.h(r1, r0)
            x6.a r0 = x6.a.f13718a
            if (r8 != r0) goto L4f
            return r0
        L4f:
            v5.l r7 = (v5.l) r7
            java.lang.Object r7 = r7.f13168a
            l4.rb r7 = (l4.rb) r7
            int r8 = r7.f10803b
            int r7 = r7.f10802a
            int r0 = com.uptodown.activities.UserActivity.Q
            com.uptodown.activities.UserActivity r0 = r6.f10338b
            r1 = 4
            r2 = 2131952269(0x7f13028d, float:1.9540976E38)
            r3 = 99
            r4 = 0
            if (r8 <= 0) goto L8d
            d5.a1 r5 = r0.o0()
            android.widget.TextView r5 = r5.A
            r5.setVisibility(r4)
            if (r8 <= r3) goto L7f
            d5.a1 r8 = r0.o0()
            android.widget.TextView r8 = r8.A
            java.lang.String r5 = r0.getString(r2)
            r8.setText(r5)
            goto L96
        L7f:
            d5.a1 r5 = r0.o0()
            android.widget.TextView r5 = r5.A
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r5.setText(r8)
            goto L96
        L8d:
            d5.a1 r8 = r0.o0()
            android.widget.TextView r8 = r8.A
            r8.setVisibility(r1)
        L96:
            if (r7 <= 0) goto Lbf
            d5.a1 r8 = r0.o0()
            android.widget.TextView r8 = r8.f6866z
            r8.setVisibility(r4)
            if (r7 <= r3) goto Lb1
            d5.a1 r7 = r0.o0()
            android.widget.TextView r7 = r7.f6866z
            java.lang.String r8 = r0.getString(r2)
            r7.setText(r8)
            goto Ld6
        Lb1:
            d5.a1 r8 = r0.o0()
            android.widget.TextView r8 = r8.f6866z
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r8.setText(r7)
            goto Ld6
        Lbf:
            d5.a1 r7 = r0.o0()
            android.widget.TextView r7 = r7.f6866z
            r7.setVisibility(r1)
            goto Ld6
        Lc9:
            v5.k r8 = v5.k.f13167a
            boolean r7 = kotlin.jvm.internal.l.a(r7, r8)
            if (r7 == 0) goto Ld2
            goto Ld6
        Ld2:
            androidx.window.layout.c.b()
            return r2
        Ld6:
            s6.w r7 = s6.w.f12711a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.da.a(v5.m, w6.c):java.lang.Object");
    }

    @Override // u7.i
    public final Object emit(Object obj, w6.c cVar) {
        int i10 = this.f10337a;
        s6.w wVar = s6.w.f12711a;
        v5.k kVar = v5.k.f13167a;
        v5.j jVar = v5.j.f13166a;
        UserActivity userActivity = this.f10338b;
        switch (i10) {
            case 0:
                v5.m mVar = (v5.m) obj;
                if (!kotlin.jvm.internal.l.a(mVar, jVar)) {
                    if (!(mVar instanceof v5.l)) {
                        if (!kotlin.jvm.internal.l.a(mVar, kVar)) {
                            androidx.window.layout.c.b();
                            break;
                        }
                    } else {
                        h5.h1 h1Var = ((nb) ((v5.l) mVar).f13168a).f10666a;
                        Intent intent = new Intent(userActivity, (Class<?>) UserDeviceDetailsActivity.class);
                        intent.putExtra("user_device", h1Var);
                        float f = UptodownApp.E;
                        userActivity.startActivity(intent, k4.c.a(userActivity));
                        break;
                    }
                }
                break;
            case 1:
                break;
            case 2:
                v5.m mVar2 = (v5.m) obj;
                if (!kotlin.jvm.internal.l.a(mVar2, jVar)) {
                    if (!(mVar2 instanceof v5.l)) {
                        if (!kotlin.jvm.internal.l.a(mVar2, kVar)) {
                            androidx.window.layout.c.b();
                            break;
                        }
                    } else {
                        v5.c.e(userActivity, (String) ((v5.l) mVar2).f13168a, userActivity.getString(R.string.uptodown_turbo));
                        break;
                    }
                }
                break;
            default:
                v5.m mVar3 = (v5.m) obj;
                if (!kotlin.jvm.internal.l.a(mVar3, jVar)) {
                    if (!(mVar3 instanceof v5.l)) {
                        if (!kotlin.jvm.internal.l.a(mVar3, kVar)) {
                            androidx.window.layout.c.b();
                            break;
                        }
                    } else {
                        userActivity.K = (String) ((v5.l) mVar3).f13168a;
                        userActivity.o0().f6855m.setVisibility(0);
                        userActivity.o0().f6855m.setOnClickListener(new z9(userActivity, 18));
                        break;
                    }
                }
                break;
        }
        return null;
    }
}
