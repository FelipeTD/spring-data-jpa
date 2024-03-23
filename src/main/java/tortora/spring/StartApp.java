package tortora.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tortora.spring.model.Usuario;
import tortora.spring.repository.UserRepository;

import java.util.List;

@Component
public class StartApp implements CommandLineRunner {

    private UserRepository userRepository;

    public StartApp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        // List<Usuario> users = userRepository.filtrarPorNome("Filipe");
        List<Usuario> users = userRepository.findByNameContaining("Filipe");
        for (Usuario u: users) {
            System.out.println(u);
        }

    }

    private void insert() {
        Usuario usuario = new Usuario();
        usuario.setName("Filipe Tortora");
        usuario.setUsername("fedispato2");
        usuario.setPassword("ftd38427689");

        userRepository.save(usuario);
    }
}
