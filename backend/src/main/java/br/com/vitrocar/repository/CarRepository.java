package br.com.vitrocar.repository;

import br.com.vitrocar.model.Car;
import br.com.vitrocar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    List<Car> findByUser(User user);
}
