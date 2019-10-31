package com.amlzq.android.viewer.material;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.ContentLoadingProgressBar;

import java.lang.reflect.Field;

/**
 * 网页
 * 参考:
 * https://github.com/takahirom/webview-in-coordinatorlayout
 */
public class WebActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private WebView mWebView;
    private ContentLoadingProgressBar mProgressBar;

    public static Intent newIntent(Context context, String url) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra("params", url);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_material);

        mToolbar = findViewById(R.id.toolbar);
        mWebView = findViewById(R.id.web_view);
        mProgressBar = findViewById(R.id.progress_bar);

        setSupportActionBar(mToolbar);

//        WebSettings webSettings = mWebView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        webSettings.setAllowFileAccess(true);
//        webSettings.setSaveFormData(true);
//        // 开启缩放功能
//        webSettings.setSupportZoom(true);
//        webSettings.setBuiltInZoomControls(true);

//        // 适应内容大小
//        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
//        webSettings.setPluginState(WebSettings.PluginState.ON);
//        webSettings.setDomStorageEnabled(true);
//        webSettings.setUseWideViewPort(true);
//        webSettings.setLoadWithOverviewMode(true);
//        // 优先使用缓存
//        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
//        webSettings.setTextSize(WebSettings.TextSize.NORMAL);
//        webSettings.setDefaultFontSize(16);
//        webSettings.setDefaultFixedFontSize(13);
//        // 设置为true时，必须重写onCreateWindow
//        webSettings.setSupportMultipleWindows(true);
//        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
//        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
//            webSettings.setDisplayZoomControls(false);
//        } else {
//            setZoomControlGone(mWebView); // Android 3.0(11)
//        }
//
//        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
//        webSettings.setSavePassword(false);
//        webSettings.setMinimumFontSize(webSettings.getMinimumFontSize() + 8);
//        mWebView.setVerticalScrollbarOverlay(true);

        // 设置背景色
//        mWebView.setBackgroundColor(getColor(mBgColor));
//        mWebView.getBackground().setAlpha(0); // 设置填充透明度 范围：0-255

        // disable scroll on touch
//        mWebView.setOnTouchListener(new WebView.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return (event.getAction() == MotionEvent.ACTION_MOVE);
//            }
//        });
//        mWebView.setVerticalScrollBarEnabled(true);
//        mWebView.setHorizontalScrollBarEnabled(false);
////        mWebView.setScrollContainer(false);
//        mWebView.requestFocus();

//        // 文件下载
//        mWebView.setDownloadListener(new DownloadListener() {
//
//            @Override
//            public void onDownloadStart(String url, String userAgent, String contentDisposition,
//                                        String mimetype, long contentLength) {
//                // 调用系统内置浏览器下载文件
//                Uri uri = Uri.parse(url);
//                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                startActivity(intent);
//            }
//        });

        mWebView.setWebViewClient(mWebViewClient);
        mWebView.setWebChromeClient(mWebChromeClient);
        String url = getIntent().getStringExtra("params");
        mWebView.loadUrl(url);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (null != mWebView) mWebView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (null != mWebView) {
            mWebView.onPause();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (null != mWebView) {
            mWebView.getSettings().setBuiltInZoomControls(true);
            mWebView.setVisibility(View.GONE);
            ViewGroup contentView = (ViewGroup) getContentView();
            contentView.removeView(mWebView);
            mWebView.removeAllViews();
            mWebView.destroy();
            mWebView = null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.web_options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_refresh) {
            mWebView.reload();
        }
        return super.onOptionsItemSelected(item);
    }

    public View getContentView() {
        return findViewById(android.R.id.content);
    }

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        mToolbar.setTitle(title);
    }

    private WebViewClient mWebViewClient = new WebViewClient() {

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

        }
    };

    private WebChromeClient mWebChromeClient = new WebChromeClient() {

        @Override
        public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
            // Android5.0以上系统通过重写此方法实现多窗口
            WebView newWebView = new WebView(view.getContext());
            view.addView(newWebView);
            newWebView.setWebViewClient(new WebViewClient());
            newWebView.setWebChromeClient(this);
            WebView.WebViewTransport transport = (WebView.WebViewTransport) resultMsg.obj;
            transport.setWebView(newWebView);
            resultMsg.sendToTarget();
            return true;
            // return super.onCreateWindow(view, isDialog, isUserGesture, resultMsg);
        }

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            // 设置网页加载的进度条
            if (newProgress < 100 && mProgressBar.getVisibility() == ProgressBar.GONE) {
                mProgressBar.setVisibility(ProgressBar.VISIBLE);
            }
            mProgressBar.setProgress(newProgress);
            if (newProgress == 100) {
                mProgressBar.setVisibility(ProgressBar.GONE);
            }

            // 不推荐使用
            // setProgress(newProgress);
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            setTitle(title);
        }

        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            return super.onJsAlert(view, url, message, result);
        }

        @Override
        public boolean onJsBeforeUnload(WebView view, String url, String message, JsResult result) {
            return super.onJsBeforeUnload(view, url, message, result);
        }

        @Override
        public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
            return super.onJsConfirm(view, url, message, result);
        }

        @Override
        public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
            return super.onJsPrompt(view, url, message, defaultValue, result);
        }

        @Override
        public boolean onJsTimeout() {
            return super.onJsTimeout();
        }
    };

    private void setZoomControlGone(View view) {
        Class<WebView> classType;
        classType = WebView.class;
        android.widget.ZoomButtonsController mZoomButtonsController = new android.widget.ZoomButtonsController(view);
        mZoomButtonsController.getZoomControls().setVisibility(View.GONE);
        try {
            Field field = classType.getDeclaredField("mZoomButtonsController");
            field.setAccessible(true);
            field.set(view, mZoomButtonsController);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}
