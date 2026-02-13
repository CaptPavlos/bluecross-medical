package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k extends a {

    /* renamed from: a, reason: collision with root package name */
    private static String f3480a = "ReplaceTempDao";

    /* renamed from: b, reason: collision with root package name */
    private static k f3481b;

    private k(f fVar) {
        super(fVar);
    }

    private boolean b(String str) {
        Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT d_value FROM c_replace_temp WHERE d_key= ? ", new String[]{str});
        if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
            try {
                cursorRawQuery.close();
                return true;
            } catch (Exception unused) {
                return true;
            }
        }
        if (cursorRawQuery == null) {
            return false;
        }
        try {
            cursorRawQuery.close();
            return false;
        } catch (Exception unused2) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final org.json.JSONObject a() {
        /*
            r6 = this;
            r0 = 604800000(0x240c8400, float:3.046947E-17)
            long r0 = (long) r0
            long r2 = java.lang.System.currentTimeMillis()
            long r2 = r2 - r0
            android.database.sqlite.SQLiteDatabase r0 = r6.getWritableDatabase()     // Catch: java.lang.Exception -> L24
            if (r0 != 0) goto L10
            goto L28
        L10:
            android.database.sqlite.SQLiteDatabase r0 = r6.getWritableDatabase()     // Catch: java.lang.Exception -> L24
            java.lang.String r1 = "c_replace_temp"
            java.lang.String r4 = "time<?"
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Exception -> L24
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch: java.lang.Exception -> L24
            r0.delete(r1, r4, r2)     // Catch: java.lang.Exception -> L24
            goto L28
        L24:
            r0 = move-exception
            r0.printStackTrace()
        L28:
            java.lang.String r0 = "SELECT * FROM c_replace_temp"
            android.database.sqlite.SQLiteDatabase r1 = r6.getReadableDatabase()
            r2 = 0
            android.database.Cursor r0 = r1.rawQuery(r0, r2)
            if (r0 == 0) goto L6c
            int r1 = r0.getCount()     // Catch: java.lang.Throwable -> L67
            if (r1 <= 0) goto L6c
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L67
            r1.<init>()     // Catch: java.lang.Throwable -> L67
        L40:
            boolean r2 = r0.moveToNext()     // Catch: java.lang.Throwable -> L63
            if (r2 == 0) goto L65
            java.lang.String r2 = "d_key"
            int r2 = r0.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L63
            java.lang.String r2 = r0.getString(r2)     // Catch: java.lang.Throwable -> L63
            java.lang.String r3 = "d_value"
            int r3 = r0.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L63
            java.lang.String r3 = r0.getString(r3)     // Catch: java.lang.Throwable -> L63
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L63
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L63
            r1.put(r2, r4)     // Catch: java.lang.Throwable -> L63
            goto L40
        L63:
            r2 = move-exception
            goto L72
        L65:
            r2 = r1
            goto L88
        L67:
            r1 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
            goto L72
        L6c:
            if (r0 == 0) goto L88
            r0.close()     // Catch: java.lang.Throwable -> L67
            goto L88
        L72:
            java.lang.String r3 = com.mbridge.msdk.foundation.db.k.f3480a     // Catch: java.lang.Throwable -> L81
            java.lang.String r2 = r2.getMessage()     // Catch: java.lang.Throwable -> L81
            com.mbridge.msdk.foundation.tools.af.b(r3, r2)     // Catch: java.lang.Throwable -> L81
            if (r0 == 0) goto L8e
            r0.close()     // Catch: java.lang.Exception -> L8e
            goto L8e
        L81:
            r1 = move-exception
            if (r0 == 0) goto L87
            r0.close()     // Catch: java.lang.Exception -> L87
        L87:
            throw r1
        L88:
            if (r0 == 0) goto L8d
            r0.close()     // Catch: java.lang.Exception -> L8d
        L8d:
            r1 = r2
        L8e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.k.a():org.json.JSONObject");
    }

    public final void a(String str, JSONObject jSONObject) {
        try {
            if (getWritableDatabase() == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("d_key", str);
            contentValues.put("d_value", jSONObject.toString());
            contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
            if (!b(str)) {
                getWritableDatabase().insert("c_replace_temp", null, contentValues);
            } else {
                getWritableDatabase().update("c_replace_temp", contentValues, "d_key = ? ", new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final org.json.JSONObject a(java.lang.String r4) {
        /*
            r3 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            java.lang.String[] r4 = new java.lang.String[]{r4}
            android.database.sqlite.SQLiteDatabase r0 = r3.getReadableDatabase()
            java.lang.String r2 = "SELECT * FROM c_replace_temp WHERE d_key = ? "
            android.database.Cursor r4 = r0.rawQuery(r2, r4)
            if (r4 == 0) goto L3d
            int r0 = r4.getCount()     // Catch: java.lang.Throwable -> L3b
            if (r0 <= 0) goto L3d
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L3b
            r0.<init>()     // Catch: java.lang.Throwable -> L3b
            r1 = r0
        L24:
            boolean r0 = r4.moveToNext()     // Catch: java.lang.Throwable -> L3b
            if (r0 == 0) goto L59
            java.lang.String r0 = "d_value"
            int r0 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r0 = r4.getString(r0)     // Catch: java.lang.Throwable -> L3b
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L3b
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L3b
            r1 = r2
            goto L24
        L3b:
            r0 = move-exception
            goto L43
        L3d:
            if (r4 == 0) goto L59
            r4.close()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L59
            goto L59
        L43:
            java.lang.String r2 = com.mbridge.msdk.foundation.db.k.f3480a     // Catch: java.lang.Throwable -> L52
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L52
            com.mbridge.msdk.foundation.tools.af.b(r2, r0)     // Catch: java.lang.Throwable -> L52
            if (r4 == 0) goto L5c
        L4e:
            r4.close()     // Catch: java.lang.Exception -> L5c
            goto L5c
        L52:
            r0 = move-exception
            if (r4 == 0) goto L58
            r4.close()     // Catch: java.lang.Exception -> L58
        L58:
            throw r0
        L59:
            if (r4 == 0) goto L5c
            goto L4e
        L5c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.k.a(java.lang.String):org.json.JSONObject");
    }

    public static k a(f fVar) {
        if (f3481b == null) {
            synchronized (e.class) {
                try {
                    if (f3481b == null) {
                        f3481b = new k(fVar);
                    }
                } finally {
                }
            }
        }
        return f3481b;
    }
}
