package com.mbridge.msdk.foundation.download;

import android.os.Handler;
import com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper;
import com.mbridge.msdk.foundation.download.utils.ILogger;
import com.mbridge.msdk.foundation.download.utils.Objects;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBDownloadConfig {
    private Handler databaseHandler;
    private IDatabaseOpenHelper databaseHelper;
    private long defaultConnectTimeout;
    private long defaultPingInterval;
    private long defaultReadTimeout;
    private long defaultWriteTimeout;
    private ILogger logger;
    private int maxRequests;
    private int maxRequestsPerHost;

    private MBDownloadConfig(Builder builder) {
        this.databaseHelper = builder.databaseHelper;
        this.logger = builder.logger;
        this.databaseHandler = builder.databaseHandler;
        this.defaultConnectTimeout = builder.defaultConnectTimeout;
        this.defaultReadTimeout = builder.defaultReadTimeout;
        this.defaultWriteTimeout = builder.defaultWriteTimeout;
        this.maxRequests = builder.maxRequests;
        this.maxRequestsPerHost = builder.maxRequestsPerHost;
        this.defaultPingInterval = builder.defaultPingInterval;
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public Handler getDatabaseHandler() {
        return this.databaseHandler;
    }

    public IDatabaseOpenHelper getDatabaseHelper() {
        return this.databaseHelper;
    }

    public long getDefaultConnectTimeout() {
        return this.defaultConnectTimeout;
    }

    public long getDefaultPingInterval() {
        return this.defaultPingInterval;
    }

    public long getDefaultReadTimeout() {
        return this.defaultReadTimeout;
    }

    public long getDefaultWriteTimeout() {
        return this.defaultWriteTimeout;
    }

    public ILogger getLogger() {
        return this.logger;
    }

    public int getMaxRequests() {
        return this.maxRequests;
    }

    public int getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
    }

    public static Builder newBuilder(MBDownloadConfig mBDownloadConfig) {
        return new Builder(mBDownloadConfig);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Builder {
        private Handler databaseHandler;
        private IDatabaseOpenHelper databaseHelper;
        private String databaseName;
        private int databaseVersion;
        private long defaultConnectTimeout;
        private long defaultPingInterval;
        private long defaultReadTimeout;
        private long defaultWriteTimeout;
        private ILogger logger;
        private int maxRequests;
        private int maxRequestsPerHost;
        private String tableName;

        public Builder(MBDownloadConfig mBDownloadConfig) {
            this.databaseName = "";
            this.databaseVersion = -1;
            this.defaultConnectTimeout = 20000L;
            this.defaultPingInterval = 10L;
            this.defaultReadTimeout = 20000L;
            this.defaultWriteTimeout = 20000L;
            this.logger = new ILogger() { // from class: com.mbridge.msdk.foundation.download.MBDownloadConfig.Builder.1
                @Override // com.mbridge.msdk.foundation.download.utils.ILogger
                public void log(String str, String str2) {
                }

                @Override // com.mbridge.msdk.foundation.download.utils.ILogger
                public void log(String str, Exception exc) {
                }
            };
            this.maxRequests = 64;
            this.maxRequestsPerHost = 20;
            this.tableName = Command.DEFAULT_DATABASE_TABLE_NAME;
            if (Objects.isNotNull(mBDownloadConfig)) {
                this.databaseHandler = mBDownloadConfig.getDatabaseHandler();
                this.logger = mBDownloadConfig.getLogger();
                this.defaultReadTimeout = mBDownloadConfig.getDefaultReadTimeout();
                this.defaultConnectTimeout = mBDownloadConfig.getDefaultConnectTimeout();
                this.maxRequests = mBDownloadConfig.getMaxRequests();
                this.defaultWriteTimeout = mBDownloadConfig.getDefaultWriteTimeout();
                this.maxRequests = mBDownloadConfig.getMaxRequests();
                this.maxRequestsPerHost = mBDownloadConfig.getMaxRequestsPerHost();
                this.defaultPingInterval = mBDownloadConfig.getDefaultPingInterval();
            }
        }

        public final MBDownloadConfig build() {
            return new MBDownloadConfig(this);
        }

        public final Builder setDatabaseHandler(Handler handler) {
            this.databaseHandler = handler;
            return this;
        }

        public final Builder setDatabaseOpenHelper(IDatabaseOpenHelper iDatabaseOpenHelper) {
            this.databaseHelper = iDatabaseOpenHelper;
            return this;
        }

        public final Builder setDefaultConnectTimeout(long j10) {
            this.defaultConnectTimeout = j10;
            return this;
        }

        public final Builder setDefaultPingInterval(long j10) {
            this.defaultPingInterval = j10;
            return this;
        }

        public final Builder setDefaultReadTimeout(long j10) {
            this.defaultReadTimeout = j10;
            return this;
        }

        public final Builder setDefaultWriteTimeout(long j10) {
            this.defaultWriteTimeout = j10;
            return this;
        }

        public final Builder setLogger(ILogger iLogger) {
            this.logger = iLogger;
            return this;
        }

        public final Builder setMaxRequests(int i10) {
            this.maxRequests = i10;
            return this;
        }

        public final Builder setMaxRequestsPerHost(int i10) {
            this.maxRequestsPerHost = i10;
            return this;
        }

        public Builder() {
            this(null);
        }
    }
}
