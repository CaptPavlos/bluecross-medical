package l4;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDelegate;
import com.uptodown.UptodownApp;
import com.uptodown.activities.UserActivity;
import com.uptodown.core.activities.FileExplorerActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class ca implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10303a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.x f10304b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f10305c;

    public /* synthetic */ ca(FileExplorerActivity fileExplorerActivity, kotlin.jvm.internal.x xVar) {
        this.f10305c = fileExplorerActivity;
        this.f10304b = xVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z9) {
        int i10 = this.f10303a;
        kotlin.jvm.internal.x xVar = this.f10304b;
        Context context = this.f10305c;
        switch (i10) {
            case 0:
                int i11 = UserActivity.Q;
                if (z9) {
                    Object obj = xVar.f10138a;
                    obj.getClass();
                    ((AlertDialog) obj).dismiss();
                    try {
                        SharedPreferences.Editor editorEdit = context.getSharedPreferences("SettingsPreferences", 0).edit();
                        editorEdit.putString("dark_mode", "system");
                        editorEdit.apply();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    AppCompatDelegate.setDefaultNightMode(-1);
                    UptodownApp.Y = true;
                    return;
                }
                return;
            default:
                FileExplorerActivity fileExplorerActivity = (FileExplorerActivity) context;
                if (!z9) {
                    int i12 = FileExplorerActivity.f6665q0;
                    return;
                }
                TextView textView = fileExplorerActivity.C;
                if (textView == null) {
                    kotlin.jvm.internal.l.i("tvSelectedPath");
                    throw null;
                }
                textView.setVisibility(8);
                TextView textView2 = fileExplorerActivity.C;
                if (textView2 != null) {
                    textView2.setText((CharSequence) xVar.f10138a);
                    return;
                } else {
                    kotlin.jvm.internal.l.i("tvSelectedPath");
                    throw null;
                }
        }
    }

    public /* synthetic */ ca(kotlin.jvm.internal.x xVar, Context context) {
        this.f10304b = xVar;
        this.f10305c = context;
    }
}
