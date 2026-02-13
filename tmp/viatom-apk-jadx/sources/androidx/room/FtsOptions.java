package androidx.room;

import androidx.annotation.RequiresApi;
import com.google.android.gms.internal.measurement.a4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class FtsOptions {
    public static final FtsOptions INSTANCE = new FtsOptions();
    public static final String TOKENIZER_ICU = "icu";
    public static final String TOKENIZER_PORTER = "porter";
    public static final String TOKENIZER_SIMPLE = "simple";

    @RequiresApi(21)
    public static final String TOKENIZER_UNICODE61 = "unicode61";

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class MatchInfo {
        private static final /* synthetic */ z6.a $ENTRIES;
        private static final /* synthetic */ MatchInfo[] $VALUES;
        public static final MatchInfo FTS3 = new MatchInfo("FTS3", 0);
        public static final MatchInfo FTS4 = new MatchInfo("FTS4", 1);

        private static final /* synthetic */ MatchInfo[] $values() {
            return new MatchInfo[]{FTS3, FTS4};
        }

        static {
            MatchInfo[] matchInfoArr$values = $values();
            $VALUES = matchInfoArr$values;
            $ENTRIES = a4.m(matchInfoArr$values);
        }

        private MatchInfo(String str, int i10) {
        }

        public static z6.a getEntries() {
            return $ENTRIES;
        }

        public static MatchInfo valueOf(String str) {
            return (MatchInfo) Enum.valueOf(MatchInfo.class, str);
        }

        public static MatchInfo[] values() {
            return (MatchInfo[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Order {
        private static final /* synthetic */ z6.a $ENTRIES;
        private static final /* synthetic */ Order[] $VALUES;
        public static final Order ASC = new Order("ASC", 0);
        public static final Order DESC = new Order("DESC", 1);

        private static final /* synthetic */ Order[] $values() {
            return new Order[]{ASC, DESC};
        }

        static {
            Order[] orderArr$values = $values();
            $VALUES = orderArr$values;
            $ENTRIES = a4.m(orderArr$values);
        }

        private Order(String str, int i10) {
        }

        public static z6.a getEntries() {
            return $ENTRIES;
        }

        public static Order valueOf(String str) {
            return (Order) Enum.valueOf(Order.class, str);
        }

        public static Order[] values() {
            return (Order[]) $VALUES.clone();
        }
    }

    private FtsOptions() {
    }
}
