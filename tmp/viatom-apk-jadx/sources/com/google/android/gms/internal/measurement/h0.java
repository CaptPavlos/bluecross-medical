package com.google.android.gms.internal.measurement;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class h0 extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1975a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(Looper looper, int i10) {
        super(looper);
        this.f1975a = i10;
        switch (i10) {
            case 3:
                super(looper);
                Looper.getMainLooper();
                break;
            case 4:
            default:
                Looper.getMainLooper();
                break;
            case 5:
                super(looper);
                Looper.getMainLooper();
                break;
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (this.f1975a) {
            case 1:
                int i10 = message.what;
                if (i10 == 3) {
                    j4.b bVar = (j4.b) message.obj;
                    bVar.f9917a.a(bVar.d());
                    return;
                }
                if (i10 != 8) {
                    if (i10 != 13) {
                        throw new AssertionError("Unknown handler message received: " + message.what);
                    }
                    List list = (List) message.obj;
                    int size = list.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        j4.b bVar2 = (j4.b) list.get(i11);
                        j4.y yVar = bVar2.f9917a;
                        Bitmap bitmapG = yVar.g(bVar2.f9920d);
                        if (bitmapG != null) {
                            yVar.b(bitmapG, 1, bVar2, null);
                        } else {
                            yVar.c(bVar2);
                        }
                    }
                    return;
                }
                List list2 = (List) message.obj;
                int size2 = list2.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    j4.f fVar = (j4.f) list2.get(i12);
                    j4.y yVar2 = fVar.f9943b;
                    yVar2.getClass();
                    j4.b bVar3 = fVar.f9947j;
                    ArrayList arrayList = fVar.f9948k;
                    boolean z9 = (arrayList == null || arrayList.isEmpty()) ? false : true;
                    if (bVar3 != null || z9) {
                        Object obj = fVar.g.f9925b;
                        Exception exc = fVar.f9952o;
                        Bitmap bitmap = fVar.f9949l;
                        int i13 = fVar.f9951n;
                        if (bVar3 != null) {
                            yVar2.b(bitmap, i13, bVar3, exc);
                        }
                        if (z9) {
                            int size3 = arrayList.size();
                            for (int i14 = 0; i14 < size3; i14++) {
                                yVar2.b(bitmap, i13, (j4.b) arrayList.get(i14), exc);
                            }
                        }
                    }
                }
                return;
            case 2:
                sendMessageDelayed(obtainMessage(), 1000L);
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h0(Looper looper, Handler.Callback callback, int i10) {
        super(looper, callback);
        this.f1975a = i10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h0(Looper looper, int i10, boolean z9) {
        super(looper);
        this.f1975a = i10;
    }
}
