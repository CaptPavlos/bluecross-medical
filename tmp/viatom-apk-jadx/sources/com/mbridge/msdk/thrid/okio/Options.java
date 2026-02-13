package com.mbridge.msdk.thrid.okio;

import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class Options extends AbstractList<ByteString> implements RandomAccess {
    final ByteString[] byteStrings;
    final int[] trie;

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    private static void buildTrieRecursive(long j10, Buffer buffer, int i10, List<ByteString> list, int i11, int i12, List<Integer> list2) {
        int i13;
        int i14;
        long j11;
        int i15;
        List<Integer> list3;
        long j12;
        int i16;
        List<ByteString> list4 = list;
        List<Integer> list5 = list2;
        if (i11 >= i12) {
            u.m();
            return;
        }
        for (int i17 = i11; i17 < i12; i17++) {
            if (list4.get(i17).size() < i10) {
                u.m();
                return;
            }
        }
        ByteString byteString = list.get(i11);
        ByteString byteString2 = list4.get(i12 - 1);
        if (i10 == byteString.size()) {
            int iIntValue = list5.get(i11).intValue();
            int i18 = i11 + 1;
            ByteString byteString3 = list4.get(i18);
            i13 = i18;
            i14 = iIntValue;
            byteString = byteString3;
        } else {
            i13 = i11;
            i14 = -1;
        }
        long j13 = 2;
        if (byteString.getByte(i10) == byteString2.getByte(i10)) {
            int iMin = Math.min(byteString.size(), byteString2.size());
            int i19 = 0;
            int i20 = i10;
            while (true) {
                if (i20 >= iMin) {
                    j11 = j13;
                    break;
                }
                j11 = j13;
                if (byteString.getByte(i20) != byteString2.getByte(i20)) {
                    break;
                }
                i19++;
                i20++;
                j13 = j11;
            }
            long jIntCount = j10 + intCount(buffer) + j11 + i19 + 1;
            buffer.writeInt(-i19);
            buffer.writeInt(i14);
            int i21 = i10;
            while (true) {
                i15 = i10 + i19;
                if (i21 >= i15) {
                    break;
                }
                buffer.writeInt(byteString.getByte(i21) & 255);
                i21++;
            }
            if (i13 + 1 == i12) {
                if (i15 == list4.get(i13).size()) {
                    buffer.writeInt(list5.get(i13).intValue());
                    return;
                } else {
                    u.m();
                    return;
                }
            }
            Buffer buffer2 = new Buffer();
            buffer.writeInt((int) ((intCount(buffer2) + jIntCount) * (-1)));
            buildTrieRecursive(jIntCount, buffer2, i15, list4, i13, i12, list5);
            buffer.write(buffer2, buffer2.size());
            return;
        }
        int i22 = 1;
        for (int i23 = i13 + 1; i23 < i12; i23++) {
            if (list4.get(i23 - 1).getByte(i10) != list4.get(i23).getByte(i10)) {
                i22++;
            }
        }
        long jIntCount2 = j10 + intCount(buffer) + 2 + (i22 * 2);
        buffer.writeInt(i22);
        buffer.writeInt(i14);
        for (int i24 = i13; i24 < i12; i24++) {
            byte b10 = list4.get(i24).getByte(i10);
            if (i24 == i13 || b10 != list4.get(i24 - 1).getByte(i10)) {
                buffer.writeInt(b10 & 255);
            }
        }
        Buffer buffer3 = new Buffer();
        int i25 = i13;
        while (i25 < i12) {
            byte b11 = list4.get(i25).getByte(i10);
            int i26 = i25 + 1;
            int i27 = i26;
            while (true) {
                if (i27 >= i12) {
                    i27 = i12;
                    break;
                } else if (b11 != list4.get(i27).getByte(i10)) {
                    break;
                } else {
                    i27++;
                }
            }
            if (i26 == i27 && i10 + 1 == list4.get(i25).size()) {
                buffer.writeInt(list5.get(i25).intValue());
                list3 = list5;
                j12 = jIntCount2;
                i16 = i27;
            } else {
                buffer.writeInt((int) ((intCount(buffer3) + jIntCount2) * (-1)));
                list3 = list5;
                j12 = jIntCount2;
                i16 = i27;
                buildTrieRecursive(j12, buffer3, i10 + 1, list, i25, i16, list3);
                list4 = list;
            }
            jIntCount2 = j12;
            i25 = i16;
            list5 = list3;
        }
        buffer.write(buffer3, buffer3.size());
    }

    private static int intCount(Buffer buffer) {
        return (int) (buffer.size() / 4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00aa, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.mbridge.msdk.thrid.okio.Options of(com.mbridge.msdk.thrid.okio.ByteString... r11) {
        /*
            int r0 = r11.length
            r1 = -1
            r2 = 0
            if (r0 != 0) goto L11
            com.mbridge.msdk.thrid.okio.Options r11 = new com.mbridge.msdk.thrid.okio.Options
            com.mbridge.msdk.thrid.okio.ByteString[] r0 = new com.mbridge.msdk.thrid.okio.ByteString[r2]
            int[] r1 = new int[]{r2, r1}
            r11.<init>(r0, r1)
            return r11
        L11:
            java.util.ArrayList r7 = new java.util.ArrayList
            java.util.List r0 = java.util.Arrays.asList(r11)
            r7.<init>(r0)
            java.util.Collections.sort(r7)
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            r0 = r2
        L23:
            int r3 = r7.size()
            if (r0 >= r3) goto L33
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)
            r10.add(r3)
            int r0 = r0 + 1
            goto L23
        L33:
            r0 = r2
        L34:
            int r1 = r7.size()
            if (r0 >= r1) goto L4a
            r1 = r11[r0]
            int r1 = java.util.Collections.binarySearch(r7, r1)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            r10.set(r1, r3)
            int r0 = r0 + 1
            goto L34
        L4a:
            java.lang.Object r0 = r7.get(r2)
            com.mbridge.msdk.thrid.okio.ByteString r0 = (com.mbridge.msdk.thrid.okio.ByteString) r0
            int r0 = r0.size()
            if (r0 == 0) goto Le4
            r0 = r2
        L57:
            int r1 = r7.size()
            if (r0 >= r1) goto Lac
            java.lang.Object r1 = r7.get(r0)
            com.mbridge.msdk.thrid.okio.ByteString r1 = (com.mbridge.msdk.thrid.okio.ByteString) r1
            int r3 = r0 + 1
            r4 = r3
        L66:
            int r5 = r7.size()
            if (r4 >= r5) goto Laa
            java.lang.Object r5 = r7.get(r4)
            com.mbridge.msdk.thrid.okio.ByteString r5 = (com.mbridge.msdk.thrid.okio.ByteString) r5
            boolean r6 = r5.startsWith(r1)
            if (r6 != 0) goto L79
            goto Laa
        L79:
            int r6 = r5.size()
            int r8 = r1.size()
            if (r6 == r8) goto La3
            java.lang.Object r5 = r10.get(r4)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.lang.Object r6 = r10.get(r0)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            if (r5 <= r6) goto La0
            r7.remove(r4)
            r10.remove(r4)
            goto L66
        La0:
            int r4 = r4 + 1
            goto L66
        La3:
            java.lang.String r11 = "duplicate option: "
            androidx.window.layout.c.j(r5, r11)
            r11 = 0
            return r11
        Laa:
            r0 = r3
            goto L57
        Lac:
            com.mbridge.msdk.thrid.okio.Buffer r5 = new com.mbridge.msdk.thrid.okio.Buffer
            r5.<init>()
            r8 = 0
            int r9 = r7.size()
            r3 = 0
            r6 = 0
            buildTrieRecursive(r3, r5, r6, r7, r8, r9, r10)
            int r0 = intCount(r5)
            int[] r1 = new int[r0]
        Lc2:
            if (r2 >= r0) goto Lcd
            int r3 = r5.readInt()
            r1[r2] = r3
            int r2 = r2 + 1
            goto Lc2
        Lcd:
            boolean r0 = r5.exhausted()
            if (r0 == 0) goto Ldf
            com.mbridge.msdk.thrid.okio.Options r0 = new com.mbridge.msdk.thrid.okio.Options
            java.lang.Object r11 = r11.clone()
            com.mbridge.msdk.thrid.okio.ByteString[] r11 = (com.mbridge.msdk.thrid.okio.ByteString[]) r11
            r0.<init>(r11, r1)
            return r0
        Ldf:
            p8.u.m()
            r11 = 0
            return r11
        Le4:
            java.lang.String r11 = "the empty byte string is not a supported option"
            com.google.gson.internal.a.n(r11)
            r11 = 0
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okio.Options.of(com.mbridge.msdk.thrid.okio.ByteString[]):com.mbridge.msdk.thrid.okio.Options");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.byteStrings.length;
    }

    @Override // java.util.AbstractList, java.util.List
    public ByteString get(int i10) {
        return this.byteStrings[i10];
    }
}
