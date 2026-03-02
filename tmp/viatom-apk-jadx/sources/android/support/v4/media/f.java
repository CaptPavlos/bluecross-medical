package android.support.v4.media;

import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaDescription;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import c1.d5;
import c1.i;
import c1.k4;
import c1.n4;
import c1.o4;
import c1.p4;
import c1.u;
import c1.v;
import c1.y4;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.measurement.a4;
import f0.q;
import i0.s;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class f implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f384a;

    public /* synthetic */ f(int i10) {
        this.f384a = i10;
    }

    public static void a(v vVar, Parcel parcel, int i10) {
        String str = vVar.f1505a;
        int I = a4.I(parcel, 20293);
        a4.F(parcel, 2, str);
        a4.E(parcel, 3, vVar.f1506b, i10);
        a4.F(parcel, 4, vVar.f1507c);
        long j10 = vVar.f1508d;
        a4.O(parcel, 5, 8);
        parcel.writeLong(j10);
        a4.M(parcel, I);
    }

    public static void b(y4 y4Var, Parcel parcel) {
        int i10 = y4Var.f1609a;
        int I = a4.I(parcel, 20293);
        a4.O(parcel, 1, 4);
        parcel.writeInt(i10);
        a4.F(parcel, 2, y4Var.f1610b);
        long j10 = y4Var.f1611c;
        a4.O(parcel, 3, 8);
        parcel.writeLong(j10);
        Long l10 = y4Var.f1612d;
        if (l10 != null) {
            a4.O(parcel, 4, 8);
            parcel.writeLong(l10.longValue());
        }
        a4.F(parcel, 6, y4Var.e);
        a4.F(parcel, 7, y4Var.f);
        Double d8 = y4Var.g;
        if (d8 != null) {
            a4.O(parcel, 8, 8);
            parcel.writeDouble(d8.doubleValue());
        }
        a4.M(parcel, I);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        long jM = 0;
        int iL = 0;
        int iL2 = 0;
        int iL3 = 0;
        int iL4 = 0;
        boolean zI = false;
        int iL5 = 0;
        int iL6 = 0;
        int iL7 = 0;
        Bundle bundleR = null;
        String strT = null;
        f0.b bVar = null;
        Intent intent = null;
        String strT2 = null;
        String strT3 = null;
        PendingIntent pendingIntent = null;
        String strT4 = null;
        Bundle bundleR2 = null;
        d.b bVar2 = null;
        ArrayList arrayListV = null;
        String strT5 = null;
        Bundle bundleR3 = null;
        switch (this.f384a) {
            case 0:
                return new MediaBrowserCompat$MediaItem(parcel);
            case 1:
                return MediaDescriptionCompat.a(MediaDescription.CREATOR.createFromParcel(parcel));
            case 2:
                return new MediaMetadataCompat(parcel);
            case 3:
                return new RatingCompat(parcel.readInt(), parcel.readFloat());
            case 4:
                return new MediaSessionCompat$QueueItem(parcel);
            case 5:
                MediaSessionCompat$ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper = new MediaSessionCompat$ResultReceiverWrapper();
                mediaSessionCompat$ResultReceiverWrapper.f392a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
                return mediaSessionCompat$ResultReceiverWrapper;
            case 6:
                return new MediaSessionCompat$Token(parcel.readParcelable(null), null);
            case 7:
                ParcelableVolumeInfo parcelableVolumeInfo = new ParcelableVolumeInfo();
                parcelableVolumeInfo.f395a = parcel.readInt();
                parcelableVolumeInfo.f397c = parcel.readInt();
                parcelableVolumeInfo.f398d = parcel.readInt();
                parcelableVolumeInfo.e = parcel.readInt();
                parcelableVolumeInfo.f396b = parcel.readInt();
                return parcelableVolumeInfo;
            case 8:
                return new PlaybackStateCompat(parcel);
            case 9:
                int iQ = a.a.Q(parcel);
                long jM2 = 0;
                long jM3 = 0;
                int iL8 = 0;
                while (parcel.dataPosition() < iQ) {
                    int i10 = parcel.readInt();
                    char c10 = (char) i10;
                    if (c10 == 1) {
                        jM2 = a.a.M(parcel, i10);
                    } else if (c10 == 2) {
                        iL8 = a.a.L(parcel, i10);
                    } else if (c10 != 3) {
                        a.a.O(parcel, i10);
                    } else {
                        jM3 = a.a.M(parcel, i10);
                    }
                }
                a.a.y(parcel, iQ);
                return new c1.d(jM2, iL8, jM3);
            case 10:
                int iQ2 = a.a.Q(parcel);
                long jM4 = 0;
                long jM5 = 0;
                long jM6 = 0;
                boolean zI2 = false;
                String strT6 = null;
                String strT7 = null;
                y4 y4Var = null;
                String strT8 = null;
                v vVar = null;
                v vVar2 = null;
                v vVar3 = null;
                while (parcel.dataPosition() < iQ2) {
                    int i11 = parcel.readInt();
                    switch ((char) i11) {
                        case 2:
                            strT6 = a.a.t(parcel, i11);
                            break;
                        case 3:
                            strT7 = a.a.t(parcel, i11);
                            break;
                        case 4:
                            y4Var = (y4) a.a.s(parcel, i11, y4.CREATOR);
                            break;
                        case 5:
                            jM4 = a.a.M(parcel, i11);
                            break;
                        case 6:
                            zI2 = a.a.I(parcel, i11);
                            break;
                        case 7:
                            strT8 = a.a.t(parcel, i11);
                            break;
                        case '\b':
                            vVar = (v) a.a.s(parcel, i11, v.CREATOR);
                            break;
                        case '\t':
                            jM5 = a.a.M(parcel, i11);
                            break;
                        case '\n':
                            vVar2 = (v) a.a.s(parcel, i11, v.CREATOR);
                            break;
                        case 11:
                            jM6 = a.a.M(parcel, i11);
                            break;
                        case '\f':
                            vVar3 = (v) a.a.s(parcel, i11, v.CREATOR);
                            break;
                        default:
                            a.a.O(parcel, i11);
                            break;
                    }
                }
                a.a.y(parcel, iQ2);
                return new c1.e(strT6, strT7, y4Var, jM4, zI2, strT8, vVar, jM5, vVar2, jM6, vVar3);
            case 11:
                int iQ3 = a.a.Q(parcel);
                while (parcel.dataPosition() < iQ3) {
                    int i12 = parcel.readInt();
                    if (((char) i12) != 1) {
                        a.a.O(parcel, i12);
                    } else {
                        bundleR = a.a.r(parcel, i12);
                    }
                }
                a.a.y(parcel, iQ3);
                return new i(bundleR);
            case 12:
                int iQ4 = a.a.Q(parcel);
                while (parcel.dataPosition() < iQ4) {
                    int i13 = parcel.readInt();
                    if (((char) i13) != 2) {
                        a.a.O(parcel, i13);
                    } else {
                        bundleR3 = a.a.r(parcel, i13);
                    }
                }
                a.a.y(parcel, iQ4);
                return new u(bundleR3);
            case 13:
                int iQ5 = a.a.Q(parcel);
                long jM7 = 0;
                String strT9 = null;
                u uVar = null;
                String strT10 = null;
                while (parcel.dataPosition() < iQ5) {
                    int i14 = parcel.readInt();
                    char c11 = (char) i14;
                    if (c11 == 2) {
                        strT9 = a.a.t(parcel, i14);
                    } else if (c11 == 3) {
                        uVar = (u) a.a.s(parcel, i14, u.CREATOR);
                    } else if (c11 == 4) {
                        strT10 = a.a.t(parcel, i14);
                    } else if (c11 != 5) {
                        a.a.O(parcel, i14);
                    } else {
                        jM7 = a.a.M(parcel, i14);
                    }
                }
                a.a.y(parcel, iQ5);
                return new v(strT9, uVar, strT10, jM7);
            case 14:
                int iQ6 = a.a.Q(parcel);
                while (parcel.dataPosition() < iQ6) {
                    int i15 = parcel.readInt();
                    char c12 = (char) i15;
                    if (c12 == 1) {
                        strT5 = a.a.t(parcel, i15);
                    } else if (c12 == 2) {
                        jM = a.a.M(parcel, i15);
                    } else if (c12 != 3) {
                        a.a.O(parcel, i15);
                    } else {
                        iL = a.a.L(parcel, i15);
                    }
                }
                a.a.y(parcel, iQ6);
                return new k4(iL, jM, strT5);
            case 15:
                int iQ7 = a.a.Q(parcel);
                long jM8 = 0;
                long jM9 = 0;
                int iL9 = 0;
                byte[] bArr = null;
                String strT11 = null;
                Bundle bundleR4 = null;
                String strT12 = null;
                while (parcel.dataPosition() < iQ7) {
                    int i16 = parcel.readInt();
                    switch ((char) i16) {
                        case 1:
                            jM8 = a.a.M(parcel, i16);
                            break;
                        case 2:
                            int iN = a.a.N(parcel, i16);
                            int iDataPosition = parcel.dataPosition();
                            if (iN == 0) {
                                bArr = null;
                                break;
                            } else {
                                byte[] bArrCreateByteArray = parcel.createByteArray();
                                parcel.setDataPosition(iDataPosition + iN);
                                bArr = bArrCreateByteArray;
                                break;
                            }
                        case 3:
                            strT11 = a.a.t(parcel, i16);
                            break;
                        case 4:
                            bundleR4 = a.a.r(parcel, i16);
                            break;
                        case 5:
                            iL9 = a.a.L(parcel, i16);
                            break;
                        case 6:
                            jM9 = a.a.M(parcel, i16);
                            break;
                        case 7:
                            strT12 = a.a.t(parcel, i16);
                            break;
                        default:
                            a.a.O(parcel, i16);
                            break;
                    }
                }
                a.a.y(parcel, iQ7);
                return new n4(jM8, bArr, strT11, bundleR4, iL9, jM9, strT12);
            case 16:
                int iQ8 = a.a.Q(parcel);
                while (true) {
                    ArrayList arrayList = null;
                    while (parcel.dataPosition() < iQ8) {
                        int i17 = parcel.readInt();
                        if (((char) i17) != 1) {
                            a.a.O(parcel, i17);
                        } else {
                            int iN2 = a.a.N(parcel, i17);
                            int iDataPosition2 = parcel.dataPosition();
                            if (iN2 == 0) {
                                break;
                            }
                            ArrayList arrayList2 = new ArrayList();
                            int i18 = parcel.readInt();
                            for (int i19 = 0; i19 < i18; i19++) {
                                arrayList2.add(Integer.valueOf(parcel.readInt()));
                            }
                            parcel.setDataPosition(iDataPosition2 + iN2);
                            arrayList = arrayList2;
                        }
                    }
                    a.a.y(parcel, iQ8);
                    return new o4(arrayList);
                    break;
                }
            case 17:
                int iQ9 = a.a.Q(parcel);
                while (parcel.dataPosition() < iQ9) {
                    int i20 = parcel.readInt();
                    if (((char) i20) != 1) {
                        a.a.O(parcel, i20);
                    } else {
                        arrayListV = a.a.v(parcel, i20, n4.CREATOR);
                    }
                }
                a.a.y(parcel, iQ9);
                return new p4(arrayListV);
            case 18:
                int iQ10 = a.a.Q(parcel);
                long jM10 = 0;
                int iL10 = 0;
                String strT13 = null;
                Long lValueOf = null;
                Float fValueOf = null;
                String strT14 = null;
                String strT15 = null;
                Double dValueOf = null;
                while (parcel.dataPosition() < iQ10) {
                    int i21 = parcel.readInt();
                    switch ((char) i21) {
                        case 1:
                            iL10 = a.a.L(parcel, i21);
                            break;
                        case 2:
                            strT13 = a.a.t(parcel, i21);
                            break;
                        case 3:
                            jM10 = a.a.M(parcel, i21);
                            break;
                        case 4:
                            int iN3 = a.a.N(parcel, i21);
                            if (iN3 == 0) {
                                lValueOf = null;
                                break;
                            } else {
                                a.a.S(parcel, iN3, 8);
                                lValueOf = Long.valueOf(parcel.readLong());
                                break;
                            }
                        case 5:
                            int iN4 = a.a.N(parcel, i21);
                            if (iN4 == 0) {
                                fValueOf = null;
                                break;
                            } else {
                                a.a.S(parcel, iN4, 4);
                                fValueOf = Float.valueOf(parcel.readFloat());
                                break;
                            }
                        case 6:
                            strT14 = a.a.t(parcel, i21);
                            break;
                        case 7:
                            strT15 = a.a.t(parcel, i21);
                            break;
                        case '\b':
                            int iN5 = a.a.N(parcel, i21);
                            if (iN5 == 0) {
                                dValueOf = null;
                                break;
                            } else {
                                a.a.S(parcel, iN5, 8);
                                dValueOf = Double.valueOf(parcel.readDouble());
                                break;
                            }
                        default:
                            a.a.O(parcel, i21);
                            break;
                    }
                }
                a.a.y(parcel, iQ10);
                return new y4(iL10, strT13, jM10, lValueOf, fValueOf, strT14, strT15, dValueOf);
            case 19:
                int iQ11 = a.a.Q(parcel);
                String strT16 = "";
                String strT17 = strT16;
                String strT18 = strT17;
                String strT19 = strT18;
                long jM11 = 0;
                long jM12 = 0;
                long jM13 = 0;
                long jM14 = 0;
                long jM15 = 0;
                long jM16 = 0;
                long jM17 = 0;
                int iL11 = 100;
                boolean zI3 = true;
                boolean zI4 = true;
                boolean zI5 = false;
                int iL12 = 0;
                boolean zI6 = false;
                boolean zI7 = false;
                int iL13 = 0;
                int iL14 = 0;
                String strT20 = null;
                String strT21 = null;
                String strT22 = null;
                String strT23 = null;
                String strT24 = null;
                String strT25 = null;
                Boolean boolValueOf = null;
                ArrayList<String> arrayList3 = null;
                String strT26 = null;
                String strT27 = null;
                long jM18 = -2147483648L;
                while (parcel.dataPosition() < iQ11) {
                    int i22 = parcel.readInt();
                    switch ((char) i22) {
                        case 2:
                            strT20 = a.a.t(parcel, i22);
                            break;
                        case 3:
                            strT21 = a.a.t(parcel, i22);
                            break;
                        case 4:
                            strT22 = a.a.t(parcel, i22);
                            break;
                        case 5:
                            strT23 = a.a.t(parcel, i22);
                            break;
                        case 6:
                            jM11 = a.a.M(parcel, i22);
                            break;
                        case 7:
                            jM12 = a.a.M(parcel, i22);
                            break;
                        case '\b':
                            strT24 = a.a.t(parcel, i22);
                            break;
                        case '\t':
                            zI3 = a.a.I(parcel, i22);
                            break;
                        case '\n':
                            zI5 = a.a.I(parcel, i22);
                            break;
                        case 11:
                            jM18 = a.a.M(parcel, i22);
                            break;
                        case '\f':
                            strT25 = a.a.t(parcel, i22);
                            break;
                        case '\r':
                        case 17:
                        case 19:
                        case 20:
                        case 24:
                        case '!':
                        default:
                            a.a.O(parcel, i22);
                            break;
                        case 14:
                            jM13 = a.a.M(parcel, i22);
                            break;
                        case 15:
                            iL12 = a.a.L(parcel, i22);
                            break;
                        case 16:
                            zI4 = a.a.I(parcel, i22);
                            break;
                        case 18:
                            zI6 = a.a.I(parcel, i22);
                            break;
                        case 21:
                            int iN6 = a.a.N(parcel, i22);
                            if (iN6 == 0) {
                                boolValueOf = null;
                                break;
                            } else {
                                a.a.S(parcel, iN6, 4);
                                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
                                break;
                            }
                        case 22:
                            jM14 = a.a.M(parcel, i22);
                            break;
                        case 23:
                            int iN7 = a.a.N(parcel, i22);
                            int iDataPosition3 = parcel.dataPosition();
                            if (iN7 == 0) {
                                arrayList3 = null;
                                break;
                            } else {
                                ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
                                parcel.setDataPosition(iDataPosition3 + iN7);
                                arrayList3 = arrayListCreateStringArrayList;
                                break;
                            }
                        case 25:
                            strT16 = a.a.t(parcel, i22);
                            break;
                        case 26:
                            strT17 = a.a.t(parcel, i22);
                            break;
                        case 27:
                            strT26 = a.a.t(parcel, i22);
                            break;
                        case 28:
                            zI7 = a.a.I(parcel, i22);
                            break;
                        case 29:
                            jM15 = a.a.M(parcel, i22);
                            break;
                        case 30:
                            iL11 = a.a.L(parcel, i22);
                            break;
                        case 31:
                            strT18 = a.a.t(parcel, i22);
                            break;
                        case ' ':
                            iL13 = a.a.L(parcel, i22);
                            break;
                        case '\"':
                            jM16 = a.a.M(parcel, i22);
                            break;
                        case '#':
                            strT27 = a.a.t(parcel, i22);
                            break;
                        case '$':
                            strT19 = a.a.t(parcel, i22);
                            break;
                        case '%':
                            jM17 = a.a.M(parcel, i22);
                            break;
                        case '&':
                            iL14 = a.a.L(parcel, i22);
                            break;
                    }
                }
                a.a.y(parcel, iQ11);
                return new d5(strT20, strT21, strT22, strT23, jM11, jM12, strT24, zI3, zI5, jM18, strT25, jM13, iL12, zI4, zI6, boolValueOf, jM14, arrayList3, strT16, strT17, strT26, zI7, jM15, iL11, strT18, iL13, jM16, strT27, strT19, jM17, iL14);
            case 20:
                d.d dVar = new d.d();
                IBinder strongBinder = parcel.readStrongBinder();
                int i23 = d.c.f6759b;
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface(d.b.f6758j);
                    if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof d.b)) {
                        d.a aVar = new d.a();
                        aVar.f6757a = strongBinder;
                        bVar2 = aVar;
                    } else {
                        bVar2 = (d.b) iInterfaceQueryLocalInterface;
                    }
                }
                dVar.f6761a = bVar2;
                return dVar;
            case 21:
                int iQ12 = a.a.Q(parcel);
                int iL15 = 0;
                while (parcel.dataPosition() < iQ12) {
                    int i24 = parcel.readInt();
                    char c13 = (char) i24;
                    if (c13 == 1) {
                        iL7 = a.a.L(parcel, i24);
                    } else if (c13 == 2) {
                        iL15 = a.a.L(parcel, i24);
                    } else if (c13 != 3) {
                        a.a.O(parcel, i24);
                    } else {
                        bundleR2 = a.a.r(parcel, i24);
                    }
                }
                a.a.y(parcel, iQ12);
                return new d0.a(iL7, iL15, bundleR2);
            case 22:
                int iQ13 = a.a.Q(parcel);
                GoogleSignInOptions googleSignInOptions = null;
                while (parcel.dataPosition() < iQ13) {
                    int i25 = parcel.readInt();
                    char c14 = (char) i25;
                    if (c14 == 2) {
                        strT4 = a.a.t(parcel, i25);
                    } else if (c14 != 5) {
                        a.a.O(parcel, i25);
                    } else {
                        googleSignInOptions = (GoogleSignInOptions) a.a.s(parcel, i25, GoogleSignInOptions.CREATOR);
                    }
                }
                a.a.y(parcel, iQ13);
                return new SignInConfiguration(strT4, googleSignInOptions);
            case 23:
                int iQ14 = a.a.Q(parcel);
                int iL16 = 0;
                String strT28 = null;
                while (parcel.dataPosition() < iQ14) {
                    int i26 = parcel.readInt();
                    char c15 = (char) i26;
                    if (c15 == 1) {
                        iL6 = a.a.L(parcel, i26);
                    } else if (c15 == 2) {
                        iL16 = a.a.L(parcel, i26);
                    } else if (c15 == 3) {
                        pendingIntent = (PendingIntent) a.a.s(parcel, i26, PendingIntent.CREATOR);
                    } else if (c15 != 4) {
                        a.a.O(parcel, i26);
                    } else {
                        strT28 = a.a.t(parcel, i26);
                    }
                }
                a.a.y(parcel, iQ14);
                return new f0.b(iL6, iL16, pendingIntent, strT28);
            case 24:
                int iQ15 = a.a.Q(parcel);
                long jM19 = -1;
                while (parcel.dataPosition() < iQ15) {
                    int i27 = parcel.readInt();
                    char c16 = (char) i27;
                    if (c16 == 1) {
                        strT3 = a.a.t(parcel, i27);
                    } else if (c16 == 2) {
                        iL5 = a.a.L(parcel, i27);
                    } else if (c16 != 3) {
                        a.a.O(parcel, i27);
                    } else {
                        jM19 = a.a.M(parcel, i27);
                    }
                }
                a.a.y(parcel, iQ15);
                return new f0.d(strT3, iL5, jM19);
            case 25:
                int iQ16 = a.a.Q(parcel);
                int iL17 = 0;
                int iL18 = 0;
                while (parcel.dataPosition() < iQ16) {
                    int i28 = parcel.readInt();
                    char c17 = (char) i28;
                    if (c17 == 1) {
                        zI = a.a.I(parcel, i28);
                    } else if (c17 == 2) {
                        strT2 = a.a.t(parcel, i28);
                    } else if (c17 == 3) {
                        iL17 = a.a.L(parcel, i28);
                    } else if (c17 != 4) {
                        a.a.O(parcel, i28);
                    } else {
                        iL18 = a.a.L(parcel, i28);
                    }
                }
                a.a.y(parcel, iQ16);
                return new q(strT2, iL17, iL18, zI);
            case 26:
                int iQ17 = a.a.Q(parcel);
                int iL19 = 0;
                while (parcel.dataPosition() < iQ17) {
                    int i29 = parcel.readInt();
                    char c18 = (char) i29;
                    if (c18 == 1) {
                        iL4 = a.a.L(parcel, i29);
                    } else if (c18 == 2) {
                        iL19 = a.a.L(parcel, i29);
                    } else if (c18 != 3) {
                        a.a.O(parcel, i29);
                    } else {
                        intent = (Intent) a.a.s(parcel, i29, Intent.CREATOR);
                    }
                }
                a.a.y(parcel, iQ17);
                return new f1.b(iL4, iL19, intent);
            case 27:
                int iQ18 = a.a.Q(parcel);
                ArrayList<String> arrayList4 = null;
                String strT29 = null;
                while (parcel.dataPosition() < iQ18) {
                    int i30 = parcel.readInt();
                    char c19 = (char) i30;
                    if (c19 == 1) {
                        int iN8 = a.a.N(parcel, i30);
                        int iDataPosition4 = parcel.dataPosition();
                        if (iN8 == 0) {
                            arrayList4 = null;
                        } else {
                            ArrayList<String> arrayListCreateStringArrayList2 = parcel.createStringArrayList();
                            parcel.setDataPosition(iDataPosition4 + iN8);
                            arrayList4 = arrayListCreateStringArrayList2;
                        }
                    } else if (c19 != 2) {
                        a.a.O(parcel, i30);
                    } else {
                        strT29 = a.a.t(parcel, i30);
                    }
                }
                a.a.y(parcel, iQ18);
                return new f1.d(strT29, arrayList4);
            case 28:
                int iQ19 = a.a.Q(parcel);
                s sVar = null;
                while (parcel.dataPosition() < iQ19) {
                    int i31 = parcel.readInt();
                    char c20 = (char) i31;
                    if (c20 == 1) {
                        iL3 = a.a.L(parcel, i31);
                    } else if (c20 == 2) {
                        bVar = (f0.b) a.a.s(parcel, i31, f0.b.CREATOR);
                    } else if (c20 != 3) {
                        a.a.O(parcel, i31);
                    } else {
                        sVar = (s) a.a.s(parcel, i31, s.CREATOR);
                    }
                }
                a.a.y(parcel, iQ19);
                return new f1.e(iL3, bVar, sVar);
            default:
                int iQ20 = a.a.Q(parcel);
                while (parcel.dataPosition() < iQ20) {
                    int i32 = parcel.readInt();
                    char c21 = (char) i32;
                    if (c21 == 1) {
                        iL2 = a.a.L(parcel, i32);
                    } else if (c21 != 2) {
                        a.a.O(parcel, i32);
                    } else {
                        strT = a.a.t(parcel, i32);
                    }
                }
                a.a.y(parcel, iQ20);
                return new Scope(iL2, strT);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i10) {
        switch (this.f384a) {
            case 0:
                return new MediaBrowserCompat$MediaItem[i10];
            case 1:
                return new MediaDescriptionCompat[i10];
            case 2:
                return new MediaMetadataCompat[i10];
            case 3:
                return new RatingCompat[i10];
            case 4:
                return new MediaSessionCompat$QueueItem[i10];
            case 5:
                return new MediaSessionCompat$ResultReceiverWrapper[i10];
            case 6:
                return new MediaSessionCompat$Token[i10];
            case 7:
                return new ParcelableVolumeInfo[i10];
            case 8:
                return new PlaybackStateCompat[i10];
            case 9:
                return new c1.d[i10];
            case 10:
                return new c1.e[i10];
            case 11:
                return new i[i10];
            case 12:
                return new u[i10];
            case 13:
                return new v[i10];
            case 14:
                return new k4[i10];
            case 15:
                return new n4[i10];
            case 16:
                return new o4[i10];
            case 17:
                return new p4[i10];
            case 18:
                return new y4[i10];
            case 19:
                return new d5[i10];
            case 20:
                return new d.d[i10];
            case 21:
                return new d0.a[i10];
            case 22:
                return new SignInConfiguration[i10];
            case 23:
                return new f0.b[i10];
            case 24:
                return new f0.d[i10];
            case 25:
                return new q[i10];
            case 26:
                return new f1.b[i10];
            case 27:
                return new f1.d[i10];
            case 28:
                return new f1.e[i10];
            default:
                return new Scope[i10];
        }
    }
}
