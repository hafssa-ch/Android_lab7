package com.example.lab7.service;

import com.example.lab7.beans.Star;
import com.example.lab7.dao.IDao;
import java.util.ArrayList;
import java.util.List;

public class StarService implements IDao<Star> {
    private List<Star> stars;
    private static StarService instance;

    private StarService() {
        stars = new ArrayList<>();
        seed();
    }

    public static StarService getInstance() {
        if (instance == null) instance = new StarService();
        return instance;
    }

    private void seed() {
        stars.add(new Star("Emma Watson", "https://upload.wikimedia.org/wikipedia/commons/7/7f/Emma_Watson_2013.jpg", 4.5f));
        stars.add(new Star("Tom Cruise", "https://upload.wikimedia.org/wikipedia/commons/3/33/Tom_Cruise_by_Gage_Skidmore_2.jpg", 4.2f));
        stars.add(new Star("Scarlett Johansson", "https://upload.wikimedia.org/wikipedia/commons/2/2a/Scarlett_Johansson_by_Gage_Skidmore_2.jpg", 4.7f));
        stars.add(new Star("Leonardo DiCaprio", "https://upload.wikimedia.org/wikipedia/commons/2/25/Leonardo_DiCaprio_2014.jpg", 4.8f));
        stars.add(new Star("Brad Pitt", "https://upload.wikimedia.org/wikipedia/commons/4/4c/Brad_Pitt_2019_by_Glenn_Francis.jpg", 4.6f));
        stars.add(new Star("Angelina Jolie", "https://upload.wikimedia.org/wikipedia/commons/a/ad/Angelina_Jolie_2_2014.jpg", 4.4f));
        stars.add(new Star("Robert Downey Jr", "https://upload.wikimedia.org/wikipedia/commons/9/94/Robert_Downey_Jr_2014_Comic_Con_2.jpg", 4.9f));
        stars.add(new Star("Jennifer Lawrence", "https://upload.wikimedia.org/wikipedia/commons/0/0b/Jennifer_Lawrence_at_the_83rd_Academy_Awards.jpg", 4.3f));
        stars.add(new Star("Will Smith", "https://upload.wikimedia.org/wikipedia/commons/3/3f/TechCrunch_Disrupt_2019_%2848834434641%29_%28cropped%29.jpg", 4.1f));
        stars.add(new Star("Margot Robbie", "https://upload.wikimedia.org/wikipedia/commons/0/01/Margot_Robbie_at_the_2018_BAFTA_Reception.jpg", 4.8f));
    }

    @Override public boolean create(Star o) { return stars.add(o); }
    @Override public boolean update(Star o) {
        for (Star s : stars) {
            if (s.getId() == o.getId()) {
                s.setName(o.getName());
                s.setImg(o.getImg());
                s.setRating(o.getRating());
                return true;
            }
        }
        return false;
    }
    @Override public boolean delete(Star o) { return stars.remove(o); }
    @Override public Star findById(int id) {
        for (Star s : stars) if (s.getId() == id) return s;
        return null;
    }
    @Override public List<Star> findAll() { return stars; }
}