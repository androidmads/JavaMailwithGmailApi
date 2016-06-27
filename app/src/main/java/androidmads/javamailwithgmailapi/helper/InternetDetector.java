package androidmads.javamailwithgmailapi.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class InternetDetector {

    private Context mcontext;

    public InternetDetector(Context context) {
        this.mcontext = context;
    }

    public boolean checkMobileInternetConn() {
        ConnectivityManager connectivity = (ConnectivityManager) mcontext
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivity != null) {
            NetworkInfo info1 = connectivity.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            NetworkInfo info2 = connectivity.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

            if (info1 != null && info2 != null) {
                if (info1.isConnected() || info2.isConnected()) {
                    return true;
                }
            }
        }
        return false;
    }
}