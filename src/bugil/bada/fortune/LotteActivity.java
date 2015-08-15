package bugil.bada.fortune;


import bugil.bada.fortune.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class LotteActivity extends Activity implements OnClickListener{
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lotte_main);
        
        findViewById(R.id.button1).setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.button1:
			Intent startcookie = new Intent(LotteActivity.this, CookieStart.class);
            startActivity(startcookie);
            break;
		}
		finish();
	}
}
