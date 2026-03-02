package v5;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.accounts.NetworkErrorException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import c1.w4;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.activities.LoginActivity;
import com.uptodown.services.AuthenticatorService;
import h5.c1;
import h5.e1;
import h5.p0;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends AbstractAccountAuthenticator {

    /* renamed from: a, reason: collision with root package name */
    public final AuthenticatorService f13140a;

    public d(AuthenticatorService authenticatorService) {
        super(authenticatorService);
        this.f13140a = authenticatorService;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public final Bundle addAccount(AccountAuthenticatorResponse accountAuthenticatorResponse, String str, String str2, String[] strArr, Bundle bundle) {
        Intent intent = new Intent(this.f13140a, (Class<?>) LoginActivity.class);
        intent.putExtra("accountAuthenticatorResponse", accountAuthenticatorResponse);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("intent", intent);
        return bundle2;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public final Bundle confirmCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, Bundle bundle) {
        accountAuthenticatorResponse.getClass();
        account.getClass();
        bundle.getClass();
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public final Bundle editProperties(AccountAuthenticatorResponse accountAuthenticatorResponse, String str) {
        accountAuthenticatorResponse.getClass();
        str.getClass();
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public final Bundle getAccountRemovalAllowed(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account) throws NetworkErrorException {
        accountAuthenticatorResponse.getClass();
        account.getClass();
        Bundle accountRemovalAllowed = super.getAccountRemovalAllowed(accountAuthenticatorResponse, account);
        if (accountRemovalAllowed != null && accountRemovalAllowed.containsKey("booleanResult") && !accountRemovalAllowed.containsKey("intent") && accountRemovalAllowed.getBoolean("booleanResult")) {
            c1.c(this.f13140a);
        }
        accountRemovalAllowed.getClass();
        return accountRemovalAllowed;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public final Bundle getAuthToken(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
        String password;
        JSONObject jSONObject;
        JSONObject jSONObjectOptJSONObject;
        accountAuthenticatorResponse.getClass();
        account.getClass();
        str.getClass();
        bundle.getClass();
        AuthenticatorService authenticatorService = this.f13140a;
        AccountManager accountManager = AccountManager.get(authenticatorService);
        String strPeekAuthToken = accountManager.peekAuthToken(account, str);
        if (TextUtils.isEmpty(strPeekAuthToken) && (password = accountManager.getPassword(account)) != null) {
            String str2 = account.name;
            str2.getClass();
            p0 p0VarH = new w4(authenticatorService, 4, false).H(str2, password);
            if (!p0VarH.b() && (jSONObject = p0VarH.f8699d) != null && (jSONObjectOptJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA)) != null) {
                e1 e1Var = new e1();
                e1Var.b(authenticatorService, jSONObjectOptJSONObject);
                String str3 = e1Var.f8512a;
                if (str3 != null && str3.length() > 0) {
                    e1Var.e(authenticatorService);
                }
                String string = null;
                try {
                    SharedPreferences sharedPreferences = authenticatorService.getSharedPreferences("SettingsPreferences", 0);
                    if (sharedPreferences.contains("UTOKEN")) {
                        string = sharedPreferences.getString("UTOKEN", null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (string == null || string.length() == 0) {
                    c1.c(authenticatorService);
                }
            }
        }
        if (TextUtils.isEmpty(strPeekAuthToken)) {
            Intent intent = new Intent(authenticatorService, (Class<?>) LoginActivity.class);
            intent.putExtra("accountAuthenticatorResponse", accountAuthenticatorResponse);
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("intent", intent);
            return bundle2;
        }
        Bundle bundle3 = new Bundle();
        bundle3.putString("authAccount", account.name);
        bundle3.putString("accountType", account.type);
        bundle3.putString("authtoken", strPeekAuthToken);
        return bundle3;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public final String getAuthTokenLabel(String str) {
        str.getClass();
        return "Uptodown login";
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public final Bundle hasFeatures(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String[] strArr) {
        accountAuthenticatorResponse.getClass();
        account.getClass();
        strArr.getClass();
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public final Bundle updateCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
        accountAuthenticatorResponse.getClass();
        account.getClass();
        str.getClass();
        bundle.getClass();
        return null;
    }
}
