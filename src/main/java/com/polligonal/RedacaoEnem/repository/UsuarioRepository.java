package com.polligonal.RedacaoEnem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.polligonal.RedacaoEnem.models.Usuario;

@Repository
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {

	Optional<Usuario> findByEmail(String email);
	
	@Query("Select u from Usuario u join u.perfis where u.id = :id")
	Usuario getOne(@Param("id")Long id);

}
