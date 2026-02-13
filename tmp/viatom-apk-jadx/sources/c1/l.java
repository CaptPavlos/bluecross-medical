package c1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public long f1311a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f1312b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f1313c;

    public l(Context context, long j10, g5.i iVar, r7.w wVar) {
        context.getClass();
        wVar.getClass();
        this.f1312b = context;
        this.f1311a = j10;
        this.f1313c = iVar;
        if (j10 > 0) {
            r7.y.q(wVar, null, null, new c5.v(this, null, 0), 3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.List] */
    public List a() {
        ArrayList arrayList;
        n nVar = (n) this.f1313c;
        ArrayList arrayList2 = new ArrayList();
        String str = (String) this.f1312b;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = nVar.V().query("raw_events", new String[]{"rowid", RewardPlus.NAME, CampaignEx.JSON_KEY_TIMESTAMP, "metadata_fingerprint", DataSchemeDataSource.SCHEME_DATA, "realtime"}, "app_id = ? and rowid > ?", new String[]{str, String.valueOf(this.f1311a)}, null, null, "rowid", "1000");
                if (cursorQuery.moveToFirst()) {
                    do {
                        long j10 = cursorQuery.getLong(0);
                        long j11 = cursorQuery.getLong(3);
                        boolean z9 = cursorQuery.getLong(5) == 1;
                        byte[] blob = cursorQuery.getBlob(4);
                        if (j10 > this.f1311a) {
                            this.f1311a = j10;
                        }
                        try {
                            com.google.android.gms.internal.measurement.b3 b3Var = (com.google.android.gms.internal.measurement.b3) a1.T(com.google.android.gms.internal.measurement.c3.z(), blob);
                            String string = cursorQuery.getString(1);
                            if (string == null) {
                                string = "";
                            }
                            b3Var.b();
                            ((com.google.android.gms.internal.measurement.c3) b3Var.f2102b).F(string);
                            long j12 = cursorQuery.getLong(2);
                            b3Var.b();
                            ((com.google.android.gms.internal.measurement.c3) b3Var.f2102b).G(j12);
                            arrayList2.add(new k(j10, j11, z9, (com.google.android.gms.internal.measurement.c3) b3Var.d()));
                        } catch (IOException e) {
                            w0 w0Var = nVar.f1149a.f;
                            u1.m(w0Var);
                            w0Var.f.d(w0.o(str), "Data loss. Failed to merge raw event. appId", e);
                        }
                    } while (cursorQuery.moveToNext());
                } else {
                    arrayList = Collections.EMPTY_LIST;
                }
            } catch (SQLiteException e3) {
                w0 w0Var2 = nVar.f1149a.f;
                u1.m(w0Var2);
                w0Var2.f.d(w0.o(str), "Data loss. Error querying raw events batch. appId", e3);
                arrayList = arrayList2;
            }
            return arrayList;
        } finally {
            if (0 != 0) {
                cursorQuery.close();
            }
        }
    }

    public l(n nVar, String str, long j10) {
        this.f1313c = nVar;
        i0.y.d(str);
        this.f1312b = str;
        this.f1311a = nVar.R("select rowid from raw_events where app_id = ? and timestamp < ? order by rowid desc limit 1", new String[]{str, String.valueOf(j10)}, -1L);
    }

    public l(n nVar, String str) {
        this.f1313c = nVar;
        i0.y.d(str);
        this.f1312b = str;
        this.f1311a = -1L;
    }
}
