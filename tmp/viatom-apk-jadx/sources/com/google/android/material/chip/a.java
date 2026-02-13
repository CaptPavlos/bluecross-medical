package com.google.android.material.chip;

import android.content.SharedPreferences;
import android.widget.CompoundButton;
import com.uptodown.activities.OldVersionsActivity;
import g5.r;
import y5.b2;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2312a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2313b;

    public /* synthetic */ a(Object obj, int i10) {
        this.f2312a = i10;
        this.f2313b = obj;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z9) {
        int i10 = this.f2312a;
        Object obj = this.f2313b;
        switch (i10) {
            case 0:
                ((Chip) obj).lambda$new$0(compoundButton, z9);
                break;
            case 1:
                OldVersionsActivity oldVersionsActivity = (OldVersionsActivity) obj;
                int i11 = OldVersionsActivity.L;
                boolean z10 = !z9;
                try {
                    SharedPreferences.Editor editorEdit = oldVersionsActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                    editorEdit.putBoolean("show_warning_download_incompatible", z10);
                    editorEdit.apply();
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            default:
                b2 b2Var = (b2) obj;
                r rVar = b2Var.f13820b;
                if (rVar != null) {
                    rVar.a(b2Var.getBindingAdapterPosition());
                    break;
                }
                break;
        }
    }
}
