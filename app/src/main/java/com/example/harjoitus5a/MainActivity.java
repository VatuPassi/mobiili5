package com.example.harjoitus5a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Uusifragment.IUusiFragment {

    Uusifragment instanssi1;
    Uusifragment instanssi2;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayoutti1, Uusifragment.newInstance()).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayoutti2, Uusifragment.newInstance()).commit();

        this.manager = getSupportFragmentManager();
        instanssi1 = (Uusifragment) this.manager.findFragmentById(R.id.frameLayoutti1);
        instanssi2 = (Uusifragment) this.manager.findFragmentById(R.id.frameLayoutti2);
    }

    @Override
    public void onButtonPressed(String txt, int id) {

        if (id == instanssi1.getId()) {

            instanssi2.AsetaTeksti(txt);
        } else {
            instanssi1.AsetaTeksti(txt);
        }

    }
}
