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
        (2, 'Brasileiro Serie A', 'Brazil', 1),
        (3, 'Premier League', 'England', 1),
        (4, 'Parva Liga', 'Bulgaria', 1);

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
        (36, 2, 'Vasco da Gama', 'Vasco da Gama RJ', 'Vasco Da Gama'),
        (37, 3, 'AFC Bournemouth', 'AFC Bournemouth', 'Bournemouth'),
        (38, 3, 'Arsenal', 'Arsenal FC', 'Arsenal'),
        (39, 3, 'Aston Villa', 'Aston Villa', 'Aston Villa'),
        (40, 3, 'Brentford', 'Brentford FC', 'Brentford'),
        (41, 3, 'Brighton & Hove Albion', 'Brighton & Hove Albion', 'Brighton'),
        (42, 3, 'Burnley', 'Burnley FC', 'Burnley'),
        (43, 3, 'Chelsea', 'Chelsea FC', 'Chelsea'),
        (44, 3, 'Crystal Palace', 'Crystal Palace FC', 'Crystal Palace'),
        (45, 3, 'Everton', 'Everton FC', 'Everton'),
        (46, 3, 'Fulham', 'Fulham FC', 'Fulham'),
        (47, 3, 'Liverpool', 'Liverpool FC', 'Liverpool'),
        (48, 3, 'Luton Town', 'Luton Town', 'Luton Town'),
        (49, 3, 'Manchester City', 'Manchester City', 'Manchester City'),
        (50, 3, 'Manchester United', 'Manchester United', 'Manchester United'),
        (51, 3, 'Newcastle United', 'Newcastle United', 'Newcastle'),
        (52, 3, 'Nottingham Forest', 'Nottingham Forest', 'Nottingham Forest'),
        (53, 3, 'Sheffield United', 'Sheffield United', 'Sheffield United'),
        (54, 3, 'Tottenham Hotspur', 'Tottenham Hotspur', 'Tottenham'),
        (55, 3, 'West Ham United', 'West Ham United', 'West Ham'),
        (56, 3, 'Wolverhampton Wanderers', 'Wolverhampton Wanderers', 'Wolverhampton'),
        (57, 4, 'Arda Kardzhali', 'FC Arda Kardzhali', 'Arda'),
        (58, 4, 'Beroe', 'PFC Beroe Stara Zagora', 'Beroe'),
        (59, 4, 'Botev Plovdiv', 'PFC Botev Plovdiv', 'Botev Plovdiv'),
        (60, 4, 'Botev Vratsa', 'POFC Botev Vratsa', 'Botev Vratsa'),
        (61, 4, 'Cherno More Varna', 'PFC Cherno More Varna', 'Cherno More'),
        (62, 4, 'CSKA 1948', 'FC CSKA 1948 Sofia', 'CSKA 1948'),
        (63, 4, 'Etar', 'FC Etar Veliko Tarnovo', 'Etar'),
        (64, 4, 'Hebar', 'Hebar Pazardzhik', 'Hebar'),
        (65, 4, 'Krumovgrad', 'Levski Krumovgrad', 'FC Krumovgrad'),
        (66, 4, 'Levski Sofia', 'PFC Levski Sofia', 'Levski Sofia'),
        (67, 4, 'Lokomotiv Plovdiv', 'PFC Lokomotiv Plovdiv', 'Lokomotiv Plovdiv'),
        (68, 4, 'Ludogorets Razgrad', 'PFC Ludogorets Razgrad', 'Ludogorets'),
        (69, 4, 'PFC CSKA-Sofia', 'PFC CSKA-Sofia', 'CSKA-Sofia'),
        (70, 4, 'PFC Lokomotiv Sofia 1929', 'FC Lokomotiv 1929 Sofia', 'Lokomotiv Sofia'),
        (71, 4, 'Pirin Blagoevgrad', 'FC Pirin Blagoevgrad', 'Pirin'),
        (72, 4, 'Slavia Sofia', 'PFC Slavia Sofia', 'Slavia Sofia');










