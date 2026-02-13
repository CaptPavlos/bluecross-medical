package androidx.versionedparcelable;

import a2.a;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.versionedparcelable.VersionedParcel;
import androidx.window.layout.c;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Set;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
class VersionedParcelStream extends VersionedParcel {
    private static final int TYPE_BOOLEAN = 5;
    private static final int TYPE_BOOLEAN_ARRAY = 6;
    private static final int TYPE_DOUBLE = 7;
    private static final int TYPE_DOUBLE_ARRAY = 8;
    private static final int TYPE_FLOAT = 13;
    private static final int TYPE_FLOAT_ARRAY = 14;
    private static final int TYPE_INT = 9;
    private static final int TYPE_INT_ARRAY = 10;
    private static final int TYPE_LONG = 11;
    private static final int TYPE_LONG_ARRAY = 12;
    private static final int TYPE_NULL = 0;
    private static final int TYPE_STRING = 3;
    private static final int TYPE_STRING_ARRAY = 4;
    private static final int TYPE_SUB_BUNDLE = 1;
    private static final int TYPE_SUB_PERSISTABLE_BUNDLE = 2;
    private static final Charset UTF_16 = Charset.forName(C.UTF16_NAME);
    int mCount;
    private DataInputStream mCurrentInput;
    private DataOutputStream mCurrentOutput;
    private FieldBuffer mFieldBuffer;
    private int mFieldId;
    int mFieldSize;
    private boolean mIgnoreParcelables;
    private final DataInputStream mMasterInput;
    private final DataOutputStream mMasterOutput;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class FieldBuffer {
        final DataOutputStream mDataStream;
        private final int mFieldId;
        final ByteArrayOutputStream mOutput;
        private final DataOutputStream mTarget;

        public FieldBuffer(int i10, DataOutputStream dataOutputStream) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.mOutput = byteArrayOutputStream;
            this.mDataStream = new DataOutputStream(byteArrayOutputStream);
            this.mFieldId = i10;
            this.mTarget = dataOutputStream;
        }

