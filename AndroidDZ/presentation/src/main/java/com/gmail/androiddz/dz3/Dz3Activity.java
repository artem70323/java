package com.gmail.androiddz.dz3;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.gmail.androiddz.BuildConfig;
import com.gmail.androiddz.R;

public class Dz3Activity extends Activity {

    TextView textVieaw;
    EditText editText;
    private Button button;
    private SimpleDraweeView circleImage;

    private void findViews() {
        button = (Button) findViewById(R.id.buttonDZ3);
        circleImage = (SimpleDraweeView) findViewById(R.id.circleDZ3);
        textVieaw = (TextView) findViewById(R.id.textViewDZ3);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_dz3);
        findViews();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText = (EditText) findViewById(R.id.editTextDZ3);
                Uri imageUri = Uri.parse(editText.getText().toString());
                circleImage.setImageURI(imageUri);
                textVieaw.setText(BuildConfig.API_ENDPOINT);
            }
        });

    }
}
