package com.mbridge.msdk.foundation.download.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.GlobalComponent;
import com.mbridge.msdk.foundation.download.database.IDatabaseHelper;
import com.mbridge.msdk.foundation.download.utils.Objects;
import com.mbridge.msdk.foundation.tools.af;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class DatabaseHelper implements IDatabaseHelper {
    private volatile SQLiteDatabase database;
    private final IDatabaseOpenHelper databaseOpenHelper;
    private final Handler handler;
    private final String tableName = GlobalComponent.getInstance().getDatabaseTableName();

    public DatabaseHelper(Context context, Handler handler, IDatabaseOpenHelper iDatabaseOpenHelper) {
        this.handler = handler;
        this.databaseOpenHelper = iDatabaseOpenHelper;
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void clear() {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.9
            @Override // java.lang.Runnable
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    return;
                }
                try {
                    try {
                        if (DatabaseHelper.this.database.isOpen()) {
                            try {
                                DatabaseHelper.this.database.beginTransaction();
                                DatabaseHelper.this.database.delete(DatabaseHelper.this.tableName, null, null);
                                DatabaseHelper.this.database.setTransactionSuccessful();
                                if (DatabaseHelper.this.database.inTransaction()) {
                                    DatabaseHelper.this.database.endTransaction();
                                }
                            } catch (Exception e) {
                                if (MBridgeConstans.DEBUG) {
                                    e.printStackTrace();
                                }
                                if (DatabaseHelper.this.database.inTransaction()) {
                                    DatabaseHelper.this.database.endTransaction();
                                }
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            if (DatabaseHelper.this.database.inTransaction()) {
                                DatabaseHelper.this.database.endTransaction();
                            }
                        } catch (Throwable th2) {
                            af.b(IDatabaseHelper.TAG, th2.getMessage());
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    af.b(IDatabaseHelper.TAG, th3.getMessage());
                }
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void find(final String str, final String str2, final IDatabaseHelper.IDatabaseListener iDatabaseListener) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.1
            /* JADX WARN: Removed duplicated region for block: B:39:0x0098  */
            /* JADX WARN: Removed duplicated region for block: B:42:0x009f  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() throws java.lang.Throwable {
                /*
                    r5 = this;
                    java.lang.String r0 = " WHERE download_id = ? AND director_path = ?"
                    java.lang.String r1 = "SELECT * FROM "
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    android.database.sqlite.SQLiteDatabase r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$000(r2)
                    boolean r2 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r2)
                    if (r2 == 0) goto L1d
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper r3 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$100(r2)
                    android.database.sqlite.SQLiteDatabase r3 = r3.getWritableDatabase()
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$002(r2, r3)
                L1d:
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    android.database.sqlite.SQLiteDatabase r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$000(r2)
                    boolean r2 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r2)
                    r3 = 0
                    if (r2 != 0) goto La3
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    android.database.sqlite.SQLiteDatabase r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$000(r2)
                    boolean r2 = r2.isOpen()
                    if (r2 != 0) goto L38
                    goto La3
                L38:
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L80
                    r2.<init>(r1)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L80
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r1 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L80
                    java.lang.String r1 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$200(r1)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L80
                    r2.append(r1)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L80
                    r2.append(r0)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L80
                    java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L80
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r1 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L80
                    android.database.sqlite.SQLiteDatabase r1 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$000(r1)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L80
                    java.lang.String r2 = r3     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L80
                    java.lang.String r4 = r4     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L80
                    java.lang.String[] r2 = new java.lang.String[]{r2, r4}     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L80
                    android.database.Cursor r0 = r1.rawQuery(r0, r2)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L80
                    if (r0 == 0) goto L70
                    boolean r1 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6e
                    if (r1 == 0) goto L70
                    com.mbridge.msdk.foundation.download.database.DownloadModel r3 = com.mbridge.msdk.foundation.download.database.DownloadModel.create(r0)     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6e
                    goto L70
                L6c:
                    r1 = move-exception
                    goto L96
                L6e:
                    r1 = move-exception
                    goto L82
                L70:
                    if (r0 == 0) goto L75
                    r0.close()
                L75:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r2
                    if (r0 == 0) goto Lb0
                    r0.onDatabase(r3)
                    return
                L7d:
                    r1 = move-exception
                    r0 = r3
                    goto L96
                L80:
                    r1 = move-exception
                    r0 = r3
                L82:
                    boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch: java.lang.Throwable -> L6c
                    if (r2 == 0) goto L89
                    r1.printStackTrace()     // Catch: java.lang.Throwable -> L6c
                L89:
                    if (r0 == 0) goto L8e
                    r0.close()
                L8e:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r2
                    if (r0 == 0) goto Lb0
                    r0.onDatabase(r3)
                    goto Lb0
                L96:
                    if (r0 == 0) goto L9b
                    r0.close()
                L9b:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r2
                    if (r0 == 0) goto La2
                    r0.onDatabase(r3)
                La2:
                    throw r1
                La3:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r2
                    boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r0)
                    if (r0 == 0) goto Lb0
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r2
                    r0.onDatabase(r3)
                Lb0:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.database.DatabaseHelper.AnonymousClass1.run():void");
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public List<DownloadModel> findAll() {
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            try {
                if (Objects.isNull(this.database)) {
                    this.database = this.databaseOpenHelper.getWritableDatabase();
                }
                if (!Objects.isNull(this.database) && this.database.isOpen()) {
                    cursorRawQuery = rawQuery("SELECT * FROM " + this.tableName, null);
                    if (cursorRawQuery != null) {
                        while (cursorRawQuery.moveToNext()) {
                            arrayList.add(DownloadModel.create(cursorRawQuery));
                        }
                    }
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                        return arrayList;
                    }
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
                return arrayList;
            }
        } catch (Throwable unused) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
        return arrayList;
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void findByDownloadUrl(final String str, final IDatabaseHelper.IDatabaseListener iDatabaseListener) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.2
            /* JADX WARN: Removed duplicated region for block: B:39:0x0096  */
            /* JADX WARN: Removed duplicated region for block: B:42:0x009d  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() throws java.lang.Throwable {
                /*
                    r4 = this;
                    java.lang.String r0 = " WHERE download_url = ?"
                    java.lang.String r1 = "SELECT * FROM "
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    android.database.sqlite.SQLiteDatabase r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$000(r2)
                    boolean r2 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r2)
                    if (r2 == 0) goto L1d
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper r3 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$100(r2)
                    android.database.sqlite.SQLiteDatabase r3 = r3.getWritableDatabase()
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$002(r2, r3)
                L1d:
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    android.database.sqlite.SQLiteDatabase r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$000(r2)
                    boolean r2 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r2)
                    r3 = 0
                    if (r2 != 0) goto La1
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    android.database.sqlite.SQLiteDatabase r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$000(r2)
                    boolean r2 = r2.isOpen()
                    if (r2 != 0) goto L38
                    goto La1
                L38:
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
                    r2.<init>(r1)     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r1 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
                    java.lang.String r1 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$200(r1)     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
                    r2.append(r1)     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
                    r2.append(r0)     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
                    java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r1 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
                    android.database.sqlite.SQLiteDatabase r1 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$000(r1)     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
                    java.lang.String r2 = r3     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
                    java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
                    android.database.Cursor r0 = r1.rawQuery(r0, r2)     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
                    if (r0 == 0) goto L6e
                    boolean r1 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
                    if (r1 == 0) goto L6e
                    com.mbridge.msdk.foundation.download.database.DownloadModel r3 = com.mbridge.msdk.foundation.download.database.DownloadModel.create(r0)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6c
                    goto L6e
                L6a:
                    r1 = move-exception
                    goto L94
                L6c:
                    r1 = move-exception
                    goto L80
                L6e:
                    if (r0 == 0) goto L73
                    r0.close()
                L73:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r2
                    if (r0 == 0) goto Lae
                    r0.onDatabase(r3)
                    return
                L7b:
                    r1 = move-exception
                    r0 = r3
                    goto L94
                L7e:
                    r1 = move-exception
                    r0 = r3
                L80:
                    boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch: java.lang.Throwable -> L6a
                    if (r2 == 0) goto L87
                    r1.printStackTrace()     // Catch: java.lang.Throwable -> L6a
                L87:
                    if (r0 == 0) goto L8c
                    r0.close()
                L8c:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r2
                    if (r0 == 0) goto Lae
                    r0.onDatabase(r3)
                    goto Lae
                L94:
                    if (r0 == 0) goto L99
                    r0.close()
                L99:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r2
                    if (r0 == 0) goto La0
                    r0.onDatabase(r3)
                La0:
                    throw r1
                La1:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r2
                    boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r0)
                    if (r0 == 0) goto Lae
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r2
                    r0.onDatabase(r3)
                Lae:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.database.DatabaseHelper.AnonymousClass2.run():void");
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public List<DownloadModel> getUnwantedModels(long j10) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            try {
                if (Objects.isNull(this.database)) {
                    this.database = this.databaseOpenHelper.getWritableDatabase();
                }
                if (!Objects.isNull(this.database) && this.database.isOpen()) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - j10;
                    cursorRawQuery = this.database.rawQuery("SELECT * FROM " + this.tableName + " WHERE last_modified_time <= ?", new String[]{String.valueOf(jCurrentTimeMillis)});
                    if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
                        do {
                            arrayList.add(DownloadModel.create(cursorRawQuery));
                        } while (cursorRawQuery.moveToNext());
                    }
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                        return arrayList;
                    }
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            }
            return arrayList;
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void insert(final DownloadModel downloadModel) {
        this.handler.postAtFrontOfQueue(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.3
            @Override // java.lang.Runnable
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (Objects.isNull(DatabaseHelper.this.database) || !DatabaseHelper.this.database.isOpen()) {
                    return;
                }
                try {
                    try {
                        try {
                            DatabaseHelper.this.database.beginTransaction();
                            DatabaseHelper.this.database.insert(DatabaseHelper.this.tableName, null, DownloadModel.create(downloadModel));
                            DatabaseHelper.this.database.setTransactionSuccessful();
                            if (DatabaseHelper.this.database.inTransaction()) {
                                DatabaseHelper.this.database.endTransaction();
                            }
                        } catch (Exception e) {
                            if (MBridgeConstans.DEBUG) {
                                e.printStackTrace();
                            }
                            if (DatabaseHelper.this.database.inTransaction()) {
                                DatabaseHelper.this.database.endTransaction();
                            }
                        }
                    } catch (Throwable th) {
                        af.b(IDatabaseHelper.TAG, th.getMessage());
                    }
                } catch (Throwable th2) {
                    try {
                        if (DatabaseHelper.this.database.inTransaction()) {
                            DatabaseHelper.this.database.endTransaction();
                        }
                    } catch (Throwable th3) {
                        af.b(IDatabaseHelper.TAG, th3.getMessage());
                    }
                    throw th2;
                }
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public Cursor rawQuery(String str, String[] strArr) {
        boolean zInTransaction;
        try {
            try {
                if (Objects.isNull(this.database)) {
                    this.database = this.databaseOpenHelper.getWritableDatabase();
                }
                if (!Objects.isNull(this.database) && this.database.isOpen()) {
                    this.database.beginTransaction();
                    Cursor cursorRawQuery = this.database.rawQuery(str, strArr);
                    this.database.setTransactionSuccessful();
                    try {
                        if (this.database.inTransaction()) {
                            this.database.endTransaction();
                            return cursorRawQuery;
                        }
                    } catch (Throwable th) {
                        if (MBridgeConstans.DEBUG) {
                            th.printStackTrace();
                        }
                    }
                    return cursorRawQuery;
                }
                try {
                    if (zInTransaction) {
                        return null;
                    }
                } catch (Throwable th2) {
                }
                return null;
            } finally {
                try {
                    if (this.database.inTransaction()) {
                        this.database.endTransaction();
                    }
                } catch (Throwable th22) {
                    if (MBridgeConstans.DEBUG) {
                        th22.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
            try {
                if (this.database.inTransaction()) {
                    this.database.endTransaction();
                }
            } catch (Throwable th3) {
                if (MBridgeConstans.DEBUG) {
                    th3.printStackTrace();
                }
            }
            return null;
        }
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void remove(final String str, final String str2) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.6
            @Override // java.lang.Runnable
            public void run() throws SQLException {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (Objects.isNull(DatabaseHelper.this.database) || !DatabaseHelper.this.database.isOpen()) {
                    return;
                }
                try {
                    DatabaseHelper.this.database.execSQL("DELETE FROM " + DatabaseHelper.this.tableName + " WHERE download_id = ? AND director_path = ?", new Object[]{str, str2});
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void update(final DownloadModel downloadModel, final String str) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.4
            @Override // java.lang.Runnable
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (Objects.isNull(DatabaseHelper.this.database) || !DatabaseHelper.this.database.isOpen()) {
                    return;
                }
                try {
                    DatabaseHelper.this.database.update(DatabaseHelper.this.tableName, DownloadModel.create(downloadModel), "download_id = ? AND director_path = ?", new String[]{downloadModel.getDownloadId(), str});
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void updateProgress(final String str, final String str2, final DownloadModel downloadModel) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.5
            @Override // java.lang.Runnable
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (Objects.isNull(DatabaseHelper.this.database) || !DatabaseHelper.this.database.isOpen()) {
                    return;
                }
                try {
                    DatabaseHelper.this.database.update(DatabaseHelper.this.tableName, DownloadModel.create(downloadModel), "download_id = ? AND director_path = ?", new String[]{str, str2});
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void updateUnzipResource(final String str, String str2, long j10) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.8
            @Override // java.lang.Runnable
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (Objects.isNull(DatabaseHelper.this.database) || !DatabaseHelper.this.database.isOpen()) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(DownloadModel.DOWNLOAD_ID, str);
                    DatabaseHelper.this.database.update(DatabaseHelper.this.tableName, contentValues, "download_id = ?", new String[]{str});
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void remove(final String str) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.7
            @Override // java.lang.Runnable
            public void run() throws SQLException {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (Objects.isNull(DatabaseHelper.this.database) || !DatabaseHelper.this.database.isOpen()) {
                    return;
                }
                try {
                    DatabaseHelper.this.database.execSQL("DELETE FROM " + DatabaseHelper.this.tableName + " WHERE download_id = ?", new Object[]{str});
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