        public void flushField() throws IOException {
            this.mDataStream.flush();
            int size = this.mOutput.size();
            this.mTarget.writeInt((this.mFieldId << 16) | (size >= 65535 ? 65535 : size));
            if (size >= 65535) {
                this.mTarget.writeInt(size);
            }
            this.mOutput.writeTo(this.mTarget);
        }
    }

    private VersionedParcelStream(InputStream inputStream, OutputStream outputStream, ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        this.mCount = 0;
        this.mFieldId = -1;
        this.mFieldSize = -1;
        DataInputStream dataInputStream = inputStream != null ? new DataInputStream(new FilterInputStream(inputStream) { // from class: androidx.versionedparcelable.VersionedParcelStream.1
            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i10, int i11) throws IOException {
                VersionedParcelStream versionedParcelStream = VersionedParcelStream.this;
                int i12 = versionedParcelStream.mFieldSize;
                if (i12 != -1 && versionedParcelStream.mCount >= i12) {
                    throw new IOException();
                }
                int i13 = super.read(bArr, i10, i11);
                if (i13 > 0) {
                    VersionedParcelStream.this.mCount += i13;
                }
                return i13;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j10) throws IOException {
                VersionedParcelStream versionedParcelStream = VersionedParcelStream.this;
                int i10 = versionedParcelStream.mFieldSize;
                if (i10 != -1 && versionedParcelStream.mCount >= i10) {
                    throw new IOException();
                }
                long jSkip = super.skip(j10);
                if (jSkip > 0) {
                    VersionedParcelStream.this.mCount += (int) jSkip;
                }
                return jSkip;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                VersionedParcelStream versionedParcelStream = VersionedParcelStream.this;
                int i10 = versionedParcelStream.mFieldSize;
                if (i10 != -1 && versionedParcelStream.mCount >= i10) {
                    throw new IOException();
                }
                int i11 = super.read();
                VersionedParcelStream.this.mCount++;
                return i11;
            }
        }) : null;
        this.mMasterInput = dataInputStream;
        DataOutputStream dataOutputStream = outputStream != null ? new DataOutputStream(outputStream) : null;
        this.mMasterOutput = dataOutputStream;
        this.mCurrentInput = dataInputStream;
        this.mCurrentOutput = dataOutputStream;
    }

    private void readObject(int i10, String str, Bundle bundle) {
        switch (i10) {
            case 0:
                bundle.putParcelable(str, null);
                break;
            case 1:
                bundle.putBundle(str, readBundle());
                break;
            case 2:
                bundle.putBundle(str, readBundle());
                break;
            case 3:
                bundle.putString(str, readString());
                break;
            case 4:
                bundle.putStringArray(str, (String[]) readArray(new String[0]));
                break;
            case 5:
                bundle.putBoolean(str, readBoolean());
                break;
            case 6:
                bundle.putBooleanArray(str, readBooleanArray());
                break;
            case 7:
                bundle.putDouble(str, readDouble());
                break;
            case 8:
                bundle.putDoubleArray(str, readDoubleArray());
                break;
            case 9:
                bundle.putInt(str, readInt());
                break;
            case 10:
                bundle.putIntArray(str, readIntArray());
                break;
            case 11:
                bundle.putLong(str, readLong());
                break;
            case 12:
                bundle.putLongArray(str, readLongArray());
                break;
            case 13:
                bundle.putFloat(str, readFloat());
                break;
            case 14:
                bundle.putFloatArray(str, readFloatArray());
                break;
            default:
                a.j(a3.a.f(i10, "Unknown type "));
                break;
        }
    }

    private void writeObject(Object obj) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        if (obj == null) {
            writeInt(0);
            return;
        }
        if (obj instanceof Bundle) {
            writeInt(1);
            writeBundle((Bundle) obj);
            return;
        }
        if (obj instanceof String) {
            writeInt(3);
            writeString((String) obj);
            return;
        }
        if (obj instanceof String[]) {
            writeInt(4);
            writeArray((String[]) obj);
            return;
        }
        if (obj instanceof Boolean) {
            writeInt(5);
            writeBoolean(((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof boolean[]) {
            writeInt(6);
            writeBooleanArray((boolean[]) obj);
            return;
        }
        if (obj instanceof Double) {
            writeInt(7);
            writeDouble(((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof double[]) {
            writeInt(8);
            writeDoubleArray((double[]) obj);
            return;
        }
        if (obj instanceof Integer) {
            writeInt(9);
            writeInt(((Integer) obj).intValue());
            return;
        }
        if (obj instanceof int[]) {
            writeInt(10);
            writeIntArray((int[]) obj);
            return;
        }
        if (obj instanceof Long) {
            writeInt(11);
            writeLong(((Long) obj).longValue());
            return;
        }
        if (obj instanceof long[]) {
            writeInt(12);
            writeLongArray((long[]) obj);
        } else if (obj instanceof Float) {
            writeInt(13);
            writeFloat(((Float) obj).floatValue());
        } else if (!(obj instanceof float[])) {
            c.f(obj.getClass(), "Unsupported type ");
        } else {
            writeInt(14);
            writeFloatArray((float[]) obj);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void closeField() {
        FieldBuffer fieldBuffer = this.mFieldBuffer;
        if (fieldBuffer != null) {
            try {
                if (fieldBuffer.mOutput.size() != 0) {
                    this.mFieldBuffer.flushField();
                }
                this.mFieldBuffer = null;
            } catch (IOException e) {
                throw new VersionedParcel.ParcelException(e);
            }
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public VersionedParcel createSubParcel() {
        return new VersionedParcelStream(this.mCurrentInput, this.mCurrentOutput, this.mReadCache, this.mWriteCache, this.mParcelizerCache);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean isStream() {
        return true;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readBoolean() {
        try {
            return this.mCurrentInput.readBoolean();
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public Bundle readBundle() throws IOException {
        int i10 = readInt();
        if (i10 < 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (int i11 = 0; i11 < i10; i11++) {
            readObject(readInt(), readString(), bundle);
        }
        return bundle;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] readByteArray() throws IOException {
        try {
            int i10 = this.mCurrentInput.readInt();
            if (i10 <= 0) {
                return null;
            }
            byte[] bArr = new byte[i10];
            this.mCurrentInput.readFully(bArr);
            return bArr;
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public CharSequence readCharSequence() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public double readDouble() {
        try {
            return this.mCurrentInput.readDouble();
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readField(int i10) throws IOException {
        while (true) {
            try {
                int i11 = this.mFieldId;
                if (i11 == i10) {
                    return true;
                }
                if (String.valueOf(i11).compareTo(String.valueOf(i10)) > 0) {
                    return false;
                }
                if (this.mCount < this.mFieldSize) {
                    this.mMasterInput.skip(r2 - r1);
                }
                this.mFieldSize = -1;
                int i12 = this.mMasterInput.readInt();
                this.mCount = 0;
                int i13 = i12 & 65535;
                if (i13 == 65535) {
                    i13 = this.mMasterInput.readInt();
                }
                this.mFieldId = (i12 >> 16) & 65535;
                this.mFieldSize = i13;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public float readFloat() {
        try {
            return this.mCurrentInput.readFloat();
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int readInt() {
        try {
            return this.mCurrentInput.readInt();
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public long readLong() {
        try {
            return this.mCurrentInput.readLong();
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public <T extends Parcelable> T readParcelable() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String readString() throws IOException {
        try {
            int i10 = this.mCurrentInput.readInt();
            if (i10 <= 0) {
                return null;
            }
            byte[] bArr = new byte[i10];
            this.mCurrentInput.readFully(bArr);
            return new String(bArr, UTF_16);
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public IBinder readStrongBinder() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void setOutputField(int i10) {
        closeField();
        FieldBuffer fieldBuffer = new FieldBuffer(i10, this.mMasterOutput);
        this.mFieldBuffer = fieldBuffer;
        this.mCurrentOutput = fieldBuffer.mDataStream;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void setSerializationFlags(boolean z9, boolean z10) {
        if (z9) {
            this.mIgnoreParcelables = z10;
        } else {
            a.j("Serialization of this object is not allowed");
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBoolean(boolean z9) throws IOException {
        try {
            this.mCurrentOutput.writeBoolean(z9);
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBundle(Bundle bundle) throws IOException {
        try {
            if (bundle == null) {
                this.mCurrentOutput.writeInt(-1);
                return;
            }
            Set<String> setKeySet = bundle.keySet();
            this.mCurrentOutput.writeInt(setKeySet.size());
            for (String str : setKeySet) {
                writeString(str);
                writeObject(bundle.get(str));
            }
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] bArr) throws IOException {
        DataOutputStream dataOutputStream = this.mCurrentOutput;
        try {
            if (bArr == null) {
                dataOutputStream.writeInt(-1);
            } else {
                dataOutputStream.writeInt(bArr.length);
                this.mCurrentOutput.write(bArr);
            }
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeCharSequence(CharSequence charSequence) {
        if (this.mIgnoreParcelables) {
            return;
        }
        a.j("CharSequence cannot be written to an OutputStream");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeDouble(double d8) throws IOException {
        try {
            this.mCurrentOutput.writeDouble(d8);
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeFloat(float f) throws IOException {
        try {
            this.mCurrentOutput.writeFloat(f);
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeInt(int i10) throws IOException {
        try {
            this.mCurrentOutput.writeInt(i10);
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeLong(long j10) throws IOException {
        try {
            this.mCurrentOutput.writeLong(j10);
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeParcelable(Parcelable parcelable) {
        if (this.mIgnoreParcelables) {
            return;
        }
        a.j("Parcelables cannot be written to an OutputStream");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeString(String str) throws IOException {
        try {
            if (str == null) {
                this.mCurrentOutput.writeInt(-1);
                return;
            }
            byte[] bytes = str.getBytes(UTF_16);
            this.mCurrentOutput.writeInt(bytes.length);
            this.mCurrentOutput.write(bytes);
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongBinder(IBinder iBinder) {
        if (this.mIgnoreParcelables) {
            return;
        }
        a.j("Binders cannot be written to an OutputStream");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongInterface(IInterface iInterface) {
        if (this.mIgnoreParcelables) {
            return;
        }
        a.j("Binders cannot be written to an OutputStream");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] bArr, int i10, int i11) throws IOException {
        DataOutputStream dataOutputStream = this.mCurrentOutput;
        try {
            if (bArr != null) {
                dataOutputStream.writeInt(i11);
                this.mCurrentOutput.write(bArr, i10, i11);
            } else {
                dataOutputStream.writeInt(-1);
            }
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    public VersionedParcelStream(InputStream inputStream, OutputStream outputStream) {
        this(inputStream, outputStream, new ArrayMap(), new ArrayMap(), new ArrayMap());
    }
}
