package l4;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.uptodown.activities.LoginActivity;
import com.uptodown.activities.RepliesActivity;
import com.uptodown.activities.SearchActivity;
import com.uptodown.views.InstantAutoCompleteTextView;
import java.util.Iterator;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class s1 implements TextView.OnEditorActionListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10808a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f10809b;

    public /* synthetic */ s1(w wVar, int i10) {
        this.f10808a = i10;
        this.f10809b = wVar;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
        int i11 = this.f10808a;
        w wVar = this.f10809b;
        switch (i11) {
            case 0:
                LoginActivity loginActivity = (LoginActivity) wVar;
                int i12 = LoginActivity.P;
                if (i10 == 6) {
                    loginActivity.y0();
                    break;
                }
                break;
            case 1:
                RepliesActivity repliesActivity = (RepliesActivity) wVar;
                int i13 = RepliesActivity.L;
                if (i10 != 6) {
                    break;
                } else {
                    repliesActivity.p0();
                    break;
                }
            default:
                SearchActivity searchActivity = (SearchActivity) wVar;
                int i14 = SearchActivity.Q;
                textView.getClass();
                if (i10 != 3) {
                    break;
                } else {
                    String string = textView.getText().toString();
                    if (string.length() > 0) {
                        Object systemService = searchActivity.getSystemService("input_method");
                        systemService.getClass();
                        ((InputMethodManager) systemService).hideSoftInputFromWindow(((InstantAutoCompleteTextView) searchActivity.o0().f7377b.f13463c).getWindowToken(), 0);
                        searchActivity.q0(0, string);
                        Bundle bundle = new Bundle();
                        bundle.putString(MimeTypes.BASE_TYPE_TEXT, string);
                        t1.c cVar = searchActivity.f10934v;
                        if (cVar != null) {
                            cVar.e(bundle, "search");
                        }
                        Pattern patternCompile = Pattern.compile("[^a-zA-Z0-9 ]+");
                        patternCompile.getClass();
                        String strReplaceAll = patternCompile.matcher(string).replaceAll("");
                        strReplaceAll.getClass();
                        String strValueOf = String.valueOf(System.currentTimeMillis());
                        v5.g gVarL = v5.g.f13148u.l(searchActivity);
                        gVarL.a();
                        Iterator it = gVarL.J().iterator();
                        it.getClass();
                        while (true) {
                            if (it.hasNext()) {
                                Object next = it.next();
                                next.getClass();
                                if (o7.u.Z(((h5.i0) next).f8614a, string, true)) {
                                }
                            } else {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("search", strReplaceAll);
                                contentValues.put(CampaignEx.JSON_KEY_TIMESTAMP, strValueOf);
                                SQLiteDatabase sQLiteDatabase = gVarL.f13150a;
                                sQLiteDatabase.getClass();
                                sQLiteDatabase.insert("recent_searches", null, contentValues);
                            }
                        }
                        gVarL.b();
                        ((InstantAutoCompleteTextView) searchActivity.o0().f7377b.f13463c).dismissDropDown();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
