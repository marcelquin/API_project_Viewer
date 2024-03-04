package App.repository;

import App.Model.MicroServicoBackup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MicroServicoRepository extends JpaRepository<MicroServicoBackup,Long> {
}
