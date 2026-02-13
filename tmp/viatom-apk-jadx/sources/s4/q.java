package s4;

import android.os.Environment;
import androidx.appcompat.widget.SearchView;
import com.uptodown.core.activities.FileExplorerActivity;
import java.io.File;
import java.util.ArrayList;
import r7.w;
import w2.r;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12603a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r f12604b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList f12605c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(r rVar, ArrayList arrayList, w6.c cVar, int i10) {
        super(2, cVar);
        this.f12603a = i10;
        this.f12604b = rVar;
        this.f12605c = arrayList;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f12603a) {
            case 0:
                return new q(this.f12604b, this.f12605c, cVar, 0);
            default:
                return new q(this.f12604b, this.f12605c, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        w wVar = (w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f12603a) {
            case 0:
                q qVar = (q) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                qVar.invokeSuspend(wVar2);
                return wVar2;
            default:
                q qVar2 = (q) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                qVar2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f12603a) {
            case 0:
                s6.a.e(obj);
                i0.k kVar = (i0.k) this.f12604b.e;
                FileExplorerActivity fileExplorerActivity = (FileExplorerActivity) kVar.f8923b;
                ArrayList arrayList = this.f12605c;
                fileExplorerActivity.O = arrayList;
                fileExplorerActivity.N = arrayList;
                fileExplorerActivity.S = null;
                fileExplorerActivity.R = null;
                SearchView searchView = fileExplorerActivity.E;
                searchView.getClass();
                fileExplorerActivity.U(searchView.getQuery().toString(), (String) kVar.f8924c);
                break;
            default:
                s6.a.e(obj);
                i0.k kVar2 = (i0.k) this.f12604b.e;
                FileExplorerActivity fileExplorerActivity2 = (FileExplorerActivity) kVar2.f8923b;
                ArrayList arrayList2 = this.f12605c;
                fileExplorerActivity2.S = arrayList2;
                fileExplorerActivity2.R = arrayList2;
                fileExplorerActivity2.O = null;
                fileExplorerActivity2.N = null;
                File file = fileExplorerActivity2.T;
                if (file != null && !file.canRead()) {
                    ArrayList arrayList3 = fileExplorerActivity2.S;
                    arrayList3.getClass();
                    if (arrayList3.isEmpty()) {
                        File externalStorageDirectory = Environment.getExternalStorageDirectory();
                        File file2 = fileExplorerActivity2.T;
                        file2.getClass();
                        if (file2.getAbsolutePath().equals(externalStorageDirectory.getAbsolutePath() + "/Android/data")) {
                            File file3 = new File(fileExplorerActivity2.T, fileExplorerActivity2.getPackageName());
                            if (file3.exists() && file3.canRead()) {
                                ArrayList arrayList4 = new ArrayList();
                                arrayList4.add(new File(fileExplorerActivity2.T, fileExplorerActivity2.getPackageName()));
                                fileExplorerActivity2.S = arrayList4;
                                fileExplorerActivity2.R = arrayList4;
                            }
                        }
                    }
                }
                SearchView searchView2 = fileExplorerActivity2.E;
                searchView2.getClass();
                fileExplorerActivity2.U(searchView2.getQuery().toString(), (String) kVar2.f8924c);
                break;
        }
        return s6.w.f12711a;
    }
}
