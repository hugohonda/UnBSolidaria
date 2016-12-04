package br.unb.unbsolidaria.organization;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

import br.unb.unbsolidaria.R;

public class CreateOpportunity extends Fragment implements View.OnClickListener {

    private Calendar referenceCalendar;
    // each text field has its own date picker
    private DatePickerDialog startDatePicker;
    private DatePickerDialog endDatePicker;

    private EditText etStartDate;
    private EditText etEndDate;

    public CreateOpportunity() {
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        referenceCalendar = Calendar.getInstance();
        int currentYear = referenceCalendar.get(Calendar.YEAR);
        int currentMonth = referenceCalendar.get(Calendar.MONTH);
        int currentDay = referenceCalendar.get(Calendar.DAY_OF_MONTH);

        // All of this just because setOnDateSetListener is only supported on API 24
        startDatePicker = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                etStartDate.setText(getString(R.string.co_tDateFormat, dayOfMonth, month, year));
            }
        }, currentYear, currentMonth, currentDay);

        endDatePicker = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                etEndDate.setText(getString(R.string.co_tDateFormat, dayOfMonth, month, year));
            }
        }, currentYear, currentMonth, currentDay);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View parentView = inflater.inflate(R.layout.fragment_create_opportunity, container, false);

        etStartDate = (EditText)parentView.findViewById(R.id.co_etDateStart);
        etStartDate.setOnClickListener(this);
        etEndDate = (EditText)parentView.findViewById(R.id.co_etDateEnd);
        etEndDate.setOnClickListener(this);

        return parentView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.co_etDateStart:
                    startDatePicker.show();
                break;
            case R.id.co_etDateEnd:
                    endDatePicker.show();
                break;
        }
    }
}