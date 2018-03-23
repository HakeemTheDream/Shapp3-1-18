package com.qnally.shappapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by hakee on 3/23/2018.
 */

public class HelpPage extends AppCompatActivity {

    EditText editTextHelp;
    Button getHelpButton,faqButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        editTextHelp= (EditText)findViewById(R.id.help_form);

        getHelpButton=(Button)findViewById(R.id.getHelpButton);
        faqButton= (Button)findViewById(R.id.faq_button);

       // getHelpButton.setOnClickListener(View.OnClickListener
    }
}
