package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n extends a<Campaign> {

    /* renamed from: a, reason: collision with root package name */
    private static n f3484a;

    private n(f fVar) {
        super(fVar);
    }

    private synchronized boolean b(String str, String str2) {
        String[] strArr;
        String str3;
        try {
            if (TextUtils.isEmpty(str2)) {
                str3 = "SELECT id FROM video WHERE video_url = ? ";
                strArr = new String[]{str};
            } else {
                strArr = new String[]{str, str2};
                str3 = "SELECT id FROM video WHERE video_url = ? AND id = ? ";
            }
            Cursor cursorRawQuery = getReadableDatabase().rawQuery(str3, strArr);
            if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
                try {
                    cursorRawQuery.close();
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("VideoDao", e.getLocalizedMessage());
                    }
                }
                return true;
            }
            if (cursorRawQuery != null) {
                try {
                    cursorRawQuery.close();
                } catch (Exception e3) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("VideoDao", e3.getLocalizedMessage());
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
        throw th;
    }

    public final synchronized long a(CampaignEx campaignEx, long j10, String str, int i10) {
        if (campaignEx == null) {
            return 0L;
        }
        try {
            try {
                if (getWritableDatabase() == null) {
                    return -1L;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("unitid", campaignEx.getCampaignUnitId());
                contentValues.put("id", campaignEx.getId());
                contentValues.put(CampaignEx.JSON_KEY_PACKAGE_NAME, campaignEx.getPackageName());
                contentValues.put("app_name", campaignEx.getAppName());
                contentValues.put("app_desc", campaignEx.getAppDesc());
                contentValues.put(CampaignEx.JSON_KEY_APP_SIZE, campaignEx.getSize());
                contentValues.put(CampaignEx.JSON_KEY_IMAGE_SIZE, campaignEx.getImageSize());
                contentValues.put(CampaignEx.JSON_KEY_ICON_URL, campaignEx.getIconUrl());
                contentValues.put(CampaignEx.JSON_KEY_IMAGE_URL, campaignEx.getImageUrl());
                contentValues.put(CampaignEx.JSON_KEY_IMPRESSION_URL, campaignEx.getImpressionURL());
                contentValues.put(CampaignEx.JSON_KEY_NOTICE_URL, campaignEx.getNoticeUrl());
                contentValues.put(DownloadModel.DOWNLOAD_URL, campaignEx.getClickURL());
                contentValues.put("only_impression", campaignEx.getOnlyImpressionURL());
                contentValues.put(CampaignEx.JSON_KEY_ST_TS, Long.valueOf(campaignEx.getTimestamp()));
                contentValues.put("template", Integer.valueOf(campaignEx.getTemplate()));
                contentValues.put(CampaignEx.JSON_KEY_CLICK_MODE, campaignEx.getClick_mode());
                contentValues.put(CampaignEx.JSON_KEY_LANDING_TYPE, campaignEx.getLandingType());
                contentValues.put(CampaignEx.JSON_KEY_LINK_TYPE, Integer.valueOf(campaignEx.getLinkType()));
                contentValues.put("star", Double.valueOf(campaignEx.getRating()));
                contentValues.put("cti", Integer.valueOf(campaignEx.getClickInterval()));
                contentValues.put("level", Integer.valueOf(campaignEx.getCacheLevel()));
                contentValues.put("adSource", Integer.valueOf(campaignEx.getType()));
                contentValues.put("ad_call", campaignEx.getAdCall());
                contentValues.put("fc_a", Integer.valueOf(campaignEx.getFca()));
                contentValues.put(CampaignEx.JSON_KEY_AD_URL_LIST, campaignEx.getAd_url_list());
                contentValues.put(CampaignEx.JSON_KEY_VIDEO_URL, campaignEx.getVideoUrlEncode());
                contentValues.put("total_size", Long.valueOf(j10));
                contentValues.put("video_state", Integer.valueOf(i10));
                contentValues.put("video_download_start", Long.valueOf(System.currentTimeMillis() / 1000));
                contentValues.put("ad_bid_token", campaignEx.getBidToken());
                if (!TextUtils.isEmpty(str)) {
                    contentValues.put("video_path", str);
                }
                if (b(campaignEx.getVideoUrlEncode(), campaignEx.getId())) {
                    return 0L;
                }
                return getWritableDatabase().insert(MimeTypes.BASE_TYPE_VIDEO, null, contentValues);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    af.b("VideoDao", e.getLocalizedMessage());
                }
                return -1L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b(String str) {
        String[] strArr;
        try {
            strArr = new String[]{str};
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.b("VideoDao", e.getLocalizedMessage());
            }
        }
        if (getWritableDatabase() == null) {
            return;
        }
        getWritableDatabase().delete(MimeTypes.BASE_TYPE_VIDEO, "video_url = ? ", strArr);
    }

    public final synchronized long b(String str, long j10) {
        int iUpdate = -1;
        try {
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.b("VideoDao", e.getLocalizedMessage());
            }
        }
        if (getWritableDatabase() == null) {
            return -1;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("total_size", Long.valueOf(j10));
        if (b(str, "")) {
            String[] strArr = {str};
            synchronized (new Object()) {
                iUpdate = getWritableDatabase().update(MimeTypes.BASE_TYPE_VIDEO, contentValues, "video_url = ? ", strArr);
            }
        }
        return iUpdate;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized com.mbridge.msdk.foundation.entity.m a(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.n.a(java.lang.String):com.mbridge.msdk.foundation.entity.m");
    }

    public final synchronized com.mbridge.msdk.foundation.entity.m a(String str, String str2) {
        Cursor cursorRawQuery = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m();
        try {
            try {
                cursorRawQuery = getReadableDatabase().rawQuery("SELECT * FROM video WHERE video_url = ? ", new String[]{str});
                if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
                    while (cursorRawQuery.moveToNext()) {
                        mVar.b(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_URL)));
                        mVar.a(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("video_state")));
                        mVar.b(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("pregeress_size")));
                        mVar.b(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("total_size")));
                        mVar.a(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("video_path")));
                        mVar.a(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("video_download_start")) * 1000);
                    }
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    af.b("VideoDao", e.getLocalizedMessage());
                }
                if (cursorRawQuery != null) {
                }
            }
            if (cursorRawQuery != null) {
                try {
                    cursorRawQuery.close();
                } catch (Exception unused) {
                }
            }
            return mVar;
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                try {
                    cursorRawQuery.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    public final synchronized void a(String str, long j10) {
        ContentValues contentValues;
        if (j10 == 0) {
            return;
        }
        try {
            contentValues = new ContentValues();
            contentValues.put("video_download_start", Long.valueOf(j10 / 1000));
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.b("VideoDao", e.getLocalizedMessage());
            }
        }
        if (b(str, "")) {
            getWritableDatabase().update(MimeTypes.BASE_TYPE_VIDEO, contentValues, "video_url = ? ", new String[]{str});
            return;
        }
        return;
    }

    public static synchronized n a(f fVar) {
        try {
            if (f3484a == null) {
                f3484a = new n(fVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f3484a;
    }

    public final synchronized long a(String str, long j10, int i10) {
        int iUpdate = -1;
        try {
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.b("VideoDao", e.getLocalizedMessage());
            }
        }
        if (getWritableDatabase() == null) {
            return -1;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("pregeress_size", Long.valueOf(j10));
        contentValues.put("video_state", Integer.valueOf(i10));
        if (b(str, "")) {
            String[] strArr = {str};
            synchronized (new Object()) {
                iUpdate = getWritableDatabase().update(MimeTypes.BASE_TYPE_VIDEO, contentValues, "video_url = ? ", strArr);
            }
        }
        return iUpdate;
    }
}
