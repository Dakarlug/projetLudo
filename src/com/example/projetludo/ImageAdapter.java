package com.example.projetludo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


/*package com.example.projetludo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
	private Context mContext;
    private Integer[] images;	
    ImageView imageView;
    LayoutInflater inflater;
    private final int casevide=0; 
    private final int pnoire=1; 
    private final int prouge=2;
	public ImageAdapter(MainActivity mainActivity, Integer[] images1) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.images.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return this.images[pnoire];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		View row;
		row= convertView;
				if(convertView == null){
		        	
		        	row = inflater.inflate(R.layout.elements,null);
	    }

				  imageView = (ImageView)row.findViewById(R.id.image1);
			        if (images[position]== casevide) {
			        	 imageView.setImageResource(R.drawable.cvide);
					}
			        else {
			        	  if (images[position]== prouge) {
			        		  imageView.setImageResource(R.drawable.prouge);
			      		}
			        	  else{
			        		  imageView.setImageResource(R.drawable.pnoir);
			        	  }
					}
			   	         return row;
		}
}*/



public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        //return mThumbIds.length;
    	return 20;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        //imageView.setImageResource(mThumbIds[position]);
        
        if (position !=2){
        	imageView.setImageResource(R.drawable.ic_launcher);
        }
        else {
        	imageView.setImageResource(R.drawable.prouge);
        	
        }
        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.ic_launcher ,
            R.drawable.cvide ,
            R.drawable.pnoir ,
            R.drawable.prouge ,
    };


}