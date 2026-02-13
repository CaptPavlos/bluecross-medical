package j$.time.chrono;

import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;

/* loaded from: classes2.dex */
public final class e0 implements Externalizable {
    private static final long serialVersionUID = -6103370247208168577L;

    /* renamed from: a, reason: collision with root package name */
    public byte f9156a;

    /* renamed from: b, reason: collision with root package name */
    public Object f9157b;

    public e0() {
    }

    public e0(byte b10, Object obj) {
        this.f9156a = b10;
        this.f9157b = obj;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) throws IOException {
        byte b10 = this.f9156a;
        Object obj = this.f9157b;
        objectOutput.writeByte(b10);
        switch (b10) {
            case 1:
                objectOutput.writeUTF(((a) obj).d());
                return;
            case 2:
                g gVar = (g) obj;
                objectOutput.writeObject(gVar.f9160a);
                objectOutput.writeObject(gVar.f9161b);
                return;
            case 3:
                k kVar = (k) obj;
                objectOutput.writeObject(kVar.f9172a);
                objectOutput.writeObject(kVar.f9173b);
                objectOutput.writeObject(kVar.f9174c);
                return;
            case 4:
                x xVar = (x) obj;
                xVar.getClass();
                objectOutput.writeInt(j$.time.temporal.r.a(xVar, j$.time.temporal.a.YEAR));
                objectOutput.writeByte(j$.time.temporal.r.a(xVar, j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(j$.time.temporal.r.a(xVar, j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case 5:
                objectOutput.writeByte(((y) obj).f9198a);
                return;
            case 6:
                q qVar = (q) obj;
                objectOutput.writeObject(qVar.f9183a);
                objectOutput.writeInt(j$.time.temporal.r.a(qVar, j$.time.temporal.a.YEAR));
                objectOutput.writeByte(j$.time.temporal.r.a(qVar, j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(j$.time.temporal.r.a(qVar, j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case 7:
                c0 c0Var = (c0) obj;
                c0Var.getClass();
                objectOutput.writeInt(j$.time.temporal.r.a(c0Var, j$.time.temporal.a.YEAR));
                objectOutput.writeByte(j$.time.temporal.r.a(c0Var, j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(j$.time.temporal.r.a(c0Var, j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case 8:
                i0 i0Var = (i0) obj;
                i0Var.getClass();
                objectOutput.writeInt(j$.time.temporal.r.a(i0Var, j$.time.temporal.a.YEAR));
                objectOutput.writeByte(j$.time.temporal.r.a(i0Var, j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(j$.time.temporal.r.a(i0Var, j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case 9:
                h hVar = (h) obj;
                objectOutput.writeUTF(hVar.f9163a.d());
                objectOutput.writeInt(hVar.f9164b);
                objectOutput.writeInt(hVar.f9165c);
                objectOutput.writeInt(hVar.f9166d);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) throws IOException {
        Object objE;
        byte b10 = objectInput.readByte();
        this.f9156a = b10;
        switch (b10) {
            case 1:
                ConcurrentHashMap concurrentHashMap = a.f9149a;
                objE = j$.com.android.tools.r8.a.E(objectInput.readUTF());
                break;
            case 2:
                objE = ((b) objectInput.readObject()).s((j$.time.k) objectInput.readObject());
                break;
            case 3:
                objE = ((e) objectInput.readObject()).h((ZoneOffset) objectInput.readObject()).m((ZoneId) objectInput.readObject());
                break;
            case 4:
                j$.time.h hVar = x.f9193d;
                int i10 = objectInput.readInt();
                byte b11 = objectInput.readByte();
                byte b12 = objectInput.readByte();
                v.f9191c.getClass();
                objE = new x(j$.time.h.D(i10, b11, b12));
                break;
            case 5:
                y yVar = y.f9197d;
                objE = y.l(objectInput.readByte());
                break;
            case 6:
                o oVar = (o) objectInput.readObject();
                int i11 = objectInput.readInt();
                byte b13 = objectInput.readByte();
                byte b14 = objectInput.readByte();
                oVar.getClass();
                objE = new q(oVar, i11, b13, b14);
                break;
            case 7:
                int i12 = objectInput.readInt();
                byte b15 = objectInput.readByte();
                byte b16 = objectInput.readByte();
                a0.f9151c.getClass();
                objE = new c0(j$.time.h.D(i12 + 1911, b15, b16));
                break;
            case 8:
                int i13 = objectInput.readInt();
                byte b17 = objectInput.readByte();
                byte b18 = objectInput.readByte();
                g0.f9162c.getClass();
                objE = new i0(j$.time.h.D(i13 - 543, b17, b18));
                break;
            case 9:
                int i14 = h.e;
                objE = new h(j$.com.android.tools.r8.a.E(objectInput.readUTF()), objectInput.readInt(), objectInput.readInt(), objectInput.readInt());
                break;
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
        this.f9157b = objE;
    }

    private Object readResolve() {
        return this.f9157b;
    }
}
