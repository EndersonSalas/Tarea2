package com.example.tarea2;

import android.bluetooth.BluetoothAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final BluetoothAdapter BLUETOOTH_ADAPTER = BluetoothAdapter.getDefaultAdapter();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mButtonTurnOn = (Button) findViewById(R.id.button_turnOn);
        Button mButtonTurnOff = (Button) findViewById(R.id.button_turnOff);

        mButtonTurnOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!BLUETOOTH_ADAPTER.isEnabled()){
                    BLUETOOTH_ADAPTER.enable();
                    seTextHistory(getResources().getString(R.string.bluetooth_turn_on)+"");
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.bluetooth_turn_on), Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(getApplicationContext(), R.string.already_enable, Toast.LENGTH_SHORT).show();
                }
            }
        });

        mButtonTurnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(BLUETOOTH_ADAPTER.isEnabled()){
                    BLUETOOTH_ADAPTER.disable();
                    seTextHistory(getResources().getString(R.string.bluetooth_turn_off)+"");
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.bluetooth_turn_off), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), R.string.already_disable, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void seTextHistory(String value){
        TextView mTextViewHistory = (TextView) findViewById(R.id.textView_history);
        mTextViewHistory.setText(mTextViewHistory.getText()+"\n"+value);
    }
}
