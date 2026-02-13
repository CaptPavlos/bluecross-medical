package l4;

import android.content.SharedPreferences;
import android.content.res.Resources;
import com.uptodown.R;
import com.uptodown.activities.LanguageSettingsActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f1 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10380a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LanguageSettingsActivity f10381b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f1(LanguageSettingsActivity languageSettingsActivity, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10380a = i10;
        this.f10381b = languageSettingsActivity;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10380a) {
            case 0:
                return new f1(this.f10381b, cVar, 0);
            default:
                return new f1(this.f10381b, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) throws Resources.NotFoundException {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10380a) {
            case 0:
                f1 f1Var = (f1) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                f1Var.invokeSuspend(wVar2);
                return wVar2;
            default:
                f1 f1Var2 = (f1) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                f1Var2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Resources.NotFoundException {
        int i10 = this.f10380a;
        s6.w wVar = s6.w.f12711a;
        LanguageSettingsActivity languageSettingsActivity = this.f10381b;
        switch (i10) {
            case 0:
                s6.a.e(obj);
                int i11 = LanguageSettingsActivity.L;
                languageSettingsActivity.o0().f7381b.setVisibility(0);
                break;
            default:
                ArrayList arrayListA = androidx.constraintlayout.core.widgets.analyzer.a.A(obj);
                String[] stringArray = languageSettingsActivity.getResources().getStringArray(R.array.languages);
                stringArray.getClass();
                String[] stringArray2 = languageSettingsActivity.getResources().getStringArray(R.array.languageCodes);
                stringArray2.getClass();
                String[] stringArray3 = languageSettingsActivity.getResources().getStringArray(R.array.localizedLang);
                stringArray3.getClass();
                int length = stringArray.length;
                for (int i12 = 0; i12 < length; i12++) {
                    String str = stringArray[i12];
                    h5.z zVar = new h5.z();
                    zVar.f8800a = str;
                    zVar.f8801b = stringArray3[i12];
                    zVar.f8802c = stringArray2[i12];
                    arrayListA.add(zVar);
                }
                String string = null;
                try {
                    SharedPreferences sharedPreferences = languageSettingsActivity.getSharedPreferences("SettingsPreferences", 0);
                    if (sharedPreferences.contains("Language")) {
                        string = sharedPreferences.getString("Language", null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (string == null) {
                    string = "en";
                }
                languageSettingsActivity.H = new n4.o(arrayListA, languageSettingsActivity.I, string);
                break;
        }
        return wVar;
    }
}
