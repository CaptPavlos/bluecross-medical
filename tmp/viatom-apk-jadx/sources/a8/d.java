package a8;

import a3.x;
import android.content.SharedPreferences;
import android.widget.TextView;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.sqlite.SQLiteConnection;
import androidx.work.Data;
import androidx.work.WorkInfo;
import androidx.work.impl.model.Dependency;
import androidx.work.impl.model.DependencyDao_Impl;
import androidx.work.impl.model.Preference;
import androidx.work.impl.model.PreferenceDao_Impl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao_Impl;
import androidx.work.impl.model.WorkName;
import androidx.work.impl.model.WorkNameDao_Impl;
import androidx.work.impl.model.WorkProgress;
import androidx.work.impl.model.WorkProgressDao_Impl;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTag;
import androidx.work.impl.model.WorkTagDao_Impl;
import com.uptodown.R;
import com.uptodown.activities.preferences.PreferencesActivity;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class d implements g7.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f306a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f307b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f308c;

    public /* synthetic */ d(int i10, Object obj, Object obj2) {
        this.f306a = i10;
        this.f307b = obj;
        this.f308c = obj2;
    }

    @Override // g7.l
    public final Object invoke(Object obj) {
        int i10 = this.f306a;
        w wVar = w.f12711a;
        Object obj2 = this.f308c;
        Object obj3 = this.f307b;
        switch (i10) {
            case 0:
                ((i) obj3).unlock(((e) obj2).f310b);
                return wVar;
            case 1:
                return DependencyDao_Impl.insertDependency$lambda$0((DependencyDao_Impl) obj3, (Dependency) obj2, (SQLiteConnection) obj);
            case 2:
                return PreferenceDao_Impl.insertPreference$lambda$0((PreferenceDao_Impl) obj3, (Preference) obj2, (SQLiteConnection) obj);
            case 3:
                return SystemIdInfoDao_Impl.insertSystemIdInfo$lambda$0((SystemIdInfoDao_Impl) obj3, (SystemIdInfo) obj2, (SQLiteConnection) obj);
            case 4:
                return WorkNameDao_Impl.insert$lambda$0((WorkNameDao_Impl) obj3, (WorkName) obj2, (SQLiteConnection) obj);
            case 5:
                return WorkProgressDao_Impl.insert$lambda$0((WorkProgressDao_Impl) obj3, (WorkProgress) obj2, (SQLiteConnection) obj);
            case 6:
                return WorkSpecDao_Impl.setOutput$lambda$41("UPDATE workspec SET output=? WHERE id=?", (Data) obj3, (String) obj2, (SQLiteConnection) obj);
            case 7:
                return Integer.valueOf(WorkSpecDao_Impl.setState$lambda$38("UPDATE workspec SET state=? WHERE id=?", (WorkInfo.State) obj3, (String) obj2, (SQLiteConnection) obj));
            case 8:
                return WorkTagDao_Impl.insert$lambda$0((WorkTagDao_Impl) obj3, (WorkTag) obj2, (SQLiteConnection) obj);
            case 9:
                PreferencesActivity preferencesActivity = (PreferencesActivity) obj3;
                x xVar = (x) obj2;
                int iIntValue = ((Integer) obj).intValue();
                int i11 = PreferencesActivity.M;
                boolean z9 = iIntValue != 0;
                try {
                    SharedPreferences.Editor editorEdit = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).edit();
                    editorEdit.putBoolean("storage_sdcard", z9);
                    editorEdit.apply();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                TextView textView = (TextView) xVar.f182c;
                if (iIntValue == 0) {
                    textView.setText(preferencesActivity.getString(R.string.internal_storage));
                } else {
                    textView.setText(preferencesActivity.getString(R.string.sd_card));
                }
                return wVar;
            case 10:
                String str = (String) obj2;
                MutablePreferences mutablePreferences = (MutablePreferences) obj;
                mutablePreferences.set(o2.i.f11707d, str);
                ((o2.i) obj3).h(mutablePreferences, str);
                return null;
            default:
                ((s7.c) obj3).f12714a.removeCallbacks((r5.a) obj2);
                return wVar;
        }
    }
}
