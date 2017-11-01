package org.unitec.elementos2017;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Elementos2017Application implements CommandLineRunner{

	 @Autowired RepositorioMensajito repoMensa;
	 @Autowired RepositorioUsuairo repoUsu;
	 @Autowired RepositorioDireccion repoDir;

	public static void main(String[] args) {
		SpringApplication.run(Elementos2017Application.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		//Vamos a generar un usuario

		/*Usuario u = new Usuario(12402032L,"Fernando","ferchovargas24@gmail.com");
		repoUsu.save(u);*/

		//Generamos la direccion
		Direccion d = new Direccion(new Usuario(12402032L),"Calle 5",55120,"Ecatepec");
		repoDir.save(d);
	}
}