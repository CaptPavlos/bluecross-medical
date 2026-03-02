package androidx.datastore.core;

import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SharedCounter {
    public static final Factory Factory = new Factory(null);
    private static final NativeSharedCounter nativeSharedCounter = new NativeSharedCounter();
    private final long mappedAddress;

    private SharedCounter(long j10) {
        this.mappedAddress = j10;
    }

    public final int getValue() {
        return nativeSharedCounter.nativeGetCounterValue(this.mappedAddress);
    }

    public final int incrementAndGetValue() {
        return nativeSharedCounter.nativeIncrementAndGetCounterValue(this.mappedAddress);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Factory {
        public /* synthetic */ Factory(g gVar) {
            this();
        }

        private final SharedCounter createCounterFromFd(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
            int fd = parcelFileDescriptor.getFd();
            if (getNativeSharedCounter$datastore_core_release().nativeTruncateFile(fd) != 0) {
                com.google.gson.internal.a.m("Failed to truncate counter file");
                return null;
            }
            long jNativeCreateSharedCounter = getNativeSharedCounter$datastore_core_release().nativeCreateSharedCounter(fd);
            if (jNativeCreateSharedCounter >= 0) {
                return new SharedCounter(jNativeCreateSharedCounter, null);
            }
            com.google.gson.internal.a.m("Failed to mmap counter file");
            return null;
        }

        public final SharedCounter create$datastore_core_release(g7.a aVar) throws Throwable {
            ParcelFileDescriptor parcelFileDescriptorOpen;
            aVar.getClass();
            try {
                parcelFileDescriptorOpen = ParcelFileDescriptor.open((File) aVar.invoke(), 939524096);
                try {
                    SharedCounter sharedCounterCreateCounterFromFd = createCounterFromFd(parcelFileDescriptorOpen);
                    if (parcelFileDescriptorOpen != null) {
                        parcelFileDescriptorOpen.close();
                    }
                    return sharedCounterCreateCounterFromFd;
                } catch (Throwable th) {
                    th = th;
                    if (parcelFileDescriptorOpen != null) {
                        parcelFileDescriptorOpen.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                parcelFileDescriptorOpen = null;
            }
        }

        public final NativeSharedCounter getNativeSharedCounter$datastore_core_release() {
            return SharedCounter.nativeSharedCounter;
        }

        public final void loadLib() {
            System.loadLibrary("datastore_shared_counter");
        }

        private Factory() {
        }
    }

    public /* synthetic */ SharedCounter(long j10, g gVar) {
        this(j10);
    }
}
