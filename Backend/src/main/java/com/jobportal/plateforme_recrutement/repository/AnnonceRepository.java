package com.jobportal.plateforme_recrutement.repository;

import com.jobportal.plateforme_recrutement.model.TypeAnnonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.jobportal.plateforme_recrutement.model.Annonce;
import java.util.List;


public interface AnnonceRepository extends JpaRepository<Annonce, Integer> {
    List<Annonce> findByTitreContainingIgnoreCase(String titre);
    List<Annonce> findByType(TypeAnnonce type);
    List<Annonce> findByRecruteurIdUser(int recruteurId);

    @Query("SELECT a FROM Annonce a WHERE a.type = :type AND a.recruteur.idUser = :recruteurId")
    List<Annonce> findByTypeAndRecruteur(@Param("type") String type, @Param("recruteurId") int recruteurId);
}
