package com.example.ventapasajes;

import static android.view.View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.ventapasajes.dataPasaje.DataAllVentaPasaje;
import com.jakewharton.threetenabp.AndroidThreeTen;

import org.threeten.bp.LocalTime;
import org.threeten.bp.format.DateTimeFormatter;

public class ActivityVentaPasaje extends AppCompatActivity {

    private Button search_button;
    private CheckBox check_no, check_si;
    private ConstraintLayout time_picker_container;
    private ImageView check_cancel_hora;
    private EditText to_location, from_location, phone_user, edtDocumentUser, nombre_user;
    private LocalTime hourPasajero;
    private TimePicker time_picker;
    private DataAllVentaPasaje dataAllVentaPasaje = new DataAllVentaPasaje();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venta_pasaje);

        // Inicializar ThreeTenABP
        AndroidThreeTen.init(this);

        search_button = findViewById(R.id.search_button);
        check_si = findViewById(R.id.check_si);
        check_no = findViewById(R.id.check_no);
        time_picker_container = findViewById(R.id.time_picker_container);
        check_cancel_hora = findViewById(R.id.check_cancel_hora);
        from_location = findViewById(R.id.from_location);
        to_location = findViewById(R.id.to_location);
        phone_user = findViewById(R.id.phone_user);
        edtDocumentUser = findViewById(R.id.edtDocumentUser);
        nombre_user = findViewById(R.id.nombre_user);
        time_picker = findViewById(R.id.time_picker);
        time_picker.setIs24HourView(false); // Usar formato AM/PM

        // Agregar TextWatchers a los campos de texto
        from_location.addTextChangedListener(textWatcher);
        to_location.addTextChangedListener(textWatcher);
        phone_user.addTextChangedListener(textWatcher);
        edtDocumentUser.addTextChangedListener(textWatcher);
        nombre_user.addTextChangedListener(textWatcher);
        check_si.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                cancelHourSelect();
                hourPasajero = LocalTime.now();
            }
            validateInputs(); // Validar campos cuando se selecciona el checkbox
        });

        check_cancel_hora.setOnClickListener(view -> {
            cancelHourSelect();
        });

        check_no.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                check_si.setChecked(false);
                time_picker_container.setVisibility(View.VISIBLE); // Muestra el time_picker_container si se selecciona "NO"
                time_picker.setCurrentHour(LocalTime.now().getHour());
                time_picker.setCurrentMinute(LocalTime.now().getMinute());
            }
            validateInputs(); // Validar campos cuando se selecciona el checkbox
        });

        time_picker.setOnTimeChangedListener((view, hourOfDay, minute) -> {
            LocalTime selectedTime = LocalTime.of(hourOfDay, minute);
            if (selectedTime.isBefore(LocalTime.now())) {
                time_picker.setCurrentHour(LocalTime.now().getHour());
                time_picker.setCurrentMinute(LocalTime.now().getMinute());
            }
            validateInputs(); // Validar campos cuando se cambia la hora
        });

        search_button.setOnClickListener(view -> {
            saveInfoPasajero();
            Intent intent = new Intent(ActivityVentaPasaje.this, chofer_buseta.class);
            startActivity(intent);
        });

        // Validar inputs al inicio para deshabilitar el botón si los campos están vacíos
        validateInputs();
    }

    private void saveInfoPasajero() {
        dataAllVentaPasaje.setUbicacionOrigen(from_location.getText().toString());
        dataAllVentaPasaje.setUbicacionDestino(to_location.getText().toString());
        dataAllVentaPasaje.setNombrePasajero(nombre_user.getText().toString());
        dataAllVentaPasaje.setNumDocumentoPasajero(edtDocumentUser.getText().toString());
        dataAllVentaPasaje.setNumTelefonoPasajero(phone_user.getText().toString());

        if (check_si.isChecked()) {
            hourPasajero = LocalTime.now();
        } else if (check_no.isChecked()) {
            int hour = time_picker.getCurrentHour();
            int minute = time_picker.getCurrentMinute();
            hourPasajero = LocalTime.of(hour, minute);
        }

        // Almacena el LocalTime en el objeto dataAllVentaPasaje
        dataAllVentaPasaje.setHoraRecogidaPasajero(hourPasajero);
    }

    private void validateInputs() {
        boolean allFieldsFilled = !from_location.getText().toString().isEmpty() &&
                !to_location.getText().toString().isEmpty() &&
                !phone_user.getText().toString().isEmpty() &&
                !edtDocumentUser.getText().toString().isEmpty() &&
                !nombre_user.getText().toString().isEmpty() &&
                (check_si.isChecked() || check_no.isChecked());

        search_button.setEnabled(allFieldsFilled);
    }

    @Override
    public void onResume() {
        super.onResume();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

    private void cancelHourSelect() {
        check_no.setChecked(false);
        time_picker_container.setVisibility(View.GONE); // Oculta el time_picker_container si se selecciona "SI"
        validateInputs(); // Validar campos cuando se cancela la selección de hora
    }

    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            validateInputs();
        }

        @Override
        public void afterTextChanged(Editable s) { }
    };
}
