package com.mbridge.msdk.tracker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.work.PeriodicWorkRequest;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class y {
    public static long a(int i10, long j10, long j11) {
        if (i10 <= 0 || j10 == 0 || i10 <= 10) {
            return j11;
        }
        if (i10 <= 20) {
            return ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS;
        }
        if (i10 <= 30) {
            return 120000L;
        }
        if (i10 <= 40) {
            return 180000L;
        }
        if (i10 <= 50) {
            return 240000L;
        }
        return PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
    }

    public static List<i> b(Cursor cursor) {
        int i10;
        int i11;
        ArrayList arrayList = new ArrayList();
        try {
            int columnIndex = cursor.getColumnIndex(RewardPlus.NAME);
            int columnIndex2 = cursor.getColumnIndex(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            int columnIndex3 = cursor.getColumnIndex("time_stamp");
            int columnIndex4 = cursor.getColumnIndex("properties");
            int columnIndex5 = cursor.getColumnIndex("priority");
            int columnIndex6 = cursor.getColumnIndex("uuid");
            int columnIndex7 = cursor.getColumnIndex(TypedValues.TransitionType.S_DURATION);
            int columnIndex8 = cursor.getColumnIndex(MRAIDCommunicatorUtil.KEY_STATE);
            int columnIndex9 = cursor.getColumnIndex("report_count");
            int columnIndex10 = cursor.getColumnIndex("ignore_max_timeout");
            int columnIndex11 = cursor.getColumnIndex("ignore_max_retry_times");
            int columnIndex12 = cursor.getColumnIndex("invalid_time");
            while (cursor.moveToNext()) {
                try {
                    e eVar = new e(cursor.getString(columnIndex));
                    eVar.a(cursor.getInt(columnIndex2));
                    i10 = columnIndex;
                    i11 = columnIndex2;
                    try {
                        eVar.a(cursor.getLong(columnIndex3));
                        eVar.a(new JSONObject(cursor.getString(columnIndex4)));
                        eVar.b(cursor.getInt(columnIndex5));
                        eVar.a(cursor.getString(columnIndex6));
                        eVar.b(cursor.getLong(columnIndex7));
                        i iVar = new i(eVar);
                        iVar.b(cursor.getInt(columnIndex8));
                        iVar.a(cursor.getInt(columnIndex9));
                        iVar.a(cursor.getInt(columnIndex10) == 0);
                        iVar.b(cursor.getInt(columnIndex11) == 0);
                        iVar.a(cursor.getLong(columnIndex12));
                        arrayList.add(iVar);
                    } catch (JSONException e) {
                        e = e;
                        if (a.f5328a) {
                            Log.e("TrackManager", "create: ", e);
                        }
                        columnIndex = i10;
                        columnIndex2 = i11;
                    }
                } catch (JSONException e3) {
                    e = e3;
                    i10 = columnIndex;
                    i11 = columnIndex2;
                }
                columnIndex = i10;
                columnIndex2 = i11;
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public static boolean a(Object obj) {
        return obj == null;
    }

    public static boolean a(List<?> list) {
        return list == null || list.size() == 0;
    }

    public static void a(Cursor cursor) {
        try {
            if (!b((Object) cursor) || cursor.isClosed()) {
                return;
            }
            cursor.close();
        } catch (Exception unused) {
        }
    }

    @SuppressLint({"MissingPermission"})
    public static boolean a(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null) {
            return true;
        }
        NetworkInfo activeNetworkInfo = null;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception unused) {
            connectivityManager = null;
        }
        if (connectivityManager == null) {
            return true;
        }
        try {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception unused2) {
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static boolean b(List<i> list) {
        if (a((List<?>) list)) {
            return false;
        }
        for (i iVar : list) {
            if (!a(iVar)) {
                e eVarC = iVar.c();
                if (!a(eVarC) && eVarC.c() == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean b(Object obj) {
        return obj != null;
    }
}
