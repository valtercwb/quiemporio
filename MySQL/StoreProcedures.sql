DELIMITER $$

CREATE PROCEDURE sp_cadastro_cliente (
	
    in cli_nome VARCHAR(45),
    in cli_CNPJ VARCHAR(45),
    in ende_nome VARCHAR(100),
    in ende_numero INT(11),
    in end_complemento VARCHAR(100),
    in ende_CEP varchar(10)
)
begin

	insert into endereco (end_nome, numero, complemento, CEP)
    values (ende_nome, ende_numero, end_complemento, ende_CEP);
    
    insert into cliente (nome, CNPJ, endereco_end_id)
    values (cli_nome, cli_CNPJ, last_insert_id());

end$$
DELIMITER ;

call sp_cadastro_cliente('Lojão do Jão','tested','Rua Teste',44,'D','837283');

DELIMITER $$

CREATE PROCEDURE sp_atualizar_cliente (

	in cli_id INT(11),
    in cli_nome VARCHAR(45),
    in cli_CNPJ VARCHAR(45),
    in ende_nome VARCHAR(100),
    in ende_numero INT(11),
    in end_complemento VARCHAR(100),
    in ende_CEP varchar(10)
)
begin

	
	select end_id into @teste from cliente
	inner join endereco on cliente.endereco_end_id = endereco.end_id
	where cliente.cli_id = cli_id;

	update endereco 
    set end_nome = ende_nome,
		numero = ende_numero, 
        complemento = end_complemento,
        CEP = ende_CEP where end_id = @teste;
    
    update cliente
    set cliente.nome = cli_nome,
		cliente.CNPJ = cli_CNPJ 
        where cliente.cli_id = cli_id;
   
end$$
DELIMITER ;


select cli_id,end_id from cliente
inner join endereco where cliente.endereco_end_id = endereco.end_id
having cli_id = 3 and end_id = 3;

select end_id into @teste from cliente
inner join endereco on cliente.endereco_end_id = endereco.end_id
where cliente.cli_id = 3;
select @teste;
