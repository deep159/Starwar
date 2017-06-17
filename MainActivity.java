package com.example.hi.starwar;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> namearray;
    ArrayList<String> heightarray;
    ArrayList<String> massarray;
    ArrayList<String> haircolorarray;
    ProgressDialog dialog;
    ListView mCustomList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        namearray=new ArrayList<>();
        heightarray=new ArrayList<>();
        massarray=new ArrayList<>();
        haircolorarray=new ArrayList<>();
        mCustomList= (ListView) findViewById(R.id.mylist);
        new GetResponse().execute();
    }
    class GetResponse extends AsyncTask<Void,Void,Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setTitle("Loading...");
            dialog.setMessage("Please wait....");
            dialog.setCancelable(false);
            dialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            String url = "http://swapi.co/api/people/";
            String response = HitURL.urlReader(url);
            try {
                JSONObject outer_object=new JSONObject(response);
                JSONArray array=outer_object.getJSONArray("results");

                for (int i = 0; i < array.length(); i++) {
                    JSONObject inner_object=array.getJSONObject(i);
                    String name=inner_object.getString("name");
                    namearray.add(name);
                    String height = inner_object.getString("height");
                    heightarray.add(height);
                    String mass = inner_object.getString("mass");
                    massarray.add(mass);
                    String haircolor = inner_object.getString("hair_color");
                    haircolorarray.add(haircolor);


                    Log.e(">>>",name);
                   Log.e(">>>",height);
                    Log.e(">>>",mass);
                    Log.e(">>>",haircolor);
                }

            } catch (JSONException e) {
                e.printStackTrace();
                Log.e(">>>", e.toString());
            }

            //Log.e(">>>",response);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            myadapter adapter=new myadapter(MainActivity.this,namearray,heightarray,massarray,haircolorarray);
            mCustomList.setAdapter(adapter);
        }
    }}