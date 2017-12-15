package com.example.trafalgar.dota2league;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;

        import com.google.gson.Gson;
        import com.google.gson.GsonBuilder;
        import com.loopj.android.http.AsyncHttpClient;
        import com.loopj.android.http.TextHttpResponseHandler;

        import com.example.trafalgar.dota2league.model.League;

        import java.util.ArrayList;

        import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    ListView listViewLeague;
    ArrayList<League> listLeagues = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewLeague = findViewById(R.id.list_view_leagues);

        final ArrayAdapter<League> adapter = new ArrayAdapter<League>(
                this,
                R.layout.list_item_league,
                R.id.text_view_league,
                listLeagues
        );

        listViewLeague.setAdapter(adapter);

        listViewLeague.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detailIntent = new Intent(
                        MainActivity.this,
                        DetailActivity.class);
                detailIntent.putExtra("league", listLeagues.get(position));
                startActivity(detailIntent);
            }
        });

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://api.opendota.com/api/leagues",
                new TextHttpResponseHandler() {
                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        Log.e("MainActivity", "Error--");
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String responseString) {
                        Log.d("MainActivity", "OK->Response:" + responseString);
                        Gson gson = new GsonBuilder().create();
                        League[] leagues = gson.fromJson(responseString, League[].class);
                        adapter.clear();
                        for (League league : leagues) {
                            adapter.add(league);
                        }
                    }
                });
    }


}