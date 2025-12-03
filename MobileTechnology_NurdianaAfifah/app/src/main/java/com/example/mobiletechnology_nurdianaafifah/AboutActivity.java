package com.example.mobiletechnology_nurdianaafifah;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar toolbar = findViewById(R.id.toolbarAbout);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("About");
        }

        Button homeBtn = findViewById(R.id.btnHomeAbout);
        Button aboutBtn = findViewById(R.id.btnAboutPage);

        homeBtn.setOnClickListener(v -> {
            startActivity(new Intent(AboutActivity.this, MainActivity.class));
        });

        aboutBtn.setOnClickListener(v -> {
        });

        TextView githubLink = findViewById(R.id.githubLink);
        githubLink.setOnClickListener(v -> {
            String url = "https://github.com/dianafifahh/Assignment-Diana.git";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
