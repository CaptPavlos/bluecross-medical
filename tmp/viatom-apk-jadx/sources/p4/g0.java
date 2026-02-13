package p4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.uptodown.core.activities.InstallerActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11959a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InstallerActivity f11960b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.x f11961c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g0(InstallerActivity installerActivity, kotlin.jvm.internal.x xVar, w6.c cVar, int i10) {
        super(2, cVar);
        this.f11959a = i10;
        this.f11960b = installerActivity;
        this.f11961c = xVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f11959a) {
            case 0:
                return new g0(this.f11960b, this.f11961c, cVar, 0);
            default:
                return new g0(this.f11960b, this.f11961c, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f11959a) {
            case 0:
                g0 g0Var = (g0) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                g0Var.invokeSuspend(wVar2);
                return wVar2;
            default:
                g0 g0Var2 = (g0) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                g0Var2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f11959a) {
            case 0:
                s6.a.e(obj);
                InstallerActivity installerActivity = this.f11960b;
                ProgressBar progressBar = installerActivity.f6679p;
                if (progressBar != null) {
                    progressBar.setIndeterminate(false);
                }
                TextView textView = installerActivity.D;
                if (textView != null) {
                    textView.setText("");
                }
                TextView textView2 = installerActivity.F;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                TextView textView3 = installerActivity.E;
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
                Object obj2 = this.f11961c.f10138a;
                if (obj2 != null) {
                    TextView textView4 = installerActivity.D;
                    if (textView4 != null) {
                        textView4.setText((CharSequence) obj2);
                    }
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("realPath", installerActivity.K);
                    installerActivity.setResult(10, intent);
                    installerActivity.finish();
                }
                break;
            default:
                s6.a.e(obj);
                InstallerActivity installerActivity2 = this.f11960b;
                Intent intent2 = installerActivity2.getIntent();
                if (intent2 != null) {
                    installerActivity2.L = intent2.getData();
                    Bundle extras = intent2.getExtras();
                    if (extras != null && extras.containsKey("realPath")) {
                        String string = extras.getString("realPath");
                        installerActivity2.K = string;
                        string.getClass();
                        String str = installerActivity2.K;
                        str.getClass();
                        this.f11961c.f10138a = string.substring(o7.m.m0("/", str, 6) + 1);
                    }
                }
                break;
        }
        return s6.w.f12711a;
    }
}
