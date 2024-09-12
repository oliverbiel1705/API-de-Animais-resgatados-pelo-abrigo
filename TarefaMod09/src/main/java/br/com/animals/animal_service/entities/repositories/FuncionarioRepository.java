package br.com.animals.animal_service.entities.repositories;

import br.com.animals.animal_service.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
    @Query("SELECT f.name, COUNT(a) FROM Funcionario f JOIN f.animais a " +
            "WHERE a.dataEntrada BETWEEN :startDate AND :endDate " +
            "GROUP BY f.id")
    List<Object[]> countAnimaisResgatadosPorFuncionarioNoIntervalo(@Param("startDate") Date startDate,
                                                                   @Param("endDate") Date endDate);
}
