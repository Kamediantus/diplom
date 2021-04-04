package ru.rodichev.webBlog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.rodichev.webBlog.entity.BlockOfSite;

public interface BlockRepository extends JpaRepository<BlockOfSite, Long> {

    @Query(value = "SELECT full_text from t_block where id = :id", nativeQuery = true)
    String getTextById(@Param("id") Long id);

    @Query(value = "SELECT * FROM T_block WHERE id = :id", nativeQuery = true)
    BlockOfSite getBlockById(@Param("id") Long id);
}
