package com.bignerdranch.androidboy.douban;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<Movie.SubjectsBean>mMovies;
    private String input;
    private final static String TAG="douban";
    private myAdapter mAdapter;
    private TextView mtitleTextview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //实例化recycle布局
        setContentView(R.layout.activity_main);
        mRecyclerView=findViewById(R.id.recycle_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


       mRecyclerView.setAdapter(mAdapter);
    }

    //创建recycleView的Adapter
    private class myAdapter extends RecyclerView.Adapter<movieHolder>{
        private List<Movie.SubjectsBean>mMovieList;



        public myAdapter(List<Movie.SubjectsBean>movies){
            mMovieList=movies;
        }

        @Override
        public movieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //实例化view
           LayoutInflater layoutInflater=LayoutInflater.from(MainActivity.this);

            return new movieHolder(layoutInflater,parent);

        }

        @Override
        public void onBindViewHolder(movieHolder holder, int position) {
            try {
                Movie.SubjectsBean movie = mMovieList.get(position);
                holder.bind(movie);

            }catch (IndexOutOfBoundsException e){
                Toast.makeText(MainActivity.this,"对不起，没有搜索到相关信息",Toast.LENGTH_SHORT).show();
            }
        }
        @Override
        public int getItemCount() {
            return 9;
        }
    }

    //创建recycleView的holder
    private class movieHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mCastsTextView;
        private TextView mGradeTextView;
        private ImageView mImageView;
        private Movie.SubjectsBean mBean;
        private String doubanUrl;

        public movieHolder(LayoutInflater inflater,ViewGroup parent ){
           super(inflater.inflate(R.layout.douban_list_view,parent,false));

            mtitleTextview=itemView.findViewById(R.id.movie_textView);
            mCastsTextView=itemView.findViewById(R.id.actor_textView);
            mGradeTextView=itemView.findViewById(R.id.grade_textView);
            mImageView=itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v){
            //Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(doubanUrl));
            Intent intent=webViewActivity.newIntent(MainActivity.this,doubanUrl);
            startActivity(intent);
        }

        public void bind(Movie.SubjectsBean Bean){
            mBean=Bean;
            String castString="主演：";
            mtitleTextview.setText(mBean.getTitle());
            List<Movie.SubjectsBean.CastsBean> casts=mBean.getCasts();
            for(int i=0;i<=2&&i+1<=casts.size();i++){
                castString+=casts.get(i).getName()+" ";
            }
            mCastsTextView.setText(castString);
            Movie.SubjectsBean.RatingBean rating=mBean.getRating();
            mGradeTextView.setText("评分："+rating.getAverage());

            //引用第三方库 异步 加载图片
            Picasso.with(MainActivity.this)
                    .load(mBean.getImages().getSmall())
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(mImageView);
             //获取网站Url
            doubanUrl=mBean.getAlt();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.douban_search_menu,menu);
        MenuItem item=menu.findItem(R.id.menu_item_search);
        final SearchView searchView=(SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                input=query;
                retrofitConnect();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }

    //创建第三方库的连接
    public void retrofitConnect(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //为retrofit添加一些okhttp配置，连接限制时间，读取时间，打印日志等
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(25, TimeUnit.SECONDS)
                .connectTimeout(25, TimeUnit.SECONDS)
                .writeTimeout(25,TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();


        //创建retrofit
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.douban.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        MovieInterface request=retrofit.create(MovieInterface.class);
        Call<Movie>call=request.getcall(input);

        //call的异步请求
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                try {
                    mMovies=response.body().getSubjects();
                    mAdapter=new myAdapter(mMovies);
                    mRecyclerView.setAdapter(mAdapter);
                }catch (NullPointerException e){
                    Toast.makeText(MainActivity.this,"没有搜寻到",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });



    }

}
