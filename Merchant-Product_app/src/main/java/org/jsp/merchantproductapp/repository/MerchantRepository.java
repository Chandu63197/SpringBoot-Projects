package org.jsp.merchantproductapp.repository;

import java.util.Optional;
import org.jsp.merchantproductapp.dto.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MerchantRepository extends JpaRepository<Merchant, Integer>{
	@Query("select m from Merchant m where m.phone=?1 and m.password=?2")
    public Optional<Merchant> verifyMerchant(long phone,String password);
	@Query("select m from Merchant m where m.email=?1 and m.password=?2")
    public Optional<Merchant> verifyMerchant(String email,String password);
	@Query("select m from Merchant m where m.id=?1 and m.password=?2")
    public Optional<Merchant> verifyMerchant(int id,String password);
}
