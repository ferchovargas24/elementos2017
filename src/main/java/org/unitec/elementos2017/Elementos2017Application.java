package org.unitec.elementos2017;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Elementos2017Application implements CommandLineRunner{

	@Autowired RepositorioMensajito repoMensa;

	public static void main(String[] args) {
		SpringApplication.run(Elementos2017Application.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		//insert
		//repoMensa.save(new Mensajito(1,"segundo", "17 de octubre no tembló"));

		//select
		/*for(Mensajito mensa:repoMensa.findAll()) {
			System.out.println(mensa.getTitulo());
		}*/

		//select where id
			//System.out.println("Vamos a buscar por id" + repoMensa.findOne(1));

		//update
			//System.out.println("Vamos a actualizar " + repoMensa.save(new Mensajito(1,"nuevo titulo","hola")));

		//borrar
		//System.out.println("Vamos a borrar" ); repoMensa.delete(1);



	}
}