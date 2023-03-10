package org.example.dao;

import lombok.RequiredArgsConstructor;
import org.example.dto.MovieRequestDto;
import org.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MovieDao implements BaseDao<Movie, MovieRequestDto> {
    private final SessionFactory sessionFactory;

    @Override
    public Movie findById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Movie movieEntity = session.get(Movie.class, id);
        session.getTransaction().commit();
        session.close();
        return movieEntity;
    }

    @Override
    public List<Movie> findAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Movie> movies = session.createQuery("from Movie ").list();
        session.getTransaction().commit();
        session.close();
        return movies;
    }

    @Override
    public Movie save(MovieRequestDto movieRequestDto) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Movie save = (Movie) session.save(movieRequestDto);
        session.getTransaction().commit();
        session.close();
        return save;
    }

    public void delete(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Movie movie = findById(id);
        session.remove(movie);
        session.getTransaction().commit();
        session.close();
    }

}
