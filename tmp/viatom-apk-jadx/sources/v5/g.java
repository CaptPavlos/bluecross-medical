package v5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import h5.g0;
import h5.i0;
import h5.j0;
import h5.q;
import h5.q0;
import h5.r;
import h5.s;
import h5.t;
import h5.w;
import h5.y0;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import o7.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g extends SQLiteOpenHelper {

    /* renamed from: u, reason: collision with root package name */
    public static final t3.h f13148u = new t3.h(10);

    /* renamed from: v, reason: collision with root package name */
    public static g f13149v;

    /* renamed from: a, reason: collision with root package name */
    public SQLiteDatabase f13150a;

    /* renamed from: b, reason: collision with root package name */
    public final String[] f13151b;

    /* renamed from: c, reason: collision with root package name */
    public final String[] f13152c;

    /* renamed from: d, reason: collision with root package name */
    public final String[] f13153d;
    public final String[] e;
    public final String[] f;
    public final String[] g;
    public final String[] h;

    /* renamed from: i, reason: collision with root package name */
    public final String[] f13154i;

    /* renamed from: j, reason: collision with root package name */
    public final String[] f13155j;

    /* renamed from: k, reason: collision with root package name */
    public final String[] f13156k;

    /* renamed from: l, reason: collision with root package name */
    public final String[] f13157l;

    /* renamed from: m, reason: collision with root package name */
    public final String[] f13158m;

    /* renamed from: n, reason: collision with root package name */
    public final String[] f13159n;

    /* renamed from: o, reason: collision with root package name */
    public final String[] f13160o;

    /* renamed from: p, reason: collision with root package name */
    public final String[] f13161p;

    /* renamed from: q, reason: collision with root package name */
    public final String[] f13162q;

    /* renamed from: r, reason: collision with root package name */
    public final String[] f13163r;

    /* renamed from: s, reason: collision with root package name */
    public final String[] f13164s;
    public final AtomicInteger t;

    public g(Context context) {
        super(context, "Uptodown.db", (SQLiteDatabase.CursorFactory) null, 688);
        this.f13151b = new String[]{"id", RewardPlus.NAME, "packagename", "versionCode", "issystemapp", "isSystemService", "urlFicha", "md5signature", "exclude", "size", "excludeFromTracking", "defaultName", "sha256", "positiveNotified", "appID", "hasOldVersions", "trackInfoRegistered"};
        this.f13152c = new String[]{"id", MBridgeConstans.APP_ID, "sha256", "size", MBridgeConstans.DYNAMIC_VIEW_WX_PATH};
        this.f13153d = new String[]{"id", "packagename", "versionCode", "versionName", "notified", "ignoreVersion", "isPartialUpdate", "newFeatures", "installationAttempts"};
        this.e = new String[]{"id", "packagename", "checked", "incomplete", "versioncode", "versionname", "attempts", "idPrograma", "downloadAnyway", "md5signature", "supportedAbis", "minsdk", "urlIcon", "appName", "nextAttemptTimeStamp", "updateId", "deeplink"};
        this.f = new String[]{"id", "downloadId", "fileId", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "size", "size_downloaded", "filehash", "absolutePath", "attempts", "nextAttemptTimeStamp"};
        this.g = new String[]{"id", "appId", "categoryFrom"};
        this.h = new String[]{"search", CampaignEx.JSON_KEY_TIMESTAMP};
        this.f13154i = new String[]{"id", MBridgeConstans.DYNAMIC_VIEW_WX_PATH};
        this.f13155j = new String[]{"id", CampaignEx.JSON_KEY_TIMESTAMP, CampaignEx.JSON_KEY_TITLE, NotificationCompat.CATEGORY_MESSAGE, "actions", "extra_info"};
        this.f13156k = new String[]{"appId", "automaticDownload"};
        this.f13157l = new String[]{"appId"};
        this.f13158m = new String[]{MBridgeConstans.DYNAMIC_VIEW_WX_PATH, "date"};
        this.f13159n = new String[]{"id", "notificationId", "packagename", "versioncode", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY};
        this.f13160o = new String[]{"id", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "json", CampaignEx.JSON_KEY_TIMESTAMP};
        this.f13161p = new String[]{"id", "json", CampaignEx.JSON_KEY_TIMESTAMP};
        this.f13162q = new String[]{"id", "json", CampaignEx.JSON_KEY_TIMESTAMP};
        this.f13163r = new String[]{RewardPlus.NAME};
        this.f13164s = new String[]{"id", "appId", "sourceDeviceName", "downloadId"};
        this.t = new AtomicInteger();
    }

    public static h5.b S(Cursor cursor) {
        h5.a aVar;
        int i10 = cursor.getInt(0);
        int i11 = cursor.getInt(1);
        String string = cursor.getString(2);
        String string2 = cursor.getString(3);
        string.getClass();
        string2.getClass();
        h5.b bVar = new h5.b(string, Long.parseLong(string2));
        bVar.f8470c = i10;
        bVar.f8471d = i11;
        int i12 = cursor.getInt(4);
        if (i12 == 0) {
            aVar = h5.a.f8457a;
        } else {
            if (i12 != 1) {
                z8.f.a();
                return null;
            }
            aVar = h5.a.f8458b;
        }
        bVar.e = aVar;
        return bVar;
    }

    public static h5.f T(Cursor cursor) {
        h5.f fVar = new h5.f();
        fVar.f8524a = cursor.getLong(0);
        fVar.f8525b = cursor.getString(1);
        fVar.f8526c = cursor.getString(2);
        String string = cursor.getString(3);
        string.getClass();
        fVar.f8527d = Long.parseLong(string);
        fVar.h = cursor.getInt(4);
        fVar.f8528i = cursor.getInt(5);
        fVar.f = cursor.getString(6);
        fVar.f8531l = cursor.getString(7);
        fVar.f8532m = cursor.getInt(8);
        String string2 = cursor.getString(9);
        string2.getClass();
        fVar.f8533n = Long.parseLong(string2);
        fVar.f8535p = cursor.getInt(10);
        fVar.f8536q = cursor.getString(11);
        fVar.f8538s = cursor.getString(12);
        fVar.t = cursor.getInt(13);
        fVar.f8541w = cursor.getLong(14);
        fVar.f8542x = cursor.getInt(15);
        fVar.y = cursor.getInt(16);
        return fVar;
    }

    public static w U(Cursor cursor) {
        cursor.getInt(0);
        cursor.getInt(1);
        w wVar = new w();
        wVar.f8781a = cursor.getString(2);
        String string = cursor.getString(3);
        string.getClass();
        wVar.f8782b = Long.parseLong(string);
        wVar.f8783c = cursor.getString(4);
        return wVar;
    }

    public static q V(Cursor cursor) {
        q qVar = new q();
        qVar.f8700a = cursor.getInt(0);
        qVar.f8701b = cursor.getString(1);
        qVar.f8702c = cursor.getInt(2);
        qVar.f8703d = cursor.getInt(3);
        qVar.e = cursor.getLong(4);
        qVar.f = cursor.getString(5);
        qVar.g = cursor.getInt(6);
        qVar.h = cursor.getLong(7);
        qVar.f8704i = cursor.getInt(8);
        qVar.f8705j = cursor.getString(9);
        qVar.f8706k = cursor.getString(10);
        qVar.f8707l = cursor.getInt(11);
        qVar.f8708m = cursor.getString(12);
        qVar.f8709n = cursor.getString(13);
        qVar.f8710o = cursor.getLong(14);
        qVar.f8712q = cursor.getLong(15);
        qVar.f8713r = cursor.getInt(16);
        return qVar;
    }

    public static r W(Cursor cursor) {
        r rVar = new r();
        rVar.f8720a = cursor.getLong(0);
        rVar.f8721b = cursor.getLong(1);
        rVar.f8722c = cursor.getLong(2);
        rVar.f8723d = cursor.getString(3);
        rVar.e = cursor.getLong(4);
        rVar.f = cursor.getLong(5);
        rVar.g = cursor.getString(6);
        rVar.h = cursor.getString(7);
        rVar.f8724i = cursor.getInt(8);
        rVar.f8725j = cursor.getLong(9);
        return rVar;
    }

    public static t X(Cursor cursor) {
        t tVar = new t();
        tVar.f8736a = cursor.getLong(0);
        tVar.f8737b = cursor.getString(1);
        cursor.getLong(2);
        return tVar;
    }

    public static y0 Y(Cursor cursor) {
        long j10 = cursor.getLong(0);
        String string = cursor.getString(1);
        string.getClass();
        y0 y0Var = new y0(string);
        y0Var.f8794a = j10;
        String string2 = cursor.getString(2);
        string2.getClass();
        y0Var.f8796c = Long.parseLong(string2);
        y0Var.f8797d = cursor.getString(3);
        y0Var.e = cursor.getInt(4);
        y0Var.f = cursor.getInt(5);
        y0Var.g = cursor.getInt(6);
        y0Var.h = cursor.getString(7);
        return y0Var;
    }

    public static void d(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS updates(id integer primary key autoincrement, packagename text, versionCode text, versionName text, notified integer default 0, ignoreVersion integer default 0, isPartialUpdate integer default 0, newFeatures text, installationAttempts integer default 0);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS apps( id integer primary key autoincrement, name text, packagename text, versionCode text, issystemapp integer default 0, isSystemService integer default 0, urlFicha text, md5signature text, exclude integer default 0, size text, excludeFromTracking integer default 0, defaultName text, sha256 text, positiveNotified integer default 0, appID integer default 0, hasOldVersions integer default 0, trackInfoRegistered integer default 0);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS app_files( id integer primary key autoincrement, app_id integer, sha256 text, size text, path text);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS downloads(id integer primary key autoincrement, packagename text, checked integer default 0, incomplete integer default 0, versioncode integer default 0, versionname text, attempts integer default 0, idPrograma integer default 0, downloadAnyway integer default 0, md5signature text, supportedAbis text, minsdk integer default 0, urlIcon text, appName text, nextAttemptTimeStamp integer default 0, updateId integer default 0, deeplink integer default 0);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS download_files(id integer primary key autoincrement, downloadId integer default 0, fileId integer default 0, type text, size integer default 0, size_downloaded integer default 0, filehash text, absolutePath text, attempts integer default 0, nextAttemptTimeStamp integer default 0);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS download_promoted(id integer primary key autoincrement, appId integer default 0, categoryFrom text);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS recent_searches(id integer primary key autoincrement, search text unique, timestamp text);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS installable_files(id integer primary key autoincrement, path text);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS notifications(id integer primary key autoincrement, timestamp text, title text, msg text, actions text, extra_info text);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS deep_link_files(id integer primary key autoincrement, path text, date text);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS active_notifications(id integer primary key autoincrement, notificationId integer, packagename text, versioncode integer, type integer);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS activity_log(id integer primary key autoincrement, type integer, packagename text, versionname_old text, versionname_new text, versioncode_old text, versioncode_new text, size text, timestamp text);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS responses(id integer primary key autoincrement, type integer, json text, timestamp text);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS events(id integer primary key autoincrement, json text, timestamp integer);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS preregistrations(id integer primary key autoincrement, appId integer, automaticDownload integer);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS preregistrations_to_notify(id integer primary key autoincrement, appId integer);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS errors(id integer primary key autoincrement, json text, timestamp integer);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS download_required_features(id integer primary key autoincrement, name text, downloadId text);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS remote_installs(id integer primary key autoincrement, appId integer, sourceDeviceName text, downloadId integer);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS app_installers(id integer primary key autoincrement, packagename text, installer_packagename text);");
    }

    public final q A(String str) {
        Cursor cursorQuery;
        int i10;
        str.getClass();
        try {
            SQLiteDatabase sQLiteDatabase = this.f13150a;
            sQLiteDatabase.getClass();
            cursorQuery = sQLiteDatabase.query("downloads", this.e, "packagename=?", new String[]{str}, null, null, "versioncode DESC");
        } catch (Exception e) {
            e = e;
            cursorQuery = null;
        }
        try {
            q qVarV = cursorQuery.moveToFirst() ? V(cursorQuery) : null;
            cursorQuery.close();
            if (qVarV != null && (i10 = qVarV.f8700a) >= 0) {
                qVarV.f8716v = D(i10);
            }
            return qVarV;
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            return null;
        }
    }

    public final q B(long j10, String str) {
        Exception exc;
        Cursor cursorQuery;
        int i10;
        str.getClass();
        try {
            SQLiteDatabase sQLiteDatabase = this.f13150a;
            sQLiteDatabase.getClass();
            cursorQuery = sQLiteDatabase.query("downloads", this.e, "packagename=? AND versioncode=?", new String[]{str, String.valueOf(j10)}, null, null, null);
        } catch (Exception e) {
            exc = e;
            cursorQuery = null;
        }
        try {
            q qVarV = cursorQuery.moveToFirst() ? V(cursorQuery) : null;
            cursorQuery.close();
            if (qVarV != null && (i10 = qVarV.f8700a) >= 0) {
                qVarV.f8716v = D(i10);
            }
            return qVarV;
        } catch (Exception e3) {
            exc = e3;
            exc.printStackTrace();
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            return null;
        }
    }

    public final q C(long j10) {
        Exception exc;
        Cursor cursorQuery;
        int i10;
        try {
            String[] strArr = {String.valueOf(j10)};
            SQLiteDatabase sQLiteDatabase = this.f13150a;
            sQLiteDatabase.getClass();
            cursorQuery = sQLiteDatabase.query("downloads", this.e, "updateId=?", strArr, null, null, null);
        } catch (Exception e) {
            exc = e;
            cursorQuery = null;
        }
        try {
            q qVarV = cursorQuery.moveToFirst() ? V(cursorQuery) : null;
            cursorQuery.close();
            if (qVarV != null && (i10 = qVarV.f8700a) >= 0) {
                qVarV.f8716v = D(i10);
            }
            return qVarV;
        } catch (Exception e3) {
            exc = e3;
            exc.printStackTrace();
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            return null;
        }
    }

    public final ArrayList D(int i10) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f13150a;
            sQLiteDatabase.getClass();
            cursorQuery = sQLiteDatabase.query("download_files", this.f, "downloadId=?", new String[]{String.valueOf(i10)}, null, null, null);
            if (cursorQuery.moveToFirst()) {
                arrayList.add(W(cursorQuery));
            }
            while (cursorQuery.moveToNext()) {
                arrayList.add(W(cursorQuery));
            }
            cursorQuery.close();
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            return arrayList;
        }
    }

    public final s E(long j10) {
        Exception exc;
        Cursor cursorQuery;
        s sVar;
        try {
            String[] strArr = {String.valueOf(j10)};
            SQLiteDatabase sQLiteDatabase = this.f13150a;
            sQLiteDatabase.getClass();
            cursorQuery = sQLiteDatabase.query("download_promoted", this.g, "appId=?", strArr, null, null, null);
        } catch (Exception e) {
            exc = e;
            cursorQuery = null;
        }
        try {
            if (cursorQuery.moveToFirst()) {
                sVar = new s();
                sVar.f8730a = -1;
                sVar.f8730a = cursorQuery.getInt(0);
                sVar.f8731b = cursorQuery.getLong(1);
                sVar.f8732c = cursorQuery.getString(2);
            } else {
                sVar = null;
            }
            cursorQuery.close();
            return sVar;
        } catch (Exception e3) {
            exc = e3;
            exc.printStackTrace();
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            return null;
        }
    }

    public final ArrayList F() {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f13150a;
            sQLiteDatabase.getClass();
            cursorQuery = sQLiteDatabase.query("downloads", this.e, null, null, null, null, null);
            if (cursorQuery.moveToFirst()) {
                q qVarV = V(cursorQuery);
                int i10 = qVarV.f8700a;
                if (i10 >= 0) {
                    qVarV.f8716v = D(i10);
                }
                arrayList.add(qVarV);
            }
            while (cursorQuery.moveToNext()) {
                q qVarV2 = V(cursorQuery);
                int i11 = qVarV2.f8700a;
                if (i11 >= 0) {
                    qVarV2.f8716v = D(i11);
                }
                arrayList.add(qVarV2);
            }
            cursorQuery.close();
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            return arrayList;
        }
    }

    public final ArrayList G() {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f13150a;
            sQLiteDatabase.getClass();
            cursorQuery = sQLiteDatabase.query("installable_files", this.f13154i, null, null, null, null, null);
            if (cursorQuery.moveToFirst()) {
                arrayList.add(cursorQuery.getString(1));
            }
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.getString(1));
            }
            cursorQuery.close();
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            return arrayList;
        }
    }

    public final ArrayList H() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = this.f13150a;
        sQLiteDatabase.getClass();
        Cursor cursorQuery = sQLiteDatabase.query("remote_installs", this.f13164s, "downloadId < 0", null, null, null, null);
        cursorQuery.getClass();
        if (cursorQuery.moveToFirst()) {
            j0 j0Var = new j0();
            j0Var.a(cursorQuery);
            arrayList.add(j0Var);
            while (cursorQuery.moveToNext()) {
                j0 j0Var2 = new j0();
                j0Var2.a(cursorQuery);
                arrayList.add(j0Var2);
            }
        }
        cursorQuery.close();
        return arrayList;
    }

    public final g0 I(long j10) {
        Exception exc;
        Cursor cursorQuery;
        g0 g0Var;
        try {
            String[] strArr = {String.valueOf(j10)};
            SQLiteDatabase sQLiteDatabase = this.f13150a;
            sQLiteDatabase.getClass();
            cursorQuery = sQLiteDatabase.query("preregistrations", this.f13156k, "appId=?", strArr, null, null, null);
        } catch (Exception e) {
            exc = e;
            cursorQuery = null;
        }
        try {
            if (cursorQuery.moveToFirst()) {
                g0Var = new g0();
                g0Var.f8558a = cursorQuery.getLong(0);
                g0Var.e = cursorQuery.getInt(1);
            } else {
                g0Var = null;
            }
            cursorQuery.close();
            return g0Var;
        } catch (Exception e3) {
            exc = e3;
            exc.printStackTrace();
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            return null;
        }
    }

    public final ArrayList J() {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f13150a;
            sQLiteDatabase.getClass();
            cursorQuery = sQLiteDatabase.query("recent_searches", this.h, null, null, null, null, null);
            if (cursorQuery.moveToFirst()) {
                i0 i0Var = new i0();
                i0Var.f8614a = cursorQuery.getString(0);
                i0Var.f8615b = cursorQuery.getString(1);
                arrayList.add(i0Var);
            }
            while (cursorQuery.moveToNext()) {
                i0 i0Var2 = new i0();
                i0Var2.f8614a = cursorQuery.getString(0);
                i0Var2.f8615b = cursorQuery.getString(1);
                arrayList.add(i0Var2);
            }
            cursorQuery.close();
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            return arrayList;
        }
    }

    public final ArrayList K(long j10) {
        String[] strArr = {String.valueOf(j10)};
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = this.f13150a;
        sQLiteDatabase.getClass();
        Cursor cursorQuery = sQLiteDatabase.query("remote_installs", this.f13164s, "appId=?", strArr, null, null, null);
        cursorQuery.getClass();
        if (cursorQuery.moveToFirst()) {
            j0 j0Var = new j0();
            j0Var.a(cursorQuery);
            arrayList.add(j0Var);
            while (cursorQuery.moveToNext()) {
                j0 j0Var2 = new j0();
                j0Var2.a(cursorQuery);
                arrayList.add(j0Var2);
            }
        }
        cursorQuery.close();
        return arrayList;
    }

    public final q0 L(String str) {
        q0 q0Var;
        Cursor cursorQuery;
        Cursor cursor = null;
        q0Var = null;
        q0 q0Var2 = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f13150a;
            sQLiteDatabase.getClass();
            cursorQuery = sQLiteDatabase.query("responses", this.f13160o, "type=?", new String[]{str}, null, null, null);
        } catch (Exception e) {
            e = e;
            q0Var = null;
        }
        try {
            if (cursorQuery.moveToFirst()) {
                cursorQuery.getInt(0);
                String string = cursorQuery.getString(1);
                String string2 = cursorQuery.getString(2);
                String string3 = cursorQuery.getString(3);
                string.getClass();
                string2.getClass();
                q0 q0Var3 = new q0(string, string2);
                string3.getClass();
                q0Var3.f8719c = Long.parseLong(string3);
                q0Var2 = q0Var3;
            }
            cursorQuery.close();
            return q0Var2;
        } catch (Exception e3) {
            e = e3;
            q0 q0Var4 = q0Var2;
            cursor = cursorQuery;
            q0Var = q0Var4;
            e.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return q0Var;
        }
    }

    public final y0 M(String str) {
        Cursor cursorQuery;
        y0 y0VarY;
        str.getClass();
        try {
            SQLiteDatabase sQLiteDatabase = this.f13150a;
            sQLiteDatabase.getClass();
            cursorQuery = sQLiteDatabase.query("updates", this.f13153d, "packagename=?", new String[]{str}, null, null, null);
        } catch (Exception e) {
            e = e;
            cursorQuery = null;
        }
        try {
            if (cursorQuery.moveToFirst()) {
                y0VarY = Y(cursorQuery);
                q qVarC = C(y0VarY.f8794a);
                y0VarY.f8798i = qVarC;
                y0VarY.f8799j = N(qVarC);
            } else {
                y0VarY = null;
            }
            cursorQuery.close();
            return y0VarY;
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            return null;
        }
    }

    public final ArrayList N(q qVar) {
        ArrayList arrayList = new ArrayList();
        if (qVar != null) {
            Cursor cursorQuery = null;
            try {
                int i10 = qVar.f8700a;
                if (i10 >= 0) {
                    String[] strArr = {String.valueOf(i10)};
                    SQLiteDatabase sQLiteDatabase = this.f13150a;
                    sQLiteDatabase.getClass();
                    cursorQuery = sQLiteDatabase.query("download_required_features", this.f13163r, "downloadId=?", strArr, null, null, null);
                    if (cursorQuery.moveToFirst()) {
                        arrayList.add(cursorQuery.getString(0));
                        while (cursorQuery.moveToNext()) {
                            arrayList.add(cursorQuery.getString(0));
                        }
                    }
                    cursorQuery.close();
                    return arrayList;
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (cursorQuery != null && !cursorQuery.isClosed()) {
                    cursorQuery.close();
                }
            }
        }
        return arrayList;
    }

    public final ArrayList O() {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f13150a;
            sQLiteDatabase.getClass();
            cursorQuery = sQLiteDatabase.query("updates", this.f13153d, null, null, null, null, null);
            if (cursorQuery.moveToFirst()) {
                y0 y0VarY = Y(cursorQuery);
                arrayList.add(y0VarY);
                q qVarC = C(y0VarY.f8794a);
                y0VarY.f8798i = qVarC;
                y0VarY.f8799j = N(qVarC);
            }
            while (cursorQuery.moveToNext()) {
                y0 y0VarY2 = Y(cursorQuery);
                arrayList.add(y0VarY2);
                q qVarC2 = C(y0VarY2.f8794a);
                y0VarY2.f8798i = qVarC2;
                y0VarY2.f8799j = N(qVarC2);
            }
            cursorQuery.close();
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            return arrayList;
        }
    }

    public final void P(q qVar) {
        qVar.getClass();
        ContentValues contentValues = new ContentValues();
        contentValues.put("packagename", qVar.f8701b);
        contentValues.put("checked", Integer.valueOf(qVar.f8702c));
        contentValues.put("incomplete", Integer.valueOf(qVar.f8703d));
        contentValues.put("versioncode", Long.valueOf(qVar.e));
        contentValues.put("versionname", qVar.f);
        contentValues.put("attempts", Integer.valueOf(qVar.g));
        contentValues.put("idPrograma", Long.valueOf(qVar.h));
        contentValues.put("downloadAnyway", Integer.valueOf(qVar.f8704i));
        contentValues.put("md5signature", qVar.f8705j);
        contentValues.put("supportedAbis", qVar.f8706k);
        contentValues.put("minsdk", Integer.valueOf(qVar.f8707l));
        contentValues.put("urlIcon", qVar.f8708m);
        contentValues.put("appName", qVar.f8709n);
        contentValues.put("nextAttemptTimeStamp", Long.valueOf(qVar.f8710o));
        contentValues.put("updateId", Long.valueOf(qVar.f8712q));
        contentValues.put("deeplink", Integer.valueOf(qVar.f8713r));
        SQLiteDatabase sQLiteDatabase = this.f13150a;
        sQLiteDatabase.getClass();
        long jInsert = sQLiteDatabase.insert("downloads", null, contentValues);
        qVar.f8700a = (int) jInsert;
        Iterator it = qVar.f8716v.iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            Q(jInsert, (r) next);
        }
    }

    public final void Q(long j10, r rVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("downloadId", Long.valueOf(j10));
        contentValues.put("fileId", Long.valueOf(rVar.f8722c));
        contentValues.put("size", Long.valueOf(rVar.e));
        contentValues.put("size_downloaded", Long.valueOf(rVar.f));
        contentValues.put("filehash", rVar.g);
        contentValues.put("absolutePath", rVar.h);
        contentValues.put("attempts", Integer.valueOf(rVar.f8724i));
        contentValues.put("nextAttemptTimeStamp", Long.valueOf(rVar.f8725j));
        SQLiteDatabase sQLiteDatabase = this.f13150a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.insert("download_files", null, contentValues);
    }

    public final void R(y0 y0Var) {
        q qVar;
        q qVar2 = y0Var.f8798i;
        if (qVar2 != null) {
            P(qVar2);
            y0Var.f8798i = qVar2;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("packagename", y0Var.f8795b);
        contentValues.put("versionCode", Long.valueOf(y0Var.f8796c));
        contentValues.put("versionName", y0Var.f8797d);
        contentValues.put("notified", Integer.valueOf(y0Var.e));
        contentValues.put("ignoreVersion", Integer.valueOf(y0Var.f));
        contentValues.put("isPartialUpdate", Integer.valueOf(y0Var.g));
        contentValues.put("newFeatures", y0Var.h);
        SQLiteDatabase sQLiteDatabase = this.f13150a;
        sQLiteDatabase.getClass();
        long jInsert = sQLiteDatabase.insert("updates", null, contentValues);
        q qVar3 = y0Var.f8798i;
        if (qVar3 != null) {
            if (jInsert < 0) {
                j(qVar3);
                return;
            }
            qVar3.f8712q = jInsert;
            ArrayList arrayList = y0Var.f8799j;
            if (arrayList != null && !arrayList.isEmpty() && (qVar = y0Var.f8798i) != null && qVar.f8700a >= 0) {
                ArrayList arrayList2 = y0Var.f8799j;
                arrayList2.getClass();
                Iterator it = arrayList2.iterator();
                it.getClass();
                while (it.hasNext()) {
                    Object next = it.next();
                    next.getClass();
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put(RewardPlus.NAME, (String) next);
                    q qVar4 = y0Var.f8798i;
                    qVar4.getClass();
                    contentValues2.put("downloadId", Integer.valueOf(qVar4.f8700a));
                    SQLiteDatabase sQLiteDatabase2 = this.f13150a;
                    sQLiteDatabase2.getClass();
                    sQLiteDatabase2.insert("download_required_features", null, contentValues2);
                }
            }
            q qVar5 = y0Var.f8798i;
            qVar5.getClass();
            d0(qVar5);
        }
    }

    public final void Z(h5.f fVar) {
        fVar.getClass();
        ContentValues contentValues = new ContentValues();
        contentValues.put("exclude", Integer.valueOf(fVar.f8532m));
        String[] strArr = {fVar.f8526c};
        SQLiteDatabase sQLiteDatabase = this.f13150a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.update("apps", contentValues, "packagename=?", strArr);
    }

    public final synchronized void a() {
        if (this.t.incrementAndGet() == 1) {
            g gVar = f13149v;
            gVar.getClass();
            gVar.f13150a = gVar.getWritableDatabase();
        }
    }

    public final void a0(h5.f fVar) {
        fVar.getClass();
        ContentValues contentValues = new ContentValues();
        String str = fVar.f8525b;
        if (str != null) {
            contentValues.put(RewardPlus.NAME, str);
        }
        long j10 = fVar.f8527d;
        if (j10 > 0) {
            contentValues.put("versionCode", Long.valueOf(j10));
        }
        contentValues.put("issystemapp", Integer.valueOf(fVar.h));
        contentValues.put("isSystemService", Integer.valueOf(fVar.f8528i));
        String str2 = fVar.f;
        if (str2 != null) {
            contentValues.put("urlFicha", str2);
        }
        String str3 = fVar.f8531l;
        if (str3 != null) {
            contentValues.put("md5signature", str3);
        }
        contentValues.put("exclude", Integer.valueOf(fVar.f8532m));
        contentValues.put("size", String.valueOf(fVar.f8533n));
        contentValues.put("excludeFromTracking", Integer.valueOf(fVar.f8535p));
        String str4 = fVar.f8536q;
        if (str4 != null) {
            contentValues.put("defaultName", str4);
        }
        String str5 = fVar.f8538s;
        if (str5 != null) {
            contentValues.put("sha256", str5);
        }
        contentValues.put("positiveNotified", Integer.valueOf(fVar.t));
        contentValues.put("appID", Long.valueOf(fVar.f8541w));
        contentValues.put("hasOldVersions", Integer.valueOf(fVar.f8542x));
        String[] strArr = {fVar.f8526c};
        SQLiteDatabase sQLiteDatabase = this.f13150a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.update("apps", contentValues, "packagename=?", strArr);
    }

    public final synchronized void b() {
        try {
            if (this.t.decrementAndGet() == 0) {
                g gVar = f13149v;
                gVar.getClass();
                gVar.close();
            } else if (this.t.get() < 0) {
                this.t.set(0);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void b0(h5.f fVar) {
        fVar.getClass();
        ContentValues contentValues = new ContentValues();
        contentValues.put("excludeFromTracking", Integer.valueOf(fVar.f8535p));
        String[] strArr = {fVar.f8526c};
        SQLiteDatabase sQLiteDatabase = this.f13150a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.update("apps", contentValues, "packagename=?", strArr);
    }

    public final void c0(y0 y0Var) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("versionCode", Long.valueOf(y0Var.f8796c));
        contentValues.put("versionName", y0Var.f8797d);
        contentValues.put("notified", Integer.valueOf(y0Var.e));
        contentValues.put("ignoreVersion", Integer.valueOf(y0Var.f));
        contentValues.put("isPartialUpdate", Integer.valueOf(y0Var.g));
        contentValues.put("newFeatures", y0Var.h);
        String[] strArr = {y0Var.f8795b};
        SQLiteDatabase sQLiteDatabase = this.f13150a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.update("updates", contentValues, "packagename=?", strArr);
    }

    public final void d0(q qVar) {
        qVar.getClass();
        ContentValues contentValues = new ContentValues();
        contentValues.put("packagename", qVar.f8701b);
        contentValues.put("checked", Integer.valueOf(qVar.f8702c));
        contentValues.put("incomplete", Integer.valueOf(qVar.f8703d));
        contentValues.put("versioncode", Long.valueOf(qVar.e));
        contentValues.put("versionname", qVar.f);
        contentValues.put("attempts", Integer.valueOf(qVar.g));
        contentValues.put("idPrograma", Long.valueOf(qVar.h));
        contentValues.put("downloadAnyway", Integer.valueOf(qVar.f8704i));
        contentValues.put("md5signature", qVar.f8705j);
        contentValues.put("supportedAbis", qVar.f8706k);
        contentValues.put("minsdk", Integer.valueOf(qVar.f8707l));
        contentValues.put("urlIcon", qVar.f8708m);
        contentValues.put("appName", qVar.f8709n);
        contentValues.put("nextAttemptTimeStamp", Long.valueOf(qVar.f8710o));
        contentValues.put("updateId", Long.valueOf(qVar.f8712q));
        contentValues.put("deeplink", Integer.valueOf(qVar.f8713r));
        int i10 = qVar.f8700a;
        if (i10 >= 0) {
            String[] strArr = {String.valueOf(i10)};
            SQLiteDatabase sQLiteDatabase = this.f13150a;
            sQLiteDatabase.getClass();
            sQLiteDatabase.update("downloads", contentValues, "id=?", strArr);
            return;
        }
        String str = qVar.f8701b;
        if (str != null) {
            long j10 = qVar.e;
            if (j10 > 0) {
                String[] strArr2 = {str, String.valueOf(j10)};
                SQLiteDatabase sQLiteDatabase2 = this.f13150a;
                sQLiteDatabase2.getClass();
                sQLiteDatabase2.update("downloads", contentValues, "packagename=? AND versioncode=?", strArr2);
            }
        }
    }

    public final void e(h5.f fVar) {
        if (fVar.f8524a < 0) {
            String str = fVar.f8526c;
            str.getClass();
            h5.f fVarR = r(str);
            if (fVarR != null) {
                fVar.f8524a = fVarR.f8524a;
            }
        }
        String[] strArr = {fVar.f8526c};
        SQLiteDatabase sQLiteDatabase = this.f13150a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.delete("apps", "packagename=?", strArr);
        String[] strArr2 = {String.valueOf(fVar.f8524a)};
        SQLiteDatabase sQLiteDatabase2 = this.f13150a;
        sQLiteDatabase2.getClass();
        sQLiteDatabase2.delete("app_files", "app_id=?", strArr2);
    }

    public final void e0(r rVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("size_downloaded", Long.valueOf(rVar.f));
        contentValues.put("absolutePath", rVar.h);
        contentValues.put("attempts", Integer.valueOf(rVar.f8724i));
        contentValues.put("nextAttemptTimeStamp", Long.valueOf(rVar.f8725j));
        String[] strArr = {String.valueOf(rVar.f8720a)};
        SQLiteDatabase sQLiteDatabase = this.f13150a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.update("download_files", contentValues, "id=?", strArr);
    }

    public final void f(String str) {
        str.getClass();
        h5.f fVarR = r(str);
        if (fVarR != null) {
            SQLiteDatabase sQLiteDatabase = this.f13150a;
            sQLiteDatabase.getClass();
            sQLiteDatabase.delete("apps", "packagename=?", new String[]{str});
            String[] strArr = {String.valueOf(fVarR.f8524a)};
            SQLiteDatabase sQLiteDatabase2 = this.f13150a;
            sQLiteDatabase2.getClass();
            sQLiteDatabase2.delete("app_files", "app_id=?", strArr);
        }
    }

    public final void f0(int i10, long j10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("automaticDownload", Integer.valueOf(i10));
        String[] strArr = {String.valueOf(j10)};
        SQLiteDatabase sQLiteDatabase = this.f13150a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.update("preregistrations", contentValues, "appId=?", strArr);
    }

    public final void g0(j0 j0Var) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("downloadId", Integer.valueOf(j0Var.f8627d));
        String[] strArr = {String.valueOf(j0Var.f8625b)};
        SQLiteDatabase sQLiteDatabase = this.f13150a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.update("remote_installs", contentValues, "appId=?", strArr);
    }

    public final void h(w wVar) {
        String str = wVar.f8781a;
        if (str != null) {
            String[] strArr = {str};
            SQLiteDatabase sQLiteDatabase = this.f13150a;
            sQLiteDatabase.getClass();
            sQLiteDatabase.delete("app_files", "sha256=?", strArr);
            return;
        }
        String str2 = wVar.f8783c;
        if (str2 != null) {
            SQLiteDatabase sQLiteDatabase2 = this.f13150a;
            sQLiteDatabase2.getClass();
            sQLiteDatabase2.delete("app_files", "path=?", new String[]{str2});
        }
    }

    public final void h0(int i10, long j10, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("appID", Long.valueOf(j10));
        contentValues.put("hasOldVersions", Integer.valueOf(i10));
        contentValues.put("trackInfoRegistered", (Integer) 1);
        SQLiteDatabase sQLiteDatabase = this.f13150a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.update("apps", contentValues, "packagename=?", new String[]{str});
    }

    public final void i(String str) {
        SQLiteDatabase sQLiteDatabase = this.f13150a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.delete("app_installers", "packagename=?", new String[]{str});
    }

    public final int j(q qVar) {
        if (qVar == null) {
            return 0;
        }
        String[] strArr = {String.valueOf(qVar.f8700a)};
        SQLiteDatabase sQLiteDatabase = this.f13150a;
        sQLiteDatabase.getClass();
        int iDelete = sQLiteDatabase.delete("downloads", "id=?", strArr);
        String[] strArr2 = {String.valueOf(qVar.f8700a)};
        SQLiteDatabase sQLiteDatabase2 = this.f13150a;
        sQLiteDatabase2.getClass();
        sQLiteDatabase2.delete("download_files", "downloadId=?", strArr2);
        return iDelete;
    }

    public final void k(long j10) {
        String[] strArr = {String.valueOf(j10)};
        SQLiteDatabase sQLiteDatabase = this.f13150a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.delete("remote_installs", "appId=?", strArr);
    }

    public final void l(String str) {
        SQLiteDatabase sQLiteDatabase = this.f13150a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.delete("responses", "type=?", new String[]{str});
    }

    public final void m(String str) {
        int i10;
        str.getClass();
        String[] strArr = {str};
        y0 y0VarM = M(str);
        if (y0VarM != null) {
            q qVar = y0VarM.f8798i;
            if (qVar != null && (i10 = qVar.f8700a) >= 0) {
                String[] strArr2 = {String.valueOf(i10)};
                SQLiteDatabase sQLiteDatabase = this.f13150a;
                sQLiteDatabase.getClass();
                sQLiteDatabase.delete("download_required_features", "downloadId=?", strArr2);
            }
            j(y0VarM.f8798i);
        }
        SQLiteDatabase sQLiteDatabase2 = this.f13150a;
        sQLiteDatabase2.getClass();
        sQLiteDatabase2.delete("updates", "packagename=?", strArr);
    }

    public final void n() {
        Iterator it = O().iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            m(((y0) next).f8795b);
        }
    }

    public final h5.b o(int i10) {
        Cursor cursorQuery;
        try {
            String[] strArr = {String.valueOf(i10)};
            SQLiteDatabase sQLiteDatabase = this.f13150a;
            sQLiteDatabase.getClass();
            cursorQuery = sQLiteDatabase.query("active_notifications", this.f13159n, "notificationId=?", strArr, null, null, null);
        } catch (Exception e) {
            e = e;
            cursorQuery = null;
        }
        try {
            h5.b bVarS = cursorQuery.moveToFirst() ? S(cursorQuery) : null;
            cursorQuery.close();
            return bVarS;
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.getClass();
        this.f13150a = sQLiteDatabase;
        d(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        sQLiteDatabase.getClass();
        if (i10 < 656) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS updates");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS apps");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS app_files");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS downloads");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS download_files");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS download_promoted");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS recent_searches");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS installable_files");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS notifications");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS deep_link_files");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS active_notifications");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS activity_log");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS responses");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS preregistrations");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS preregistrations_to_notify");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS errors");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS download_required_features");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS remote_installs");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS app_installers");
        } else {
            if (i10 < 687) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS downloads");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS download_files");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS download_promoted");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS download_required_features");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS updates");
            }
            if (i10 < 688) {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS app_installers(id integer primary key autoincrement, packagename text, installer_packagename text);");
            }
        }
        d(sQLiteDatabase);
    }

    public final h5.b p(long j10, String str) {
        Exception exc;
        Cursor cursorQuery;
        str.getClass();
        try {
            String[] strArr = {str, String.valueOf(j10)};
            SQLiteDatabase sQLiteDatabase = this.f13150a;
            sQLiteDatabase.getClass();
            cursorQuery = sQLiteDatabase.query("active_notifications", this.f13159n, "packagename=? AND versioncode=?", strArr, null, null, null);
            try {
                h5.b bVarS = cursorQuery.moveToFirst() ? S(cursorQuery) : null;
                cursorQuery.close();
                return bVarS;
            } catch (Exception e) {
                exc = e;
                exc.printStackTrace();
                if (cursorQuery != null && !cursorQuery.isClosed()) {
                    cursorQuery.close();
                }
                return null;
            }
        } catch (Exception e3) {
            exc = e3;
            cursorQuery = null;
        }
    }

    public final h5.b q(int i10) {
        Cursor cursorQuery;
        try {
            String[] strArr = {String.valueOf(i10)};
            SQLiteDatabase sQLiteDatabase = this.f13150a;
            sQLiteDatabase.getClass();
            cursorQuery = sQLiteDatabase.query("active_notifications", this.f13159n, "id=?", strArr, null, null, null);
        } catch (Exception e) {
            e = e;
            cursorQuery = null;
        }
        try {
            h5.b bVarS = cursorQuery.moveToFirst() ? S(cursorQuery) : null;
            cursorQuery.close();
            return bVarS;
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            return null;
        }
    }

    public final h5.f r(String str) {
        Cursor cursorQuery;
        str.getClass();
        try {
            SQLiteDatabase sQLiteDatabase = this.f13150a;
            sQLiteDatabase.getClass();
            cursorQuery = sQLiteDatabase.query("apps", this.f13151b, "packagename=?", new String[]{str}, null, null, null);
        } catch (Exception e) {
            e = e;
            cursorQuery = null;
        }
        try {
            h5.f fVarT = cursorQuery.moveToFirst() ? T(cursorQuery) : null;
            cursorQuery.close();
            return fVarT;
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            return null;
        }
    }

    public final ArrayList s(long j10) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            String[] strArr = {String.valueOf(j10)};
            SQLiteDatabase sQLiteDatabase = this.f13150a;
            sQLiteDatabase.getClass();
            cursorQuery = sQLiteDatabase.query("app_files", this.f13152c, "app_id=?", strArr, null, null, null);
            if (cursorQuery.moveToFirst()) {
                arrayList.add(U(cursorQuery));
                while (cursorQuery.moveToNext()) {
                    arrayList.add(U(cursorQuery));
                }
            }
            cursorQuery.close();
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            return arrayList;
        }
    }

    public final ArrayList t(h5.f fVar) {
        h5.f fVarR;
        long j10 = fVar.f8524a;
        if (j10 >= 0) {
            return s(j10);
        }
        String str = fVar.f8526c;
        if (str == null || (fVarR = r(str)) == null) {
            return null;
        }
        return s(fVarR.f8524a);
    }

    public final ArrayList u() {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f13150a;
            sQLiteDatabase.getClass();
            cursorQuery = sQLiteDatabase.query("apps", this.f13151b, null, null, null, null, null);
            if (cursorQuery.moveToFirst()) {
                arrayList.add(T(cursorQuery));
                while (cursorQuery.moveToNext()) {
                    arrayList.add(T(cursorQuery));
                }
            }
            cursorQuery.close();
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            return arrayList;
        }
    }

    public final ArrayList v() {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f13150a;
            sQLiteDatabase.getClass();
            cursorQuery = sQLiteDatabase.query("deep_link_files", this.f13158m, null, null, null, null, null);
            if (cursorQuery.moveToFirst()) {
                h5.l lVar = new h5.l();
                String string = cursorQuery.getString(0);
                string.getClass();
                lVar.f8644a = string;
                String string2 = cursorQuery.getString(1);
                string2.getClass();
                lVar.f8645b = string2;
                arrayList.add(lVar);
            }
            while (cursorQuery.moveToNext()) {
                h5.l lVar2 = new h5.l();
                String string3 = cursorQuery.getString(0);
                string3.getClass();
                lVar2.f8644a = string3;
                String string4 = cursorQuery.getString(1);
                string4.getClass();
                lVar2.f8645b = string4;
                arrayList.add(lVar2);
            }
            cursorQuery.close();
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            return arrayList;
        }
    }

    public final q w(String str) {
        Iterator it = F().iterator();
        it.getClass();
        q qVar = null;
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            q qVar2 = (q) next;
            Iterator it2 = qVar2.f8716v.iterator();
            it2.getClass();
            while (it2.hasNext()) {
                Object next2 = it2.next();
                next2.getClass();
                r rVar = (r) next2;
                if (rVar.h != null) {
                    String str2 = rVar.h;
                    str2.getClass();
                    if (u.Z(new File(str2).getName(), str, true)) {
                        qVar = qVar2;
                    }
                }
            }
        }
        return qVar;
    }

    public final q x(String str) {
        Iterator it = F().iterator();
        it.getClass();
        q qVar = null;
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            q qVar2 = (q) next;
            if (!qVar2.f8716v.isEmpty()) {
                Iterator it2 = qVar2.f8716v.iterator();
                it2.getClass();
                while (true) {
                    if (it2.hasNext()) {
                        Object next2 = it2.next();
                        next2.getClass();
                        r rVar = (r) next2;
                        if (rVar.h != null) {
                            String str2 = rVar.h;
                            str2.getClass();
                            File parentFile = new File(str2).getParentFile();
                            if (parentFile != null && u.Z(parentFile.getAbsolutePath(), str, true)) {
                                qVar = qVar2;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return qVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final h5.q y(java.lang.String r12) {
        /*
            r11 = this;
            r12.getClass()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r11.f13150a     // Catch: java.lang.Exception -> L30
            r2.getClass()     // Catch: java.lang.Exception -> L30
            java.lang.String r3 = "download_files"
            java.lang.String[] r4 = r11.f     // Catch: java.lang.Exception -> L30
            java.lang.String r5 = "fileId=?"
            java.lang.String[] r6 = new java.lang.String[]{r12}     // Catch: java.lang.Exception -> L30
            r8 = 0
            r9 = 0
            r7 = 0
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L30
            boolean r0 = r12.moveToFirst()     // Catch: java.lang.Exception -> L26
            if (r0 == 0) goto L29
            h5.r r0 = W(r12)     // Catch: java.lang.Exception -> L26
            r2 = r0
            goto L2a
        L26:
            r0 = move-exception
            r2 = r1
            goto L33
        L29:
            r2 = r1
        L2a:
            r12.close()     // Catch: java.lang.Exception -> L2e
            goto L41
        L2e:
            r0 = move-exception
            goto L33
        L30:
            r0 = move-exception
            r12 = r1
            r2 = r12
        L33:
            r0.printStackTrace()
            if (r12 == 0) goto L41
            boolean r0 = r12.isClosed()
            if (r0 != 0) goto L41
            r12.close()
        L41:
            if (r2 == 0) goto L4a
            long r3 = r2.f8721b
            java.lang.Long r12 = java.lang.Long.valueOf(r3)
            goto L4b
        L4a:
            r12 = r1
        L4b:
            if (r12 == 0) goto L98
            android.database.sqlite.SQLiteDatabase r3 = r11.f13150a     // Catch: java.lang.Exception -> L88
            r3.getClass()     // Catch: java.lang.Exception -> L88
            java.lang.String r4 = "downloads"
            java.lang.String[] r5 = r11.e     // Catch: java.lang.Exception -> L88
            java.lang.String r6 = "id=?"
            long r7 = r2.f8721b     // Catch: java.lang.Exception -> L88
            java.lang.String r12 = java.lang.String.valueOf(r7)     // Catch: java.lang.Exception -> L88
            java.lang.String[] r7 = new java.lang.String[]{r12}     // Catch: java.lang.Exception -> L88
            r9 = 0
            r10 = 0
            r8 = 0
            android.database.Cursor r12 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> L88
            boolean r0 = r12.moveToFirst()     // Catch: java.lang.Exception -> L74
            if (r0 == 0) goto L76
            h5.q r0 = V(r12)     // Catch: java.lang.Exception -> L74
            goto L77
        L74:
            r0 = move-exception
            goto L8a
        L76:
            r0 = r1
        L77:
            r12.close()     // Catch: java.lang.Exception -> L74
            if (r0 == 0) goto L86
            int r2 = r0.f8700a     // Catch: java.lang.Exception -> L74
            if (r2 < 0) goto L86
            java.util.ArrayList r2 = r11.D(r2)     // Catch: java.lang.Exception -> L74
            r0.f8716v = r2     // Catch: java.lang.Exception -> L74
        L86:
            r1 = r0
            goto L98
        L88:
            r0 = move-exception
            r12 = r1
        L8a:
            r0.printStackTrace()
            if (r12 == 0) goto L98
            boolean r0 = r12.isClosed()
            if (r0 != 0) goto L98
            r12.close()
        L98:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: v5.g.y(java.lang.String):h5.q");
    }

    public final q z(int i10) {
        Cursor cursorQuery;
        int i11;
        try {
            String[] strArr = {String.valueOf(i10)};
            SQLiteDatabase sQLiteDatabase = this.f13150a;
            sQLiteDatabase.getClass();
            cursorQuery = sQLiteDatabase.query("downloads", this.e, "id=?", strArr, null, null, null);
        } catch (Exception e) {
            e = e;
            cursorQuery = null;
        }
        try {
            q qVarV = cursorQuery.moveToFirst() ? V(cursorQuery) : null;
            cursorQuery.close();
            if (qVarV != null && (i11 = qVarV.f8700a) >= 0) {
                qVarV.f8716v = D(i11);
            }
            return qVarV;
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            return null;
        }
    }
}
