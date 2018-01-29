package com.bignerdranch.androidboy.photogallery;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by androidboy on 18-1-29.
 */

public class PhotoGalleryFragment extends Fragment {
    private RecyclerView mPhotoRecycleView;
    private static final String TAG="PhotoGalleryFragment";
    private List<GalleryItem>mItems=new ArrayList<>();



    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        new FetchItemsTask().execute();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View v=inflater.inflate(R.layout.fragment_photo_gallery,container,false);

        mPhotoRecycleView=v.findViewById(R.id.photo_recycler_view);
        mPhotoRecycleView.setLayoutManager(new GridLayoutManager(getActivity(),3));

        return v;
    }

    private class FetchItemsTask extends AsyncTask<Void,Void,List<GalleryItem>>{

        protected List<GalleryItem> doInBackground(Void...params){
          return new FlickrFetchr().fetchItems();
        }

        protected void onPostExecute(List<GalleryItem> items){
            mItems=items;
            setupAdapter();
        }
    }

    private class PhotoHolder extends RecyclerView.ViewHolder{
        private TextView mtitleTextView;

        public PhotoHolder(View itemView){
            super(itemView);

            mtitleTextView=(TextView)itemView;
        }

        public void bindGalleryItem(GalleryItem item){
            mtitleTextView.setText(item.toString());
        }
    }

    private class PhoteAdapter extends RecyclerView.Adapter<PhotoHolder>{
        private List<GalleryItem> mGalleryItems;

        public PhoteAdapter(List<GalleryItem>galleryItems){
            mGalleryItems=galleryItems;
        }

        @Override
        public PhotoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            TextView textView=new TextView(getActivity());
            return new PhotoHolder(textView);
        }

        @Override
        public void onBindViewHolder(PhotoHolder holder, int position) {
            GalleryItem galleryItem=mGalleryItems.get(position);
            holder.bindGalleryItem(galleryItem);

        }

        @Override
        public int getItemCount() {
            return mGalleryItems.size();
        }

        }

    public void setupAdapter(){
        if(isAdded()){
            mPhotoRecycleView.setAdapter(new PhoteAdapter(mItems));
        }
    }
    }

