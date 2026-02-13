package com.mbridge.msdk.foundation.download.core;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class ExecutorManager {
    private static ExecutorManager instance;
    private final ExecutorSupplier executorSupplier;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class ClassHolder {
        private static final ExecutorManager EXECUTOR_MANAGER = new ExecutorManager();

        private ClassHolder() {
        }
    }

    private ExecutorManager() {
        this.executorSupplier = new DefaultExecutorSupplier();
    }

    public static ExecutorManager getInstance() {
        return ClassHolder.EXECUTOR_MANAGER;
    }

    public static void shutDown() {
        if (instance != null) {
            instance = null;
        }
    }

    public ExecutorSupplier getExecutorSupplier() {
        return this.executorSupplier;
    }
}
