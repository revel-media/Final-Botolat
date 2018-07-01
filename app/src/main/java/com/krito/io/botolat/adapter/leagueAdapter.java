package com.krito.io.botolat.adapter;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.krito.io.botolat.R;
import com.krito.io.botolat.model.Team;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Goda on 21/06/2018.
 */

public class leagueAdapter extends RecyclerView.Adapter<leagueHolder> implements View.OnClickListener {
    List<Team>teamList=new ArrayList<>();
    Context context;
    String setTime;
    public  leagueAdapter(List<Team>teamList,Context context){
        this.teamList=teamList;
        this.context=context;
    }
    @Override
    public leagueHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.league_date_row,parent,false);
        return new leagueHolder(view);
    }

    @Override
    public void onBindViewHolder(leagueHolder holder, int position) {
        Team team=teamList.get(position);
        holder.txtTeam1.setText(team.getTeamName());
        holder.txtTeam2.setText(team.getTeamName());
        holder.edtTime.setOnClickListener(this);
        holder.edtDate.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    @Override
    public void onClick(final View view) {
        switch (view.getId()){
            case R.id.time:
                Calendar getTime=Calendar.getInstance();
                int hours=getTime.get(Calendar.HOUR_OF_DAY);
                int minutes=getTime.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog=new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        leagueHolder holder = new leagueHolder(view);
                        holder.edtTime.setText(selectedHour+":"+selectedMinute);
                    }
                },hours,minutes,true);
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();
                break;
            case R.id.date:
                Calendar c=Calendar.getInstance();
                int year=c.get(Calendar.YEAR);
                int month=c.get(Calendar.MONTH);
                int day=c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog;
                datePickerDialog=new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        leagueHolder holder = new leagueHolder(view);
                        holder.edtDate.setText(day+"/"+(month+1)+"/"+year);
                    }
                },year,month,day);
                datePickerDialog.setTitle("Select Date");
                datePickerDialog.show();
                break;
        }

    }
}
