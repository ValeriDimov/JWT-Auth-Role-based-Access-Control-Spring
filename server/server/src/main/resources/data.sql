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
        (15, 'www.winbet.bg'),
        (16, 'www.elitbet.bg');

INSERT INTO sports (id, type)
VALUES  (1, 'Football'),
        (2, 'Tennis');

INSERT INTO championships (id, name, country_or_tournament, sport_id)
VALUES  (1, 'Eliteserien', 'Norway', 1),
        (2, 'Brasileiro Serie A', 'Brazil', 1),
        (3, 'Premier League', 'England', 1),
        (4, 'Parva Liga', 'Bulgaria', 1),
        (5, 'LaLiga', 'Spain', 1),
        (6, 'Serie A', 'Italy', 1),
        (7, 'Bundesliga', 'Germany', 1),
        (8, 'Ligue 1', 'France', 1),
        (9, 'Eredivisie', 'Netherlands', 1),
        (10, 'MSL', 'USA', 1),
        (11, 'Unknown', 'Unknown tournament', 1),
        (12, 'International championship', 'International', 1);

INSERT INTO teams_nomenclature (id, championship_id, team_name_main, team_name_betano, team_name_efbet, team_name_inbet, team_name_winbet)
VALUES  (1, 1, 'Bodo/Glimt', 'Bodoe/Glimt', 'Bodo/Glimt', 'Бoдьо/Глимт', 'Бoдьо/Глимт'),
        (2, 1, 'Brann', 'Brann', 'Brann', 'Бран', 'Бран'),
        (3, 1, 'Viking', 'Viking', 'Viking', 'Викинг', 'Викинг'),
        (4, 1, 'Tromsoe', 'Tromsoe', 'Tromsoe', 'Тромсьо', 'Тромсьо'),
        (5, 1, 'Lillestroem', 'Lillestrom', 'Lillestrom', 'Лилестрьом', 'Лилестрьом'),
        (6, 1, 'Molde', 'Molde', 'Molde', 'Молде', 'Молде'),
        (7, 1, 'Sarpsborg 08', 'Sarpsborg', 'Sarpsborg', 'Сарпсборг', 'Сарпсборг'),
        (8, 1, 'Stabaek', 'Stabaek', 'Stabaek', 'Стабек ИФ', 'Стабек ИФ'),
        (9, 1, 'Rosenborg', 'Rosenborg', 'Rosenborg', 'Розенборг', 'Розенборг'),
        (10, 1, 'Odds Ballklubb', 'Odd', 'Odds Bk', 'Одд БК', 'Одд БК'),
        (11, 1, 'FK Haugesund', 'Haugesund', 'Haugesund', 'Хаугесунд', 'Хаугесунд'),
        (12, 1, 'Stroemsgodset', 'Stroemsgodset', 'Stroemsgodset', 'Стрьомгодсет', 'Стрьомгодсет'),
        (13, 1, 'Vaalerenga', 'Valerenga', 'Valerenga', 'Вoлеренга', 'Вoлеренга'),
        (14, 1, 'Sandefjord', 'Sandefjord', 'Sandefjord', 'Сандефьорд', 'Сандефьорд'),
        (15, 1, 'Hamarkameratene', 'Ham-Kam', 'Ham-Kam', 'Хам-Кам', 'Хам-Кам'),
        (16, 1, 'Aalesund', 'Aalesun', 'Aalesunds', 'Аалесунд', 'Аалесунд'),
        (17, 2, 'America MG', 'America MG', 'America MG', 'Америка МГ', 'Америка МГ'),
        (18, 2, 'Athletico Paranaense', 'Athletico PR', 'Atletico Paranaense PR', 'Атл. Паранаензе', 'Атл. Паранаензе'),
        (19, 2, 'Atletico MG', 'Clube Atletico MG', 'Atletico Mineiro', 'Атлетико Минейро МГ', 'Атлетико Минейро МГ'),
        (20, 2, 'Bahia', 'EC Bahia BA', 'Bahia', 'ЕК Баия БА', 'ЕК Баия БА'),
        (21, 2, 'Botafogo FR', 'Botafogo RJ', 'Botafogo RJ', 'Ботафого РЖ', 'Ботафого РЖ'),
        (22, 2, 'Bragantino', 'Bragantino SP', 'RB Bragantino', 'Ред Бул Брагантино СП', 'Ред Бул Брагантино СП'),
        (23, 2, 'Corinthians', 'Corinthians SP', 'Corinthians', 'Коринтианс СП', 'Коринтианс СП'),
        (24, 2, 'Coritiba', 'Coritiba PR', 'Coritiba', 'Коритиба ПР', 'Коритиба ПР'),
        (25, 2, 'Cruzeiro', 'Cruzeiro MG', 'Cruzeiro', 'Крузейро МГ', 'Крузейро МГ'),
        (26, 2, 'Cuiaba', 'Cuiaba MT', 'Cuiaba', 'Куяба Еспорте Клубе МТ', 'Куяба Еспорте Клубе МТ'),
        (27, 2, 'Flamengo', 'Flamengo RJ', 'Flamengo', 'Фламенго РЖ', 'Фламенго РЖ'),
        (28, 2, 'Fluminense', 'Fluminense RJ', 'Fluminense', 'Флуминензе РЖ', 'Флуминензе РЖ'),
        (29, 2, 'Fortaleza', 'Fortaleza CE', 'Fortaleza', 'Форталеза СЕ', 'Форталеза СЕ'),
        (30, 2, 'Goias', 'Goiás GO', 'Goias', 'Гояс ЕК ГО', 'Гояс ЕК ГО'),
        (31, 2, 'Gremio', 'Gremio RS', 'Gremio', 'Гремио РС', 'Гремио РС'),
        (32, 2, 'Internacional', 'Internacional RS', 'Internacional', 'Интернасионал РС', 'Интернасионал РС'),
        (33, 2, 'Palmeiras', 'Palmeiras SP', 'Palmeiras', 'Палмейрас СП', 'Палмейрас СП'),
        (34, 2, 'Santos FC', 'Santos SP', 'Santos', 'Сантош СП', 'Сантош СП'),
        (35, 2, 'Sao Paulo', 'Sao Paulo SP', 'Sao Paulo', 'Сао Пауло', 'Сао Пауло'),
        (36, 2, 'Vasco da Gama', 'Vasco da Gama RJ', 'Vasco Da Gama', 'Вашку да Гама РЖ', 'Вашку да Гама РЖ'),
        (37, 3, 'AFC Bournemouth', 'AFC Bournemouth', 'Bournemouth', 'Борнемут', 'Борнемут'),
        (38, 3, 'Arsenal', 'Arsenal FC', 'Arsenal', 'Арсенал', 'Арсенал'),
        (39, 3, 'Aston Villa', 'Aston Villa', 'Aston Villa', 'Астън Вила', 'Астън Вила'),
        (40, 3, 'Brentford', 'Brentford FC', 'Brentford', 'Брентфорд', 'Брентфорд'),
        (41, 3, 'Brighton & Hove Albion', 'Brighton & Hove Albion', 'Brighton', 'Брайтън', 'Брайтън'),
        (42, 3, 'Burnley', 'Burnley FC', 'Burnley', 'Бърнли', 'Бърнли'),
        (43, 3, 'Chelsea', 'Chelsea FC', 'Chelsea', 'Челси', 'Челси'),
        (44, 3, 'Crystal Palace', 'Crystal Palace FC', 'Crystal Palace', 'Кристъл Палас', 'Кристъл Палас'),
        (45, 3, 'Everton', 'Everton FC', 'Everton', 'Евертън', 'Евертън'),
        (46, 3, 'Fulham', 'Fulham FC', 'Fulham', 'Фулъм', 'Фулъм'),
        (47, 3, 'Liverpool', 'Liverpool FC', 'Liverpool', 'Ливърпул', 'Ливърпул'),
        (48, 3, 'Luton Town', 'Luton Town', 'Luton Town', 'Лутън Таун', 'Лутън Таун'),
        (49, 3, 'Manchester City', 'Manchester City', 'Manchester City', 'Манчестър Сити', 'Манчестър Сити'),
        (50, 3, 'Manchester United', 'Manchester United', 'Manchester United', 'Манчестър Юнайтед', 'Манчестър Юнайтед'),
        (51, 3, 'Newcastle United', 'Newcastle United', 'Newcastle', 'Нюкасъл', 'Нюкасъл'),
        (52, 3, 'Nottingham Forest', 'Nottingham Forest', 'Nottingham Forest', 'Нотингам Форест', 'Нотингам Форест'),
        (53, 3, 'Sheffield United', 'Sheffield United', 'Sheffield United', 'Шефилд Юнайтед', 'Шефилд Юнайтед'),
        (54, 3, 'Tottenham Hotspur', 'Tottenham Hotspur', 'Tottenham', 'Тотнъм', 'Тотнъм'),
        (55, 3, 'West Ham United', 'West Ham United', 'West Ham', 'Уест Хям', 'Уест Хям'),
        (56, 3, 'Wolverhampton Wanderers', 'Wolverhampton Wanderers', 'Wolverhampton', 'Уулвърхямптън', 'Уулвърхямптън'),
        (57, 4, 'Arda Kardzhali', 'FC Arda Kardzhali', 'Arda', 'Арда Кърджали', 'Арда Кърджали'),
        (58, 4, 'Beroe', 'PFC Beroe Stara Zagora', 'Beroe', 'Берое Стара Загора', 'Берое Стара Загора'),
        (59, 4, 'Botev Plovdiv', 'PFC Botev Plovdiv', 'Botev Plovdiv', 'Ботев Пловдив', 'Ботев Пловдив'),
        (60, 4, 'Botev Vratsa', 'POFC Botev Vratsa', 'Botev Vratsa', 'Ботев Враца', 'Ботев Враца'),
        (61, 4, 'Cherno More Varna', 'PFC Cherno More Varna', 'Cherno More', 'Черно море Варна', 'Черно море Варна'),
        (62, 4, 'CSKA 1948', 'FC CSKA 1948 Sofia', 'Cska 1948', 'ЦСКА 1948 София', 'ЦСКА 1948 София'),
        (63, 4, 'Etar', 'FC Etar Veliko Tarnovo', 'Etar', 'Етър Велико Търново', 'Етър Велико Търново'),
        (64, 4, 'Hebar', 'Hebar Pazardzhik', 'Hebar', 'ПФК Хебър', 'ПФК Хебър'),
        (65, 4, 'Krumovgrad', 'Levski Krumovgrad', 'Fc Krumovgrad', 'ФК Крумовград', 'ФК Крумовград'),
        (66, 4, 'Levski Sofia', 'PFC Levski Sofia', 'Levski Sofia', 'Левски София', 'Левски София'),
        (67, 4, 'Lokomotiv Plovdiv', 'PFC Lokomotiv Plovdiv', 'Lokomotiv Plovdiv', 'Локомотив Пловдив', 'Локомотив Пловдив'),
        (68, 4, 'Ludogorets Razgrad', 'PFC Ludogorets Razgrad', 'Ludogorets', 'Лудогорец Разград', 'Лудогорец Разград'),
        (69, 4, 'PFC CSKA-Sofia', 'PFC CSKA-Sofia', 'Cska-Sofia', 'ЦСКА-София', 'ЦСКА София'),
        (70, 4, 'PFC Lokomotiv Sofia 1929', 'FC Lokomotiv 1929 Sofia', 'Lokomotiv Sofia', 'Локомотив София', 'Локомотив София'),
        (71, 4, 'Pirin Blagoevgrad', 'FC Pirin Blagoevgrad', 'Pirin', 'Пирин Благоевград', 'Пирин Благоевград'),
        (72, 4, 'Slavia Sofia', 'PFC Slavia Sofia', 'Slavia', 'Славия София', 'Славия София'),
        (73, 5, 'Almeria', 'UD Almeria', 'Almeria', 'Алмерия', 'Алмерия'),
        (74, 5, 'Athletic Bilbao', 'Athletic Bilbao', 'Athletic Bilbao', 'Атлетик Билбао', 'Атлетик Билбао'),
        (75, 5, 'Atletico Madrid', 'Atletico Madrid', 'Atletico Madrid', 'Атлетико Мадрид', 'Атлетико Мадрид'),
        (76, 5, 'Barcelona', 'FC Barcelona', 'Barcelona', 'Барселона', 'Барселона'),
        (77, 5, 'Cadiz', 'Cadiz CF', 'Cadiz', 'Кадис', 'Кадис'),
        (78, 5, 'Celta Vigo', 'RC Celta de Vigo', 'Celta Vigo', 'Селта Виго', 'Селта Виго'),
        (79, 5, 'Deportivo Alaves', 'Deportivo Alaves', 'Alaves', 'Алавес', 'Алавес'),
        (80, 5, 'Getafe', 'Getafe CF', 'Getafe', 'Хетафе', 'Хетафе'),
        (81, 5, 'Girona', 'Girona FC', 'Girona', 'Жирона', 'Жирона'),
        (82, 5, 'Granada', 'Granada CF', 'Granada', 'Гранада', 'Гранада'),
        (83, 5, 'Las Palmas', 'UD Las Palmas', 'Las Palmas', 'Лас Палмас', 'Лас Палмас'),
        (84, 5, 'Mallorca', 'RCD Mallorca', 'Mallorca', 'Майорка', 'Майорка'),
        (85, 5, 'Osasuna', 'CA Osasuna', 'Osasuna', 'Осасуна', 'Осасуна'),
        (86, 5, 'Rayo Vallecano', 'Rayo Vallecano', 'Rayo Vallecano', 'Райо Валекано', 'Райо Валекано'),
        (87, 5, 'Real Betis', 'Real Betis Balompie', 'Real Betis', 'Бетис', 'Бетис'),
        (88, 5, 'Real Madrid', 'Real Madrid', 'Real Madrid', 'Реал Мадрид', 'Реал Мадрид'),
        (89, 5, 'Real Sociedad', 'Real Sociedad', 'Real Sociedad', 'Реал Сосиедад', 'Реал Сосиедад'),
        (90, 5, 'Sevilla', 'Sevilla FC', 'Sevilla', 'Севиля', 'Севиля'),
        (91, 5, 'Valencia', 'Valencia CF', 'Valencia', 'Валенсия', 'Валенсия'),
        (92, 5, 'Villarreal', 'Villarreal CF', 'Villarreal', 'Виляреал', 'Виляреал'),
        (93, 6, 'AC Milan', 'AC Milan', 'Milan', 'Милан', 'Милан'),
        (94, 6, 'Atalanta', 'Atalanta', 'Atalanta', 'Аталанта', 'Аталанта'),
        (95, 6, 'Bologna', 'Bologna FC', 'Bologna', 'Болоня', 'Болоня'),
        (96, 6, 'Cagliari', 'Cagliari Calcio', 'Cagliari', 'Каляри', 'Каляри'),
        (97, 6, 'Empoli', 'Empoli FC', 'Empoli', 'Емполи', 'Емполи'),
        (98, 6, 'Fiorentina', 'AC Fiorentina', 'Fiorentina', 'Фиорентина', 'Фиорентина'),
        (99, 6, 'Frosinone', 'Frosinone', 'Frosinone', 'Фрозиноне', 'Фрозиноне'),
        (100, 6, 'Genoa', 'Genoa CFC', 'Genoa', 'Дженоа', 'Дженоа'),
        (101, 6, 'Inter', 'Inter Milan', 'Inter', 'Интер Милано', 'Интер Милано'),
        (102, 6, 'Juventus', 'Juventus FC', 'Juventus', 'Ювентус', 'Ювентус'),
        (103, 6, 'Lazio', 'SS Lazio', 'Lazio', 'Лацио', 'Лацио'),
        (104, 6, 'Lecce', 'US Lecce', 'Lecce', 'Лече', 'Лече'),
        (105, 6, 'Monza', 'AC Monza', 'Ac Monza', 'Монца', 'Монца'),
        (106, 6, 'Napoli', 'SSC Napoli', 'Napoli', 'Наполи', 'Наполи'),
        (107, 6, 'Roma', 'AS Roma', 'Roma', 'Рома', 'Рома'),
        (108, 6, 'Salernitana', 'US Salernitana 1919', 'Salernitana', 'Салернитана', 'Салернитана'),
        (109, 6, 'Sassuolo', 'US Sassuolo Calcio', 'Sassuolo', 'Сасуоло', 'Сасуоло'),
        (110, 6, 'Torino', 'Torino FC', 'Torino', 'Торино', 'Торино'),
        (111, 6, 'Udinese', 'Udinese Calcio', 'Udinese', 'Удинезе', 'Удинезе'),
        (112, 6, 'Verona', 'Hellas Verona', 'Verona', 'Верона', 'Верона'),
        (113, 7, 'Augsburg', 'FC Augsburg', 'Augsburg', 'Аугсбург', 'Аугсбург'),
        (114, 7, 'Bayer Leverkusen', 'Bayer 04 Leverkusen', 'Bayer Leverkusen', 'Байер Леверкузен', 'Байер Леверкузен'),
        (115, 7, 'Bayern Munich', 'FC Bayern Munchen', 'Bayern Munich', 'Байерн Мюнхен', 'Байерн Мюнхен'),
        (116, 7, 'Bochum', 'VfL Bochum', 'Bochum', 'Бохум', 'Бохум'),
        (117, 7, 'Borussia Dortmund', 'Borussia Dortmund', 'Borussia Dortmund', 'Борусия Дортмунд', 'Борусия Дортмунд'),
        (118, 7, 'Borussia Monchengladbach', 'Borussia Monchengladbach', 'Borussia M`gladbach', 'Борусия Мьонхенгладбах', 'Борусия Мьонхенгладбах'),
        (119, 7, 'Darmstadt', 'SV Darmstadt 98', 'Darmstadt', 'Дармщад', 'Дармщад'),
        (120, 7, 'Eintracht Frankfurt', 'Eintracht Frankfurt', 'Eintracht Frankfurt', 'Айнтрахт Франкфурт', 'Айнтрахт Франкфурт'),
        (121, 7, 'FC Cologne', '1. FC Köln', 'Köln', 'Кьолн', 'Кьолн'),
        (122, 7, 'FC Heidenheim', '1. FC Heidenheim', 'Heidenheim', 'Хайденхайм', 'Хайденхайм'),
        (123, 7, 'Freiburg', 'SC Freiburg', 'Freiburg', 'Фрайбург', 'Фрайбург'),
        (124, 7, 'Hoffenheim', 'TSG 1899 Hoffenheim', 'Hoffenheim', 'Хофенхайм', 'Хофенхайм'),
        (125, 7, 'Mainz', 'FSV Mainz 05', 'Mainz 05', 'Майнц 05', 'Майнц 05'),
        (126, 7, 'RB Leipzig', 'RB Leipzig', 'Rb Leipzig', 'РБ Лайпциг', 'РБ Лайпциг'),
        (127, 7, 'Union Berlin', '1. FC Union Berlin', 'Union Berlin', 'Унион Берлин', 'Унион Берлин'),
        (128, 7, 'VfB Stuttgart', 'VfB Stuttgart', 'Stuttgart', 'Щутгарт', 'Щутгарт'),
        (129, 7, 'Werder Bremen', 'Werder Bremen', 'Werder Bremen', 'Вердер Бремен', 'Вердер Бремен'),
        (130, 7, 'Wolfsburg', 'VfL Wolfsburg', 'Wolfsburg', 'Волфсбург', 'Волфсбург'),
        (131, 8, 'Brest', 'Stade Brestois 29', 'Brest', 'Брест', 'Брест'),
        (132, 8, 'Clermont Foot', 'Clermont Foot', 'Clermont Foot', 'Клермон Фуут', 'Клермон Фуут'),
        (133, 8, 'Le Havre', 'Le Havre AC', 'Ac Le Havre', 'Льо Авър', 'Льо Авър'),
        (134, 8, 'Lens', 'RC Lens', 'Lens', 'Ланс', 'Ланс'),
        (135, 8, 'Lille', 'Lille OSC', 'Lille', 'Лил', 'Лил'),
        (136, 8, 'Lorient', 'FC Lorient', 'Lorient', 'Лориен', 'Лориен'),
        (137, 8, 'Lyon', 'Olympique Lyonnais', 'Lyon', 'Лион', 'Лион'),
        (138, 8, 'Marseille', 'Olympique Marseille', 'Olympique Marseille', 'Олимпик Марсилия', 'Олимпик Марсилия'),
        (139, 8, 'Metz', 'FC Metz', 'Metz', 'Мец', 'Метц'),
        (140, 8, 'Monaco', 'AS Monaco', 'Monaco', 'Монако', 'Монако'),
        (141, 8, 'Montpellier', 'Montpellier HSC', 'Montpellier', 'Монпелие', 'Монпелие'),
        (142, 8, 'Nantes', 'FC Nantes', 'Nantes', 'Нант', 'Нант'),
        (143, 8, 'Nice', 'OGC Nice', 'Nice', 'Ница', 'Ница'),
        (144, 8, 'Paris Saint-Germain', 'Paris Saint-Germain', 'Psg', 'ПСЖ', 'ПСЖ'),
        (145, 8, 'Reims', 'Stade Reims', 'Reims', 'Реймс', 'Реймс'),
        (146, 8, 'Rennes', 'Stade Rennais FC', 'Rennes', 'Рен', 'Рен'),
        (147, 8, 'Strasbourg', 'RC Strasbourg', 'Strasbourg', 'Страсбург', 'Страсбург'),
        (148, 8, 'Toulouse', 'Toulouse FC', 'Toulouse', 'Тулуза', 'Тулуза'),
        (149, 9, 'Ajax', 'Ajax', 'Ajax', 'Аякс Амстердам', 'Аякс Амстердам'),
        (150, 9, 'Almere City FC', 'Almere', 'Almere City', 'Алмере Сити', 'Алмере Сити'),
        (151, 9, 'AZ Alkmaar', 'Alkmaar', 'AZ Alkmaar', 'АЗ Алкмаар', 'АЗ Алкмаар'),
        (152, 9, 'Excelsior', 'Excelsior', 'Excelsior', 'СБВ Екселсиор', 'СБВ Екселсиор'),
        (153, 9, 'FC Twente', 'Enschede', 'Twente', 'Твенте', 'Твенте'),
        (154, 9, 'FC Utrecht', 'Utrecht', 'Utrecht', 'Утрехт', 'Утрехт'),
        (155, 9, 'FC Volendam', 'Volendam', 'Volendam', 'Волендам', 'Волендам'),
        (156, 9, 'Feyenoord', 'Feyenoord', 'Feyenoord', 'Фейенорд', 'Фейенорд'),
        (157, 9, 'Fortuna Sittard', 'Sittard', 'Fortuna Sittard', 'Фортуна Ситард', 'Фортуна Ситард'),
        (158, 9, 'Go Ahead Eagles', 'GA Eagles', 'Go Ahead Eagles', 'Го Ахед Ийгълс', 'Го Ахед Ийгълс'),
        (159, 9, 'Heracles', 'Almelo', 'Heracles', 'Хераклес Алмело', 'Хераклес Алмело'),
        (160, 9, 'NEC Nijmegen', 'Nijmegen', 'NEC Nijmegen', 'НЕК Ниймеген', 'НЕК Ниймеген'),
        (161, 9, 'PEC Zwolle', 'Zwolle', 'PEC Zwolle', 'Цволе', 'Цволе'),
        (162, 9, 'PSV Eindhoven', 'Eindhoven', 'PSV Eindhoven', 'ПСВ Айндховен', 'ПСВ Айндховен'),
        (163, 9, 'RKC Waalwijk', 'Waalwijk', 'RKC Waalwijk', 'Ваалвийк', 'Ваалвийк'),
        (164, 9, 'SC Heerenveen', 'Heerenveen', 'Heerenveen', 'Хееренвеен', 'Хееренвеен'),
        (165, 9, 'Sparta Rotterdam', 'Sparta', 'Sparta Rotterdam', 'Спарта Ротердам', 'Спарта Ротердам'),
        (166, 9, 'Vitesse', 'Vitesse', 'Vitesse', 'Витес Арнем', 'Витес Арнем'),
        (167, 10, 'Atlanta United', 'Atlanta United FC', 'Atlanta Utd ', 'Атланта Юнайтед', 'Атланта Юнайтед'),
        (168, 10, 'Austin FC', 'Austin FC', 'Austin Fc', 'Остин ФК', 'Остин ФК'),
        (169, 10, 'CF Montreal', 'CF Montreal', 'Cf Montreal ', 'Монреал Импакт', 'Монреал Импакт'),
        (170, 10, 'Charlotte', 'Charlotte FC', 'Charlotte Fc ', 'Шарлот', 'Шарлот'),
        (171, 10, 'Chicago Fire', 'Chicago Fire FC', 'Chicago Fire', 'Чикаго Файър', 'Чикаго Файър'),
        (172, 10, 'Colorado Rapids', 'Colorado Rapids', 'Colorado Rapids', 'Колорадо Рапидс', 'Колорадо Рапидс'),
        (173, 10, 'Columbus Crew', 'Columbus Crew SC', 'Columbus Crew ', 'Кълъмбъс Крю', 'Кълъмбъс Крю'),
        (174, 10, 'DC United', 'D.C. United', 'Dc United ', 'ДиСи Юнайтед', 'ДиСи Юнайтед'),
        (175, 10, 'FC Cincinnati', 'FC Cincinnati', 'Fc Cincinnati', 'Синсинати', 'Синсинати'),
        (176, 10, 'FC Dallas', 'FC Dallas', 'Fc Dallas', 'Далас', 'Далас'),
        (177, 10, 'Houston Dynamo', 'Houston Dynamo FC', 'Houston Dynamo', 'Хюстън Динамо', 'Хюстън Динамо'),
        (178, 10, 'Inter Miami CF', 'Inter Miami CF', 'Inter Miami ', 'Интер Маями', 'Интер Маями'),
        (179, 10, 'LA Galaxy', 'Los Angeles Galaxy', 'Los Angeles Galaxy', 'Лос Анджелис Галакси', 'Лос Анджелис Галакси'),
        (180, 10, 'Los Angeles FC', 'Los Angeles FC', 'Los Angeles Fc ', 'Лос Анджелис', 'Лос Анджелис'),
        (181, 10, 'Minnesota United', 'Minnesota United FC', 'Minnesota Utd', 'Минесота Юнайтед', 'Минесота Юнайтед'),
        (182, 10, 'Nashville SC', 'Nashville SC', 'Nashville Sc ', 'Нашвил', 'Нашвил'),
        (183, 10, 'New England Revolution', 'New England Revolution', 'New England Revolution ', 'Ню Ингланд Революшън', 'Ню Ингланд Революшън'),
        (184, 10, 'New York City FC', 'New York City FC', 'New York City Fc', 'Ню Йорк Сити ФК', 'Ню Йорк Сити ФК'),
        (185, 10, 'New York Red Bulls', 'New York Red Bulls', 'New York Red Bulls ', 'Ню Йорк Ред Булс', 'Ню Йорк Ред Булс'),
        (186, 10, 'Orlando City', 'Orlando City SC', 'Orlando City ', 'Орландо Сити ФК', 'Орландо Сити ФК'),
        (187, 10, 'Philadelphia Union', 'Philadelphia Union', 'Philadelphia Union ', 'Филаделфия Юниън', 'Филаделфия Юниън'),
        (188, 10, 'Portland Timbers', 'Portland Timbers', 'Portland Timbers', 'Портланд Тимбърс', 'Портланд Тимбърс'),
        (189, 10, 'Real Salt Lake', 'Real Salt Lake', 'Real Salt Lake', 'Реал Солт Лейк', 'Реал Солт Лейк'),
        (190, 10, 'San Jose Earthquakes', 'San Jose Earthquakes', 'San Jose Earthquakes', 'Сан Хосе Ърткуейкс', 'Сан Хосе Ърткуейкс'),
        (191, 10, 'Seattle Sounders FC', 'Seattle Sounders FC', 'Seattle Sounders', 'Сиатъл Саундърс', 'Сиатъл Саундърс'),
        (192, 10, 'Sporting Kansas City', 'Sporting Kansas City', 'Sporting Kansas City', 'Спортинг Канзас Сити', 'Спортинг Канзас Сити'),
        (193, 10, 'St. Louis City', 'St. Louis City SC', 'Saint Louis City Sc ', 'Сейнт Луис Сити СК', 'Сейнт Луис Сити СК'),
        (194, 10, 'Toronto FC', 'Toronto FC', 'Toronto Fc ', 'Торонто', 'Торонто'),
        (195, 10, 'Vancouver Whitecaps', 'Vancouver Whitecaps FC', 'Vancouver Whitecaps', 'Ванкувър Уайткапс ФК', 'Ванкувър Уайткапс ФК');