
CREATE TABLE agenda (
	id serial PRIMARY KEY,
	descricao varchar(500),
	data_hora timestamp,
	data_criacao timestamp,
	email varchar(100),
	pacient_id integer,
	CONSTRAINT fk_agenda_paciente FOREIGN KEY (paciente_id) REFERENCES paciente(id)

)

