package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.al;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class d extends a<JumpLoaderResult> {

    /* renamed from: a, reason: collision with root package name */
    public static final String f3453a = "d";

    /* renamed from: b, reason: collision with root package name */
    private static d f3454b;

    private d(f fVar) {
        super(fVar);
    }

    private synchronized boolean c(String str, String str2) {
        Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT id FROM campaignclick WHERE id= ? AND unitid= ?", new String[]{str, str2});
        if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
            cursorRawQuery.close();
            return true;
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return false;
    }

    public final synchronized long a(CampaignEx campaignEx, String str) {
        if (campaignEx == null) {
            return 0L;
        }
        try {
            try {
                String strA = al.a(campaignEx.getJumpResult());
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", campaignEx.getId());
                contentValues.put("unitid", str);
                contentValues.put("result", strA);
                contentValues.put("cti", Integer.valueOf(campaignEx.getClickInterval() * 1000));
                contentValues.put(CampaignEx.JSON_KEY_PACKAGE_NAME, campaignEx.getPackageName());
                com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
                contentValues.put(CampaignEx.JSON_KEY_ST_TS, Long.valueOf(System.currentTimeMillis()));
                if (gVarB != null && gVarB.aa() > 0) {
                    contentValues.put("cpei", Integer.valueOf(gVarB.aa() * 1000));
                }
                if (gVarB != null && gVarB.ab() > 0) {
                    contentValues.put("cpoci", Integer.valueOf(gVarB.ab() * 1000));
                }
                if (!c(campaignEx.getId(), str)) {
                    return getWritableDatabase().insert("campaignclick", null, contentValues);
                }
                if (getWritableDatabase() == null) {
                    return -1L;
                }
                return getWritableDatabase().update("campaignclick", contentValues, "id = ? AND unitid = ? ", new String[]{campaignEx.getId(), str});
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    af.b(f3453a, e.getMessage());
                }
                return -1L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c A[Catch: all -> 0x0040, PHI: r12
      0x004c: PHI (r12v4 android.database.Cursor) = (r12v3 android.database.Cursor), (r12v5 android.database.Cursor) binds: [B:32:0x0063, B:22:0x004a] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:13:0x003b, B:23:0x004c, B:37:0x006a, B:38:0x006d), top: B:41:0x0002 }] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized com.mbridge.msdk.click.entity.JumpLoaderResult b(java.lang.String r12, java.lang.String r13) {
        /*
            r11 = this;
            monitor-enter(r11)
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r11.getReadableDatabase()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            java.lang.String r3 = "campaignclick"
            java.lang.String r5 = "id=? AND unitid=?"
            java.lang.String[] r6 = new java.lang.String[]{r12, r13}     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            r9 = 0
            r10 = 0
            r4 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            if (r12 == 0) goto L4a
            int r13 = r12.getCount()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L47
            if (r13 <= 0) goto L4a
            boolean r13 = r12.moveToFirst()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L47
            if (r13 == 0) goto L4a
            java.lang.String r13 = "result"
            int r13 = r12.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L47
            java.lang.String r13 = r12.getString(r13)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L47
            boolean r0 = android.text.TextUtils.isEmpty(r13)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L47
            if (r0 != 0) goto L4a
            java.lang.Object r13 = com.mbridge.msdk.foundation.tools.al.a(r13)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L47
            com.mbridge.msdk.click.entity.JumpLoaderResult r13 = (com.mbridge.msdk.click.entity.JumpLoaderResult) r13     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L47
            r12.close()     // Catch: java.lang.Throwable -> L40
            monitor-exit(r11)
            return r13
        L40:
            r0 = move-exception
            r12 = r0
            goto L6e
        L43:
            r0 = move-exception
            r13 = r0
            r1 = r12
            goto L68
        L47:
            r0 = move-exception
            r13 = r0
            goto L56
        L4a:
            if (r12 == 0) goto L66
        L4c:
            r12.close()     // Catch: java.lang.Throwable -> L40
            goto L66
        L50:
            r0 = move-exception
            r13 = r0
            goto L68
        L53:
            r0 = move-exception
            r13 = r0
            r12 = r1
        L56:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch: java.lang.Throwable -> L43
            if (r0 == 0) goto L63
            java.lang.String r0 = com.mbridge.msdk.foundation.db.d.f3453a     // Catch: java.lang.Throwable -> L43
            java.lang.String r13 = r13.getMessage()     // Catch: java.lang.Throwable -> L43
            com.mbridge.msdk.foundation.tools.af.b(r0, r13)     // Catch: java.lang.Throwable -> L43
        L63:
            if (r12 == 0) goto L66
            goto L4c
        L66:
            monitor-exit(r11)
            return r1
        L68:
            if (r1 == 0) goto L6d
            r1.close()     // Catch: java.lang.Throwable -> L40
        L6d:
            throw r13     // Catch: java.lang.Throwable -> L40
        L6e:
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L40
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.d.b(java.lang.String, java.lang.String):com.mbridge.msdk.click.entity.JumpLoaderResult");
    }

    public final synchronized void a() {
        try {
            getWritableDatabase().delete("campaignclick", " ( " + System.currentTimeMillis() + " - ts) > cti", null);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.b(f3453a, e.getMessage());
            }
        }
    }

    public static synchronized d a(f fVar) {
        try {
            if (f3454b == null) {
                f3454b = new d(fVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f3454b;
    }

    public final synchronized boolean a(String str, String str2) {
        try {
            Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT id FROM campaignclick WHERE id= ? AND unitid= ? AND cti + ts > " + System.currentTimeMillis(), new String[]{str, str2});
            if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
                cursorRawQuery.close();
                return true;
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return false;
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.b(f3453a, e.getMessage());
            }
            return false;
        }
    }
}
