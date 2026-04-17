package com.videostreaming.movie_catalog_service.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieInfoRepository extends JpaRepository<MovieInfo, Long> {

}
