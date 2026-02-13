package androidx.datastore.preferences.protobuf;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@CheckReturnValue
/* loaded from: classes.dex */
final class OneofInfo {
    private final java.lang.reflect.Field caseField;
    private final int id;
    private final java.lang.reflect.Field valueField;

    public OneofInfo(int i10, java.lang.reflect.Field field, java.lang.reflect.Field field2) {
        this.id = i10;
        this.caseField = field;
        this.valueField = field2;
    }

    public java.lang.reflect.Field getCaseField() {
        return this.caseField;
    }

    public int getId() {
        return this.id;
    }

    public java.lang.reflect.Field getValueField() {
        return this.valueField;
    }
}
