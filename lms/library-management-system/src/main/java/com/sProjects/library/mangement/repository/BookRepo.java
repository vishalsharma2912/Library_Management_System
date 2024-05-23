package com.sProjects.library.mangement.repository;

import com.sProjects.library.mangement.Enum.Genre;
import com.sProjects.library.mangement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer> {

    //using normal sql syntax
    //here its based on tables on db
    @Query(value = "select * from book where genre = :genre and cost>= :cost",nativeQuery = true)
    public List<Book> findByGenreAndCost(Genre genre,double cost);

    //using hql syntax
    //here its based on entities on code
    @Query(value = "select item from Book item where item.genre = :genre and item.cost >= :cost")
    public List<Book> findByGenreAndCostHQL(Genre genre,double cost);
}
