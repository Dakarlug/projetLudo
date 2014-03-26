package com.example.projetludo;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	 private GridView gridview;
		private Integer[] images;
		private final int casevide=0; 
	    private final int pnoire=1; 
	    private final int prouge=2;
	    private Integer[] images1=new Integer[225];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		gridview=(GridView)findViewById(R.id.gridView);
	    gridview.setAdapter(new ImageAdapter(MainActivity.this));
//		for (int i = 0; i < 255; i++) {
//			if(i==0){
//				images1[i]=casevide;
//			}
//			else{
//				if(i%2==0){
//					images1[i]=prouge;
//				}
//				else{
//					images1[i]=pnoire;
//				}
//			}
//		}
		
//      gridview.setAdapter(new ImageAdapter(MainActivity.this, images1));
//
      gridview.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView parent, View v,
					int position, long id) {
				Toast.makeText(MainActivity.this, "" + position,
                      Toast.LENGTH_SHORT).show();
				// TODO Auto-generated method stub
				
			}
      });
      
      }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
