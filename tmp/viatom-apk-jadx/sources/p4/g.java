package p4;

import android.content.SharedPreferences;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import com.uptodown.core.activities.FileExplorerActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class g implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11957a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f11958b;

    public /* synthetic */ g(FileExplorerActivity fileExplorerActivity, int i10) {
        this.f11957a = i10;
        this.f11958b = fileExplorerActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z9) {
        int i10 = this.f11957a;
        FileExplorerActivity fileExplorerActivity = this.f11958b;
        switch (i10) {
            case 0:
                if (!z9) {
                    int i11 = FileExplorerActivity.f6665q0;
                    return;
                }
                fileExplorerActivity.U = !fileExplorerActivity.U;
                RadioButton radioButton = fileExplorerActivity.G;
                radioButton.getClass();
                radioButton.setOnClickListener(new e(fileExplorerActivity, 7));
                RadioButton radioButton2 = fileExplorerActivity.H;
                radioButton2.getClass();
                radioButton2.setOnClickListener(new e5.n(28));
                RadioButton radioButton3 = fileExplorerActivity.I;
                radioButton3.getClass();
                radioButton3.setOnClickListener(new e5.n(28));
                return;
            case 1:
                if (!z9) {
                    int i12 = FileExplorerActivity.f6665q0;
                    return;
                }
                fileExplorerActivity.U = !fileExplorerActivity.U;
                RadioButton radioButton4 = fileExplorerActivity.H;
                radioButton4.getClass();
                radioButton4.setOnClickListener(new e(fileExplorerActivity, 4));
                RadioButton radioButton5 = fileExplorerActivity.G;
                radioButton5.getClass();
                radioButton5.setOnClickListener(new e5.n(28));
                RadioButton radioButton6 = fileExplorerActivity.I;
                radioButton6.getClass();
                radioButton6.setOnClickListener(new e5.n(28));
                return;
            case 2:
                if (!z9) {
                    int i13 = FileExplorerActivity.f6665q0;
                    return;
                }
                fileExplorerActivity.U = !fileExplorerActivity.U;
                RadioButton radioButton7 = fileExplorerActivity.I;
                radioButton7.getClass();
                radioButton7.setOnClickListener(new e(fileExplorerActivity, 5));
                RadioButton radioButton8 = fileExplorerActivity.G;
                radioButton8.getClass();
                radioButton8.setOnClickListener(new e5.n(28));
                RadioButton radioButton9 = fileExplorerActivity.H;
                radioButton9.getClass();
                radioButton9.setOnClickListener(new e5.n(28));
                return;
            case 3:
                if (!z9) {
                    int i14 = FileExplorerActivity.f6665q0;
                    return;
                }
                TextView textView = fileExplorerActivity.C;
                if (textView != null) {
                    textView.setVisibility(0);
                    return;
                } else {
                    kotlin.jvm.internal.l.i("tvSelectedPath");
                    throw null;
                }
            default:
                int i15 = FileExplorerActivity.f6665q0;
                try {
                    SharedPreferences.Editor editorEdit = fileExplorerActivity.getSharedPreferences("CoreSettings", 0).edit();
                    editorEdit.putBoolean("show_hidden_files", z9);
                    editorEdit.apply();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                SearchView searchView = fileExplorerActivity.E;
                searchView.getClass();
                fileExplorerActivity.U(searchView.getQuery().toString(), null);
                return;
        }
    }
}
