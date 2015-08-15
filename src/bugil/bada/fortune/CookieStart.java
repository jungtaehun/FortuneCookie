package bugil.bada.fortune;

import java.util.List;
import java.util.Random;

import bugil.bada.fortune.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class CookieStart extends Activity implements OnClickListener{
	int x;
	Random rand;
	String[] Fortune;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookie_start);
        Fortune = getResources().getStringArray(R.array.fortune);
        findViewById(R.id.btncookie).setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
				
		Random rand = new Random();
		x = rand.nextInt(100);
		
		switch(v.getId()){
		case R.id.btncookie:
			new AlertDialog.Builder(this)
			.setIcon(R.drawable.cookie_s)
			.setTitle("�룷異섏퓼�궎 寃곌낵�뒗!!!")
			.setMessage(Fortune[x])
			.setPositiveButton("怨듭쑀�븯湲�", new DialogInterface.OnClickListener() {			
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Intent it = new Intent(android.content.Intent.ACTION_SEND);
					it.setType("text/plain");
					it.putExtra(Intent.EXTRA_TITLE, "[�떦�떊�쓽 �룷異섏퓼�궎�뒗?]");
					it.putExtra(Intent.EXTRA_SUBJECT, "[�떦�떊�쓽 �룷異섏퓼�궎�뒗?]");
					it.putExtra(Intent.EXTRA_TEXT, Fortune[x]);
					 /**final PackageManager pm = getPackageManager();
				        final List<ResolveInfo> matches = pm.queryIntentActivities(it, 0);
				        ResolveInfo best = null;
				        for (final ResolveInfo info : matches)
				            if (info.activityInfo.packageName.endsWith(".talk") ||
				                    info.activityInfo.name.toLowerCase().contains("kakao")) best = info;
				                if (best != null)
				                    it.setClassName(best.activityInfo.packageName, best.activityInfo.name);**/
				                startActivity(it);
				}
			})
			.setNegativeButton("�븯猷⑤�� �떆�옉�븯湲�!", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					finish();
				}
			})
			.show();
			break;
		}
	}
}