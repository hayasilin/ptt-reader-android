package com.cracktheterm.pttreader;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String apiUrl = "https://disp.cc/api/hot_text.json";

    List<HotArticle> hotArticles = new ArrayList<>();

    ArrayAdapter adapter;

    // The Idling Resource which will be null in production.
    @Nullable private SimpleIdlingResource idlingResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new GetHotArticleAsyncTask().execute(apiUrl);

        ListView listview = (ListView) findViewById(R.id.listView);
        //ListView 要顯示的內容
        //android.R.layout.simple_list_item_1 為內建樣式，還有其他樣式可自行研究
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                hotArticles);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                intent.putExtra("hotArticle", hotArticles.get(i));
                startActivity(intent);
            }
        });
    }

    @VisibleForTesting
    @NonNull
    public IdlingResource getIdlingResource() {
        if (idlingResource == null) {
            idlingResource = new SimpleIdlingResource();
        }
        return idlingResource;
    }

    // get ptt hot article from server
    public class GetHotArticleAsyncTask extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            //before works
        }
        @Override
        protected String  doInBackground(String... params) {
            try {
                String hotArticleData;
                //define the url we have to connect with
                URL url = new URL(params[0]);
                //make connect with url and send request
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                //waiting for 7000ms for response
                urlConnection.setConnectTimeout(5000);//set timeout to 5 seconds

                try {
                    //getting the response data
                    InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
                    //convert the stream to string
                    hotArticleData = ConvertInputToStringNoChange(inputStream);
                    //send to display data
                    publishProgress(hotArticleData);
                } finally {
                    //end connection
                    urlConnection.disconnect();
                }

            }catch (Exception ex){}
            return null;
        }

        protected void onProgressUpdate(String... progress) {
            try {
                JSONObject json = new JSONObject(progress[0]);
                JSONArray lists = json.getJSONArray("list");

                for (int i = 0; i < lists.length(); i++) {
                    JSONObject data = lists.getJSONObject(i);

                    HotArticle article = new HotArticle();
                    article.hot_num = data.getString("hot_num");;
                    article.author = data.getString("author");;
                    article.title = data.getString("title");;
                    article.board_name = data.getString("board_name");;
                    article.desc = data.getString("desc");;
                    article.url = data.getString("url");;

                    hotArticles.add(article);
                }

                adapter.notifyDataSetChanged();

                idlingResource.setIdleState(true);

            } catch (Exception ex) {
                Log.e("error", "exception", ex);
            }
        }

        protected void onPostExecute(String  result2){
            // After works
        }
    }

    // This method convert any stream to string
    public static String ConvertInputToStringNoChange(InputStream inputStream) {
        BufferedReader bureader = new BufferedReader( new InputStreamReader(inputStream));
        String line ;
        String linereultcal="";

        try{
            while((line=bureader.readLine())!=null) {
                linereultcal+=line;
            }
            inputStream.close();
        }catch (Exception ex){}

        return linereultcal;
    }
}
