create table usuario(cuenta integer primary key,
                     nombre varchar(60),
                     email varchar(60));

create table direccion(id integer primary key auto_increment,
                       cuenta integer,
                       calle varchar(80),
                       cp integer,
                       municipio varchar(60),
                       foreign key(cuenta) references usuario(cuenta));