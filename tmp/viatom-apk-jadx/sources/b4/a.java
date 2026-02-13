package b4;

import a3.x;
import a4.f;
import android.os.AsyncTask;

/* loaded from: classes3.dex */
public abstract class a extends AsyncTask {

    /* renamed from: a, reason: collision with root package name */
    public x f838a;

    /* renamed from: b, reason: collision with root package name */
    public final f f839b;

    public a(f fVar) {
        this.f839b = fVar;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        x xVar = this.f838a;
        if (xVar != null) {
            xVar.f183d = null;
            xVar.l();
        }
    }
}
