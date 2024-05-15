IF NOT EXISTS (SELECT * FROM sys.tables WHERE name='produtos')
BEGIN
    CREATE TABLE produtos (
        id INT IDENTITY(1,1) PRIMARY KEY,
        idUsuario INT,
        nome VARCHAR(255),
        descricao VARCHAR(255),
        valor DECIMAL(10, 2)
    );
END
GO

IF NOT EXISTS (SELECT 1 FROM produtos)
BEGIN
    INSERT INTO produtos (nome, descricao, valor)
    VALUES
        ('Arroz', 'Arroz branco, tipo longo, pacote de 5kg', 10.50),
        ('Feijão', 'Feijão preto, tipo carioca, pacote de 1kg', 15.75),
        ('Macarrão', 'Espaguete nº 7, pacote de 500g', 20.25),
        ('Óleo de Soja', 'Óleo de soja refinado, garrafa de 900ml', 8.99),
        ('Açúcar', 'Açúcar refinado, pacote de 1kg', 12.00),
        ('Café', 'Café torrado e moído, embalagem a vácuo, 500g', 18.50),
        ('Leite', 'Leite integral pasteurizado, caixa de 1 litro', 25.99),
        ('Farinha de Trigo', 'Farinha de trigo tipo 1, pacote de 1kg', 30.75),
        ('Sal', 'Sal refinado iodado, pacote de 1kg', 22.00),
        ('Biscoitos', 'Biscoitos recheados sabor chocolate, pacote de 200g', 16.25),
        ('Sabonete', 'Sabonete em barra, fragrância de lavanda, unidade', 19.99),
        ('Detergente', 'Detergente líquido para louças, embalagem de 500ml', 11.50),
        ('Shampoo', 'Shampoo para todos os tipos de cabelo, frasco de 350ml', 14.25),
        ('Condicionador', 'Condicionador hidratante, frasco de 300ml', 9.99),
        ('Creme Dental', 'Creme dental com flúor, embalagem de 90g', 27.00),
        ('Papel Higiênico', 'Rolo de papel higiênico folha dupla, pacote com 4 rolos', 31.50),
        ('Sabão em Pó', 'Sabão em pó para máquina de lavar roupa, pacote de 1kg', 24.99),
        ('Amaciante', 'Amaciante concentrado, fragrância suave, garrafa de 2 litros', 18.75),
        ('Desinfetante', 'Desinfetante líquido, aroma de pinho, frasco de 500ml', 23.50),
        ('Água Sanitária', 'Água sanitária concentrada, embalagem de 1 litro', 35.99),
        ('Desodorante', 'Desodorante roll-on, fragrância neutra, embalagem de 50ml', 40.75),
        ('Cereal Matinal', 'Cereal matinal sabor chocolate, pacote de 300g', 32.00),
        ('Iogurte', 'Iogurte natural, garrafa de 500g', 26.25),
        ('Margarina', 'Margarina cremosa, embalagem de 250g', 29.99),
        ('Ovos', 'Ovos brancos, dúzia', 21.50),
        ('Queijo', 'Queijo mussarela fatiado, pacote de 200g', 24.25),
        ('Presunto', 'Presunto cozido fatiado, pacote de 150g', 19.99),
        ('Manteiga', 'Manteiga com sal, tablete de 200g', 37.00),
        ('Refrigerante', 'Refrigerante sabor cola, garrafa de 2 litros', 41.50),
        ('Suco', 'Suco de laranja natural, garrafa de 1 litro', 34.99),
        ('Chocolate', 'Barra de chocolate ao leite, 100g', 28.75),
        ('Pão', 'Pão francês, unidade', 33.50),
        ('Geleia', 'Geleia de morango, pote de 250g', 45.99),
        ('Molho de Tomate', 'Molho de tomate pronto, embalagem de 350g', 50.75),
        ('Creme de Leite', 'Creme de leite em lata, 200g', 42.00),
        ('Azeite de Oliva', 'Azeite de oliva extra virgem, garrafa de 500ml', 36.25),
        ('Vinagre', 'Vinagre de álcool, frasco de 500ml', 39.99),
        ('Iogurte Grego', 'Iogurte grego natural, pote de 150g', 31.50),
        ('Cerveja', 'Cerveja Pilsen, lata de 350ml', 47.00),
        ('Vinho', 'Vinho tinto seco, garrafa de 750ml', 52.50),
        ('Batata', 'Batata inglesa, saco com 5kg', 44.99),
        ('Cenoura', 'Cenoura orgânica, pacote com 500g', 48.75),
        ('Tomate', 'Tomate italiano, 1kg', 40.50),
        ('Cebola', 'Cebola branca, saco com 1kg', 54.99),
        ('Alho', 'Alho descascado, embalagem de 200g', 60.75),
        ('Laranja', 'Laranja pera, saco com 2kg', 49.00),
        ('Banana', 'Banana nanica, dúzia', 43.25),
        ('Maçã', 'Maçã fuji, saco com 1kg', 46.99);
END
GO
