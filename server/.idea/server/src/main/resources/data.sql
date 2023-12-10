-- INSERT INTO user_roles (id, user_role)
-- values (1, 'ADMIN'),
--        (2, 'USER');

INSERT INTO bookmakers (id, name)
VALUES  (1, 'www.betano.bg'),
        (2, 'www.efbet.com'),
        (3, 'www.8888.bg'),
        (4, 'www.alphawin.bg'),
        (5, 'www.bet.bg'),
        (6, 'www.bet365.com'),
        (7, 'www.betmarket.bg'),
        (8, 'www.betway.bg'),
        (9, 'www.bwin.com'),
        (10, 'www.inbet.com'),
        (11, 'www.palmsbet.com'),
        (12, 'www.sesame.bg'),
        (13, 'www.sportingwin.com'),
        (14, 'www.toto.bg'),
        (15, 'www.winbet.bg');

INSERT INTO sports (id, type)
VALUES  (1, 'Football'),
        (2, 'Tennis');

INSERT INTO championships (id, name, country_or_tournament, sport_id)
VALUES  (1, 'Eliteserien', 'Norway', 1),
        (2, 'Brasileiro Serie A', 'Brazil', 1);

INSERT INTO teams_nomenclature (id, championship_id, team_name_main, team_name_betano, team_name_efbet)
VALUES  (1, 1, 'Bodo/Glimt', 'Bodoe/Glimt', 'Bodo/Glimt'),
        (2, 1, 'Brann', 'Brann', 'Brann'),
        (3, 1, 'Viking', 'Viking', 'Viking'),
        (4, 1, 'Tromsoe', 'Tromsoe', 'Tromsoe'),
        (5, 1, 'Lillestroem', 'Lillestrom', 'Lillestrom'),
        (6, 1, 'Molde', 'Molde', 'Molde'),
        (7, 1, 'Sarpsborg 08', 'Sarpsborg', 'Sarpsborg'),
        (8, 1, 'Stabaek', 'Stabaek', 'Stabaek'),
        (9, 1, 'Rosenborg', 'Rosenborg', 'Rosenborg'),
        (10, 1, 'Odds Ballklubb', 'Odd', 'Odds Bk'),
        (11, 1, 'FK Haugesund', 'Haugesund', 'Haugesund'),
        (12, 1, 'Stroemsgodset', 'Stroemsgodset', 'Stroemsgodset'),
        (13, 1, 'Vaalerenga', 'Valerenga', 'Valerenga'),
        (14, 1, 'Sandefjord', 'Sandefjord', 'Sandefjord'),
        (15, 1, 'Hamarkameratene', 'Ham-Kam', 'Ham-Kam'),
        (16, 1, 'Aalesund', 'Aalesun', 'Aalesunds'),
        (17, 2, 'America MG', 'America MG', 'America MG'),
        (18, 2, 'Athletico Paranaense', 'Athletico PR', 'Atletico Paranaense PR'),
        (19, 2, 'Atletico MG', 'Clube Atletico MG', 'Atletico Mineiro'),
        (20, 2, 'Bahia', 'EC Bahia BA', 'Bahia'),
        (21, 2, 'Botafogo FR', 'Botafogo RJ', 'Botafogo RJ'),
        (22, 2, 'Bragantino', 'Bragantino SP', 'RB Bragantino'),
        (23, 2, 'Corinthians', 'Corinthians SP', 'Corinthians'),
        (24, 2, 'Coritiba', 'Coritiba PR', 'Coritiba'),
        (25, 2, 'Cruzeiro', 'Cruzeiro MG', 'Cruzeiro'),
        (26, 2, 'Cuiaba', 'Cuiaba MT', 'Cuiaba'),
        (27, 2, 'Flamengo', 'Flamengo RJ', 'Flamengo'),
        (28, 2, 'Fluminense', 'Fluminense RJ', 'Fluminense'),
        (29, 2, 'Fortaleza', 'Fortaleza CE', 'Fortaleza'),
        (30, 2, 'Goias', 'Goiás GO', 'Goias'),
        (31, 2, 'Gremio', 'Gremio RS', 'Gremio'),
        (32, 2, 'Internacional', 'Internacional RS', 'Internacional'),
        (33, 2, 'Palmeiras', 'Palmeiras SP', 'Palmeiras'),
        (34, 2, 'Santos FC', 'Santos SP', 'Santos'),
        (35, 2, 'Sao Paulo', 'Sao Paulo SP', 'Sao Paulo'),
        (36, 2, 'Vasco da Gama', 'Vasco da Gama RJ', 'Vasco Da Gama');










