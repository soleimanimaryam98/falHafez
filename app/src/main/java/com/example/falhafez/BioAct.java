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
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class BioAct extends AppCompatActivity implements View.OnClickListener {

    ProgressDialog progressDialog;
    TextView txtback;
    RecyclerView lstBio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio);


        //سناسایی لیست ویو و دکمه ها
        lstBio=findViewById(R.id.lstBio);
        txtback=findViewById(R.id.txtback);
        txtback.setOnClickListener(this);

        // فراخوانی متد برای نمایش بیوگرافی شاعرها
        biografi();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.txtback:
            {
                startActivity(new Intent(this,MainActivity.class));
                break;
            }
        }
    }

    // متد برای ارسال درخواست به سرور ونمایش اطلاعات شاعران
    void biografi()
    {
        progressDialog = new ProgressDialog(this, R.style.MyTheme);
        progressDialog.show();






        // کد ارسال درخواست به سمت سرور
        StringRequest request = new StringRequest
                (Request.Method.GET, Config.LinkBio, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {
                        // اگر درخواست به درستی ارسال شد اطلاعات در متغیر response  ذخیره میشود و سپس با فراخوانی متد show bio اطلاعات را نمایش میدهیم
                        showBio(response);
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(BioAct.this, error + "", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    // متد برای نحوه نمایش اطلاعات
    public void showBio(String bio)
    {
        String response = bio;
        ObjectMapper mapper = new ObjectMapper();
        try {
            // تبدیل رشته به صورت ارایه
            List<ModelBio> list = mapper.readValue(response, new TypeReference<List<ModelBio>>() {});
            AdapterBio adapter = new AdapterBio(this, list);
            lstBio.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            lstBio.setItemAnimator(new DefaultItemAnimator());
            lstBio.setAdapter(adapter);
        }
        catch (JsonProcessingException e)
        {

        }
    }
}