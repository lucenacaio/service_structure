package br.com.lucenacaio.structure.repository;

import br.com.lucenacaio.structure.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
