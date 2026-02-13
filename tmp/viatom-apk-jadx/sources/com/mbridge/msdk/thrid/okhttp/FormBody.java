package com.mbridge.msdk.thrid.okhttp;

import androidx.browser.trusted.sharing.ShareTarget;
import androidx.window.layout.c;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.BufferedSink;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class FormBody extends RequestBody {
    private static final MediaType CONTENT_TYPE = MediaType.get(ShareTarget.ENCODING_TYPE_URL_ENCODED);
    private final List<String> encodedNames;
    private final List<String> encodedValues;

    public FormBody(List<String> list, List<String> list2) {
        this.encodedNames = Util.immutableList(list);
        this.encodedValues = Util.immutableList(list2);
    }

    private long writeOrCountBytes(BufferedSink bufferedSink, boolean z9) {
        Buffer buffer = z9 ? new Buffer() : bufferedSink.buffer();
        int size = this.encodedNames.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 > 0) {
                buffer.writeByte(38);
            }
            buffer.writeUtf8(this.encodedNames.get(i10));
            buffer.writeByte(61);
            buffer.writeUtf8(this.encodedValues.get(i10));
        }
        if (!z9) {
            return 0L;
        }
        long size2 = buffer.size();
        buffer.clear();
        return size2;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.RequestBody
    public long contentLength() {
        return writeOrCountBytes(null, true);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.RequestBody
    public MediaType contentType() {
        return CONTENT_TYPE;
    }

    public String encodedName(int i10) {
        return this.encodedNames.get(i10);
    }

    public String encodedValue(int i10) {
        return this.encodedValues.get(i10);
    }

    public String name(int i10) {
        return HttpUrl.percentDecode(encodedName(i10), true);
    }

    public int size() {
        return this.encodedNames.size();
    }

    public String value(int i10) {
        return HttpUrl.percentDecode(encodedValue(i10), true);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        writeOrCountBytes(bufferedSink, false);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Builder {
        private final Charset charset;
        private final List<String> names;
        private final List<String> values;

        public Builder(Charset charset) {
            this.names = new ArrayList();
            this.values = new ArrayList();
            this.charset = charset;
        }

        public Builder add(String str, String str2) {
            if (str == null) {
                c.k("name == null");
                return null;
            }
            if (str2 == null) {
                c.k("value == null");
                return null;
            }
            this.names.add(HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.charset));
            this.values.add(HttpUrl.canonicalize(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.charset));
            return this;
        }

        public Builder addEncoded(String str, String str2) {
            if (str == null) {
                c.k("name == null");
                return null;
            }
            if (str2 == null) {
                c.k("value == null");
                return null;
            }
            this.names.add(HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.charset));
            this.values.add(HttpUrl.canonicalize(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.charset));
            return this;
        }

        public FormBody build() {
            return new FormBody(this.names, this.values);
        }

        public Builder() {
            this(null);
        }
    }
}
