package com.uptodown.workers;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.mbridge.msdk.MBridgeConstans;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import o4.b;
import o7.u;
import r0.f;
import t3.h;
import v5.g;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class SearchApksWorker extends Worker {

    /* renamed from: a, reason: collision with root package name */
    public final Context f6749a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchApksWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
        this.f6749a = context;
        Activity activity = b.g;
        this.f6749a = f.h(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(java.io.File r20, int r21) {
        /*
            Method dump skipped, instructions count: 427
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.SearchApksWorker.d(java.io.File, int):boolean");
    }

    @Override // androidx.work.Worker
    public final ListenableWorker.Result doWork() {
        boolean z9;
        Context context = this.f6749a;
        ListenableWorker.Result resultSuccess = ListenableWorker.Result.success();
        resultSuccess.getClass();
        try {
            ArrayList arrayListP = h.p(context);
            g gVarL = g.f13148u.l(context);
            gVarL.a();
            ArrayList arrayListG = gVarL.G();
            Iterator it = arrayListP.iterator();
            it.getClass();
            int i10 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                File file = (File) next;
                Iterator it2 = arrayListG.iterator();
                int i11 = 0;
                while (true) {
                    if (!it2.hasNext()) {
                        i11 = -1;
                        z9 = false;
                        break;
                    }
                    int i12 = i11 + 1;
                    if (u.Z(file.getAbsolutePath(), (String) it2.next(), false)) {
                        z9 = true;
                        break;
                    }
                    i11 = i12;
                }
                if (z9) {
                    arrayListG.remove(i11);
                } else if (i10 < 10 && d(file, i10)) {
                    String absolutePath = file.getAbsolutePath();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, absolutePath);
                    SQLiteDatabase sQLiteDatabase = gVarL.f13150a;
                    sQLiteDatabase.getClass();
                    sQLiteDatabase.insert("installable_files", null, contentValues);
                    i10++;
                }
            }
            Iterator it3 = arrayListG.iterator();
            it3.getClass();
            while (it3.hasNext()) {
                Object next2 = it3.next();
                next2.getClass();
                SQLiteDatabase sQLiteDatabase2 = gVarL.f13150a;
                sQLiteDatabase2.getClass();
                sQLiteDatabase2.delete("installable_files", "path=?", new String[]{(String) next2});
            }
            gVarL.b();
            return resultSuccess;
        } catch (Exception e) {
            e.printStackTrace();
            ListenableWorker.Result resultFailure = ListenableWorker.Result.failure();
            resultFailure.getClass();
            return resultFailure;
        }
    }
}
