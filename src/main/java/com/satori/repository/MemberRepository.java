package com.satori.repository;

import com.satori.model.Category;
import com.satori.model.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Page<Member> findMembersByClubIdOrderByLastName(Pageable pageable, Long id);

    Page<Member> findByCategoriesOrderByLastName(Pageable pageable, Category category);

    Page<Member> findByOrderByLastName(Pageable pageable);
}
