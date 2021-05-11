package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.File;
import java.lang.annotation.ElementType;

public class CharacterInfo extends AppCompatActivity {
    private ToggleButton likeButton;
    private TextView characterName;
    private TextView gender;
    private TextView hairColor;
    private TextView eyeColor;
    private TextView cast;
    private TextView status;
    private ImageView image;
    private TextView about;
    private TextView background;
    private ImageView shareBtn;
    private Uri imageUri;
    SharedPreferences preferences;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollview_sam);

        likeButton = findViewById(R.id.like);
        characterName = findViewById(R.id.name_scrollview);
        gender = findViewById(R.id.gender);
        hairColor = findViewById(R.id.hairColor);
        eyeColor = findViewById(R.id.eyeColor);
        cast = findViewById(R.id.cast);
        status = findViewById(R.id.status);
        image = findViewById(R.id.characterImage);
        shareBtn = findViewById(R.id.shareBtn);
        about = findViewById(R.id.text_about);
        background = findViewById(R.id.text_background);

        likeButton();
        shareInfo();
        settingNamesAndGender();
        setCharactedDetails();
        //Preserve the state of like button for each character

    }


    public void settingNamesAndGender(){
        Bundle bundle = getIntent().getExtras();

        name = bundle.getString("name");
        int im = bundle.getInt("image",1);

        characterName.setText(name);
        image.setImageResource(im);

        if(name.startsWith("F") || name.startsWith("M") ||  name.startsWith("A") || name.startsWith("L")){
            gender.setText(R.string.gender_female);
        } else{
            gender.setText(R.string.gender_male);
        }
    }


    public void likeButton(){
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        preferences = getPreferences(MODE_PRIVATE);
        boolean tgpref = preferences.getBoolean(name, false);  //default is true

        likeButton.setChecked(tgpref);
        int uniHearth = 0x1F496;
        int uniBrokenHearth =  0x1F494;
        String hearth = new String(Character.toChars(uniHearth));
        String brokenHearth = new String(Character.toChars(uniBrokenHearth));


        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean(name,likeButton.isChecked());

                if (null != likeButton && likeButton.isChecked()){
                    Toast.makeText(getApplicationContext(), name + " liked!" + hearth, Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(getApplicationContext(), name + " disliked" + brokenHearth, Toast.LENGTH_SHORT).show();
                }

                editor.apply();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        likeButton.setChecked(preferences.getBoolean(name,false));
    }

    public void shareInfo(){

        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getIntent().getExtras();
                String name = bundle.getString("name");

                switch (name) {
                    case "Fragile":
                        characterShare(getResources().getString(R.string.background_fragile), getResources().getString(R.string.name_fragile));
                        break;
                    case "Sam":
                        characterShare(getResources().getString(R.string.background_sam1), getResources().getString(R.string.name_sam));
                        break;
                    case "Deadman":
                        characterShare(getResources().getString(R.string.background_deadman), getResources().getString(R.string.name_deadman));
                        break;
                    case "Mama":
                        characterShare(getResources().getString(R.string.background_mama), getResources().getString(R.string.name_mama));
                    case "Higgs":
                        characterShare(getResources().getString(R.string.background_higgs), getResources().getString(R.string.name_higgs));
                    case "Diehardman":
                        characterShare(getResources().getString(R.string.background_diehardman), getResources().getString(R.string.name_diehardman));
                    case "Amelie":
                        characterShare(getResources().getString(R.string.background_amelie), getResources().getString(R.string.name_amelie));
                    case "Cliff":
                        characterShare(getResources().getString(R.string.background_cliff), getResources().getString(R.string.name_cliff));
                    case "Lockne":
                        characterShare(getResources().getString(R.string.background_lockne), getResources().getString(R.string.name_lockne));
                    case "Hearthman":
                        characterShare(getResources().getString(R.string.background_hearthman), getResources().getString(R.string.name_hearthman));

                }


            }
        });


    }

    public void setCharactedDetails(){
        characterInfoSet(getResources().getString(R.string.color_brown), getResources().getString(R.string.color_blue), getResources().getString(R.string.status_alive),getResources().getString(R.string.cast_norman),getResources().getString(R.string.background_sam1),getResources().getString(R.string.about_sam),getResources().getString(R.string.name_sam));
        characterInfoSet(getResources().getString(R.string.color_blonde), getResources().getString(R.string.color_blue), getResources().getString(R.string.status_alive),getResources().getString(R.string.cast_fragile),getResources().getString(R.string.background_fragile),getResources().getString(R.string.about_fragile),getResources().getString(R.string.name_fragile));
        characterInfoSet(getResources().getString(R.string.color_brown), getResources().getString(R.string.color_blue), getResources().getString(R.string.status_alive),getResources().getString(R.string.cast_deadman),getResources().getString(R.string.background_deadman),getResources().getString(R.string.about_deadman),getResources().getString(R.string.name_deadman));
        characterInfoSet(getResources().getString(R.string.color_brown), getResources().getString(R.string.color_blue), getResources().getString(R.string.status_dead),getResources().getString(R.string.cast_mama),getResources().getString(R.string.background_mama),getResources().getString(R.string.about_mama),getResources().getString(R.string.name_mama));
        characterInfoSet(getResources().getString(R.string.color_brown), getResources().getString(R.string.color_blue), getResources().getString(R.string.status_unknown),getResources().getString(R.string.cast_higgs),getResources().getString(R.string.background_higgs),getResources().getString(R.string.about_higgs),getResources().getString(R.string.name_higgs));
        characterInfoSet(getResources().getString(R.string.color_black), getResources().getString(R.string.color_brown), getResources().getString(R.string.status_alive),getResources().getString(R.string.cast_diehardman),getResources().getString(R.string.background_diehardman),getResources().getString(R.string.about_diehardman),getResources().getString(R.string.name_diehardman));
        characterInfoSet(getResources().getString(R.string.color_blonde), getResources().getString(R.string.color_blue), getResources().getString(R.string.status_unknown),getResources().getString(R.string.cast_amelie),getResources().getString(R.string.background_diehardman),getResources().getString(R.string.about_amelie),getResources().getString(R.string.name_amelie));
        characterInfoSet(getResources().getString(R.string.color_brown), getResources().getString(R.string.color_brown), getResources().getString(R.string.status_dead),getResources().getString(R.string.cast_cliff),getResources().getString(R.string.background_cliff),getResources().getString(R.string.about_cliff),getResources().getString(R.string.name_cliff));
        characterInfoSet(getResources().getString(R.string.color_brown), getResources().getString(R.string.color_brown), getResources().getString(R.string.status_dead),getResources().getString(R.string.cast_cliff),getResources().getString(R.string.background_cliff),getResources().getString(R.string.about_cliff),getResources().getString(R.string.name_cliff));
        characterInfoSet(getResources().getString(R.string.color_brown), getResources().getString(R.string.color_hazel), getResources().getString(R.string.status_dead),getResources().getString(R.string.cast_mama),getResources().getString(R.string.background_lockne),getResources().getString(R.string.about_lockne),getResources().getString(R.string.name_lockne));
        characterInfoSet(getResources().getString(R.string.color_brown), getResources().getString(R.string.color_brown), getResources().getString(R.string.status_alive),getResources().getString(R.string.cast_hearthman),getResources().getString(R.string.background_hearthman),getResources().getString(R.string.about_hearthman),getResources().getString(R.string.name_hearthman));


    }

    public void characterInfoSet(String hairclr, String eyeClr, String stts, String cst, String bg, String abt, String characterName){
        Bundle bundle = getIntent().getExtras();
        String bundleName = bundle.getString("name");
        if(bundleName.equals(characterName)){
            hairColor.setText(hairclr);
            eyeColor.setText(eyeClr);
            status.setText(stts);
            cast.setText(cst);
            background.setText(bg);
            about.setText(abt);
        }
    }



    public void characterShare(String background, String header){
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        Uri imageUri = Uri.parse("android.resource://" + getPackageName()
                + "/drawable/" + name.toLowerCase());

        Intent togetherIntent = new Intent();

        togetherIntent.setAction(Intent.ACTION_SEND);
        togetherIntent.putExtra(Intent.EXTRA_SUBJECT,header); // subject
        togetherIntent.putExtra(Intent.EXTRA_STREAM,imageUri); // image
        togetherIntent.putExtra(Intent.EXTRA_TEXT, background); // body of the message
        togetherIntent.setType("image/jpeg");
        togetherIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(Intent.createChooser(togetherIntent, "send"));
    }









}