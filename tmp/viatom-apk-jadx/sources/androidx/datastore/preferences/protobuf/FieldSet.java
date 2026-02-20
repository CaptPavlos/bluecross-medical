package androidx.datastore.preferences.protobuf;

import a2.a;
import androidx.datastore.preferences.protobuf.FieldSet.FieldDescriptorLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.LazyField;
import androidx.datastore.preferences.protobuf.MessageLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.window.layout.c;
import j$.util.DesugarCollections;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final class FieldSet<T extends FieldDescriptorLite<T>> {
    private static final FieldSet<?> DEFAULT_INSTANCE = new FieldSet<>(true);
    private final SmallSortedMap<T, Object> fields;
    private boolean hasLazyField;
    private boolean isImmutable;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.datastore.preferences.protobuf.FieldSet$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[WireFormat.JavaType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$JavaType = iArr2;
            try {
                iArr2[WireFormat.JavaType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
        Internal.EnumLiteMap<?> getEnumType();

        WireFormat.JavaType getLiteJavaType();

        WireFormat.FieldType getLiteType();

        int getNumber();

        MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite);

        boolean isPacked();

        boolean isRepeated();
    }

    private FieldSet(boolean z9) {
        this(SmallSortedMap.newFieldMap());
        makeImmutable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends FieldDescriptorLite<T>> SmallSortedMap<T, Object> cloneAllFieldsMap(SmallSortedMap<T, Object> smallSortedMap, boolean z9, boolean z10) {
        SmallSortedMap<T, Object> smallSortedMapNewFieldMap = SmallSortedMap.newFieldMap();
        int numArrayEntries = smallSortedMap.getNumArrayEntries();
        for (int i10 = 0; i10 < numArrayEntries; i10++) {
            cloneFieldEntry(smallSortedMapNewFieldMap, smallSortedMap.getArrayEntryAt(i10), z9, z10);
        }
        Iterator it = smallSortedMap.getOverflowEntries().iterator();
        while (it.hasNext()) {
            cloneFieldEntry(smallSortedMapNewFieldMap, (Map.Entry) it.next(), z9, z10);
        }
        return smallSortedMapNewFieldMap;
    }

    private static <T extends FieldDescriptorLite<T>> void cloneFieldEntry(Map<T, Object> map, Map.Entry<T, Object> entry, boolean z9, boolean z10) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (z10 && (value instanceof LazyField)) {
            map.put(key, ((LazyField) value).getValue());
        } else if (z9 && (value instanceof List)) {
            map.put(key, new ArrayList((List) value));
        } else {
            map.put(key, value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object cloneIfMutable(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static int computeElementSize(WireFormat.FieldType fieldType, int i10, Object obj) {
        int iComputeTagSize = CodedOutputStream.computeTagSize(i10);
        if (fieldType == WireFormat.FieldType.GROUP) {
            iComputeTagSize *= 2;
        }
        return iComputeTagSize + computeElementSizeNoTag(fieldType, obj);
    }

    public static int computeElementSizeNoTag(WireFormat.FieldType fieldType, Object obj) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                return CodedOutputStream.computeDoubleSizeNoTag(((Double) obj).doubleValue());
            case 2:
                return CodedOutputStream.computeFloatSizeNoTag(((Float) obj).floatValue());
            case 3:
                return CodedOutputStream.computeInt64SizeNoTag(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.computeUInt64SizeNoTag(((Long) obj).longValue());
            case 5:
                return CodedOutputStream.computeInt32SizeNoTag(((Integer) obj).intValue());
            case 6:
                return CodedOutputStream.computeFixed64SizeNoTag(((Long) obj).longValue());
            case 7:
                return CodedOutputStream.computeFixed32SizeNoTag(((Integer) obj).intValue());
            case 8:
                return CodedOutputStream.computeBoolSizeNoTag(((Boolean) obj).booleanValue());
            case 9:
                return CodedOutputStream.computeGroupSizeNoTag((MessageLite) obj);
            case 10:
                return obj instanceof LazyField ? CodedOutputStream.computeLazyFieldSizeNoTag((LazyField) obj) : CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj);
            case 11:
                return obj instanceof ByteString ? CodedOutputStream.computeBytesSizeNoTag((ByteString) obj) : CodedOutputStream.computeStringSizeNoTag((String) obj);
            case 12:
                return obj instanceof ByteString ? CodedOutputStream.computeBytesSizeNoTag((ByteString) obj) : CodedOutputStream.computeByteArraySizeNoTag((byte[]) obj);
            case 13:
                return CodedOutputStream.computeUInt32SizeNoTag(((Integer) obj).intValue());
            case 14:
                return CodedOutputStream.computeSFixed32SizeNoTag(((Integer) obj).intValue());
            case 15:
                return CodedOutputStream.computeSFixed64SizeNoTag(((Long) obj).longValue());
            case 16:
                return CodedOutputStream.computeSInt32SizeNoTag(((Integer) obj).intValue());
            case 17:
                return CodedOutputStream.computeSInt64SizeNoTag(((Long) obj).longValue());
            case 18:
                return obj instanceof Internal.EnumLite ? CodedOutputStream.computeEnumSizeNoTag(((Internal.EnumLite) obj).getNumber()) : CodedOutputStream.computeEnumSizeNoTag(((Integer) obj).intValue());
            default:
                a.j("There is no way to get here, but the compiler thinks otherwise.");
                return 0;
        }
    }

    public static int computeFieldSize(FieldDescriptorLite<?> fieldDescriptorLite, Object obj) {
        WireFormat.FieldType liteType = fieldDescriptorLite.getLiteType();
        int number = fieldDescriptorLite.getNumber();
        if (!fieldDescriptorLite.isRepeated()) {
            return computeElementSize(liteType, number, obj);
        }
        List list = (List) obj;
        int size = list.size();
        int i10 = 0;
        if (!fieldDescriptorLite.isPacked()) {
            int iComputeElementSize = 0;
            while (i10 < size) {
                iComputeElementSize += computeElementSize(liteType, number, list.get(i10));
                i10++;
            }
            return iComputeElementSize;
        }
        if (list.isEmpty()) {
            return 0;
        }
        int iComputeElementSizeNoTag = 0;
        while (i10 < size) {
            iComputeElementSizeNoTag += computeElementSizeNoTag(liteType, list.get(i10));
            i10++;
        }
        return CodedOutputStream.computeUInt32SizeNoTag(iComputeElementSizeNoTag) + CodedOutputStream.computeTagSize(number) + iComputeElementSizeNoTag;
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> emptySet() {
        return (FieldSet<T>) DEFAULT_INSTANCE;
    }

    private int getMessageSetSerializedSize(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        return (key.getLiteJavaType() != WireFormat.JavaType.MESSAGE || key.isRepeated() || key.isPacked()) ? computeFieldSize(key, value) : value instanceof LazyField ? CodedOutputStream.computeLazyFieldMessageSetExtensionSize(entry.getKey().getNumber(), (LazyField) value) : CodedOutputStream.computeMessageSetExtensionSize(entry.getKey().getNumber(), (MessageLite) value);
    }

    public static int getWireFormatForFieldType(WireFormat.FieldType fieldType, boolean z9) {
        if (z9) {
            return 2;
        }
        return fieldType.getWireType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends FieldDescriptorLite<T>> boolean isInitialized(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.getLiteJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        if (!key.isRepeated()) {
            return isMessageFieldValueInitialized(entry.getValue());
        }
        List list = (List) entry.getValue();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!isMessageFieldValueInitialized(list.get(i10))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isMessageFieldValueInitialized(Object obj) {
        if (obj instanceof MessageLiteOrBuilder) {
            return ((MessageLiteOrBuilder) obj).isInitialized();
        }
        if (obj instanceof LazyField) {
            return true;
        }
        com.google.gson.internal.a.n("Wrong object type used with protocol message reflection.");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isValidType(WireFormat.FieldType fieldType, Object obj) {
        Internal.checkNotNull(obj);
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[fieldType.getJavaType().ordinal()]) {
            case 7:
                if ((obj instanceof ByteString) || (obj instanceof byte[])) {
                }
                break;
            case 8:
                if ((obj instanceof Integer) || (obj instanceof Internal.EnumLite)) {
                }
                break;
            case 9:
                if ((obj instanceof MessageLite) || (obj instanceof LazyField)) {
                }
                break;
        }
        return false;
    }

    private void mergeFromField(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        boolean z9 = value instanceof LazyField;
        if (key.isRepeated()) {
            if (z9) {
                c.g("Lazy fields can not be repeated");
                return;
            }
            Object field = getField(key);
            if (field == null) {
                field = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) field).add(cloneIfMutable(it.next()));
            }
            this.fields.put((SmallSortedMap<T, Object>) key, (T) field);
            return;
        }
        if (key.getLiteJavaType() != WireFormat.JavaType.MESSAGE) {
            if (z9) {
                c.g("Lazy fields must be message-valued");
                return;
            } else {
                this.fields.put((SmallSortedMap<T, Object>) key, (T) cloneIfMutable(value));
                return;
            }
        }
        Object field2 = getField(key);
        if (field2 == null) {
            this.fields.put((SmallSortedMap<T, Object>) key, (T) cloneIfMutable(value));
            if (z9) {
                this.hasLazyField = true;
                return;
            }
            return;
        }
        if (z9) {
            value = ((LazyField) value).getValue();
        }
        this.fields.put((SmallSortedMap<T, Object>) key, (T) key.internalMergeFrom(((MessageLite) field2).toBuilder(), (MessageLite) value).build());
    }

    public static <T extends FieldDescriptorLite<T>> Builder<T> newBuilder() {
        return new Builder<>((AnonymousClass1) null);
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> newFieldSet() {
        return new FieldSet<>();
    }

    public static Object readPrimitiveField(CodedInputStream codedInputStream, WireFormat.FieldType fieldType, boolean z9) throws IOException {
        return z9 ? WireFormat.readPrimitiveField(codedInputStream, fieldType, WireFormat.Utf8Validation.STRICT) : WireFormat.readPrimitiveField(codedInputStream, fieldType, WireFormat.Utf8Validation.LOOSE);
    }

    private void verifyType(T t, Object obj) {
        if (isValidType(t.getLiteType(), obj)) {
            return;
        }
        androidx.core.view.accessibility.a.r("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(t.getNumber()), t.getLiteType().getJavaType(), obj.getClass().getName()});
    }

    public static void writeElement(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, int i10, Object obj) throws IOException {
        if (fieldType == WireFormat.FieldType.GROUP) {
            codedOutputStream.writeGroup(i10, (MessageLite) obj);
        } else {
            codedOutputStream.writeTag(i10, getWireFormatForFieldType(fieldType, false));
            writeElementNoTag(codedOutputStream, fieldType, obj);
        }
    }

    public static void writeElementNoTag(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, Object obj) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                codedOutputStream.writeDoubleNoTag(((Double) obj).doubleValue());
                break;
            case 2:
                codedOutputStream.writeFloatNoTag(((Float) obj).floatValue());
                break;
            case 3:
                codedOutputStream.writeInt64NoTag(((Long) obj).longValue());
                break;
            case 4:
                codedOutputStream.writeUInt64NoTag(((Long) obj).longValue());
                break;
            case 5:
                codedOutputStream.writeInt32NoTag(((Integer) obj).intValue());
                break;
            case 6:
                codedOutputStream.writeFixed64NoTag(((Long) obj).longValue());
                break;
            case 7:
                codedOutputStream.writeFixed32NoTag(((Integer) obj).intValue());
                break;
            case 8:
                codedOutputStream.writeBoolNoTag(((Boolean) obj).booleanValue());
                break;
            case 9:
                codedOutputStream.writeGroupNoTag((MessageLite) obj);
                break;
            case 10:
                codedOutputStream.writeMessageNoTag((MessageLite) obj);
                break;
            case 11:
                if (!(obj instanceof ByteString)) {
                    codedOutputStream.writeStringNoTag((String) obj);
                    break;
                } else {
                    codedOutputStream.writeBytesNoTag((ByteString) obj);
                    break;
                }
            case 12:
                if (!(obj instanceof ByteString)) {
                    codedOutputStream.writeByteArrayNoTag((byte[]) obj);
                    break;
                } else {
                    codedOutputStream.writeBytesNoTag((ByteString) obj);
                    break;
                }
            case 13:
                codedOutputStream.writeUInt32NoTag(((Integer) obj).intValue());
                break;
            case 14:
                codedOutputStream.writeSFixed32NoTag(((Integer) obj).intValue());
                break;
            case 15:
                codedOutputStream.writeSFixed64NoTag(((Long) obj).longValue());
                break;
            case 16:
                codedOutputStream.writeSInt32NoTag(((Integer) obj).intValue());
                break;
            case 17:
                codedOutputStream.writeSInt64NoTag(((Long) obj).longValue());
                break;
            case 18:
                if (!(obj instanceof Internal.EnumLite)) {
                    codedOutputStream.writeEnumNoTag(((Integer) obj).intValue());
                    break;
                } else {
                    codedOutputStream.writeEnumNoTag(((Internal.EnumLite) obj).getNumber());
                    break;
                }
        }
    }

    public static void writeField(FieldDescriptorLite<?> fieldDescriptorLite, Object obj, CodedOutputStream codedOutputStream) throws IOException {
        WireFormat.FieldType liteType = fieldDescriptorLite.getLiteType();
        int number = fieldDescriptorLite.getNumber();
        if (!fieldDescriptorLite.isRepeated()) {
            if (obj instanceof LazyField) {
                writeElement(codedOutputStream, liteType, number, ((LazyField) obj).getValue());
                return;
            } else {
                writeElement(codedOutputStream, liteType, number, obj);
                return;
            }
        }
        List list = (List) obj;
        int size = list.size();
        int i10 = 0;
        if (!fieldDescriptorLite.isPacked()) {
            while (i10 < size) {
                writeElement(codedOutputStream, liteType, number, list.get(i10));
                i10++;
            }
        } else {
            if (list.isEmpty()) {
                return;
            }
            codedOutputStream.writeTag(number, 2);
            int iComputeElementSizeNoTag = 0;
            for (int i11 = 0; i11 < size; i11++) {
                iComputeElementSizeNoTag += computeElementSizeNoTag(liteType, list.get(i11));
            }
            codedOutputStream.writeUInt32NoTag(iComputeElementSizeNoTag);
            while (i10 < size) {
                writeElementNoTag(codedOutputStream, liteType, list.get(i10));
                i10++;
            }
        }
    }

    private void writeMessageSetTo(Map.Entry<T, Object> entry, CodedOutputStream codedOutputStream) throws IOException {
        T key = entry.getKey();
        if (key.getLiteJavaType() != WireFormat.JavaType.MESSAGE || key.isRepeated() || key.isPacked()) {
            writeField(key, entry.getValue(), codedOutputStream);
            return;
        }
        Object value = entry.getValue();
        if (!(value instanceof LazyField)) {
            codedOutputStream.writeMessageSetExtension(entry.getKey().getNumber(), (MessageLite) value);
        } else {
            codedOutputStream.writeRawMessageSetExtension(entry.getKey().getNumber(), ((LazyField) value).toByteString());
        }
    }

    public void addRepeatedField(T t, Object obj) {
        List arrayList;
        if (!t.isRepeated()) {
            com.google.gson.internal.a.n("addRepeatedField() can only be called on repeated fields.");
            return;
        }
        verifyType(t, obj);
        Object field = getField(t);
        if (field == null) {
            arrayList = new ArrayList();
            this.fields.put((SmallSortedMap<T, Object>) t, (T) arrayList);
        } else {
            arrayList = (List) field;
        }
        arrayList.add(obj);
    }

    public void clear() {
        this.fields.clear();
        this.hasLazyField = false;
    }

    public void clearField(T t) {
        this.fields.remove(t);
        if (this.fields.isEmpty()) {
            this.hasLazyField = false;
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public FieldSet<T> m44clone() {
        SmallSortedMap<T, Object> smallSortedMap;
        FieldSet<T> fieldSetNewFieldSet = newFieldSet();
        int numArrayEntries = this.fields.getNumArrayEntries();
        int i10 = 0;
        while (true) {
            smallSortedMap = this.fields;
            if (i10 >= numArrayEntries) {
                break;
            }
            Map.Entry<K, Object> arrayEntryAt = smallSortedMap.getArrayEntryAt(i10);
            fieldSetNewFieldSet.setField((FieldDescriptorLite) arrayEntryAt.getKey(), arrayEntryAt.getValue());
            i10++;
        }
        Iterator it = smallSortedMap.getOverflowEntries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            fieldSetNewFieldSet.setField((FieldDescriptorLite) entry.getKey(), entry.getValue());
        }
        fieldSetNewFieldSet.hasLazyField = this.hasLazyField;
        return fieldSetNewFieldSet;
    }

    public Iterator<Map.Entry<T, Object>> descendingIterator() {
        if (isEmpty()) {
            return Collections.emptyIterator();
        }
        boolean z9 = this.hasLazyField;
        SmallSortedMap<T, Object> smallSortedMap = this.fields;
        return z9 ? new LazyField.LazyIterator(smallSortedMap.descendingEntrySet().iterator()) : smallSortedMap.descendingEntrySet().iterator();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FieldSet) {
            return this.fields.equals(((FieldSet) obj).fields);
        }
        return false;
    }

    public Map<T, Object> getAllFields() {
        boolean z9 = this.hasLazyField;
        SmallSortedMap<T, Object> smallSortedMap = this.fields;
        if (!z9) {
            boolean zIsImmutable = smallSortedMap.isImmutable();
            SmallSortedMap<T, Object> smallSortedMap2 = this.fields;
            return zIsImmutable ? smallSortedMap2 : DesugarCollections.unmodifiableMap(smallSortedMap2);
        }
        SmallSortedMap smallSortedMapCloneAllFieldsMap = cloneAllFieldsMap(smallSortedMap, false, true);
        if (this.fields.isImmutable()) {
            smallSortedMapCloneAllFieldsMap.makeImmutable();
        }
        return smallSortedMapCloneAllFieldsMap;
    }

    public Object getField(T t) {
        Object obj = this.fields.get(t);
        return obj instanceof LazyField ? ((LazyField) obj).getValue() : obj;
    }

    public Object getRepeatedField(T t, int i10) {
        if (!t.isRepeated()) {
            com.google.gson.internal.a.n("getRepeatedField() can only be called on repeated fields.");
            return null;
        }
        Object field = getField(t);
        if (field != null) {
            return ((List) field).get(i10);
        }
        throw new IndexOutOfBoundsException();
    }

    public int getRepeatedFieldCount(T t) {
        if (!t.isRepeated()) {
            com.google.gson.internal.a.n("getRepeatedField() can only be called on repeated fields.");
            return 0;
        }
        Object field = getField(t);
        if (field == null) {
            return 0;
        }
        return ((List) field).size();
    }

    public int getSerializedSize() {
        SmallSortedMap<T, Object> smallSortedMap;
        int numArrayEntries = this.fields.getNumArrayEntries();
        int i10 = 0;
        int iComputeFieldSize = 0;
        while (true) {
            smallSortedMap = this.fields;
            if (i10 >= numArrayEntries) {
                break;
            }
            Map.Entry<K, Object> arrayEntryAt = smallSortedMap.getArrayEntryAt(i10);
            iComputeFieldSize += computeFieldSize((FieldDescriptorLite) arrayEntryAt.getKey(), arrayEntryAt.getValue());
            i10++;
        }
        Iterator it = smallSortedMap.getOverflowEntries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            iComputeFieldSize += computeFieldSize((FieldDescriptorLite) entry.getKey(), entry.getValue());
        }
        return iComputeFieldSize;
    }

    public boolean hasField(T t) {
        if (!t.isRepeated()) {
            return this.fields.get(t) != null;
        }
        com.google.gson.internal.a.n("hasField() can only be called on non-repeated fields.");
        return false;
    }

    public int hashCode() {
        return this.fields.hashCode();
    }

    public boolean isEmpty() {
        return this.fields.isEmpty();
    }

    public boolean isImmutable() {
        return this.isImmutable;
    }

    public Iterator<Map.Entry<T, Object>> iterator() {
        if (isEmpty()) {
            return Collections.emptyIterator();
        }
        boolean z9 = this.hasLazyField;
        SmallSortedMap<T, Object> smallSortedMap = this.fields;
        return z9 ? new LazyField.LazyIterator(smallSortedMap.entrySet().iterator()) : smallSortedMap.entrySet().iterator();
    }

    public void makeImmutable() {
        if (this.isImmutable) {
            return;
        }
        int numArrayEntries = this.fields.getNumArrayEntries();
        int i10 = 0;
        while (true) {
            SmallSortedMap<T, Object> smallSortedMap = this.fields;
            if (i10 >= numArrayEntries) {
                smallSortedMap.makeImmutable();
                this.isImmutable = true;
                return;
            } else {
                Map.Entry<K, Object> arrayEntryAt = smallSortedMap.getArrayEntryAt(i10);
                if (arrayEntryAt.getValue() instanceof GeneratedMessageLite) {
                    ((GeneratedMessageLite) arrayEntryAt.getValue()).makeImmutable();
                }
                i10++;
            }
        }
    }

    public void mergeFrom(FieldSet<T> fieldSet) {
        SmallSortedMap<T, Object> smallSortedMap;
        int numArrayEntries = fieldSet.fields.getNumArrayEntries();
        int i10 = 0;
        while (true) {
            smallSortedMap = fieldSet.fields;
            if (i10 >= numArrayEntries) {
                break;
            }
            mergeFromField(smallSortedMap.getArrayEntryAt(i10));
            i10++;
        }
        Iterator it = smallSortedMap.getOverflowEntries().iterator();
        while (it.hasNext()) {
            mergeFromField((Map.Entry) it.next());
        }
    }

    public void setField(T t, Object obj) {
        if (!t.isRepeated()) {
            verifyType(t, obj);
        } else {
            if (!(obj instanceof List)) {
                com.google.gson.internal.a.n("Wrong object type used with protocol message reflection.");
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj2 = arrayList.get(i10);
                i10++;
                verifyType(t, obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof LazyField) {
            this.hasLazyField = true;
        }
        this.fields.put((SmallSortedMap<T, Object>) t, (T) obj);
    }

    public void setRepeatedField(T t, int i10, Object obj) {
        if (!t.isRepeated()) {
            com.google.gson.internal.a.n("getRepeatedField() can only be called on repeated fields.");
            return;
        }
        Object field = getField(t);
        if (field == null) {
            throw new IndexOutOfBoundsException();
        }
        verifyType(t, obj);
        ((List) field).set(i10, obj);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        SmallSortedMap<T, Object> smallSortedMap;
        int numArrayEntries = this.fields.getNumArrayEntries();
        int i10 = 0;
        while (true) {
            smallSortedMap = this.fields;
            if (i10 >= numArrayEntries) {
                break;
            }
            Map.Entry<K, Object> arrayEntryAt = smallSortedMap.getArrayEntryAt(i10);
            writeField((FieldDescriptorLite) arrayEntryAt.getKey(), arrayEntryAt.getValue(), codedOutputStream);
            i10++;
        }
        Iterator it = smallSortedMap.getOverflowEntries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            writeField((FieldDescriptorLite) entry.getKey(), entry.getValue(), codedOutputStream);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Builder<T extends FieldDescriptorLite<T>> {
        private SmallSortedMap<T, Object> fields;
        private boolean hasLazyField;
        private boolean hasNestedBuilders;
        private boolean isMutable;

        private Builder(SmallSortedMap<T, Object> smallSortedMap) {
            this.fields = smallSortedMap;
            this.isMutable = true;
        }

        private FieldSet<T> buildImpl(boolean z9) {
            if (this.fields.isEmpty()) {
                return FieldSet.emptySet();
            }
            this.isMutable = false;
            SmallSortedMap<T, Object> smallSortedMapCloneAllFieldsMap = this.fields;
            if (this.hasNestedBuilders) {
                smallSortedMapCloneAllFieldsMap = FieldSet.cloneAllFieldsMap(smallSortedMapCloneAllFieldsMap, false, false);
                replaceBuilders(smallSortedMapCloneAllFieldsMap, z9);
            }
            FieldSet<T> fieldSet = new FieldSet<>(smallSortedMapCloneAllFieldsMap, null);
            ((FieldSet) fieldSet).hasLazyField = this.hasLazyField;
            return fieldSet;
        }

        private void ensureIsMutable() {
            if (this.isMutable) {
                return;
            }
            this.fields = FieldSet.cloneAllFieldsMap(this.fields, true, false);
            this.isMutable = true;
        }

        public static <T extends FieldDescriptorLite<T>> Builder<T> fromFieldSet(FieldSet<T> fieldSet) {
            Builder<T> builder = new Builder<>(FieldSet.cloneAllFieldsMap(((FieldSet) fieldSet).fields, true, false));
            ((Builder) builder).hasLazyField = ((FieldSet) fieldSet).hasLazyField;
            return builder;
        }

        private void mergeFromField(Map.Entry<T, Object> entry) {
            T key = entry.getKey();
            Object value = entry.getValue();
            boolean z9 = value instanceof LazyField;
            if (key.isRepeated()) {
                if (z9) {
                    c.g("Lazy fields can not be repeated");
                    return;
                }
                List arrayList = (List) getFieldAllowBuilders(key);
                List list = (List) value;
                int size = list.size();
                if (arrayList == null) {
                    arrayList = new ArrayList(size);
                    this.fields.put((SmallSortedMap<T, Object>) key, (T) arrayList);
                }
                for (int i10 = 0; i10 < size; i10++) {
                    arrayList.add(FieldSet.cloneIfMutable(list.get(i10)));
                }
                return;
            }
            if (key.getLiteJavaType() != WireFormat.JavaType.MESSAGE) {
                if (z9) {
                    c.g("Lazy fields must be message-valued");
                    return;
                } else {
                    this.fields.put((SmallSortedMap<T, Object>) key, (T) FieldSet.cloneIfMutable(value));
                    return;
                }
            }
            Object fieldAllowBuilders = getFieldAllowBuilders(key);
            if (fieldAllowBuilders == null) {
                this.fields.put((SmallSortedMap<T, Object>) key, (T) FieldSet.cloneIfMutable(value));
                if (z9) {
                    this.hasLazyField = true;
                    return;
                }
                return;
            }
            if (z9) {
                value = ((LazyField) value).getValue();
            }
            if (fieldAllowBuilders instanceof MessageLite.Builder) {
                key.internalMergeFrom((MessageLite.Builder) fieldAllowBuilders, (MessageLite) value);
            } else {
                this.fields.put((SmallSortedMap<T, Object>) key, (T) key.internalMergeFrom(((MessageLite) fieldAllowBuilders).toBuilder(), (MessageLite) value).build());
            }
        }

        private static Object replaceBuilder(Object obj, boolean z9) {
            if (!(obj instanceof MessageLite.Builder)) {
                return obj;
            }
            MessageLite.Builder builder = (MessageLite.Builder) obj;
            return z9 ? builder.buildPartial() : builder.build();
        }

        private static <T extends FieldDescriptorLite<T>> Object replaceBuilders(T t, Object obj, boolean z9) {
            if (obj == null || t.getLiteJavaType() != WireFormat.JavaType.MESSAGE) {
                return obj;
            }
            if (!t.isRepeated()) {
                return replaceBuilder(obj, z9);
            }
            if (!(obj instanceof List)) {
                com.google.gson.internal.a.l(obj.getClass(), "Repeated field should contains a List but actually contains type: ");
                return null;
            }
            List arrayList = (List) obj;
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                Object obj2 = arrayList.get(i10);
                Object objReplaceBuilder = replaceBuilder(obj2, z9);
                if (objReplaceBuilder != obj2) {
                    if (arrayList == obj) {
                        arrayList = new ArrayList(arrayList);
                    }
                    arrayList.set(i10, objReplaceBuilder);
                }
            }
            return arrayList;
        }

        private void verifyType(T t, Object obj) {
            if (FieldSet.isValidType(t.getLiteType(), obj)) {
                return;
            }
            if (t.getLiteType().getJavaType() == WireFormat.JavaType.MESSAGE && (obj instanceof MessageLite.Builder)) {
                return;
            }
            androidx.core.view.accessibility.a.r("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(t.getNumber()), t.getLiteType().getJavaType(), obj.getClass().getName()});
        }

        public void addRepeatedField(T t, Object obj) {
            List arrayList;
            ensureIsMutable();
            if (!t.isRepeated()) {
                com.google.gson.internal.a.n("addRepeatedField() can only be called on repeated fields.");
                return;
            }
            this.hasNestedBuilders = this.hasNestedBuilders || (obj instanceof MessageLite.Builder);
            verifyType(t, obj);
            Object fieldAllowBuilders = getFieldAllowBuilders(t);
            if (fieldAllowBuilders == null) {
                arrayList = new ArrayList();
                this.fields.put((SmallSortedMap<T, Object>) t, (T) arrayList);
            } else {
                arrayList = (List) fieldAllowBuilders;
            }
            arrayList.add(obj);
        }

        public FieldSet<T> build() {
            return buildImpl(false);
        }

        public FieldSet<T> buildPartial() {
            return buildImpl(true);
        }

        public void clearField(T t) {
            ensureIsMutable();
            this.fields.remove(t);
            if (this.fields.isEmpty()) {
                this.hasLazyField = false;
            }
        }

        public Map<T, Object> getAllFields() {
            boolean z9 = this.hasLazyField;
            SmallSortedMap<T, Object> smallSortedMap = this.fields;
            if (!z9) {
                boolean zIsImmutable = smallSortedMap.isImmutable();
                SmallSortedMap<T, Object> smallSortedMap2 = this.fields;
                return zIsImmutable ? smallSortedMap2 : DesugarCollections.unmodifiableMap(smallSortedMap2);
            }
            SmallSortedMap smallSortedMapCloneAllFieldsMap = FieldSet.cloneAllFieldsMap(smallSortedMap, false, true);
            if (this.fields.isImmutable()) {
                smallSortedMapCloneAllFieldsMap.makeImmutable();
                return smallSortedMapCloneAllFieldsMap;
            }
            replaceBuilders(smallSortedMapCloneAllFieldsMap, true);
            return smallSortedMapCloneAllFieldsMap;
        }

        public Object getField(T t) {
            return replaceBuilders(t, getFieldAllowBuilders(t), true);
        }

        public Object getFieldAllowBuilders(T t) {
            Object obj = this.fields.get(t);
            return obj instanceof LazyField ? ((LazyField) obj).getValue() : obj;
        }

        public Object getRepeatedField(T t, int i10) {
            if (this.hasNestedBuilders) {
                ensureIsMutable();
            }
            return replaceBuilder(getRepeatedFieldAllowBuilders(t, i10), true);
        }

        public Object getRepeatedFieldAllowBuilders(T t, int i10) {
            if (!t.isRepeated()) {
                com.google.gson.internal.a.n("getRepeatedField() can only be called on repeated fields.");
                return null;
            }
            Object fieldAllowBuilders = getFieldAllowBuilders(t);
            if (fieldAllowBuilders != null) {
                return ((List) fieldAllowBuilders).get(i10);
            }
            throw new IndexOutOfBoundsException();
        }

        public int getRepeatedFieldCount(T t) {
            if (!t.isRepeated()) {
                com.google.gson.internal.a.n("getRepeatedFieldCount() can only be called on repeated fields.");
                return 0;
            }
            Object fieldAllowBuilders = getFieldAllowBuilders(t);
            if (fieldAllowBuilders == null) {
                return 0;
            }
            return ((List) fieldAllowBuilders).size();
        }

        public boolean hasField(T t) {
            if (!t.isRepeated()) {
                return this.fields.get(t) != null;
            }
            com.google.gson.internal.a.n("hasField() can only be called on non-repeated fields.");
            return false;
        }

        public boolean isInitialized() {
            int numArrayEntries = this.fields.getNumArrayEntries();
            int i10 = 0;
            while (true) {
                SmallSortedMap<T, Object> smallSortedMap = this.fields;
                if (i10 >= numArrayEntries) {
                    Iterator it = smallSortedMap.getOverflowEntries().iterator();
                    while (it.hasNext()) {
                        if (!FieldSet.isInitialized((Map.Entry) it.next())) {
                            return false;
                        }
                    }
                    return true;
                }
                if (!FieldSet.isInitialized(smallSortedMap.getArrayEntryAt(i10))) {
                    return false;
                }
                i10++;
            }
        }

        public void mergeFrom(FieldSet<T> fieldSet) {
            ensureIsMutable();
            int numArrayEntries = ((FieldSet) fieldSet).fields.getNumArrayEntries();
            for (int i10 = 0; i10 < numArrayEntries; i10++) {
                mergeFromField(((FieldSet) fieldSet).fields.getArrayEntryAt(i10));
            }
            Iterator it = ((FieldSet) fieldSet).fields.getOverflowEntries().iterator();
            while (it.hasNext()) {
                mergeFromField((Map.Entry) it.next());
            }
        }

        public void setField(T t, Object obj) {
            ensureIsMutable();
            if (!t.isRepeated()) {
                verifyType(t, obj);
            } else {
                if (!(obj instanceof List)) {
                    com.google.gson.internal.a.n("Wrong object type used with protocol message reflection.");
                    return;
                }
                ArrayList arrayList = new ArrayList((List) obj);
                int size = arrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    Object obj2 = arrayList.get(i10);
                    verifyType(t, obj2);
                    this.hasNestedBuilders = this.hasNestedBuilders || (obj2 instanceof MessageLite.Builder);
                }
                obj = arrayList;
            }
            if (obj instanceof LazyField) {
                this.hasLazyField = true;
            }
            this.hasNestedBuilders = this.hasNestedBuilders || (obj instanceof MessageLite.Builder);
            this.fields.put((SmallSortedMap<T, Object>) t, (T) obj);
        }

        public void setRepeatedField(T t, int i10, Object obj) {
            ensureIsMutable();
            if (!t.isRepeated()) {
                com.google.gson.internal.a.n("getRepeatedField() can only be called on repeated fields.");
                return;
            }
            this.hasNestedBuilders = this.hasNestedBuilders || (obj instanceof MessageLite.Builder);
            Object fieldAllowBuilders = getFieldAllowBuilders(t);
            if (fieldAllowBuilders == null) {
                throw new IndexOutOfBoundsException();
            }
            verifyType(t, obj);
            ((List) fieldAllowBuilders).set(i10, obj);
        }

        private Builder() {
            this(SmallSortedMap.newFieldMap());
        }

        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private static <T extends FieldDescriptorLite<T>> void replaceBuilders(Map.Entry<T, Object> entry, boolean z9) {
            entry.setValue(replaceBuilders(entry.getKey(), entry.getValue(), z9));
        }

        private static <T extends FieldDescriptorLite<T>> void replaceBuilders(SmallSortedMap<T, Object> smallSortedMap, boolean z9) {
            int numArrayEntries = smallSortedMap.getNumArrayEntries();
            for (int i10 = 0; i10 < numArrayEntries; i10++) {
                replaceBuilders(smallSortedMap.getArrayEntryAt(i10), z9);
            }
            Iterator it = smallSortedMap.getOverflowEntries().iterator();
            while (it.hasNext()) {
                replaceBuilders((Map.Entry) it.next(), z9);
            }
        }
    }

    private FieldSet() {
        this.fields = SmallSortedMap.newFieldMap();
    }

    public /* synthetic */ FieldSet(SmallSortedMap smallSortedMap, AnonymousClass1 anonymousClass1) {
        this(smallSortedMap);
    }

    private FieldSet(SmallSortedMap<T, Object> smallSortedMap) {
        this.fields = smallSortedMap;
        makeImmutable();
    }

    public boolean isInitialized() {
        int numArrayEntries = this.fields.getNumArrayEntries();
        int i10 = 0;
        while (true) {
            SmallSortedMap<T, Object> smallSortedMap = this.fields;
            if (i10 < numArrayEntries) {
                if (!isInitialized(smallSortedMap.getArrayEntryAt(i10))) {
                    return false;
                }
                i10++;
            } else {
                Iterator it = smallSortedMap.getOverflowEntries().iterator();
                while (it.hasNext()) {
                    if (!isInitialized((Map.Entry) it.next())) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    public int getMessageSetSerializedSize() {
        SmallSortedMap<T, Object> smallSortedMap;
        int numArrayEntries = this.fields.getNumArrayEntries();
        int i10 = 0;
        int messageSetSerializedSize = 0;
        while (true) {
            smallSortedMap = this.fields;
            if (i10 >= numArrayEntries) {
                break;
            }
            messageSetSerializedSize += getMessageSetSerializedSize(smallSortedMap.getArrayEntryAt(i10));
            i10++;
        }
        Iterator it = smallSortedMap.getOverflowEntries().iterator();
        while (it.hasNext()) {
            messageSetSerializedSize += getMessageSetSerializedSize((Map.Entry) it.next());
        }
        return messageSetSerializedSize;
    }

    public void writeMessageSetTo(CodedOutputStream codedOutputStream) throws IOException {
        SmallSortedMap<T, Object> smallSortedMap;
        int numArrayEntries = this.fields.getNumArrayEntries();
        int i10 = 0;
        while (true) {
            smallSortedMap = this.fields;
            if (i10 >= numArrayEntries) {
                break;
            }
            writeMessageSetTo(smallSortedMap.getArrayEntryAt(i10), codedOutputStream);
            i10++;
        }
        Iterator it = smallSortedMap.getOverflowEntries().iterator();
        while (it.hasNext()) {
            writeMessageSetTo((Map.Entry) it.next(), codedOutputStream);
        }
    }
}
