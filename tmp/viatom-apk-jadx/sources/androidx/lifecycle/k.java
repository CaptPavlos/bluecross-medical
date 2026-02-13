package androidx.lifecycle;

import com.uptodown.activities.MyDownloads;
import com.uptodown.workers.DownloadWorker;
import g8.n0;
import o7.m;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class k implements g7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f591a;

    public /* synthetic */ k(n0 n0Var) {
        this.f591a = 11;
    }

    @Override // g7.a
    public final Object invoke() {
        int i10 = this.f591a;
        w wVar = w.f12711a;
        switch (i10) {
            case 9:
                if (DownloadWorker.f) {
                    DownloadWorker.f = false;
                    DownloadWorker.e = false;
                    break;
                }
                break;
            case 10:
                if (DownloadWorker.f) {
                    DownloadWorker.f = false;
                    DownloadWorker.e = false;
                    break;
                }
                break;
            case 11:
                e8.i iVar = e8.i.f;
                e8.e[] eVarArr = new e8.e[0];
                if (!m.l0("kotlin.Unit")) {
                    if (!iVar.equals(e8.i.f7973c)) {
                        e8.a aVar = new e8.a("kotlin.Unit");
                        break;
                    } else {
                        com.google.gson.internal.a.n("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
                        break;
                    }
                } else {
                    com.google.gson.internal.a.n("Blank serial names are prohibited");
                    break;
                }
            case 17:
                int i11 = i4.c.h;
                break;
            case 18:
                int i12 = MyDownloads.O;
                DownloadWorker.f = false;
                DownloadWorker.e = false;
                break;
        }
        return wVar;
    }

    public /* synthetic */ k(int i10) {
        this.f591a = i10;
    }
}
