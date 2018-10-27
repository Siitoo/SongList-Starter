package info.pauek.songlist;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class SongEditActivity extends AppCompatActivity {

    EditText edit_year;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_edit);

        edit_year = findViewById(R.id.edit_year);


        Calendar calendar = new GregorianCalendar();
        int year = calendar.get(Calendar.YEAR);
        edit_year.setText(Integer.toString(year));
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
}
