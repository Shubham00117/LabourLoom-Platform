package com.labourloomplatform.labourloomPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.labourloomplatform.labourloomPlatform.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
