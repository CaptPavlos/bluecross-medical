package com.mbridge.msdk.thrid.okhttp.internal.http2;

import androidx.browser.trusted.sharing.ShareTarget;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.accessibility.a;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.BufferedSource;
import com.mbridge.msdk.thrid.okio.ByteString;
import com.mbridge.msdk.thrid.okio.Okio;
import com.mbridge.msdk.thrid.okio.Source;
import j$.util.DesugarCollections;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class Hpack {
    static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX;
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    static final Header[] STATIC_HEADER_TABLE;

    static {
        Header header = new Header(Header.TARGET_AUTHORITY, "");
        ByteString byteString = Header.TARGET_METHOD;
        Header header2 = new Header(byteString, ShareTarget.METHOD_GET);
        Header header3 = new Header(byteString, ShareTarget.METHOD_POST);
        ByteString byteString2 = Header.TARGET_PATH;
        Header header4 = new Header(byteString2, "/");
        Header header5 = new Header(byteString2, "/index.html");
        ByteString byteString3 = Header.TARGET_SCHEME;
        Header header6 = new Header(byteString3, "http");
        Header header7 = new Header(byteString3, "https");
        ByteString byteString4 = Header.RESPONSE_STATUS;
        STATIC_HEADER_TABLE = new Header[]{header, header2, header3, header4, header5, header6, header7, new Header(byteString4, "200"), new Header(byteString4, "204"), new Header(byteString4, "206"), new Header(byteString4, "304"), new Header(byteString4, "400"), new Header(byteString4, "404"), new Header(byteString4, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header(DownloadModel.ETAG, ""), new Header("expect", ""), new Header("expires", ""), new Header(TypedValues.TransitionType.S_FROM, ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header(ToolBar.REFRESH, ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
        NAME_TO_FIRST_INDEX = nameToFirstIndex();
    }

    private Hpack() {
    }

    public static ByteString checkLowercase(ByteString byteString) throws IOException {
        int size = byteString.size();
        for (int i10 = 0; i10 < size; i10++) {
            byte b10 = byteString.getByte(i10);
            if (b10 >= 65 && b10 <= 90) {
                a.i(byteString.utf8(), "PROTOCOL_ERROR response malformed: mixed case name: ");
                return null;
            }
        }
        return byteString;
    }

    private static Map<ByteString, Integer> nameToFirstIndex() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(STATIC_HEADER_TABLE.length);
        int i10 = 0;
        while (true) {
            Header[] headerArr = STATIC_HEADER_TABLE;
            if (i10 >= headerArr.length) {
                return DesugarCollections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(headerArr[i10].name)) {
                linkedHashMap.put(headerArr[i10].name, Integer.valueOf(i10));
            }
            i10++;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Writer {
        private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
        private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
        Header[] dynamicTable;
        int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        int headerCount;
        int headerTableSizeSetting;
        int maxDynamicTableByteCount;
        int nextHeaderIndex;
        private final Buffer out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        public Writer(int i10, boolean z9, Buffer buffer) {
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = r0.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = i10;
            this.maxDynamicTableByteCount = i10;
            this.useCompression = z9;
            this.out = buffer;
        }

        private void adjustDynamicTableByteCount() {
            int i10 = this.maxDynamicTableByteCount;
            int i11 = this.dynamicTableByteCount;
            if (i10 < i11) {
                if (i10 == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i11 - i10);
                }
            }
        }

        private void clearDynamicTable() {
            Arrays.fill(this.dynamicTable, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int evictToRecoverBytes(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i11 = this.nextHeaderIndex;
                    if (length < i11 || i10 <= 0) {
                        break;
                    }
                    int i13 = this.dynamicTable[length].hpackSize;
                    i10 -= i13;
                    this.dynamicTableByteCount -= i13;
                    this.headerCount--;
                    i12++;
                }
                Header[] headerArr = this.dynamicTable;
                System.arraycopy(headerArr, i11 + 1, headerArr, i11 + 1 + i12, this.headerCount);
                Header[] headerArr2 = this.dynamicTable;
                int i14 = this.nextHeaderIndex;
                Arrays.fill(headerArr2, i14 + 1, i14 + 1 + i12, (Object) null);
                this.nextHeaderIndex += i12;
            }
            return i12;
        }

        private void insertIntoDynamicTable(Header header) {
            int i10 = header.hpackSize;
            int i11 = this.maxDynamicTableByteCount;
            if (i10 > i11) {
                clearDynamicTable();
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i10) - i11);
            int i12 = this.headerCount + 1;
            Header[] headerArr = this.dynamicTable;
            if (i12 > headerArr.length) {
                Header[] headerArr2 = new Header[headerArr.length * 2];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr2;
            }
            int i13 = this.nextHeaderIndex;
            this.nextHeaderIndex = i13 - 1;
            this.dynamicTable[i13] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i10;
        }

        public void setHeaderTableSizeSetting(int i10) {
            this.headerTableSizeSetting = i10;
            int iMin = Math.min(i10, 16384);
            int i11 = this.maxDynamicTableByteCount;
            if (i11 == iMin) {
                return;
            }
            if (iMin < i11) {
                this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, iMin);
            }
            this.emitDynamicTableSizeUpdate = true;
            this.maxDynamicTableByteCount = iMin;
            adjustDynamicTableByteCount();
        }

        public void writeByteString(ByteString byteString) throws IOException {
            if (!this.useCompression || Huffman.get().encodedLength(byteString) >= byteString.size()) {
                writeInt(byteString.size(), Hpack.PREFIX_7_BITS, 0);
                this.out.write(byteString);
                return;
            }
            Buffer buffer = new Buffer();
            Huffman.get().encode(byteString, buffer);
            ByteString byteString2 = buffer.readByteString();
            writeInt(byteString2.size(), Hpack.PREFIX_7_BITS, 128);
            this.out.write(byteString2);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void writeHeaders(java.util.List<com.mbridge.msdk.thrid.okhttp.internal.http2.Header> r14) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 236
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.http2.Hpack.Writer.writeHeaders(java.util.List):void");
        }

        public void writeInt(int i10, int i11, int i12) {
            Buffer buffer = this.out;
            if (i10 < i11) {
                buffer.writeByte(i10 | i12);
                return;
            }
            buffer.writeByte(i12 | i11);
            int i13 = i10 - i11;
            while (true) {
                Buffer buffer2 = this.out;
                if (i13 < 128) {
                    buffer2.writeByte(i13);
                    return;
                } else {
                    buffer2.writeByte(128 | (i13 & Hpack.PREFIX_7_BITS));
                    i13 >>>= 7;
                }
            }
        }

        public Writer(Buffer buffer) {
            this(4096, true, buffer);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Reader {
        Header[] dynamicTable;
        int dynamicTableByteCount;
        int headerCount;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        int nextHeaderIndex;
        private final BufferedSource source;

        public Reader(int i10, int i11, Source source) {
            this.headerList = new ArrayList();
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = r0.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = i10;
            this.maxDynamicTableByteCount = i11;
            this.source = Okio.buffer(source);
        }

        private void adjustDynamicTableByteCount() {
            int i10 = this.maxDynamicTableByteCount;
            int i11 = this.dynamicTableByteCount;
            if (i10 < i11) {
                if (i10 == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i11 - i10);
                }
            }
        }

        private void clearDynamicTable() {
            Arrays.fill(this.dynamicTable, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int dynamicTableIndex(int i10) {
            return this.nextHeaderIndex + 1 + i10;
        }

        private int evictToRecoverBytes(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i11 = this.nextHeaderIndex;
                    if (length < i11 || i10 <= 0) {
                        break;
                    }
                    int i13 = this.dynamicTable[length].hpackSize;
                    i10 -= i13;
                    this.dynamicTableByteCount -= i13;
                    this.headerCount--;
                    i12++;
                }
                Header[] headerArr = this.dynamicTable;
                System.arraycopy(headerArr, i11 + 1, headerArr, i11 + 1 + i12, this.headerCount);
                this.nextHeaderIndex += i12;
            }
            return i12;
        }

        private ByteString getName(int i10) throws IOException {
            if (isStaticHeader(i10)) {
                return Hpack.STATIC_HEADER_TABLE[i10].name;
            }
            int iDynamicTableIndex = dynamicTableIndex(i10 - Hpack.STATIC_HEADER_TABLE.length);
            if (iDynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (iDynamicTableIndex < headerArr.length) {
                    return headerArr[iDynamicTableIndex].name;
                }
            }
            u.n(i10 + 1, "Header index too large ");
            return null;
        }

        private void insertIntoDynamicTable(int i10, Header header) {
            this.headerList.add(header);
            int i11 = header.hpackSize;
            if (i10 != -1) {
                i11 -= this.dynamicTable[dynamicTableIndex(i10)].hpackSize;
            }
            int i12 = this.maxDynamicTableByteCount;
            if (i11 > i12) {
                clearDynamicTable();
                return;
            }
            int iEvictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i11) - i12);
            if (i10 == -1) {
                int i13 = this.headerCount + 1;
                Header[] headerArr = this.dynamicTable;
                if (i13 > headerArr.length) {
                    Header[] headerArr2 = new Header[headerArr.length * 2];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = headerArr2;
                }
                int i14 = this.nextHeaderIndex;
                this.nextHeaderIndex = i14 - 1;
                this.dynamicTable[i14] = header;
                this.headerCount++;
            } else {
                this.dynamicTable[dynamicTableIndex(i10) + iEvictToRecoverBytes + i10] = header;
            }
            this.dynamicTableByteCount += i11;
        }

        private boolean isStaticHeader(int i10) {
            return i10 >= 0 && i10 <= Hpack.STATIC_HEADER_TABLE.length - 1;
        }

        private int readByte() throws IOException {
            return this.source.readByte() & 255;
        }

        private void readIndexedHeader(int i10) throws IOException {
            if (isStaticHeader(i10)) {
                this.headerList.add(Hpack.STATIC_HEADER_TABLE[i10]);
                return;
            }
            int iDynamicTableIndex = dynamicTableIndex(i10 - Hpack.STATIC_HEADER_TABLE.length);
            if (iDynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (iDynamicTableIndex < headerArr.length) {
                    this.headerList.add(headerArr[iDynamicTableIndex]);
                    return;
                }
            }
            u.n(i10 + 1, "Header index too large ");
        }

        private void readLiteralHeaderWithIncrementalIndexingIndexedName(int i10) throws IOException {
            insertIntoDynamicTable(-1, new Header(getName(i10), readByteString()));
        }

        private void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            insertIntoDynamicTable(-1, new Header(Hpack.checkLowercase(readByteString()), readByteString()));
        }

        private void readLiteralHeaderWithoutIndexingIndexedName(int i10) throws IOException {
            this.headerList.add(new Header(getName(i10), readByteString()));
        }

        private void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            this.headerList.add(new Header(Hpack.checkLowercase(readByteString()), readByteString()));
        }

        public List<Header> getAndResetHeaderList() {
            ArrayList arrayList = new ArrayList(this.headerList);
            this.headerList.clear();
            return arrayList;
        }

        public int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        public ByteString readByteString() throws IOException {
            int i10 = readByte();
            boolean z9 = (i10 & 128) == 128;
            int i11 = readInt(i10, Hpack.PREFIX_7_BITS);
            return z9 ? ByteString.of(Huffman.get().decode(this.source.readByteArray(i11))) : this.source.readByteString(i11);
        }

        public void readHeaders() throws IOException {
            while (!this.source.exhausted()) {
                byte b10 = this.source.readByte();
                int i10 = b10 & 255;
                if (i10 == 128) {
                    com.google.gson.internal.a.m("index == 0");
                    return;
                }
                if ((b10 & 128) == 128) {
                    readIndexedHeader(readInt(i10, Hpack.PREFIX_7_BITS) - 1);
                } else if (i10 == 64) {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else if ((b10 & 64) == 64) {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(i10, 63) - 1);
                } else if ((b10 & 32) == 32) {
                    int i11 = readInt(i10, 31);
                    this.maxDynamicTableByteCount = i11;
                    if (i11 < 0 || i11 > this.headerTableSizeSetting) {
                        u.n(this.maxDynamicTableByteCount, "Invalid dynamic table size update ");
                        return;
                    }
                    adjustDynamicTableByteCount();
                } else if (i10 == 16 || i10 == 0) {
                    readLiteralHeaderWithoutIndexingNewName();
                } else {
                    readLiteralHeaderWithoutIndexingIndexedName(readInt(i10, 15) - 1);
                }
            }
        }

        public int readInt(int i10, int i11) throws IOException {
            int i12 = i10 & i11;
            if (i12 < i11) {
                return i12;
            }
            int i13 = 0;
            while (true) {
                int i14 = readByte();
                if ((i14 & 128) == 0) {
                    return i11 + (i14 << i13);
                }
                i11 += (i14 & Hpack.PREFIX_7_BITS) << i13;
                i13 += 7;
            }
        }

        public Reader(int i10, Source source) {
            this(i10, i10, source);
        }
    }
}
