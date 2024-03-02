package App.RestApi.Infra.Persistence.Repository;

import App.RestApi.Infra.Persistence.Entity.MicroServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MicroServicoRepository extends JpaRepository<MicroServicoEntity,Long> {
}
