package ph.url.romil93.youtubebackground;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mWebView = new WebView(this);

        setContentView(mWebView);

        mWebView.getSettings().setJavaScriptEnabled(true); // enable javascript
        mWebView.getSettings().setAppCacheEnabled(false);
        mWebView.setInitialScale(1);
        mWebView.getSettings().setPluginState(WebSettings.PluginState.ON);

        WebSettings webSettings = mWebView.getSettings();

        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setUseWideViewPort(true);

        mWebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }
        });

        mWebView.setWebChromeClient(new WebChromeClient(){});

        webSettings.setDomStorageEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setAppCachePath(getApplicationContext().getFilesDir().getAbsolutePath() + "/cache");

        webSettings.setDatabaseEnabled(true);
        webSettings.setDatabasePath(getApplicationContext().getFilesDir().getAbsolutePath() + "/databases");

        mWebView.loadUrl("http://www.youtube.com");
    }

    @Override
    protected void onResume() {
        super.onResume();
        try
        {
            mWebView.onResume();
        }
        catch ( Exception  e )
        {
            Log.d("Exception", e.toString());
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

    }
}
