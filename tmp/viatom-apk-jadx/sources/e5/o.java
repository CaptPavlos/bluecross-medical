package e5;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.CompoundButton;
import androidx.lifecycle.ViewModelKt;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class o implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7823a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j0 f7824b;

    public /* synthetic */ o(j0 j0Var, int i10) {
        this.f7823a = i10;
        this.f7824b = j0Var;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z9) {
        int i10 = this.f7823a;
        j0 j0Var = this.f7824b;
        switch (i10) {
            case 0:
                c1 c1VarG = j0Var.G();
                Context contextRequireContext = j0Var.requireContext();
                contextRequireContext.getClass();
                long j10 = j0Var.D().f8566a;
                c1VarG.getClass();
                r7.w viewModelScope = ViewModelKt.getViewModelScope(c1VarG);
                y7.e eVar = r7.i0.f12407a;
                r7.y.q(viewModelScope, y7.d.f14116a, null, new b1(contextRequireContext, j10, z9, null), 2);
                break;
            default:
                Context contextRequireContext2 = j0Var.requireContext();
                contextRequireContext2.getClass();
                boolean z10 = !z9;
                try {
                    SharedPreferences.Editor editorEdit = contextRequireContext2.getSharedPreferences("SettingsPreferences", 0).edit();
                    editorEdit.putBoolean("show_warning_download_incompatible", z10);
                    editorEdit.apply();
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }
}
