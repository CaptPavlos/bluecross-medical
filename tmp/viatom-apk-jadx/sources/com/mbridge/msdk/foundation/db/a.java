package com.mbridge.msdk.foundation.db;

import android.database.sqlite.SQLiteDatabase;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class a<T> {
    protected f mHelper;

    public a(f fVar) {
        this.mHelper = fVar;
    }

    public synchronized SQLiteDatabase getReadableDatabase() {
        try {
        } catch (Exception unused) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            af.a("BaseDao", "getReadableDatabase error");
            return null;
        }
        return this.mHelper.c();
    }

    public synchronized SQLiteDatabase getWritableDatabase() {
        try {
        } catch (Exception unused) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            af.a("BaseDao", "getWritableDatabase error");
            return null;
        }
        return this.mHelper.d();
    }
}
