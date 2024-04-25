create table if not exists produtos(
  id INT AUTO_INCREMENT PRIMARY KEY,
  idUsuario int,
  nome varchar(255),
  descricao varchar(255),
  valor decimal(10, 2)
);

INSERT INTO produtos (nome, descricao, valor)
SELECT * FROM (
    SELECT 'Arroz' as nome, 'Arroz branco, tipo longo, pacote de 5kg' as descricao, 10.50 as valor  UNION ALL
    SELECT 'Feijão' as nome, 'Feijão preto, tipo carioca, pacote de 1kg' as descricao, 15.75 as valor UNION ALL
    SELECT 'Macarrão'as nome, 'Espaguete nº 7, pacote de 500g'as descricao, 20.25 as valor UNION ALL
    SELECT 'Óleo de Soja'as nome, 'Óleo de soja refinado, garrafa de 900ml'as descricao, 8.99 as valor UNION ALL
    SELECT 'Açúcar'as nome, 'Açúcar refinado, pacote de 1kg'as descricao, 12.00 as valor UNION ALL
    SELECT 'Café'as nome, 'Café torrado e moído, embalagem a vácuo, 500g'as descricao, 18.50 as valor UNION ALL
    SELECT 'Leite'as nome, 'Leite integral pasteurizado, caixa de 1 litro' as descricao, 25.99 as valor UNION ALL
    SELECT 'Farinha de Trigo'as nome, 'Farinha de trigo tipo 1, pacote de 1kg' as descricao, 30.75 as valor UNION ALL
    SELECT 'Sal'as nome, 'Sal refinado iodado, pacote de 1kg' as descricao, 22.00 as valor UNION ALL
    SELECT 'Biscoitos'as nome, 'Biscoitos recheados sabor chocolate, pacote de 200g' as descricao, 16.25 as valor UNION ALL
    SELECT 'Sabonete'as nome, 'Sabonete em barra, fragrância de lavanda, unidade' as descricao, 19.99 as valor UNION ALL
    SELECT 'Detergente'as nome, 'Detergente líquido para louças, embalagem de 500ml' as descricao, 11.50 as valor UNION ALL
    SELECT 'Shampoo'as nome, 'Shampoo para todos os tipos de cabelo, frasco de 350ml' as descricao, 14.25 as valor UNION ALL
    SELECT 'Condicionador'as nome, 'Condicionador hidratante, frasco de 300ml' as descricao, 9.99 as valor UNION ALL
    SELECT 'Creme Dental'as nome, 'Creme dental com flúor, embalagem de 90g' as descricao, 27.00 as valor UNION ALL
    SELECT 'Papel Higiênico'as nome, 'Rolo de papel higiênico folha dupla, pacote com 4 rolos' as descricao, 31.50 as valor UNION ALL
    SELECT 'Sabão em Pó'as nome, 'Sabão em pó para máquina de lavar roupa, pacote de 1kg' as descricao, 24.99 as valor UNION ALL
    SELECT 'Amaciante'as nome, 'Amaciante concentrado, fragrância suave, garrafa de 2 litros' as descricao, 18.75 as valor UNION ALL
    SELECT 'Desinfetante'as nome, 'Desinfetante líquido, aroma de pinho, frasco de 500ml' as descricao, 23.50 as valor UNION ALL
    SELECT 'Água Sanitária'as nome, 'Água sanitária concentrada, embalagem de 1 litro' as descricao, 35.99 as valor UNION ALL
    SELECT 'Desodorante'as nome, 'Desodorante roll-on, fragrância neutra, embalagem de 50ml' as descricao, 40.75 as valor UNION ALL
    SELECT 'Cereal Matinal'as nome, 'Cereal matinal sabor chocolate, pacote de 300g' as descricao, 32.00 as valor UNION ALL
    SELECT 'Iogurte'as nome, 'Iogurte natural, garrafa de 500g' as descricao, 26.25 as valor UNION ALL
    SELECT 'Margarina'as nome, 'Margarina cremosa, embalagem de 250g' as descricao, 29.99 as valor UNION ALL
    SELECT 'Ovos'as nome, 'Ovos brancos, dúzia' as descricao, 21.50 as valor UNION ALL
    SELECT 'Queijo'as nome, 'Queijo mussarela fatiado, pacote de 200g' as descricao, 24.25 as valor UNION ALL
    SELECT 'Presunto'as nome, 'Presunto cozido fatiado, pacote de 150g' as descricao, 19.99 as valor UNION ALL
    SELECT 'Manteiga'as nome, 'Manteiga com sal, tablete de 200g' as descricao, 37.00 as valor UNION ALL
    SELECT 'Refrigerante'as nome, 'Refrigerante sabor cola, garrafa de 2 litros' as descricao, 41.50 as valor UNION ALL
    SELECT 'Suco'as nome, 'Suco de laranja natural, garrafa de 1 litro' as descricao, 34.99 as valor UNION ALL
    SELECT 'Chocolate'as nome, 'Barra de chocolate ao leite, 100g' as descricao, 28.75 as valor UNION ALL
    SELECT 'Pão'as nome, 'Pão francês, unidade' as descricao, 33.50 as valor UNION ALL
    SELECT 'Geleia'as nome, 'Geleia de morango, pote de 250g' as descricao, 45.99 as valor UNION ALL
    SELECT 'Molho de Tomate'as nome, 'Molho de tomate pronto, embalagem de 350g' as descricao, 50.75 as valor UNION ALL
    SELECT 'Creme de Leite'as nome, 'Creme de leite em lata, 200g' as descricao, 42.00 as valor UNION ALL
    SELECT 'Azeite de Oliva'as nome, 'Azeite de oliva extra virgem, garrafa de 500ml' as descricao, 36.25 as valor UNION ALL
    SELECT 'Vinagre'as nome, 'Vinagre de álcool, frasco de 500ml' as descricao, 39.99 as valor UNION ALL
    SELECT 'Iogurte Grego'as nome, 'Iogurte grego natural, pote de 150g' as descricao, 31.50 as valor UNION ALL
    SELECT 'Cerveja'as nome, 'Cerveja Pilsen, lata de 350ml' as descricao, 47.00 as valor UNION ALL
    SELECT 'Vinho'as nome, 'Vinho tinto seco, garrafa de 750ml' as descricao, 52.50 as valor UNION ALL
    SELECT 'Batata'as nome, 'Batata inglesa, saco com 5kg' as descricao, 44.99 as valor UNION ALL
    SELECT 'Cenoura'as nome, 'Cenoura orgânica, pacote com 500g' as descricao, 48.75 as valor UNION ALL
    SELECT 'Tomate'as nome, 'Tomate italiano, 1kg' as descricao, 40.50 as valor UNION ALL
    SELECT 'Cebola'as nome, 'Cebola branca, saco com 1kg' as descricao, 54.99 as valor UNION ALL
    SELECT 'Alho'as nome, 'Alho descascado, embalagem de 200g' as descricao, 60.75 as valor UNION ALL
    SELECT 'Laranja'as nome, 'Laranja pera, saco com 2kg' as descricao, 49.00 as valor UNION ALL
    SELECT 'Banana'as nome, 'Banana nanica, dúzia' as descricao, 43.25 as valor UNION ALL
    SELECT 'Maçã'as nome, 'Maçã fuji, saco com 1kg' as descricao, 46.99
) AS tmp WHERE NOT EXISTS (SELECT 1 FROM produtos);
