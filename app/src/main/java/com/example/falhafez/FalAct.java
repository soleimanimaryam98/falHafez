package com.example.falhafez;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class FalAct extends AppCompatActivity implements View.OnClickListener{
    TextView txtback,txtagain,txtNumberfal,txtFal;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fal);

        // شناسایی متغیر ها
        txtback=findViewById(R.id.txtback);
        txtagain=findViewById(R.id.txtagain);
        txtNumberfal=findViewById(R.id.txtNumberfal);
        txtFal=findViewById(R.id.txtFal);

        txtback.setOnClickListener(this);
        txtagain.setOnClickListener(this);

        // فراخوانی متد برای گرفتن فال
        Fal();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.txtback:
            {
                // رفتن به اکتیویتی قبلی
                startActivity(new Intent(this,MainActivity.class));
                break;
            }
            case R.id.txtagain:
            {
                Fal();
                break;
            }
        }
    }

    // متد برای گرفتن فال
    public void Fal()
    {
        progressDialog = new ProgressDialog(this, R.style.MyTheme);
        progressDialog.show();

        // ارسال درخواست و دریافت اطلاعات
        StringRequest request = new StringRequest
                (Request.Method.GET, Config.LinkFal, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {
                        showFalAct(response);
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(FalAct.this, error + "", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    // نحوه نمایش اطلاعات داخل تکس ویو
    public void showFalAct (String fal)
    {
        String response = fal;
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

        try
        {
            ModelFal modelFalList = mapper.readValue(response, new TypeReference<ModelFal>() {});

            txtNumberfal.setText(modelFalList.getFullTitle());
            txtFal.setText(modelFalList.getPlainText());
        }
        catch (JsonProcessingException e)
        {

        }

    }


}