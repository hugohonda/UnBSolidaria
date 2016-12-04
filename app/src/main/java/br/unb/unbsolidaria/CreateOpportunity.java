package br.unb.unbsolidaria;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CreateOpportunity.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CreateOpportunity#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateOpportunity extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private Calendar referenceCalendar;
    // each text field has its own date picker
    private DatePickerDialog startDatePicker;
    private DatePickerDialog endDatePicker;

    private EditText etStartDate;
    private EditText etEndDate;

    public CreateOpportunity() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CreateOpportunity.
     */
    // TODO: Rename and change types and number of parameters
    public static CreateOpportunity newInstance(String param1, String param2) {
        CreateOpportunity fragment = new CreateOpportunity();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

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

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}