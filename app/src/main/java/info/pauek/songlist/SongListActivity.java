package info.pauek.songlist;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SongListActivity extends AppCompatActivity {
    public static final int NEW_SONG = 0;
    private List<Song> songs;
    private RecyclerView song_list_view;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        songs = new ArrayList<>();
        songs.add(new Song("...And Justice For All"));

        adapter = new Adapter();

        song_list_view = findViewById(R.id.song_list_view);
        song_list_view.setLayoutManager(new LinearLayoutManager(this));
        song_list_view.setAdapter(adapter);
    }

    private void onClickSong(int position) {
        Toast.makeText(this, "Clicked '" + songs.get(position).getTitle() + "'", Toast.LENGTH_SHORT).show();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title_view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title_view = itemView.findViewById(R.id.title_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickSong(getAdapterPosition());
                }
            });
        }
    }

    class Adapter extends RecyclerView.Adapter<ViewHolder> {
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = getLayoutInflater().inflate(R.layout.song_item, parent, false);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
            holder.title_view.setText(songs.get(i).getTitle());
        }

        @Override
        public int getItemCount() {
            return songs.size();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.new_song_btn:
                Toast.makeText(this, "New Song has been clicked!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, SongEditActivity.class);
                startActivityForResult(intent, NEW_SONG);
                break;
        }
        return true;
    }
}
