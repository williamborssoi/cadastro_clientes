package br.edu.unoesc.ads.clientes.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.edu.unoesc.ads.clientes.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
@Query("select c from Cliente c where c.idade >= :idade")
List<Cliente> porIdade(@Param("idade") Long idade);
}