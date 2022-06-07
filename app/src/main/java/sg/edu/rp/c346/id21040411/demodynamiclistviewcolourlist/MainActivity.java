package sg.edu.rp.c346.id21040411.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement, etIndexElement;
    Button btnAdd, btnRemove, btnUpdate;
    ListView lvColour;
    ArrayList<String> alColour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        etIndexElement = findViewById(R.id.editTextIndex);
        btnAdd = findViewById(R.id.btnAddItem);
        btnRemove = findViewById(R.id.btnRemoveItem);
        btnUpdate = findViewById(R.id.btnUpdateItem);
        lvColour = findViewById(R.id.listViewColour);

        alColour = new ArrayList<String>();
        alColour.add("Red");
        alColour.add("Orange");

        ArrayAdapter aaColour = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, alColour);

        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String colour = etElement.getText().toString();
                int position = Integer.parseInt(etIndexElement.getText().toString());
                alColour.add(position, colour);
                aaColour.notifyDataSetChanged();

            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = Integer.parseInt(etIndexElement.getText().toString());
                alColour.remove(position);
                aaColour.notifyDataSetChanged();

            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String colour = etElement.getText().toString();
                int position = Integer.parseInt(etIndexElement.getText().toString());

                alColour.set(position, colour);
                aaColour.notifyDataSetChanged();

            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if (i == 0) {
                    Toast.makeText(MainActivity.this, alColour.get(0) , Toast.LENGTH_SHORT).show();
                } else if (i == 1) {
                    Toast.makeText(MainActivity.this, alColour.get(1) , Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Invalid Colour" , Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}