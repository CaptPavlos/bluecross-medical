package s5;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.SharedPreferences;
import androidx.documentfile.provider.DocumentFile;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.widget.ArrayObjectAdapter;
import com.uptodown.R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12652a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f12653b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f12654c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m0(Object obj, Object obj2, w6.c cVar, int i10) {
        super(2, cVar);
        this.f12652a = i10;
        this.f12653b = obj;
        this.f12654c = obj2;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f12652a) {
            case 0:
                return new m0((p0) this.f12653b, (kotlin.jvm.internal.x) this.f12654c, cVar, 0);
            case 1:
                return new m0((InputStream) this.f12653b, (FileOutputStream) this.f12654c, cVar, 1);
            case 2:
                return new m0((p4.d0) this.f12653b, (String) this.f12654c, cVar, 2);
            case 3:
                return new m0((t1.c) this.f12653b, (File) this.f12654c, cVar, 3);
            case 4:
                return new m0((b9.h) this.f12653b, (File) this.f12654c, cVar, 4);
            default:
                return new m0((b9.h) this.f12653b, (DocumentFile) this.f12654c, cVar, 5);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) throws IOException {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f12652a) {
            case 0:
                m0 m0Var = (m0) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                m0Var.invokeSuspend(wVar2);
                return wVar2;
            case 1:
                m0 m0Var2 = (m0) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                m0Var2.invokeSuspend(wVar3);
                return wVar3;
            case 2:
                return ((m0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
            case 3:
                return ((m0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
            case 4:
                m0 m0Var3 = (m0) create(wVar, cVar);
                s6.w wVar4 = s6.w.f12711a;
                m0Var3.invokeSuspend(wVar4);
                return wVar4;
            default:
                m0 m0Var4 = (m0) create(wVar, cVar);
                s6.w wVar5 = s6.w.f12711a;
                m0Var4.invokeSuspend(wVar5);
                return wVar5;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws IOException {
        switch (this.f12652a) {
            case 0:
                s6.a.e(obj);
                p0 p0Var = (p0) this.f12653b;
                ArrayList arrayList = (ArrayList) ((kotlin.jvm.internal.x) this.f12654c).f10138a;
                if (arrayList != null && !arrayList.isEmpty()) {
                    int size = arrayList.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        ArrayObjectAdapter arrayObjectAdapter = p0Var.f12665a;
                        if (arrayObjectAdapter != null) {
                            arrayObjectAdapter.add(arrayList.get(i10));
                        }
                    }
                } else if (p0Var.getContext() != null) {
                    String string = p0Var.getString(R.string.no_data_available);
                    string.getClass();
                    FragmentActivity activity = p0Var.getActivity();
                    if (activity != null && !activity.isFinishing()) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                        builder.setMessage(string);
                        builder.setPositiveButton(android.R.string.ok, new r5.c(11));
                        builder.setCancelable(true);
                        builder.create().show();
                    }
                }
                p0Var.f12668d = false;
                return s6.w.f12711a;
            case 1:
                FileOutputStream fileOutputStream = (FileOutputStream) this.f12654c;
                InputStream inputStream = (InputStream) this.f12653b;
                s6.a.e(obj);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i11 = inputStream.read(bArr);
                        if (i11 <= 0) {
                            try {
                                inputStream.close();
                            } catch (Exception unused) {
                            }
                            try {
                                fileOutputStream.close();
                            } catch (Exception unused2) {
                            }
                            return s6.w.f12711a;
                        }
                        fileOutputStream.write(bArr, 0, i11);
                    }
                } finally {
                }
            case 2:
                s6.a.e(obj);
                p4.d0 d0Var = (p4.d0) this.f12653b;
                if (d0Var == null) {
                    return null;
                }
                d0Var.f11935a.O(((String) this.f12654c).concat(" could not be parsed."));
                return s6.w.f12711a;
            case 3:
                File file = (File) this.f12654c;
                t1.c cVar = (t1.c) this.f12653b;
                s6.w wVar = s6.w.f12711a;
                s6.a.e(obj);
                try {
                    boolean z9 = false;
                    try {
                        SharedPreferences sharedPreferences = ((Activity) cVar.f12751b).getSharedPreferences("CoreSettings", 0);
                        if (sharedPreferences.contains("system_app")) {
                            z9 = sharedPreferences.getBoolean("system_app", false);
                        }
                    } catch (Exception unused3) {
                    }
                    if (z9) {
                        t1.c.a(cVar, file);
                    } else {
                        p4.a0 a0Var = (p4.a0) cVar.f12752c;
                        if (a0Var != null) {
                            file.getPath();
                            a0Var.f11920a.O("error: not system permissions");
                        } else {
                            wVar = null;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return wVar;
            case 4:
                s6.a.e(obj);
                b9.h hVar = (b9.h) this.f12653b;
                String name = ((File) this.f12654c).getName();
                name.getClass();
                hVar.i(name);
                return s6.w.f12711a;
            default:
                s6.a.e(obj);
                b9.h hVar2 = (b9.h) this.f12653b;
                String name2 = ((DocumentFile) this.f12654c).getName();
                name2.getClass();
                hVar2.i(name2);
                return s6.w.f12711a;
        }
    }
}
