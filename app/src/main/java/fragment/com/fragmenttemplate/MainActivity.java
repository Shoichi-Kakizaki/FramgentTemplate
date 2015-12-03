package fragment.com.fragmenttemplate;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity implements FTemplate.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void backBrowserTransaction() {
        Log.d("Activty", "通知ｷﾀ━━━━(ﾟ∀ﾟ)━━━━!!");
    }
}
