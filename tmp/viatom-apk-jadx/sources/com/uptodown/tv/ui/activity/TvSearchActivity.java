package com.uptodown.tv.ui.activity;

import android.os.Bundle;
import android.speech.SpeechRecognizer;
import com.uptodown.R;
import r5.b;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class TvSearchActivity extends b {

    /* renamed from: b, reason: collision with root package name */
    public SpeechRecognizer f6692b;

    @Override // r5.b, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tv_search_activity);
        if (SpeechRecognizer.isRecognitionAvailable(this)) {
            this.f6692b = SpeechRecognizer.createSpeechRecognizer(this);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        if (this.f6692b != null && SpeechRecognizer.isRecognitionAvailable(this)) {
            SpeechRecognizer speechRecognizer = this.f6692b;
            speechRecognizer.getClass();
            speechRecognizer.stopListening();
            SpeechRecognizer speechRecognizer2 = this.f6692b;
            speechRecognizer2.getClass();
            speechRecognizer2.cancel();
            SpeechRecognizer speechRecognizer3 = this.f6692b;
            speechRecognizer3.getClass();
            speechRecognizer3.destroy();
        }
        this.f6692b = null;
        super.onPause();
    }
}
