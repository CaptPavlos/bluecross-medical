package s4;

import androidx.documentfile.provider.DocumentFile;
import java.io.File;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import r7.i0;
import r7.w;
import r7.y;
import w2.r;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12600a;

    /* renamed from: b, reason: collision with root package name */
    public int f12601b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r f12602c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(r rVar, w6.c cVar, int i10) {
        super(2, cVar);
        this.f12600a = i10;
        this.f12602c = rVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f12600a) {
            case 0:
                return new p(this.f12602c, cVar, 0);
            default:
                return new p(this.f12602c, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        w wVar = (w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f12600a) {
        }
        return ((p) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i10 = this.f12600a;
        s6.w wVar = s6.w.f12711a;
        x6.a aVar = x6.a.f13718a;
        r rVar = this.f12602c;
        int i11 = 1;
        w6.c cVar = null;
        switch (i10) {
            case 0:
                int i12 = this.f12601b;
                if (i12 != 0) {
                    if (i12 == 1) {
                        s6.a.e(obj);
                        return wVar;
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                this.f12601b = 1;
                y7.e eVar = i0.f12407a;
                Object objZ = y.z(new p(rVar, cVar, i11), y7.d.f14116a, this);
                if (objZ != aVar) {
                    objZ = wVar;
                }
                return objZ == aVar ? aVar : wVar;
            default:
                int i13 = this.f12601b;
                try {
                    if (i13 != 0) {
                        if (i13 == 1 || i13 == 2) {
                            s6.a.e(obj);
                            return wVar;
                        }
                        androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    s6.a.e(obj);
                    DocumentFile documentFile = (DocumentFile) rVar.f13462b;
                    int i14 = 0;
                    if (documentFile != null) {
                        DocumentFile[] documentFileArrListFiles = documentFile.listFiles();
                        documentFileArrListFiles.getClass();
                        ArrayList arrayList = new ArrayList();
                        for (DocumentFile documentFile2 : documentFileArrListFiles) {
                            if (documentFile2.getName() != null) {
                                arrayList.add(documentFile2);
                                String path = documentFile2.getUri().getPath();
                                if (path != null) {
                                    String name = documentFile2.getName();
                                    name.getClass();
                                    r.o(rVar, path, name);
                                }
                            }
                        }
                        y7.e eVar2 = i0.f12407a;
                        s7.c cVar2 = w7.n.f13548a;
                        q qVar = new q(rVar, arrayList, cVar, i14);
                        this.f12601b = 1;
                        if (y.z(qVar, cVar2, this) != aVar) {
                            return wVar;
                        }
                    } else {
                        File file = (File) rVar.f13463c;
                        if (file == null) {
                            return wVar;
                        }
                        File[] fileArrListFiles = file.listFiles();
                        ArrayList arrayList2 = new ArrayList();
                        if (fileArrListFiles != null) {
                            while (i14 < fileArrListFiles.length) {
                                int i15 = i14 + 1;
                                try {
                                    File file2 = fileArrListFiles[i14];
                                    arrayList2.add(file2);
                                    String path2 = file2.getPath();
                                    path2.getClass();
                                    String name2 = file2.getName();
                                    name2.getClass();
                                    r.o(rVar, path2, name2);
                                    i14 = i15;
                                } catch (ArrayIndexOutOfBoundsException e) {
                                    throw new NoSuchElementException(e.getMessage());
                                }
                            }
                        }
                        y7.e eVar3 = i0.f12407a;
                        s7.c cVar3 = w7.n.f13548a;
                        q qVar2 = new q(rVar, arrayList2, cVar, i11);
                        this.f12601b = 2;
                        if (y.z(qVar2, cVar3, this) != aVar) {
                            return wVar;
                        }
                    }
                    return aVar;
                } catch (Error e3) {
                    e3.printStackTrace();
                    return wVar;
                } catch (Exception e7) {
                    e7.printStackTrace();
                    return wVar;
                }
        }
    }
}
