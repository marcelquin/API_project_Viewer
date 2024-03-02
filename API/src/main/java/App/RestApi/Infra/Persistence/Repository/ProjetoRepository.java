package App.RestApi.Infra.Persistence.Repository;

import App.RestApi.Infra.Persistence.Entity.ProjetoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends JpaRepository<ProjetoEntity,Long> {
}
