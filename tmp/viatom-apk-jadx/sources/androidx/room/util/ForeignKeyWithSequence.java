package androidx.room.util;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final class ForeignKeyWithSequence implements Comparable<ForeignKeyWithSequence> {
    private final String from;
    private final int id;
    private final int sequence;
    private final String to;

    public ForeignKeyWithSequence(int i10, int i11, String str, String str2) {
        str.getClass();
        str2.getClass();
        this.id = i10;
        this.sequence = i11;
        this.from = str;
        this.to = str2;
    }

    @Override // java.lang.Comparable
    public int compareTo(ForeignKeyWithSequence foreignKeyWithSequence) {
        foreignKeyWithSequence.getClass();
        int i10 = this.id - foreignKeyWithSequence.id;
        return i10 == 0 ? this.sequence - foreignKeyWithSequence.sequence : i10;
    }

    public final String getFrom() {
        return this.from;
    }

    public final int getId() {
        return this.id;
    }

    public final int getSequence() {
        return this.sequence;
    }

    public final String getTo() {
        return this.to;
    }
}
