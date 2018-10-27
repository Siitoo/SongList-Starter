package info.pauek.songlist;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class SongEditActivity extends AppCompatActivity {

    EditText edit_year;
    EditText edit_title;
    EditText edit_band;
    int index = 0;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_edit);

        edit_year = findViewById(R.id.edit_year);


        Calendar calendar = new GregorianCalendar();
        int year = calendar.get(Calendar.YEAR);
        edit_title = findViewById(R.id.edit_song);
        edit_band = findViewById(R.id.edit_band);
        edit_year.setText(Integer.toString(year));

        Intent intent = getIntent();
        if (intent != null) {
            edit_title.setText(intent.getStringExtra("title"));
            edit_band.setText(intent.getStringExtra("band"));
            edit_year.setText(intent.getStringExtra("year"));
            index = intent.getIntExtra("index", -1);
        }
    }

    public void onMinusClick(View view) {
        if (!edit_year.getText().toString().equals("")) {
            int year = Integer.valueOf(edit_year.getText().toString());
            year--;
            edit_year.setText(Integer.toString(year));
        }
    }
    public void onPlusClick(View view) {
        if (!edit_year.getText().toString().equals("")) {
            int year = Integer.valueOf(edit_year.getText().toString());
            year++;
            edit_year.setText(Integer.toString(year));
        }
    }

    public void onSave(View view) {
        Intent data = new Intent();
        data.putExtra("title", edit_title.getText().toString());
        data.putExtra("band", edit_band.getText().toString());
        data.putExtra("year", edit_year.getText().toString());
        data.putExtra("index", index);
        setResult(RESULT_OK, data);
        finish();
    }
}
