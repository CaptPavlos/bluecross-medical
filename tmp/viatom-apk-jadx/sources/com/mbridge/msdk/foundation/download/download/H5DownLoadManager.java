package com.mbridge.msdk.foundation.download.download;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Patterns;
import android.webkit.URLUtil;
import androidx.work.WorkRequest;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.resource.MBResourceManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.e.a;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.ap;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class H5DownLoadManager {
    public static final String SP_ENDING_PAGE_SAVE_TIME = "ending_page_save_time";
    public static final String SP_ENDING_PAGE_SOURCE = "ending_page_source";
    private static final String TAG = "H5DownLoadManager";
    private static volatile H5DownLoadManager sH5Manager;
    private final String DOWN_TYPE = "down_type";
    private final String LOCAL_RID = CampaignEx.JSON_KEY_LOCAL_REQUEST_ID;
    private HTMLResourceManager htmlResourceManager;
    private boolean isUseDownloadModule;
    private CopyOnWriteArrayList<String> mResDownloadingList;
    private ConcurrentMap<String, DownLoadH5SourceListener> mResDownloadingMap;
    private ResourceManager resourceManager;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface H5ResDownloadListerInter {
        void onFailed(String str, String str2);

        void onSuccess(String str, String str2, boolean z9);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface IH5SourceDownloadListener extends H5ResDownloadListerInter {
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface IOnDownLoadH5Source {
        void onFailed(String str);

        void onStart();

        void onSuccess(String str, byte[] bArr, String str2);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface ZipDownloadListener extends H5ResDownloadListerInter {
    }

    private H5DownLoadManager() {
        this.isUseDownloadModule = false;
        try {
            this.resourceManager = ResourceManager.getinstance();
            this.htmlResourceManager = HTMLResourceManager.getInstance();
            this.mResDownloadingList = new CopyOnWriteArrayList<>();
            this.mResDownloadingMap = new ConcurrentHashMap();
            g gVarB = h.a().b(c.m().k());
            if (gVarB != null) {
                this.isUseDownloadModule = gVarB.z(1);
            }
        } catch (Throwable th) {
            af.b(TAG, th.getMessage(), th);
        }
    }

    private void downloadHTML(final com.mbridge.msdk.foundation.same.report.d.c cVar, final String str, final H5ResDownloadListerInter h5ResDownloadListerInter) {
        try {
            af.b(TAG, "download url:" + str);
            final e eVar = new e();
            eVar.a("scenes", "1");
            eVar.a("url", str);
            if (cVar != null) {
                eVar.a("resource_type", Integer.valueOf(cVar.b()));
            }
            if (this.mResDownloadingList.contains(str)) {
                return;
            }
            this.mResDownloadingList.add(str);
            DownloadTask.getInstance().runTask(new a() { // from class: com.mbridge.msdk.foundation.download.download.H5DownLoadManager.2
                @Override // com.mbridge.msdk.foundation.same.e.a
                public void runTask() {
                    if (TextUtils.isEmpty(H5DownLoadManager.this.htmlResourceManager.getHtmlContentFromUrl(str))) {
                        DownLoadUtils.getSourceCodeFromNetUrl(str, new IOnDownLoadH5Source() { // from class: com.mbridge.msdk.foundation.download.download.H5DownLoadManager.2.1
                            @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.IOnDownLoadH5Source
                            public void onFailed(String str2) {
                                try {
                                    H5DownLoadManager.this.mResDownloadingList.remove(str);
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    H5ResDownloadListerInter h5ResDownloadListerInter2 = h5ResDownloadListerInter;
                                    if (h5ResDownloadListerInter2 != null) {
                                        h5ResDownloadListerInter2.onFailed(str, str2);
                                    }
                                } catch (Exception e) {
                                    if (MBridgeConstans.DEBUG) {
                                        e.printStackTrace();
                                    }
                                    AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                    H5ResDownloadListerInter h5ResDownloadListerInter3 = h5ResDownloadListerInter;
                                    if (h5ResDownloadListerInter3 != null) {
                                        h5ResDownloadListerInter3.onFailed(str, str2);
                                    }
                                }
                                AnonymousClass2 anonymousClass23 = AnonymousClass2.this;
                                if (h5ResDownloadListerInter == null) {
                                    eVar.a("result", 3);
                                    AnonymousClass2 anonymousClass24 = AnonymousClass2.this;
                                    cVar.a("m_download_end", eVar);
                                    d.a().a("m_download_end", cVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
                                }
                            }

                            @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.IOnDownLoadH5Source
                            public void onSuccess(String str2, byte[] bArr, String str3) {
                                try {
                                    H5DownLoadManager.this.mResDownloadingList.remove(str3);
                                    if (bArr == null || bArr.length <= 0) {
                                        return;
                                    }
                                    boolean zSaveResHtmlFile = H5DownLoadManager.this.htmlResourceManager.saveResHtmlFile(str3, bArr);
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    if (zSaveResHtmlFile) {
                                        H5ResDownloadListerInter h5ResDownloadListerInter2 = h5ResDownloadListerInter;
                                        if (h5ResDownloadListerInter2 != null) {
                                            h5ResDownloadListerInter2.onSuccess(str3, "", false);
                                            return;
                                        }
                                        eVar.a("result", 3);
                                        AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                        cVar.a("m_download_end", eVar);
                                        d.a().a("m_download_end", cVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
                                        return;
                                    }
                                    H5ResDownloadListerInter h5ResDownloadListerInter3 = h5ResDownloadListerInter;
                                    if (h5ResDownloadListerInter3 != null) {
                                        h5ResDownloadListerInter3.onFailed(str3, "save file failed");
                                        return;
                                    }
                                    eVar.a("result", 3);
                                    AnonymousClass2 anonymousClass23 = AnonymousClass2.this;
                                    cVar.a("m_download_end", eVar);
                                    d.a().a("m_download_end", cVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
                                } catch (Exception e) {
                                    if (MBridgeConstans.DEBUG) {
                                        e.printStackTrace();
                                    }
                                    AnonymousClass2 anonymousClass24 = AnonymousClass2.this;
                                    H5ResDownloadListerInter h5ResDownloadListerInter4 = h5ResDownloadListerInter;
                                    if (h5ResDownloadListerInter4 != null) {
                                        h5ResDownloadListerInter4.onFailed(str3, e.getMessage());
                                        return;
                                    }
                                    eVar.a("result", 3);
                                    AnonymousClass2 anonymousClass25 = AnonymousClass2.this;
                                    cVar.a("m_download_end", eVar);
                                    d.a().a("m_download_end", cVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
                                }
                            }

                            @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.IOnDownLoadH5Source
                            public void onStart() {
                            }
                        }, true);
                        eVar.a("cache", 1);
                        cVar.a("m_download_start", eVar);
                        d.a().a("m_download_start", cVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
                        return;
                    }
                    eVar.a("cache", 2);
                    H5DownLoadManager.this.mResDownloadingList.remove(str);
                    H5ResDownloadListerInter h5ResDownloadListerInter2 = h5ResDownloadListerInter;
                    if (h5ResDownloadListerInter2 != null) {
                        h5ResDownloadListerInter2.onSuccess(str, "", true);
                    }
                    cVar.a("m_download_start", eVar);
                    d.a().a("m_download_start", cVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
                }

                @Override // com.mbridge.msdk.foundation.same.e.a
                public void cancelTask() {
                }

                @Override // com.mbridge.msdk.foundation.same.e.a
                public void pauseTask(boolean z9) {
                }
            });
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
    }

    private void downloadHTMLByDownloadModule(final String str, final H5ResDownloadListerInter h5ResDownloadListerInter) throws NoSuchAlgorithmException {
        if (TextUtils.isEmpty(str)) {
            if (h5ResDownloadListerInter != null) {
                h5ResDownloadListerInter.onFailed("zip url is null", str);
                return;
            }
            return;
        }
        try {
            new URL(str);
            MBDownloadManager.getInstance().download(new DownloadMessage<>(new Object(), str, a3.a.C(SameMD5.getMD5(aq.b(str)), ".html"), 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_HTML)).withTimeout(ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS).withReadTimeout(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS).withConnectTimeout(20000L).withDownloadPriority(DownloadPriority.HIGH).withHttpRetryCounter(1).withDirectoryPathInternal(com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_HTML) + "/").withDownloadStateListener(new OnDownloadStateListener() { // from class: com.mbridge.msdk.foundation.download.download.H5DownLoadManager.1
                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public void onCancelDownload(DownloadMessage downloadMessage) {
                    af.a(H5DownLoadManager.TAG, "下载取消： ");
                    H5ResDownloadListerInter h5ResDownloadListerInter2 = h5ResDownloadListerInter;
                    if (h5ResDownloadListerInter2 != null) {
                        h5ResDownloadListerInter2.onFailed(str, "task cancel");
                    }
                }

                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public void onDownloadComplete(DownloadMessage downloadMessage) {
                    af.a(H5DownLoadManager.TAG, "下载结束： " + downloadMessage.getDownloadUrl() + " " + downloadMessage.getDownloadResourceType() + " " + downloadMessage.getSaveFilePath());
                    H5ResDownloadListerInter h5ResDownloadListerInter2 = h5ResDownloadListerInter;
                    if (h5ResDownloadListerInter2 != null) {
                        h5ResDownloadListerInter2.onSuccess(str, "", false);
                    }
                }

                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
                    af.a(H5DownLoadManager.TAG, "下载结束失败： " + downloadError.getException().getMessage());
                    H5ResDownloadListerInter h5ResDownloadListerInter2 = h5ResDownloadListerInter;
                    if (h5ResDownloadListerInter2 != null) {
                        h5ResDownloadListerInter2.onFailed(str, downloadError.getException().getMessage());
                    }
                }

                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public void onDownloadStart(DownloadMessage downloadMessage) {
                    af.a(H5DownLoadManager.TAG, "开始下载 html： " + downloadMessage.getDownloadUrl() + " " + downloadMessage.getDownloadResourceType());
                }
            }).build().start();
        } catch (Exception unused) {
            if (h5ResDownloadListerInter != null) {
                h5ResDownloadListerInter.onFailed("zip url is unlawful", str);
            }
        }
    }

    private void downloadZipByDownloadModule(final com.mbridge.msdk.foundation.same.report.d.c cVar, String str, final ZipDownloadListener zipDownloadListener) throws NoSuchAlgorithmException {
        if (TextUtils.isEmpty(str)) {
            if (zipDownloadListener != null) {
                zipDownloadListener.onFailed(str, "zip url is null");
                return;
            }
            return;
        }
        try {
            new URL(str);
            final e eVar = new e();
            eVar.a("scenes", "1");
            eVar.a("url", str);
            if (cVar != null) {
                eVar.a("resource_type", Integer.valueOf(cVar.b()));
            }
            String strA = com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_RES);
            String md5 = SameMD5.getMD5(aq.b(str));
            String strC = a3.a.C(strA, "/");
            final String strJ = a3.a.j(strA, "/", md5);
            DownloadMessage<?> downloadMessage = new DownloadMessage<>(cVar, str, a3.a.C(md5, ".zip"), 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_ZIP);
            if (cVar != null) {
                downloadMessage.setUseCronetDownload(cVar.n());
            }
            MBDownloadManager.getInstance().download(downloadMessage).withReadTimeout(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS).withConnectTimeout(20000L).withDownloadPriority(DownloadPriority.HIGH).withHttpRetryCounter(1).withDirectoryPathInternal(strC).withTimeout(ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS).withDownloadStateListener(new OnDownloadStateListener() { // from class: com.mbridge.msdk.foundation.download.download.H5DownLoadManager.3
                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public void onCancelDownload(DownloadMessage downloadMessage2) {
                    af.a(H5DownLoadManager.TAG, "下载取消： " + downloadMessage2.getDownloadUrl() + " " + downloadMessage2.getDownloadResourceType());
                    e eVar2 = eVar;
                    if (eVar2 != null) {
                        eVar2.a("cache", Integer.valueOf(downloadMessage2.isCache() ? 1 : 2));
                    }
                    com.mbridge.msdk.foundation.same.report.d.c cVar2 = cVar;
                    if (cVar2 != null) {
                        cVar2.a("m_download_start", eVar);
                    }
                    d.a().a("m_download_start", cVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
                    boolean zIsEmpty = TextUtils.isEmpty(ResourceManager.getinstance().getResDirFromCampaign(downloadMessage2.getDownloadUrl()));
                    ZipDownloadListener zipDownloadListener2 = zipDownloadListener;
                    if (zIsEmpty) {
                        if (zipDownloadListener2 != null) {
                            zipDownloadListener2.onFailed(downloadMessage2.getDownloadUrl(), "task cancel");
                        }
                    } else if (zipDownloadListener2 != null) {
                        zipDownloadListener2.onSuccess(downloadMessage2.getDownloadUrl(), "", downloadMessage2.isCache());
                    }
                }

                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public void onDownloadComplete(DownloadMessage downloadMessage2) {
                    af.a(H5DownLoadManager.TAG, "下载结束，开始解压缩文件： " + downloadMessage2.getDownloadUrl() + " " + downloadMessage2.getDownloadResourceType() + " " + downloadMessage2.getSaveFilePath());
                    try {
                        e eVar2 = eVar;
                        if (eVar2 != null) {
                            eVar2.a("cache", Integer.valueOf(downloadMessage2.isCache() ? 1 : 2));
                        }
                        com.mbridge.msdk.foundation.same.report.d.c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.a("m_download_start", eVar);
                        }
                        d.a().a("m_download_start", cVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
                        if (TextUtils.isEmpty(ResourceManager.getinstance().getResDirFromCampaign(downloadMessage2.getDownloadUrl()))) {
                            MBResourceManager.getInstance().unZip(downloadMessage2.getSaveFilePath(), strJ);
                        }
                        String str2 = "";
                        try {
                            str2 = (String) downloadMessage2.getExtra("responseHeaders");
                        } catch (Throwable th) {
                            af.b(H5DownLoadManager.TAG, th.getMessage());
                        }
                        af.a(H5DownLoadManager.TAG, "下载结束，开始解压缩文件，文件解压成功： " + strJ);
                        ZipDownloadListener zipDownloadListener2 = zipDownloadListener;
                        if (zipDownloadListener2 != null) {
                            zipDownloadListener2.onSuccess(downloadMessage2.getDownloadUrl(), str2, downloadMessage2.isCache());
                        }
                    } catch (IOException e) {
                        af.a(H5DownLoadManager.TAG, "下载结束，开始解压缩文件，文件解压失败： " + e.getMessage());
                        ZipDownloadListener zipDownloadListener3 = zipDownloadListener;
                        if (zipDownloadListener3 != null) {
                            zipDownloadListener3.onFailed(downloadMessage2.getDownloadUrl(), e.getMessage());
                        }
                    }
                }

                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public void onDownloadError(DownloadMessage downloadMessage2, DownloadError downloadError) {
                    af.a(H5DownLoadManager.TAG, "下载错误： " + downloadMessage2.getDownloadUrl() + " " + downloadMessage2.getDownloadResourceType() + "  " + downloadError.getException().getMessage());
                    e eVar2 = eVar;
                    if (eVar2 != null) {
                        eVar2.a("cache", Integer.valueOf(downloadMessage2.isCache() ? 1 : 2));
                    }
                    com.mbridge.msdk.foundation.same.report.d.c cVar2 = cVar;
                    if (cVar2 != null) {
                        cVar2.a("m_download_start", eVar);
                    }
                    d.a().a("m_download_start", cVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
                    boolean zIsEmpty = TextUtils.isEmpty(ResourceManager.getinstance().getResDirFromCampaign(downloadMessage2.getDownloadUrl()));
                    ZipDownloadListener zipDownloadListener2 = zipDownloadListener;
                    if (zIsEmpty) {
                        if (zipDownloadListener2 != null) {
                            zipDownloadListener2.onFailed(downloadMessage2.getDownloadUrl(), downloadError.getException().getMessage());
                        }
                    } else if (zipDownloadListener2 != null) {
                        zipDownloadListener2.onSuccess(downloadMessage2.getDownloadUrl(), "", downloadMessage2.isCache());
                    }
                }

                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public void onDownloadStart(DownloadMessage downloadMessage2) {
                    af.a(H5DownLoadManager.TAG, "开始下载 zip： " + downloadMessage2.getDownloadUrl() + " " + downloadMessage2.getDownloadResourceType());
                }
            }).build().start();
        } catch (Exception unused) {
            if (zipDownloadListener != null) {
                zipDownloadListener.onFailed(str, "zip url is unlawful");
            }
        }
    }

    private void downloadZipByOldDownloadModule(com.mbridge.msdk.foundation.same.report.d.c cVar, String str, ZipDownloadListener zipDownloadListener) {
        e eVar = new e();
        eVar.a("scenes", "1");
        eVar.a("url", str);
        if (cVar != null) {
            eVar.a("resource_type", Integer.valueOf(cVar.b()));
        }
        try {
            if (TextUtils.isEmpty(this.resourceManager.getResDirFromCampaign(str))) {
                eVar.a("cache", 2);
                if (this.mResDownloadingMap.containsKey(str)) {
                    DownLoadH5SourceListener downLoadH5SourceListener = this.mResDownloadingMap.get(str);
                    if (downLoadH5SourceListener != null) {
                        downLoadH5SourceListener.setZipDownloadListener(zipDownloadListener);
                    }
                    if (cVar == null || cVar.a()) {
                        return;
                    }
                    cVar.a("m_download_start", eVar);
                    d.a().a("m_download_start", cVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
                    return;
                }
                DownLoadH5SourceListener downLoadH5SourceListener2 = new DownLoadH5SourceListener(this.mResDownloadingMap, this.resourceManager, zipDownloadListener, str);
                this.mResDownloadingMap.put(str, downLoadH5SourceListener2);
                DownLoadUtils.getSourceCodeFromNetUrl(str, downLoadH5SourceListener2, true);
            } else {
                eVar.a("cache", 1);
                if (zipDownloadListener != null) {
                    zipDownloadListener.onSuccess(str, "", true);
                }
            }
            if (cVar == null || cVar.a()) {
                return;
            }
            cVar.a("m_download_start", eVar);
            d.a().a("m_download_start", cVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
        } catch (Exception e) {
            if (zipDownloadListener != null) {
                zipDownloadListener.onFailed(str, "downloadzip failed");
            }
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private String getHtmlAddress(String str) {
        HTMLResourceManager hTMLResourceManager = this.htmlResourceManager;
        return hTMLResourceManager != null ? hTMLResourceManager.getHtmlPathFromUrl(str) : str;
    }

    public static H5DownLoadManager getInstance() {
        if (sH5Manager == null) {
            synchronized (H5DownLoadManager.class) {
                try {
                    if (sH5Manager == null) {
                        sH5Manager = new H5DownLoadManager();
                    }
                } finally {
                }
            }
        }
        return sH5Manager;
    }

    private long getPreSaveTimeFromSp(String str) {
        try {
            Object objA = an.a(c.m().c(), SP_ENDING_PAGE_SAVE_TIME + str, 0L);
            if (objA != null && (objA instanceof Long)) {
                return ((Long) objA).longValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0L;
    }

    private void saveSourceContent(String str, String str2) {
        try {
            af.c(TAG, "sourceContent:" + str);
            an.b(c.m().c(), SP_ENDING_PAGE_SOURCE + str2, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateEndingPageSaveTime(String str) {
        try {
            an.b(c.m().c(), SP_ENDING_PAGE_SAVE_TIME + str, Long.valueOf(System.currentTimeMillis()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void download(com.mbridge.msdk.foundation.same.report.d.c cVar, String str, H5ResDownloadListerInter h5ResDownloadListerInter) throws NoSuchAlgorithmException {
        if (this.isUseDownloadModule) {
            downloadHTMLByDownloadModule(str, h5ResDownloadListerInter);
        } else {
            downloadHTML(cVar, str, h5ResDownloadListerInter);
        }
    }

    public void downloadH5Res(com.mbridge.msdk.foundation.same.report.d.c cVar, String str, H5ResDownloadListerInter h5ResDownloadListerInter) {
        com.mbridge.msdk.foundation.same.report.d.c cVarB = d.a().b(cVar);
        try {
            if (Patterns.WEB_URL.matcher(str).matches() || URLUtil.isValidUrl(str)) {
                String path = Uri.parse(str).getPath();
                if (!TextUtils.isEmpty(path)) {
                    if (path.toLowerCase().endsWith(".zip")) {
                        downloadZip(cVarB, str, (ZipDownloadListener) h5ResDownloadListerInter);
                        return;
                    } else {
                        download(cVarB, str, h5ResDownloadListerInter);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (h5ResDownloadListerInter != null) {
            h5ResDownloadListerInter.onFailed(str, "The URL does not contain a path ");
        }
    }

    public void downloadZip(com.mbridge.msdk.foundation.same.report.d.c cVar, String str, ZipDownloadListener zipDownloadListener) throws NoSuchAlgorithmException {
        if (this.isUseDownloadModule) {
            downloadZipByDownloadModule(cVar, str, zipDownloadListener);
        } else {
            downloadZipByOldDownloadModule(cVar, str, zipDownloadListener);
        }
    }

    public String getH5ResAddress(String str) {
        try {
            if (!Patterns.WEB_URL.matcher(str).matches() && !URLUtil.isValidUrl(str)) {
                return str;
            }
            Uri uri = Uri.parse(str);
            String path = uri.getPath();
            if (!TextUtils.isEmpty(path) && TextUtils.isEmpty(uri.getQueryParameter("urlDebug"))) {
                return path.toLowerCase().endsWith(".zip") ? getResAddress(str) : getHtmlAddress(str);
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public String getResAddress(String str) {
        ResourceManager resourceManager = this.resourceManager;
        if (resourceManager != null) {
            return resourceManager.getResDirFromCampaign(str);
        }
        return null;
    }

    public String getSourceContentFromSp(String str) {
        try {
            Object objA = an.a(c.m().c(), SP_ENDING_PAGE_SOURCE + str, "");
            if (objA == null || !(objA instanceof String)) {
                return null;
            }
            String str2 = (String) objA;
            if (ap.b(str2)) {
                return str2;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void download(com.mbridge.msdk.foundation.same.report.d.c cVar, String str) throws NoSuchAlgorithmException {
        download(cVar, str, null);
    }

    public void downloadH5Res(com.mbridge.msdk.foundation.same.report.d.c cVar, String str) {
        downloadH5Res(cVar, str, null);
    }

    public void downloadH5Res(String str, H5ResDownloadListerInter h5ResDownloadListerInter) {
        downloadH5Res(new com.mbridge.msdk.foundation.same.report.d.c(), str, h5ResDownloadListerInter);
    }
}
