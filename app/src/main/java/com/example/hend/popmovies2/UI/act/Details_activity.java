package com.example.hend.popmovies2.UI.act;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
 import com.example.hend.popmovies2.R;
import com.example.hend.popmovies2.UI.Adapters.trailersAdapter;
import com.example.hend.popmovies2.UI.API.TMDBinterface;
import com.squareup.picasso.Picasso;

import retrofit2.Retrofit;



public class Details_activity extends AppCompatActivity {

    public static String Base_URL = "http://api.themoviedb.org";

    ImageView ivposter;
    TextView date  , rating ,description , title;


    Retrofit retrofit;
    TMDBinterface moviesAPI;

    trailersAdapter trailersAdapter ;

    private RecyclerView rvtrailers;
    trailersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_activity);


        date =  findViewById(R.id.tvdate);
        description =  findViewById(R.id.tvoverview);
        rating =  findViewById(R.id.tvrating);
        title =  findViewById(R.id.tvtitle);
        ivposter =   findViewById(R.id.ivposter);

        date.setText(getIntent().getExtras().getString("release_date"));
        description.setText(getIntent().getExtras().getString("overview"));
        rating.setText(String.valueOf(getIntent().getExtras().getDouble("vote_average"))+"/10");
        title.setText(getIntent().getExtras().getString("title"));
        Picasso.with(Details_activity.this)
                .load("http://image.tmdb.org/t/p/w185/" + getIntent().getExtras().getString("poster_path"))
                .placeholder(R.color.colorAccent)
                .error(R.drawable.ic_launcher_background)
                .into(ivposter);

       // initViews();
    }

/*
    private void initViews() {
        ArrayList <Trailers> mTrailers = new ArrayList<>();
        trailersAdapter = new trailersAdapter(mTrailers ,this);

        rvtrailers = (RecyclerView) findViewById(R.id.rvtrailers);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvtrailers.setLayoutManager(mLayoutManager);
        rvtrailers.setAdapter(adapter);

        adapter.notifyDataSetChanged();
        rvtrailers.setHasFixedSize(true);

        loadTrailers();
        loadReviews();


    }

    public void loadTrailers() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        moviesAPI = retrofit.create(TMDBinterface.class);

        int  movie_id = getIntent().getExtras().getInt("movie_id");

        Call<TrailersResponse> trailersCall = moviesAPI.getMoviesVideos(movie_id , TMDBinterface.myApiKey);
        trailersCall.enqueue(new Callback<TrailersResponse>() {
            @Override
            public void onResponse(Call<TrailersResponse> call, Response<TrailersResponse> response) {
                List<Trailers> trailers = response.body().getVideoResults();
                RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rvtrailers);
                LinearLayout linearLayout = new LinearLayoutManager(getApplicationContext()LinearLayoutManager.VERTICAL, LinearLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(linearLayout);
                recyclerView.setAdapter(new trailersAdapter(trailers , getApplicationContext()));
                recyclerView.hasFixedSize();

            }

            @Override
            public void onFailure(Call<TrailersResponse> call, Throwable t) {

            }
        });


    }

    public void loadReviews(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        moviesAPI = retrofit.create(TMDBinterface.class);

        int  movie_id = getIntent().getExtras().getInt("movie_id");

        Call<Review> reviewCall = moviesAPI.getReview(movie_id , TMDBinterface.myApiKey);
        reviewCall.enqueue(new Callback<Review>() {
            @Override
            public void onResponse(Call<Review> call, Response<Review> response) {
                List<ReviewResponse> reviewResponses = response.body().getResults();
                ReviewAdapter reviewAdapter = new ReviewAdapter(this , reviewResponses);
                RecyclerView rvreviews = (RecyclerView)findViewById(R.id.rvreviews);
                LinearLayout linearLayout = new LinearLayoutManager(getApplicationContext()LinearLayoutManager.VERTICAL, LinearLayoutManager.VERTICAL, false);
                rvreviews.setLayoutManager(linearLayout);
                rvreviews.setAdapter(reviewAdapter);
                rvreviews.hasFixedSize();

            }

            @Override
            public void onFailure(Call<Review> call, Throwable t) {

            }
        });


    }
*/
 }
