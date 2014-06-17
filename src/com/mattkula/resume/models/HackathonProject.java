package com.mattkula.resume.models;

import android.view.View;
import com.mattkula.resume.R;

import java.util.ArrayList;

/**
 * Created by matt on 6/16/14.
 */
public class HackathonProject {

    public HackathonProject(String name, String hackathon, String description, ArrayList<String> awards, String youtubeUrl, String githubUrl, int imageId) {
        this.name = name;
        this.hackathon = hackathon;
        this.description = description;
        this.awards = awards;
        this.youtubeUrl = youtubeUrl;
        this.githubUrl = githubUrl;
        this.imageId = imageId;
    }

    public String name;
    public String hackathon;
    public String description;
    public ArrayList<String> awards;
    public String youtubeUrl;
    public String githubUrl
    public int imageId;

    public static ArrayList<HackathonProject> getProjects(){
        ArrayList<HackathonProject> projects = new ArrayList<HackathonProject>();

        projects.add(new HackathonProject("LeapDJ", "MHacks Fall 2013", "Play as the DJ using the Leap Motion controller.",
                null, "https://www.youtube.com/watch?v=lX94gtECMhw", "https://github.com/matthewrkula/leapdj-mhacks", R.drawable.leap_dj_logo_small));

        projects.add(new HackathonProject("NextSlide", "HackMIT", "Use your phone or Pebble watch to control presentations hosted on the internet.",
                null, "https://www.youtube.com/watch?v=6cKSB5mMAFo", null, R.drawable.nextslide));

        projects.add(new HackathonProject("GamePad", "Facebook Midwest Regional Hackathon", "Control web games from your phone using WebSockets",
                null, null, "https://github.com/matthewrkula/facebook-hack", R.drawable.gamepad));

        projects.add(new HackathonProject("Oculus Quidditch", "MHacks Spring 2014", "Fly around Hogwarts using the Oculus Rift and a Wiimote as your broom.",
                null, "https://www.youtube.com/watch?v=8I2tAC7BR20", null,  R.drawable.quidditch));

        return projects;
    }
}
