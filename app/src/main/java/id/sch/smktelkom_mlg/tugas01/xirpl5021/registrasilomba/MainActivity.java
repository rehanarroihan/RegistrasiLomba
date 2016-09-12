package id.sch.smktelkom_mlg.tugas01.xirpl5021.registrasilomba;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    EditText etDepan, etBlkng;
    RadioButton rbLaki, rbPR;
    Spinner spUmur;
    CheckBox cbPP, cbBK, cbV, cbFS, cbC, cbMK;
    Button bOK;
    TextView tvLM, tvHasil, tvHasil2, tvHasil3, tvHasil4;
    int lomba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDepan = (EditText) findViewById(R.id.editTextDepan);
        etBlkng = (EditText) findViewById(R.id.editTextBlkng);
        rbLaki = (RadioButton) findViewById(R.id.radioButtonLK);
        rbPR = (RadioButton) findViewById(R.id.radioButtonPR);
        spUmur = (Spinner) findViewById(R.id.spinnerUmur);
        cbPP = (CheckBox) findViewById(R.id.checkBoxPP);
        cbBK = (CheckBox) findViewById(R.id.checkBoxBK);
        cbV = (CheckBox) findViewById(R.id.checkBoxV);
        cbFS = (CheckBox) findViewById(R.id.checkBoxFS);
        cbC = (CheckBox) findViewById(R.id.checkBoxC);
        cbMK = (CheckBox) findViewById(R.id.checkBoxMK);
        bOK = (Button) findViewById(R.id.buttonOK);
        tvLM = (TextView) findViewById(R.id.textViewLM);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvHasil2 = (TextView) findViewById(R.id.textViewHasil2);
        tvHasil3 = (TextView) findViewById(R.id.textViewHasil3);
        tvHasil4 = (TextView) findViewById(R.id.textViewHasil4);

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickME();
            }
        });

        //Start : Check Lomba
        cbPP.setOnCheckedChangeListener(this);
        cbBK.setOnCheckedChangeListener(this);
        cbV.setOnCheckedChangeListener(this);
        cbFS.setOnCheckedChangeListener(this);
        cbC.setOnCheckedChangeListener(this);
        cbMK.setOnCheckedChangeListener(this);
        //End : Check Lomba

    }

    private void clickME() {
        //Start : Nama
        if (isValid()) ;
        {
            String dpn = etDepan.getText().toString();
            String blkng = etBlkng.getText().toString();
            tvHasil.setText("Nama :\n" + dpn + " " + blkng);
        }
        //End : Nama

        //Start : Jenis Kelamin
        String jns = null;
        if (rbLaki.isChecked()) {
            jns = rbLaki.getText().toString();
        } else if (rbPR.isChecked()) {
            jns = rbPR.getText().toString();
        }
        if (jns == null) {
            tvHasil2.setText("Jenis Kelamin :\nBelum Dipilih");
        } else {
            tvHasil2.setText("Jenis Kelamin :\n" + jns);
        }
        //End : Jenis Kelamin

        //Start : Umur
        tvHasil3.setText("Umur :\n " + spUmur.getSelectedItem().toString());
        //End : Umur

        //Start : Lomba
        String lmb = "Lomba :\n";
        int startlen = lmb.length();
        if (cbPP.isChecked()) lmb += cbPP.getText() + "\n";
        if (cbBK.isChecked()) lmb += cbBK.getText() + "\n";
        if (cbV.isChecked()) lmb += cbV.getText() + "\n";
        if (cbFS.isChecked()) lmb += cbFS.getText() + "\n";
        if (cbC.isChecked()) lmb += cbC.getText() + "\n";
        if (cbMK.isChecked()) lmb += cbMK.getText() + "\n";

        if (lmb.length() == startlen) lmb += "Belum Dipilih";
        tvHasil4.setText(lmb);
        //End : Lomba
    }

    //Start : Validasi Form Nama
    private boolean isValid() {
        boolean valid = true;

        String dpn = etDepan.getText().toString();
        String blkng = etBlkng.getText().toString();

        if (dpn.isEmpty()) {
            etDepan.setError("Belum Diisi");
            valid = false;
        } else if (dpn.length() < 3) {
            etDepan.setError("Minimal 3 Karakter");
            valid = false;
        } else {
            etDepan.setError(null);
        }
        if (blkng.isEmpty()) {
            etBlkng.setError("Belum Diisi");
            valid = false;
        } else if (blkng.length() < 3) {
            etBlkng.setError("Minimal 3 Karakter");
            valid = false;
        } else {
            etBlkng.setError(null);
        }

        return valid;
    }
    //End : Validasi Form Nama

    //Start : Checked Lomba
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) lomba += 1;
        else lomba -= 1;

        tvLM.setText("Lomba Yang Ingin Diikuti (" + lomba + "/6)");
    }
    //End : Checked Lomba

}