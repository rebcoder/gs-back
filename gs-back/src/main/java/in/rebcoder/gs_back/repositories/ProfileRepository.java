package in.rebcoder.gs_back.repositories;


import in.rebcoder.gs_back.models.Profile;
import in.rebcoder.gs_back.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Profile findByUser(User user);
}

