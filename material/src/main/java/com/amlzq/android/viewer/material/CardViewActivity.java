package com.amlzq.android.viewer.material;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * CardView
 * MaterialCardView
 */
public class CardViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        findViewById(R.id.card).setOnClickListener(v -> {
            Toast.makeText(v.getContext(), "click card", Toast.LENGTH_SHORT).show();
        });
    }

}
