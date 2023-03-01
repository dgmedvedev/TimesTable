package demo.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listViewNumbers;
    private SeekBar seekBar;

    private ArrayList<Integer> numbers;
    private int max = 20;   // - max значение SeekBar
    private int min = 1;    // - min значение SeekBar
    private int count = 10; // - количество элементов, выводимых в ListView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewNumbers = findViewById(R.id.listViewNumbers);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(max);

        numbers = new ArrayList<>();
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1, numbers);
        listViewNumbers.setAdapter(arrayAdapter);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override // вызывается, когда изменен прогресс на SeekBar
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                numbers.clear();
                for (int i = min; i <= count; i++) {
                    numbers.add(progress * i);
                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override // когда только начали двигать кружок
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override // когда отпустили кружок
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar.setProgress(10);
    }
}