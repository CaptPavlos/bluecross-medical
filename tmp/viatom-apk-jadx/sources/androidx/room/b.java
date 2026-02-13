package androidx.room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.widget.ProgressBar;
import androidx.work.WorkRequest;
import androidx.work.impl.WorkManagerImpl;
import com.uptodown.activities.OldVersionsActivity;
import h5.q;
import java.io.File;
import kotlin.jvm.internal.l;
import n4.u0;
import s6.w;
import y5.r1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements g7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f609a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f610b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f611c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f612d;

    public /* synthetic */ b(WorkManagerImpl workManagerImpl, String str, WorkRequest workRequest) {
        this.f609a = 1;
        this.f611c = workManagerImpl;
        this.f610b = str;
        this.f612d = workRequest;
    }

    @Override // g7.a
    public final Object invoke() {
        int i10 = this.f609a;
        w wVar = w.f12711a;
        Object obj = this.f610b;
        Object obj2 = this.f612d;
        Object obj3 = this.f611c;
        switch (i10) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                int i11 = l4.w.G;
                ((l4.w) obj3).S((File) obj2, (String) obj);
                break;
            case 4:
                OldVersionsActivity oldVersionsActivity = (OldVersionsActivity) obj3;
                String str = (String) obj;
                int i12 = OldVersionsActivity.L;
                int i13 = ((q) obj2).f8700a;
                try {
                    SharedPreferences.Editor editorEdit = oldVersionsActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                    editorEdit.putInt("downloadID_to_rollback", i13);
                    editorEdit.apply();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                str.getClass();
                Intent intent = new Intent("android.intent.action.DELETE", Uri.parse("package:".concat(str)));
                intent.addFlags(268435456);
                oldVersionsActivity.startActivity(intent);
                break;
            default:
                u0 u0Var = (u0) obj2;
                ProgressBar progressBar = (ProgressBar) obj;
                if (l.a(((r1) obj3).f13998r, u0Var.f11493a.f8526c)) {
                    progressBar.setVisibility(8);
                    u0Var.e = false;
                    u0Var.f11496d = false;
                    break;
                }
                break;
        }
        return wVar;
    }

    public /* synthetic */ b(Object obj, Object obj2, Object obj3, int i10) {
        this.f609a = i10;
        this.f611c = obj;
        this.f612d = obj2;
        this.f610b = obj3;
    }
}
