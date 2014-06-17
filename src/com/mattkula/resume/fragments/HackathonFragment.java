package com.mattkula.resume.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.mattkula.resume.R;
import com.mattkula.resume.models.HackathonProject;

import java.util.ArrayList;

/**
 * Created by matt on 6/16/14.
 */
public class HackathonFragment extends ListFragment {

    ArrayList<HackathonProject> mProjects = HackathonProject.getProjects();
    int[] colors = {android.R.color.holo_blue_light, android.R.color.holo_red_dark, android.R.color.holo_green_dark,
                    android.R.color.holo_purple, android.R.color.holo_orange_dark};


    Typeface robotoLight;
    Typeface robotoThin;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new HackathonAdapter());
        getListView().setDivider(null);
        getListView().setDividerHeight(0);
    }

    @Override
    public void onResume() {
        super.onResume();
        robotoLight =  Typeface.createFromAsset(getResources().getAssets(), "fonts/RobotoLight.ttf");
        robotoThin = Typeface.createFromAsset(getResources().getAssets(), "fonts/RobotoThin.ttf");
    }

    private class HackathonAdapter extends BaseAdapter {

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View v = view;
            if (v == null) {
                v = LayoutInflater.from(getActivity()).inflate(R.layout.item_hackathon_project, viewGroup, false);
            }

            final HackathonProject project = mProjects.get(i);

            TextView proj = (TextView)v.findViewById(R.id.tv_hackathon_project_title);
            proj.setText(project.name);
            proj.setTypeface(robotoLight);

            TextView hackathon = (TextView)v.findViewById(R.id.tv_hackathon_name);
            hackathon.setText("Created at " + project.hackathon);
            hackathon.setTypeface(robotoLight);

            TextView desc = (TextView)v.findViewById(R.id.tv_hackathon_description);
            desc.setText(project.description);
            desc.setTypeface(robotoThin);

            ImageButton youtube = (ImageButton)v.findViewById(R.id.ib_youtube);
            if(project.youtubeUrl != null) {
                youtube.setVisibility(View.VISIBLE);
                youtube.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(project.youtubeUrl)));
                    }
                });
            } else {
                youtube.setVisibility(View.GONE);
            }

            ImageButton github = (ImageButton)v.findViewById(R.id.ib_github);
            if(project.githubUrl != null) {
                github.setVisibility(View.VISIBLE);
                github.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(project.githubUrl)));
                    }
                });
            } else {
                github.setVisibility(View.GONE);
            }

            if (project.imageId > 0) {
                ((ImageView) v.findViewById(R.id.iv_hackathon)).setImageDrawable(getResources().getDrawable(project.imageId));
            }

            v.findViewById(R.id.colorizer).setBackgroundColor(getResources().getColor(colors[i % colors.length]));
            v.findViewById(R.id.colorizer2).setBackgroundColor(getResources().getColor(colors[i % colors.length]));
            return v;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public Object getItem(int i) {
            return mProjects.get(i);
        }

        @Override
        public int getCount() {
            return mProjects.size();
        }
    }
}
