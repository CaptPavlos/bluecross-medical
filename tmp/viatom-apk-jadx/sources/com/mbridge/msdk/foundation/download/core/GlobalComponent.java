package com.mbridge.msdk.foundation.download.core;

import android.content.Context;
import android.database.Cursor;
import com.mbridge.msdk.foundation.download.MBDownloadConfig;
import com.mbridge.msdk.foundation.download.database.DatabaseHelper;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.download.database.IDatabaseHelper;
import com.mbridge.msdk.foundation.download.utils.ILogger;
import com.mbridge.msdk.foundation.download.utils.Objects;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.thrid.okhttp.ConnectionPool;
import com.mbridge.msdk.thrid.okhttp.Dispatcher;
import com.mbridge.msdk.thrid.okhttp.OkHttpClient;
import com.mbridge.msdk.thrid.okhttp.Protocol;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class GlobalComponent {
    private static volatile GlobalComponent INSTANCE;
    private MBDownloadConfig config;
    private Context context;
    private IDatabaseHelper databaseHelper;
    private ILogger logger;
    private volatile OkHttpClient okHttpClient;
    private int byteBufferSize = 4096;
    private String databaseTableName = DownloadModel.TABLE_NAME;

    private GlobalComponent() {
    }

    public static GlobalComponent getInstance() {
        if (Objects.isNull(INSTANCE)) {
            synchronized (GlobalComponent.class) {
                try {
                    if (Objects.isNull(INSTANCE)) {
                        INSTANCE = new GlobalComponent();
                    }
                } finally {
                }
            }
        }
        return INSTANCE;
    }

    public final int getByteBufferSize() {
        return this.byteBufferSize;
    }

    public final Context getContext() {
        return this.context;
    }

    public final IDatabaseHelper getDatabaseHelper() {
        return this.databaseHelper;
    }

    public final String getDatabaseTableName() {
        return this.databaseTableName;
    }

    public final ILogger getLogger() {
        if (this.logger == null) {
            this.logger = new ILogger() { // from class: com.mbridge.msdk.foundation.download.core.GlobalComponent.1
                @Override // com.mbridge.msdk.foundation.download.utils.ILogger
                public void log(String str, Exception exc) {
                    af.a(str, exc.getMessage());
                }

                @Override // com.mbridge.msdk.foundation.download.utils.ILogger
                public void log(String str, String str2) {
                    af.a(str, str2);
                }
            };
        }
        return this.logger;
    }

    public final OkHttpClient getOkHttpClient() {
        if (this.okHttpClient == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Protocol.HTTP_1_1);
            Dispatcher dispatcher = new Dispatcher(new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false)));
            dispatcher.setMaxRequests(this.config.getMaxRequests());
            dispatcher.setMaxRequestsPerHost(this.config.getMaxRequestsPerHost());
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            long defaultConnectTimeout = this.config.getDefaultConnectTimeout();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.okHttpClient = builder.connectTimeout(defaultConnectTimeout, timeUnit).readTimeout(this.config.getDefaultConnectTimeout(), timeUnit).writeTimeout(this.config.getDefaultWriteTimeout(), timeUnit).dispatcher(dispatcher).pingInterval(this.config.getDefaultPingInterval(), timeUnit).retryOnConnectionFailure(true).connectionPool(new ConnectionPool(32, 5L, TimeUnit.MINUTES)).protocols(arrayList).build();
        }
        return this.okHttpClient;
    }

    public final void initialize(Context context, MBDownloadConfig mBDownloadConfig) {
        this.context = context.getApplicationContext();
        this.logger = mBDownloadConfig.getLogger();
        this.config = mBDownloadConfig;
        if (mBDownloadConfig.getDatabaseHandler() == null || mBDownloadConfig.getDatabaseHelper() == null) {
            this.databaseHelper = new IDatabaseHelper() { // from class: com.mbridge.msdk.foundation.download.core.GlobalComponent.2
                @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
                public List<DownloadModel> findAll() {
                    return null;
                }

                @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
                public List<DownloadModel> getUnwantedModels(long j10) {
                    return null;
                }

                @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
                public Cursor rawQuery(String str, String[] strArr) {
                    return null;
                }

                @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
                public void remove(String str, String str2) {
                }

                @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
                public void clear() {
                }

                @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
                public void insert(DownloadModel downloadModel) {
                }

                @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
                public void remove(String str) {
                }

                @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
                public void findByDownloadUrl(String str, IDatabaseHelper.IDatabaseListener iDatabaseListener) {
                }

                @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
                public void update(DownloadModel downloadModel, String str) {
                }

                @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
                public void find(String str, String str2, IDatabaseHelper.IDatabaseListener iDatabaseListener) {
                }

                @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
                public void updateProgress(String str, String str2, DownloadModel downloadModel) {
                }

                @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
                public void updateUnzipResource(String str, String str2, long j10) {
                }
            };
        } else {
            this.databaseHelper = new DatabaseHelper(context, mBDownloadConfig.getDatabaseHandler(), mBDownloadConfig.getDatabaseHelper());
        }
    }
}
