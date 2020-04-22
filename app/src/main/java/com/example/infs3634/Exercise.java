package com.example.infs3634;

import java.util.ArrayList;

/* This is the java class for the Exercises Section of the application which has the data
for all the exercises including the name, image, intensity, time, level, description, type
and link to the relevant youtube video for each exercise.*/

public class Exercise {

    //The attributes relevant to every exercise.
    private String name;
    private int image;
    private String intensity;
    private String time;
    private String level;
    private String desc;
    private String type;
    private String link;

    //Empty Constructor.
    public Exercise() {
    }

    public Exercise(String name, int image, String intensity, String time, String level, String desc, String type, String link) {
        this.name = name;
        this.image = image;
        this.intensity = intensity;
        this.time = time;
        this.level = level;
        this.desc = desc;
        this.type = type;
        this.link = link;
    }

    //Getters and Setters for each attribute.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getIntensity() {
        return intensity;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    /*ArrayList data, for all the exercise data and their details which includes name, image,
    intensity, time, level, description and type. The links to the relevant youtube video
    are also listed.*/
    public static ArrayList<Exercise> exerciseDetail() {
        ArrayList<Exercise> elist = new ArrayList<>();
        elist.add(new Exercise("Planks", R.drawable.planks, "Low", "2 sets - 60 seconds", "Beginner", "The plank strengthens your spine, your rhomboids and trapezius, and your abdominal muscles, which naturally result in a strong posture as they grow in strength.", "ABS", "https://www.youtube.com/watch?v=ASdvN_XEl_c"));
        elist.add(new Exercise("Bicycle Crunches", R.drawable.crunches, "Medium", "3 Sets - 10 Reps", "Beginner", "The primary muscles worked in the bicycle crunch are the rectus abdominus, hips, and obliques. Keeping your legs off the ground targets your lower abs. The rotation activates your obliques. The pedaling of your legs stimulates the hips. \n", "ABS", "https://www.youtube.com/watch?v=9FGilxCbdz8"));
        elist.add(new Exercise("Mountain Climbers", R.drawable.climbers, "High", "3 Sets - 30 Reps", "Beginner", "Mountain climbers are a compound cardio exercise that works several joints and muscles at the same time, from your neck down to your feet. In particular, it targets your triceps, deltoids, abs, back, hip flexors, quads, hamstrings and butt.\n", "ABS", "https://www.youtube.com/watch?v=nmwgirgXLYM"));
        elist.add(new Exercise("Bird Dog", R.drawable.birddog, "Low", "2 Sets - 10 Reps", "Beginner", "The bird dog is a simple core exercise that improves stability, encourages a neutral spine, and relieves low back pain. It strengthens your core, hips, and back muscles. It also promotes proper posture and increases range of motion.", "BACK", "https://www.youtube.com/watch?v=wiFNA3sqjCA"));
        elist.add(new Exercise("Superman", R.drawable.superman, "Medium", "2 Sets - 15 Reps", "Beginner", "The Superman is one of the best exercises to strengthen your upper and lower back muscles. If done regularly, the Superman may help alleviate back pain that is related to weak back muscles. In addition to strengthening back muscles, the Superman works your glutes and your hamstring muscles. ", "BACK", "https://www.youtube.com/watch?v=cc6UVRS7PW4"));
        elist.add(new Exercise("Back extensions", R.drawable.ic_launcher_background, "High", "20 Reps or 1 Minute", "Beginner", "Back extension exercises target muscle groups in the back, especially the lower back, to improve overall health, mobility, and core strength. ", "BACK", "https://www.youtube.com/watch?v=Bw9YuQTTc58"));
        elist.add(new Exercise("Bridge", R.drawable.bridge, "Low", "3 Sets -10 Reps", "Beginner", "The basic bridge isolates and strengthens your gluteus (butt) muscles and hamstrings (back of the thigh). A basic bridge stretches the stabilizers of the posterior chain, including your hip abductors, gluteus maximus, and hamstrings. ", "GLUTES", "https://www.youtube.com/watch?v=WowARnE-p0s"));
        elist.add(new Exercise("Squats", R.drawable.squats, "Medium", "3 Sets -20 Reps", "Beginner", "Squats help build your leg muscles – quadriceps, hamstrings, and calves. These drills also create an anabolic environment, which promotes body-wide muscle building, improving muscle mass. Squats, and all of their variations, are a great exercise for the whole body", "GLUTES", "https://www.youtube.com/watch?v=aclHkVaku9U"));
        elist.add(new Exercise("Lunges", R.drawable.lunges, "High", "2 Sets - 12 Reps", "Beginner", "A lunge is a single-leg bodyweight exercise that works your hips, glutes, quads, hamstrings, and core and the hard-to-reach muscles of your inner thighs. Lunges can help you develop lower-body strength and endurance while also improving balance, coordination, and stability.", "GLUTES", "https://www.youtube.com/watch?v=QOVaHwm-Q6U"));
        elist.add(new Exercise("Pushups", R.drawable.pushups, "Low", "2 Sets - 10 Reps", "Beginner", "Push-ups are known as a fantastic upper-body strengthener, used to build endurance and power in the chest and shoulders. When done properly, however, the push-up activates the core — including the ab muscles — for stabilization.", "CHEST", "https://www.youtube.com/watch?v=IODxDxX7oi4"));
        elist.add(new Exercise("Dips", R.drawable.dips, "Medium", "2 Sets - 10 Reps", "Beginner", "A dip is an upper-body strength exercise. Narrow, shoulder-width dips primarily train the triceps, with major synergists being the anterior deltoid, the pectoralis muscles (sternal, clavicular, and minor), and the rhomboid muscles of the back. ", "CHEST", "https://www.youtube.com/watch?v=2z8JmcrW-As"));
        elist.add(new Exercise("Decline Pushups", R.drawable.declinepushups, "High", "2 Sets - 10 Reps", "Beginner", "A decline variation targets your upper chest and fronts of shoulders more aggressively than a regular push-up performed on level ground. Perform it in addition to a regular push-up as well as with other chest exercises to get the most well-rounded chest development.", "CHEST", "https://www.youtube.com/watch?v=SKPab2YC8BE"));
        elist.add(new Exercise("Arm Circles", R.drawable.armcircles, "Low", "2 Sets - 20 Reps", "Beginner", "Arm circle is an easy exercise and is mostly done as a warm up before any strenuous exercise such as strength training. Practising arm circles targets your triceps, back, biceps and shoulders. Practising it daily will first reduce arm fat followed by toning of muscles", "ARMS", "https://www.youtube.com/watch?v=140RTNMciH8"));
        elist.add(new Exercise("Arm Raises", R.drawable.armraises, "Medium", "2 Sets - 20 Reps", "Beginner", "Arm Raise is an isolation exercise which isolates shoulder flexion. It primarily works the anterior deltoid, with assistance from the serratus anterior, biceps brachii and clavicular portions of the pectoralis major.", "ARMS", "https://www.youtube.com/watch?v=D-3JnFrFUOw"));
        elist.add(new Exercise("Up Down Plank", R.drawable.updownplank, "High", "3 Sets - 10 Reps", "Beginner", "The up and down plank strengthens and tones your core, glutes, arms, wrists, and shoulders. This exercise helps to improve your posture, tightens the midsection and boosts weight loss.\n", "ARMS", "https://www.youtube.com/watch?v=L4oFJRDAU4Q"));
        elist.add(new Exercise("Leg Raises", R.drawable.legraises, "Low", "3 Sets - 10 Reps", "Beginner", "The leg raise is a strength training exercise which targets the thigh and hip muscle. Because the abdominal muscles are used isometrically to stabilize the body during the motion, leg raises are also often used to strengthen the rectus abdominis muscle", "LEGS", "https://www.youtube.com/watch?v=JB2oyawG9KI"));
        elist.add(new Exercise("Squat Jumps", R.drawable.squats, "Medium", "3 Sets - 5 Reps", "Beginner", "Jump squats increase your explosive power, improve upper and lower body strength, and burn calories faster than regular squats. Squat jumps and their variations help shed fat from the lower body, tone your butt and legs, and improve strength and balance\n", "LEGS", "https://www.youtube.com/watch?v=U4s4mEQ5VqU"));
        elist.add(new Exercise("Side Lunges", R.drawable.sidelunge, "High", "2 Sets - 20 Reps", "Beginner", " Side lunges' lateral movement targets the inner and outer thighs and helps to strengthen and tone those areas of your legs. This is also an excellent move to strengthen your quads, hamstrings and glutes, which makes the side lunge a very complete lower body exercise", "LEGS", "https://www.youtube.com/watch?v=rvqLVxYqEvo"));

        return elist;

    }

    // CREATE NEW FILTERED ARRAY LIST
    //This second list filters the data in the ArrayList elist to store top 3 values for abs into a separate variable called filtered exercises.
    public static ArrayList<Exercise> filterExercises(String abs) {
        ArrayList<Exercise> filteredData = new ArrayList<>();

        for (int i = 0; i < exerciseDetail().size(); i++) {
            //For elist, get the position of the item, get name and if it contains/equals abs, add to filtered data.
            if (exerciseDetail().get(i).getName().contains(abs)) {
                filteredData.add(exerciseDetail().get(i));
            }
        }
        return filteredData;
    }
}