package androidx.datastore.preferences.protobuf;

import a3.a;
import java.util.logging.Logger;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class RuntimeVersion {
    public static final RuntimeDomain DOMAIN;
    public static final int MAJOR = 4;
    public static final int MINOR = 28;
    public static final RuntimeDomain OSS_DOMAIN;
    public static final int OSS_MAJOR = 4;
    public static final int OSS_MINOR = 28;
    public static final int OSS_PATCH = 2;
    public static final String OSS_SUFFIX = "";
    public static final int PATCH = 2;
    public static final String SUFFIX = "";
    private static final String VERSION_STRING;
    private static final Logger logger;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class ProtobufRuntimeVersionException extends RuntimeException {
        public ProtobufRuntimeVersionException(String str) {
            super(str);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public enum RuntimeDomain {
        GOOGLE_INTERNAL,
        PUBLIC
    }

    static {
        RuntimeDomain runtimeDomain = RuntimeDomain.PUBLIC;
        OSS_DOMAIN = runtimeDomain;
        DOMAIN = runtimeDomain;
        VERSION_STRING = versionString(4, 28, 2, "");
        logger = Logger.getLogger(RuntimeVersion.class.getName());
    }

    private RuntimeVersion() {
    }

    private static boolean checkDisabled() {
        String str = System.getenv("TEMORARILY_DISABLE_PROTOBUF_VERSION_CHECK");
        return str != null && str.equals("true");
    }

    public static void validateProtobufGencodeVersion(RuntimeDomain runtimeDomain, int i10, int i11, int i12, String str, String str2) {
        if (checkDisabled()) {
            return;
        }
        validateProtobufGencodeVersionImpl(runtimeDomain, i10, i11, i12, str, str2);
    }

    private static void validateProtobufGencodeVersionImpl(RuntimeDomain runtimeDomain, int i10, int i11, int i12, String str, String str2) {
        if (checkDisabled()) {
            return;
        }
        String strVersionString = versionString(i10, i11, i12, str);
        if (i10 < 0 || i11 < 0 || i12 < 0) {
            throw new ProtobufRuntimeVersionException(a.i("Invalid gencode version: ", strVersionString));
        }
        RuntimeDomain runtimeDomain2 = DOMAIN;
        if (runtimeDomain != runtimeDomain2) {
            throw new ProtobufRuntimeVersionException("Detected mismatched Protobuf Gencode/Runtime domains when loading " + str2 + ": gencode " + runtimeDomain + ", runtime " + runtimeDomain2 + ". Cross-domain usage of Protobuf is not supported.");
        }
        if (i10 != 4) {
            if (i10 != 3) {
                String str3 = VERSION_STRING;
                StringBuilder sb = new StringBuilder("Detected mismatched Protobuf Gencode/Runtime major versions when loading ");
                sb.append(str2);
                sb.append(": gencode ");
                sb.append(strVersionString);
                sb.append(", runtime ");
                throw new ProtobufRuntimeVersionException(a.o(sb, str3, ". Same major version is required."));
            }
            logger.warning(" Protobuf gencode version " + strVersionString + " is exactly one major version older than the runtime version " + VERSION_STRING + " at " + str2 + ". Please update the gencode to avoid compatibility violations in the next runtime release.");
        }
        if (28 < i11 || (i11 == 28 && 2 < i12)) {
            String str4 = VERSION_STRING;
            StringBuilder sb2 = new StringBuilder("Detected incompatible Protobuf Gencode/Runtime versions when loading ");
            sb2.append(str2);
            sb2.append(": gencode ");
            sb2.append(strVersionString);
            sb2.append(", runtime ");
            throw new ProtobufRuntimeVersionException(a.o(sb2, str4, ". Runtime version cannot be older than the linked gencode version."));
        }
        if (28 > i11 || 2 > i12) {
            logger.warning(" Protobuf gencode version " + strVersionString + " is older than the runtime version " + VERSION_STRING + " at " + str2 + ". Please avoid checked-in Protobuf gencode that can be obsolete.");
        }
        if (str.equals("")) {
            return;
        }
        String str5 = VERSION_STRING;
        StringBuilder sb3 = new StringBuilder("Detected mismatched Protobuf Gencode/Runtime version suffixes when loading ");
        sb3.append(str2);
        sb3.append(": gencode ");
        sb3.append(strVersionString);
        sb3.append(", runtime ");
        throw new ProtobufRuntimeVersionException(a.o(sb3, str5, ". Version suffixes must be the same."));
    }

    private static String versionString(int i10, int i11, int i12, String str) {
        return String.format("%d.%d.%d%s", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), str);
    }
}
