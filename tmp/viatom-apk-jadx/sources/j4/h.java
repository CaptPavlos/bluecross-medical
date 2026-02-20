package j4;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import java.io.FileNotFoundException;
import java.io.InputStream;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h extends f0 {

    /* renamed from: b, reason: collision with root package name */
    public static final UriMatcher f9965b;

    /* renamed from: a, reason: collision with root package name */
    public final Context f9966a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f9965b = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "display_photo/#", 4);
    }

    public h(Context context) {
        this.f9966a = context;
    }

    @Override // j4.f0
    public final boolean b(c0 c0Var) {
        Uri uri = (Uri) c0Var.f9925b;
        return "content".equals(uri.getScheme()) && ContactsContract.Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && f9965b.match(uri) != -1;
    }

    @Override // j4.f0
    public final e0 e(c0 c0Var, int i10) throws FileNotFoundException {
        InputStream inputStreamOpenContactPhotoInputStream;
        ContentResolver contentResolver = this.f9966a.getContentResolver();
        Uri uriLookupContact = (Uri) c0Var.f9925b;
        int iMatch = f9965b.match(uriLookupContact);
        if (iMatch != 1) {
            if (iMatch != 2) {
                if (iMatch != 3) {
                    if (iMatch != 4) {
                        com.google.gson.internal.a.h(uriLookupContact, "Invalid uri: ");
                        return null;
                    }
                }
            }
            inputStreamOpenContactPhotoInputStream = contentResolver.openInputStream(uriLookupContact);
        } else {
            uriLookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uriLookupContact);
            inputStreamOpenContactPhotoInputStream = uriLookupContact == null ? null : ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uriLookupContact, true);
        }
        if (inputStreamOpenContactPhotoInputStream == null) {
            return null;
        }
        return new e0(t1.T(inputStreamOpenContactPhotoInputStream), 2);
    }
}
